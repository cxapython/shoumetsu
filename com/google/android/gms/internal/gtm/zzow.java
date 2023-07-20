package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzgj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzow {
    private final List<zzox> a;
    private final Map<String, List<zzot>> b;
    private String c;
    private int d;

    private zzow() {
        this.a = new ArrayList();
        this.b = new HashMap();
        this.c = "";
        this.d = 0;
    }

    public final zzow zzaf(int i) {
        this.d = i;
        return this;
    }

    public final zzow zzb(zzox zzoxVar) {
        this.a.add(zzoxVar);
        return this;
    }

    public final zzow zzc(zzot zzotVar) {
        String zzc = zzgj.zzc(zzotVar.zzlu().get(zzb.INSTANCE_NAME.toString()));
        List<zzot> list = this.b.get(zzc);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(zzc, list);
        }
        list.add(zzotVar);
        return this;
    }

    public final zzow zzcs(String str) {
        this.c = str;
        return this;
    }

    public final zzov zzmp() {
        return new zzov(this.a, this.b, this.c, this.d);
    }
}
