package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes.dex */
final class ef extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.APP_NAME.toString();
    private final Context b;

    public ef(Context context) {
        super(a, new String[0]);
        this.b = context;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        try {
            PackageManager packageManager = this.b.getPackageManager();
            return zzgj.zzi(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.b.getPackageName(), 0)).toString());
        } catch (PackageManager.NameNotFoundException e) {
            zzdi.zza("App name is not found.", e);
            return zzgj.zzkc();
        }
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
