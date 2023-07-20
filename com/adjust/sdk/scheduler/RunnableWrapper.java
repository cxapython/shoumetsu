package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;

/* loaded from: classes.dex */
public class RunnableWrapper implements Runnable {
    private Runnable runnable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableWrapper(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.runnable.run();
        } catch (Throwable th) {
            AdjustFactory.getLogger().error("Runnable error [%s] of type [%s]", th.getMessage(), th.getClass().getCanonicalName());
        }
    }
}
