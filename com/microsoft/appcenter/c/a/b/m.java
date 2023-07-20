package com.microsoft.appcenter.c.a.b;

import java.util.UUID;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class m implements com.microsoft.appcenter.c.a.g {
    private String a;
    private String b;
    private Long c;
    private UUID d;

    public String a() {
        return this.a;
    }

    public void a(Long l) {
        this.c = l;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(UUID uuid) {
        this.d = uuid;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        a(jSONObject.optString("libVer", null));
        b(jSONObject.optString("epoch", null));
        a(com.microsoft.appcenter.c.a.a.e.b(jSONObject, "seq"));
        if (jSONObject.has("installId")) {
            a(UUID.fromString(jSONObject.getString("installId")));
        }
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "libVer", a());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "epoch", b());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "seq", c());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "installId", d());
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public Long c() {
        return this.c;
    }

    public UUID d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        String str = this.a;
        if (str == null ? mVar.a != null : !str.equals(mVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? mVar.b != null : !str2.equals(mVar.b)) {
            return false;
        }
        Long l = this.c;
        if (l == null ? mVar.c != null : !l.equals(mVar.c)) {
            return false;
        }
        UUID uuid = this.d;
        return uuid != null ? uuid.equals(mVar.d) : mVar.d == null;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.c;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        UUID uuid = this.d;
        if (uuid != null) {
            i = uuid.hashCode();
        }
        return hashCode3 + i;
    }
}
