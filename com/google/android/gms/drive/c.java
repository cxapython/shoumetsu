package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.internal.drive.zzaw;

/* loaded from: classes.dex */
final class c extends Api.AbstractClientBuilder<zzaw, Drive.zzb> {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ zzaw buildClient(Context context, Looper looper, ClientSettings clientSettings, Drive.zzb zzbVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (zzbVar == null) {
            return new zzaw(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener, new Bundle());
        }
        throw new NoSuchMethodError();
    }
}
