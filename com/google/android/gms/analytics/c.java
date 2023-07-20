package com.google.android.gms.analytics;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {
    private final /* synthetic */ zzg a;
    private final /* synthetic */ zzk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzk zzkVar, zzg zzgVar) {
        this.b = zzkVar;
        this.a = zzgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<zzn> list;
        this.a.b().a(this.a);
        list = this.b.c;
        for (zzn zznVar : list) {
            zznVar.zza(this.a);
        }
        zzk zzkVar = this.b;
        zzk.b(this.a);
    }
}
