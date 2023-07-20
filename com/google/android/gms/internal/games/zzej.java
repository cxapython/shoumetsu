package com.google.android.gms.internal.games;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zzej {
    private final AtomicReference<zzeh> a = new AtomicReference<>();

    protected abstract zzeh a();

    public final void flush() {
        zzeh zzehVar = this.a.get();
        if (zzehVar != null) {
            zzehVar.flush();
        }
    }

    public final void zza(String str, int i) {
        zzeh zzehVar = this.a.get();
        if (zzehVar == null) {
            zzehVar = a();
            if (!this.a.compareAndSet(null, zzehVar)) {
                zzehVar = this.a.get();
            }
        }
        zzehVar.zzg(str, i);
    }
}
