package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "CancelPayloadParamsCreator")
/* loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzt();
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzdz a;
    @SafeParcelable.Field(getter = "getPayloadId", id = 2)
    private long b;

    private zzq() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    @SafeParcelable.Constructor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzq(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) long j) {
        this(r3, j);
        zzdz zzebVar;
        if (iBinder == null) {
            zzebVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzebVar = queryLocalInterface instanceof zzdz ? (zzdz) queryLocalInterface : new zzeb(iBinder);
        }
    }

    private zzq(zzdz zzdzVar, long j) {
        this.a = zzdzVar;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzq) {
            zzq zzqVar = (zzq) obj;
            if (Objects.equal(this.a, zzqVar.a) && Objects.equal(Long.valueOf(this.b), Long.valueOf(zzqVar.b))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, Long.valueOf(this.b));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdzVar = this.a;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        SafeParcelWriter.writeLong(parcel, 2, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
