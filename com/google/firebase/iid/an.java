package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class an implements ThreadFactory {
    static final ThreadFactory a = new an();

    private an() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return ak.a(runnable);
    }
}
