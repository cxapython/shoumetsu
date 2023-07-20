package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
final class d implements DeferredLifecycleHelper.a {
    private final /* synthetic */ FrameLayout a;
    private final /* synthetic */ LayoutInflater b;
    private final /* synthetic */ ViewGroup c;
    private final /* synthetic */ Bundle d;
    private final /* synthetic */ DeferredLifecycleHelper e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = deferredLifecycleHelper;
        this.a = frameLayout;
        this.b = layoutInflater;
        this.c = viewGroup;
        this.d = bundle;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final int a() {
        return 2;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.a
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        this.a.removeAllViews();
        FrameLayout frameLayout = this.a;
        lifecycleDelegate2 = this.e.a;
        frameLayout.addView(lifecycleDelegate2.onCreateView(this.b, this.c, this.d));
    }
}
