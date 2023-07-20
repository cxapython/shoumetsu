package com.microsoft.appcenter.e.b;

import com.microsoft.appcenter.c.a.g;
import java.util.Date;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
final class c implements g {
    private String a;
    private String b;
    private Date c;
    private Date d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, Date date, Date date2) {
        this.a = str;
        this.b = str2;
        this.c = date;
        this.d = date2;
    }

    private void a(String str) {
        this.a = str;
    }

    private void a(Date date) {
        this.c = date;
    }

    private void b(String str) {
        this.b = str;
    }

    private void b(Date date) {
        this.d = date;
    }

    public String a() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        Date date = null;
        a(jSONObject.optString("authToken", null));
        b(jSONObject.optString("homeAccountId", null));
        String optString = jSONObject.optString("time", null);
        a(optString != null ? com.microsoft.appcenter.c.a.a.d.a(optString) : null);
        String optString2 = jSONObject.optString("expiresOn", null);
        if (optString2 != null) {
            date = com.microsoft.appcenter.c.a.a.d.a(optString2);
        }
        b(date);
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "authToken", a());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "homeAccountId", b());
        Date c = c();
        String str = null;
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "time", c != null ? com.microsoft.appcenter.c.a.a.d.a(c) : null);
        Date d = d();
        if (d != null) {
            str = com.microsoft.appcenter.c.a.a.d.a(d);
        }
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "expiresOn", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.b;
    }

    public Date c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Date d() {
        return this.d;
    }
}
