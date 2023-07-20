package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "AppContentSectionEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class AppContentSectionEntity extends com.google.android.gms.games.internal.zzd implements zzi {
    public static final Parcelable.Creator<AppContentSectionEntity> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getActions", id = 1)
    private final ArrayList<AppContentActionEntity> a;
    @SafeParcelable.Field(getter = "getCards", id = 3)
    private final ArrayList<AppContentCardEntity> b;
    @SafeParcelable.Field(getter = "getContentDescription", id = 4)
    private final String c;
    @SafeParcelable.Field(getter = "getExtras", id = 5)
    private final Bundle d;
    @SafeParcelable.Field(getter = "getSubtitle", id = 6)
    private final String e;
    @SafeParcelable.Field(getter = "getTitle", id = 7)
    private final String f;
    @SafeParcelable.Field(getter = "getType", id = 8)
    private final String g;
    @SafeParcelable.Field(getter = "getId", id = 9)
    private final String h;
    @SafeParcelable.Field(getter = "getCardType", id = 10)
    private final String i;
    @SafeParcelable.Field(getter = "getAnnotations", id = 14)
    private final ArrayList<AppContentAnnotationEntity> j;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AppContentSectionEntity(@SafeParcelable.Param(id = 1) ArrayList<AppContentActionEntity> arrayList, @SafeParcelable.Param(id = 3) ArrayList<AppContentCardEntity> arrayList2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) Bundle bundle, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) String str4, @SafeParcelable.Param(id = 9) String str5, @SafeParcelable.Param(id = 10) String str6, @SafeParcelable.Param(id = 14) ArrayList<AppContentAnnotationEntity> arrayList3) {
        this.a = arrayList;
        this.j = arrayList3;
        this.b = arrayList2;
        this.i = str6;
        this.c = str;
        this.d = bundle;
        this.h = str5;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzi) {
            if (this == obj) {
                return true;
            }
            zzi zziVar = (zzi) obj;
            return Objects.equal(zziVar.getActions(), getActions()) && Objects.equal(zziVar.zzai(), zzai()) && Objects.equal(zziVar.zzaq(), zzaq()) && Objects.equal(zziVar.zzar(), zzar()) && Objects.equal(zziVar.zzaa(), zzaa()) && com.google.android.gms.games.internal.zzc.zza(zziVar.getExtras(), getExtras()) && Objects.equal(zziVar.getId(), getId()) && Objects.equal(zziVar.zzak(), zzak()) && Objects.equal(zziVar.getTitle(), getTitle()) && Objects.equal(zziVar.getType(), getType());
        }
        return false;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ zzi mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final List<zza> getActions() {
        return new ArrayList(this.a);
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final Bundle getExtras() {
        return this.d;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String getId() {
        return this.h;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String getTitle() {
        return this.f;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String getType() {
        return this.g;
    }

    public final int hashCode() {
        return Objects.hashCode(getActions(), zzai(), zzaq(), zzar(), zzaa(), Integer.valueOf(com.google.android.gms.games.internal.zzc.zza(getExtras())), getId(), zzak(), getTitle(), getType());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Actions", getActions()).add("Annotations", zzai()).add("Cards", zzaq()).add("CardType", zzar()).add("ContentDescription", zzaa()).add("Extras", getExtras()).add("Id", getId()).add("Subtitle", zzak()).add("Title", getTitle()).add("Type", getType()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getActions(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, zzaq(), false);
        SafeParcelWriter.writeString(parcel, 4, this.c, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.d, false);
        SafeParcelWriter.writeString(parcel, 6, this.e, false);
        SafeParcelWriter.writeString(parcel, 7, this.f, false);
        SafeParcelWriter.writeString(parcel, 8, this.g, false);
        SafeParcelWriter.writeString(parcel, 9, this.h, false);
        SafeParcelWriter.writeString(parcel, 10, this.i, false);
        SafeParcelWriter.writeTypedList(parcel, 14, zzai(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String zzaa() {
        return this.c;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final List<zzc> zzai() {
        return new ArrayList(this.j);
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String zzak() {
        return this.e;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final List<zze> zzaq() {
        return new ArrayList(this.b);
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String zzar() {
        return this.i;
    }
}
