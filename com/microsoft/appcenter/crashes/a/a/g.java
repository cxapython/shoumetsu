package com.microsoft.appcenter.crashes.a.a;

import java.util.List;
import net.gree.gamelib.payment.shop.Product;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class g implements com.microsoft.appcenter.c.a.g {
    private long a;
    private String b;
    private List<f> c;

    public long a() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(List<f> list) {
        this.c = list;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        a(jSONObject.getLong("id"));
        a(jSONObject.optString(Product.KEY_NAME, null));
        a(com.microsoft.appcenter.c.a.a.e.a(jSONObject, "frames", com.microsoft.appcenter.crashes.a.a.a.e.a()));
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "id", Long.valueOf(a()));
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, Product.KEY_NAME, b());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "frames", (List<? extends com.microsoft.appcenter.c.a.g>) c());
    }

    public String b() {
        return this.b;
    }

    public List<f> c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.a != gVar.a) {
            return false;
        }
        String str = this.b;
        if (str == null ? gVar.b != null : !str.equals(gVar.b)) {
            return false;
        }
        List<f> list = this.c;
        return list != null ? list.equals(gVar.c) : gVar.c == null;
    }

    public int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<f> list = this.c;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }
}
