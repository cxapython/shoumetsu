package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GetPermissionStatusRequestCreator")
@Deprecated
/* loaded from: classes.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private final zzp b;
    @SafeParcelable.Field(id = 3)
    @Deprecated
    private final String c;
    @SafeParcelable.Field(id = 4)
    @Deprecated
    private final ClientAppContext d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzh(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) ClientAppContext clientAppContext) {
        zzp zzrVar;
        this.a = i;
        if (iBinder == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.b = zzrVar;
        this.c = str;
        this.d = ClientAppContext.a(clientAppContext, null, str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(IBinder iBinder) {
        this(1, iBinder, null, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeIBinder(parcel, 2, this.b.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.d, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
