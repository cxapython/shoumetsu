package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends al {
    private final /* synthetic */ Message b;
    private final /* synthetic */ aj c;
    private final /* synthetic */ PublishOptions d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(zzbi zzbiVar, GoogleApiClient googleApiClient, Message message, aj ajVar, PublishOptions publishOptions) {
        super(googleApiClient);
        this.b = message;
        this.c = ajVar;
        this.d = publishOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzah zzahVar) {
        zzahVar.a(a(), zzaf.zza(this.b), this.c, this.d);
    }
}
