package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
final class at extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.INSTALL_REFERRER.toString();
    private static final String b = zzb.COMPONENT.toString();
    private final Context c;

    public at(Context context) {
        super(a, new String[0]);
        this.c = context;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String zze = zzcw.zze(this.c, map.get(b) != null ? zzgj.zzc(map.get(b)) : null);
        return zze != null ? zzgj.zzi(zze) : zzgj.zzkc();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
