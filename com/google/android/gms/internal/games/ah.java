package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class ah extends an {
    private final /* synthetic */ int[] b;
    private final /* synthetic */ int c;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(zzbn zzbnVar, GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
        super(googleApiClient, null);
        this.b = iArr;
        this.c = i;
        this.d = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) {
        zzeVar.zza(this, this.b, this.c, this.d);
    }
}
