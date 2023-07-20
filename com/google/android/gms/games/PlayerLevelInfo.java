package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzd;

@SafeParcelable.Class(creator = "PlayerLevelInfoCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class PlayerLevelInfo extends zzd {
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new zzar();
    @SafeParcelable.Field(getter = "getCurrentXpTotal", id = 1)
    private final long a;
    @SafeParcelable.Field(getter = "getLastLevelUpTimestamp", id = 2)
    private final long b;
    @SafeParcelable.Field(getter = "getCurrentLevel", id = 3)
    private final PlayerLevel c;
    @SafeParcelable.Field(getter = "getNextLevel", id = 4)
    private final PlayerLevel d;

    @SafeParcelable.Constructor
    public PlayerLevelInfo(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) PlayerLevel playerLevel, @SafeParcelable.Param(id = 4) PlayerLevel playerLevel2) {
        Preconditions.checkState(j != -1);
        Preconditions.checkNotNull(playerLevel);
        Preconditions.checkNotNull(playerLevel2);
        this.a = j;
        this.b = j2;
        this.c = playerLevel;
        this.d = playerLevel2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return Objects.equal(Long.valueOf(this.a), Long.valueOf(playerLevelInfo.a)) && Objects.equal(Long.valueOf(this.b), Long.valueOf(playerLevelInfo.b)) && Objects.equal(this.c, playerLevelInfo.c) && Objects.equal(this.d, playerLevelInfo.d);
    }

    public final PlayerLevel getCurrentLevel() {
        return this.c;
    }

    public final long getCurrentXpTotal() {
        return this.a;
    }

    public final long getLastLevelUpTimestamp() {
        return this.b;
    }

    public final PlayerLevel getNextLevel() {
        return this.d;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.a), Long.valueOf(this.b), this.c, this.d);
    }

    public final boolean isMaxLevel() {
        return this.c.equals(this.d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getCurrentXpTotal());
        SafeParcelWriter.writeLong(parcel, 2, getLastLevelUpTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 3, getCurrentLevel(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getNextLevel(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
