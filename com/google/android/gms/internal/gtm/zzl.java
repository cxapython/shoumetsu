package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
public final class zzl extends zzuq<zzl> {
    private static volatile zzl[] c;
    public int type = 1;
    public String string = "";
    public zzl[] zzqn = zzaa();
    public zzl[] zzqo = zzaa();
    public zzl[] zzqp = zzaa();
    public String zzqq = "";
    public String zzqr = "";
    public long zzqs = 0;
    public boolean zzqt = false;
    public zzl[] zzqu = zzaa();
    public int[] zzqv = zzuz.zzbcw;
    public boolean zzqw = false;

    public zzl() {
        this.a = null;
        this.b = -1;
    }

    private static int a(int i) {
        if (i <= 0 || i > 17) {
            StringBuilder sb = new StringBuilder(40);
            sb.append(i);
            sb.append(" is not a valid enum Escaping");
            throw new IllegalArgumentException(sb.toString());
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.gtm.zzuw
    /* renamed from: a */
    public final zzl zza(zzun zzunVar) {
        while (true) {
            int zzni = zzunVar.zzni();
            switch (zzni) {
                case 0:
                    return this;
                case 8:
                    int position = zzunVar.getPosition();
                    try {
                        int zzoa = zzunVar.zzoa();
                        if (zzoa <= 0 || zzoa > 8) {
                            StringBuilder sb = new StringBuilder(36);
                            sb.append(zzoa);
                            sb.append(" is not a valid enum Type");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                        } else {
                            this.type = zzoa;
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzunVar.zzbz(position);
                        a(zzunVar, zzni);
                        break;
                    }
                case 18:
                    this.string = zzunVar.readString();
                    break;
                case 26:
                    int zzb = zzuz.zzb(zzunVar, 26);
                    zzl[] zzlVarArr = this.zzqn;
                    int length = zzlVarArr == null ? 0 : zzlVarArr.length;
                    zzl[] zzlVarArr2 = new zzl[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzqn, 0, zzlVarArr2, 0, length);
                    }
                    while (length < zzlVarArr2.length - 1) {
                        zzlVarArr2[length] = new zzl();
                        zzunVar.zza(zzlVarArr2[length]);
                        zzunVar.zzni();
                        length++;
                    }
                    zzlVarArr2[length] = new zzl();
                    zzunVar.zza(zzlVarArr2[length]);
                    this.zzqn = zzlVarArr2;
                    break;
                case 34:
                    int zzb2 = zzuz.zzb(zzunVar, 34);
                    zzl[] zzlVarArr3 = this.zzqo;
                    int length2 = zzlVarArr3 == null ? 0 : zzlVarArr3.length;
                    zzl[] zzlVarArr4 = new zzl[zzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzqo, 0, zzlVarArr4, 0, length2);
                    }
                    while (length2 < zzlVarArr4.length - 1) {
                        zzlVarArr4[length2] = new zzl();
                        zzunVar.zza(zzlVarArr4[length2]);
                        zzunVar.zzni();
                        length2++;
                    }
                    zzlVarArr4[length2] = new zzl();
                    zzunVar.zza(zzlVarArr4[length2]);
                    this.zzqo = zzlVarArr4;
                    break;
                case 42:
                    int zzb3 = zzuz.zzb(zzunVar, 42);
                    zzl[] zzlVarArr5 = this.zzqp;
                    int length3 = zzlVarArr5 == null ? 0 : zzlVarArr5.length;
                    zzl[] zzlVarArr6 = new zzl[zzb3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzqp, 0, zzlVarArr6, 0, length3);
                    }
                    while (length3 < zzlVarArr6.length - 1) {
                        zzlVarArr6[length3] = new zzl();
                        zzunVar.zza(zzlVarArr6[length3]);
                        zzunVar.zzni();
                        length3++;
                    }
                    zzlVarArr6[length3] = new zzl();
                    zzunVar.zza(zzlVarArr6[length3]);
                    this.zzqp = zzlVarArr6;
                    break;
                case 50:
                    this.zzqq = zzunVar.readString();
                    break;
                case 58:
                    this.zzqr = zzunVar.readString();
                    break;
                case 64:
                    this.zzqs = zzunVar.zzob();
                    break;
                case 72:
                    this.zzqw = zzunVar.zzno();
                    break;
                case 80:
                    int zzb4 = zzuz.zzb(zzunVar, 80);
                    int[] iArr = new int[zzb4];
                    int i = 0;
                    for (int i2 = 0; i2 < zzb4; i2++) {
                        if (i2 != 0) {
                            zzunVar.zzni();
                        }
                        int position2 = zzunVar.getPosition();
                        try {
                            iArr[i] = a(zzunVar.zzoa());
                            i++;
                        } catch (IllegalArgumentException unused2) {
                            zzunVar.zzbz(position2);
                            a(zzunVar, zzni);
                        }
                    }
                    if (i == 0) {
                        break;
                    } else {
                        int[] iArr2 = this.zzqv;
                        int length4 = iArr2 == null ? 0 : iArr2.length;
                        if (length4 != 0 || i != iArr.length) {
                            int[] iArr3 = new int[length4 + i];
                            if (length4 != 0) {
                                System.arraycopy(this.zzqv, 0, iArr3, 0, length4);
                            }
                            System.arraycopy(iArr, 0, iArr3, length4, i);
                            this.zzqv = iArr3;
                            break;
                        } else {
                            this.zzqv = iArr;
                            break;
                        }
                    }
                case 82:
                    int zzaq = zzunVar.zzaq(zzunVar.zzoa());
                    int position3 = zzunVar.getPosition();
                    int i3 = 0;
                    while (zzunVar.zzrv() > 0) {
                        try {
                            a(zzunVar.zzoa());
                            i3++;
                        } catch (IllegalArgumentException unused3) {
                        }
                    }
                    if (i3 != 0) {
                        zzunVar.zzbz(position3);
                        int[] iArr4 = this.zzqv;
                        int length5 = iArr4 == null ? 0 : iArr4.length;
                        int[] iArr5 = new int[i3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzqv, 0, iArr5, 0, length5);
                        }
                        while (zzunVar.zzrv() > 0) {
                            int position4 = zzunVar.getPosition();
                            try {
                                iArr5[length5] = a(zzunVar.zzoa());
                                length5++;
                            } catch (IllegalArgumentException unused4) {
                                zzunVar.zzbz(position4);
                                a(zzunVar, 80);
                            }
                        }
                        this.zzqv = iArr5;
                    }
                    zzunVar.zzar(zzaq);
                    break;
                case 90:
                    int zzb5 = zzuz.zzb(zzunVar, 90);
                    zzl[] zzlVarArr7 = this.zzqu;
                    int length6 = zzlVarArr7 == null ? 0 : zzlVarArr7.length;
                    zzl[] zzlVarArr8 = new zzl[zzb5 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.zzqu, 0, zzlVarArr8, 0, length6);
                    }
                    while (length6 < zzlVarArr8.length - 1) {
                        zzlVarArr8[length6] = new zzl();
                        zzunVar.zza(zzlVarArr8[length6]);
                        zzunVar.zzni();
                        length6++;
                    }
                    zzlVarArr8[length6] = new zzl();
                    zzunVar.zza(zzlVarArr8[length6]);
                    this.zzqu = zzlVarArr8;
                    break;
                case 96:
                    this.zzqt = zzunVar.zzno();
                    break;
                default:
                    if (!super.a(zzunVar, zzni)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static zzl[] zzaa() {
        if (c == null) {
            synchronized (zzuu.zzbhk) {
                if (c == null) {
                    c = new zzl[0];
                }
            }
        }
        return c;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    protected final int a() {
        int[] iArr;
        int a = super.a() + zzuo.zzi(1, this.type);
        String str = this.string;
        if (str != null && !str.equals("")) {
            a += zzuo.zzb(2, this.string);
        }
        zzl[] zzlVarArr = this.zzqn;
        int i = 0;
        if (zzlVarArr != null && zzlVarArr.length > 0) {
            int i2 = a;
            int i3 = 0;
            while (true) {
                zzl[] zzlVarArr2 = this.zzqn;
                if (i3 >= zzlVarArr2.length) {
                    break;
                }
                zzl zzlVar = zzlVarArr2[i3];
                if (zzlVar != null) {
                    i2 += zzuo.zzb(3, zzlVar);
                }
                i3++;
            }
            a = i2;
        }
        zzl[] zzlVarArr3 = this.zzqo;
        if (zzlVarArr3 != null && zzlVarArr3.length > 0) {
            int i4 = a;
            int i5 = 0;
            while (true) {
                zzl[] zzlVarArr4 = this.zzqo;
                if (i5 >= zzlVarArr4.length) {
                    break;
                }
                zzl zzlVar2 = zzlVarArr4[i5];
                if (zzlVar2 != null) {
                    i4 += zzuo.zzb(4, zzlVar2);
                }
                i5++;
            }
            a = i4;
        }
        zzl[] zzlVarArr5 = this.zzqp;
        if (zzlVarArr5 != null && zzlVarArr5.length > 0) {
            int i6 = a;
            int i7 = 0;
            while (true) {
                zzl[] zzlVarArr6 = this.zzqp;
                if (i7 >= zzlVarArr6.length) {
                    break;
                }
                zzl zzlVar3 = zzlVarArr6[i7];
                if (zzlVar3 != null) {
                    i6 += zzuo.zzb(5, zzlVar3);
                }
                i7++;
            }
            a = i6;
        }
        String str2 = this.zzqq;
        if (str2 != null && !str2.equals("")) {
            a += zzuo.zzb(6, this.zzqq);
        }
        String str3 = this.zzqr;
        if (str3 != null && !str3.equals("")) {
            a += zzuo.zzb(7, this.zzqr);
        }
        long j = this.zzqs;
        if (j != 0) {
            a += zzuo.zzd(8, j);
        }
        if (this.zzqw) {
            a += zzuo.zzbb(9) + 1;
        }
        int[] iArr2 = this.zzqv;
        if (iArr2 != null && iArr2.length > 0) {
            int i8 = 0;
            int i9 = 0;
            while (true) {
                iArr = this.zzqv;
                if (i8 >= iArr.length) {
                    break;
                }
                i9 += zzuo.zzbc(iArr[i8]);
                i8++;
            }
            a = a + i9 + (iArr.length * 1);
        }
        zzl[] zzlVarArr7 = this.zzqu;
        if (zzlVarArr7 != null && zzlVarArr7.length > 0) {
            while (true) {
                zzl[] zzlVarArr8 = this.zzqu;
                if (i >= zzlVarArr8.length) {
                    break;
                }
                zzl zzlVar4 = zzlVarArr8[i];
                if (zzlVar4 != null) {
                    a += zzuo.zzb(11, zzlVar4);
                }
                i++;
            }
        }
        return this.zzqt ? a + zzuo.zzbb(12) + 1 : a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzl)) {
            return false;
        }
        zzl zzlVar = (zzl) obj;
        if (this.type != zzlVar.type) {
            return false;
        }
        String str = this.string;
        if (str == null) {
            if (zzlVar.string != null) {
                return false;
            }
        } else if (!str.equals(zzlVar.string)) {
            return false;
        }
        if (!zzuu.equals(this.zzqn, zzlVar.zzqn) || !zzuu.equals(this.zzqo, zzlVar.zzqo) || !zzuu.equals(this.zzqp, zzlVar.zzqp)) {
            return false;
        }
        String str2 = this.zzqq;
        if (str2 == null) {
            if (zzlVar.zzqq != null) {
                return false;
            }
        } else if (!str2.equals(zzlVar.zzqq)) {
            return false;
        }
        String str3 = this.zzqr;
        if (str3 == null) {
            if (zzlVar.zzqr != null) {
                return false;
            }
        } else if (!str3.equals(zzlVar.zzqr)) {
            return false;
        }
        if (this.zzqs != zzlVar.zzqs || this.zzqt != zzlVar.zzqt || !zzuu.equals(this.zzqu, zzlVar.zzqu) || !zzuu.equals(this.zzqv, zzlVar.zzqv) || this.zzqw != zzlVar.zzqw) {
            return false;
        }
        return (this.a == null || this.a.isEmpty()) ? zzlVar.a == null || zzlVar.a.isEmpty() : this.a.equals(zzlVar.a);
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.type) * 31;
        String str = this.string;
        int i = 0;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + zzuu.hashCode(this.zzqn)) * 31) + zzuu.hashCode(this.zzqo)) * 31) + zzuu.hashCode(this.zzqp)) * 31;
        String str2 = this.zzqq;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzqr;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        long j = this.zzqs;
        int i2 = (((hashCode3 + hashCode4) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        int i3 = 1231;
        int hashCode5 = (((((i2 + (this.zzqt ? 1231 : 1237)) * 31) + zzuu.hashCode(this.zzqu)) * 31) + zzuu.hashCode(this.zzqv)) * 31;
        if (!this.zzqw) {
            i3 = 1237;
        }
        int i4 = (hashCode5 + i3) * 31;
        if (this.a != null && !this.a.isEmpty()) {
            i = this.a.hashCode();
        }
        return i4 + i;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) {
        zzuoVar.zze(1, this.type);
        String str = this.string;
        if (str != null && !str.equals("")) {
            zzuoVar.zza(2, this.string);
        }
        zzl[] zzlVarArr = this.zzqn;
        int i = 0;
        if (zzlVarArr != null && zzlVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzl[] zzlVarArr2 = this.zzqn;
                if (i2 >= zzlVarArr2.length) {
                    break;
                }
                zzl zzlVar = zzlVarArr2[i2];
                if (zzlVar != null) {
                    zzuoVar.zza(3, zzlVar);
                }
                i2++;
            }
        }
        zzl[] zzlVarArr3 = this.zzqo;
        if (zzlVarArr3 != null && zzlVarArr3.length > 0) {
            int i3 = 0;
            while (true) {
                zzl[] zzlVarArr4 = this.zzqo;
                if (i3 >= zzlVarArr4.length) {
                    break;
                }
                zzl zzlVar2 = zzlVarArr4[i3];
                if (zzlVar2 != null) {
                    zzuoVar.zza(4, zzlVar2);
                }
                i3++;
            }
        }
        zzl[] zzlVarArr5 = this.zzqp;
        if (zzlVarArr5 != null && zzlVarArr5.length > 0) {
            int i4 = 0;
            while (true) {
                zzl[] zzlVarArr6 = this.zzqp;
                if (i4 >= zzlVarArr6.length) {
                    break;
                }
                zzl zzlVar3 = zzlVarArr6[i4];
                if (zzlVar3 != null) {
                    zzuoVar.zza(5, zzlVar3);
                }
                i4++;
            }
        }
        String str2 = this.zzqq;
        if (str2 != null && !str2.equals("")) {
            zzuoVar.zza(6, this.zzqq);
        }
        String str3 = this.zzqr;
        if (str3 != null && !str3.equals("")) {
            zzuoVar.zza(7, this.zzqr);
        }
        long j = this.zzqs;
        if (j != 0) {
            zzuoVar.zzi(8, j);
        }
        boolean z = this.zzqw;
        if (z) {
            zzuoVar.zzb(9, z);
        }
        int[] iArr = this.zzqv;
        if (iArr != null && iArr.length > 0) {
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.zzqv;
                if (i5 >= iArr2.length) {
                    break;
                }
                zzuoVar.zze(10, iArr2[i5]);
                i5++;
            }
        }
        zzl[] zzlVarArr7 = this.zzqu;
        if (zzlVarArr7 != null && zzlVarArr7.length > 0) {
            while (true) {
                zzl[] zzlVarArr8 = this.zzqu;
                if (i >= zzlVarArr8.length) {
                    break;
                }
                zzl zzlVar4 = zzlVarArr8[i];
                if (zzlVar4 != null) {
                    zzuoVar.zza(11, zzlVar4);
                }
                i++;
            }
        }
        boolean z2 = this.zzqt;
        if (z2) {
            zzuoVar.zzb(12, z2);
        }
        super.zza(zzuoVar);
    }
}
