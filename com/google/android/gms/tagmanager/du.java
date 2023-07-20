package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class du implements ComponentCallbacks2 {
    private final /* synthetic */ TagManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(TagManager tagManager) {
        this.a = tagManager;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.a.dispatch();
        }
    }
}
