package com.microsoft.appcenter.c.a;

import java.util.List;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class h extends a {
    private List<String> a;

    @Override // com.microsoft.appcenter.c.a.d
    public String a() {
        return "startService";
    }

    public void a(List<String> list) {
        this.a = list;
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(com.microsoft.appcenter.c.a.a.e.e(jSONObject, "services"));
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        com.microsoft.appcenter.c.a.a.e.b(jSONStringer, "services", b());
    }

    public List<String> b() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        h hVar = (h) obj;
        List<String> list = this.a;
        return list != null ? list.equals(hVar.a) : hVar.a == null;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        List<String> list = this.a;
        return hashCode + (list != null ? list.hashCode() : 0);
    }
}
