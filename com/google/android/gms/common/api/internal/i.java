package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends p {
    final /* synthetic */ zaak a;
    private final Map<Api.Client, h> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(zaak zaakVar, Map<Api.Client, h> map) {
        super(zaakVar, null);
        this.a = zaakVar;
        this.b = map;
    }

    @Override // com.google.android.gms.common.api.internal.p
    @GuardedBy("mLock")
    public final void a() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        boolean z;
        Context context2;
        zabe zabeVar;
        zad zadVar;
        zad zadVar2;
        zabe zabeVar2;
        Context context3;
        boolean z2;
        googleApiAvailabilityLight = this.a.d;
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(googleApiAvailabilityLight);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.b.keySet()) {
            if (client.requiresGooglePlayServices()) {
                z2 = this.b.get(client).c;
                if (!z2) {
                    arrayList.add(client);
                }
            }
            arrayList2.add(client);
        }
        int i = -1;
        int i2 = 0;
        if (arrayList.isEmpty()) {
            ArrayList arrayList3 = arrayList2;
            int size = arrayList3.size();
            while (i2 < size) {
                Object obj = arrayList3.get(i2);
                i2++;
                context3 = this.a.c;
                i = googleApiAvailabilityCache.getClientAvailability(context3, (Api.Client) obj);
                if (i == 0) {
                    break;
                }
            }
        } else {
            ArrayList arrayList4 = arrayList;
            int size2 = arrayList4.size();
            while (i2 < size2) {
                Object obj2 = arrayList4.get(i2);
                i2++;
                context = this.a.c;
                i = googleApiAvailabilityCache.getClientAvailability(context, (Api.Client) obj2);
                if (i != 0) {
                    break;
                }
            }
        }
        if (i != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i, null);
            zabeVar2 = this.a.a;
            zabeVar2.a(new j(this, this.a, connectionResult));
            return;
        }
        z = this.a.m;
        if (z) {
            zadVar = this.a.k;
            if (zadVar != null) {
                zadVar2 = this.a.k;
                zadVar2.connect();
            }
        }
        for (Api.Client client2 : this.b.keySet()) {
            h hVar = this.b.get(client2);
            if (client2.requiresGooglePlayServices()) {
                context2 = this.a.c;
                if (googleApiAvailabilityCache.getClientAvailability(context2, client2) != 0) {
                    zabeVar = this.a.a;
                    zabeVar.a(new k(this, this.a, hVar));
                }
            }
            client2.connect(hVar);
        }
    }
}
