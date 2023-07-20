package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzbu extends zzan {
    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzbu(zzap zzapVar) {
        super(zzapVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
    }

    public final zzv zzfa() {
        q();
        return h().zzau();
    }

    public final String zzfb() {
        q();
        zzv zzfa = zzfa();
        int i = zzfa.zzul;
        int i2 = zzfa.zzum;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }
}
