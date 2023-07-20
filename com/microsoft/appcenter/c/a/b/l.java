package com.microsoft.appcenter.c.a.b;

import java.util.List;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class l implements com.microsoft.appcenter.c.a.g {
    private List<String> a;
    private String b;
    private String c;

    public List<String> a() {
        return this.a;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(List<String> list) {
        this.a = list;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        a(com.microsoft.appcenter.c.a.a.e.e(jSONObject, "ticketKeys"));
        a(jSONObject.optString("devMake", null));
        b(jSONObject.optString("devModel", null));
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.b(jSONStringer, "ticketKeys", a());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "devMake", b());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "devModel", c());
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        List<String> list = this.a;
        if (list == null ? lVar.a != null : !list.equals(lVar.a)) {
            return false;
        }
        String str = this.b;
        if (str == null ? lVar.b != null : !str.equals(lVar.b)) {
            return false;
        }
        String str2 = this.c;
        return str2 != null ? str2.equals(lVar.c) : lVar.c == null;
    }

    public int hashCode() {
        List<String> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }
}
