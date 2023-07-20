package com.c.a.a;

import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import java.net.URI;

/* loaded from: classes.dex */
public final class f extends HttpEntityEnclosingRequestBase {
    public f() {
    }

    public f(String str) {
        setURI(URI.create(str));
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return "GET";
    }
}
