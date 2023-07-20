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

@SafeParcelable.Class(creator = "SendPayloadParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzfu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfu> CREATOR = new zzfx();
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzdz a;
    @SafeParcelable.Field(getter = "getRemoteEndpointIds", id = 2)
    private String[] b;
    @SafeParcelable.Field(getter = "getPayload", id = 3)
    private zzfh c;
    @SafeParcelable.Field(getter = "getSendReliably", id = 4)
    private boolean d;

    private zzfu() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    @SafeParcelable.Constructor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzfu(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) zzfh zzfhVar, @SafeParcelable.Param(id = 4) boolean z) {
        this(r3, strArr, zzfhVar, z);
        zzdz zzebVar;
        if (iBinder == null) {
            zzebVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzebVar = queryLocalInterface instanceof zzdz ? (zzdz) queryLocalInterface : new zzeb(iBinder);
        }
    }

    private zzfu(zzdz zzdzVar, String[] strArr, zzfh zzfhVar, boolean z) {
        this.a = zzdzVar;
        this.b = strArr;
        this.c = zzfhVar;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfu) {
            zzfu zzfuVar = (zzfu) obj;
            if (Objects.equal(this.a, zzfuVar.a) && Arrays.equals(this.b, zzfuVar.b) && Objects.equal(this.c, zzfuVar.c) && Objects.equal(Boolean.valueOf(this.d), Boolean.valueOf(zzfuVar.d))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, Integer.valueOf(Arrays.hashCode(this.b)), this.c, Boolean.valueOf(this.d));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdzVar = this.a;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.c, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
