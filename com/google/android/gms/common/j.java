package com.google.android.gms.common;

import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public class j {
    private static final j b = new j(true, null, null);
    final boolean a;
    private final String c;
    private final Throwable d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.a = z;
        this.c = str;
        this.d = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(String str) {
        return new j(false, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(String str, Throwable th) {
        return new j(false, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(Callable<String> callable) {
        return new l(callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, d dVar, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z2 ? "debug cert rejected" : "not whitelisted", str, Hex.bytesToStringLowercase(AndroidUtilsLight.zzj(Constants.SHA1).digest(dVar.a())), Boolean.valueOf(z), "12451009.false");
    }

    @Nullable
    String b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (this.a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.d != null) {
            Log.d("GoogleCertificatesRslt", b(), this.d);
        } else {
            Log.d("GoogleCertificatesRslt", b());
        }
    }
}
