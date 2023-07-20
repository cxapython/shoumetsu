package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzch;
import java.lang.Thread;
import java.util.ArrayList;

@VisibleForTesting
/* loaded from: classes.dex */
public class ExceptionReporter implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler a;
    private final Tracker b;
    private final Context c;
    private ExceptionParser d;
    private GoogleAnalytics e;

    public ExceptionReporter(Tracker tracker, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (tracker != null) {
            if (context == null) {
                throw new NullPointerException("context cannot be null");
            }
            this.a = uncaughtExceptionHandler;
            this.b = tracker;
            this.d = new StandardExceptionParser(context, new ArrayList());
            this.c = context.getApplicationContext();
            String valueOf = String.valueOf(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
            zzch.zzab(valueOf.length() != 0 ? "ExceptionReporter created, original handler is ".concat(valueOf) : new String("ExceptionReporter created, original handler is "));
            return;
        }
        throw new NullPointerException("tracker cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Thread.UncaughtExceptionHandler a() {
        return this.a;
    }

    public ExceptionParser getExceptionParser() {
        return this.d;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.d = exceptionParser;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.d != null) {
            str = this.d.getDescription(thread != null ? thread.getName() : null, th);
        }
        String valueOf = String.valueOf(str);
        zzch.zzab(valueOf.length() != 0 ? "Reporting uncaught exception: ".concat(valueOf) : new String("Reporting uncaught exception: "));
        this.b.send(new HitBuilders.ExceptionBuilder().setDescription(str).setFatal(true).build());
        if (this.e == null) {
            this.e = GoogleAnalytics.getInstance(this.c);
        }
        GoogleAnalytics googleAnalytics = this.e;
        googleAnalytics.dispatchLocalHits();
        googleAnalytics.a().zzcs().zzcj();
        if (this.a != null) {
            zzch.zzab("Passing exception to the original handler");
            this.a.uncaughtException(thread, th);
        }
    }
}
