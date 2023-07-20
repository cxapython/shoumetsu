package net.gree.gamelib.payment;

import java.util.Map;

/* loaded from: classes.dex */
public class Xuid extends net.gree.gamelib.payment.internal.b.a {
    public static final String APPLICATION_ID = "x_app_id";
    public static final String USER_ID = "x_uid";
    protected String mAppId;
    protected String mUserId;

    /* JADX INFO: Access modifiers changed from: protected */
    public Xuid(Map<String, String> map) {
        super("{\"result\":\"OK\"}");
        this.mUserId = null;
        this.mAppId = null;
        if (map != null) {
            this.mUserId = map.get("x_uid");
            if (this.mUserId != null) {
                this.mJson.put("x_uid", map.get("x_uid"));
            }
            this.mAppId = map.get("x_app_id");
            if (this.mAppId == null) {
                return;
            }
            this.mJson.put("x_app_id", map.get("x_app_id"));
        }
    }

    public String getApplicationId() {
        return this.mAppId;
    }

    public String getUserId() {
        return this.mUserId;
    }
}
