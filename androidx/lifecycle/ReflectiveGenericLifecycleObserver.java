package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements d {
    private final Object a;
    private final a.C0036a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = a.a.b(this.a.getClass());
    }

    @Override // androidx.lifecycle.d
    public void a(g gVar, e.a aVar) {
        this.b.a(gVar, aVar, this.a);
    }
}
