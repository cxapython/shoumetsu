package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.AdvertisingOptions;

/* loaded from: classes.dex */
public final class zzga {
    private final zzfy a = new zzfy();

    public final zzga zza(zzdd zzddVar) {
        this.a.b = zzddVar;
        return this;
    }

    public final zzga zza(zzec zzecVar) {
        this.a.a = zzecVar;
        return this;
    }

    public final zzga zzb(zzdj zzdjVar) {
        this.a.g = zzdjVar;
        return this;
    }

    public final zzga zzd(long j) {
        this.a.e = j;
        return this;
    }

    public final zzga zzg(AdvertisingOptions advertisingOptions) {
        this.a.f = advertisingOptions;
        return this;
    }

    public final zzga zzi(String str) {
        this.a.c = str;
        return this;
    }

    public final zzga zzj(String str) {
        this.a.d = str;
        return this;
    }

    public final zzfy zzv() {
        return this.a;
    }
}
