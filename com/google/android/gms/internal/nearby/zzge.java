package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* loaded from: classes.dex */
public final class zzge {
    private final zzgc a = new zzgc();

    public final zzge zza(zzdr zzdrVar) {
        this.a.f = zzdrVar;
        return this;
    }

    public final zzge zze(long j) {
        this.a.d = j;
        return this;
    }

    public final zzge zze(DiscoveryOptions discoveryOptions) {
        this.a.e = discoveryOptions;
        return this;
    }

    public final zzge zzf(zzdz zzdzVar) {
        this.a.a = zzdzVar;
        return this;
    }

    public final zzge zzk(String str) {
        this.a.c = str;
        return this;
    }

    public final zzgc zzw() {
        return this.a;
    }
}
