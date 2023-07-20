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
@SafeParcelable.Class(creator = "AppContentCardEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class AppContentCardEntity extends com.google.android.gms.games.internal.zzd implements zze {
    public static final Parcelable.Creator<AppContentCardEntity> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getActions", id = 1)
    private final ArrayList<AppContentActionEntity> a;
    @SafeParcelable.Field(getter = "getAnnotations", id = 2)
    private final ArrayList<AppContentAnnotationEntity> b;
    @SafeParcelable.Field(getter = "getConditions", id = 3)
    private final ArrayList<AppContentConditionEntity> c;
    @SafeParcelable.Field(getter = "getContentDescription", id = 4)
    private final String d;
    @SafeParcelable.Field(getter = "getCurrentProgress", id = 5)
    private final int e;
    @SafeParcelable.Field(getter = "getDescription", id = 6)
    private final String f;
    @SafeParcelable.Field(getter = "getExtras", id = 7)
    private final Bundle g;
    @SafeParcelable.Field(getter = "getSubtitle", id = 10)
    private final String h;
    @SafeParcelable.Field(getter = "getTitle", id = 11)
    private final String i;
    @SafeParcelable.Field(getter = "getTotalProgress", id = 12)
    private final int j;
    @SafeParcelable.Field(getter = "getType", id = 13)
    private final String k;
    @SafeParcelable.Field(getter = "getId", id = 14)
    private final String l;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AppContentCardEntity(@SafeParcelable.Param(id = 1) ArrayList<AppContentActionEntity> arrayList, @SafeParcelable.Param(id = 2) ArrayList<AppContentAnnotationEntity> arrayList2, @SafeParcelable.Param(id = 3) ArrayList<AppContentConditionEntity> arrayList3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 11) String str4, @SafeParcelable.Param(id = 12) int i2, @SafeParcelable.Param(id = 13) String str5, @SafeParcelable.Param(id = 14) String str6) {
        this.a = arrayList;
        this.b = arrayList2;
        this.c = arrayList3;
        this.d = str;
        this.e = i;
        this.f = str2;
        this.g = bundle;
        this.l = str6;
        this.h = str3;
        this.i = str4;
        this.j = i2;
        this.k = str5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zze) {
            if (this == obj) {
                return true;
            }
            zze zzeVar = (zze) obj;
            return Objects.equal(zzeVar.getActions(), getActions()) && Objects.equal(zzeVar.zzai(), zzai()) && Objects.equal(zzeVar.zzz(), zzz()) && Objects.equal(zzeVar.zzaa(), zzaa()) && Objects.equal(Integer.valueOf(zzeVar.zzaj()), Integer.valueOf(zzaj())) && Objects.equal(zzeVar.getDescription(), getDescription()) && com.google.android.gms.games.internal.zzc.zza(zzeVar.getExtras(), getExtras()) && Objects.equal(zzeVar.getId(), getId()) && Objects.equal(zzeVar.zzak(), zzak()) && Objects.equal(zzeVar.getTitle(), getTitle()) && Objects.equal(Integer.valueOf(zzeVar.zzal()), Integer.valueOf(zzal())) && Objects.equal(zzeVar.getType(), getType());
        }
        return false;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ zze mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final List<zza> getActions() {
        return new ArrayList(this.a);
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String getDescription() {
        return this.f;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final Bundle getExtras() {
        return this.g;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String getId() {
        return this.l;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String getTitle() {
        return this.i;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String getType() {
        return this.k;
    }

    public final int hashCode() {
        return Objects.hashCode(getActions(), zzai(), zzz(), zzaa(), Integer.valueOf(zzaj()), getDescription(), Integer.valueOf(com.google.android.gms.games.internal.zzc.zza(getExtras())), getId(), zzak(), getTitle(), Integer.valueOf(zzal()), getType());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Actions", getActions()).add("Annotations", zzai()).add("Conditions", zzz()).add("ContentDescription", zzaa()).add("CurrentSteps", Integer.valueOf(zzaj())).add("Description", getDescription()).add("Extras", getExtras()).add("Id", getId()).add("Subtitle", zzak()).add("Title", getTitle()).add("TotalSteps", Integer.valueOf(zzal())).add("Type", getType()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getActions(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, zzai(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, zzz(), false);
        SafeParcelWriter.writeString(parcel, 4, this.d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.e);
        SafeParcelWriter.writeString(parcel, 6, this.f, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.g, false);
        SafeParcelWriter.writeString(parcel, 10, this.h, false);
        SafeParcelWriter.writeString(parcel, 11, this.i, false);
        SafeParcelWriter.writeInt(parcel, 12, this.j);
        SafeParcelWriter.writeString(parcel, 13, this.k, false);
        SafeParcelWriter.writeString(parcel, 14, this.l, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String zzaa() {
        return this.d;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final List<zzc> zzai() {
        return new ArrayList(this.b);
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final int zzaj() {
        return this.e;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String zzak() {
        return this.h;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final int zzal() {
        return this.j;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final List<zzg> zzz() {
        return new ArrayList(this.c);
    }
}
