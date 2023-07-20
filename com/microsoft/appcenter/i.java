package com.microsoft.appcenter;

import android.os.Handler;
import java.lang.Thread;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class i implements Thread.UncaughtExceptionHandler {
    private final Handler a;
    private final com.microsoft.appcenter.a.b b;
    private Thread.UncaughtExceptionHandler c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Handler handler, com.microsoft.appcenter.a.b bVar) {
        this.a = handler;
        this.b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (b.a().b()) {
            final Semaphore semaphore = new Semaphore(0);
            this.a.post(new Runnable() { // from class: com.microsoft.appcenter.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.b.a();
                    com.microsoft.appcenter.e.a.b("AppCenter", "Channel completed shutdown.");
                    semaphore.release();
                }
            });
            try {
                if (!semaphore.tryAcquire(5000L, TimeUnit.MILLISECONDS)) {
                    com.microsoft.appcenter.e.a.e("AppCenter", "Timeout waiting for looper tasks to complete.");
                }
            } catch (InterruptedException e) {
                com.microsoft.appcenter.e.a.a("AppCenter", "Interrupted while waiting looper to flush.", e);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            com.microsoft.appcenter.e.g.a(10);
        }
    }
}
