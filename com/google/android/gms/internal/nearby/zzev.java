package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnPayloadReceivedParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzev extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzev> CREATOR = new zzew();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String a;
    @SafeParcelable.Field(getter = "getPayload", id = 2)
    private zzfh b;
    @SafeParcelable.Field(getter = "getIsReliable", id = 3)
    private boolean c;

    private zzev() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzev(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) zzfh zzfhVar, @SafeParcelable.Param(id = 3) boolean z) {
        this.a = str;
        this.b = zzfhVar;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzev) {
            zzev zzevVar = (zzev) obj;
            if (Objects.equal(this.a, zzevVar.a) && Objects.equal(this.b, zzevVar.b) && Objects.equal(Boolean.valueOf(this.c), Boolean.valueOf(zzevVar.c))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b, Boolean.valueOf(this.c));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzg() {
        return this.a;
    }

    public final zzfh zzl() {
        return this.b;
    }

    public final boolean zzm() {
        return this.c;
    }
}
