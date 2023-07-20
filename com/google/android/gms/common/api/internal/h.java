package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class h implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final WeakReference<zaak> a;
    private final Api<?> b;
    private final boolean c;

    public h(zaak zaakVar, Api<?> api, boolean z) {
        this.a = new WeakReference<>(zaakVar);
        this.b = api;
        this.c = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        zabe zabeVar;
        Lock lock;
        Lock lock2;
        boolean a;
        boolean a2;
        zaak zaakVar = this.a.get();
        if (zaakVar == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        zabeVar = zaakVar.a;
        Preconditions.checkState(myLooper == zabeVar.d.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = zaakVar.b;
        lock.lock();
        try {
            a = zaakVar.a(0);
            if (a) {
                if (!connectionResult.isSuccess()) {
                    zaakVar.a(connectionResult, this.b, this.c);
                }
                a2 = zaakVar.a();
                if (a2) {
                    zaakVar.b();
                }
            }
        } finally {
            lock2 = zaakVar.b;
            lock2.unlock();
        }
    }
}
