package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzl;
import java.util.UUID;

@SafeParcelable.Class(creator = "NearbyDeviceFilterCreator")
/* loaded from: classes.dex */
public final class zzgu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgu> CREATOR = new zzgv();
    @SafeParcelable.VersionField(id = 1000)
    private final int a;
    @SafeParcelable.Field(id = 1)
    private final int b;
    @SafeParcelable.Field(id = 2)
    private final byte[] c;
    @SafeParcelable.Field(id = 3)
    private final boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzgu(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) boolean z) {
        this.a = i;
        this.b = i2;
        this.c = bArr;
        this.d = z;
    }

    private zzgu(int i, byte[] bArr) {
        this(1, i, bArr, false);
    }

    public static zzgu zza(UUID uuid, Short sh, Short sh2) {
        return new zzgu(3, new zzl(uuid, sh, sh2).getBytes());
    }

    public static zzgu zzb(String str, String str2) {
        String valueOf = String.valueOf(str);
        if (str2 == null) {
            str2 = "";
        }
        String valueOf2 = String.valueOf(str2);
        return new zzgu(2, new com.google.android.gms.nearby.messages.internal.zzg(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).getBytes());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.b);
        SafeParcelWriter.writeByteArray(parcel, 2, this.c, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.d);
        SafeParcelWriter.writeInt(parcel, 1000, this.a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
