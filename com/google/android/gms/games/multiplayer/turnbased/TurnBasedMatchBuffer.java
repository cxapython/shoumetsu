package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

/* loaded from: classes.dex */
public final class TurnBasedMatchBuffer extends EntityBuffer<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final /* synthetic */ TurnBasedMatch a(int i, int i2) {
        return new zzd(this.a, i, i2);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final String a() {
        return "external_match_id";
    }
}
