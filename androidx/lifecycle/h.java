package androidx.lifecycle;

import android.util.Log;
import androidx.lifecycle.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends e {
    private final WeakReference<g> c;
    private androidx.a.a.b.a<f, a> a = new androidx.a.a.b.a<>();
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<e.b> g = new ArrayList<>();
    private e.b b = e.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        e.b a;
        d b;

        a(f fVar, e.b bVar) {
            this.b = j.a(fVar);
            this.a = bVar;
        }

        void a(g gVar, e.a aVar) {
            e.b b = h.b(aVar);
            this.a = h.a(this.a, b);
            this.b.a(gVar, aVar);
            this.a = b;
        }
    }

    public h(g gVar) {
        this.c = new WeakReference<>(gVar);
    }

    static e.b a(e.b bVar, e.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(g gVar) {
        androidx.a.a.b.b<f, a>.d c = this.a.c();
        while (c.hasNext() && !this.f) {
            Map.Entry next = c.next();
            a aVar = (a) next.getValue();
            while (aVar.a.compareTo(this.b) < 0 && !this.f && this.a.c(next.getKey())) {
                c(aVar.a);
                aVar.a(gVar, e(aVar.a));
                c();
            }
        }
    }

    static e.b b(e.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return e.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return e.b.STARTED;
            case ON_RESUME:
                return e.b.RESUMED;
            case ON_DESTROY:
                return e.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private void b(e.b bVar) {
        if (this.b == bVar) {
            return;
        }
        this.b = bVar;
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        d();
        this.e = false;
    }

    private void b(g gVar) {
        Iterator<Map.Entry<f, a>> b = this.a.b();
        while (b.hasNext() && !this.f) {
            Map.Entry<f, a> next = b.next();
            a value = next.getValue();
            while (value.a.compareTo(this.b) > 0 && !this.f && this.a.c(next.getKey())) {
                e.a d = d(value.a);
                c(b(d));
                value.a(gVar, d);
                c();
            }
        }
    }

    private boolean b() {
        if (this.a.a() == 0) {
            return true;
        }
        e.b bVar = this.a.d().getValue().a;
        e.b bVar2 = this.a.e().getValue().a;
        return bVar == bVar2 && this.b == bVar2;
    }

    private e.b c(f fVar) {
        Map.Entry<f, a> d = this.a.d(fVar);
        e.b bVar = null;
        e.b bVar2 = d != null ? d.getValue().a : null;
        if (!this.g.isEmpty()) {
            ArrayList<e.b> arrayList = this.g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.b, bVar2), bVar);
    }

    private void c() {
        ArrayList<e.b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void c(e.b bVar) {
        this.g.add(bVar);
    }

    private static e.a d(e.b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return e.a.ON_DESTROY;
            case STARTED:
                return e.a.ON_STOP;
            case RESUMED:
                return e.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void d() {
        g gVar = this.c.get();
        if (gVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.b.compareTo(this.a.d().getValue().a) < 0) {
                b(gVar);
            }
            Map.Entry<f, a> e = this.a.e();
            if (!this.f && e != null && this.b.compareTo(e.getValue().a) > 0) {
                a(gVar);
            }
        }
        this.f = false;
    }

    private static e.a e(e.b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return e.a.ON_CREATE;
            case CREATED:
                return e.a.ON_START;
            case STARTED:
                return e.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    @Override // androidx.lifecycle.e
    public e.b a() {
        return this.b;
    }

    public void a(e.a aVar) {
        b(b(aVar));
    }

    public void a(e.b bVar) {
        b(bVar);
    }

    @Override // androidx.lifecycle.e
    public void a(f fVar) {
        g gVar;
        a aVar = new a(fVar, this.b == e.b.DESTROYED ? e.b.DESTROYED : e.b.INITIALIZED);
        if (this.a.a(fVar, aVar) == null && (gVar = this.c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            e.b c = c(fVar);
            this.d++;
            while (aVar.a.compareTo(c) < 0 && this.a.c(fVar)) {
                c(aVar.a);
                aVar.a(gVar, e(aVar.a));
                c();
                c = c(fVar);
            }
            if (!z) {
                d();
            }
            this.d--;
        }
    }

    @Override // androidx.lifecycle.e
    public void b(f fVar) {
        this.a.b(fVar);
    }
}
