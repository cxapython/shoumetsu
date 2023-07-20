package com.microsoft.appcenter.c.a;

import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class c extends i {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Integer h;
    private String i;
    private Integer j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;

    public String a() {
        return this.a;
    }

    public void a(Integer num) {
        this.h = num;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // com.microsoft.appcenter.c.a.i, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(jSONObject.getString("sdkName"));
        b(jSONObject.getString("sdkVersion"));
        c(jSONObject.getString("model"));
        d(jSONObject.getString("oemName"));
        e(jSONObject.getString("osName"));
        f(jSONObject.getString("osVersion"));
        g(jSONObject.optString("osBuild", null));
        a(com.microsoft.appcenter.c.a.a.e.a(jSONObject, "osApiLevel"));
        h(jSONObject.getString("locale"));
        b(Integer.valueOf(jSONObject.getInt("timeZoneOffset")));
        i(jSONObject.getString("screenSize"));
        j(jSONObject.getString("appVersion"));
        k(jSONObject.optString("carrierName", null));
        l(jSONObject.optString("carrierCountry", null));
        m(jSONObject.getString("appBuild"));
        n(jSONObject.optString("appNamespace", null));
    }

    @Override // com.microsoft.appcenter.c.a.i, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        jSONStringer.key("sdkName").value(a());
        jSONStringer.key("sdkVersion").value(b());
        jSONStringer.key("model").value(c());
        jSONStringer.key("oemName").value(d());
        jSONStringer.key("osName").value(e());
        jSONStringer.key("osVersion").value(f());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "osBuild", g());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "osApiLevel", h());
        jSONStringer.key("locale").value(i());
        jSONStringer.key("timeZoneOffset").value(j());
        jSONStringer.key("screenSize").value(k());
        jSONStringer.key("appVersion").value(l());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "carrierName", m());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "carrierCountry", n());
        jSONStringer.key("appBuild").value(o());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "appNamespace", p());
    }

    public String b() {
        return this.b;
    }

    public void b(Integer num) {
        this.j = num;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
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

    @Override // com.microsoft.appcenter.c.a.i
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
        String str3 = this.c;
        if (str3 == null ? cVar.c != null : !str3.equals(cVar.c)) {
            return false;
        }
        String str4 = this.d;
        if (str4 == null ? cVar.d != null : !str4.equals(cVar.d)) {
            return false;
        }
        String str5 = this.e;
        if (str5 == null ? cVar.e != null : !str5.equals(cVar.e)) {
            return false;
        }
        String str6 = this.f;
        if (str6 == null ? cVar.f != null : !str6.equals(cVar.f)) {
            return false;
        }
        String str7 = this.g;
        if (str7 == null ? cVar.g != null : !str7.equals(cVar.g)) {
            return false;
        }
        Integer num = this.h;
        if (num == null ? cVar.h != null : !num.equals(cVar.h)) {
            return false;
        }
        String str8 = this.i;
        if (str8 == null ? cVar.i != null : !str8.equals(cVar.i)) {
            return false;
        }
        Integer num2 = this.j;
        if (num2 == null ? cVar.j != null : !num2.equals(cVar.j)) {
            return false;
        }
        String str9 = this.k;
        if (str9 == null ? cVar.k != null : !str9.equals(cVar.k)) {
            return false;
        }
        String str10 = this.l;
        if (str10 == null ? cVar.l != null : !str10.equals(cVar.l)) {
            return false;
        }
        String str11 = this.m;
        if (str11 == null ? cVar.m != null : !str11.equals(cVar.m)) {
            return false;
        }
        String str12 = this.n;
        if (str12 == null ? cVar.n != null : !str12.equals(cVar.n)) {
            return false;
        }
        String str13 = this.o;
        if (str13 == null ? cVar.o != null : !str13.equals(cVar.o)) {
            return false;
        }
        String str14 = this.p;
        return str14 != null ? str14.equals(cVar.p) : cVar.p == null;
    }

    public String f() {
        return this.f;
    }

    public void f(String str) {
        this.f = str;
    }

    public String g() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public Integer h() {
        return this.h;
    }

    public void h(String str) {
        this.i = str;
    }

    @Override // com.microsoft.appcenter.c.a.i
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.g;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Integer num = this.h;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 31;
        String str8 = this.i;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num2 = this.j;
        int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str9 = this.k;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.l;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.m;
        int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.n;
        int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.o;
        int hashCode16 = (hashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.p;
        if (str14 != null) {
            i = str14.hashCode();
        }
        return hashCode16 + i;
    }

    public String i() {
        return this.i;
    }

    public void i(String str) {
        this.k = str;
    }

    public Integer j() {
        return this.j;
    }

    public void j(String str) {
        this.l = str;
    }

    public String k() {
        return this.k;
    }

    public void k(String str) {
        this.m = str;
    }

    public String l() {
        return this.l;
    }

    public void l(String str) {
        this.n = str;
    }

    public String m() {
        return this.m;
    }

    public void m(String str) {
        this.o = str;
    }

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.p = str;
    }

    public String o() {
        return this.o;
    }

    public String p() {
        return this.p;
    }
}
