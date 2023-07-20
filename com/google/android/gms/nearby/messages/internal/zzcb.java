package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

@SafeParcelable.Class(creator = "RegisterStatusCallbackRequestCreator")
/* loaded from: classes.dex */
public final class zzcb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcb> CREATOR = new zzcc();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private final zzp b;
    @SafeParcelable.Field(getter = "getStatusCallbackAsBinder", id = 3, type = "android.os.IBinder")
    private final zzx c;
    @SafeParcelable.Field(id = 5)
    @Deprecated
    private String d;
    @SafeParcelable.Field(id = 6)
    @Deprecated
    private final ClientAppContext e;
    @SafeParcelable.Field(id = 4)
    public boolean zzix;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzcb(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) IBinder iBinder2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) ClientAppContext clientAppContext) {
        zzp zzrVar;
        zzx zzzVar;
        this.a = i;
        if (iBinder == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.b = zzrVar;
        if (iBinder2 == null) {
            zzzVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            zzzVar = queryLocalInterface2 instanceof zzx ? (zzx) queryLocalInterface2 : new zzz(iBinder2);
        }
        this.c = zzzVar;
        this.zzix = z;
        this.d = str;
        this.e = ClientAppContext.a(clientAppContext, null, str, false);
    }

    @VisibleForTesting
    public zzcb(IBinder iBinder, IBinder iBinder2) {
        this(1, iBinder, iBinder2, false, null, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeIBinder(parcel, 2, this.b.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.c.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzix);
        SafeParcelWriter.writeString(parcel, 5, this.d, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.e, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
