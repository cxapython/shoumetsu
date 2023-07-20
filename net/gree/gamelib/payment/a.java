package net.gree.gamelib.payment;

import android.content.Context;
import java.util.Map;
import net.gree.gamelib.payment.internal.b.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    a() {
    }

    public static Payment a(Context context, String str, String str2, Map<String, String> map) {
        return (map == null || !c.a(map.get("policy"))) ? new Payment(context, str, str2, map) : new Payment(context, str, str2, map);
    }
}
