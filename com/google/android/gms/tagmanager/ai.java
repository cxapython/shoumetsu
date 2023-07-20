package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
final class ai extends br {
    private static final String a = com.google.android.gms.internal.gtm.zza.GREATER_EQUALS.toString();

    public ai() {
        super(a);
    }

    @Override // com.google.android.gms.tagmanager.br
    protected final boolean a(dz dzVar, dz dzVar2, Map<String, zzl> map) {
        return dzVar.compareTo(dzVar2) >= 0;
    }
}
