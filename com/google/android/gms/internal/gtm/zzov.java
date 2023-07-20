package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzov {
    private final List<zzox> a;
    private final Map<String, List<zzot>> b;
    private final String c;
    private final int d;

    private zzov(List<zzox> list, Map<String, List<zzot>> map, String str, int i) {
        this.a = Collections.unmodifiableList(list);
        this.b = Collections.unmodifiableMap(map);
        this.c = str;
        this.d = i;
    }

    public static zzow zzmn() {
        return new zzow();
    }

    public final String getVersion() {
        return this.c;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String valueOf2 = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17 + String.valueOf(valueOf2).length());
        sb.append("Rules: ");
        sb.append(valueOf);
        sb.append("  Macros: ");
        sb.append(valueOf2);
        return sb.toString();
    }

    public final List<zzox> zzls() {
        return this.a;
    }

    public final Map<String, List<zzot>> zzmo() {
        return this.b;
    }
}
