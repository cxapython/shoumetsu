package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PermissionCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @SafeParcelable.Field(getter = "getAccountIdentifier", id = 2)
    private String a;
    @SafeParcelable.Field(getter = "getAccountType", id = 3)
    private int b;
    @SafeParcelable.Field(getter = "getAccountDisplayName", id = 4)
    private String c;
    @SafeParcelable.Field(getter = "getPhotoLink", id = 5)
    private String d;
    @SafeParcelable.Field(getter = "getRole", id = 6)
    private int e;
    @SafeParcelable.Field(getter = "isLinkRequiredForAccess", id = 7)
    private boolean f;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) int i2, @SafeParcelable.Param(id = 7) boolean z) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = i2;
        this.f = z;
    }

    private static boolean a(int i) {
        switch (i) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            zzr zzrVar = (zzr) obj;
            if (Objects.equal(this.a, zzrVar.a) && this.b == zzrVar.b && this.e == zzrVar.e && this.f == zzrVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, Integer.valueOf(this.b), Integer.valueOf(this.e), Boolean.valueOf(this.f));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        boolean z = false;
        SafeParcelWriter.writeString(parcel, 2, !a(this.b) ? null : this.a, false);
        int i2 = -1;
        SafeParcelWriter.writeInt(parcel, 3, !a(this.b) ? -1 : this.b);
        SafeParcelWriter.writeString(parcel, 4, this.c, false);
        SafeParcelWriter.writeString(parcel, 5, this.d, false);
        switch (this.e) {
            case 0:
            case 1:
            case 2:
            case 3:
                z = true;
                break;
        }
        if (z) {
            i2 = this.e;
        }
        SafeParcelWriter.writeInt(parcel, 6, i2);
        SafeParcelWriter.writeBoolean(parcel, 7, this.f);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
