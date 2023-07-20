package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class br {
    private static final Class<?> a = c();

    public static zzqp a() {
        if (a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzqp.a;
    }

    private static final zzqp a(String str) {
        return (zzqp) a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzqp b() {
        zzqp a2;
        if (a != null) {
            try {
                a2 = a("loadGeneratedRegistry");
            } catch (Exception unused) {
            }
            if (a2 == null) {
                a2 = zzqp.a();
            }
            return a2 != null ? a() : a2;
        }
        a2 = null;
        if (a2 == null) {
        }
        if (a2 != null) {
        }
    }

    private static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
