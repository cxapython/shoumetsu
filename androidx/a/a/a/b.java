package androidx.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b extends c {
    private final Object a = new Object();
    private final ExecutorService b = Executors.newFixedThreadPool(2, new ThreadFactory() { // from class: androidx.a.a.a.b.1
        private final AtomicInteger b = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.b.getAndIncrement())));
            return thread;
        }
    });
    private volatile Handler c;

    @Override // androidx.a.a.a.c
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override // androidx.a.a.a.c
    public void b(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.a) {
                if (this.c == null) {
                    this.c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    @Override // androidx.a.a.a.c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
