package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzq extends com.google.android.gms.analytics.zzi<zzq> {
    private String a;
    private String b;
    private String c;
    private String d;

    public final void setAppId(String str) {
        this.c = str;
    }

    public final void setAppInstallerId(String str) {
        this.d = str;
    }

    public final void setAppName(String str) {
        this.a = str;
    }

    public final void setAppVersion(String str) {
        this.b = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.a);
        hashMap.put("appVersion", this.b);
        hashMap.put("appId", this.c);
        hashMap.put("appInstallerId", this.d);
        return zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    /* renamed from: zza */
    public final void zzb(zzq zzqVar) {
        if (!TextUtils.isEmpty(this.a)) {
            zzqVar.a = this.a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            zzqVar.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            zzqVar.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            zzqVar.d = this.d;
        }
    }

    public final String zzaz() {
        return this.a;
    }

    public final String zzba() {
        return this.b;
    }

    public final String zzbb() {
        return this.c;
    }

    public final String zzbc() {
        return this.d;
    }
}
