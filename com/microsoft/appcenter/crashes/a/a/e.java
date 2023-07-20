package com.microsoft.appcenter.crashes.a.a;

import java.util.List;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class e extends a {
    private c a;
    private List<g> b;

    @Override // com.microsoft.appcenter.c.a.d
    public String a() {
        return "managedError";
    }

    public void a(c cVar) {
        this.a = cVar;
    }

    public void a(List<g> list) {
        this.b = list;
    }

    @Override // com.microsoft.appcenter.crashes.a.a.a, com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject.has("exception")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("exception");
            c cVar = new c();
            cVar.a(jSONObject2);
            a(cVar);
        }
        a(com.microsoft.appcenter.c.a.a.e.a(jSONObject, "threads", com.microsoft.appcenter.crashes.a.a.a.f.a()));
    }

    @Override // com.microsoft.appcenter.crashes.a.a.a, com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        if (l() != null) {
            jSONStringer.key("exception").object();
            this.a.a(jSONStringer);
            jSONStringer.endObject();
        }
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "threads", (List<? extends com.microsoft.appcenter.c.a.g>) m());
    }

    @Override // com.microsoft.appcenter.crashes.a.a.a, com.microsoft.appcenter.c.a.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        e eVar = (e) obj;
        c cVar = this.a;
        if (cVar == null ? eVar.a != null : !cVar.equals(eVar.a)) {
            return false;
        }
        List<g> list = this.b;
        return list != null ? list.equals(eVar.b) : eVar.b == null;
    }

    @Override // com.microsoft.appcenter.crashes.a.a.a, com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        c cVar = this.a;
        int i = 0;
        int hashCode2 = (hashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
        List<g> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public c l() {
        return this.a;
    }

    public List<g> m() {
        return this.b;
    }
}
