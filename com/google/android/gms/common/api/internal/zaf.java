package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zaf extends av<Void> {
    private final RegisterListenerMethod<Api.AnyClient, ?> b;
    private final UnregisterListenerMethod<Api.AnyClient, ?> c;

    public zaf(zabw zabwVar, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.b = zabwVar.zajx;
        this.c = zabwVar.zajy;
    }

    @Override // com.google.android.gms.common.api.internal.av, com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void zaa(Status status) {
        super.zaa(status);
    }

    @Override // com.google.android.gms.common.api.internal.av, com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void zaa(zaab zaabVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.av, com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void zaa(RuntimeException runtimeException) {
        super.zaa(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(GoogleApiManager.zaa<?> zaaVar) {
        return this.b.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zac(GoogleApiManager.zaa<?> zaaVar) {
        return this.b.shouldAutoResolveMissingFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.av
    public final void zad(GoogleApiManager.zaa<?> zaaVar) {
        this.b.a(zaaVar.zaab(), this.a);
        if (this.b.getListenerKey() != null) {
            zaaVar.zabk().put(this.b.getListenerKey(), new zabw(this.b, this.c));
        }
    }
}
