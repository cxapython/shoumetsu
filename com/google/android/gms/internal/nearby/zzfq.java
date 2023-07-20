package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "SendConnectionRequestParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzfq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfq> CREATOR = new zzft();
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzdz a;
    @SafeParcelable.Field(getter = "getConnectionEventListenerAsBinder", id = 2, type = "android.os.IBinder")
    private zzdg b;
    @SafeParcelable.Field(getter = "getConnectionResponseListenerAsBinder", id = 3, type = "android.os.IBinder")
    private zzdm c;
    @SafeParcelable.Field(getter = "getName", id = 4)
    private String d;
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 5)
    private String e;
    @SafeParcelable.Field(getter = "getHandshakeData", id = 6)
    private byte[] f;
    @SafeParcelable.Field(getter = "getConnectionLifecycleListenerAsBinder", id = 7, type = "android.os.IBinder")
    private zzdj g;

    private zzfq() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.nearby.zzdz] */
    @SafeParcelable.Constructor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzfq(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) IBinder iBinder2, @SafeParcelable.Param(id = 3) IBinder iBinder3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) byte[] bArr, @SafeParcelable.Param(id = 7) IBinder iBinder4) {
        this(r7, r8, r9, str, str2, bArr, r4);
        zzeb zzebVar;
        zzdg zzdiVar;
        zzdm zzdoVar;
        zzdj zzdjVar = null;
        if (iBinder == null) {
            zzebVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzebVar = queryLocalInterface instanceof zzdz ? (zzdz) queryLocalInterface : new zzeb(iBinder);
        }
        if (iBinder2 == null) {
            zzdiVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            zzdiVar = queryLocalInterface2 instanceof zzdg ? (zzdg) queryLocalInterface2 : new zzdi(iBinder2);
        }
        if (iBinder3 == null) {
            zzdoVar = null;
        } else {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
            zzdoVar = queryLocalInterface3 instanceof zzdm ? (zzdm) queryLocalInterface3 : new zzdo(iBinder3);
        }
        if (iBinder4 != null) {
            IInterface queryLocalInterface4 = iBinder4.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzdjVar = queryLocalInterface4 instanceof zzdj ? (zzdj) queryLocalInterface4 : new zzdl(iBinder4);
        }
    }

    private zzfq(zzdz zzdzVar, zzdg zzdgVar, zzdm zzdmVar, String str, String str2, byte[] bArr, zzdj zzdjVar) {
        this.a = zzdzVar;
        this.b = zzdgVar;
        this.c = zzdmVar;
        this.d = str;
        this.e = str2;
        this.f = bArr;
        this.g = zzdjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfq) {
            zzfq zzfqVar = (zzfq) obj;
            if (Objects.equal(this.a, zzfqVar.a) && Objects.equal(this.b, zzfqVar.b) && Objects.equal(this.c, zzfqVar.c) && Objects.equal(this.d, zzfqVar.d) && Objects.equal(this.e, zzfqVar.e) && Arrays.equals(this.f, zzfqVar.f) && Objects.equal(this.g, zzfqVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b, this.c, this.d, this.e, Integer.valueOf(Arrays.hashCode(this.f)), this.g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdzVar = this.a;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        zzdg zzdgVar = this.b;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdgVar == null ? null : zzdgVar.asBinder(), false);
        zzdm zzdmVar = this.c;
        SafeParcelWriter.writeIBinder(parcel, 3, zzdmVar == null ? null : zzdmVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.d, false);
        SafeParcelWriter.writeString(parcel, 5, this.e, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.f, false);
        zzdj zzdjVar = this.g;
        if (zzdjVar != null) {
            iBinder = zzdjVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 7, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
