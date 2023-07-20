package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzd;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public class Product {
    private Map<String, String> a = new HashMap();

    private final void a(String str, String str2) {
        Preconditions.checkNotNull(str, "Name should be non-null");
        this.a.put(str, str2);
    }

    public Product setBrand(String str) {
        a("br", str);
        return this;
    }

    public Product setCategory(String str) {
        a("ca", str);
        return this;
    }

    public Product setCouponCode(String str) {
        a("cc", str);
        return this;
    }

    public Product setCustomDimension(int i, String str) {
        a(zzd.zzo(i), str);
        return this;
    }

    public Product setCustomMetric(int i, int i2) {
        a(zzd.zzp(i), Integer.toString(i2));
        return this;
    }

    public Product setId(String str) {
        a("id", str);
        return this;
    }

    public Product setName(String str) {
        a("nm", str);
        return this;
    }

    public Product setPosition(int i) {
        a("ps", Integer.toString(i));
        return this;
    }

    public Product setPrice(double d) {
        a("pr", Double.toString(d));
        return this;
    }

    public Product setQuantity(int i) {
        a("qt", Integer.toString(i));
        return this;
    }

    public Product setVariant(String str) {
        a("va", str);
        return this;
    }

    public String toString() {
        return zzi.zza((Map) this.a);
    }

    public final Map<String, String> zzn(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), entry.getValue());
        }
        return hashMap;
    }
}
