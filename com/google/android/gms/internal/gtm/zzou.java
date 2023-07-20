package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzou {
    private final Map<String, zzl> a;
    private zzl b;

    private zzou() {
        this.a = new HashMap();
    }

    public final zzou zzb(String str, zzl zzlVar) {
        this.a.put(str, zzlVar);
        return this;
    }

    public final zzou zzm(zzl zzlVar) {
        this.b = zzlVar;
        return this;
    }

    public final zzot zzmm() {
        return new zzot(this.a, this.b);
    }
}
