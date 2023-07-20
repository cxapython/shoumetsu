package net.gree.gamelib.payment.internal.a;

import net.gree.gamelib.core.GLog;

/* loaded from: classes.dex */
public class i {
    private static final String a = "i";

    public static h a(String str) {
        if ("google".equalsIgnoreCase(str)) {
            return new c();
        }
        if (a.a.equalsIgnoreCase(str)) {
            return new a();
        }
        if (b.a.equalsIgnoreCase(str)) {
            return net.gree.gamelib.payment.internal.b.e();
        }
        c cVar = new c();
        GLog.v(a, "Unknown storeType, create a GooglePlayStore");
        return cVar;
    }
}
