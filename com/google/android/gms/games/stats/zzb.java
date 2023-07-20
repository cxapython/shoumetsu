package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;

/* loaded from: classes.dex */
public final class zzb extends DataBufferRef implements PlayerStats {
    private Bundle c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return PlayerStatsEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* synthetic */ PlayerStats mo28freeze() {
        return new PlayerStatsEntity(this);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getAverageSessionLength() {
        return e("ave_session_length_minutes");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getChurnProbability() {
        return e("churn_probability");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final int getDaysSinceLastPlayed() {
        return b("days_since_last_played");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getHighSpenderProbability() {
        if (!hasColumn("high_spender_probability")) {
            return -1.0f;
        }
        return e("high_spender_probability");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfPurchases() {
        return b("num_purchases");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfSessions() {
        return b("num_sessions");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getSessionPercentile() {
        return e("num_sessions_percentile");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendPercentile() {
        return e("spend_percentile");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendProbability() {
        if (!hasColumn("spend_probability")) {
            return -1.0f;
        }
        return e("spend_probability");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getTotalSpendNext28Days() {
        if (!hasColumn("total_spend_next_28_days")) {
            return -1.0f;
        }
        return e("total_spend_next_28_days");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return PlayerStatsEntity.a(this);
    }

    public final String toString() {
        return PlayerStatsEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((PlayerStatsEntity) ((PlayerStats) mo28freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final Bundle zzdu() {
        Bundle bundle = this.c;
        if (bundle != null) {
            return bundle;
        }
        this.c = new Bundle();
        String d = d("unknown_raw_keys");
        String d2 = d("unknown_raw_values");
        if (d != null && d2 != null) {
            String[] split = d.split(",");
            String[] split2 = d2.split(",");
            Asserts.checkState(split.length <= split2.length, "Invalid raw arguments!");
            for (int i = 0; i < split.length; i++) {
                this.c.putString(split[i], split2[i]);
            }
        }
        return this.c;
    }
}
