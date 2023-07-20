package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzbm extends dq {
    private static final String a = com.google.android.gms.internal.gtm.zza.EQUALS.toString();

    public zzbm() {
        super(a);
    }

    @Override // com.google.android.gms.tagmanager.dq
    protected final boolean a(String str, String str2, Map<String, zzl> map) {
        return str.equals(str2);
    }
}
