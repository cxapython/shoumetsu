package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
final class c implements DeferredLifecycleHelper.a {
    private final /* synthetic */ Bundle a;
    private final /* synthetic */ DeferredLifecycleHelper b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.b = deferredLifecycleHelper;
        this.a = bundle;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final int a() {
        return 1;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.b.a;
        lifecycleDelegate2.onCreate(this.a);
    }
}
