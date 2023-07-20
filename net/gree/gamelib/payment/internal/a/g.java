package net.gree.gamelib.payment.internal.a;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {
    public static final String a = "productId";
    public static final String b = "orderId";
    public static final String c = "userId";
    public static final String d = "requestId";
    public static final String e = "receipt";
    public static final String f = "purchaseTime";
    public static final String g = "purchaseState";
    public static final String h = "developerPayload";
    String i;
    String j;
    String k;
    long l;
    int m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    String t;

    public g(String str, String str2) {
        this.p = str;
        JSONObject jSONObject = new JSONObject(this.p);
        this.i = jSONObject.optString(b);
        this.j = jSONObject.optString("packageName");
        this.k = jSONObject.optString("productId");
        this.l = jSONObject.optLong(f);
        this.m = jSONObject.optInt(g);
        this.n = jSONObject.optString(h);
        this.o = jSONObject.optString(net.gree.gamelib.core.a.b.a.p, jSONObject.optString("purchaseToken"));
        this.s = jSONObject.optString(c);
        this.r = jSONObject.optString(e);
        this.q = str2;
    }

    public String a() {
        return this.i;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(this.i)) {
            this.i = str;
            return true;
        }
        return false;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.k;
    }

    public long d() {
        return this.l;
    }

    public int e() {
        return this.m;
    }

    public String f() {
        return this.n;
    }

    public String g() {
        return this.o;
    }

    public String h() {
        return this.p;
    }

    public String i() {
        return this.q;
    }

    public String j() {
        return this.s;
    }

    public String k() {
        return this.r;
    }
}
