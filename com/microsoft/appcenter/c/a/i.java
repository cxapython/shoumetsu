package com.microsoft.appcenter.c.a;

import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class i implements g {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        o(jSONObject.optString("wrapperSdkVersion", null));
        p(jSONObject.optString("wrapperSdkName", null));
        q(jSONObject.optString("wrapperRuntimeVersion", null));
        r(jSONObject.optString("liveUpdateReleaseLabel", null));
        s(jSONObject.optString("liveUpdateDeploymentKey", null));
        t(jSONObject.optString("liveUpdatePackageHash", null));
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "wrapperSdkVersion", q());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "wrapperSdkName", r());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "wrapperRuntimeVersion", s());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "liveUpdateReleaseLabel", t());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "liveUpdateDeploymentKey", u());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "liveUpdatePackageHash", v());
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
        if (str == null ? iVar.a != null : !str.equals(iVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? iVar.b != null : !str2.equals(iVar.b)) {
            return false;
        }
        String str3 = this.c;
        if (str3 == null ? iVar.c != null : !str3.equals(iVar.c)) {
            return false;
        }
        String str4 = this.d;
        if (str4 == null ? iVar.d != null : !str4.equals(iVar.d)) {
            return false;
        }
        String str5 = this.e;
        if (str5 == null ? iVar.e != null : !str5.equals(iVar.e)) {
            return false;
        }
        String str6 = this.f;
        return str6 != null ? str6.equals(iVar.f) : iVar.f == null;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public void o(String str) {
        this.a = str;
    }

    public void p(String str) {
        this.b = str;
    }

    public String q() {
        return this.a;
    }

    public void q(String str) {
        this.c = str;
    }

    public String r() {
        return this.b;
    }

    public void r(String str) {
        this.d = str;
    }

    public String s() {
        return this.c;
    }

    public void s(String str) {
        this.e = str;
    }

    public String t() {
        return this.d;
    }

    public void t(String str) {
        this.f = str;
    }

    public String u() {
        return this.e;
    }

    public String v() {
        return this.f;
    }
}
