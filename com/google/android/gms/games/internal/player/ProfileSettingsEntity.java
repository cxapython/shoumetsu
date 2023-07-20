package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Players;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "ProfileSettingsEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class ProfileSettingsEntity extends com.google.android.gms.games.internal.zzd implements Players.zza {
    public static final Parcelable.Creator<ProfileSettingsEntity> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status a;
    @SafeParcelable.Field(getter = "getGamerTag", id = 2)
    private final String b;
    @SafeParcelable.Field(getter = "isGamerTagExplicitlySet", id = 3)
    private final boolean c;
    @SafeParcelable.Field(getter = "isProfileVisible", id = 4)
    private final boolean d;
    @SafeParcelable.Field(getter = "isVisibilityExplicitlySet", id = 5)
    private final boolean e;
    @SafeParcelable.Field(getter = "getStockProfileImage", id = 6)
    private final StockProfileImageEntity f;
    @SafeParcelable.Field(getter = "isProfileDiscoverable", id = 7)
    private final boolean g;
    @SafeParcelable.Field(getter = "isAutoSignInEnabled", id = 8)
    private final boolean h;
    @SafeParcelable.Field(getter = "getHttpErrorCode", id = 9)
    private final int i;
    @SafeParcelable.Field(getter = "isSettingsChangesProhibited", id = 10)
    private final boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ProfileSettingsEntity(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) StockProfileImageEntity stockProfileImageEntity, @SafeParcelable.Param(id = 7) boolean z4, @SafeParcelable.Param(id = 8) boolean z5, @SafeParcelable.Param(id = 9) int i, @SafeParcelable.Param(id = 10) boolean z6) {
        this.a = status;
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = stockProfileImageEntity;
        this.g = z4;
        this.h = z5;
        this.i = i;
        this.j = z6;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Players.zza)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Players.zza zzaVar = (Players.zza) obj;
        return Objects.equal(this.b, zzaVar.zzh()) && Objects.equal(Boolean.valueOf(this.c), Boolean.valueOf(zzaVar.zzr())) && Objects.equal(Boolean.valueOf(this.d), Boolean.valueOf(zzaVar.zzk())) && Objects.equal(Boolean.valueOf(this.e), Boolean.valueOf(zzaVar.zzp())) && Objects.equal(this.a, zzaVar.getStatus()) && Objects.equal(this.f, zzaVar.zzq()) && Objects.equal(Boolean.valueOf(this.g), Boolean.valueOf(zzaVar.zzs())) && Objects.equal(Boolean.valueOf(this.h), Boolean.valueOf(zzaVar.zzt())) && this.i == zzaVar.zzv() && this.j == zzaVar.zzu();
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.a;
    }

    public int hashCode() {
        return Objects.hashCode(this.b, Boolean.valueOf(this.c), Boolean.valueOf(this.d), Boolean.valueOf(this.e), this.a, this.f, Boolean.valueOf(this.g), Boolean.valueOf(this.h), Integer.valueOf(this.i), Boolean.valueOf(this.j));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("GamerTag", this.b).add("IsGamerTagExplicitlySet", Boolean.valueOf(this.c)).add("IsProfileVisible", Boolean.valueOf(this.d)).add("IsVisibilityExplicitlySet", Boolean.valueOf(this.e)).add("Status", this.a).add("StockProfileImage", this.f).add("IsProfileDiscoverable", Boolean.valueOf(this.g)).add("AutoSignIn", Boolean.valueOf(this.h)).add("httpErrorCode", Integer.valueOf(this.i)).add("IsSettingsChangesProhibited", Boolean.valueOf(this.j)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.e);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.g);
        SafeParcelWriter.writeBoolean(parcel, 8, this.h);
        SafeParcelWriter.writeInt(parcel, 9, this.i);
        SafeParcelWriter.writeBoolean(parcel, 10, this.j);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.Players.zza
    public final String zzh() {
        return this.b;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzk() {
        return this.d;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzp() {
        return this.e;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final StockProfileImage zzq() {
        return this.f;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzr() {
        return this.c;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzs() {
        return this.g;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzt() {
        return this.h;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzu() {
        return this.j;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final int zzv() {
        return this.i;
    }
}
