package net.gree.gamelib.payment.internal.b;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    protected static final String ENTRY_KEY = "entry";
    protected static final String ERROR_CODE_KEY = "code";
    protected static final String ERROR_ENTITY_KEY = "message";
    protected static final String RESULT_KEY = "result";
    protected static final String RESULT_OK = "OK";
    protected JSONObject mJson;

    public a(String str) {
        this.mJson = new JSONObject(str);
        if ("OK".equals(this.mJson.getString("result"))) {
            return;
        }
        throw new JSONException("result is not OK");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject getEntry() {
        return this.mJson.getJSONObject(ENTRY_KEY);
    }

    public JSONObject getJson() {
        return this.mJson;
    }

    public String toString() {
        return this.mJson.toString();
    }
}
