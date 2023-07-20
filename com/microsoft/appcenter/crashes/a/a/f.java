package com.microsoft.appcenter.crashes.a.a;

import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class f implements com.microsoft.appcenter.c.a.g {
    private String a;
    private String b;
    private Integer c;
    private String d;

    public String a() {
        return this.a;
    }

    public void a(Integer num) {
        this.c = num;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        a(jSONObject.optString("className", null));
        b(jSONObject.optString("methodName", null));
        a(com.microsoft.appcenter.c.a.a.e.a(jSONObject, "lineNumber"));
        c(jSONObject.optString("fileName", null));
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "className", a());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "methodName", b());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "lineNumber", c());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "fileName", d());
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public Integer c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
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
        if (str == null ? fVar.a != null : !str.equals(fVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? fVar.b != null : !str2.equals(fVar.b)) {
            return false;
        }
        Integer num = this.c;
        if (num == null ? fVar.c != null : !num.equals(fVar.c)) {
            return false;
        }
        String str3 = this.d;
        return str3 != null ? str3.equals(fVar.d) : fVar.d == null;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.c;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }
}
