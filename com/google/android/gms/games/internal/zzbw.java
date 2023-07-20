package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PopupLocationInfoParcelableCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzbw extends zzd {
    public static final Parcelable.Creator<zzbw> CREATOR = new zzbx();
    @SafeParcelable.Field(getter = "getInfoBundle", id = 1)
    private final Bundle a;
    @SafeParcelable.Field(getter = "getWindowToken", id = 2)
    private final IBinder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzbw(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) IBinder iBinder) {
        this.a = bundle;
        this.b = iBinder;
    }

    public zzbw(zzca zzcaVar) {
        this.a = zzcaVar.zzcs();
        this.b = zzcaVar.zzju;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.a, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
