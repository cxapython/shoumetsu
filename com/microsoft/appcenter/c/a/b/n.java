package com.microsoft.appcenter.c.a.b;

import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class n implements com.microsoft.appcenter.c.a.g {
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
        a(jSONObject.optString("localId", null));
        b(jSONObject.optString("locale", null));
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "localId", a());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "locale", b());
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
        n nVar = (n) obj;
        String str = this.a;
        if (str == null ? nVar.a != null : !str.equals(nVar.a)) {
            return false;
        }
        String str2 = this.b;
        return str2 != null ? str2.equals(nVar.b) : nVar.b == null;
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
