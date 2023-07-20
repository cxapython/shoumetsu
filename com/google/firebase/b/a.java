package com.google.firebase.b;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class a<T> {
    private final Class<T> a;
    private final T b;

    @KeepForSdk
    public Class<T> a() {
        return this.a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.a, this.b);
    }
}
