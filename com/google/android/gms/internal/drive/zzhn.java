package com.google.android.gms.internal.drive;

/* loaded from: classes.dex */
public final class zzhn extends zzir<zzhn> {
    public int versionCode = 1;
    public String zzab = "";
    public long zzac = -1;
    public long zzf = -1;
    public int zzad = -1;

    public zzhn() {
        this.a = null;
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.drive.zzir, com.google.android.gms.internal.drive.zzix
    public final int a() {
        int a = super.a() + zzip.zzc(1, this.versionCode) + zzip.zzo(2) + zzip.zzi(this.zzab) + zzip.zzb(3, this.zzac) + zzip.zzb(4, this.zzf);
        int i = this.zzad;
        return i != -1 ? a + zzip.zzc(5, i) : a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhn)) {
            return false;
        }
        zzhn zzhnVar = (zzhn) obj;
        if (this.versionCode != zzhnVar.versionCode) {
            return false;
        }
        String str = this.zzab;
        if (str == null) {
            if (zzhnVar.zzab != null) {
                return false;
            }
        } else if (!str.equals(zzhnVar.zzab)) {
            return false;
        }
        if (this.zzac != zzhnVar.zzac || this.zzf != zzhnVar.zzf || this.zzad != zzhnVar.zzad) {
            return false;
        }
        return (this.a == null || this.a.isEmpty()) ? zzhnVar.a == null || zzhnVar.a.isEmpty() : this.a.equals(zzhnVar.a);
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31;
        String str = this.zzab;
        int i = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j = this.zzac;
        long j2 = this.zzf;
        int i2 = (((((((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.zzad) * 31;
        if (this.a != null && !this.a.isEmpty()) {
            i = this.a.hashCode();
        }
        return i2 + i;
    }

    @Override // com.google.android.gms.internal.drive.zzix
    public final /* synthetic */ zzix zza(zzio zzioVar) {
        while (true) {
            int zzbd = zzioVar.zzbd();
            if (zzbd != 0) {
                if (zzbd == 8) {
                    this.versionCode = zzioVar.zzbe();
                } else if (zzbd == 18) {
                    this.zzab = zzioVar.readString();
                } else if (zzbd == 24) {
                    long zzbf = zzioVar.zzbf();
                    this.zzac = (-(zzbf & 1)) ^ (zzbf >>> 1);
                } else if (zzbd == 32) {
                    long zzbf2 = zzioVar.zzbf();
                    this.zzf = (-(zzbf2 & 1)) ^ (zzbf2 >>> 1);
                } else if (zzbd == 40) {
                    this.zzad = zzioVar.zzbe();
                } else if (!super.a(zzioVar, zzbd)) {
                    return this;
                }
            } else {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.drive.zzir, com.google.android.gms.internal.drive.zzix
    public final void zza(zzip zzipVar) {
        zzipVar.zzb(1, this.versionCode);
        String str = this.zzab;
        zzipVar.zzd(2, 2);
        zzipVar.zzh(str);
        zzipVar.zza(3, this.zzac);
        zzipVar.zza(4, this.zzf);
        int i = this.zzad;
        if (i != -1) {
            zzipVar.zzb(5, i);
        }
        super.zza(zzipVar);
    }
}
