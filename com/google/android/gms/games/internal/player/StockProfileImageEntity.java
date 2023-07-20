package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "StockProfileImageEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class StockProfileImageEntity extends com.google.android.gms.games.internal.zzd implements StockProfileImage {
    public static final Parcelable.Creator<StockProfileImageEntity> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getImageUrl", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getImageUri", id = 2)
    private final Uri b;

    @SafeParcelable.Constructor
    public StockProfileImageEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) Uri uri) {
        this.a = str;
        this.b = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StockProfileImage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        StockProfileImage stockProfileImage = (StockProfileImage) obj;
        return Objects.equal(this.a, stockProfileImage.getImageUrl()) && Objects.equal(this.b, stockProfileImage.zzae());
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ StockProfileImage mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public final String getImageUrl() {
        return this.a;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("ImageId", this.a).add("ImageUri", this.b).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public final Uri zzae() {
        return this.b;
    }
}
