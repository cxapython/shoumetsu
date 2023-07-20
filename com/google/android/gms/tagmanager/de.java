package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
final class de extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.SDK_VERSION.toString();

    public de() {
        super(a, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(Integer.valueOf(Build.VERSION.SDK_INT));
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
