package net.gree.gamelib.core.migration;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class ThirdPartyAccount {
    public static final String KEY_HASHED_ACCOUNT_ID = "hashed_account_id";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_STATUS = "status";
    private JSONObject a;
    private int b;
    private String c;
    private int d;

    public ThirdPartyAccount(JSONObject jSONObject) {
        this.a = jSONObject;
        a(this.a);
    }

    private void a(JSONObject jSONObject) {
        this.b = jSONObject.getInt("platform");
        this.c = jSONObject.getString("hashed_account_id");
        this.d = jSONObject.getInt("status");
    }

    public String getHashedAccountId() {
        return this.c;
    }

    public int getPlatform() {
        return this.b;
    }

    public int getStatus() {
        return this.d;
    }

    public String toString() {
        return this.a.toString();
    }
}
