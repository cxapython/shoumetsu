package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "ExperienceEventEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class ExperienceEventEntity extends zzd implements ExperienceEvent {
    public static final Parcelable.Creator<ExperienceEventEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getExperienceId", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getGame", id = 2)
    private final GameEntity b;
    @SafeParcelable.Field(getter = "getDisplayTitle", id = 3)
    private final String c;
    @SafeParcelable.Field(getter = "getDisplayDescription", id = 4)
    private final String d;
    @SafeParcelable.Field(getter = "getIconImageUrl", id = 5)
    private final String e;
    @SafeParcelable.Field(getter = "getIconImageUri", id = 6)
    private final Uri f;
    @SafeParcelable.Field(getter = "getCreatedTimestamp", id = 7)
    private final long g;
    @SafeParcelable.Field(getter = "getXpEarned", id = 8)
    private final long h;
    @SafeParcelable.Field(getter = "getCurrentXp", id = 9)
    private final long i;
    @SafeParcelable.Field(getter = "getType", id = 10)
    private final int j;
    @SafeParcelable.Field(getter = "getNewLevel", id = 11)
    private final int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ExperienceEventEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) GameEntity gameEntity, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) Uri uri, @SafeParcelable.Param(id = 7) long j, @SafeParcelable.Param(id = 8) long j2, @SafeParcelable.Param(id = 9) long j3, @SafeParcelable.Param(id = 10) int i, @SafeParcelable.Param(id = 11) int i2) {
        this.a = str;
        this.b = gameEntity;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = uri;
        this.g = j;
        this.h = j2;
        this.i = j3;
        this.j = i;
        this.k = i2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ExperienceEvent) {
            if (this == obj) {
                return true;
            }
            ExperienceEvent experienceEvent = (ExperienceEvent) obj;
            return Objects.equal(experienceEvent.zzcu(), zzcu()) && Objects.equal(experienceEvent.getGame(), getGame()) && Objects.equal(experienceEvent.zzcv(), zzcv()) && Objects.equal(experienceEvent.zzcw(), zzcw()) && Objects.equal(experienceEvent.getIconImageUrl(), getIconImageUrl()) && Objects.equal(experienceEvent.getIconImageUri(), getIconImageUri()) && Objects.equal(Long.valueOf(experienceEvent.zzcx()), Long.valueOf(zzcx())) && Objects.equal(Long.valueOf(experienceEvent.zzcy()), Long.valueOf(zzcy())) && Objects.equal(Long.valueOf(experienceEvent.zzcz()), Long.valueOf(zzcz())) && Objects.equal(Integer.valueOf(experienceEvent.getType()), Integer.valueOf(getType())) && Objects.equal(Integer.valueOf(experienceEvent.zzda()), Integer.valueOf(zzda()));
        }
        return false;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ ExperienceEvent mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Game getGame() {
        return this.b;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Uri getIconImageUri() {
        return this.f;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String getIconImageUrl() {
        return this.e;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int getType() {
        return this.j;
    }

    public final int hashCode() {
        return Objects.hashCode(zzcu(), getGame(), zzcv(), zzcw(), getIconImageUrl(), getIconImageUri(), Long.valueOf(zzcx()), Long.valueOf(zzcy()), Long.valueOf(zzcz()), Integer.valueOf(getType()), Integer.valueOf(zzda()));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("ExperienceId", zzcu()).add("Game", getGame()).add("DisplayTitle", zzcv()).add("DisplayDescription", zzcw()).add("IconImageUrl", getIconImageUrl()).add("IconImageUri", getIconImageUri()).add("CreatedTimestamp", Long.valueOf(zzcx())).add("XpEarned", Long.valueOf(zzcy())).add("CurrentXp", Long.valueOf(zzcz())).add("Type", Integer.valueOf(getType())).add("NewLevel", Integer.valueOf(zzda())).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeString(parcel, 4, this.d, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i, false);
        SafeParcelWriter.writeLong(parcel, 7, this.g);
        SafeParcelWriter.writeLong(parcel, 8, this.h);
        SafeParcelWriter.writeLong(parcel, 9, this.i);
        SafeParcelWriter.writeInt(parcel, 10, this.j);
        SafeParcelWriter.writeInt(parcel, 11, this.k);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzcu() {
        return this.a;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzcv() {
        return this.c;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzcw() {
        return this.d;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzcx() {
        return this.g;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzcy() {
        return this.h;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzcz() {
        return this.i;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int zzda() {
        return this.k;
    }
}
