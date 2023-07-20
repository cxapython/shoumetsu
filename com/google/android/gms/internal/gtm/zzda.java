package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzda extends zzan {
    protected boolean a;
    protected int b;
    private String c;
    private String d;
    private int e;
    private boolean f;
    private boolean g;

    public zzda(zzap zzapVar) {
        super(zzapVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        ApplicationInfo applicationInfo;
        int i;
        zzcc zzq;
        Context e = e();
        try {
            applicationInfo = e.getPackageManager().getApplicationInfo(e.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            zzd("PackageManager doesn't know about the app package", e2);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzt("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) <= 0 || (zzq = new zzca(zzcm()).zzq(i)) == null) {
            return;
        }
        zzq("Loading global XML config values");
        boolean z = false;
        if (zzq.zzaau != null) {
            String str = zzq.zzaau;
            this.d = str;
            zzb("XML config - app name", str);
        }
        if (zzq.zzaav != null) {
            String str2 = zzq.zzaav;
            this.c = str2;
            zzb("XML config - app version", str2);
        }
        if (zzq.zzaaw != null) {
            String lowerCase = zzq.zzaaw.toLowerCase(Locale.US);
            int i2 = "verbose".equals(lowerCase) ? 0 : "info".equals(lowerCase) ? 1 : "warning".equals(lowerCase) ? 2 : "error".equals(lowerCase) ? 3 : -1;
            if (i2 >= 0) {
                this.e = i2;
                zza("XML config - log level", Integer.valueOf(i2));
            }
        }
        if (zzq.zzaax >= 0) {
            int i3 = zzq.zzaax;
            this.b = i3;
            this.a = true;
            zzb("XML config - dispatch period (sec)", Integer.valueOf(i3));
        }
        if (zzq.zzaay == -1) {
            return;
        }
        if (zzq.zzaay == 1) {
            z = true;
        }
        this.g = z;
        this.f = true;
        zzb("XML config - dry run", Boolean.valueOf(z));
    }

    public final String zzaz() {
        q();
        return this.d;
    }

    public final String zzba() {
        q();
        return this.c;
    }

    public final boolean zzgh() {
        q();
        return false;
    }

    public final boolean zzgi() {
        q();
        return this.f;
    }

    public final boolean zzgj() {
        q();
        return this.g;
    }
}
