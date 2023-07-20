package com.microsoft.appcenter.c.a.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class c implements g {
    private final Map<String, f> a = new HashMap();

    private com.microsoft.appcenter.c.a.d a(JSONObject jSONObject, String str) {
        if (str == null) {
            str = jSONObject.getString(net.gree.gamelib.payment.internal.a.e.J);
        }
        f fVar = this.a.get(str);
        if (fVar != null) {
            com.microsoft.appcenter.c.a.d b = fVar.b();
            b.a(jSONObject);
            return b;
        }
        throw new JSONException("Unknown log type: " + str);
    }

    private JSONStringer a(JSONStringer jSONStringer, com.microsoft.appcenter.c.a.d dVar) {
        jSONStringer.object();
        dVar.a(jSONStringer);
        jSONStringer.endObject();
        return jSONStringer;
    }

    @Override // com.microsoft.appcenter.c.a.a.g
    public com.microsoft.appcenter.c.a.d a(String str, String str2) {
        return a(new JSONObject(str), str2);
    }

    @Override // com.microsoft.appcenter.c.a.a.g
    public String a(com.microsoft.appcenter.c.a.d dVar) {
        return a(new JSONStringer(), dVar).toString();
    }

    @Override // com.microsoft.appcenter.c.a.a.g
    public String a(com.microsoft.appcenter.c.a.e eVar) {
        JSONStringer jSONStringer = new JSONStringer();
        jSONStringer.object();
        jSONStringer.key("logs").array();
        for (com.microsoft.appcenter.c.a.d dVar : eVar.a()) {
            a(jSONStringer, dVar);
        }
        jSONStringer.endArray();
        jSONStringer.endObject();
        return jSONStringer.toString();
    }

    @Override // com.microsoft.appcenter.c.a.a.g
    public void a(String str, f fVar) {
        this.a.put(str, fVar);
    }

    @Override // com.microsoft.appcenter.c.a.a.g
    public Collection<com.microsoft.appcenter.c.a.b.c> b(com.microsoft.appcenter.c.a.d dVar) {
        return this.a.get(dVar.a()).a(dVar);
    }
}
