package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzd;

@SafeParcelable.Class(creator = "PlayerLevelCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class PlayerLevel extends zzd {
    public static final Parcelable.Creator<PlayerLevel> CREATOR = new zzaq();
    @SafeParcelable.Field(getter = "getLevelNumber", id = 1)
    private final int a;
    @SafeParcelable.Field(getter = "getMinXp", id = 2)
    private final long b;
    @SafeParcelable.Field(getter = "getMaxXp", id = 3)
    private final long c;

    @SafeParcelable.Constructor
    public PlayerLevel(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) long j2) {
        boolean z = true;
        Preconditions.checkState(j >= 0, "Min XP must be positive!");
        Preconditions.checkState(j2 <= j ? false : z, "Max XP must be more than min XP!");
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return Objects.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && Objects.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && Objects.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public final int getLevelNumber() {
        return this.a;
    }

    public final long getMaxXp() {
        return this.c;
    }

    public final long getMinXp() {
        return this.b;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("LevelNumber", Integer.valueOf(getLevelNumber())).add("MinXp", Long.valueOf(getMinXp())).add("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getLevelNumber());
        SafeParcelWriter.writeLong(parcel, 2, getMinXp());
        SafeParcelWriter.writeLong(parcel, 3, getMaxXp());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
