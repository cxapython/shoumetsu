package com.google.android.gms.internal.gtm;

import java.util.List;

/* loaded from: classes.dex */
abstract class cg {
    private static final cg a = new ci();
    private static final cg b = new cj();

    private cg() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cg a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cg b() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, long j);
}
