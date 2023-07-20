package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ai {
    private final Clock a;
    private long b;

    public ai(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.a = clock;
    }

    public ai(Clock clock, long j) {
        Preconditions.checkNotNull(clock);
        this.a = clock;
        this.b = j;
    }

    public final void a() {
        this.b = this.a.elapsedRealtime();
    }

    public final boolean a(long j) {
        return this.b == 0 || this.a.elapsedRealtime() - this.b > j;
    }

    public final void b() {
        this.b = 0L;
    }
}
