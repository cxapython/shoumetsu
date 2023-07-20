package com.microsoft.appcenter.c.a.b;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class d implements com.microsoft.appcenter.c.a.g {
    private final JSONObject a = new JSONObject();

    public JSONObject a() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        JSONArray names = jSONObject.names();
        if (names != null) {
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                this.a.put(string, jSONObject.get(string));
            }
        }
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "baseType", this.a.optString("baseType", null));
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "baseData", this.a.optJSONObject("baseData"));
        JSONArray names = this.a.names();
        if (names != null) {
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                if (!string.equals("baseType") && !string.equals("baseData")) {
                    jSONStringer.key(string).value(this.a.get(string));
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.a.toString().equals(((d) obj).a.toString());
        }
        return false;
    }

    public int hashCode() {
        return this.a.toString().hashCode();
    }
}
