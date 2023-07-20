package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "AppContentConditionEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class AppContentConditionEntity extends com.google.android.gms.games.internal.zzd implements zzg {
    public static final Parcelable.Creator<AppContentConditionEntity> CREATOR = new zzh();
    @SafeParcelable.Field(getter = "getDefaultValue", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getExpectedValue", id = 2)
    private final String b;
    @SafeParcelable.Field(getter = "getPredicate", id = 3)
    private final String c;
    @SafeParcelable.Field(getter = "getPredicateParameters", id = 4)
    private final Bundle d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AppContentConditionEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = bundle;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzg) {
            if (this == obj) {
                return true;
            }
            zzg zzgVar = (zzg) obj;
            return Objects.equal(zzgVar.zzam(), zzam()) && Objects.equal(zzgVar.zzan(), zzan()) && Objects.equal(zzgVar.zzao(), zzao()) && Objects.equal(zzgVar.zzap(), zzap());
        }
        return false;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ zzg mo28freeze() {
        return this;
    }

    public final int hashCode() {
        return Objects.hashCode(zzam(), zzan(), zzao(), zzap());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("DefaultValue", zzam()).add("ExpectedValue", zzan()).add("Predicate", zzao()).add("PredicateParameters", zzap()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.appcontent.zzg
    public final String zzam() {
        return this.a;
    }

    @Override // com.google.android.gms.games.appcontent.zzg
    public final String zzan() {
        return this.b;
    }

    @Override // com.google.android.gms.games.appcontent.zzg
    public final String zzao() {
        return this.c;
    }

    @Override // com.google.android.gms.games.appcontent.zzg
    public final Bundle zzap() {
        return this.d;
    }
}
