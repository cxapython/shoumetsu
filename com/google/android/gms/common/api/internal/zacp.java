package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zacp {
    @VisibleForTesting
    final Set<BasePendingResult<?>> a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final au c = new as(this);
    private final Map<Api.AnyClientKey<?>, Api.Client> d;
    public static final Status zakx = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] b = new BasePendingResult[0];

    public zacp(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.d = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BasePendingResult<? extends Result> basePendingResult) {
        this.a.add(basePendingResult);
        basePendingResult.zaa(this.c);
    }

    public final void release() {
        BasePendingResult[] basePendingResultArr;
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.a.toArray(b)) {
            com.google.android.gms.common.api.zac zacVar = null;
            basePendingResult.zaa(null);
            if (basePendingResult.zam() != null) {
                basePendingResult.setResultCallback(null);
                IBinder serviceBrokerBinder = this.d.get(((BaseImplementation.ApiMethodImpl) basePendingResult).getClientKey()).getServiceBrokerBinder();
                if (basePendingResult.isReady()) {
                    basePendingResult.zaa(new at(basePendingResult, null, serviceBrokerBinder, null));
                } else {
                    if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                        basePendingResult.zaa(null);
                    } else {
                        at atVar = new at(basePendingResult, null, serviceBrokerBinder, null);
                        basePendingResult.zaa(atVar);
                        try {
                            serviceBrokerBinder.linkToDeath(atVar, 0);
                        } catch (RemoteException unused) {
                        }
                    }
                    basePendingResult.cancel();
                    zacVar.remove(basePendingResult.zam().intValue());
                }
            } else if (!basePendingResult.zat()) {
            }
            this.a.remove(basePendingResult);
        }
    }

    public final void zabx() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.a.toArray(b)) {
            basePendingResult.zab(zakx);
        }
    }
}
