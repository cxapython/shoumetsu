package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* loaded from: classes.dex */
public final class b {
    private static volatile zzm a;
    private static final Object b = new Object();
    private static Context c;

    public static j a(String str, d dVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return b(str, dVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static final /* synthetic */ String a(boolean z, String str, d dVar) {
        boolean z2 = true;
        if (z || !b(str, dVar, true, false).a) {
            z2 = false;
        }
        return j.a(str, dVar, z, z2);
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                c = context.getApplicationContext();
            }
        }
    }

    private static j b(String str, d dVar, boolean z, boolean z2) {
        try {
            if (a == null) {
                Preconditions.checkNotNull(c);
                synchronized (b) {
                    if (a == null) {
                        a = zzn.zzc(DynamiteModule.load(c, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            Preconditions.checkNotNull(c);
            try {
                return a.zza(new zzk(str, dVar, z, z2), ObjectWrapper.wrap(c.getPackageManager())) ? j.a() : j.a(new Callable(z, str, dVar) { // from class: com.google.android.gms.common.c
                    private final boolean a;
                    private final String b;
                    private final d c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = z;
                        this.b = str;
                        this.c = dVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return b.a(this.a, this.b, this.c);
                    }
                });
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return j.a("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String valueOf = String.valueOf(e2.getMessage());
            return j.a(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e2);
        }
    }
}
