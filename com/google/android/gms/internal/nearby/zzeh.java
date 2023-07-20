package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "OnConnectionInitiatedParamsCreator")
/* loaded from: classes.dex */
public final class zzeh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeh> CREATOR = new zzei();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String a;
    @SafeParcelable.Field(getter = "getRemoteEndpointName", id = 2)
    private String b;
    @SafeParcelable.Field(getter = "getAuthenticationToken", id = 3)
    private String c;
    @SafeParcelable.Field(getter = "getIsIncomingConnection", id = 4)
    private boolean d;
    @SafeParcelable.Field(getter = "getHandshakeData", id = 5)
    private byte[] e;

    private zzeh() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzeh(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) byte[] bArr) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeh) {
            zzeh zzehVar = (zzeh) obj;
            if (Objects.equal(this.a, zzehVar.a) && Objects.equal(this.b, zzehVar.b) && Objects.equal(this.c, zzehVar.c) && Objects.equal(Boolean.valueOf(this.d), Boolean.valueOf(zzehVar.d)) && Arrays.equals(this.e, zzehVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final String getAuthenticationToken() {
        return this.c;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b, this.c, Boolean.valueOf(this.d), Integer.valueOf(Arrays.hashCode(this.e)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.d);
        SafeParcelWriter.writeByteArray(parcel, 5, this.e, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzg() {
        return this.a;
    }

    public final String zzh() {
        return this.b;
    }

    public final boolean zzi() {
        return this.d;
    }
}
