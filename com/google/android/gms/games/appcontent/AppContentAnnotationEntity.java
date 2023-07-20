package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "AppContentAnnotationEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class AppContentAnnotationEntity extends com.google.android.gms.games.internal.zzd implements zzc {
    public static final Parcelable.Creator<AppContentAnnotationEntity> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getDescription", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getImageUri", id = 2)
    private final Uri b;
    @SafeParcelable.Field(getter = "getTitle", id = 3)
    private final String c;
    @SafeParcelable.Field(getter = "getId", id = 5)
    private final String d;
    @SafeParcelable.Field(getter = "getLayoutSlot", id = 6)
    private final String e;
    @SafeParcelable.Field(getter = "getImageDefaultId", id = 7)
    private final String f;
    @SafeParcelable.Field(getter = "getImageHeight", id = 8)
    private final int g;
    @SafeParcelable.Field(getter = "getImageWidth", id = 9)
    private final int h;
    @SafeParcelable.Field(getter = "getModifiers", id = 10)
    private final Bundle i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AppContentAnnotationEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) Uri uri, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) int i, @SafeParcelable.Param(id = 9) int i2, @SafeParcelable.Param(id = 10) Bundle bundle) {
        this.a = str;
        this.d = str3;
        this.f = str5;
        this.g = i;
        this.b = uri;
        this.h = i2;
        this.e = str4;
        this.i = bundle;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzc) {
            if (this == obj) {
                return true;
            }
            zzc zzcVar = (zzc) obj;
            return Objects.equal(zzcVar.getDescription(), getDescription()) && Objects.equal(zzcVar.getId(), getId()) && Objects.equal(zzcVar.zzac(), zzac()) && Objects.equal(Integer.valueOf(zzcVar.zzad()), Integer.valueOf(zzad())) && Objects.equal(zzcVar.zzae(), zzae()) && Objects.equal(Integer.valueOf(zzcVar.zzag()), Integer.valueOf(zzag())) && Objects.equal(zzcVar.zzah(), zzah()) && com.google.android.gms.games.internal.zzc.zza(zzcVar.zzaf(), zzaf()) && Objects.equal(zzcVar.getTitle(), getTitle());
        }
        return false;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ zzc mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.appcontent.zzc
    public final String getDescription() {
        return this.a;
    }

    @Override // com.google.android.gms.games.appcontent.zzc
    public final String getId() {
        return this.d;
    }

    @Override // com.google.android.gms.games.appcontent.zzc
    public final String getTitle() {
        return this.c;
    }

    public final int hashCode() {
        return Objects.hashCode(getDescription(), getId(), zzac(), Integer.valueOf(zzad()), zzae(), Integer.valueOf(zzag()), zzah(), Integer.valueOf(com.google.android.gms.games.internal.zzc.zza(zzaf())), getTitle());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Description", getDescription()).add("Id", getId()).add("ImageDefaultId", zzac()).add("ImageHeight", Integer.valueOf(zzad())).add("ImageUri", zzae()).add("ImageWidth", Integer.valueOf(zzag())).add("LayoutSlot", zzah()).add("Modifiers", zzaf()).add("Title", getTitle()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeString(parcel, 5, this.d, false);
        SafeParcelWriter.writeString(parcel, 6, this.e, false);
        SafeParcelWriter.writeString(parcel, 7, this.f, false);
        SafeParcelWriter.writeInt(parcel, 8, this.g);
        SafeParcelWriter.writeInt(parcel, 9, this.h);
        SafeParcelWriter.writeBundle(parcel, 10, this.i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.appcontent.zzc
    public final String zzac() {
        return this.f;
    }

    @Override // com.google.android.gms.games.appcontent.zzc
    public final int zzad() {
        return this.g;
    }

    @Override // com.google.android.gms.games.appcontent.zzc
    public final Uri zzae() {
        return this.b;
    }

    @Override // com.google.android.gms.games.appcontent.zzc
    public final Bundle zzaf() {
        return this.i;
    }

    @Override // com.google.android.gms.games.appcontent.zzc
    public final int zzag() {
        return this.h;
    }

    @Override // com.google.android.gms.games.appcontent.zzc
    public final String zzah() {
        return this.e;
    }
}
