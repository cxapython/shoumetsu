package com.microsoft.appcenter.b;

import android.content.Context;
import android.os.Build;
import com.adjust.sdk.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;

/* loaded from: classes.dex */
public class j {
    private static final Class[] a = {EOFException.class, InterruptedIOException.class, SocketException.class, UnknownHostException.class, RejectedExecutionException.class};
    private static final Pattern b = Pattern.compile("connection (time|reset|abort)|failure in ssl library, usually a protocol error|anchor for certification path not found");
    private static final Pattern c = Pattern.compile(":[^\"]+");
    private static final Pattern d = Pattern.compile("-[^,]+(,|$)");

    public static d a(Context context) {
        return a(context, true);
    }

    public static d a(Context context, boolean z) {
        return new h(b(context, z));
    }

    public static String a(String str) {
        int length = str.length();
        int i = 8;
        if (str.length() < 8) {
            i = 0;
        }
        int i2 = length - i;
        char[] cArr = new char[i2];
        Arrays.fill(cArr, '*');
        return new String(cArr) + str.substring(i2);
    }

    public static HttpsURLConnection a(URL url) {
        if (Constants.SCHEME.equals(url.getProtocol())) {
            URLConnection openConnection = url.openConnection();
            if (!(openConnection instanceof HttpsURLConnection)) {
                throw new IOException("App Center supports only HTTPS connection.");
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            if (Build.VERSION.SDK_INT <= 21) {
                httpsURLConnection.setSSLSocketFactory(new m());
            }
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(10000);
            return httpsURLConnection;
        }
        throw new IOException("App Center support only HTTPS connection.");
    }

    public static boolean a(Throwable th) {
        String message;
        if (th instanceof i) {
            int a2 = ((i) th).a();
            return a2 >= 500 || a2 == 408 || a2 == 429;
        }
        for (Class cls : a) {
            if (cls.isAssignableFrom(th.getClass())) {
                return true;
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            for (Class cls2 : a) {
                if (cls2.isAssignableFrom(cause.getClass())) {
                    return true;
                }
            }
        }
        return (th instanceof SSLException) && (message = th.getMessage()) != null && b.matcher(message.toLowerCase(Locale.US)).find();
    }

    public static d b(Context context, boolean z) {
        return new g(new b(z), com.microsoft.appcenter.e.f.a(context));
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = d.matcher(str);
        int i = 0;
        while (matcher.find()) {
            sb.append(str.substring(i, matcher.start()));
            sb.append("-***");
            sb.append(matcher.group(1));
            i = matcher.end();
        }
        if (i < str.length()) {
            sb.append(str.substring(i));
        }
        return sb.toString();
    }

    public static String c(String str) {
        return c.matcher(str).replaceAll(":***");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str) {
        String str2 = str.split("\\s+")[0];
        return str2 + " ***";
    }
}
