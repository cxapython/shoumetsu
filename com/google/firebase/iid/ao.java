package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class ao implements Parcelable.Creator<ap> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ap createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new ap(readStrongBinder);
        }
        return null;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ap[] newArray(int i) {
        return new ap[i];
    }
}
