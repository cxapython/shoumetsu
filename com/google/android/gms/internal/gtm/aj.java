package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class aj extends zzam implements zzbp<zzcy> {
    private final zzcy a;

    public aj(zzap zzapVar) {
        super(zzapVar);
        this.a = new zzcy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zza(String str, boolean z) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.a.zzacp = z;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.a.zzacq = z;
        } else if (!"ga_reportUncaughtExceptions".equals(str)) {
            zzd("bool configuration name not recognized", str);
        } else {
            this.a.zzacr = z ? 1 : 0;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.a.zzaco = i;
        } else {
            zzd("int configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, String str2) {
        this.a.zzacs.put(str, str2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzc(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.a.zzacm = str2;
        } else if (!"ga_sampleFrequency".equals(str)) {
            zzd("string configuration name not recognized", str);
        } else {
            try {
                this.a.zzacn = Double.parseDouble(str2);
            } catch (NumberFormatException e) {
                zzc("Error parsing ga_sampleFrequency value", str2, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final /* synthetic */ zzcy zzel() {
        return this.a;
    }
}
