package net.gree.gamelib.payment.internal;

import android.content.Context;
import com.b.a.a.a.a;
import java.util.Map;
import java.util.Random;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.SettingConsts;

/* loaded from: classes.dex */
public class a {
    public static final int a = 2100;
    public static final int b = 2101;
    public static final String c = "au Service Bind Error";
    public static final String d = "au License Authorize Error";
    private static final String e = "a";
    private static PaymentListener<String> f;
    private com.b.a.a.a.a g;
    private String h = d();

    public a(com.b.a.a.a.a aVar) {
        this.g = aVar;
    }

    private String d() {
        return Long.toString(new Random(System.nanoTime()).nextLong());
    }

    public String a() {
        return this.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, Map<String, String> map, PaymentListener<String> paymentListener) {
        long parseLong;
        if (paymentListener == null) {
            GLog.e(e, "authorize listener is null.");
        } else if (!b.a(context)) {
            paymentListener.onError(a, "au Service Bind Error");
        } else {
            f = paymentListener;
            a.d dVar = new a.d() { // from class: net.gree.gamelib.payment.internal.a.1
                @Override // com.b.a.a.a.a.d
                public void onAuthorizeLicenseResult(int i, String str, String str2, Map<String, Object> map2) {
                    if (i == 0) {
                        a.f.onSuccess(str);
                    } else {
                        String str3 = a.e;
                        GLog.v(str3, "au license authorize error, result code: " + i);
                        a.f.onError(a.b, a.d);
                    }
                    PaymentListener unused = a.f = null;
                }
            };
            String str = map.get(SettingConsts.AU_LICENSE_CACHE_TIME);
            if (str != null) {
                try {
                    parseLong = Long.parseLong(str);
                } catch (NumberFormatException unused) {
                }
                if (parseLong <= 0) {
                    this.g.a(context.getPackageName(), dVar, parseLong, this.h);
                    return;
                } else {
                    this.g.a(context.getPackageName(), dVar, this.h);
                    return;
                }
            }
            parseLong = -1;
            if (parseLong <= 0) {
            }
        }
    }
}
