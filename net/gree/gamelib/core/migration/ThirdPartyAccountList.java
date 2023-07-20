package net.gree.gamelib.core.migration;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ThirdPartyAccountList {
    public static final String KEY_ACCOUNTS = "accounts";
    private JSONObject a;
    private ThirdPartyAccount[] b;

    public ThirdPartyAccountList(String str) {
        this.a = new JSONObject(str);
        JSONArray a = a();
        int length = a.length();
        this.b = new ThirdPartyAccount[length];
        for (int i = 0; i < length; i++) {
            this.b[i] = new ThirdPartyAccount(a.getJSONObject(i));
        }
    }

    public ThirdPartyAccountList(JSONObject jSONObject) {
        this.a = jSONObject;
        JSONArray a = a();
        int length = a.length();
        this.b = new ThirdPartyAccount[length];
        for (int i = 0; i < length; i++) {
            this.b[i] = new ThirdPartyAccount(a.getJSONObject(i));
        }
    }

    private JSONArray a() {
        return this.a.getJSONArray("accounts");
    }

    public ThirdPartyAccount[] getAccounts() {
        return this.b;
    }

    public String toString() {
        return this.a.toString();
    }
}
