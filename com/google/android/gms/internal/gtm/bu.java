package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class bu {
    private static final bs<?> a = new bt();
    private static final bs<?> b = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bs<?> a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bs<?> b() {
        bs<?> bsVar = b;
        if (bsVar != null) {
            return bsVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static bs<?> c() {
        try {
            return (bs) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
