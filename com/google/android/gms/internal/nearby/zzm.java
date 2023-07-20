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

@SafeParcelable.Class(creator = "AcceptConnectionRequestParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzp();
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzdz a;
    @SafeParcelable.Field(getter = "getConnectionEventListenerAsBinder", id = 2, type = "android.os.IBinder")
    private zzdg b;
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 3)
    private String c;
    @SafeParcelable.Field(getter = "getHandshakeData", id = 4)
    private byte[] d;
    @SafeParcelable.Field(getter = "getPayloadListenerAsBinder", id = 5, type = "android.os.IBinder")
    private zzdw e;

    private zzm() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.google.android.gms.internal.nearby.zzdz] */
    @SafeParcelable.Constructor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzm(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) IBinder iBinder2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) IBinder iBinder3) {
        this(r3, r4, str, bArr, r0);
        zzeb zzebVar;
        zzdg zzdiVar;
        zzdw zzdwVar = null;
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
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IPayloadListener");
            zzdwVar = queryLocalInterface3 instanceof zzdw ? (zzdw) queryLocalInterface3 : new zzdy(iBinder3);
        }
    }

    private zzm(zzdz zzdzVar, zzdg zzdgVar, String str, byte[] bArr, zzdw zzdwVar) {
        this.a = zzdzVar;
        this.b = zzdgVar;
        this.c = str;
        this.d = bArr;
        this.e = zzdwVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzm) {
            zzm zzmVar = (zzm) obj;
            if (Objects.equal(this.a, zzmVar.a) && Objects.equal(this.b, zzmVar.b) && Objects.equal(this.c, zzmVar.c) && Arrays.equals(this.d, zzmVar.d) && Objects.equal(this.e, zzmVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b, this.c, Integer.valueOf(Arrays.hashCode(this.d)), this.e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdzVar = this.a;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        zzdg zzdgVar = this.b;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdgVar == null ? null : zzdgVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.d, false);
        zzdw zzdwVar = this.e;
        if (zzdwVar != null) {
            iBinder = zzdwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
