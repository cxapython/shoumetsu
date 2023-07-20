package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* loaded from: classes.dex */
public interface HttpClient {
    /* renamed from: execute */
    HttpResponse mo36execute(HttpHost httpHost, HttpRequest httpRequest);

    /* renamed from: execute */
    HttpResponse mo37execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext);

    /* renamed from: execute */
    HttpResponse mo38execute(HttpUriRequest httpUriRequest);

    /* renamed from: execute */
    HttpResponse mo39execute(HttpUriRequest httpUriRequest, HttpContext httpContext);

    <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler);

    <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext);

    <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler);

    <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext);

    @Deprecated
    ClientConnectionManager getConnectionManager();

    @Deprecated
    HttpParams getParams();
}
