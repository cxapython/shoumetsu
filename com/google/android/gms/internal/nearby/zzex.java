package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

@SafeParcelable.Class(creator = "OnPayloadTransferUpdateParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzex extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzex> CREATOR = new zzey();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String a;
    @SafeParcelable.Field(getter = "getUpdate", id = 2)
    private PayloadTransferUpdate b;

    private zzex() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzex(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) PayloadTransferUpdate payloadTransferUpdate) {
        this.a = str;
        this.b = payloadTransferUpdate;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzex) {
            zzex zzexVar = (zzex) obj;
            if (Objects.equal(this.a, zzexVar.a) && Objects.equal(this.b, zzexVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzg() {
        return this.a;
    }

    public final PayloadTransferUpdate zzn() {
        return this.b;
    }
}
