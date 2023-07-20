package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bd implements zabt {
    private final /* synthetic */ ba a;

    private bd(ba baVar) {
        this.a = baVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bd(ba baVar, bb bbVar) {
        this(baVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void zab(int i, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        zabe zabeVar;
        lock = this.a.m;
        lock.lock();
        try {
            z2 = this.a.l;
            if (z2) {
                this.a.l = false;
                this.a.a(i, z);
            } else {
                this.a.l = true;
                zabeVar = this.a.d;
                zabeVar.onConnectionSuspended(i);
            }
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
            this.a.k = ConnectionResult.RESULT_SUCCESS;
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
            this.a.k = connectionResult;
            this.a.a();
        } finally {
            lock2 = this.a.m;
            lock2.unlock();
        }
    }
}
