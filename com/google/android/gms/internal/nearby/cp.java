package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes.dex */
public final class cp extends zzdk {
    private final ListenerHolder<ConnectionLifecycleCallback> a;
    private final Set<String> b = new androidx.b.b();
    private final Set<String> c = new androidx.b.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(ListenerHolder<ConnectionLifecycleCallback> listenerHolder) {
        this.a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a() {
        for (String str : this.b) {
            this.a.notifyListener(new e(this, str));
        }
        this.b.clear();
        for (String str2 : this.c) {
            this.a.notifyListener(new f(this, str2));
        }
        this.c.clear();
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzef zzefVar) {
        this.a.notifyListener(new d(this, zzefVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final synchronized void zza(zzeh zzehVar) {
        this.b.add(zzehVar.zzg());
        this.a.notifyListener(new a(this, zzehVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final synchronized void zza(zzen zzenVar) {
        Status b;
        this.b.remove(zzenVar.zzg());
        b = zzx.b(zzenVar.getStatusCode());
        if (b.isSuccess()) {
            this.c.add(zzenVar.zzg());
        }
        this.a.notifyListener(new b(this, zzenVar, b));
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final synchronized void zza(zzep zzepVar) {
        this.c.remove(zzepVar.zzg());
        this.a.notifyListener(new c(this, zzepVar));
    }
}
