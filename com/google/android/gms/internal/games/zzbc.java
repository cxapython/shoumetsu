package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;

/* loaded from: classes.dex */
public final class zzbc implements Notifications {
    @Override // com.google.android.gms.games.Notifications
    public final void clear(GoogleApiClient googleApiClient, int i) {
        com.google.android.gms.games.internal.zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzm(i);
        }
    }

    @Override // com.google.android.gms.games.Notifications
    public final void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, Notifications.NOTIFICATION_TYPES_ALL);
    }
}
