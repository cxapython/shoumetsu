package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Runnable {
    private final /* synthetic */ zaak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zaak zaakVar) {
        this.a = zaakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        googleApiAvailabilityLight = this.a.d;
        context = this.a.c;
        googleApiAvailabilityLight.cancelAvailabilityErrorNotifications(context);
    }
}
