package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.List;

/* loaded from: classes.dex */
final class s implements Runnable {
    private final /* synthetic */ zzaq a;
    private final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, zzaq zzaqVar) {
        this.b = qVar;
        this.a = zzaqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<DataLayer.a> b;
        zzaq zzaqVar = this.a;
        b = this.b.b();
        zzaqVar.zzc(b);
    }
}
