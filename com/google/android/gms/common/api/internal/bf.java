package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bf implements OnCompleteListener<Map<zai<?>, String>> {
    private final /* synthetic */ zax a;

    private bf(zax zaxVar) {
        this.a = zaxVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Map<zai<?>, String>> task) {
        Lock lock;
        Lock lock2;
        boolean z;
        zax zaxVar;
        ConnectionResult connectionResult;
        boolean z2;
        Map map;
        Map map2;
        boolean a;
        Map map3;
        Map map4;
        ConnectionResult connectionResult2;
        zaaw zaawVar;
        ConnectionResult connectionResult3;
        Condition condition;
        Map map5;
        Map map6;
        ConnectionResult d;
        Map map7;
        Map map8;
        Map map9;
        lock = this.a.f;
        lock.lock();
        try {
            z = this.a.n;
            if (z) {
                if (task.isSuccessful()) {
                    zax zaxVar2 = this.a;
                    map7 = this.a.a;
                    zaxVar2.o = new androidx.b.a(map7.size());
                    map8 = this.a.a;
                    for (zaw zawVar : map8.values()) {
                        map9 = this.a.o;
                        map9.put(zawVar.zak(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else {
                    if (task.getException() instanceof AvailabilityException) {
                        AvailabilityException availabilityException = (AvailabilityException) task.getException();
                        z2 = this.a.l;
                        if (z2) {
                            zax zaxVar3 = this.a;
                            map = this.a.a;
                            zaxVar3.o = new androidx.b.a(map.size());
                            map2 = this.a.a;
                            for (zaw zawVar2 : map2.values()) {
                                Object zak = zawVar2.zak();
                                ConnectionResult connectionResult4 = availabilityException.getConnectionResult(zawVar2);
                                a = this.a.a(zawVar2, connectionResult4);
                                if (a) {
                                    map3 = this.a.o;
                                    connectionResult4 = new ConnectionResult(16);
                                } else {
                                    map3 = this.a.o;
                                }
                                map3.put(zak, connectionResult4);
                            }
                        } else {
                            this.a.o = availabilityException.zaj();
                        }
                        zaxVar = this.a;
                        connectionResult = this.a.d();
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                        this.a.o = Collections.emptyMap();
                        zaxVar = this.a;
                        connectionResult = new ConnectionResult(8);
                    }
                    zaxVar.r = connectionResult;
                }
                map4 = this.a.p;
                if (map4 != null) {
                    map5 = this.a.o;
                    map6 = this.a.p;
                    map5.putAll(map6);
                    zax zaxVar4 = this.a;
                    d = this.a.d();
                    zaxVar4.r = d;
                }
                connectionResult2 = this.a.r;
                if (connectionResult2 == null) {
                    this.a.b();
                    this.a.c();
                } else {
                    this.a.n = false;
                    zaawVar = this.a.e;
                    connectionResult3 = this.a.r;
                    zaawVar.zac(connectionResult3);
                }
                condition = this.a.i;
                condition.signalAll();
            }
        } finally {
            lock2 = this.a.f;
            lock2.unlock();
        }
    }
}
