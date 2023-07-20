package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public class Response<T extends Result> {
    private T a;

    public Response() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Response(T t) {
        this.a = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T a() {
        return this.a;
    }

    public void setResult(T t) {
        this.a = t;
    }
}
