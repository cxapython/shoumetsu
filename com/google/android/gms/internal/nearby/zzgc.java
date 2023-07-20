package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

@SafeParcelable.Class(creator = "StartDiscoveryParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzgc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgc> CREATOR = new zzgf();
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzdz a;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private zzdp b;
    @SafeParcelable.Field(getter = "getServiceId", id = 3)
    private String c;
    @SafeParcelable.Field(getter = "getDurationMillis", id = 4)
    private long d;
    @SafeParcelable.Field(getter = "getOptions", id = 5)
    private DiscoveryOptions e;
    @SafeParcelable.Field(getter = "getDiscoveryListenerAsBinder", id = 6, type = "android.os.IBinder")
    private zzdr f;

    private zzgc() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.nearby.zzdz] */
    @SafeParcelable.Constructor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzgc(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) IBinder iBinder2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) DiscoveryOptions discoveryOptions, @SafeParcelable.Param(id = 6) IBinder iBinder3) {
        this(r6, r7, str, j, discoveryOptions, r3);
        zzeb zzebVar;
        zzdp zzdqVar;
        zzdr zzdrVar = null;
        if (iBinder == null) {
            zzebVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzebVar = queryLocalInterface instanceof zzdz ? (zzdz) queryLocalInterface : new zzeb(iBinder);
        }
        if (iBinder2 == null) {
            zzdqVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryCallback");
            zzdqVar = queryLocalInterface2 instanceof zzdp ? (zzdp) queryLocalInterface2 : new zzdq(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
            zzdrVar = queryLocalInterface3 instanceof zzdr ? (zzdr) queryLocalInterface3 : new zzdt(iBinder3);
        }
    }

    private zzgc(zzdz zzdzVar, zzdp zzdpVar, String str, long j, DiscoveryOptions discoveryOptions, zzdr zzdrVar) {
        this.a = zzdzVar;
        this.b = zzdpVar;
        this.c = str;
        this.d = j;
        this.e = discoveryOptions;
        this.f = zzdrVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgc) {
            zzgc zzgcVar = (zzgc) obj;
            if (Objects.equal(this.a, zzgcVar.a) && Objects.equal(this.b, zzgcVar.b) && Objects.equal(this.c, zzgcVar.c) && Objects.equal(Long.valueOf(this.d), Long.valueOf(zzgcVar.d)) && Objects.equal(this.e, zzgcVar.e) && Objects.equal(this.f, zzgcVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b, this.c, Long.valueOf(this.d), this.e, this.f);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdzVar = this.a;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        zzdp zzdpVar = this.b;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdpVar == null ? null : zzdpVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeLong(parcel, 4, this.d);
        SafeParcelWriter.writeParcelable(parcel, 5, this.e, i, false);
        zzdr zzdrVar = this.f;
        if (zzdrVar != null) {
            iBinder = zzdrVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
