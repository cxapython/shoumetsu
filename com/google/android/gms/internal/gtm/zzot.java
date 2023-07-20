package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzot {
    private final Map<String, zzl> a;
    private final zzl b;

    private zzot(Map<String, zzl> map, zzl zzlVar) {
        this.a = map;
        this.b = zzlVar;
    }

    public static zzou zzml() {
        return new zzou();
    }

    public final String toString() {
        String valueOf = String.valueOf(Collections.unmodifiableMap(this.a));
        String valueOf2 = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length());
        sb.append("Properties: ");
        sb.append(valueOf);
        sb.append(" pushAfterEvaluate: ");
        sb.append(valueOf2);
        return sb.toString();
    }

    public final void zza(String str, zzl zzlVar) {
        this.a.put(str, zzlVar);
    }

    public final zzl zzji() {
        return this.b;
    }

    public final Map<String, zzl> zzlu() {
        return Collections.unmodifiableMap(this.a);
    }
}
