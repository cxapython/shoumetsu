package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.messages.Strategy;

@SafeParcelable.Class(creator = "PublishRequestCreator")
/* loaded from: classes.dex */
public final class zzbz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbz> CREATOR = new zzca();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(id = 2)
    private final zzaf b;
    @SafeParcelable.Field(id = 3)
    private final Strategy c;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 4, type = "android.os.IBinder")
    private final zzp d;
    @SafeParcelable.Field(id = 5)
    @Deprecated
    private final String e;
    @SafeParcelable.Field(id = 6)
    @Deprecated
    private final String f;
    @SafeParcelable.Field(id = 7)
    @Deprecated
    private final boolean g;
    @SafeParcelable.Field(getter = "getPublishCallbackAsBinder", id = 8, type = "android.os.IBinder")
    private final zzu h;
    @SafeParcelable.Field(id = 9)
    @Deprecated
    private final boolean i;
    @SafeParcelable.Field(id = 10)
    @Deprecated
    private final ClientAppContext j;
    @SafeParcelable.Field(id = 11)
    private final int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzbz(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) zzaf zzafVar, @SafeParcelable.Param(id = 3) Strategy strategy, @SafeParcelable.Param(id = 4) IBinder iBinder, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) IBinder iBinder2, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) ClientAppContext clientAppContext, @SafeParcelable.Param(id = 11) int i2) {
        zzp zzrVar;
        this.a = i;
        this.b = zzafVar;
        this.c = strategy;
        zzu zzuVar = null;
        if (iBinder == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.d = zzrVar;
        this.e = str;
        this.f = str2;
        this.g = z;
        if (iBinder2 != null && iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            zzuVar = queryLocalInterface2 instanceof zzu ? (zzu) queryLocalInterface2 : new zzw(iBinder2);
        }
        this.h = zzuVar;
        this.i = z2;
        this.j = ClientAppContext.a(clientAppContext, str2, str, z2);
        this.k = i2;
    }

    @VisibleForTesting
    public zzbz(zzaf zzafVar, Strategy strategy, IBinder iBinder, IBinder iBinder2, int i) {
        this(2, zzafVar, strategy, iBinder, null, null, false, iBinder2, false, null, i);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.c, i, false);
        SafeParcelWriter.writeIBinder(parcel, 4, this.d.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 5, this.e, false);
        SafeParcelWriter.writeString(parcel, 6, this.f, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.g);
        zzu zzuVar = this.h;
        SafeParcelWriter.writeIBinder(parcel, 8, zzuVar == null ? null : zzuVar.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.i);
        SafeParcelWriter.writeParcelable(parcel, 10, this.j, i, false);
        SafeParcelWriter.writeInt(parcel, 11, this.k);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
