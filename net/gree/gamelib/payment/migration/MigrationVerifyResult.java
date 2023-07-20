package net.gree.gamelib.payment.migration;

import net.gree.gamelib.core.a.b.b;
import net.gree.gamelib.core.migration.VerifyResult;
import net.gree.gamelib.payment.depositbook.Balance;
import net.gree.gamelib.payment.internal.b.a;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MigrationVerifyResult extends a {
    private VerifyResult a;
    private Balance b;

    /* loaded from: classes.dex */
    protected class MigrationBalance extends Balance {
        protected MigrationBalance(String str) {
            super(str);
        }

        @Override // net.gree.gamelib.payment.internal.b.a
        public JSONObject getEntry() {
            return this.mJson;
        }
    }

    public MigrationVerifyResult(String str) {
        super(str);
        this.a = new VerifyResult(str);
        this.b = new MigrationBalance(str);
    }

    public MigrationVerifyResult(String str, String str2, String str3) {
        super(toResponseJson(str, str2, str3));
    }

    protected static String toResponseJson(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b.c, b.d);
        jSONObject.put("migration_token", str);
        jSONObject.put("src_uuid", str2);
        jSONObject.put("src_x_uid", str3);
        return jSONObject.toString();
    }

    public Balance getBalance() {
        return this.b;
    }

    public String getMigrationToken() {
        return this.a.getMigrationToken();
    }

    public String getSourceUUID() {
        return this.a.getSourceUUID();
    }

    public String getSourceXUID() {
        return this.a.getSourceXUID();
    }
}
