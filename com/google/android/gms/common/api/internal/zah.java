package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zah extends av<Boolean> {
    private final ListenerHolder.ListenerKey<?> b;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.b = listenerKey;
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
        zabw zabwVar = zaaVar.zabk().get(this.b);
        if (zabwVar == null) {
            return null;
        }
        return zabwVar.zajx.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zac(GoogleApiManager.zaa<?> zaaVar) {
        zabw zabwVar = zaaVar.zabk().get(this.b);
        return zabwVar != null && zabwVar.zajx.shouldAutoResolveMissingFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.av
    public final void zad(GoogleApiManager.zaa<?> zaaVar) {
        zabw remove = zaaVar.zabk().remove(this.b);
        if (remove == null) {
            this.a.trySetResult(false);
            return;
        }
        remove.zajy.a(zaaVar.zaab(), this.a);
        remove.zajx.clearListener();
    }
}
