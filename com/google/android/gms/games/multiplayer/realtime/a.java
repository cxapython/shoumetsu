package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class a implements Parcelable.Creator<RealTimeMessage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RealTimeMessage createFromParcel(Parcel parcel) {
        return new RealTimeMessage(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RealTimeMessage[] newArray(int i) {
        return new RealTimeMessage[i];
    }
}
