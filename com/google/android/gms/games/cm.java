package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;

/* loaded from: classes.dex */
final class cm implements Games.GetServerAuthCodeResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(Games.b bVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.Games.GetServerAuthCodeResult
    public final String getCode() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
