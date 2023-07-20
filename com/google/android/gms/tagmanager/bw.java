package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes.dex */
public final class bw implements zzfw {
    private final /* synthetic */ bv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar) {
        this.a = bvVar;
    }

    @Override // com.google.android.gms.tagmanager.zzfw
    public final void zza(am amVar) {
        this.a.a(amVar.a());
    }

    @Override // com.google.android.gms.tagmanager.zzfw
    public final void zzb(am amVar) {
        this.a.a(amVar.a());
        long a = amVar.a();
        StringBuilder sb = new StringBuilder(57);
        sb.append("Permanent failure dispatching hitId: ");
        sb.append(a);
        zzdi.zzab(sb.toString());
    }

    @Override // com.google.android.gms.tagmanager.zzfw
    public final void zzc(am amVar) {
        Clock clock;
        Clock clock2;
        long b = amVar.b();
        if (b == 0) {
            bv bvVar = this.a;
            long a = amVar.a();
            clock2 = this.a.h;
            bvVar.a(a, clock2.currentTimeMillis());
            return;
        }
        clock = this.a.h;
        if (b + 14400000 >= clock.currentTimeMillis()) {
            return;
        }
        this.a.a(amVar.a());
        long a2 = amVar.a();
        StringBuilder sb = new StringBuilder(47);
        sb.append("Giving up on failed hitId: ");
        sb.append(a2);
        zzdi.zzab(sb.toString());
    }
}
