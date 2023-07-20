package net.gree.gamelib.core.a;

import android.text.TextUtils;
import java.util.Map;
import net.gree.gamelib.core.CallbackListener;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.http.ResponseAdapter;
import net.gree.gamelib.core.http.ResponseListener;
import net.gree.gamelib.core.http.SignedRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e extends b {
    private static final String a = "e";
    private static final String b = "device_id";
    private static final String c = "token";
    private static final String d = "uuid";
    private static final String e = "payload";
    private static final String f = "is_test_user";
    private d g;
    private net.gree.gamelib.core.a.c.b h;
    private String i;

    public e(d dVar, String str) {
        this.g = null;
        this.h = null;
        this.i = null;
        this.g = dVar;
        this.h = new net.gree.gamelib.core.a.c.b(this.g.a(), this.g.b());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", this.g.f());
            jSONObject.put("token", "-----BEGIN PUBLIC KEY-----\n" + net.gree.gamelib.core.a.c.c.e(this.g.c()) + "\n-----END PUBLIC KEY-----\n");
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(e, str);
            }
            if (this.g.g().h()) {
                jSONObject.put(f, true);
            }
            this.i = jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // net.gree.gamelib.core.a.b
    public SignedRequest a() {
        SignedRequest signedRequest = new SignedRequest();
        signedRequest.setSigner(this.h);
        signedRequest.setSettings(this.g.g());
        Map<String, String> i = this.g.g().i();
        if (i != null) {
            for (Map.Entry<String, String> entry : i.entrySet()) {
                signedRequest.addCustomValues(entry.getKey(), entry.getValue());
            }
        }
        return signedRequest;
    }

    @Override // net.gree.gamelib.core.a.b
    public void a(CallbackListener<String> callbackListener) {
        SignedRequest a2 = a();
        a2.setExecutor(Core.EXECUTOR);
        a2.setEntity(this.i);
        a2.request("POST", net.gree.gamelib.core.a.b.a.a(this.g.g().a()), b(callbackListener));
    }

    String b() {
        return this.i;
    }

    ResponseListener b(CallbackListener<String> callbackListener) {
        return new ResponseAdapter<String>(a, callbackListener) { // from class: net.gree.gamelib.core.a.e.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public String mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return jSONObject.getString("uuid");
            }
        };
    }
}
