package com.microsoft.appcenter.analytics;

import java.util.Date;

/* loaded from: classes.dex */
public class b {
    private final c a;
    private final String b;
    private final String c;
    private final InterfaceC0060b d;
    private a e;
    private Date f;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* renamed from: com.microsoft.appcenter.analytics.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060b {
        void a(String str, a aVar);
    }

    /* loaded from: classes.dex */
    public enum c {
        MSA_COMPACT("p"),
        MSA_DELEGATE("d");
        
        private final String c;

        c(String str) {
            this.c = str + ":";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.c;
    }

    synchronized void b() {
        if (this.e != null) {
            return;
        }
        com.microsoft.appcenter.e.a.b("AppCenterAnalytics", "Calling token provider=" + this.a + " callback.");
        this.e = new a() { // from class: com.microsoft.appcenter.analytics.b.1
        };
        this.d.a(this.b, this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c() {
        if (this.f != null && this.f.getTime() <= System.currentTimeMillis() + 600000) {
            b();
        }
    }
}
