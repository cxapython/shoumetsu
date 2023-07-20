package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder<L> a;
    private final Feature[] b;
    private final boolean c;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public RegisterListenerMethod(ListenerHolder<L> listenerHolder) {
        this.a = listenerHolder;
        this.b = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z) {
        this.a = listenerHolder;
        this.b = featureArr;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public abstract void a(A a, TaskCompletionSource<Void> taskCompletionSource);

    @KeepForSdk
    public void clearListener() {
        this.a.clear();
    }

    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.a.getListenerKey();
    }

    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return this.b;
    }

    public final boolean shouldAutoResolveMissingFeatures() {
        return this.c;
    }
}
