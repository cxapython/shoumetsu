package com.google.android.gms.internal.drive;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"MissingRemoteException"})
/* loaded from: classes.dex */
public final class m extends zzav {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(GoogleApiClient googleApiClient, Status status) {
        super(googleApiClient);
        setResult((m) status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void a(zzaw zzawVar) {
    }
}
