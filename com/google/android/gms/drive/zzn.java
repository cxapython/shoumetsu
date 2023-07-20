package com.google.android.gms.drive;

@Deprecated
/* loaded from: classes.dex */
public final class zzn extends ExecutionOptions {
    private boolean a;

    private zzn(String str, boolean z, int i, boolean z2) {
        super(str, z, i);
        this.a = z2;
    }

    public static zzn zza(ExecutionOptions executionOptions) {
        zzp zzpVar = new zzp();
        if (executionOptions != null) {
            zzpVar.setConflictStrategy(executionOptions.zzm());
            zzpVar.setNotifyOnCompletion(executionOptions.zzl());
            String zzk = executionOptions.zzk();
            if (zzk != null) {
                zzpVar.setTrackingTag(zzk);
            }
        }
        return (zzn) zzpVar.build();
    }

    public final boolean zzo() {
        return this.a;
    }
}
