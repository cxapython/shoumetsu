package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzox;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cy implements da {
    private final /* synthetic */ Map a;
    private final /* synthetic */ Map b;
    private final /* synthetic */ Map c;
    private final /* synthetic */ Map d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cv cvVar, Map map, Map map2, Map map3, Map map4) {
        this.a = map;
        this.b = map2;
        this.c = map3;
        this.d = map4;
    }

    @Override // com.google.android.gms.tagmanager.da
    public final void a(zzox zzoxVar, Set<zzot> set, Set<zzot> set2, cj cjVar) {
        List list = (List) this.a.get(zzoxVar);
        this.b.get(zzoxVar);
        if (list != null) {
            set.addAll(list);
            cjVar.c();
        }
        List list2 = (List) this.c.get(zzoxVar);
        this.d.get(zzoxVar);
        if (list2 != null) {
            set2.addAll(list2);
            cjVar.d();
        }
    }
}
