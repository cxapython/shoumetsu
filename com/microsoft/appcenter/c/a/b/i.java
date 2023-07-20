package com.microsoft.appcenter.c.a.b;

import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class i implements com.microsoft.appcenter.c.a.g {
    private String a;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        a(jSONObject.optString("provider", null));
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "provider", a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        String str = this.a;
        return str != null ? str.equals(iVar.a) : iVar.a == null;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
