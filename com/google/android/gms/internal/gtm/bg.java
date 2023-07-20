package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bg {
    private final zzqj a;
    private final byte[] b;

    private bg(int i) {
        this.b = new byte[i];
        this.a = zzqj.zzg(this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bg(int i, ba baVar) {
        this(i);
    }

    public final zzps a() {
        if (this.a.zzoi() == 0) {
            return new bi(this.b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzqj b() {
        return this.a;
    }
}
