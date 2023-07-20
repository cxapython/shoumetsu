package net.gree.gamelib.moderation.a.a;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    protected static final String a = "OK";
    protected static final String b = "NG";
    protected static final String c = "result";
    protected static final String d = "timestamp";
    protected static final String e = "id";
    private static final long g = 1000;
    protected JSONObject f;

    public a() {
        a("OK");
    }

    public a(int i) {
        a("NG");
        this.f.put(e, i);
    }

    public static long a(JSONObject jSONObject) {
        return jSONObject.getLong(d);
    }

    public static long b() {
        return System.currentTimeMillis() / g;
    }

    String a() {
        try {
            return this.f.getString(d);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    protected void a(String str) {
        this.f = new JSONObject();
        this.f.put(d, b());
        this.f.put("result", str);
    }

    public String toString() {
        return this.f.toString();
    }
}
