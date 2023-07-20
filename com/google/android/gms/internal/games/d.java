package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;

/* loaded from: classes.dex */
abstract class d extends Games.zza<GamesMetadata.LoadGamesResult> {
    private d(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(GoogleApiClient googleApiClient, c cVar) {
        this(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: createFailedResult */
    public /* synthetic */ Result mo8createFailedResult(Status status) {
        return new e(this, status);
    }
}
