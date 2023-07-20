package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;

/* loaded from: classes.dex */
public final class zzh extends zzuq<zzh> {
    public zzl[] zzpe = zzl.zzaa();
    public zzl[] zzpf = zzl.zzaa();
    public zzc.C0045zzc[] zzpg = new zzc.C0045zzc[0];

    public zzh() {
        this.a = null;
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final int a() {
        int a = super.a();
        zzl[] zzlVarArr = this.zzpe;
        int i = 0;
        if (zzlVarArr != null && zzlVarArr.length > 0) {
            int i2 = a;
            int i3 = 0;
            while (true) {
                zzl[] zzlVarArr2 = this.zzpe;
                if (i3 >= zzlVarArr2.length) {
                    break;
                }
                zzl zzlVar = zzlVarArr2[i3];
                if (zzlVar != null) {
                    i2 += zzuo.zzb(1, zzlVar);
                }
                i3++;
            }
            a = i2;
        }
        zzl[] zzlVarArr3 = this.zzpf;
        if (zzlVarArr3 != null && zzlVarArr3.length > 0) {
            int i4 = a;
            int i5 = 0;
            while (true) {
                zzl[] zzlVarArr4 = this.zzpf;
                if (i5 >= zzlVarArr4.length) {
                    break;
                }
                zzl zzlVar2 = zzlVarArr4[i5];
                if (zzlVar2 != null) {
                    i4 += zzuo.zzb(2, zzlVar2);
                }
                i5++;
            }
            a = i4;
        }
        zzc.C0045zzc[] c0045zzcArr = this.zzpg;
        if (c0045zzcArr != null && c0045zzcArr.length > 0) {
            while (true) {
                zzc.C0045zzc[] c0045zzcArr2 = this.zzpg;
                if (i >= c0045zzcArr2.length) {
                    break;
                }
                zzc.C0045zzc c0045zzc = c0045zzcArr2[i];
                if (c0045zzc != null) {
                    a += zzqj.zzc(3, c0045zzc);
                }
                i++;
            }
        }
        return a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzhVar = (zzh) obj;
        if (!zzuu.equals(this.zzpe, zzhVar.zzpe) || !zzuu.equals(this.zzpf, zzhVar.zzpf) || !zzuu.equals(this.zzpg, zzhVar.zzpg)) {
            return false;
        }
        return (this.a == null || this.a.isEmpty()) ? zzhVar.a == null || zzhVar.a.isEmpty() : this.a.equals(zzhVar.a);
    }

    public final int hashCode() {
        return ((((((((getClass().getName().hashCode() + 527) * 31) + zzuu.hashCode(this.zzpe)) * 31) + zzuu.hashCode(this.zzpf)) * 31) + zzuu.hashCode(this.zzpg)) * 31) + ((this.a == null || this.a.isEmpty()) ? 0 : this.a.hashCode());
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zza(zzun zzunVar) {
        while (true) {
            int zzni = zzunVar.zzni();
            if (zzni != 0) {
                if (zzni == 10) {
                    int zzb = zzuz.zzb(zzunVar, 10);
                    zzl[] zzlVarArr = this.zzpe;
                    int length = zzlVarArr == null ? 0 : zzlVarArr.length;
                    zzl[] zzlVarArr2 = new zzl[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzpe, 0, zzlVarArr2, 0, length);
                    }
                    while (length < zzlVarArr2.length - 1) {
                        zzlVarArr2[length] = new zzl();
                        zzunVar.zza(zzlVarArr2[length]);
                        zzunVar.zzni();
                        length++;
                    }
                    zzlVarArr2[length] = new zzl();
                    zzunVar.zza(zzlVarArr2[length]);
                    this.zzpe = zzlVarArr2;
                } else if (zzni == 18) {
                    int zzb2 = zzuz.zzb(zzunVar, 18);
                    zzl[] zzlVarArr3 = this.zzpf;
                    int length2 = zzlVarArr3 == null ? 0 : zzlVarArr3.length;
                    zzl[] zzlVarArr4 = new zzl[zzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzpf, 0, zzlVarArr4, 0, length2);
                    }
                    while (length2 < zzlVarArr4.length - 1) {
                        zzlVarArr4[length2] = new zzl();
                        zzunVar.zza(zzlVarArr4[length2]);
                        zzunVar.zzni();
                        length2++;
                    }
                    zzlVarArr4[length2] = new zzl();
                    zzunVar.zza(zzlVarArr4[length2]);
                    this.zzpf = zzlVarArr4;
                } else if (zzni == 26) {
                    int zzb3 = zzuz.zzb(zzunVar, 26);
                    zzc.C0045zzc[] c0045zzcArr = this.zzpg;
                    int length3 = c0045zzcArr == null ? 0 : c0045zzcArr.length;
                    zzc.C0045zzc[] c0045zzcArr2 = new zzc.C0045zzc[zzb3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzpg, 0, c0045zzcArr2, 0, length3);
                    }
                    while (length3 < c0045zzcArr2.length - 1) {
                        c0045zzcArr2[length3] = (zzc.C0045zzc) zzunVar.zza(zzc.C0045zzc.zza());
                        zzunVar.zzni();
                        length3++;
                    }
                    c0045zzcArr2[length3] = (zzc.C0045zzc) zzunVar.zza(zzc.C0045zzc.zza());
                    this.zzpg = c0045zzcArr2;
                } else if (!super.a(zzunVar, zzni)) {
                    return this;
                }
            } else {
                return this;
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) {
        zzl[] zzlVarArr = this.zzpe;
        int i = 0;
        if (zzlVarArr != null && zzlVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzl[] zzlVarArr2 = this.zzpe;
                if (i2 >= zzlVarArr2.length) {
                    break;
                }
                zzl zzlVar = zzlVarArr2[i2];
                if (zzlVar != null) {
                    zzuoVar.zza(1, zzlVar);
                }
                i2++;
            }
        }
        zzl[] zzlVarArr3 = this.zzpf;
        if (zzlVarArr3 != null && zzlVarArr3.length > 0) {
            int i3 = 0;
            while (true) {
                zzl[] zzlVarArr4 = this.zzpf;
                if (i3 >= zzlVarArr4.length) {
                    break;
                }
                zzl zzlVar2 = zzlVarArr4[i3];
                if (zzlVar2 != null) {
                    zzuoVar.zza(2, zzlVar2);
                }
                i3++;
            }
        }
        zzc.C0045zzc[] c0045zzcArr = this.zzpg;
        if (c0045zzcArr != null && c0045zzcArr.length > 0) {
            while (true) {
                zzc.C0045zzc[] c0045zzcArr2 = this.zzpg;
                if (i >= c0045zzcArr2.length) {
                    break;
                }
                zzc.C0045zzc c0045zzc = c0045zzcArr2[i];
                if (c0045zzc != null) {
                    zzuoVar.zze(3, c0045zzc);
                }
                i++;
            }
        }
        super.zza(zzuoVar);
    }
}
