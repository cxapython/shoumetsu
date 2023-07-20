package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements zzaq {
    private final /* synthetic */ DataLayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(DataLayer dataLayer) {
        this.a = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzaq
    public final void zzc(List<DataLayer.a> list) {
        CountDownLatch countDownLatch;
        for (DataLayer.a aVar : list) {
            this.a.a(DataLayer.a(aVar.a, aVar.b));
        }
        countDownLatch = this.a.h;
        countDownLatch.countDown();
    }
}
