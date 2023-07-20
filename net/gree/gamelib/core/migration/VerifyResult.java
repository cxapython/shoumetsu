package net.gree.gamelib.core.migration;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class VerifyResult {
    public static final String KEY_MIGRATION_TOKEN = "migration_token";
    public static final String KEY_SOURCE_UUID = "src_uuid";
    public static final String KEY_SOURCE_XUID = "src_x_uid";
    private String a;
    private String b;
    private String c;
    private JSONObject d;

    public VerifyResult(String str) {
        this.d = new JSONObject(str);
        a(this.d);
    }

    public VerifyResult(JSONObject jSONObject) {
        this.d = jSONObject;
        a(this.d);
    }

    private void a(JSONObject jSONObject) {
        this.a = jSONObject.getString("migration_token");
        this.b = jSONObject.getString("src_uuid");
        this.c = jSONObject.getString("src_x_uid");
    }

    public String getMigrationToken() {
        return this.a;
    }

    public JSONObject getPayload() {
        return this.d;
    }

    public String getSourceUUID() {
        return this.b;
    }

    public String getSourceXUID() {
        return this.c;
    }
}
