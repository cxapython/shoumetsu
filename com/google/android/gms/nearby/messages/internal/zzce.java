package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

@SafeParcelable.Class(creator = "UnpublishRequestCreator")
/* loaded from: classes.dex */
public final class zzce extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzce> CREATOR = new zzcf();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(id = 2)
    private final zzaf b;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 3, type = "android.os.IBinder")
    private final zzp c;
    @SafeParcelable.Field(id = 4)
    @Deprecated
    private final String d;
    @SafeParcelable.Field(id = 5)
    @Deprecated
    private final String e;
    @SafeParcelable.Field(id = 6)
    @Deprecated
    private final boolean f;
    @SafeParcelable.Field(id = 7)
    @Deprecated
    private final ClientAppContext g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzce(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) zzaf zzafVar, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) ClientAppContext clientAppContext) {
        zzp zzrVar;
        this.a = i;
        this.b = zzafVar;
        if (iBinder == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.c = zzrVar;
        this.d = str;
        this.e = str2;
        this.f = z;
        this.g = ClientAppContext.a(clientAppContext, str2, str, z);
    }

    @VisibleForTesting
    public zzce(zzaf zzafVar, IBinder iBinder) {
        this(1, zzafVar, iBinder, null, null, false, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.c.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.d, false);
        SafeParcelWriter.writeString(parcel, 5, this.e, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f);
        SafeParcelWriter.writeParcelable(parcel, 7, this.g, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
