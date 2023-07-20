package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

/* loaded from: classes.dex */
public final class LeaderboardBuffer extends EntityBuffer<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final /* synthetic */ Leaderboard a(int i, int i2) {
        return new LeaderboardRef(this.a, i, i2);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final String a() {
        return "external_leaderboard_id";
    }
}
