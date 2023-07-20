package com.google.android.gms.internal.games;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.Events;

/* loaded from: classes.dex */
public final class zzu implements Events {
    @Override // com.google.android.gms.games.event.Events
    @SuppressLint({"MissingRemoteException"})
    public final void increment(GoogleApiClient googleApiClient, String str, int i) {
        com.google.android.gms.games.internal.zze zzb = Games.zzb(googleApiClient, false);
        if (zzb == null) {
            return;
        }
        if (zzb.isConnected()) {
            zzb.zza(str, i);
        } else {
            googleApiClient.execute(new di(this, googleApiClient, str, i));
        }
    }

    @Override // com.google.android.gms.games.event.Events
    public final PendingResult<Events.LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new dh(this, googleApiClient, z));
    }

    @Override // com.google.android.gms.games.event.Events
    public final PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.enqueue(new dg(this, googleApiClient, z, strArr));
    }
}
