package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends dy {
    private static final String a = com.google.android.gms.internal.gtm.zza.DATA_LAYER_WRITE.toString();
    private static final String b = zzb.VALUE.toString();
    private static final String c = zzb.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer d;

    public w(DataLayer dataLayer) {
        super(a, b);
        this.d = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.dy
    public final void zzd(Map<String, zzl> map) {
        String zzc;
        zzl zzlVar = map.get(b);
        if (zzlVar != null && zzlVar != zzgj.zzjw()) {
            Object zzh = zzgj.zzh(zzlVar);
            if (zzh instanceof List) {
                for (Object obj : (List) zzh) {
                    if (obj instanceof Map) {
                        this.d.push((Map) obj);
                    }
                }
            }
        }
        zzl zzlVar2 = map.get(c);
        if (zzlVar2 == null || zzlVar2 == zzgj.zzjw() || (zzc = zzgj.zzc(zzlVar2)) == zzgj.zzkb()) {
            return;
        }
        this.d.a(zzc);
    }
}
