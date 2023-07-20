package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
final class q extends zzav {
    private final /* synthetic */ DriveId b;
    private final /* synthetic */ int c = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(zzaw zzawVar, GoogleApiClient googleApiClient, DriveId driveId, int i) {
        super(googleApiClient);
        this.b = driveId;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        ((zzeo) zzawVar.getService()).zza(new zzgm(this.b, this.c), (zzes) null, (String) null, new zzgs(this));
    }
}
