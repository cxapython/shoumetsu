package com.microsoft.appcenter.c.a.c;

import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class c extends f {
    private double a;

    @Override // com.microsoft.appcenter.c.a.c.f
    public String a() {
        return "double";
    }

    public void a(double d) {
        this.a = d;
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(jSONObject.getDouble("value"));
    }

    @Override // com.microsoft.appcenter.c.a.c.f, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        jSONStringer.key("value").value(b());
    }

    public double b() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.c.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && Double.compare(((c) obj).a, this.a) == 0;
    }

    @Override // com.microsoft.appcenter.c.a.c.f
    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }
}
