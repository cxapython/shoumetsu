package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@KeepForSdk
@SafeParcelable.Class(creator = "ContentsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class Contents extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new zzc();
    @SafeParcelable.Field(id = 3)
    final int a;
    @SafeParcelable.Field(id = 2)
    private final ParcelFileDescriptor b;
    @SafeParcelable.Field(id = 4)
    private final int c;
    @SafeParcelable.Field(id = 5)
    private final DriveId d;
    @SafeParcelable.Field(id = 7)
    private final boolean e;
    @SafeParcelable.Field(id = 8)
    private final String f;

    @SafeParcelable.Constructor
    public Contents(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) DriveId driveId, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) String str) {
        this.b = parcelFileDescriptor;
        this.a = i;
        this.c = i2;
        this.d = driveId;
        this.e = z;
        this.f = str;
    }

    public final DriveId getDriveId() {
        return this.d;
    }

    public final InputStream getInputStream() {
        return new FileInputStream(this.b.getFileDescriptor());
    }

    public final int getMode() {
        return this.c;
    }

    public final OutputStream getOutputStream() {
        return new FileOutputStream(this.b.getFileDescriptor());
    }

    @KeepForSdk
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.b;
    }

    public final int getRequestId() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.a);
        SafeParcelWriter.writeInt(parcel, 4, this.c);
        SafeParcelWriter.writeParcelable(parcel, 5, this.d, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.e);
        SafeParcelWriter.writeString(parcel, 8, this.f, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza() {
        return this.e;
    }
}
