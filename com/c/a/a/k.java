package com.c.a.a;

import cz.msebera.android.httpclient.client.methods.HttpUriRequest;

/* loaded from: classes.dex */
public abstract class k extends e {
    private long e;
    private boolean f;

    public void a(HttpUriRequest httpUriRequest) {
        if (this.a.exists() && this.a.canWrite()) {
            this.e = this.a.length();
        }
        if (this.e > 0) {
            this.f = true;
            httpUriRequest.setHeader("Range", "bytes=" + this.e + "-");
        }
    }
}
