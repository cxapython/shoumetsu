package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "AchievementEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class AchievementEntity extends zzd implements Achievement {
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getAchievementId", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getType", id = 2)
    private final int b;
    @SafeParcelable.Field(getter = "getName", id = 3)
    private final String c;
    @SafeParcelable.Field(getter = "getDescription", id = 4)
    private final String d;
    @SafeParcelable.Field(getter = "getUnlockedImageUri", id = 5)
    private final Uri e;
    @SafeParcelable.Field(getter = "getUnlockedImageUrl", id = 6)
    private final String f;
    @SafeParcelable.Field(getter = "getRevealedImageUri", id = 7)
    private final Uri g;
    @SafeParcelable.Field(getter = "getRevealedImageUrl", id = 8)
    private final String h;
    @SafeParcelable.Field(getter = "getTotalStepsRaw", id = 9)
    private final int i;
    @SafeParcelable.Field(getter = "getFormattedTotalStepsRaw", id = 10)
    private final String j;
    @SafeParcelable.Field(getter = "getPlayerInternal", id = 11)
    private final PlayerEntity k;
    @SafeParcelable.Field(getter = "getState", id = 12)
    private final int l;
    @SafeParcelable.Field(getter = "getCurrentStepsRaw", id = 13)
    private final int m;
    @SafeParcelable.Field(getter = "getFormattedCurrentStepsRaw", id = 14)
    private final String n;
    @SafeParcelable.Field(getter = "getLastUpdatedTimestamp", id = 15)
    private final long o;
    @SafeParcelable.Field(getter = "getXpValue", id = 16)
    private final long p;
    @SafeParcelable.Field(defaultValue = "-1.0f", getter = "getRarityPercent", id = 17)
    private final float q;
    @SafeParcelable.Field(getter = "getApplicationId", id = 18)
    private final String r;

    public AchievementEntity(Achievement achievement) {
        this.a = achievement.getAchievementId();
        this.b = achievement.getType();
        this.c = achievement.getName();
        this.d = achievement.getDescription();
        this.e = achievement.getUnlockedImageUri();
        this.f = achievement.getUnlockedImageUrl();
        this.g = achievement.getRevealedImageUri();
        this.h = achievement.getRevealedImageUrl();
        if (achievement.zzw() != null) {
            this.k = (PlayerEntity) achievement.zzw().mo28freeze();
        } else {
            this.k = null;
        }
        this.l = achievement.getState();
        this.o = achievement.getLastUpdatedTimestamp();
        this.p = achievement.getXpValue();
        this.q = achievement.zzx();
        this.r = achievement.getApplicationId();
        if (achievement.getType() == 1) {
            this.i = achievement.getTotalSteps();
            this.j = achievement.getFormattedTotalSteps();
            this.m = achievement.getCurrentSteps();
            this.n = achievement.getFormattedCurrentSteps();
        } else {
            this.i = 0;
            this.j = null;
            this.m = 0;
            this.n = null;
        }
        Asserts.checkNotNull(this.a);
        Asserts.checkNotNull(this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AchievementEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) Uri uri, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Uri uri2, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) int i2, @SafeParcelable.Param(id = 10) String str6, @SafeParcelable.Param(id = 11) PlayerEntity playerEntity, @SafeParcelable.Param(id = 12) int i3, @SafeParcelable.Param(id = 13) int i4, @SafeParcelable.Param(id = 14) String str7, @SafeParcelable.Param(id = 15) long j, @SafeParcelable.Param(id = 16) long j2, @SafeParcelable.Param(id = 17) float f, @SafeParcelable.Param(id = 18) String str8) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = uri;
        this.f = str4;
        this.g = uri2;
        this.h = str5;
        this.i = i2;
        this.j = str6;
        this.k = playerEntity;
        this.l = i3;
        this.m = i4;
        this.n = str7;
        this.o = j;
        this.p = j2;
        this.q = f;
        this.r = str8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Achievement achievement) {
        Objects.ToStringHelper add = Objects.toStringHelper(achievement).add("Id", achievement.getAchievementId()).add("Game Id", achievement.getApplicationId()).add("Type", Integer.valueOf(achievement.getType())).add("Name", achievement.getName()).add("Description", achievement.getDescription()).add("Player", achievement.zzw()).add("State", Integer.valueOf(achievement.getState())).add("Rarity Percent", Float.valueOf(achievement.zzx()));
        if (achievement.getType() == 1) {
            add.add("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            add.add("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return add.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Achievement) {
            if (this == obj) {
                return true;
            }
            Achievement achievement = (Achievement) obj;
            if (achievement.getType() != getType()) {
                return false;
            }
            return (getType() != 1 || (achievement.getCurrentSteps() == getCurrentSteps() && achievement.getTotalSteps() == getTotalSteps())) && achievement.getXpValue() == getXpValue() && achievement.getState() == getState() && achievement.getLastUpdatedTimestamp() == getLastUpdatedTimestamp() && Objects.equal(achievement.getAchievementId(), getAchievementId()) && Objects.equal(achievement.getApplicationId(), getApplicationId()) && Objects.equal(achievement.getName(), getName()) && Objects.equal(achievement.getDescription(), getDescription()) && Objects.equal(achievement.zzw(), zzw()) && achievement.zzx() == zzx();
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final Achievement mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getAchievementId() {
        return this.a;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getApplicationId() {
        return this.r;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.m;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getDescription() {
        return this.d;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.d, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.n;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        DataUtils.copyStringToBuffer(this.n, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.j;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        DataUtils.copyStringToBuffer(this.j, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getLastUpdatedTimestamp() {
        return this.o;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getName() {
        return this.c;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.c, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player getPlayer() {
        return (Player) Preconditions.checkNotNull(this.k);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getRevealedImageUri() {
        return this.g;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getRevealedImageUrl() {
        return this.h;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getState() {
        return this.l;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.i;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getType() {
        return this.b;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getUnlockedImageUri() {
        return this.e;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getUnlockedImageUrl() {
        return this.f;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getXpValue() {
        return this.p;
    }

    public final int hashCode() {
        int i;
        int i2;
        if (getType() == 1) {
            i = getCurrentSteps();
            i2 = getTotalSteps();
        } else {
            i = 0;
            i2 = 0;
        }
        return Objects.hashCode(getAchievementId(), getApplicationId(), getName(), Integer.valueOf(getType()), getDescription(), Long.valueOf(getXpValue()), Integer.valueOf(getState()), Long.valueOf(getLastUpdatedTimestamp()), zzw(), Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return a(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAchievementId(), false);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getUnlockedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getUnlockedImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getRevealedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 8, getRevealedImageUrl(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.i);
        SafeParcelWriter.writeString(parcel, 10, this.j, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.k, i, false);
        SafeParcelWriter.writeInt(parcel, 12, getState());
        SafeParcelWriter.writeInt(parcel, 13, this.m);
        SafeParcelWriter.writeString(parcel, 14, this.n, false);
        SafeParcelWriter.writeLong(parcel, 15, getLastUpdatedTimestamp());
        SafeParcelWriter.writeLong(parcel, 16, getXpValue());
        SafeParcelWriter.writeFloat(parcel, 17, this.q);
        SafeParcelWriter.writeString(parcel, 18, this.r, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player zzw() {
        return this.k;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final float zzx() {
        return this.q;
    }
}
