package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes.dex */
final class ab extends g {
    private final /* synthetic */ int b;
    private final /* synthetic */ DriveFile.DownloadProgressListener c;
    private final /* synthetic */ zzbn d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(zzbn zzbnVar, GoogleApiClient googleApiClient, int i, DriveFile.DownloadProgressListener downloadProgressListener) {
        super(googleApiClient);
        this.d = zzbnVar;
        this.b = i;
        this.c = downloadProgressListener;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) {
        a(ICancelToken.Stub.asInterface(((zzeo) zzawVar.getService()).zza(new zzgd(this.d.getDriveId(), this.b, 0), new cn(this, this.c)).a));
    }
}
