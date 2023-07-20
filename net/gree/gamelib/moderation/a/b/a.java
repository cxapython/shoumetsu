package net.gree.gamelib.moderation.a.b;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    protected static final String e = "result";
    protected static final String f = "OK";
    protected static final String g = "entry";
    protected static final String h = "code";
    protected static final String i = "message";
    protected JSONObject j;

    public a(String str) {
        this.j = new JSONObject(str);
        if ("OK".equals(this.j.getString("result"))) {
            return;
        }
        throw new JSONException("result is not OK");
    }

    public JSONObject d() {
        return this.j.getJSONObject(g);
    }

    public String toString() {
        return this.j.toString();
    }
}
