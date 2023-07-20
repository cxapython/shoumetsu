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
@SafeParcelable.Class(creator = "AppContentActionEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class AppContentActionEntity extends com.google.android.gms.games.internal.zzd implements zza {
    public static final Parcelable.Creator<AppContentActionEntity> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getConditions", id = 1)
    private final ArrayList<AppContentConditionEntity> a;
    @SafeParcelable.Field(getter = "getContentDescription", id = 2)
    private final String b;
    @SafeParcelable.Field(getter = "getExtras", id = 3)
    private final Bundle c;
    @SafeParcelable.Field(getter = "getType", id = 6)
    private final String d;
    @SafeParcelable.Field(getter = "getId", id = 7)
    private final String e;
    @SafeParcelable.Field(getter = "getAnnotation", id = 8)
    private final AppContentAnnotationEntity f;
    @SafeParcelable.Field(getter = "getOverflowText", id = 9)
    private final String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AppContentActionEntity(@SafeParcelable.Param(id = 1) ArrayList<AppContentConditionEntity> arrayList, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) AppContentAnnotationEntity appContentAnnotationEntity, @SafeParcelable.Param(id = 9) String str4) {
        this.f = appContentAnnotationEntity;
        this.a = arrayList;
        this.b = str;
        this.c = bundle;
        this.e = str3;
        this.g = str4;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zza) {
            if (this == obj) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return Objects.equal(zzaVar.zzy(), zzy()) && Objects.equal(zzaVar.zzz(), zzz()) && Objects.equal(zzaVar.zzaa(), zzaa()) && com.google.android.gms.games.internal.zzc.zza(zzaVar.getExtras(), getExtras()) && Objects.equal(zzaVar.getId(), getId()) && Objects.equal(zzaVar.zzab(), zzab()) && Objects.equal(zzaVar.getType(), getType());
        }
        return false;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ zza mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final Bundle getExtras() {
        return this.c;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final String getId() {
        return this.e;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final String getType() {
        return this.d;
    }

    public final int hashCode() {
        return Objects.hashCode(zzy(), zzz(), zzaa(), Integer.valueOf(com.google.android.gms.games.internal.zzc.zza(getExtras())), getId(), zzab(), getType());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Annotation", zzy()).add("Conditions", zzz()).add("ContentDescription", zzaa()).add("Extras", getExtras()).add("Id", getId()).add("OverflowText", zzab()).add("Type", getType()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, zzz(), false);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeBundle(parcel, 3, this.c, false);
        SafeParcelWriter.writeString(parcel, 6, this.d, false);
        SafeParcelWriter.writeString(parcel, 7, this.e, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.f, i, false);
        SafeParcelWriter.writeString(parcel, 9, this.g, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final String zzaa() {
        return this.b;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final String zzab() {
        return this.g;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final zzc zzy() {
        return this.f;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final List<zzg> zzz() {
        return new ArrayList(this.a);
    }
}
