package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class cz {
    private static final cx a = c();
    private static final cx b = new cy();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cx a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cx b() {
        return b;
    }

    private static cx c() {
        try {
            return (cx) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
