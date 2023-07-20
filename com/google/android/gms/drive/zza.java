package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.drive.zzhm;
import com.google.android.gms.internal.drive.zzix;

@SafeParcelable.Class(creator = "ChangeSequenceNumberCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    @SafeParcelable.Field(id = 2)
    private final long a;
    @SafeParcelable.Field(id = 3)
    private final long b;
    @SafeParcelable.Field(id = 4)
    private final long c;
    private volatile String d = null;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) long j3) {
        boolean z = true;
        Preconditions.checkArgument(j != -1);
        Preconditions.checkArgument(j2 != -1);
        Preconditions.checkArgument(j3 == -1 ? false : z);
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zza.class) {
            zza zzaVar = (zza) obj;
            if (zzaVar.b == this.b && zzaVar.c == this.c && zzaVar.a == this.a) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String valueOf = String.valueOf(this.a);
        String valueOf2 = String.valueOf(this.b);
        String valueOf3 = String.valueOf(this.c);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append(valueOf);
        sb.append(valueOf2);
        sb.append(valueOf3);
        return sb.toString().hashCode();
    }

    public String toString() {
        if (this.d == null) {
            zzhm zzhmVar = new zzhm();
            zzhmVar.versionCode = 1;
            zzhmVar.zze = this.a;
            zzhmVar.zzf = this.b;
            zzhmVar.zzg = this.c;
            String encodeToString = Base64.encodeToString(zzix.zza(zzhmVar), 10);
            String valueOf = String.valueOf("ChangeSequenceNumber:");
            String valueOf2 = String.valueOf(encodeToString);
            this.d = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.a);
        SafeParcelWriter.writeLong(parcel, 3, this.b);
        SafeParcelWriter.writeLong(parcel, 4, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
