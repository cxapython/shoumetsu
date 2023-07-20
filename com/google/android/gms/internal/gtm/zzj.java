package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
public final class zzj extends zzuq<zzj> {
    private static volatile zzj[] c;
    public String name = "";
    private zzl d = null;
    public zzh zzqi = null;

    public zzj() {
        this.a = null;
        this.b = -1;
    }

    public static zzj[] zzz() {
        if (c == null) {
            synchronized (zzuu.zzbhk) {
                if (c == null) {
                    c = new zzj[0];
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final int a() {
        int a = super.a();
        String str = this.name;
        if (str != null && !str.equals("")) {
            a += zzuo.zzb(1, this.name);
        }
        zzl zzlVar = this.d;
        if (zzlVar != null) {
            a += zzuo.zzb(2, zzlVar);
        }
        zzh zzhVar = this.zzqi;
        return zzhVar != null ? a + zzuo.zzb(3, zzhVar) : a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        String str = this.name;
        if (str == null) {
            if (zzjVar.name != null) {
                return false;
            }
        } else if (!str.equals(zzjVar.name)) {
            return false;
        }
        zzl zzlVar = this.d;
        if (zzlVar == null) {
            if (zzjVar.d != null) {
                return false;
            }
        } else if (!zzlVar.equals(zzjVar.d)) {
            return false;
        }
        zzh zzhVar = this.zzqi;
        if (zzhVar == null) {
            if (zzjVar.zzqi != null) {
                return false;
            }
        } else if (!zzhVar.equals(zzjVar.zzqi)) {
            return false;
        }
        return (this.a == null || this.a.isEmpty()) ? zzjVar.a == null || zzjVar.a.isEmpty() : this.a.equals(zzjVar.a);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = hashCode + (str == null ? 0 : str.hashCode());
        zzl zzlVar = this.d;
        int hashCode3 = (hashCode2 * 31) + (zzlVar == null ? 0 : zzlVar.hashCode());
        zzh zzhVar = this.zzqi;
        int hashCode4 = ((hashCode3 * 31) + (zzhVar == null ? 0 : zzhVar.hashCode())) * 31;
        if (this.a != null && !this.a.isEmpty()) {
            i = this.a.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zza(zzun zzunVar) {
        zzuw zzuwVar;
        while (true) {
            int zzni = zzunVar.zzni();
            if (zzni != 0) {
                if (zzni != 10) {
                    if (zzni == 18) {
                        if (this.d == null) {
                            this.d = new zzl();
                        }
                        zzuwVar = this.d;
                    } else if (zzni == 26) {
                        if (this.zzqi == null) {
                            this.zzqi = new zzh();
                        }
                        zzuwVar = this.zzqi;
                    } else if (!super.a(zzunVar, zzni)) {
                        return this;
                    }
                    zzunVar.zza(zzuwVar);
                } else {
                    this.name = zzunVar.readString();
                }
            } else {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) {
        String str = this.name;
        if (str != null && !str.equals("")) {
            zzuoVar.zza(1, this.name);
        }
        zzl zzlVar = this.d;
        if (zzlVar != null) {
            zzuoVar.zza(2, zzlVar);
        }
        zzh zzhVar = this.zzqi;
        if (zzhVar != null) {
            zzuoVar.zza(3, zzhVar);
        }
        super.zza(zzuoVar);
    }
}
