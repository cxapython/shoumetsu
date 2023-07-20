package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class cr {
    private static final cp a = c();
    private static final cp b = new cq();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cp a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cp b() {
        return b;
    }

    private static cp c() {
        try {
            return (cp) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
