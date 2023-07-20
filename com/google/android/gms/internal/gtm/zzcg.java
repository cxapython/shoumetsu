package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzcg {
    private final long a;
    private final int b;
    private double c;
    private long d;
    private final Object e;
    private final String f;
    private final Clock g;

    private zzcg(int i, long j, String str, Clock clock) {
        this.e = new Object();
        this.b = 60;
        this.c = this.b;
        this.a = 2000L;
        this.f = str;
        this.g = clock;
    }

    public zzcg(String str, Clock clock) {
        this(60, 2000L, str, clock);
    }

    public final boolean zzfm() {
        synchronized (this.e) {
            long currentTimeMillis = this.g.currentTimeMillis();
            if (this.c < this.b) {
                double d = (currentTimeMillis - this.d) / this.a;
                if (d > 0.0d) {
                    this.c = Math.min(this.b, this.c + d);
                }
            }
            this.d = currentTimeMillis;
            if (this.c >= 1.0d) {
                this.c -= 1.0d;
                return true;
            }
            String str = this.f;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
            sb.append("Excessive ");
            sb.append(str);
            sb.append(" detected; call ignored.");
            zzch.zzac(sb.toString());
            return false;
        }
    }
}
