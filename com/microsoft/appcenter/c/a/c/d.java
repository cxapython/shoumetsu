package com.microsoft.appcenter.c.a.c;

import com.adjust.sdk.Constants;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class d extends f {
    private long a;

    @Override // com.microsoft.appcenter.c.a.c.f
    public String a() {
        return Constants.LONG;
    }

    public void a(long j) {
        this.a = j;
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(jSONObject.getLong("value"));
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        jSONStringer.key("value").value(b());
    }

    public long b() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.c.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && this.a == ((d) obj).a;
    }

    @Override // com.microsoft.appcenter.c.a.c.f
    public int hashCode() {
        long j = this.a;
        return (super.hashCode() * 31) + ((int) (j ^ (j >>> 32)));
    }
}
