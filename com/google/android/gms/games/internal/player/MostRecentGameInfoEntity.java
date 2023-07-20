package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "MostRecentGameInfoEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class MostRecentGameInfoEntity extends com.google.android.gms.games.internal.zzd implements zza {
    public static final Parcelable.Creator<MostRecentGameInfoEntity> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getGameId", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getGameName", id = 2)
    private final String b;
    @SafeParcelable.Field(getter = "getActivityTimestampMillis", id = 3)
    private final long c;
    @SafeParcelable.Field(getter = "getGameIconImageUri", id = 4)
    private final Uri d;
    @SafeParcelable.Field(getter = "getGameHiResImageUri", id = 5)
    private final Uri e;
    @SafeParcelable.Field(getter = "getGameFeaturedImageUri", id = 6)
    private final Uri f;

    public MostRecentGameInfoEntity(zza zzaVar) {
        this.a = zzaVar.zzdb();
        this.b = zzaVar.zzdc();
        this.c = zzaVar.zzdd();
        this.d = zzaVar.zzde();
        this.e = zzaVar.zzdf();
        this.f = zzaVar.zzdg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public MostRecentGameInfoEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) Uri uri, @SafeParcelable.Param(id = 5) Uri uri2, @SafeParcelable.Param(id = 6) Uri uri3) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = uri;
        this.e = uri2;
        this.f = uri3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zza zzaVar) {
        return Objects.hashCode(zzaVar.zzdb(), zzaVar.zzdc(), Long.valueOf(zzaVar.zzdd()), zzaVar.zzde(), zzaVar.zzdf(), zzaVar.zzdg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zza zzaVar, Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (zzaVar == obj) {
            return true;
        }
        zza zzaVar2 = (zza) obj;
        return Objects.equal(zzaVar2.zzdb(), zzaVar.zzdb()) && Objects.equal(zzaVar2.zzdc(), zzaVar.zzdc()) && Objects.equal(Long.valueOf(zzaVar2.zzdd()), Long.valueOf(zzaVar.zzdd())) && Objects.equal(zzaVar2.zzde(), zzaVar.zzde()) && Objects.equal(zzaVar2.zzdf(), zzaVar.zzdf()) && Objects.equal(zzaVar2.zzdg(), zzaVar.zzdg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(zza zzaVar) {
        return Objects.toStringHelper(zzaVar).add("GameId", zzaVar.zzdb()).add("GameName", zzaVar.zzdc()).add("ActivityTimestampMillis", Long.valueOf(zzaVar.zzdd())).add("GameIconUri", zzaVar.zzde()).add("GameHiResUri", zzaVar.zzdf()).add("GameFeaturedUri", zzaVar.zzdg()).toString();
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ zza mo28freeze() {
        return this;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeLong(parcel, 3, this.c);
        SafeParcelWriter.writeParcelable(parcel, 4, this.d, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.e, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzdb() {
        return this.a;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzdc() {
        return this.b;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final long zzdd() {
        return this.c;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzde() {
        return this.d;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdf() {
        return this.e;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdg() {
        return this.f;
    }
}
