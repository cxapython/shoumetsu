package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements d {
    private final c[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.a = cVarArr;
    }

    @Override // androidx.lifecycle.d
    public void a(g gVar, e.a aVar) {
        k kVar = new k();
        for (c cVar : this.a) {
            cVar.a(gVar, aVar, false, kVar);
        }
        for (c cVar2 : this.a) {
            cVar2.a(gVar, aVar, true, kVar);
        }
    }
}
