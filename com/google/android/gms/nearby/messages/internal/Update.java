package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.nearby.zzgr;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

@SafeParcelable.Class(creator = "UpdateCreator")
/* loaded from: classes.dex */
public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new zzci();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(id = 2)
    private final int b;
    @SafeParcelable.Field(id = 7)
    private final byte[] c;
    @SafeParcelable.Field(id = 3)
    public final Message zzhk;
    @SafeParcelable.Field(id = 4)
    public final zze zzjf;
    @SafeParcelable.Field(id = 5)
    public final zza zzjg;
    @SafeParcelable.Field(id = 6)
    public final zzgs zzjh;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Update(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) Message message, @SafeParcelable.Param(id = 4) zze zzeVar, @SafeParcelable.Param(id = 5) zza zzaVar, @SafeParcelable.Param(id = 6) zzgs zzgsVar, @SafeParcelable.Param(id = 7) byte[] bArr) {
        this.a = i;
        int i3 = 2;
        if (a(i2, 2)) {
            zzeVar = null;
            zzaVar = null;
            zzgsVar = null;
            bArr = null;
        } else {
            i3 = i2;
        }
        this.b = i3;
        this.zzhk = message;
        this.zzjf = zzeVar;
        this.zzjg = zzaVar;
        this.zzjh = zzgsVar;
        this.c = bArr;
    }

    private static boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.b == update.b && Objects.equal(this.zzhk, update.zzhk) && Objects.equal(this.zzjf, update.zzjf) && Objects.equal(this.zzjg, update.zzjg) && Objects.equal(this.zzjh, update.zzjh) && Arrays.equals(this.c, update.c);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.b), this.zzhk, this.zzjf, this.zzjg, this.zzjh, this.c);
    }

    public String toString() {
        androidx.b.b bVar = new androidx.b.b();
        if (zzg(1)) {
            bVar.add("FOUND");
        }
        if (zzg(2)) {
            bVar.add("LOST");
        }
        if (zzg(4)) {
            bVar.add("DISTANCE");
        }
        if (zzg(8)) {
            bVar.add("BLE_SIGNAL");
        }
        if (zzg(16)) {
            bVar.add("DEVICE");
        }
        if (zzg(32)) {
            bVar.add("BLE_RECORD");
        }
        String valueOf = String.valueOf(bVar);
        String valueOf2 = String.valueOf(this.zzhk);
        String valueOf3 = String.valueOf(this.zzjf);
        String valueOf4 = String.valueOf(this.zzjg);
        String valueOf5 = String.valueOf(this.zzjh);
        String valueOf6 = String.valueOf(zzgr.zzd(this.c));
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 68 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length());
        sb.append("Update{types=");
        sb.append(valueOf);
        sb.append(", message=");
        sb.append(valueOf2);
        sb.append(", distance=");
        sb.append(valueOf3);
        sb.append(", bleSignal=");
        sb.append(valueOf4);
        sb.append(", device=");
        sb.append(valueOf5);
        sb.append(", bleRecord=");
        sb.append(valueOf6);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeInt(parcel, 2, this.b);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzhk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzjf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzjg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzjh, i, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzg(int i) {
        return a(this.b, i);
    }
}
