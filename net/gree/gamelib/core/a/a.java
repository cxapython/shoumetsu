package net.gree.gamelib.core.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import net.gree.gamelib.core.Core;

/* loaded from: classes.dex */
public class a {
    private static final String a = "RSA";
    private static final String b = "SHA1PRNG";
    private static final int c = 512;
    private static String d = null;
    private static String e = null;
    private static byte[] f = null;
    private static String g = null;
    private static String h = null;
    private static boolean i = false;
    private static String j = null;
    private static String k = null;
    private static boolean l = false;
    private static boolean m = false;
    private static String n;
    private static String o;
    private static String p;
    private static Semaphore q;
    private static AtomicBoolean r = new AtomicBoolean();
    private String s;
    private String t;
    private KeyPair u;
    private Semaphore v;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    /* renamed from: net.gree.gamelib.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066a {
        C0066a() {
        }

        static String a(Context context) {
            try {
                return WebSettings.getDefaultUserAgent(context);
            } catch (RuntimeException e) {
                e.printStackTrace();
                return "";
            }
        }

        static String b(Context context) {
            try {
                Constructor<?> declaredConstructor = Class.forName("android.webkit.WebSettingsClassic").getDeclaredConstructor(Context.class, Class.forName("android.webkit.WebViewClassic"));
                declaredConstructor.setAccessible(true);
                try {
                    try {
                        try {
                            try {
                                return ((WebSettings) declaredConstructor.newInstance(context, null)).getUserAgentString();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                                return new WebView(context).getSettings().getUserAgentString();
                            } catch (InvocationTargetException e2) {
                                e2.printStackTrace();
                                return new WebView(context).getSettings().getUserAgentString();
                            }
                        } catch (IllegalArgumentException e3) {
                            e3.printStackTrace();
                            return new WebView(context).getSettings().getUserAgentString();
                        }
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                        return new WebView(context).getSettings().getUserAgentString();
                    }
                } finally {
                    declaredConstructor.setAccessible(false);
                }
            } catch (ClassNotFoundException e5) {
                e5.printStackTrace();
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
            }
        }
    }

    a(Context context, String str, String str2) {
        this(context, str, str2, null);
    }

    public a(final Context context, String str, String str2, String str3) {
        String b2;
        this.s = null;
        this.t = null;
        this.u = null;
        if (q == null) {
            q = new Semaphore(1);
        }
        this.v = new Semaphore(1);
        if (!r.getAndSet(true)) {
            try {
                q.acquire();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (e == null) {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    e = a(context, Build.VERSION.SDK_INT);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.gree.gamelib.core.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String unused = a.e = a.this.a(context, Build.VERSION.SDK_INT);
                        }
                    });
                }
            }
            Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.core.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.d == null) {
                        String unused = a.d = a.this.a(context);
                    }
                    if (a.h == null) {
                        String unused2 = a.h = a.this.c(context);
                    }
                    if (a.g == null) {
                        String unused3 = a.g = a.this.d(context);
                    }
                    boolean unused4 = a.i = a.this.e(context);
                    a.q.release();
                }
            });
        }
        if (f == null) {
            f = b(context);
        }
        if (i(context)) {
            this.s = str;
            this.t = str2;
        } else {
            if (str3 != null) {
                this.s = a(str3, str);
                b2 = b(str3, str2);
            } else {
                this.s = a(f, str);
                b2 = b(f, str2);
            }
            this.t = b2;
        }
        if (j == null) {
            j = o();
        }
        if (k == null) {
            k = p();
        }
        l = g.a();
        m = f(context);
        n = g(context);
        o = h(context);
        p = q();
    }

    static boolean i(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return false;
            }
            return applicationInfo.metaData.getBoolean("skip_decryption");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void y() {
        try {
            try {
                q.acquire();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        } finally {
            q.release();
        }
    }

    PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public String a() {
        return this.s;
    }

    String a(Context context) {
        return net.gree.gamelib.core.a.a.a.b(Settings.Secure.getString(context.getContentResolver(), "android_id"));
    }

    String a(Context context, int i2) {
        if (i2 >= 17) {
            return C0066a.a(context);
        }
        if (i2 >= 16) {
            return C0066a.b(context);
        }
        try {
            Constructor declaredConstructor = WebSettings.class.getDeclaredConstructor(Context.class, WebView.class);
            declaredConstructor.setAccessible(true);
            try {
                String userAgentString = ((WebSettings) declaredConstructor.newInstance(context, null)).getUserAgentString();
                declaredConstructor.setAccessible(false);
                return userAgentString;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                declaredConstructor.setAccessible(false);
                return new WebView(context).getSettings().getUserAgentString();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                declaredConstructor.setAccessible(false);
                return new WebView(context).getSettings().getUserAgentString();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
                declaredConstructor.setAccessible(false);
                return new WebView(context).getSettings().getUserAgentString();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                declaredConstructor.setAccessible(false);
                return new WebView(context).getSettings().getUserAgentString();
            }
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
        }
    }

    String a(String str, String str2) {
        return net.gree.gamelib.core.a.a.a.a(str, str2);
    }

    String a(byte[] bArr, String str) {
        return net.gree.gamelib.core.a.a.a.b(bArr, str);
    }

    public String b() {
        return this.t;
    }

    String b(String str, String str2) {
        return net.gree.gamelib.core.a.a.a.a(str, str2);
    }

    String b(byte[] bArr, String str) {
        return net.gree.gamelib.core.a.a.a.b(bArr, str);
    }

    byte[] b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "".getBytes();
        }
    }

    public String c() {
        y();
        return d;
    }

    String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 1).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String d() {
        y();
        return e;
    }

    String d(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public String e() {
        y();
        return g;
    }

    boolean e(Context context) {
        return new File("/system/bin/su").exists() || new File("/system/app/Superuser.apk").exists() || a(context, "com.noshufou.android.su") != null;
    }

    public String f() {
        y();
        return h;
    }

    boolean f(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    String g(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    public boolean g() {
        y();
        return i;
    }

    public String h() {
        return j;
    }

    String h(Context context) {
        return context.getPackageName();
    }

    public String i() {
        return k;
    }

    public boolean j() {
        return l;
    }

    public boolean k() {
        return m;
    }

    public String l() {
        return n;
    }

    public String m() {
        return o;
    }

    public String n() {
        return p;
    }

    String o() {
        return Locale.getDefault().getCountry();
    }

    String p() {
        try {
            return Currency.getInstance(Locale.getDefault()).getCurrencyCode();
        } catch (IllegalArgumentException | NullPointerException unused) {
            return "";
        }
    }

    String q() {
        return Build.VERSION.RELEASE;
    }

    public String r() {
        if (this.u == null) {
            t();
        }
        try {
            try {
                this.v.acquire();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            KeyPair keyPair = this.u;
            if (keyPair == null) {
                return null;
            }
            return net.gree.gamelib.core.a.a.b.a(((RSAPublicKey) keyPair.getPublic()).getEncoded());
        } finally {
            this.v.release();
        }
    }

    public String s() {
        if (this.u == null) {
            t();
        }
        try {
            try {
                this.v.acquire();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            KeyPair keyPair = this.u;
            if (keyPair == null) {
                return null;
            }
            return net.gree.gamelib.core.a.a.b.a(((RSAPrivateKey) keyPair.getPrivate()).getEncoded());
        } finally {
            this.v.release();
        }
    }

    public void t() {
        try {
            this.v.acquire();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.core.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(a.a);
                    keyPairGenerator.initialize(a.c, SecureRandom.getInstance(a.b));
                    a.this.u = keyPairGenerator.generateKeyPair();
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
                a.this.v.release();
            }
        });
    }
}
