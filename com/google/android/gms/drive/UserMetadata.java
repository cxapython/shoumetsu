package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserMetadataCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class UserMetadata extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<UserMetadata> CREATOR = new zzt();
    @SafeParcelable.Field(id = 2)
    private final String a;
    @SafeParcelable.Field(id = 3)
    private final String b;
    @SafeParcelable.Field(id = 4)
    private final String c;
    @SafeParcelable.Field(id = 5)
    private final boolean d;
    @SafeParcelable.Field(id = 6)
    private final String e;

    @SafeParcelable.Constructor
    public UserMetadata(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = str4;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", this.a, this.b, this.c, Boolean.valueOf(this.d), this.e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.a, false);
        SafeParcelWriter.writeString(parcel, 3, this.b, false);
        SafeParcelWriter.writeString(parcel, 4, this.c, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.d);
        SafeParcelWriter.writeString(parcel, 6, this.e, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
