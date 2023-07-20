package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
public class zzrr {
    private static final zzqp a = zzqp.zzoq();
    private zzps b;
    private volatile zzsk c;
    private volatile zzps d;

    private final zzsk a(zzsk zzskVar) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        this.c = zzskVar;
                        this.d = zzps.zzavx;
                    } catch (zzrk unused) {
                        this.c = zzskVar;
                        this.d = zzps.zzavx;
                    }
                }
            }
        }
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzrr)) {
            return false;
        }
        zzrr zzrrVar = (zzrr) obj;
        zzsk zzskVar = this.c;
        zzsk zzskVar2 = zzrrVar.c;
        return (zzskVar == null && zzskVar2 == null) ? zzmv().equals(zzrrVar.zzmv()) : (zzskVar == null || zzskVar2 == null) ? zzskVar != null ? zzskVar.equals(zzrrVar.a(zzskVar.zzpi())) : a(zzskVar2.zzpi()).equals(zzskVar2) : zzskVar.equals(zzskVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzsk zzi(zzsk zzskVar) {
        zzsk zzskVar2 = this.c;
        this.b = null;
        this.d = null;
        this.c = zzskVar;
        return zzskVar2;
    }

    public final zzps zzmv() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            this.d = this.c == null ? zzps.zzavx : this.c.zzmv();
            return this.d;
        }
    }

    public final int zzpe() {
        if (this.d != null) {
            return this.d.size();
        }
        if (this.c == null) {
            return 0;
        }
        return this.c.zzpe();
    }
}
