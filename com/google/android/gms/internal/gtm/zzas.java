package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzas {
    private final long a;
    private final String b;
    private final String c;
    private final boolean d;
    private long e;
    private final Map<String, String> f;

    public zzas(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.a = 0L;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = j2;
        this.f = map != null ? new HashMap<>(map) : Collections.emptyMap();
    }

    public final void zzb(long j) {
        this.e = j;
    }

    public final String zzbt() {
        return this.b;
    }

    public final long zzdi() {
        return this.a;
    }

    public final String zzdj() {
        return this.c;
    }

    public final boolean zzdk() {
        return this.d;
    }

    public final long zzdl() {
        return this.e;
    }

    public final Map<String, String> zzdm() {
        return this.f;
    }
}
