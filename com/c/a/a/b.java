package com.c.a.a;

import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.impl.client.AbstractHttpClient;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b implements Runnable {
    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final n d;
    private final AtomicBoolean e = new AtomicBoolean();
    private int f;
    private boolean g;
    private volatile boolean h;
    private boolean i;

    public b(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, n nVar) {
        this.a = (AbstractHttpClient) p.a(abstractHttpClient, "client");
        this.b = (HttpContext) p.a(httpContext, "context");
        this.c = (HttpUriRequest) p.a(httpUriRequest, "request");
        this.d = (n) p.a(nVar, "responseHandler");
    }

    private void c() {
        if (a()) {
            return;
        }
        if (this.c.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
        }
        n nVar = this.d;
        if (nVar instanceof k) {
            ((k) nVar).a(this.c);
        }
        CloseableHttpResponse execute = this.a.mo39execute(this.c, this.b);
        if (a()) {
            return;
        }
        n nVar2 = this.d;
        nVar2.a(nVar2, execute);
        if (a()) {
            return;
        }
        this.d.a(execute);
        if (a()) {
            return;
        }
        n nVar3 = this.d;
        nVar3.b(nVar3, execute);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x000a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        HttpRequestRetryHandler httpRequestRetryHandler = this.a.getHttpRequestRetryHandler();
        IOException iOException = null;
        boolean z = true;
        while (z) {
            try {
                try {
                    try {
                        c();
                        return;
                    } catch (NullPointerException e) {
                        iOException = new IOException("NPE in HttpClient: " + e.getMessage());
                        int i = this.f + 1;
                        this.f = i;
                        z = httpRequestRetryHandler.retryRequest(iOException, i, this.b);
                        if (!z) {
                        }
                    }
                } catch (UnknownHostException e2) {
                    iOException = new IOException("UnknownHostException exception: " + e2.getMessage());
                    if (this.f > 0) {
                        int i2 = this.f + 1;
                        this.f = i2;
                        if (httpRequestRetryHandler.retryRequest(e2, i2, this.b)) {
                            z = true;
                            if (!z) {
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            } catch (IOException e3) {
                try {
                    if (a()) {
                        return;
                    }
                    int i3 = this.f + 1;
                    this.f = i3;
                    boolean retryRequest = httpRequestRetryHandler.retryRequest(e3, i3, this.b);
                    iOException = e3;
                    z = retryRequest;
                    if (!z) {
                        this.d.b(this.f);
                    }
                } catch (Exception e4) {
                    a.a.b("AsyncHttpRequest", "Unhandled exception origin cause", e4);
                    throw new IOException("Unhandled exception: " + e4.getMessage());
                }
            }
        }
    }

    private synchronized void e() {
        if (!this.h && this.e.get() && !this.g) {
            this.g = true;
            this.d.i();
        }
    }

    public void a(b bVar) {
    }

    public boolean a() {
        boolean z = this.e.get();
        if (z) {
            e();
        }
        return z;
    }

    public boolean a(boolean z) {
        this.e.set(true);
        this.c.abort();
        return a();
    }

    public void b(b bVar) {
    }

    public boolean b() {
        return a() || this.h;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            return;
        }
        if (!this.i) {
            this.i = true;
            a(this);
        }
        if (a()) {
            return;
        }
        this.d.g();
        if (a()) {
            return;
        }
        try {
            d();
        } catch (IOException e) {
            if (!a()) {
                this.d.b(0, null, null, e);
            } else {
                a.a.b("AsyncHttpRequest", "makeRequestWithRetries returned error", e);
            }
        }
        if (a()) {
            return;
        }
        this.d.h();
        if (a()) {
            return;
        }
        b(this);
        this.h = true;
    }
}
