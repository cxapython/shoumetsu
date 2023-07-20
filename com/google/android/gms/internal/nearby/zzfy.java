package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

@SafeParcelable.Class(creator = "StartAdvertisingParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzfy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfy> CREATOR = new zzgb();
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzec a;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private zzdd b;
    @SafeParcelable.Field(getter = "getName", id = 3)
    private String c;
    @SafeParcelable.Field(getter = "getServiceId", id = 4)
    private String d;
    @SafeParcelable.Field(getter = "getDurationMillis", id = 5)
    private long e;
    @SafeParcelable.Field(getter = "getOptions", id = 6)
    private AdvertisingOptions f;
    @SafeParcelable.Field(getter = "getConnectionLifecycleListenerAsBinder", id = 7, type = "android.os.IBinder")
    private zzdj g;

    private zzfy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.nearby.zzec] */
    @SafeParcelable.Constructor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzfy(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) IBinder iBinder2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) AdvertisingOptions advertisingOptions, @SafeParcelable.Param(id = 7) IBinder iBinder3) {
        this(r6, r7, str, str2, j, advertisingOptions, r3);
        zzee zzeeVar;
        zzdd zzdfVar;
        zzdj zzdjVar = null;
        if (iBinder == null) {
            zzeeVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
            zzeeVar = queryLocalInterface instanceof zzec ? (zzec) queryLocalInterface : new zzee(iBinder);
        }
        if (iBinder2 == null) {
            zzdfVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
            zzdfVar = queryLocalInterface2 instanceof zzdd ? (zzdd) queryLocalInterface2 : new zzdf(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzdjVar = queryLocalInterface3 instanceof zzdj ? (zzdj) queryLocalInterface3 : new zzdl(iBinder3);
        }
    }

    private zzfy(zzec zzecVar, zzdd zzddVar, String str, String str2, long j, AdvertisingOptions advertisingOptions, zzdj zzdjVar) {
        this.a = zzecVar;
        this.b = zzddVar;
        this.c = str;
        this.d = str2;
        this.e = j;
        this.f = advertisingOptions;
        this.g = zzdjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfy) {
            zzfy zzfyVar = (zzfy) obj;
            if (Objects.equal(this.a, zzfyVar.a) && Objects.equal(this.b, zzfyVar.b) && Objects.equal(this.c, zzfyVar.c) && Objects.equal(this.d, zzfyVar.d) && Objects.equal(Long.valueOf(this.e), Long.valueOf(zzfyVar.e)) && Objects.equal(this.f, zzfyVar.f) && Objects.equal(this.g, zzfyVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b, this.c, this.d, Long.valueOf(this.e), this.f, this.g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzec zzecVar = this.a;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzecVar == null ? null : zzecVar.asBinder(), false);
        zzdd zzddVar = this.b;
        SafeParcelWriter.writeIBinder(parcel, 2, zzddVar == null ? null : zzddVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeString(parcel, 4, this.d, false);
        SafeParcelWriter.writeLong(parcel, 5, this.e);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i, false);
        zzdj zzdjVar = this.g;
        if (zzdjVar != null) {
            iBinder = zzdjVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 7, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
