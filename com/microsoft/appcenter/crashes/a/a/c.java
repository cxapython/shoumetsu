package com.microsoft.appcenter.crashes.a.a;

import java.util.List;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class c implements com.microsoft.appcenter.c.a.g {
    private String a;
    private String b;
    private String c;
    private List<f> d;
    private List<c> e;
    private String f;
    private String g;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(List<f> list) {
        this.d = list;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        a(jSONObject.optString(net.gree.gamelib.payment.internal.a.e.J, null));
        b(jSONObject.optString(net.gree.gamelib.core.a.b.b.g, null));
        c(jSONObject.optString("stackTrace", null));
        a(com.microsoft.appcenter.c.a.a.e.a(jSONObject, "frames", com.microsoft.appcenter.crashes.a.a.a.e.a()));
        b(com.microsoft.appcenter.c.a.a.e.a(jSONObject, "innerExceptions", com.microsoft.appcenter.crashes.a.a.a.b.a()));
        d(jSONObject.optString("wrapperSdkName", null));
        e(jSONObject.optString("minidumpFilePath", null));
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, net.gree.gamelib.payment.internal.a.e.J, a());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, net.gree.gamelib.core.a.b.b.g, b());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "stackTrace", c());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "frames", (List<? extends com.microsoft.appcenter.c.a.g>) d());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "innerExceptions", (List<? extends com.microsoft.appcenter.c.a.g>) e());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "wrapperSdkName", f());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "minidumpFilePath", g());
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void b(List<c> list) {
        this.e = list;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public List<f> d() {
        return this.d;
    }

    public void d(String str) {
        this.f = str;
    }

    public List<c> e() {
        return this.e;
    }

    public void e(String str) {
        this.g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
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
        List<f> list = this.d;
        if (list == null ? cVar.d != null : !list.equals(cVar.d)) {
            return false;
        }
        List<c> list2 = this.e;
        if (list2 == null ? cVar.e != null : !list2.equals(cVar.e)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? cVar.f != null : !str4.equals(cVar.f)) {
            return false;
        }
        String str5 = this.g;
        return str5 != null ? str5.equals(cVar.g) : cVar.g == null;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<f> list = this.d;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<c> list2 = this.e;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str4 = this.f;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.g;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode6 + i;
    }
}
