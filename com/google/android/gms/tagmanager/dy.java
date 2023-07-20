package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
abstract class dy extends ag {
    public dy(String str, String... strArr) {
        super(str, strArr);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public zzl zzb(Map<String, zzl> map) {
        zzd(map);
        return zzgj.zzkc();
    }

    public abstract void zzd(Map<String, zzl> map);

    @Override // com.google.android.gms.tagmanager.ag
    public boolean zzgw() {
        return false;
    }
}
