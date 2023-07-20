package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "OnConnectionResultParamsCreator")
/* loaded from: classes.dex */
public final class zzen extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzen> CREATOR = new zzeo();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String a;
    @SafeParcelable.Field(getter = "getStatusCode", id = 2)
    private int b;
    @SafeParcelable.Field(getter = "getHandshakeData", id = 3)
    private byte[] c;

    private zzen() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzen(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) byte[] bArr) {
        this.a = str;
        this.b = i;
        this.c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzen) {
            zzen zzenVar = (zzen) obj;
            if (Objects.equal(this.a, zzenVar.a) && Objects.equal(Integer.valueOf(this.b), Integer.valueOf(zzenVar.b)) && Arrays.equals(this.c, zzenVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int getStatusCode() {
        return this.b;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, Integer.valueOf(this.b), Integer.valueOf(Arrays.hashCode(this.c)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.b);
        SafeParcelWriter.writeByteArray(parcel, 3, this.c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzg() {
        return this.a;
    }
}
