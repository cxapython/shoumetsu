package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
final class j extends dq {
    private static final String a = com.google.android.gms.internal.gtm.zza.CONTAINS.toString();

    public j() {
        super(a);
    }

    @Override // com.google.android.gms.tagmanager.dq
    protected final boolean a(String str, String str2, Map<String, zzl> map) {
        return str.contains(str2);
    }
}
