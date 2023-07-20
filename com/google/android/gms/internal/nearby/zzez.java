package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnStartAdvertisingResultParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzez extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzez> CREATOR = new zzfa();
    @SafeParcelable.Field(getter = "getStatusCode", id = 1)
    private int a;
    @SafeParcelable.Field(getter = "getLocalEndpointName", id = 2)
    private String b;

    private zzez() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzez(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzez) {
            zzez zzezVar = (zzez) obj;
            if (Objects.equal(Integer.valueOf(this.a), Integer.valueOf(zzezVar.a)) && Objects.equal(this.b, zzezVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final String getLocalEndpointName() {
        return this.b;
    }

    public final int getStatusCode() {
        return this.a;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.a), this.b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
