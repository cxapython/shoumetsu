package net.gree.gamelib.moderation.a;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    protected static final String a = "id";
    protected static final String b = "type";
    protected static final String c = "rank";
    protected static final String d = "keyword";
    protected int e;
    protected int f;
    protected int g;
    protected String h;
    protected String i;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(JSONObject jSONObject) {
        this.e = jSONObject.getInt(a);
        this.f = jSONObject.getInt("type");
        this.g = jSONObject.getInt(c);
        this.h = jSONObject.getString(d);
        this.i = new f().a(jSONObject.getString(d));
    }

    public int a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.i;
    }
}
