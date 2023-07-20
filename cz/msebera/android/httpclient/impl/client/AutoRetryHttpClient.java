package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;

@ThreadSafe
@Deprecated
/* loaded from: classes.dex */
public class AutoRetryHttpClient implements HttpClient {
    private final HttpClient backend;
    public HttpClientAndroidLog log;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public AutoRetryHttpClient() {
        this(new DefaultHttpClient(), new DefaultServiceUnavailableRetryStrategy());
    }

    public AutoRetryHttpClient(HttpClient httpClient) {
        this(httpClient, new DefaultServiceUnavailableRetryStrategy());
    }

    public AutoRetryHttpClient(HttpClient httpClient, ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(httpClient, "HttpClient");
        Args.notNull(serviceUnavailableRetryStrategy, "ServiceUnavailableRetryStrategy");
        this.backend = httpClient;
        this.retryStrategy = serviceUnavailableRetryStrategy;
    }

    public AutoRetryHttpClient(ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this(new DefaultHttpClient(), serviceUnavailableRetryStrategy);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    /* renamed from: execute */
    public HttpResponse mo36execute(HttpHost httpHost, HttpRequest httpRequest) {
        return mo37execute(httpHost, httpRequest, (HttpContext) null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    /* renamed from: execute */
    public HttpResponse mo37execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        int i = 1;
        while (true) {
            HttpResponse mo37execute = this.backend.mo37execute(httpHost, httpRequest, httpContext);
            try {
                if (!this.retryStrategy.retryRequest(mo37execute, i, httpContext)) {
                    return mo37execute;
                }
                EntityUtils.consume(mo37execute.getEntity());
                long retryInterval = this.retryStrategy.getRetryInterval();
                try {
                    HttpClientAndroidLog httpClientAndroidLog = this.log;
                    httpClientAndroidLog.trace("Wait for " + retryInterval);
                    Thread.sleep(retryInterval);
                    i++;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            } catch (RuntimeException e) {
                try {
                    EntityUtils.consume(mo37execute.getEntity());
                } catch (IOException e2) {
                    this.log.warn("I/O error consuming response content", e2);
                }
                throw e;
            }
        }
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    /* renamed from: execute */
    public HttpResponse mo38execute(HttpUriRequest httpUriRequest) {
        return mo39execute(httpUriRequest, (HttpContext) null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    /* renamed from: execute */
    public HttpResponse mo39execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        URI uri = httpUriRequest.getURI();
        return mo37execute(new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), httpUriRequest, httpContext);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(httpHost, httpRequest, responseHandler, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return responseHandler.mo35handleResponse(mo37execute(httpHost, httpRequest, httpContext));
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(httpUriRequest, responseHandler, (HttpContext) null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return responseHandler.mo35handleResponse(mo39execute(httpUriRequest, httpContext));
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpParams getParams() {
        return this.backend.getParams();
    }
}
