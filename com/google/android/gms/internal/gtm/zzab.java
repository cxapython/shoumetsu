package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzab extends com.google.android.gms.analytics.zzi<zzab> {
    public String zzvh;
    public String zzvi;
    public String zzvj;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("network", this.zzvh);
        hashMap.put("action", this.zzvi);
        hashMap.put("target", this.zzvj);
        return zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzab zzabVar) {
        zzab zzabVar2 = zzabVar;
        if (!TextUtils.isEmpty(this.zzvh)) {
            zzabVar2.zzvh = this.zzvh;
        }
        if (!TextUtils.isEmpty(this.zzvi)) {
            zzabVar2.zzvi = this.zzvi;
        }
        if (!TextUtils.isEmpty(this.zzvj)) {
            zzabVar2.zzvj = this.zzvj;
        }
    }
}
