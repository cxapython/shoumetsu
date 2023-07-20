package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
abstract class br extends zzef {
    public br(String str) {
        super(str);
    }

    @Override // com.google.android.gms.tagmanager.zzef
    protected final boolean a(zzl zzlVar, zzl zzlVar2, Map<String, zzl> map) {
        dz zzd = zzgj.zzd(zzlVar);
        dz zzd2 = zzgj.zzd(zzlVar2);
        if (zzd == zzgj.zzka() || zzd2 == zzgj.zzka()) {
            return false;
        }
        return a(zzd, zzd2, map);
    }

    protected abstract boolean a(dz dzVar, dz dzVar2, Map<String, zzl> map);
}
