package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object b = new Object();
    volatile Object d;
    private volatile Object f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;
    final Object a = new Object();
    private androidx.a.a.b.b<m<? super T>, LiveData<T>.a> e = new androidx.a.a.b.b<>();
    int c = 0;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.a implements d {
        final g a;

        LifecycleBoundObserver(g gVar, m<? super T> mVar) {
            super(mVar);
            this.a = gVar;
        }

        @Override // androidx.lifecycle.d
        public void a(g gVar, e.a aVar) {
            if (this.a.getLifecycle().a() == e.b.DESTROYED) {
                LiveData.this.a((m) this.c);
            } else {
                a(a());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a() {
            return this.a.getLifecycle().a().a(e.b.STARTED);
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a(g gVar) {
            return this.a == gVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        void b() {
            this.a.getLifecycle().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a {
        final m<? super T> c;
        boolean d;
        int e = -1;

        a(m<? super T> mVar) {
            this.c = mVar;
        }

        void a(boolean z) {
            if (z == this.d) {
                return;
            }
            this.d = z;
            int i = 1;
            boolean z2 = LiveData.this.c == 0;
            LiveData liveData = LiveData.this;
            int i2 = liveData.c;
            if (!this.d) {
                i = -1;
            }
            liveData.c = i2 + i;
            if (z2 && this.d) {
                LiveData.this.b();
            }
            if (LiveData.this.c == 0 && !this.d) {
                LiveData.this.c();
            }
            if (!this.d) {
                return;
            }
            LiveData.this.a(this);
        }

        abstract boolean a();

        boolean a(g gVar) {
            return false;
        }

        void b() {
        }
    }

    public LiveData() {
        Object obj = b;
        this.f = obj;
        this.d = obj;
        this.g = -1;
        this.j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.a) {
                    obj2 = LiveData.this.d;
                    LiveData.this.d = LiveData.b;
                }
                LiveData.this.a((LiveData) obj2);
            }
        };
    }

    private static void a(String str) {
        if (androidx.a.a.a.a.a().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(LiveData<T>.a aVar) {
        if (!aVar.d) {
            return;
        }
        if (!aVar.a()) {
            aVar.a(false);
            return;
        }
        int i = aVar.e;
        int i2 = this.g;
        if (i >= i2) {
            return;
        }
        aVar.e = i2;
        aVar.c.a((Object) this.f);
    }

    public T a() {
        T t = (T) this.f;
        if (t != b) {
            return t;
        }
        return null;
    }

    void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar == null) {
                androidx.a.a.b.b<m<? super T>, LiveData<T>.a>.d c = this.e.c();
                while (c.hasNext()) {
                    b((a) c.next().getValue());
                    if (this.i) {
                        break;
                    }
                }
            } else {
                b(aVar);
                aVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    public void a(g gVar, m<? super T> mVar) {
        a("observe");
        if (gVar.getLifecycle().a() == e.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, mVar);
        LiveData<T>.a a2 = this.e.a(mVar, lifecycleBoundObserver);
        if (a2 != null && !a2.a(gVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (a2 != null) {
            return;
        }
        gVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void a(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.a b2 = this.e.b(mVar);
        if (b2 == null) {
            return;
        }
        b2.b();
        b2.a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        a("setValue");
        this.g++;
        this.f = t;
        a((a) null);
    }

    protected void b() {
    }

    protected void c() {
    }

    public boolean d() {
        return this.c > 0;
    }
}
