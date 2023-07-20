package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae extends al {
    private final /* synthetic */ PendingIntent b;
    private final /* synthetic */ am c;
    private final /* synthetic */ SubscribeOptions d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(zzbi zzbiVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent, am amVar, SubscribeOptions subscribeOptions) {
        super(googleApiClient);
        this.b = pendingIntent;
        this.c = amVar;
        this.d = subscribeOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzah zzahVar) {
        zzahVar.a(a(), this.b, this.c, this.d);
    }
}
