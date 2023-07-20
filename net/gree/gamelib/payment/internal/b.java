package net.gree.gamelib.payment.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import net.gree.gamelib.core.GLog;

/* loaded from: classes.dex */
public class b {
    private static final String a = "b";
    private static b b;
    private com.b.a.a.a.a c;

    private b() {
        this.c = null;
        this.c = new com.b.a.a.a.a();
    }

    public static void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            b();
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.gree.gamelib.payment.internal.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.b();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            GLog.e(a, "au service initialized error");
        }
    }

    public static void a(com.b.a.a.a.a aVar) {
        b.c = aVar;
    }

    public static boolean a(Context context) {
        int a2 = c().a(context);
        if (a2 != 0) {
            String str = a;
            GLog.e(str, "au service bind error, result code: " + a2);
            return false;
        }
        return true;
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    public static com.b.a.a.a.a c() {
        return b.c;
    }

    public static a d() {
        return new a(c());
    }

    public static net.gree.gamelib.payment.internal.a.b e() {
        return new net.gree.gamelib.payment.internal.a.b(c());
    }
}
