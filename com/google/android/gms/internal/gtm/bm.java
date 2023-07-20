package com.google.android.gms.internal.gtm;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bm implements dd {
    private final zzqe a;
    private int b;
    private int c;
    private int d = 0;

    private bm(zzqe zzqeVar) {
        this.a = (zzqe) zzre.a(zzqeVar, "input");
        this.a.c = this;
    }

    public static bm a(zzqe zzqeVar) {
        return zzqeVar.c != null ? zzqeVar.c : new bm(zzqeVar);
    }

    private final Object a(zzug zzugVar, Class<?> cls, zzqp zzqpVar) {
        switch (bn.a[zzugVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(k());
            case 2:
                return n();
            case 3:
                return Double.valueOf(d());
            case 4:
                return Integer.valueOf(p());
            case 5:
                return Integer.valueOf(j());
            case 6:
                return Long.valueOf(i());
            case 7:
                return Float.valueOf(e());
            case 8:
                return Integer.valueOf(h());
            case 9:
                return Long.valueOf(g());
            case 10:
                a(2);
                return c(db.a().a((Class) cls), zzqpVar);
            case 11:
                return Integer.valueOf(q());
            case 12:
                return Long.valueOf(r());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case 15:
                return m();
            case 16:
                return Integer.valueOf(o());
            case 17:
                return Long.valueOf(f());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void a(int i) {
        if ((this.b & 7) == i) {
            return;
        }
        throw zzrk.e();
    }

    private final void a(List<String> list, boolean z) {
        int zzni;
        int zzni2;
        if ((this.b & 7) == 2) {
            if (!(list instanceof zzrt) || z) {
                do {
                    list.add(z ? m() : l());
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            }
            zzrt zzrtVar = (zzrt) list;
            do {
                zzrtVar.zzc(n());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
            return;
        }
        throw zzrk.e();
    }

    private static void b(int i) {
        if ((i & 7) == 0) {
            return;
        }
        throw zzrk.g();
    }

    private final <T> T c(de<T> deVar, zzqp zzqpVar) {
        int zznr = this.a.zznr();
        if (this.a.a < this.a.b) {
            int zzaq = this.a.zzaq(zznr);
            T a = deVar.a();
            this.a.a++;
            deVar.a(a, this, zzqpVar);
            deVar.c(a);
            this.a.zzan(0);
            zzqe zzqeVar = this.a;
            zzqeVar.a--;
            this.a.zzar(zzaq);
            return a;
        }
        throw zzrk.f();
    }

    private static void c(int i) {
        if ((i & 3) == 0) {
            return;
        }
        throw zzrk.g();
    }

    private final <T> T d(de<T> deVar, zzqp zzqpVar) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T a = deVar.a();
            deVar.a(a, this, zzqpVar);
            deVar.c(a);
            if (this.b == this.c) {
                return a;
            }
            throw zzrk.g();
        } finally {
            this.c = i;
        }
    }

    private final void d(int i) {
        if (this.a.zznz() == i) {
            return;
        }
        throw zzrk.a();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final int a() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.zzni();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final <T> T a(de<T> deVar, zzqp zzqpVar) {
        a(2);
        return (T) c(deVar, zzqpVar);
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void a(List<Double> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof bq)) {
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zznr = this.a.zznr();
                    b(zznr);
                    int zznz = this.a.zznz() + zznr;
                    do {
                        list.add(Double.valueOf(this.a.readDouble()));
                    } while (this.a.zznz() < zznz);
                    return;
                default:
                    throw zzrk.e();
            }
            do {
                list.add(Double.valueOf(this.a.readDouble()));
                if (this.a.zzny()) {
                    return;
                }
                zzni = this.a.zzni();
            } while (zzni == this.b);
            this.d = zzni;
            return;
        }
        bq bqVar = (bq) list;
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zznr2 = this.a.zznr();
                b(zznr2);
                int zznz2 = this.a.zznz() + zznr2;
                do {
                    bqVar.a(this.a.readDouble());
                } while (this.a.zznz() < zznz2);
                return;
            default:
                throw zzrk.e();
        }
        do {
            bqVar.a(this.a.readDouble());
            if (this.a.zzny()) {
                return;
            }
            zzni2 = this.a.zzni();
        } while (zzni2 == this.b);
        this.d = zzni2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.dd
    public final <T> void a(List<T> list, de<T> deVar, zzqp zzqpVar) {
        int zzni;
        int i = this.b;
        if ((i & 7) == 2) {
            do {
                list.add(c(deVar, zzqpVar));
                if (this.a.zzny() || this.d != 0) {
                    return;
                }
                zzni = this.a.zzni();
            } while (zzni == i);
            this.d = zzni;
            return;
        }
        throw zzrk.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.dd
    public final <K, V> void a(Map<K, V> map, co<K, V> coVar, zzqp zzqpVar) {
        a(2);
        int zzaq = this.a.zzaq(this.a.zznr());
        Object obj = coVar.b;
        Object obj2 = coVar.d;
        while (true) {
            try {
                int a = a();
                if (a != Integer.MAX_VALUE && !this.a.zzny()) {
                    switch (a) {
                        case 1:
                            obj = a(coVar.a, (Class<?>) null, (zzqp) null);
                            break;
                        case 2:
                            obj2 = a(coVar.c, coVar.d.getClass(), zzqpVar);
                            break;
                        default:
                            try {
                                if (!c()) {
                                    throw new zzrk("Unable to parse map entry.");
                                    break;
                                } else {
                                    break;
                                }
                            } catch (zzrl unused) {
                                if (!c()) {
                                    throw new zzrk("Unable to parse map entry.");
                                }
                                break;
                            }
                    }
                }
            } finally {
                this.a.zzar(zzaq);
            }
        }
        map.put(obj, obj2);
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final <T> T b(de<T> deVar, zzqp zzqpVar) {
        a(3);
        return (T) d(deVar, zzqpVar);
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void b(List<Float> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof bz)) {
            int i = this.b & 7;
            if (i == 2) {
                int zznr = this.a.zznr();
                c(zznr);
                int zznz = this.a.zznz() + zznr;
                do {
                    list.add(Float.valueOf(this.a.readFloat()));
                } while (this.a.zznz() < zznz);
                return;
            } else if (i != 5) {
                throw zzrk.e();
            } else {
                do {
                    list.add(Float.valueOf(this.a.readFloat()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            }
        }
        bz bzVar = (bz) list;
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zznr2 = this.a.zznr();
            c(zznr2);
            int zznz2 = this.a.zznz() + zznr2;
            do {
                bzVar.a(this.a.readFloat());
            } while (this.a.zznz() < zznz2);
        } else if (i2 != 5) {
            throw zzrk.e();
        } else {
            do {
                bzVar.a(this.a.readFloat());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.dd
    public final <T> void b(List<T> list, de<T> deVar, zzqp zzqpVar) {
        int zzni;
        int i = this.b;
        if ((i & 7) == 3) {
            do {
                list.add(d(deVar, zzqpVar));
                if (this.a.zzny() || this.d != 0) {
                    return;
                }
                zzni = this.a.zzni();
            } while (zzni == i);
            this.d = zzni;
            return;
        }
        throw zzrk.e();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void c(List<Long> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof ck)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.a.zznj()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            } else if (i != 2) {
                throw zzrk.e();
            } else {
                int zznz = this.a.zznz() + this.a.zznr();
                do {
                    list.add(Long.valueOf(this.a.zznj()));
                } while (this.a.zznz() < zznz);
                d(zznz);
                return;
            }
        }
        ck ckVar = (ck) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                ckVar.a(this.a.zznj());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        } else if (i2 != 2) {
            throw zzrk.e();
        } else {
            int zznz2 = this.a.zznz() + this.a.zznr();
            do {
                ckVar.a(this.a.zznj());
            } while (this.a.zznz() < zznz2);
            d(zznz2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final boolean c() {
        int i;
        if (this.a.zzny() || (i = this.b) == this.c) {
            return false;
        }
        return this.a.zzao(i);
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final double d() {
        a(1);
        return this.a.readDouble();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void d(List<Long> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof ck)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.a.zznk()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            } else if (i != 2) {
                throw zzrk.e();
            } else {
                int zznz = this.a.zznz() + this.a.zznr();
                do {
                    list.add(Long.valueOf(this.a.zznk()));
                } while (this.a.zznz() < zznz);
                d(zznz);
                return;
            }
        }
        ck ckVar = (ck) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                ckVar.a(this.a.zznk());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        } else if (i2 != 2) {
            throw zzrk.e();
        } else {
            int zznz2 = this.a.zznz() + this.a.zznr();
            do {
                ckVar.a(this.a.zznk());
            } while (this.a.zznz() < zznz2);
            d(zznz2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final float e() {
        a(5);
        return this.a.readFloat();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void e(List<Integer> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof cc)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.a.zznl()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            } else if (i != 2) {
                throw zzrk.e();
            } else {
                int zznz = this.a.zznz() + this.a.zznr();
                do {
                    list.add(Integer.valueOf(this.a.zznl()));
                } while (this.a.zznz() < zznz);
                d(zznz);
                return;
            }
        }
        cc ccVar = (cc) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                ccVar.b(this.a.zznl());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        } else if (i2 != 2) {
            throw zzrk.e();
        } else {
            int zznz2 = this.a.zznz() + this.a.zznr();
            do {
                ccVar.b(this.a.zznl());
            } while (this.a.zznz() < zznz2);
            d(zznz2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final long f() {
        a(0);
        return this.a.zznj();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void f(List<Long> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof ck)) {
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zznr = this.a.zznr();
                    b(zznr);
                    int zznz = this.a.zznz() + zznr;
                    do {
                        list.add(Long.valueOf(this.a.zznm()));
                    } while (this.a.zznz() < zznz);
                    return;
                default:
                    throw zzrk.e();
            }
            do {
                list.add(Long.valueOf(this.a.zznm()));
                if (this.a.zzny()) {
                    return;
                }
                zzni = this.a.zzni();
            } while (zzni == this.b);
            this.d = zzni;
            return;
        }
        ck ckVar = (ck) list;
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zznr2 = this.a.zznr();
                b(zznr2);
                int zznz2 = this.a.zznz() + zznr2;
                do {
                    ckVar.a(this.a.zznm());
                } while (this.a.zznz() < zznz2);
                return;
            default:
                throw zzrk.e();
        }
        do {
            ckVar.a(this.a.zznm());
            if (this.a.zzny()) {
                return;
            }
            zzni2 = this.a.zzni();
        } while (zzni2 == this.b);
        this.d = zzni2;
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final long g() {
        a(0);
        return this.a.zznk();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void g(List<Integer> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof cc)) {
            int i = this.b & 7;
            if (i == 2) {
                int zznr = this.a.zznr();
                c(zznr);
                int zznz = this.a.zznz() + zznr;
                do {
                    list.add(Integer.valueOf(this.a.zznn()));
                } while (this.a.zznz() < zznz);
                return;
            } else if (i != 5) {
                throw zzrk.e();
            } else {
                do {
                    list.add(Integer.valueOf(this.a.zznn()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            }
        }
        cc ccVar = (cc) list;
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zznr2 = this.a.zznr();
            c(zznr2);
            int zznz2 = this.a.zznz() + zznr2;
            do {
                ccVar.b(this.a.zznn());
            } while (this.a.zznz() < zznz2);
        } else if (i2 != 5) {
            throw zzrk.e();
        } else {
            do {
                ccVar.b(this.a.zznn());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final int h() {
        a(0);
        return this.a.zznl();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void h(List<Boolean> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof az)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Boolean.valueOf(this.a.zzno()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            } else if (i != 2) {
                throw zzrk.e();
            } else {
                int zznz = this.a.zznz() + this.a.zznr();
                do {
                    list.add(Boolean.valueOf(this.a.zzno()));
                } while (this.a.zznz() < zznz);
                d(zznz);
                return;
            }
        }
        az azVar = (az) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                azVar.a(this.a.zzno());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        } else if (i2 != 2) {
            throw zzrk.e();
        } else {
            int zznz2 = this.a.zznz() + this.a.zznr();
            do {
                azVar.a(this.a.zzno());
            } while (this.a.zznz() < zznz2);
            d(zznz2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final long i() {
        a(1);
        return this.a.zznm();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void i(List<String> list) {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final int j() {
        a(5);
        return this.a.zznn();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void j(List<String> list) {
        a(list, true);
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void k(List<zzps> list) {
        int zzni;
        if ((this.b & 7) == 2) {
            do {
                list.add(n());
                if (this.a.zzny()) {
                    return;
                }
                zzni = this.a.zzni();
            } while (zzni == this.b);
            this.d = zzni;
            return;
        }
        throw zzrk.e();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final boolean k() {
        a(0);
        return this.a.zzno();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final String l() {
        a(2);
        return this.a.readString();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void l(List<Integer> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof cc)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.a.zznr()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            } else if (i != 2) {
                throw zzrk.e();
            } else {
                int zznz = this.a.zznz() + this.a.zznr();
                do {
                    list.add(Integer.valueOf(this.a.zznr()));
                } while (this.a.zznz() < zznz);
                d(zznz);
                return;
            }
        }
        cc ccVar = (cc) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                ccVar.b(this.a.zznr());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        } else if (i2 != 2) {
            throw zzrk.e();
        } else {
            int zznz2 = this.a.zznz() + this.a.zznr();
            do {
                ccVar.b(this.a.zznr());
            } while (this.a.zznz() < zznz2);
            d(zznz2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final String m() {
        a(2);
        return this.a.zznp();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void m(List<Integer> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof cc)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.a.zzns()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            } else if (i != 2) {
                throw zzrk.e();
            } else {
                int zznz = this.a.zznz() + this.a.zznr();
                do {
                    list.add(Integer.valueOf(this.a.zzns()));
                } while (this.a.zznz() < zznz);
                d(zznz);
                return;
            }
        }
        cc ccVar = (cc) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                ccVar.b(this.a.zzns());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        } else if (i2 != 2) {
            throw zzrk.e();
        } else {
            int zznz2 = this.a.zznz() + this.a.zznr();
            do {
                ccVar.b(this.a.zzns());
            } while (this.a.zznz() < zznz2);
            d(zznz2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final zzps n() {
        a(2);
        return this.a.zznq();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void n(List<Integer> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof cc)) {
            int i = this.b & 7;
            if (i == 2) {
                int zznr = this.a.zznr();
                c(zznr);
                int zznz = this.a.zznz() + zznr;
                do {
                    list.add(Integer.valueOf(this.a.zznt()));
                } while (this.a.zznz() < zznz);
                return;
            } else if (i != 5) {
                throw zzrk.e();
            } else {
                do {
                    list.add(Integer.valueOf(this.a.zznt()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            }
        }
        cc ccVar = (cc) list;
        int i2 = this.b & 7;
        if (i2 == 2) {
            int zznr2 = this.a.zznr();
            c(zznr2);
            int zznz2 = this.a.zznz() + zznr2;
            do {
                ccVar.b(this.a.zznt());
            } while (this.a.zznz() < zznz2);
        } else if (i2 != 5) {
            throw zzrk.e();
        } else {
            do {
                ccVar.b(this.a.zznt());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final int o() {
        a(0);
        return this.a.zznr();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void o(List<Long> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof ck)) {
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int zznr = this.a.zznr();
                    b(zznr);
                    int zznz = this.a.zznz() + zznr;
                    do {
                        list.add(Long.valueOf(this.a.zznu()));
                    } while (this.a.zznz() < zznz);
                    return;
                default:
                    throw zzrk.e();
            }
            do {
                list.add(Long.valueOf(this.a.zznu()));
                if (this.a.zzny()) {
                    return;
                }
                zzni = this.a.zzni();
            } while (zzni == this.b);
            this.d = zzni;
            return;
        }
        ck ckVar = (ck) list;
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int zznr2 = this.a.zznr();
                b(zznr2);
                int zznz2 = this.a.zznz() + zznr2;
                do {
                    ckVar.a(this.a.zznu());
                } while (this.a.zznz() < zznz2);
                return;
            default:
                throw zzrk.e();
        }
        do {
            ckVar.a(this.a.zznu());
            if (this.a.zzny()) {
                return;
            }
            zzni2 = this.a.zzni();
        } while (zzni2 == this.b);
        this.d = zzni2;
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final int p() {
        a(0);
        return this.a.zzns();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void p(List<Integer> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof cc)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.a.zznv()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            } else if (i != 2) {
                throw zzrk.e();
            } else {
                int zznz = this.a.zznz() + this.a.zznr();
                do {
                    list.add(Integer.valueOf(this.a.zznv()));
                } while (this.a.zznz() < zznz);
                d(zznz);
                return;
            }
        }
        cc ccVar = (cc) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                ccVar.b(this.a.zznv());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        } else if (i2 != 2) {
            throw zzrk.e();
        } else {
            int zznz2 = this.a.zznz() + this.a.zznr();
            do {
                ccVar.b(this.a.zznv());
            } while (this.a.zznz() < zznz2);
            d(zznz2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final int q() {
        a(5);
        return this.a.zznt();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void q(List<Long> list) {
        int zzni;
        int zzni2;
        if (!(list instanceof ck)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.a.zznw()));
                    if (this.a.zzny()) {
                        return;
                    }
                    zzni = this.a.zzni();
                } while (zzni == this.b);
                this.d = zzni;
                return;
            } else if (i != 2) {
                throw zzrk.e();
            } else {
                int zznz = this.a.zznz() + this.a.zznr();
                do {
                    list.add(Long.valueOf(this.a.zznw()));
                } while (this.a.zznz() < zznz);
                d(zznz);
                return;
            }
        }
        ck ckVar = (ck) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                ckVar.a(this.a.zznw());
                if (this.a.zzny()) {
                    return;
                }
                zzni2 = this.a.zzni();
            } while (zzni2 == this.b);
            this.d = zzni2;
        } else if (i2 != 2) {
            throw zzrk.e();
        } else {
            int zznz2 = this.a.zznz() + this.a.zznr();
            do {
                ckVar.a(this.a.zznw());
            } while (this.a.zznz() < zznz2);
            d(zznz2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final long r() {
        a(1);
        return this.a.zznu();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final int s() {
        a(0);
        return this.a.zznv();
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final long t() {
        a(0);
        return this.a.zznw();
    }
}
