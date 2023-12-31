package com.amazon.device.iap.internal.c;

import org.json.JSONObject;

/* loaded from: classes.dex */
class d {
    private final String a;
    private final String b;
    private final long c;
    private final String d;

    public d(String str, String str2, String str3, long j) {
        this.a = str;
        this.b = str2;
        this.d = str3;
        this.c = j;
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.getString("KEY_USER_ID"), jSONObject.getString("KEY_RECEIPT_STRING"), jSONObject.getString("KEY_REQUEST_ID"), jSONObject.getLong("KEY_TIMESTAMP"));
        } catch (Throwable th) {
            throw new e("Input invalid for PendingReceipt Object:" + str, th);
        }
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("KEY_USER_ID", this.a);
        jSONObject.put("KEY_RECEIPT_STRING", this.b);
        jSONObject.put("KEY_REQUEST_ID", this.d);
        jSONObject.put("KEY_TIMESTAMP", this.c);
        return jSONObject.toString();
    }
}
