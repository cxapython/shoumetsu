package com.microsoft.appcenter.crashes.a.a;

import android.util.Base64;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class b extends com.microsoft.appcenter.c.a.a {
    static final Charset a = Charset.forName("UTF-8");
    private UUID b;
    private UUID c;
    private String d;
    private String e;
    private byte[] f;

    public static b a(byte[] bArr, String str, String str2) {
        b bVar = new b();
        bVar.a(bArr);
        bVar.b(str);
        bVar.a(str2);
        return bVar;
    }

    @Override // com.microsoft.appcenter.c.a.d
    public String a() {
        return "errorAttachment";
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(UUID uuid) {
        this.b = uuid;
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(UUID.fromString(jSONObject.getString("id")));
        b(UUID.fromString(jSONObject.getString("errorId")));
        a(jSONObject.getString("contentType"));
        b(jSONObject.optString("fileName", null));
        try {
            a(Base64.decode(jSONObject.getString("data"), 0));
        } catch (IllegalArgumentException e) {
            throw new JSONException(e.getMessage());
        }
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "id", b());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "errorId", c());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "contentType", d());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "fileName", e());
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, "data", Base64.encodeToString(f(), 2));
    }

    public void a(byte[] bArr) {
        this.f = bArr;
    }

    public UUID b() {
        return this.b;
    }

    public void b(String str) {
        this.e = str;
    }

    public void b(UUID uuid) {
        this.c = uuid;
    }

    public UUID c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        b bVar = (b) obj;
        UUID uuid = this.b;
        if (uuid == null ? bVar.b != null : !uuid.equals(bVar.b)) {
            return false;
        }
        UUID uuid2 = this.c;
        if (uuid2 == null ? bVar.c != null : !uuid2.equals(bVar.c)) {
            return false;
        }
        String str = this.d;
        if (str == null ? bVar.d != null : !str.equals(bVar.d)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? bVar.e != null : !str2.equals(bVar.e)) {
            return false;
        }
        return Arrays.equals(this.f, bVar.f);
    }

    public byte[] f() {
        return this.f;
    }

    public boolean g() {
        return (b() == null || c() == null || d() == null || f() == null) ? false : true;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        UUID uuid = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        UUID uuid2 = this.c;
        int hashCode3 = (hashCode2 + (uuid2 != null ? uuid2.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.e;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode4 + i) * 31) + Arrays.hashCode(this.f);
    }
}
