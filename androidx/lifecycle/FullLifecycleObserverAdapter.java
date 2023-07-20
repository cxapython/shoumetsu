package androidx.lifecycle;

import androidx.lifecycle.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements d {
    private final b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(b bVar) {
        this.a = bVar;
    }

    @Override // androidx.lifecycle.d
    public void a(g gVar, e.a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.a.a(gVar);
                return;
            case ON_START:
                this.a.b(gVar);
                return;
            case ON_RESUME:
                this.a.c(gVar);
                return;
            case ON_PAUSE:
                this.a.d(gVar);
                return;
            case ON_STOP:
                this.a.e(gVar);
                return;
            case ON_DESTROY:
                this.a.f(gVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
