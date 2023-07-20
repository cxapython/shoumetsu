package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;

/* loaded from: classes.dex */
final class bl extends bw {
    private final /* synthetic */ List b;
    private final /* synthetic */ byte[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(zzca zzcaVar, GoogleApiClient googleApiClient, List list, byte[] bArr) {
        super(googleApiClient, null);
        this.b = list;
        this.c = bArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        zzxVar.zza((BaseImplementation.ResultHolder<Status>) this, (String[]) this.b.toArray(new String[0]), Payload.fromBytes(this.c), true);
    }
}
