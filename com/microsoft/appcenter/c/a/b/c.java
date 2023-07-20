package com.microsoft.appcenter.c.a.b;

import net.gree.gamelib.payment.shop.Product;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public abstract class c extends com.microsoft.appcenter.c.a.a {
    private String a;
    private String b;
    private Double c;
    private String d;
    private Long e;
    private String f;
    private f g;
    private d h;

    public void a(d dVar) {
        this.h = dVar;
    }

    public void a(f fVar) {
        this.g = fVar;
    }

    public void a(Double d) {
        this.c = d;
    }

    public void a(Long l) {
        this.e = l;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        a(jSONObject.getString("ver"));
        b(jSONObject.getString(Product.KEY_NAME));
        b(com.microsoft.appcenter.c.a.a.d.a(jSONObject.getString("time")));
        if (jSONObject.has("popSample")) {
            a(Double.valueOf(jSONObject.getDouble("popSample")));
        }
        c(jSONObject.optString("iKey", null));
        a(com.microsoft.appcenter.c.a.a.e.b(jSONObject, "flags"));
        d(jSONObject.optString("cV", null));
        if (jSONObject.has("ext")) {
            f fVar = new f();
            fVar.a(jSONObject.getJSONObject("ext"));
            a(fVar);
        }
        if (jSONObject.has("data")) {
            d dVar = new d();
            dVar.a(jSONObject.getJSONObject("data"));
            a(dVar);
        }
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        jSONStringer.key("ver").value(b());
        jSONStringer.key(Product.KEY_NAME).value(c());
        jSONStringer.key("time").value(com.microsoft.appcenter.c.a.a.d.a(n()));
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "popSample", d());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "iKey", e());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "flags", f());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "cV", g());
        if (h() != null) {
            jSONStringer.key("ext").object();
            h().a(jSONStringer);
            jSONStringer.endObject();
        }
        if (i() != null) {
            jSONStringer.key("data").object();
            i().a(jSONStringer);
            jSONStringer.endObject();
        }
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.d = str;
    }

    public Double d() {
        return this.c;
    }

    public void d(String str) {
        this.f = str;
    }

    public String e() {
        return this.d;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.a;
        if (str == null ? cVar.a != null : !str.equals(cVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? cVar.b != null : !str2.equals(cVar.b)) {
            return false;
        }
        Double d = this.c;
        if (d == null ? cVar.c != null : !d.equals(cVar.c)) {
            return false;
        }
        String str3 = this.d;
        if (str3 == null ? cVar.d != null : !str3.equals(cVar.d)) {
            return false;
        }
        Long l = this.e;
        if (l == null ? cVar.e != null : !l.equals(cVar.e)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? cVar.f != null : !str4.equals(cVar.f)) {
            return false;
        }
        f fVar = this.g;
        if (fVar == null ? cVar.g != null : !fVar.equals(cVar.g)) {
            return false;
        }
        d dVar = this.h;
        return dVar != null ? dVar.equals(cVar.h) : cVar.h == null;
    }

    public Long f() {
        return this.e;
    }

    public String g() {
        return this.f;
    }

    public f h() {
        return this.g;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d = this.c;
        int hashCode4 = (hashCode3 + (d != null ? d.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l = this.e;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        String str4 = this.f;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        f fVar = this.g;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 31;
        d dVar = this.h;
        if (dVar != null) {
            i = dVar.hashCode();
        }
        return hashCode8 + i;
    }

    public d i() {
        return this.h;
    }
}
