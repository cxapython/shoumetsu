package net.gree.gamelib.payment.internal.b;

import java.util.Map;
import net.gree.gamelib.core.http.RequestUrl;
import net.gree.gamelib.payment.internal.shop.PurchaseSettings;

/* loaded from: classes.dex */
public class c extends RequestUrl {
    public static final String a = "paymentVersion";
    private static final String b = "gl-payment";
    private static final String c = "bn-payment";
    private static final String d = "gree-apps.net";
    private static final String e = "wrightflyer.net";
    private static final String f = "BNE";
    private static final String g = "GLS";
    private static final String h = "/payment/balance";
    private static final String i = "/payment/balancelist";
    private static final String j = "/payment/history";
    private static final String k = "/payment/ageverification";
    private static final String l = "/payment/productlist";
    private static final String m = "/payment/purchase";
    private static final String n = "/payment/purchase/commit";
    private static final String o = "/payment/productlist/default";
    private static final String p = "/payment/country";
    private static final String q = "/payment/purchase/alert";
    private static final String r = "/payment/purchase/alert/setting";
    private static final String s = "/payment/purchase/alert/setting/update";
    private static final String t = "/payment/ticket/status";
    private static final String u = "/payment/refund/balance";

    public c(Map<String, String> map) {
        super(map);
    }

    public static boolean a(String str) {
        return f.equalsIgnoreCase(str) || g.equalsIgnoreCase(str);
    }

    public String a(String str, int i2) {
        return b(str) + "?expire_in=" + i2;
    }

    public String a(String str, int i2, int i3) {
        return this.mBaseUrl + '/' + str + i + "?offset=" + i2 + "&limit=" + i3;
    }

    public String a(String str, int i2, int i3, int i4) {
        return a(str, i2, i3) + "&expire_in=" + i4;
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.mBaseUrl + '/' + str + p);
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        sb.append("?country_code=" + str2 + "&currency_code=" + str3);
        return sb.toString();
    }

    public String b(String str) {
        return this.mBaseUrl + '/' + str + h;
    }

    public String b(String str, int i2, int i3) {
        return this.mBaseUrl + '/' + str + j + "?offset=" + i2 + "&limit=" + i3;
    }

    public String c(String str) {
        return this.mBaseUrl + '/' + str + k;
    }

    public String d(String str) {
        return c(str) + "/commit";
    }

    public String e(String str) {
        return this.mBaseUrl + '/' + str + l;
    }

    public String f(String str) {
        return this.mBaseUrl + '/' + str + m;
    }

    public String g(String str) {
        String str2 = this.mBaseUrl + '/' + str + n;
        if (PurchaseSettings.sForceFailPurchaseCommit) {
            return str2 + "fail";
        }
        return str2;
    }

    @Override // net.gree.gamelib.core.http.RequestUrl
    protected String getDomain(String str) {
        return a(str) ? c : b;
    }

    @Override // net.gree.gamelib.core.http.RequestUrl
    protected String getProductionUrlSuffix(String str) {
        return a(str) ? e : d;
    }

    public String h(String str) {
        return this.mBaseUrl + '/' + str + o;
    }

    public String i(String str) {
        return this.mBaseUrl + '/' + str + q;
    }

    public String j(String str) {
        return this.mBaseUrl + '/' + str + r;
    }

    public String k(String str) {
        return this.mBaseUrl + '/' + str + s;
    }

    public String l(String str) {
        return this.mBaseUrl + '/' + str + t;
    }

    public String m(String str) {
        return this.mBaseUrl + '/' + str + u;
    }
}
