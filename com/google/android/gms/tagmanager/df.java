package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* loaded from: classes.dex */
final class df implements cc {
    private final long a;
    private final int b;
    private double c;
    private long d;
    private final Object e;
    private final Clock f;

    public df() {
        this(60, 2000L);
    }

    private df(int i, long j) {
        this.e = new Object();
        this.b = 60;
        this.c = this.b;
        this.a = 2000L;
        this.f = DefaultClock.getInstance();
    }

    @Override // com.google.android.gms.tagmanager.cc
    public final boolean a() {
        synchronized (this.e) {
            long currentTimeMillis = this.f.currentTimeMillis();
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
            zzdi.zzac("No more tokens available.");
            return false;
        }
    }
}
