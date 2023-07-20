package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;
import net.gree.gamelib.payment.shop.Product;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzr extends com.google.android.gms.analytics.zzi<zzr> {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public final String getId() {
        return this.f;
    }

    public final String getName() {
        return this.a;
    }

    public final String getSource() {
        return this.b;
    }

    public final void setName(String str) {
        this.a = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(Product.KEY_NAME, this.a);
        hashMap.put("source", this.b);
        hashMap.put(Constants.MEDIUM, this.c);
        hashMap.put("keyword", this.d);
        hashMap.put("content", this.e);
        hashMap.put("id", this.f);
        hashMap.put("adNetworkId", this.g);
        hashMap.put("gclid", this.h);
        hashMap.put("dclid", this.i);
        hashMap.put("aclid", this.j);
        return zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzr zzrVar) {
        zzr zzrVar2 = zzrVar;
        if (!TextUtils.isEmpty(this.a)) {
            zzrVar2.a = this.a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            zzrVar2.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            zzrVar2.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            zzrVar2.d = this.d;
        }
        if (!TextUtils.isEmpty(this.e)) {
            zzrVar2.e = this.e;
        }
        if (!TextUtils.isEmpty(this.f)) {
            zzrVar2.f = this.f;
        }
        if (!TextUtils.isEmpty(this.g)) {
            zzrVar2.g = this.g;
        }
        if (!TextUtils.isEmpty(this.h)) {
            zzrVar2.h = this.h;
        }
        if (!TextUtils.isEmpty(this.i)) {
            zzrVar2.i = this.i;
        }
        if (!TextUtils.isEmpty(this.j)) {
            zzrVar2.j = this.j;
        }
    }

    public final String zzbd() {
        return this.c;
    }

    public final String zzbe() {
        return this.d;
    }

    public final String zzbf() {
        return this.e;
    }

    public final String zzbg() {
        return this.g;
    }

    public final String zzbh() {
        return this.h;
    }

    public final String zzbi() {
        return this.i;
    }

    public final String zzbj() {
        return this.j;
    }

    public final void zzc(String str) {
        this.b = str;
    }

    public final void zzd(String str) {
        this.c = str;
    }

    public final void zze(String str) {
        this.d = str;
    }

    public final void zzf(String str) {
        this.e = str;
    }

    public final void zzg(String str) {
        this.f = str;
    }

    public final void zzh(String str) {
        this.g = str;
    }

    public final void zzi(String str) {
        this.h = str;
    }

    public final void zzj(String str) {
        this.i = str;
    }

    public final void zzk(String str) {
        this.j = str;
    }
}
