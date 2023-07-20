package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OperatorCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzx extends AbstractSafeParcelable {
    @SafeParcelable.Field(id = 1)
    private final String b;
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    public static final zzx zzma = new zzx("=");
    public static final zzx zzmb = new zzx("<");
    public static final zzx zzmc = new zzx("<=");
    public static final zzx zzmd = new zzx(">");
    public static final zzx zzme = new zzx(">=");
    public static final zzx zzmf = new zzx("and");
    public static final zzx zzmg = new zzx("or");
    private static final zzx a = new zzx("not");
    public static final zzx zzmi = new zzx("contains");

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(id = 1) String str) {
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzx zzxVar = (zzx) obj;
        String str = this.b;
        if (str == null) {
            if (zzxVar.b != null) {
                return false;
            }
        } else if (!str.equals(zzxVar.b)) {
            return false;
        }
        return true;
    }

    public final String getTag() {
        return this.b;
    }

    public final int hashCode() {
        String str = this.b;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
