package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

@SafeParcelable.Class(creator = "SubscribeRequestCreator")
/* loaded from: classes.dex */
public final class SubscribeRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzcd();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(getter = "getMessageListenerAsBinder", id = 2, type = "android.os.IBinder")
    private final zzm b;
    @SafeParcelable.Field(id = 3)
    private final Strategy c;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 4, type = "android.os.IBinder")
    private final zzp d;
    @SafeParcelable.Field(id = 5)
    private final MessageFilter e;
    @SafeParcelable.Field(id = 6)
    private final PendingIntent f;
    @SafeParcelable.Field(id = 7)
    @Deprecated
    private final int g;
    @SafeParcelable.Field(id = 8)
    @Deprecated
    private final String h;
    @SafeParcelable.Field(id = 9)
    @Deprecated
    private final String i;
    @SafeParcelable.Field(id = 10)
    private final byte[] j;
    @SafeParcelable.Field(id = 11)
    @Deprecated
    private final boolean k;
    @SafeParcelable.Field(getter = "getSubscribeCallbackAsBinder", id = 12, type = "android.os.IBinder")
    private final zzaa l;
    @SafeParcelable.Field(id = 13)
    @Deprecated
    private final boolean m;
    @SafeParcelable.Field(id = 14)
    @Deprecated
    private final ClientAppContext n;
    @SafeParcelable.Field(id = 15)
    private final boolean o;
    @SafeParcelable.Field(id = 16)
    private final int p;
    @SafeParcelable.Field(id = 17)
    private final int q;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public SubscribeRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) Strategy strategy, @SafeParcelable.Param(id = 4) IBinder iBinder2, @SafeParcelable.Param(id = 5) MessageFilter messageFilter, @SafeParcelable.Param(id = 6) PendingIntent pendingIntent, @SafeParcelable.Param(id = 7) int i2, @SafeParcelable.Param(id = 8) String str, @SafeParcelable.Param(id = 9) String str2, @SafeParcelable.Param(id = 10) byte[] bArr, @SafeParcelable.Param(id = 11) boolean z, @SafeParcelable.Param(id = 12) IBinder iBinder3, @SafeParcelable.Param(id = 13) boolean z2, @SafeParcelable.Param(id = 14) ClientAppContext clientAppContext, @SafeParcelable.Param(id = 15) boolean z3, @SafeParcelable.Param(id = 16) int i3, @SafeParcelable.Param(id = 17) int i4) {
        zzm zzoVar;
        zzp zzrVar;
        this.a = i;
        zzaa zzaaVar = null;
        if (iBinder == null) {
            zzoVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzoVar = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(iBinder);
        }
        this.b = zzoVar;
        this.c = strategy;
        if (iBinder2 == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface2 instanceof zzp ? (zzp) queryLocalInterface2 : new zzr(iBinder2);
        }
        this.d = zzrVar;
        this.e = messageFilter;
        this.f = pendingIntent;
        this.g = i2;
        this.h = str;
        this.i = str2;
        this.j = bArr;
        this.k = z;
        if (iBinder3 != null && iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            zzaaVar = queryLocalInterface3 instanceof zzaa ? (zzaa) queryLocalInterface3 : new zzac(iBinder3);
        }
        this.l = zzaaVar;
        this.m = z2;
        this.n = ClientAppContext.a(clientAppContext, str2, str, z2);
        this.o = z3;
        this.p = i3;
        this.q = i4;
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i) {
        this(iBinder, strategy, iBinder2, messageFilter, null, bArr, iBinder3, z, 0, i);
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i, int i2) {
        this(3, iBinder, strategy, iBinder2, messageFilter, pendingIntent, 0, null, null, bArr, false, iBinder3, false, null, z, i, i2);
    }

    public final String toString() {
        String sb;
        String valueOf = String.valueOf(this.b);
        String valueOf2 = String.valueOf(this.c);
        String valueOf3 = String.valueOf(this.d);
        String valueOf4 = String.valueOf(this.e);
        String valueOf5 = String.valueOf(this.f);
        byte[] bArr = this.j;
        if (bArr == null) {
            sb = null;
        } else {
            int length = bArr.length;
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("<");
            sb2.append(length);
            sb2.append(" bytes>");
            sb = sb2.toString();
        }
        String valueOf6 = String.valueOf(this.l);
        boolean z = this.m;
        String valueOf7 = String.valueOf(this.n);
        boolean z2 = this.o;
        String str = this.h;
        String str2 = this.i;
        boolean z3 = this.k;
        int i = this.q;
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 291 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(sb).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(str).length() + String.valueOf(str2).length());
        sb3.append("SubscribeRequest{messageListener=");
        sb3.append(valueOf);
        sb3.append(", strategy=");
        sb3.append(valueOf2);
        sb3.append(", callback=");
        sb3.append(valueOf3);
        sb3.append(", filter=");
        sb3.append(valueOf4);
        sb3.append(", pendingIntent=");
        sb3.append(valueOf5);
        sb3.append(", hint=");
        sb3.append(sb);
        sb3.append(", subscribeCallback=");
        sb3.append(valueOf6);
        sb3.append(", useRealClientApiKey=");
        sb3.append(z);
        sb3.append(", clientAppContext=");
        sb3.append(valueOf7);
        sb3.append(", isDiscardPendingIntent=");
        sb3.append(z2);
        sb3.append(", zeroPartyPackageName=");
        sb3.append(str);
        sb3.append(", realClientPackageName=");
        sb3.append(str2);
        sb3.append(", isIgnoreNearbyPermission=");
        sb3.append(z3);
        sb3.append(", callingContext=");
        sb3.append(i);
        sb3.append("}");
        return sb3.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        zzm zzmVar = this.b;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 2, zzmVar == null ? null : zzmVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.c, i, false);
        zzp zzpVar = this.d;
        SafeParcelWriter.writeIBinder(parcel, 4, zzpVar == null ? null : zzpVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.e, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i, false);
        SafeParcelWriter.writeInt(parcel, 7, this.g);
        SafeParcelWriter.writeString(parcel, 8, this.h, false);
        SafeParcelWriter.writeString(parcel, 9, this.i, false);
        SafeParcelWriter.writeByteArray(parcel, 10, this.j, false);
        SafeParcelWriter.writeBoolean(parcel, 11, this.k);
        zzaa zzaaVar = this.l;
        if (zzaaVar != null) {
            iBinder = zzaaVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 12, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 13, this.m);
        SafeParcelWriter.writeParcelable(parcel, 14, this.n, i, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.o);
        SafeParcelWriter.writeInt(parcel, 16, this.p);
        SafeParcelWriter.writeInt(parcel, 17, this.q);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
