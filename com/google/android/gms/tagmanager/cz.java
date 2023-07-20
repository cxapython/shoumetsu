package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzox;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cz implements da {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cv cvVar) {
    }

    @Override // com.google.android.gms.tagmanager.da
    public final void a(zzox zzoxVar, Set<zzot> set, Set<zzot> set2, cj cjVar) {
        set.addAll(zzoxVar.zzly());
        set2.addAll(zzoxVar.zzlz());
        cjVar.e();
        cjVar.f();
    }
}
