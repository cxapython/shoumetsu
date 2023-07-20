package com.c.a.a;

import android.os.SystemClock;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;

/* loaded from: classes.dex */
class o implements HttpRequestRetryHandler {
    private static final HashSet<Class<?>> a = new HashSet<>();
    private static final HashSet<Class<?>> b = new HashSet<>();
    private final int c;
    private final int d;

    static {
        a.add(NoHttpResponseException.class);
        a.add(UnknownHostException.class);
        a.add(SocketException.class);
        b.add(InterruptedIOException.class);
        b.add(SSLException.class);
    }

    public o(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Class<?> cls) {
        a.add(cls);
    }

    protected boolean a(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }

    @Override // cz.msebera.android.httpclient.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        boolean z = true;
        if (bool == null || !bool.booleanValue()) {
        }
        if (i > this.c || (!a(a, iOException) && a(b, iOException))) {
            z = false;
        }
        if (!z || ((HttpUriRequest) httpContext.getAttribute("http.request")) != null) {
            if (z) {
                SystemClock.sleep(this.d);
            } else {
                iOException.printStackTrace();
            }
            return z;
        }
        return false;
    }
}
