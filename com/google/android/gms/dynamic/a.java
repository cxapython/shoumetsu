package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
final class a implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.a = deferredLifecycleHelper;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LifecycleDelegate lifecycleDelegate2;
        this.a.a = lifecycleDelegate;
        linkedList = this.a.c;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            lifecycleDelegate2 = this.a.a;
            ((DeferredLifecycleHelper.a) it.next()).a(lifecycleDelegate2);
        }
        linkedList2 = this.a.c;
        linkedList2.clear();
        this.a.b = null;
    }
}
