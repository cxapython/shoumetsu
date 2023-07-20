package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.drive.zzbn;
import com.google.android.gms.internal.drive.zzbs;
import com.google.android.gms.internal.drive.zzdp;
import com.google.android.gms.internal.drive.zzhn;
import com.google.android.gms.internal.drive.zzho;
import com.google.android.gms.internal.drive.zziw;
import com.google.android.gms.internal.drive.zzix;

@SafeParcelable.Class(creator = "DriveIdCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class DriveId extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new zzk();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    @SafeParcelable.Field(id = 2)
    private final String a;
    @SafeParcelable.Field(id = 3)
    private final long b;
    @SafeParcelable.Field(id = 4)
    private final long c;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.drive.DriveId.RESOURCE_TYPE_UNKNOWN", id = 5)
    private final int d;
    private volatile String e = null;
    private volatile String f = null;

    @SafeParcelable.Constructor
    public DriveId(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) long j2, @SafeParcelable.Param(id = 5) int i) {
        this.a = str;
        boolean z = true;
        Preconditions.checkArgument(!"".equals(str));
        if (str == null && j == -1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.b = j;
        this.c = j2;
        this.d = i;
    }

    @VisibleForTesting
    private static DriveId a(byte[] bArr) {
        try {
            zzhn zzhnVar = (zzhn) zzix.zza(new zzhn(), bArr, 0, bArr.length);
            return new DriveId("".equals(zzhnVar.zzab) ? null : zzhnVar.zzab, zzhnVar.zzac, zzhnVar.zzf, zzhnVar.zzad);
        } catch (zziw unused) {
            throw new IllegalArgumentException();
        }
    }

    public static DriveId decodeFromString(String str) {
        boolean startsWith = str.startsWith("DriveId:");
        String valueOf = String.valueOf(str);
        Preconditions.checkArgument(startsWith, valueOf.length() != 0 ? "Invalid DriveId: ".concat(valueOf) : new String("Invalid DriveId: "));
        return a(Base64.decode(str.substring(8), 10));
    }

    @VisibleForTesting
    public static DriveId zza(String str) {
        Preconditions.checkNotNull(str);
        return new DriveId(str, -1L, -1L, -1);
    }

    public DriveFile asDriveFile() {
        if (this.d != 1) {
            return new zzbn(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }

    public DriveFolder asDriveFolder() {
        if (this.d != 0) {
            return new zzbs(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }

    public DriveResource asDriveResource() {
        int i = this.d;
        return i == 1 ? asDriveFolder() : i == 0 ? asDriveFile() : new zzdp(this);
    }

    public final String encodeToString() {
        if (this.e == null) {
            zzhn zzhnVar = new zzhn();
            zzhnVar.versionCode = 1;
            String str = this.a;
            if (str == null) {
                str = "";
            }
            zzhnVar.zzab = str;
            zzhnVar.zzac = this.b;
            zzhnVar.zzf = this.c;
            zzhnVar.zzad = this.d;
            String encodeToString = Base64.encodeToString(zzix.zza(zzhnVar), 10);
            String valueOf = String.valueOf("DriveId:");
            String valueOf2 = String.valueOf(encodeToString);
            this.e = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        return this.e;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj != null && obj.getClass() == DriveId.class) {
            DriveId driveId = (DriveId) obj;
            if (driveId.c != this.c) {
                return false;
            }
            if (driveId.b == -1 && this.b == -1) {
                return driveId.a.equals(this.a);
            }
            String str2 = this.a;
            if (str2 != null && (str = driveId.a) != null) {
                return driveId.b == this.b && str.equals(str2);
            } else if (driveId.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public String getResourceId() {
        return this.a;
    }

    public int getResourceType() {
        return this.d;
    }

    public int hashCode() {
        if (this.b == -1) {
            return this.a.hashCode();
        }
        String valueOf = String.valueOf(String.valueOf(this.c));
        String valueOf2 = String.valueOf(String.valueOf(this.b));
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }

    public final String toInvariantString() {
        if (this.f == null) {
            zzho zzhoVar = new zzho();
            zzhoVar.zzac = this.b;
            zzhoVar.zzf = this.c;
            this.f = Base64.encodeToString(zzix.zza(zzhoVar), 10);
        }
        return this.f;
    }

    public String toString() {
        return encodeToString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.a, false);
        SafeParcelWriter.writeLong(parcel, 3, this.b);
        SafeParcelWriter.writeLong(parcel, 4, this.c);
        SafeParcelWriter.writeInt(parcel, 5, this.d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
