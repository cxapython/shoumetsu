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
public final class a implements OnCompleteListener<Map<zai<?>, String>> {
    private SignInConnectionListener a;
    private final /* synthetic */ zax b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zax zaxVar, SignInConnectionListener signInConnectionListener) {
        this.b = zaxVar;
        this.a = signInConnectionListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.a.onComplete();
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Map<zai<?>, String>> task) {
        Lock lock;
        Lock lock2;
        boolean z;
        boolean z2;
        Map map;
        Map map2;
        boolean a;
        Map map3;
        SignInConnectionListener signInConnectionListener;
        Map map4;
        Map map5;
        ConnectionResult d;
        Condition condition;
        Map map6;
        Map map7;
        Map map8;
        lock = this.b.f;
        lock.lock();
        try {
            z = this.b.n;
            if (!z) {
                signInConnectionListener = this.a;
            } else {
                if (task.isSuccessful()) {
                    zax zaxVar = this.b;
                    map6 = this.b.b;
                    zaxVar.p = new androidx.b.a(map6.size());
                    map7 = this.b.b;
                    for (zaw zawVar : map7.values()) {
                        map8 = this.b.p;
                        map8.put(zawVar.zak(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    z2 = this.b.l;
                    if (z2) {
                        zax zaxVar2 = this.b;
                        map = this.b.b;
                        zaxVar2.p = new androidx.b.a(map.size());
                        map2 = this.b.b;
                        for (zaw zawVar2 : map2.values()) {
                            Object zak = zawVar2.zak();
                            ConnectionResult connectionResult = availabilityException.getConnectionResult(zawVar2);
                            a = this.b.a(zawVar2, connectionResult);
                            if (a) {
                                map3 = this.b.p;
                                connectionResult = new ConnectionResult(16);
                            } else {
                                map3 = this.b.p;
                            }
                            map3.put(zak, connectionResult);
                        }
                    } else {
                        this.b.p = availabilityException.zaj();
                    }
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                    this.b.p = Collections.emptyMap();
                }
                if (this.b.isConnected()) {
                    map4 = this.b.o;
                    map5 = this.b.p;
                    map4.putAll(map5);
                    d = this.b.d();
                    if (d == null) {
                        this.b.b();
                        this.b.c();
                        condition = this.b.i;
                        condition.signalAll();
                    }
                }
                signInConnectionListener = this.a;
            }
            signInConnectionListener.onComplete();
        } finally {
            lock2 = this.b.f;
            lock2.unlock();
        }
    }
}
