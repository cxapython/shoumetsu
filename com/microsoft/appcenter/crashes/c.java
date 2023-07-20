package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.e.g;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Thread.UncaughtExceptionHandler {
    private boolean a = false;
    private Thread.UncaughtExceptionHandler b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b = !this.a ? Thread.getDefaultUncaughtExceptionHandler() : null;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Thread.setDefaultUncaughtExceptionHandler(this.b);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Crashes.getInstance().a(thread, th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            g.a(10);
        }
    }
}
