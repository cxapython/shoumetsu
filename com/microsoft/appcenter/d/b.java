package com.microsoft.appcenter.d;

import com.microsoft.appcenter.c.a.a.g;
import com.microsoft.appcenter.c.a.d;
import java.io.Closeable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b implements Closeable {
    private g a;

    /* loaded from: classes.dex */
    public static class a extends Exception {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public abstract int a(Date date);

    public abstract long a(d dVar, String str, int i);

    public abstract String a(String str, Collection<String> collection, int i, List<d> list, Date date, Date date2);

    public abstract void a();

    public void a(g gVar) {
        this.a = gVar;
    }

    public abstract void a(String str, String str2);

    public abstract boolean a(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public g b() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("logSerializer not configured");
    }

    public abstract void b(String str);

    public abstract int c(String str);
}
