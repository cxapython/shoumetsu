package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: classes.dex */
public class ap implements Parcelable {
    public static final Parcelable.Creator<ap> CREATOR = new ao();
    private Messenger a;
    private az b;

    /* loaded from: classes.dex */
    public static final class a extends ClassLoader {
        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) {
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                if (!FirebaseInstanceId.e()) {
                    return ap.class;
                }
                Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
                return ap.class;
            }
            return super.loadClass(str, z);
        }
    }

    public ap(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.a = new Messenger(iBinder);
        } else {
            this.b = new ay(iBinder);
        }
    }

    private final IBinder a() {
        Messenger messenger = this.a;
        return messenger != null ? messenger.getBinder() : this.b.asBinder();
    }

    public final void a(Message message) {
        Messenger messenger = this.a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.b.a(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((ap) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.a;
        parcel.writeStrongBinder(messenger != null ? messenger.getBinder() : this.b.asBinder());
    }
}
