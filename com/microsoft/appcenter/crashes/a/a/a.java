package com.microsoft.appcenter.crashes.a.a;

import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public abstract class a extends com.microsoft.appcenter.c.a.a {
    private UUID a;
    private Integer b;
    private String c;
    private Integer d;
    private String e;
    private Long f;
    private String g;
    private Boolean h;
    private Date i;
    private String j;

    public void a(Boolean bool) {
        this.h = bool;
    }

    public void a(Integer num) {
        this.b = num;
    }

    public void a(Long l) {
        this.f = l;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(Date date) {
        this.i = date;
    }

    public void a(UUID uuid) {
        this.a = uuid;
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(UUID.fromString(jSONObject.getString("id")));
        a(com.microsoft.appcenter.c.a.a.e.a(jSONObject, "processId"));
        a(jSONObject.optString("processName", null));
        b(com.microsoft.appcenter.c.a.a.e.a(jSONObject, "parentProcessId"));
        b(jSONObject.optString("parentProcessName", null));
        a(com.microsoft.appcenter.c.a.a.e.b(jSONObject, "errorThreadId"));
        c(jSONObject.optString("errorThreadName", null));
        a(com.microsoft.appcenter.c.a.a.e.c(jSONObject, "fatal"));
        a(com.microsoft.appcenter.c.a.a.d.a(jSONObject.getString("appLaunchTimestamp")));
        d(jSONObject.optString("architecture", null));
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "id", b());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "processId", c());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "processName", d());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "parentProcessId", e());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "parentProcessName", f());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "errorThreadId", g());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "errorThreadName", h());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "fatal", i());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "appLaunchTimestamp", com.microsoft.appcenter.c.a.a.d.a(j()));
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "architecture", k());
    }

    public UUID b() {
        return this.a;
    }

    public void b(Integer num) {
        this.d = num;
    }

    public void b(String str) {
        this.e = str;
    }

    public Integer c() {
        return this.b;
    }

    public void c(String str) {
        this.g = str;
    }

    public String d() {
        return this.c;
    }

    public void d(String str) {
        this.j = str;
    }

    public Integer e() {
        return this.d;
    }

    @Override // com.microsoft.appcenter.c.a.a
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
        Integer num = this.b;
        if (num == null ? aVar.b != null : !num.equals(aVar.b)) {
            return false;
        }
        String str = this.c;
        if (str == null ? aVar.c != null : !str.equals(aVar.c)) {
            return false;
        }
        Integer num2 = this.d;
        if (num2 == null ? aVar.d != null : !num2.equals(aVar.d)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? aVar.e != null : !str2.equals(aVar.e)) {
            return false;
        }
        Long l = this.f;
        if (l == null ? aVar.f != null : !l.equals(aVar.f)) {
            return false;
        }
        String str3 = this.g;
        if (str3 == null ? aVar.g != null : !str3.equals(aVar.g)) {
            return false;
        }
        Boolean bool = this.h;
        if (bool == null ? aVar.h != null : !bool.equals(aVar.h)) {
            return false;
        }
        Date date = this.i;
        if (date == null ? aVar.i != null : !date.equals(aVar.i)) {
            return false;
        }
        String str4 = this.j;
        return str4 != null ? str4.equals(aVar.j) : aVar.j == null;
    }

    public String f() {
        return this.e;
    }

    public Long g() {
        return this.f;
    }

    public String h() {
        return this.g;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        UUID uuid = this.a;
        int i = 0;
        int hashCode2 = (hashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        Integer num = this.b;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.d;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.f;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.g;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.h;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        Date date = this.i;
        int hashCode10 = (hashCode9 + (date != null ? date.hashCode() : 0)) * 31;
        String str4 = this.j;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode10 + i;
    }

    public Boolean i() {
        return this.h;
    }

    public Date j() {
        return this.i;
    }

    public String k() {
        return this.j;
    }
}
