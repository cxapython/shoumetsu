package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes.dex */
final class bh extends bw {
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ byte[] d;
    private final /* synthetic */ ListenerHolder e;
    private final /* synthetic */ ListenerHolder f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(zzca zzcaVar, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(googleApiClient, null);
        this.b = str;
        this.c = str2;
        this.d = bArr;
        this.e = listenerHolder;
        this.f = listenerHolder2;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzx zzxVar) {
        String str = this.b;
        String str2 = this.c;
        byte[] bArr = this.d;
        ListenerHolder listenerHolder = this.e;
        ((zzdu) zzxVar.getService()).zza(new zzfs().zzd(new aa(this)).zzg(str).zzh(str2).zzc(bArr).zzb(new r(this.f)).zza(new i(listenerHolder)).zzt());
    }
}
