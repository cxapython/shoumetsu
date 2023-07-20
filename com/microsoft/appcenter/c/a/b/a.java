package com.microsoft.appcenter.c.a.b;

import net.gree.gamelib.payment.shop.Product;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class a implements com.microsoft.appcenter.c.a.g {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        a(jSONObject.optString("id", null));
        c(jSONObject.optString("ver", null));
        b(jSONObject.optString(Product.KEY_NAME, null));
        d(jSONObject.optString("locale", null));
        e(jSONObject.optString(net.gree.gamelib.payment.internal.a.g.c, null));
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "id", a());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "ver", c());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, Product.KEY_NAME, b());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "locale", d());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, net.gree.gamelib.payment.internal.a.g.c, e());
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.a;
        if (str == null ? aVar.a != null : !str.equals(aVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? aVar.b != null : !str2.equals(aVar.b)) {
            return false;
        }
        String str3 = this.c;
        if (str3 == null ? aVar.c != null : !str3.equals(aVar.c)) {
            return false;
        }
        String str4 = this.d;
        if (str4 == null ? aVar.d != null : !str4.equals(aVar.d)) {
            return false;
        }
        String str5 = this.e;
        return str5 != null ? str5.equals(aVar.e) : aVar.e == null;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }
}
