package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UnsubscribeRequestCreator")
/* loaded from: classes.dex */
public final class zzcg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcg> CREATOR = new zzch();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(getter = "getMessageListenerAsBinder", id = 2, type = "android.os.IBinder")
    private final zzm b;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 3, type = "android.os.IBinder")
    private final zzp c;
    @SafeParcelable.Field(id = 4)
    private final PendingIntent d;
    @SafeParcelable.Field(id = 5)
    @Deprecated
    private final int e;
    @SafeParcelable.Field(id = 6)
    @Deprecated
    private final String f;
    @SafeParcelable.Field(id = 7)
    @Deprecated
    private final String g;
    @SafeParcelable.Field(id = 8)
    @Deprecated
    private final boolean h;
    @SafeParcelable.Field(id = 9)
    @Deprecated
    private final ClientAppContext i;

    @SafeParcelable.Constructor
    public zzcg(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) IBinder iBinder2, @SafeParcelable.Param(id = 4) PendingIntent pendingIntent, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) ClientAppContext clientAppContext) {
        zzm zzoVar;
        this.a = i;
        zzp zzpVar = null;
        if (iBinder == null) {
            zzoVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzoVar = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(iBinder);
        }
        this.b = zzoVar;
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzpVar = queryLocalInterface2 instanceof zzp ? (zzp) queryLocalInterface2 : new zzr(iBinder2);
        }
        this.c = zzpVar;
        this.d = pendingIntent;
        this.e = i2;
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = ClientAppContext.a(clientAppContext, str2, str, z);
    }

    public zzcg(IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent) {
        this(1, iBinder, iBinder2, pendingIntent, 0, null, null, false, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        zzm zzmVar = this.b;
        SafeParcelWriter.writeIBinder(parcel, 2, zzmVar == null ? null : zzmVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.c.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.d, i, false);
        SafeParcelWriter.writeInt(parcel, 5, this.e);
        SafeParcelWriter.writeString(parcel, 6, this.f, false);
        SafeParcelWriter.writeString(parcel, 7, this.g, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.h);
        SafeParcelWriter.writeParcelable(parcel, 9, this.i, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
