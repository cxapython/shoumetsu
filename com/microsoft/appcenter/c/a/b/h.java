package com.microsoft.appcenter.c.a.b;

import java.util.Iterator;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class h implements com.microsoft.appcenter.c.a.g {
    private JSONObject a = new JSONObject();

    public JSONObject a() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        Iterator<String> keys = this.a.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONStringer.key(next).value(this.a.get(next));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.a.toString().equals(((h) obj).a.toString());
        }
        return false;
    }

    public int hashCode() {
        return this.a.toString().hashCode();
    }
}
