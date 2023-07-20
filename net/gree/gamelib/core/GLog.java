package net.gree.gamelib.core;

import android.util.Log;

/* loaded from: classes.dex */
public class GLog {
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    static final int a = 0;
    static int b = 0;
    private static final int c = 4;
    public static int sLogLevel = 6;

    protected GLog() {
    }

    private static String a() {
        StringBuilder sb = new StringBuilder("received null at ");
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        sb.append(stackTraceElement.getClassName());
        sb.append('.');
        sb.append(stackTraceElement.getMethodName());
        sb.append('(');
        sb.append(stackTraceElement.getFileName());
        sb.append(':');
        sb.append(stackTraceElement.getLineNumber());
        sb.append(')');
        return sb.toString();
    }

    public static void e(String str, String str2) {
        if (sLogLevel <= 6) {
            if (str2 == null) {
                str2 = a();
            }
            Log.e(str, str2);
            b = 6;
        }
    }

    public static void i(String str, String str2) {
        if (sLogLevel <= 4) {
            if (str2 == null) {
                str2 = a();
            }
            Log.i(str, str2);
            b = 4;
        }
    }

    public static void v(String str, String str2) {
        if (sLogLevel <= 2) {
            if (str2 == null) {
                str2 = a();
            }
            Log.v(str, str2);
            b = 2;
        }
    }

    public static void w(String str, String str2) {
        if (sLogLevel <= 5) {
            if (str2 == null) {
                str2 = a();
            }
            Log.w(str, str2);
            b = 5;
        }
    }
}
