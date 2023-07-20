package com.microsoft.appcenter.c.a;

import java.util.Map;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public abstract class f extends a {
    private Map<String, String> a;

    public void a(Map<String, String> map) {
        this.a = map;
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(com.microsoft.appcenter.c.a.a.e.d(jSONObject, "properties"));
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "properties", e());
    }

    public Map<String, String> e() {
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
        f fVar = (f) obj;
        Map<String, String> map = this.a;
        return map != null ? map.equals(fVar.a) : fVar.a == null;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Map<String, String> map = this.a;
        return hashCode + (map != null ? map.hashCode() : 0);
    }
}
