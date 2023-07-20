package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
public final class zai<O extends Api.ApiOptions> {
    private final boolean a;
    private final int b;
    private final Api<O> c;
    private final O d;

    private zai(Api<O> api) {
        this.a = true;
        this.c = api;
        this.d = null;
        this.b = System.identityHashCode(this);
    }

    private zai(Api<O> api, O o) {
        this.a = false;
        this.c = api;
        this.d = o;
        this.b = Objects.hashCode(this.c, this.d);
    }

    public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> api) {
        return new zai<>(api);
    }

    public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> api, O o) {
        return new zai<>(api, o);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zai)) {
            return false;
        }
        zai zaiVar = (zai) obj;
        return !this.a && !zaiVar.a && Objects.equal(this.c, zaiVar.c) && Objects.equal(this.d, zaiVar.d);
    }

    public final int hashCode() {
        return this.b;
    }

    public final String zan() {
        return this.c.getName();
    }
}
