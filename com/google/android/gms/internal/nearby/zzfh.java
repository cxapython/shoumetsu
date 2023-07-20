package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "ParcelablePayloadCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzfh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfh> CREATOR = new zzfk();
    @SafeParcelable.Field(getter = "getId", id = 1)
    private long a;
    @SafeParcelable.Field(getter = "getType", id = 2)
    private int b;
    @SafeParcelable.Field(getter = "getBytes", id = 3)
    private byte[] c;
    @SafeParcelable.Field(getter = "getDataPfd", id = 4)
    private ParcelFileDescriptor d;
    @SafeParcelable.Field(getter = "getJavaFilePath", id = 5)
    private String e;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getJavaFileSize", id = 6)
    private long f;
    @SafeParcelable.Field(getter = "getStatusPfd", id = 7)
    private ParcelFileDescriptor g;

    private zzfh() {
        this.f = -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzfh(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) long j2, @SafeParcelable.Param(id = 7) ParcelFileDescriptor parcelFileDescriptor2) {
        this.f = -1L;
        this.a = j;
        this.b = i;
        this.c = bArr;
        this.d = parcelFileDescriptor;
        this.e = str;
        this.f = j2;
        this.g = parcelFileDescriptor2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfh) {
            zzfh zzfhVar = (zzfh) obj;
            if (Objects.equal(Long.valueOf(this.a), Long.valueOf(zzfhVar.a)) && Objects.equal(Integer.valueOf(this.b), Integer.valueOf(zzfhVar.b)) && Arrays.equals(this.c, zzfhVar.c) && Objects.equal(this.d, zzfhVar.d) && Objects.equal(this.e, zzfhVar.e) && Objects.equal(Long.valueOf(this.f), Long.valueOf(zzfhVar.f)) && Objects.equal(this.g, zzfhVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final byte[] getBytes() {
        return this.c;
    }

    public final long getId() {
        return this.a;
    }

    public final int getType() {
        return this.b;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(Arrays.hashCode(this.c)), this.d, this.e, Long.valueOf(this.f), this.g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.a);
        SafeParcelWriter.writeInt(parcel, 2, this.b);
        SafeParcelWriter.writeByteArray(parcel, 3, this.c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.d, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.e, false);
        SafeParcelWriter.writeLong(parcel, 6, this.f);
        SafeParcelWriter.writeParcelable(parcel, 7, this.g, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ParcelFileDescriptor zzo() {
        return this.d;
    }

    public final String zzp() {
        return this.e;
    }

    public final long zzq() {
        return this.f;
    }
}
