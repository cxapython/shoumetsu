package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;

/* loaded from: classes.dex */
public class StockProfileImageRef extends DataBufferRef implements StockProfileImage {
    @Override // android.os.Parcelable
    public int describeContents() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public /* synthetic */ StockProfileImage mo28freeze() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public String getImageUrl() {
        return d("image_url");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public final Uri zzae() {
        throw new NoSuchMethodError();
    }
}
