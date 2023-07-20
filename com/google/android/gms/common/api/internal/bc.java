package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc implements zabt {
    private final /* synthetic */ ba a;

    private bc(ba baVar) {
        this.a = baVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bc(ba baVar, bb bbVar) {
        this(baVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zab(int i, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        zabe zabeVar;
        lock = this.a.m;
        lock.lock();
        try {
            z2 = this.a.l;
            if (!z2) {
                connectionResult = this.a.k;
                if (connectionResult != null) {
                    connectionResult2 = this.a.k;
                    if (connectionResult2.isSuccess()) {
                        this.a.l = true;
                        zabeVar = this.a.e;
                        zabeVar.onConnectionSuspended(i);
                    }
                }
            }
            this.a.l = false;
            this.a.a(i, z);
        } finally {
            lock2 = this.a.m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zab(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.a.m;
        lock.lock();
        try {
            this.a.a(bundle);
            this.a.j = ConnectionResult.RESULT_SUCCESS;
            this.a.a();
        } finally {
            lock2 = this.a.m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zac(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.a.m;
        lock.lock();
        try {
            this.a.j = connectionResult;
            this.a.a();
        } finally {
            lock2 = this.a.m;
            lock2.unlock();
        }
    }
}
