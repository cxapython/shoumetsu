package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes.dex */
final class b extends g {
    private final /* synthetic */ int b = DriveFile.MODE_WRITE_ONLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzaf zzafVar, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        ((zzeo) zzawVar.getService()).zza(new zzr(this.b), new e(this));
    }
}
