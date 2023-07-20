package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    private Map<String, String> a = new HashMap();

    private final void a(String str, String str2) {
        Preconditions.checkNotNull(str, "Name should be non-null");
        this.a.put(str, str2);
    }

    public Promotion setCreative(String str) {
        a("cr", str);
        return this;
    }

    public Promotion setId(String str) {
        a("id", str);
        return this;
    }

    public Promotion setName(String str) {
        a("nm", str);
        return this;
    }

    public Promotion setPosition(String str) {
        a("ps", str);
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
