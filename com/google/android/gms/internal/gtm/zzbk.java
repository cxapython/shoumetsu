package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class zzbk implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<zzbk> CREATOR = new u();
    private String a;
    private String b;
    private String c;

    @Deprecated
    public zzbk() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public zzbk(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    @Deprecated
    public final int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.a;
    }

    public final String getValue() {
        return this.c;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
