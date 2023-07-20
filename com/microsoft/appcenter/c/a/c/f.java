package com.microsoft.appcenter.c.a.c;

import net.gree.gamelib.payment.shop.Product;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public abstract class f implements com.microsoft.appcenter.c.a.g {
    private String a;

    public abstract String a();

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        if (jSONObject.getString(net.gree.gamelib.payment.internal.a.e.J).equals(a())) {
            b(jSONObject.getString(Product.KEY_NAME));
            return;
        }
        throw new JSONException("Invalid type");
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        jSONStringer.key(net.gree.gamelib.payment.internal.a.e.J).value(a());
        jSONStringer.key(Product.KEY_NAME).value(c());
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.a;
        return str != null ? str.equals(fVar.a) : fVar.a == null;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
