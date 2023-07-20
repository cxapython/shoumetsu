package com.google.android.gms.internal.firebase_messaging;

import java.io.PrintStream;

/* loaded from: classes.dex */
public final class zzn {
    private static final e a;
    private static final int b;

    /* loaded from: classes.dex */
    static final class a extends e {
        a() {
        }

        @Override // com.google.android.gms.internal.firebase_messaging.e
        public final void a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    static {
        Integer num;
        e aVar;
        int i = 1;
        try {
            num = a();
        } catch (Throwable th) {
            th = th;
            num = null;
        }
        if (num != null) {
            try {
            } catch (Throwable th2) {
                th = th2;
                PrintStream printStream = System.err;
                String name = a.class.getName();
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 133);
                sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                sb.append(name);
                sb.append("will be used. The error is: ");
                printStream.println(sb.toString());
                th.printStackTrace(System.err);
                aVar = new a();
                a = aVar;
                if (num != null) {
                }
                b = i;
            }
            if (num.intValue() >= 19) {
                aVar = new i();
                a = aVar;
                if (num != null) {
                    i = num.intValue();
                }
                b = i;
            }
        }
        aVar = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new h() : new a();
        a = aVar;
        if (num != null) {
        }
        b = i;
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static void zza(Throwable th, Throwable th2) {
        a.a(th, th2);
    }
}
