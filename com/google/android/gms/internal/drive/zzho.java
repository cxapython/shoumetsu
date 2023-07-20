package com.google.android.gms.internal.drive;

/* loaded from: classes.dex */
public final class zzho extends zzir<zzho> {
    public long zzac = -1;
    public long zzf = -1;

    public zzho() {
        this.a = null;
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.drive.zzir, com.google.android.gms.internal.drive.zzix
    public final int a() {
        return super.a() + zzip.zzb(1, this.zzac) + zzip.zzb(2, this.zzf);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzho)) {
            return false;
        }
        zzho zzhoVar = (zzho) obj;
        if (this.zzac != zzhoVar.zzac || this.zzf != zzhoVar.zzf) {
            return false;
        }
        return (this.a == null || this.a.isEmpty()) ? zzhoVar.a == null || zzhoVar.a.isEmpty() : this.a.equals(zzhoVar.a);
    }

    public final int hashCode() {
        long j = this.zzac;
        long j2 = this.zzf;
        return ((((((getClass().getName().hashCode() + 527) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((this.a == null || this.a.isEmpty()) ? 0 : this.a.hashCode());
    }

    @Override // com.google.android.gms.internal.drive.zzix
    public final /* synthetic */ zzix zza(zzio zzioVar) {
        while (true) {
            int zzbd = zzioVar.zzbd();
            if (zzbd != 0) {
                if (zzbd == 8) {
                    long zzbf = zzioVar.zzbf();
                    this.zzac = (-(zzbf & 1)) ^ (zzbf >>> 1);
                } else if (zzbd == 16) {
                    long zzbf2 = zzioVar.zzbf();
                    this.zzf = (-(zzbf2 & 1)) ^ (zzbf2 >>> 1);
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
        zzipVar.zza(1, this.zzac);
        zzipVar.zza(2, this.zzf);
        super.zza(zzipVar);
    }
}
