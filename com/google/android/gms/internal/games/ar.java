package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class ar extends as {
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(zzbz zzbzVar, GoogleApiClient googleApiClient, int i, int i2, int i3) {
        super(googleApiClient, null);
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) {
        zzeVar.zza(this, this.b, this.c, this.d);
    }
}
