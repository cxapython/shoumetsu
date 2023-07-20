package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NearbyDeviceCreator")
/* loaded from: classes.dex */
public final class zzgs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgs> CREATOR = new zzgt();
    private static final String a = null;
    public static final zzgs zzgv = new zzgs("", null);
    @SafeParcelable.VersionField(id = 1000)
    private final int b;
    @SafeParcelable.Field(getter = "getHandle", id = 3)
    private final String c;
    @SafeParcelable.Field(getter = "getBluetoothAddress", id = 6)
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzgs(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 6) String str2) {
        this.b = ((Integer) Preconditions.checkNotNull(Integer.valueOf(i))).intValue();
        this.c = str == null ? "" : str;
        this.d = str2;
    }

    private zzgs(String str, String str2) {
        this(1, str, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgs)) {
            return false;
        }
        zzgs zzgsVar = (zzgs) obj;
        return Objects.equal(this.c, zzgsVar.c) && Objects.equal(this.d, zzgsVar.d);
    }

    public final int hashCode() {
        return Objects.hashCode(this.c, this.d);
    }

    public final String toString() {
        String str = this.c;
        String str2 = this.d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(str2).length());
        sb.append("NearbyDevice{handle=");
        sb.append(str);
        sb.append(", bluetoothAddress=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeString(parcel, 6, this.d, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
