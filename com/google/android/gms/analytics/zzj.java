package com.google.android.gms.analytics;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class zzj<T extends zzj> {
    protected final zzg a;
    private final zzk b;
    private final List<zzh> c;

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public zzj(zzk zzkVar, Clock clock) {
        Preconditions.checkNotNull(zzkVar);
        this.b = zzkVar;
        this.c = new ArrayList();
        zzg zzgVar = new zzg(this, clock);
        zzgVar.d();
        this.a = zzgVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzg zzgVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzk b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(zzg zzgVar) {
        for (zzh zzhVar : this.c) {
            zzhVar.zza(this, zzgVar);
        }
    }

    public zzg zzac() {
        zzg zzai = this.a.zzai();
        b(zzai);
        return zzai;
    }
}
