package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bv extends ce {
    private final /* synthetic */ int b;
    private final /* synthetic */ int[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(zzcz zzczVar, GoogleApiClient googleApiClient, int i, int[] iArr) {
        super(googleApiClient, null);
        this.b = i;
        this.c = iArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) {
        zzeVar.zza(this, this.b, this.c);
    }
}
