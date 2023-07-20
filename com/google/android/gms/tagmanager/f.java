package com.google.android.gms.tagmanager;

/* loaded from: classes.dex */
final class f implements zzw {
    private final /* synthetic */ zzy a;

    private f(zzy zzyVar) {
        this.a = zzyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(zzy zzyVar, eq eqVar) {
        this(zzyVar);
    }

    @Override // com.google.android.gms.tagmanager.zzw
    public final void zzao(String str) {
        this.a.a(str);
    }

    @Override // com.google.android.gms.tagmanager.zzw
    public final String zzhc() {
        return this.a.a();
    }

    @Override // com.google.android.gms.tagmanager.zzw
    public final void zzhe() {
        if (zzy.a(this.a).a()) {
            zzy.a(this.a, 0L);
        }
    }
}
