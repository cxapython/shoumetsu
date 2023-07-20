package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
final class b implements DeferredLifecycleHelper.a {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ Bundle b;
    private final /* synthetic */ Bundle c;
    private final /* synthetic */ DeferredLifecycleHelper d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.d = deferredLifecycleHelper;
        this.a = activity;
        this.b = bundle;
        this.c = bundle2;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final int a() {
        return 0;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.d.a;
        lifecycleDelegate2.onInflate(this.a, this.b, this.c);
    }
}
