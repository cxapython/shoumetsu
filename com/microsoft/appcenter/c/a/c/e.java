package com.microsoft.appcenter.c.a.c;

import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class e extends f {
    private String a;

    @Override // com.microsoft.appcenter.c.a.c.f
    public String a() {
        return "string";
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(jSONObject.getString("value"));
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        jSONStringer.key("value").value(b());
    }

    public String b() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.c.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.a;
        return str != null ? str.equals(eVar.a) : eVar.a == null;
    }

    @Override // com.microsoft.appcenter.c.a.c.f
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.a;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
