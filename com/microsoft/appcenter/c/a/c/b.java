package com.microsoft.appcenter.c.a.c;

import java.util.Date;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class b extends f {
    private Date a;

    @Override // com.microsoft.appcenter.c.a.c.f
    public String a() {
        return "dateTime";
    }

    public void a(Date date) {
        this.a = date;
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(com.microsoft.appcenter.c.a.a.d.a(jSONObject.getString("value")));
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        jSONStringer.key("value").value(com.microsoft.appcenter.c.a.a.d.a(b()));
    }

    public Date b() {
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
        b bVar = (b) obj;
        Date date = this.a;
        return date != null ? date.equals(bVar.a) : bVar.a == null;
    }

    @Override // com.microsoft.appcenter.c.a.c.f
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Date date = this.a;
        return hashCode + (date != null ? date.hashCode() : 0);
    }
}
