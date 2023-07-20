package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "PlayerStatsEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class PlayerStatsEntity extends zzd implements PlayerStats {
    public static final Parcelable.Creator<PlayerStatsEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getAverageSessionLength", id = 1)
    private final float a;
    @SafeParcelable.Field(getter = "getChurnProbability", id = 2)
    private final float b;
    @SafeParcelable.Field(getter = "getDaysSinceLastPlayed", id = 3)
    private final int c;
    @SafeParcelable.Field(getter = "getNumberOfPurchases", id = 4)
    private final int d;
    @SafeParcelable.Field(getter = "getNumberOfSessions", id = 5)
    private final int e;
    @SafeParcelable.Field(getter = "getSessionPercentile", id = 6)
    private final float f;
    @SafeParcelable.Field(getter = "getSpendPercentile", id = 7)
    private final float g;
    @SafeParcelable.Field(getter = "getRawValues", id = 8)
    private final Bundle h;
    @SafeParcelable.Field(getter = "getSpendProbability", id = 9)
    private final float i;
    @SafeParcelable.Field(getter = "getHighSpenderProbability", id = 10)
    private final float j;
    @SafeParcelable.Field(getter = "getTotalSpendNext28Days", id = 11)
    private final float k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PlayerStatsEntity(@SafeParcelable.Param(id = 1) float f, @SafeParcelable.Param(id = 2) float f2, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) float f3, @SafeParcelable.Param(id = 7) float f4, @SafeParcelable.Param(id = 8) Bundle bundle, @SafeParcelable.Param(id = 9) float f5, @SafeParcelable.Param(id = 10) float f6, @SafeParcelable.Param(id = 11) float f7) {
        this.a = f;
        this.b = f2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = f3;
        this.g = f4;
        this.h = bundle;
        this.i = f5;
        this.j = f6;
        this.k = f7;
    }

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.a = playerStats.getAverageSessionLength();
        this.b = playerStats.getChurnProbability();
        this.c = playerStats.getDaysSinceLastPlayed();
        this.d = playerStats.getNumberOfPurchases();
        this.e = playerStats.getNumberOfSessions();
        this.f = playerStats.getSessionPercentile();
        this.g = playerStats.getSpendPercentile();
        this.i = playerStats.getSpendProbability();
        this.j = playerStats.getHighSpenderProbability();
        this.k = playerStats.getTotalSpendNext28Days();
        this.h = playerStats.zzdu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(PlayerStats playerStats) {
        return Objects.hashCode(Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.getChurnProbability()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()), Float.valueOf(playerStats.getSpendProbability()), Float.valueOf(playerStats.getHighSpenderProbability()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return Objects.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) && Objects.equal(Float.valueOf(playerStats2.getChurnProbability()), Float.valueOf(playerStats.getChurnProbability())) && Objects.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) && Objects.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendProbability()), Float.valueOf(playerStats.getSpendProbability())) && Objects.equal(Float.valueOf(playerStats2.getHighSpenderProbability()), Float.valueOf(playerStats.getHighSpenderProbability())) && Objects.equal(Float.valueOf(playerStats2.getTotalSpendNext28Days()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(PlayerStats playerStats) {
        return Objects.toStringHelper(playerStats).add("AverageSessionLength", Float.valueOf(playerStats.getAverageSessionLength())).add("ChurnProbability", Float.valueOf(playerStats.getChurnProbability())).add("DaysSinceLastPlayed", Integer.valueOf(playerStats.getDaysSinceLastPlayed())).add("NumberOfPurchases", Integer.valueOf(playerStats.getNumberOfPurchases())).add("NumberOfSessions", Integer.valueOf(playerStats.getNumberOfSessions())).add("SessionPercentile", Float.valueOf(playerStats.getSessionPercentile())).add("SpendPercentile", Float.valueOf(playerStats.getSpendPercentile())).add("SpendProbability", Float.valueOf(playerStats.getSpendProbability())).add("HighSpenderProbability", Float.valueOf(playerStats.getHighSpenderProbability())).add("TotalSpendNext28Days", Float.valueOf(playerStats.getTotalSpendNext28Days())).toString();
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public /* bridge */ /* synthetic */ PlayerStats mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getAverageSessionLength() {
        return this.a;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getChurnProbability() {
        return this.b;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int getDaysSinceLastPlayed() {
        return this.c;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getHighSpenderProbability() {
        return this.j;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int getNumberOfPurchases() {
        return this.d;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int getNumberOfSessions() {
        return this.e;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getSessionPercentile() {
        return this.f;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getSpendPercentile() {
        return this.g;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getSpendProbability() {
        return this.i;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getTotalSpendNext28Days() {
        return this.k;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 1, getAverageSessionLength());
        SafeParcelWriter.writeFloat(parcel, 2, getChurnProbability());
        SafeParcelWriter.writeInt(parcel, 3, getDaysSinceLastPlayed());
        SafeParcelWriter.writeInt(parcel, 4, getNumberOfPurchases());
        SafeParcelWriter.writeInt(parcel, 5, getNumberOfSessions());
        SafeParcelWriter.writeFloat(parcel, 6, getSessionPercentile());
        SafeParcelWriter.writeFloat(parcel, 7, getSpendPercentile());
        SafeParcelWriter.writeBundle(parcel, 8, this.h, false);
        SafeParcelWriter.writeFloat(parcel, 9, getSpendProbability());
        SafeParcelWriter.writeFloat(parcel, 10, getHighSpenderProbability());
        SafeParcelWriter.writeFloat(parcel, 11, getTotalSpendNext28Days());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final Bundle zzdu() {
        return this.h;
    }
}
