package com.google.android.gms.internal.gtm;

import java.io.PrintStream;
import java.util.List;

/* loaded from: classes.dex */
final class av extends as {
    private final at a = new at();

    @Override // com.google.android.gms.internal.gtm.as
    public final void a(Throwable th, PrintStream printStream) {
        th.printStackTrace(printStream);
        List<Throwable> a = this.a.a(th, false);
        if (a == null) {
            return;
        }
        synchronized (a) {
            for (Throwable th2 : a) {
                printStream.print("Suppressed: ");
                th2.printStackTrace(printStream);
            }
        }
    }
}
