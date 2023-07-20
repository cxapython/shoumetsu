package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class ay implements az {
    private final IBinder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // com.google.firebase.iid.az
    public final void a(Message message) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        obtain.writeInt(1);
        message.writeToParcel(obtain, 0);
        try {
            this.a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
