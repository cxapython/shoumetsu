package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public final class zzfj {
    private final zzfh a = new zzfh();

    public final zzfj zzb(long j) {
        this.a.a = j;
        return this;
    }

    public final zzfj zzb(byte[] bArr) {
        this.a.c = bArr;
        return this;
    }

    public final zzfj zzc(long j) {
        this.a.f = j;
        return this;
    }

    public final zzfj zzc(ParcelFileDescriptor parcelFileDescriptor) {
        this.a.d = parcelFileDescriptor;
        return this;
    }

    public final zzfj zzd(int i) {
        this.a.b = i;
        return this;
    }

    public final zzfj zzd(ParcelFileDescriptor parcelFileDescriptor) {
        this.a.g = parcelFileDescriptor;
        return this;
    }

    public final zzfj zze(String str) {
        this.a.e = str;
        return this;
    }

    public final zzfh zzr() {
        return this.a;
    }
}
