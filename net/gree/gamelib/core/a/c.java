package net.gree.gamelib.core.a;

import java.util.Map;
import net.gree.gamelib.core.CallbackListener;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.http.ResponseAdapter;
import net.gree.gamelib.core.http.ResponseListener;
import net.gree.gamelib.core.http.SignedRequest;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends b {
    private static final String a = "c";
    private d b;
    private net.gree.gamelib.core.a.c.a c;

    public c(d dVar) {
        this.b = null;
        this.c = null;
        this.b = dVar;
        this.c = new net.gree.gamelib.core.a.c.a(this.b.a(), this.b.b(), this.b.d(), this.b.e());
    }

    @Override // net.gree.gamelib.core.a.b
    public SignedRequest a() {
        Map<String, String> i;
        SignedRequest signedRequest = new SignedRequest();
        signedRequest.setSigner(this.c);
        i g = this.b.g();
        signedRequest.setSettings(g);
        if (g != null && (i = g.i()) != null) {
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
        a2.request("POST", net.gree.gamelib.core.a.b.a.b(this.b.g().a()), b(callbackListener));
    }

    ResponseListener b(CallbackListener<String> callbackListener) {
        return new ResponseAdapter<String>(a, callbackListener) { // from class: net.gree.gamelib.core.a.c.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public String mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return null;
            }
        };
    }
}
