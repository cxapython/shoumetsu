package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHeaders;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;

@Deprecated
/* loaded from: classes.dex */
public class DecompressingHttpClient implements HttpClient {
    private final HttpRequestInterceptor acceptEncodingInterceptor;
    private final HttpClient backend;
    private final HttpResponseInterceptor contentEncodingInterceptor;

    public DecompressingHttpClient() {
        this(new DefaultHttpClient());
    }

    public DecompressingHttpClient(HttpClient httpClient) {
        this(httpClient, new RequestAcceptEncoding(), new ResponseContentEncoding());
    }

    DecompressingHttpClient(HttpClient httpClient, HttpRequestInterceptor httpRequestInterceptor, HttpResponseInterceptor httpResponseInterceptor) {
        this.backend = httpClient;
        this.acceptEncodingInterceptor = httpRequestInterceptor;
        this.contentEncodingInterceptor = httpResponseInterceptor;
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    /* renamed from: execute */
    public HttpResponse mo36execute(HttpHost httpHost, HttpRequest httpRequest) {
        return mo37execute(httpHost, httpRequest, (HttpContext) null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    /* renamed from: execute */
    public HttpResponse mo37execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        if (httpContext == null) {
            try {
                httpContext = new BasicHttpContext();
            } catch (HttpException e) {
                throw new ClientProtocolException(e);
            }
        }
        HttpRequest entityEnclosingRequestWrapper = httpRequest instanceof HttpEntityEnclosingRequest ? new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest) : new RequestWrapper(httpRequest);
        this.acceptEncodingInterceptor.process(entityEnclosingRequestWrapper, httpContext);
        HttpResponse mo37execute = this.backend.mo37execute(httpHost, entityEnclosingRequestWrapper, httpContext);
        try {
            try {
                this.contentEncodingInterceptor.process(mo37execute, httpContext);
                if (Boolean.TRUE.equals(httpContext.getAttribute(ResponseContentEncoding.UNCOMPRESSED))) {
                    mo37execute.removeHeaders("Content-Length");
                    mo37execute.removeHeaders("Content-Encoding");
                    mo37execute.removeHeaders(HttpHeaders.CONTENT_MD5);
                }
                return mo37execute;
            } catch (IOException e2) {
                EntityUtils.consume(mo37execute.getEntity());
                throw e2;
            } catch (RuntimeException e3) {
                EntityUtils.consume(mo37execute.getEntity());
                throw e3;
            }
        } catch (HttpException e4) {
            EntityUtils.consume(mo37execute.getEntity());
            throw e4;
        }
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    /* renamed from: execute */
    public HttpResponse mo38execute(HttpUriRequest httpUriRequest) {
        return mo37execute(getHttpHost(httpUriRequest), httpUriRequest, (HttpContext) null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    /* renamed from: execute */
    public HttpResponse mo39execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        return mo37execute(getHttpHost(httpUriRequest), httpUriRequest, httpContext);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(httpHost, httpRequest, responseHandler, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        HttpResponse mo37execute = mo37execute(httpHost, httpRequest, httpContext);
        try {
            return responseHandler.mo35handleResponse(mo37execute);
        } finally {
            HttpEntity entity = mo37execute.getEntity();
            if (entity != null) {
                EntityUtils.consume(entity);
            }
        }
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) execute(getHttpHost(httpUriRequest), httpUriRequest, responseHandler);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) execute(getHttpHost(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    public HttpClient getHttpClient() {
        return this.backend;
    }

    HttpHost getHttpHost(HttpUriRequest httpUriRequest) {
        return URIUtils.extractHost(httpUriRequest.getURI());
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpParams getParams() {
        return this.backend.getParams();
    }
}
