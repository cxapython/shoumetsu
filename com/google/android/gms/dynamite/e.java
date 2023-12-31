package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class e implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.zzb zza(Context context, String str, DynamiteModule.VersionPolicy.zza zzaVar) {
        DynamiteModule.VersionPolicy.zzb zzbVar = new DynamiteModule.VersionPolicy.zzb();
        zzbVar.zzir = zzaVar.getLocalVersion(context, str);
        zzbVar.zzis = zzbVar.zzir != 0 ? zzaVar.zza(context, str, false) : zzaVar.zza(context, str, true);
        if (zzbVar.zzir == 0 && zzbVar.zzis == 0) {
            zzbVar.zzit = 0;
        } else if (zzbVar.zzir >= zzbVar.zzis) {
            zzbVar.zzit = -1;
        } else {
            zzbVar.zzit = 1;
        }
        return zzbVar;
    }
}
