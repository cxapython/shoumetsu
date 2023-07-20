package androidx.core.c;

import android.os.Build;

/* loaded from: classes.dex */
public class a {
    public static boolean a() {
        return Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'Q' && Build.VERSION.CODENAME.charAt(0) <= 'Z';
    }
}
