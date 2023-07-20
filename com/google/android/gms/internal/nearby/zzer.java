package com.google.android.gms.internal.nearby;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnEndpointFoundParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzer extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzer> CREATOR = new zzes();
    @SafeParcelable.Field(getter = "getEndpointId", id = 1)
    private String a;
    @SafeParcelable.Field(getter = "getServiceId", id = 2)
    private String b;
    @SafeParcelable.Field(getter = "getEndpointName", id = 3)
    private String c;
    @SafeParcelable.Field(getter = "getBluetoothDevice", id = 4)
    private BluetoothDevice d;

    private zzer() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzer(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) BluetoothDevice bluetoothDevice) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = bluetoothDevice;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzer) {
            zzer zzerVar = (zzer) obj;
            if (Objects.equal(this.a, zzerVar.a) && Objects.equal(this.b, zzerVar.b) && Objects.equal(this.c, zzerVar.c) && Objects.equal(this.d, zzerVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final String getEndpointName() {
        return this.c;
    }

    public final String getServiceId() {
        return this.b;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b, this.c, this.d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.d, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zze() {
        return this.a;
    }

    public final BluetoothDevice zzk() {
        return this.d;
    }
}
