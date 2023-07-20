package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "BleFilterCreator")
/* loaded from: classes.dex */
public final class zzgp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgp> CREATOR = new zzgq();
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int a;
    @SafeParcelable.Field(getter = "getServiceUuid", id = 4)
    private final ParcelUuid b;
    @SafeParcelable.Field(getter = "getServiceUuidMask", id = 5)
    private final ParcelUuid c;
    @SafeParcelable.Field(getter = "getServiceDataUuid", id = 6)
    private final ParcelUuid d;
    @SafeParcelable.Field(getter = "getServiceData", id = 7)
    private final byte[] e;
    @SafeParcelable.Field(getter = "getServiceDataMask", id = 8)
    private final byte[] f;
    @SafeParcelable.Field(getter = "getManufacturerId", id = 9)
    private final int g;
    @SafeParcelable.Field(getter = "getManufacturerData", id = 10)
    private final byte[] h;
    @SafeParcelable.Field(getter = "getManufacturerDataMask", id = 11)
    private final byte[] i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzgp(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 4) ParcelUuid parcelUuid, @SafeParcelable.Param(id = 5) ParcelUuid parcelUuid2, @SafeParcelable.Param(id = 6) ParcelUuid parcelUuid3, @SafeParcelable.Param(id = 7) byte[] bArr, @SafeParcelable.Param(id = 8) byte[] bArr2, @SafeParcelable.Param(id = 9) int i2, @SafeParcelable.Param(id = 10) byte[] bArr3, @SafeParcelable.Param(id = 11) byte[] bArr4) {
        this.a = i;
        this.b = parcelUuid;
        this.c = parcelUuid2;
        this.d = parcelUuid3;
        this.e = bArr;
        this.f = bArr2;
        this.g = i2;
        this.h = bArr3;
        this.i = bArr4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzgp zzgpVar = (zzgp) obj;
            if (this.g == zzgpVar.g && Arrays.equals(this.h, zzgpVar.h) && Arrays.equals(this.i, zzgpVar.i) && Objects.equal(this.d, zzgpVar.d) && Arrays.equals(this.e, zzgpVar.e) && Arrays.equals(this.f, zzgpVar.f) && Objects.equal(this.b, zzgpVar.b) && Objects.equal(this.c, zzgpVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.g), Integer.valueOf(Arrays.hashCode(this.h)), Integer.valueOf(Arrays.hashCode(this.i)), this.d, Integer.valueOf(Arrays.hashCode(this.e)), Integer.valueOf(Arrays.hashCode(this.f)), this.b, this.c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeParcelable(parcel, 4, this.b, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.c, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.d, i, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.e, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.f, false);
        SafeParcelWriter.writeInt(parcel, 9, this.g);
        SafeParcelWriter.writeByteArray(parcel, 10, this.h, false);
        SafeParcelWriter.writeByteArray(parcel, 11, this.i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
