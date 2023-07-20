package net.gree.gamelib.moderation.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.moderation.KeywordFilter;
import net.gree.gamelib.moderation.KeywordFilterListener;
import net.gree.gamelib.moderation.a.a.c;

/* loaded from: classes.dex */
public class g {
    protected static final int a = 90000;
    protected static final String b = "v1.0";
    protected KeywordFilter c;
    protected net.gree.gamelib.moderation.a.a.d d;
    protected AtomicBoolean e = new AtomicBoolean();
    protected ScheduledExecutorService f = Executors.newScheduledThreadPool(1);

    public g(KeywordFilter keywordFilter) {
        this.c = keywordFilter;
        this.d = keywordFilter.getUserRestrictionStorage();
    }

    public void a() {
        c();
    }

    protected int b() {
        return a;
    }

    protected void c() {
        if (!this.e.getAndSet(true)) {
            this.f.schedule(new Runnable() { // from class: net.gree.gamelib.moderation.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.d();
                    g.this.g();
                }
            }, b(), TimeUnit.MILLISECONDS);
        }
    }

    protected void d() {
        this.e.set(false);
    }

    AtomicBoolean e() {
        return this.e;
    }

    net.gree.gamelib.moderation.a.a.d f() {
        return this.d;
    }

    protected void g() {
        KeywordFilter keywordFilter = this.c;
        if (keywordFilter != null) {
            keywordFilter.getSignedRequest().request("GET", new net.gree.gamelib.moderation.a.b.c(this.c.getParams()).c(b), new c.a(new KeywordFilterListener<net.gree.gamelib.moderation.a.a.c>() { // from class: net.gree.gamelib.moderation.a.g.2
                @Override // net.gree.gamelib.core.CallbackListener
                /* renamed from: a */
                public void onSuccess(final net.gree.gamelib.moderation.a.a.c cVar) {
                    if (cVar == null) {
                        return;
                    }
                    Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.moderation.a.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.d.a(cVar);
                        }
                    });
                }

                @Override // net.gree.gamelib.core.CallbackListener
                public void onError(int i, String str) {
                }
            }));
        }
    }
}
