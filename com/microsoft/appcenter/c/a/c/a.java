package com.microsoft.appcenter.c.a.c;

import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class a extends f {
    private boolean a;

    @Override // com.microsoft.appcenter.c.a.c.f
    public String a() {
        return "boolean";
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(jSONObject.getBoolean("value"));
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        jSONStringer.key("value").value(b());
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean b() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.c.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && this.a == ((a) obj).a;
    }

    @Override // com.microsoft.appcenter.c.a.c.f
    public int hashCode() {
        return (super.hashCode() * 31) + (this.a ? 1 : 0);
    }
}
