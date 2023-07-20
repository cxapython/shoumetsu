package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

/* loaded from: classes.dex */
public final class zzah implements Invitations {
    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final Intent getInvitationInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbe();
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient) {
        return loadInvitations(googleApiClient, 0);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new f(this, googleApiClient, i));
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final void registerInvitationListener(GoogleApiClient googleApiClient, OnInvitationReceivedListener onInvitationReceivedListener) {
        com.google.android.gms.games.internal.zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzb(googleApiClient.registerListener(onInvitationReceivedListener));
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final void unregisterInvitationListener(GoogleApiClient googleApiClient) {
        com.google.android.gms.games.internal.zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzbg();
        }
    }
}
