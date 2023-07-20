package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<a> a;

    /* loaded from: classes.dex */
    static class a extends LifecycleCallback {
        private List<Runnable> b;

        private a(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.b = new ArrayList();
            this.a.addCallback("LifecycleObserverOnStop", this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void a(Runnable runnable) {
            this.b.add(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(Activity activity) {
            a aVar;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                aVar = (a) fragment.getCallbackOrNull("LifecycleObserverOnStop", a.class);
                if (aVar == null) {
                    aVar = new a(fragment);
                }
            }
            return aVar;
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.b;
                this.b = new ArrayList();
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
        }
    }

    public zaa(Activity activity) {
        this(a.b(activity));
    }

    private zaa(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        a aVar = this.a.get();
        if (aVar != null) {
            aVar.a(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }
}
