package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class ag {
    private final Set<String> a;
    private final String b;

    public ag(String str, String... strArr) {
        this.b = str;
        this.a = new HashSet(strArr.length);
        for (String str2 : strArr) {
            this.a.add(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(Set<String> set) {
        return set.containsAll(this.a);
    }

    public abstract zzl zzb(Map<String, zzl> map);

    public abstract boolean zzgw();

    public String zzif() {
        return this.b;
    }

    public Set<String> zzig() {
        return this.a;
    }
}
