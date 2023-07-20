package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzw extends com.google.android.gms.analytics.zzi<zzw> {
    private final List<Product> a = new ArrayList();
    private final List<Promotion> b = new ArrayList();
    private final Map<String, List<Product>> c = new HashMap();
    private ProductAction d;

    public final String toString() {
        HashMap hashMap = new HashMap();
        if (!this.a.isEmpty()) {
            hashMap.put("products", this.a);
        }
        if (!this.b.isEmpty()) {
            hashMap.put("promotions", this.b);
        }
        if (!this.c.isEmpty()) {
            hashMap.put("impressions", this.c);
        }
        hashMap.put("productAction", this.d);
        return zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzw zzwVar) {
        zzw zzwVar2 = zzwVar;
        zzwVar2.a.addAll(this.a);
        zzwVar2.b.addAll(this.b);
        for (Map.Entry<String, List<Product>> entry : this.c.entrySet()) {
            String key = entry.getKey();
            for (Product product : entry.getValue()) {
                if (product != null) {
                    String str = key == null ? "" : key;
                    if (!zzwVar2.c.containsKey(str)) {
                        zzwVar2.c.put(str, new ArrayList());
                    }
                    zzwVar2.c.get(str).add(product);
                }
            }
        }
        ProductAction productAction = this.d;
        if (productAction != null) {
            zzwVar2.d = productAction;
        }
    }

    public final ProductAction zzbn() {
        return this.d;
    }

    public final List<Product> zzbo() {
        return Collections.unmodifiableList(this.a);
    }

    public final Map<String, List<Product>> zzbp() {
        return this.c;
    }

    public final List<Promotion> zzbq() {
        return Collections.unmodifiableList(this.b);
    }
}
