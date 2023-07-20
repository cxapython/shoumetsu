package com.microsoft.appcenter.c.a;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public abstract class a implements d {
    private final Set<String> a = new LinkedHashSet();
    private Date b;
    private UUID c;
    private String d;
    private String e;
    private c f;
    private Object g;

    @Override // com.microsoft.appcenter.c.a.d
    public void a(c cVar) {
        this.f = cVar;
    }

    public void a(Object obj) {
        this.g = obj;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        if (jSONObject.getString(net.gree.gamelib.payment.internal.a.e.J).equals(a())) {
            b(com.microsoft.appcenter.c.a.a.d.a(jSONObject.getString("timestamp")));
            if (jSONObject.has("sid")) {
                c(UUID.fromString(jSONObject.getString("sid")));
            }
            e(jSONObject.optString("distributionGroupId", null));
            f(jSONObject.optString(net.gree.gamelib.payment.internal.a.g.c, null));
            if (!jSONObject.has("device")) {
                return;
            }
            c cVar = new c();
            cVar.a(jSONObject.getJSONObject("device"));
            a(cVar);
            return;
        }
        throw new JSONException("Invalid type");
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, net.gree.gamelib.payment.internal.a.e.J, a());
        jSONStringer.key("timestamp").value(com.microsoft.appcenter.c.a.a.d.a(n()));
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "sid", o());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "distributionGroupId", p());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, net.gree.gamelib.payment.internal.a.g.c, q());
        if (r() != null) {
            jSONStringer.key("device").object();
            r().a(jSONStringer);
            jSONStringer.endObject();
        }
    }

    @Override // com.microsoft.appcenter.c.a.d
    public void b(Date date) {
        this.b = date;
    }

    @Override // com.microsoft.appcenter.c.a.d
    public void c(UUID uuid) {
        this.c = uuid;
    }

    public void e(String str) {
        this.d = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.a.equals(aVar.a)) {
            return false;
        }
        Date date = this.b;
        if (date == null ? aVar.b != null : !date.equals(aVar.b)) {
            return false;
        }
        UUID uuid = this.c;
        if (uuid == null ? aVar.c != null : !uuid.equals(aVar.c)) {
            return false;
        }
        String str = this.d;
        if (str == null ? aVar.d != null : !str.equals(aVar.d)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? aVar.e != null : !str2.equals(aVar.e)) {
            return false;
        }
        c cVar = this.f;
        if (cVar == null ? aVar.f != null : !cVar.equals(aVar.f)) {
            return false;
        }
        Object obj2 = this.g;
        return obj2 != null ? obj2.equals(aVar.g) : aVar.g == null;
    }

    public void f(String str) {
        this.e = str;
    }

    @Override // com.microsoft.appcenter.c.a.d
    public synchronized void g(String str) {
        this.a.add(str);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        Date date = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
        UUID uuid = this.c;
        int hashCode3 = (hashCode2 + (uuid != null ? uuid.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        c cVar = this.f;
        int hashCode6 = (hashCode5 + (cVar != null ? cVar.hashCode() : 0)) * 31;
        Object obj = this.g;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // com.microsoft.appcenter.c.a.d
    public Date n() {
        return this.b;
    }

    @Override // com.microsoft.appcenter.c.a.d
    public UUID o() {
        return this.c;
    }

    public String p() {
        return this.d;
    }

    @Override // com.microsoft.appcenter.c.a.d
    public String q() {
        return this.e;
    }

    @Override // com.microsoft.appcenter.c.a.d
    public c r() {
        return this.f;
    }

    @Override // com.microsoft.appcenter.c.a.d
    public Object s() {
        return this.g;
    }

    @Override // com.microsoft.appcenter.c.a.d
    public synchronized Set<String> t() {
        return Collections.unmodifiableSet(this.a);
    }
}
