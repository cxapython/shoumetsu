package com.microsoft.appcenter.c.a.b;

import net.gree.gamelib.payment.shop.Product;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class j implements com.microsoft.appcenter.c.a.g {
    private String a;
    private String b;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        a(jSONObject.optString(Product.KEY_NAME, null));
        b(jSONObject.optString("ver", null));
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, Product.KEY_NAME, a());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "ver", b());
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        String str = this.a;
        if (str == null ? jVar.a != null : !str.equals(jVar.a)) {
            return false;
        }
        String str2 = this.b;
        return str2 != null ? str2.equals(jVar.b) : jVar.b == null;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
