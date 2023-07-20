package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class d {
    private final zai<?> a;
    private final TaskCompletionSource<Boolean> b = new TaskCompletionSource<>();

    public d(zai<?> zaiVar) {
        this.a = zaiVar;
    }

    public final zai<?> a() {
        return this.a;
    }

    public final TaskCompletionSource<Boolean> b() {
        return this.b;
    }
}
