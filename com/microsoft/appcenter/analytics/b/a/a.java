package com.microsoft.appcenter.analytics.b.a;

import com.google.android.gms.tagmanager.DataLayer;
import com.microsoft.appcenter.c.a.a.e;
import com.microsoft.appcenter.c.a.c.f;
import com.microsoft.appcenter.c.a.c.g;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class a extends b {
    private UUID a;
    private List<f> b;

    @Override // com.microsoft.appcenter.c.a.d
    public String a() {
        return DataLayer.EVENT_KEY;
    }

    public void a(List<f> list) {
        this.b = list;
    }

    public void a(UUID uuid) {
        this.a = uuid;
    }

    @Override // com.microsoft.appcenter.analytics.b.a.b, com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(UUID.fromString(jSONObject.getString("id")));
        a(g.a(jSONObject));
    }

    @Override // com.microsoft.appcenter.analytics.b.a.b, com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        jSONStringer.key("id").value(b());
        e.a(jSONStringer, "typedProperties", (List<? extends com.microsoft.appcenter.c.a.g>) c());
    }

    public UUID b() {
        return this.a;
    }

    public List<f> c() {
        return this.b;
    }

    @Override // com.microsoft.appcenter.analytics.b.a.b, com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        a aVar = (a) obj;
        UUID uuid = this.a;
        if (uuid == null ? aVar.a != null : !uuid.equals(aVar.a)) {
            return false;
        }
        List<f> list = this.b;
        return list != null ? list.equals(aVar.b) : aVar.b == null;
    }

    @Override // com.microsoft.appcenter.analytics.b.a.b, com.microsoft.appcenter.c.a.f, com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        UUID uuid = this.a;
        int i = 0;
        int hashCode2 = (hashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        List<f> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }
}
