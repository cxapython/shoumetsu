package com.microsoft.appcenter.analytics.b.a;

import com.microsoft.appcenter.c.a.f;
import net.gree.gamelib.payment.shop.Product;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public abstract class b extends f {
    private String a;

    public void a(String str) {
        this.a = str;
    }

    @Override // com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(jSONObject.getString(Product.KEY_NAME));
    }

    @Override // com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        jSONStringer.key(Product.KEY_NAME).value(d());
    }

    public String d() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.a;
        return str != null ? str.equals(bVar.a) : bVar.a == null;
    }

    @Override // com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.a;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
