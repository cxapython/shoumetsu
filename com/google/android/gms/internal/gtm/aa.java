package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class aa implements zzbp<zzcc> {
    private final zzap a;
    private final zzcc b = new zzcc();

    public aa(zzap zzapVar) {
        this.a = zzapVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zza(String str, boolean z) {
        if (!"ga_dryRun".equals(str)) {
            this.a.zzco().zzd("Bool xml configuration name not recognized", str);
            return;
        }
        this.b.zzaay = z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.b.zzaax = i;
        } else {
            this.a.zzco().zzd("Int xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, String str2) {
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzc(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.b.zzaau = str2;
        } else if ("ga_appVersion".equals(str)) {
            this.b.zzaav = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.b.zzaaw = str2;
        } else {
            this.a.zzco().zzd("String xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final /* synthetic */ zzcc zzel() {
        return this.b;
    }
}
