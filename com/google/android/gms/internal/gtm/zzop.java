package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
public final class zzop extends zzuq<zzop> {
    public long zzaux = 0;
    public zzi zzqk = null;
    public zzk zzauy = null;

    public zzop() {
        this.a = null;
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final int a() {
        int a = super.a() + zzuo.zzd(1, this.zzaux);
        zzi zziVar = this.zzqk;
        if (zziVar != null) {
            a += zzuo.zzb(2, zziVar);
        }
        zzk zzkVar = this.zzauy;
        return zzkVar != null ? a + zzuo.zzb(3, zzkVar) : a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzop)) {
            return false;
        }
        zzop zzopVar = (zzop) obj;
        if (this.zzaux != zzopVar.zzaux) {
            return false;
        }
        zzi zziVar = this.zzqk;
        if (zziVar == null) {
            if (zzopVar.zzqk != null) {
                return false;
            }
        } else if (!zziVar.equals(zzopVar.zzqk)) {
            return false;
        }
        zzk zzkVar = this.zzauy;
        if (zzkVar == null) {
            if (zzopVar.zzauy != null) {
                return false;
            }
        } else if (!zzkVar.equals(zzopVar.zzauy)) {
            return false;
        }
        return (this.a == null || this.a.isEmpty()) ? zzopVar.a == null || zzopVar.a.isEmpty() : this.a.equals(zzopVar.a);
    }

    public final int hashCode() {
        long j = this.zzaux;
        zzi zziVar = this.zzqk;
        int i = 0;
        int hashCode = ((((getClass().getName().hashCode() + 527) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (zziVar == null ? 0 : zziVar.hashCode());
        zzk zzkVar = this.zzauy;
        int hashCode2 = ((hashCode * 31) + (zzkVar == null ? 0 : zzkVar.hashCode())) * 31;
        if (this.a != null && !this.a.isEmpty()) {
            i = this.a.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zza(zzun zzunVar) {
        zzuw zzuwVar;
        while (true) {
            int zzni = zzunVar.zzni();
            if (zzni != 0) {
                if (zzni != 8) {
                    if (zzni == 18) {
                        if (this.zzqk == null) {
                            this.zzqk = new zzi();
                        }
                        zzuwVar = this.zzqk;
                    } else if (zzni == 26) {
                        if (this.zzauy == null) {
                            this.zzauy = new zzk();
                        }
                        zzuwVar = this.zzauy;
                    } else if (!super.a(zzunVar, zzni)) {
                        return this;
                    }
                    zzunVar.zza(zzuwVar);
                } else {
                    this.zzaux = zzunVar.zzob();
                }
            } else {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) {
        zzuoVar.zzi(1, this.zzaux);
        zzi zziVar = this.zzqk;
        if (zziVar != null) {
            zzuoVar.zza(2, zziVar);
        }
        zzk zzkVar = this.zzauy;
        if (zzkVar != null) {
            zzuoVar.zza(3, zzkVar);
        }
        super.zza(zzuoVar);
    }
}
