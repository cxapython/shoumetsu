package com.microsoft.appcenter.crashes.a.a;

import java.util.UUID;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class d extends com.microsoft.appcenter.c.a.f {
    private UUID a;
    private c b;

    @Override // com.microsoft.appcenter.c.a.d
    public String a() {
        return "handledError";
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    public void a(UUID uuid) {
        this.a = uuid;
    }

    @Override // com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(UUID.fromString(jSONObject.getString("id")));
        if (jSONObject.has("exception")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("exception");
            c cVar = new c();
            cVar.a(jSONObject2);
            a(cVar);
        }
    }

    @Override // com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        jSONStringer.key("id").value(b());
        if (c() != null) {
            jSONStringer.key("exception").object();
            this.b.a(jSONStringer);
            jSONStringer.endObject();
        }
    }

    public UUID b() {
        return this.a;
    }

    public c c() {
        return this.b;
    }

    @Override // com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        d dVar = (d) obj;
        UUID uuid = this.a;
        if (uuid == null ? dVar.a != null : !uuid.equals(dVar.a)) {
            return false;
        }
        c cVar = this.b;
        return cVar != null ? cVar.equals(dVar.b) : dVar.b == null;
    }

    @Override // com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        UUID uuid = this.a;
        int i = 0;
        int hashCode2 = (hashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        c cVar = this.b;
        if (cVar != null) {
            i = cVar.hashCode();
        }
        return hashCode2 + i;
    }
}
