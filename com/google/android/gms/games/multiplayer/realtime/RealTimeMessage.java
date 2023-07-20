package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new a();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String a;
    private final byte[] b;
    private final int c;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ RealTimeMessage(Parcel parcel, a aVar) {
        this(parcel);
    }

    private RealTimeMessage(String str, byte[] bArr, int i) {
        this.a = (String) Preconditions.checkNotNull(str);
        this.b = (byte[]) ((byte[]) Preconditions.checkNotNull(bArr)).clone();
        this.c = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final byte[] getMessageData() {
        return this.b;
    }

    public final String getSenderParticipantId() {
        return this.a;
    }

    public final boolean isReliable() {
        return this.c == 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
    }
}
