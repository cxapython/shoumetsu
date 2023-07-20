package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
abstract class dv<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T a(B b);

    abstract void a(B b, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, zzps zzpsVar);

    abstract void a(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, em emVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(dd ddVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(B b, dd ddVar) {
        int b2 = ddVar.b();
        int i = b2 >>> 3;
        switch (b2 & 7) {
            case 0:
                a((dv<T, B>) b, i, ddVar.g());
                return true;
            case 1:
                b(b, i, ddVar.i());
                return true;
            case 2:
                a((dv<T, B>) b, i, ddVar.n());
                return true;
            case 3:
                B a = a();
                int i2 = (i << 3) | 4;
                while (ddVar.a() != Integer.MAX_VALUE && a((dv<T, B>) a, ddVar)) {
                }
                if (i2 != ddVar.b()) {
                    throw zzrk.d();
                }
                a((dv<T, B>) b, i, (int) a((dv<T, B>) a));
                return true;
            case 4:
                return false;
            case 5:
                a((dv<T, B>) b, i, ddVar.j());
                return true;
            default:
                throw zzrk.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T b(Object obj);

    abstract void b(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, em emVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B c(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f(T t);
}
