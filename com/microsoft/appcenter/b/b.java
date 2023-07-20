package com.microsoft.appcenter.b;

import android.os.AsyncTask;
import com.microsoft.appcenter.b.c;
import com.microsoft.appcenter.b.d;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public class b implements c.a, d {
    private final Set<c> a;
    private final boolean b;

    public b() {
        this(true);
    }

    public b(boolean z) {
        this.a = new HashSet();
        this.b = z;
    }

    @Override // com.microsoft.appcenter.b.d
    public k a(String str, String str2, Map<String, String> map, d.a aVar, final l lVar) {
        final c cVar = new c(str, str2, map, aVar, lVar, this, this.b);
        try {
            cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } catch (RejectedExecutionException e) {
            com.microsoft.appcenter.e.c.a(new Runnable() { // from class: com.microsoft.appcenter.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    lVar.a(e);
                }
            });
        }
        return new k() { // from class: com.microsoft.appcenter.b.b.2
        };
    }

    @Override // com.microsoft.appcenter.b.d
    public void a() {
    }

    @Override // com.microsoft.appcenter.b.c.a
    public synchronized void a(c cVar) {
        this.a.add(cVar);
    }

    @Override // com.microsoft.appcenter.b.c.a
    public synchronized void b(c cVar) {
        this.a.remove(cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.a.size() > 0) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Cancelling " + this.a.size() + " network call(s).");
            for (c cVar : this.a) {
                cVar.cancel(true);
            }
            this.a.clear();
        }
    }
}
