package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* loaded from: classes.dex */
final class bx implements TurnBasedMultiplayer.CancelMatchResult {
    private final /* synthetic */ Status a;
    private final /* synthetic */ bw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar, Status status) {
        this.b = bwVar;
        this.a = status;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
    public final String getMatchId() {
        String str;
        str = this.b.b;
        return str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
