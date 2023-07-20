package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb extends bw {
    private final /* synthetic */ List b;
    private final /* synthetic */ Payload c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(zzca zzcaVar, GoogleApiClient googleApiClient, List list, Payload payload) {
        super(googleApiClient, null);
        this.b = list;
        this.c = payload;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        zzxVar.zza((BaseImplementation.ResultHolder<Status>) this, (String[]) this.b.toArray(new String[0]), this.c, false);
    }
}
