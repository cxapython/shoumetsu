package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class cw<T> implements de<T> {
    private final zzsk a;
    private final dv<?, ?> b;
    private final boolean c;
    private final bs<?> d;

    private cw(dv<?, ?> dvVar, bs<?> bsVar, zzsk zzskVar) {
        this.b = dvVar;
        this.c = bsVar.a(zzskVar);
        this.d = bsVar;
        this.a = zzskVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> cw<T> a(dv<?, ?> dvVar, bs<?> bsVar, zzsk zzskVar) {
        return new cw<>(dvVar, bsVar, zzskVar);
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final int a(T t) {
        int hashCode = this.b.b(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final T a() {
        return (T) this.a.zzph().zzpl();
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final void a(T t, dd ddVar, zzqp zzqpVar) {
        boolean z;
        dv<?, ?> dvVar = this.b;
        bs<?> bsVar = this.d;
        Object c = dvVar.c(t);
        bv<?> b = bsVar.b(t);
        do {
            try {
                if (ddVar.a() == Integer.MAX_VALUE) {
                    return;
                }
                int b2 = ddVar.b();
                if (b2 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzps zzpsVar = null;
                    while (ddVar.a() != Integer.MAX_VALUE) {
                        int b3 = ddVar.b();
                        if (b3 == 16) {
                            i = ddVar.o();
                            obj = bsVar.a(zzqpVar, this.a, i);
                        } else if (b3 == 26) {
                            if (obj != null) {
                                bsVar.a(ddVar, obj, zzqpVar, b);
                            } else {
                                zzpsVar = ddVar.n();
                            }
                        } else if (!ddVar.c()) {
                            break;
                        }
                    }
                    if (ddVar.b() != 12) {
                        throw zzrk.d();
                    } else if (zzpsVar != null) {
                        if (obj != null) {
                            bsVar.a(zzpsVar, obj, zzqpVar, b);
                        } else {
                            dvVar.a((dv<?, ?>) c, i, zzpsVar);
                        }
                    }
                } else if ((b2 & 7) == 2) {
                    Object a = bsVar.a(zzqpVar, this.a, b2 >>> 3);
                    if (a != null) {
                        bsVar.a(ddVar, a, zzqpVar, b);
                    } else {
                        z = dvVar.a((dv<?, ?>) c, ddVar);
                        continue;
                    }
                } else {
                    z = ddVar.c();
                    continue;
                }
                z = true;
                continue;
            } finally {
                dvVar.b((Object) t, (T) c);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final void a(T t, em emVar) {
        int zzc;
        Object value;
        Iterator<Map.Entry<?, Object>> d = this.d.a(t).d();
        while (d.hasNext()) {
            Map.Entry<?, Object> next = d.next();
            zzqv zzqvVar = (zzqv) next.getKey();
            if (zzqvVar.zzoy() != zzul.MESSAGE || zzqvVar.zzoz() || zzqvVar.zzpa()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof ce) {
                zzc = zzqvVar.zzc();
                value = ((ce) next).a().zzmv();
            } else {
                zzc = zzqvVar.zzc();
                value = next.getValue();
            }
            emVar.a(zzc, value);
        }
        dv<?, ?> dvVar = this.b;
        dvVar.b((dv<?, ?>) dvVar.b(t), emVar);
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final boolean a(T t, T t2) {
        if (!this.b.b(t).equals(this.b.b(t2))) {
            return false;
        }
        if (!this.c) {
            return true;
        }
        return this.d.a(t).equals(this.d.a(t2));
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final int b(T t) {
        dv<?, ?> dvVar = this.b;
        int e = dvVar.e(dvVar.b(t)) + 0;
        return this.c ? e + this.d.a(t).g() : e;
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final void b(T t, T t2) {
        dg.a(this.b, t, t2);
        if (this.c) {
            dg.a(this.d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final void c(T t) {
        this.b.d(t);
        this.d.c(t);
    }

    @Override // com.google.android.gms.internal.gtm.de
    public final boolean d(T t) {
        return this.d.a(t).f();
    }
}
