package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TurnBasedMatchConfig {

    /* loaded from: classes.dex */
    public static final class Builder {
        int a;
        ArrayList<String> b;
        Bundle c;
        int d;

        private Builder() {
            this.a = -1;
            this.b = new ArrayList<>();
            this.c = null;
            this.d = 2;
        }

        public final Builder addInvitedPlayer(String str) {
            Preconditions.checkNotNull(str);
            this.b.add(str);
            return this;
        }

        public final Builder addInvitedPlayers(ArrayList<String> arrayList) {
            Preconditions.checkNotNull(arrayList);
            this.b.addAll(arrayList);
            return this;
        }

        public final TurnBasedMatchConfig build() {
            return new zzb(this);
        }

        public final Builder setAutoMatchCriteria(Bundle bundle) {
            this.c = bundle;
            return this;
        }

        public final Builder setVariant(int i) {
            Preconditions.checkArgument(i == -1 || i > 0, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.a = i;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String[] getInvitedPlayerIds();

    public abstract int getVariant();

    public abstract int zzdp();
}
