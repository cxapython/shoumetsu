package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes.dex */
public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final zza b;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.b = new zza(dataHolder.getMetadata());
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: get */
    public final LeaderboardScore mo27get(int i) {
        return new LeaderboardScoreRef(this.a, i);
    }

    public final zza zzdi() {
        return this.b;
    }
}
