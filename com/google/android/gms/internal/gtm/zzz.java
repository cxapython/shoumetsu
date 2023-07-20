package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzz extends com.google.android.gms.analytics.zzi<zzz> {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private double h;

    public final void setClientId(String str) {
        this.b = str;
    }

    public final void setUserId(String str) {
        this.c = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.a);
        hashMap.put("clientId", this.b);
        hashMap.put(net.gree.gamelib.payment.internal.a.g.c, this.c);
        hashMap.put("androidAdId", this.d);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.e));
        hashMap.put("sessionControl", this.f);
        hashMap.put("nonInteraction", Boolean.valueOf(this.g));
        hashMap.put("sampleRate", Double.valueOf(this.h));
        return zza((Object) hashMap);
    }

    public final void zza(boolean z) {
        this.e = z;
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzz zzzVar) {
        zzz zzzVar2 = zzzVar;
        if (!TextUtils.isEmpty(this.a)) {
            zzzVar2.a = this.a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            zzzVar2.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            zzzVar2.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            zzzVar2.d = this.d;
        }
        boolean z = true;
        if (this.e) {
            zzzVar2.e = true;
        }
        if (!TextUtils.isEmpty(this.f)) {
            zzzVar2.f = this.f;
        }
        boolean z2 = this.g;
        if (z2) {
            zzzVar2.g = z2;
        }
        double d = this.h;
        if (d != 0.0d) {
            if (d < 0.0d || d > 100.0d) {
                z = false;
            }
            Preconditions.checkArgument(z, "Sample rate must be between 0% and 100%");
            zzzVar2.h = d;
        }
    }

    public final void zzb(boolean z) {
        this.g = true;
    }

    public final String zzbs() {
        return this.a;
    }

    public final String zzbt() {
        return this.b;
    }

    public final String zzbu() {
        return this.c;
    }

    public final String zzbv() {
        return this.d;
    }

    public final boolean zzbw() {
        return this.e;
    }

    public final String zzbx() {
        return this.f;
    }

    public final boolean zzby() {
        return this.g;
    }

    public final double zzbz() {
        return this.h;
    }

    public final void zzl(String str) {
        this.a = str;
    }

    public final void zzm(String str) {
        this.d = str;
    }
}
