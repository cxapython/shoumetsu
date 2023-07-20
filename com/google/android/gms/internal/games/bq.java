package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.multiplayer.ParticipantResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bq extends cg {
    private final /* synthetic */ String b;
    private final /* synthetic */ byte[] c;
    private final /* synthetic */ String d;
    private final /* synthetic */ ParticipantResult[] e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq(zzcz zzczVar, GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        super(googleApiClient, null);
        this.b = str;
        this.c = bArr;
        this.d = str2;
        this.e = participantResultArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(com.google.android.gms.games.internal.zze zzeVar) {
        zzeVar.zza(this, this.b, this.c, this.d, this.e);
    }
}
