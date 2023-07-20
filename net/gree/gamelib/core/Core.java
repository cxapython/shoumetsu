package net.gree.gamelib.core;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import net.gree.gamelib.core.DeviceVerifyResult;
import net.gree.gamelib.core.a.b;
import net.gree.gamelib.core.a.c;
import net.gree.gamelib.core.a.d;
import net.gree.gamelib.core.a.d.a;
import net.gree.gamelib.core.a.e;
import net.gree.gamelib.core.a.f;
import net.gree.gamelib.core.a.h;
import net.gree.gamelib.core.a.i;
import net.gree.gamelib.core.http.ResponseAdapter;
import net.gree.gamelib.core.http.ResponseListener;
import net.gree.gamelib.core.http.SignedRequest;
import net.gree.gamelib.core.migration.ThirdPartyAccountList;
import net.gree.gamelib.core.migration.VerifyResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Core {
    public static final Executor EXECUTOR = Executors.newCachedThreadPool();
    private static final String a = "Core";
    private static final String b = "1.5.1";
    private Config c;
    private a d;
    private net.gree.gamelib.core.a.a e;
    private boolean f = false;
    private h g = new h();
    private h h = new h();
    private h i = new h();

    public Core(Context context, Config config) {
        String c;
        this.c = null;
        this.d = null;
        this.e = null;
        GLog.i(a, "version:1.5.1");
        this.c = config;
        this.e = new net.gree.gamelib.core.a.a(context, getConfig().getId(), getConfig().getSecret(), getConfig().getScramble());
        this.d = new a(context, getConfig().getDomain());
        if (this.d.g()) {
            this.e.t();
        }
        if (this.d.f() != null || (c = this.e.c()) == null) {
            return;
        }
        this.d.a(c);
    }

    private d b() {
        i iVar = new i(this.c.getServerBaseUrl(), this.e.d(), this.e.f(), this.e.e(), this.e.g(), this.e.h(), this.e.i());
        iVar.a(this.c.getTestUserEnabled());
        iVar.a(this.c.getExtraHeader());
        d.a aVar = new d.a(iVar);
        aVar.a(this.e.a());
        aVar.b(this.e.b());
        aVar.f(this.e.c());
        if (this.d.g()) {
            aVar.c(this.e.r());
            aVar.d(this.e.s());
        } else {
            aVar.c(this.d.a());
            aVar.d(this.d.b());
            aVar.e(this.d.c());
        }
        return aVar.a();
    }

    public static String descramble(String str) {
        return net.gree.gamelib.core.a.a.a.c(str);
    }

    public static String getVersion() {
        return b;
    }

    public static String scramble(String str) {
        return net.gree.gamelib.core.a.a.a.b(str);
    }

    CallbackListener<String> a(final CallbackListener<Void> callbackListener) {
        return new CallbackListener<String>() { // from class: net.gree.gamelib.core.Core.1
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(String str) {
                Core.this.f = true;
                if (str != null && Core.this.d.g()) {
                    Core.this.d.a(Core.this.e.r(), Core.this.e.s(), str);
                }
                Core.this.g.b();
                CallbackListener callbackListener2 = callbackListener;
                if (callbackListener2 != null) {
                    callbackListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str) {
                Core.this.g.b();
                CallbackListener callbackListener2 = callbackListener;
                if (callbackListener2 != null) {
                    callbackListener2.onError(i, str);
                }
            }
        };
    }

    b a(String str) {
        return this.d.g() ? new e(b(), str) : new c(b());
    }

    ResponseListener a(final String str, CallbackListener<Void> callbackListener) {
        return new ResponseAdapter<Void>(a, callbackListener) { // from class: net.gree.gamelib.core.Core.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public Void mo48jsonObjectToResponseData(JSONObject jSONObject) {
                String a2;
                String b2;
                Core.this.h.b();
                if (Core.this.d.g()) {
                    a2 = Core.this.e.r();
                    b2 = Core.this.e.s();
                } else {
                    a2 = Core.this.d.a();
                    b2 = Core.this.d.b();
                }
                Core.this.d.h();
                Core.this.d.a(a2, b2, str);
                Core.this.f = true;
                return null;
            }
        };
    }

    public void authorize(String str, CallbackListener<Void> callbackListener) {
        if (this.g.a()) {
            a(str).a(a(callbackListener));
        } else if (callbackListener == null) {
        } else {
            callbackListener.onError(17219, "The process is already in progress");
        }
    }

    ResponseListener b(CallbackListener<Void> callbackListener) {
        return new ResponseAdapter<Void>(a, callbackListener) { // from class: net.gree.gamelib.core.Core.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public Void mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return null;
            }
        };
    }

    ResponseListener c(CallbackListener<Map<String, String>> callbackListener) {
        return new ResponseAdapter<Map<String, String>>(a, callbackListener) { // from class: net.gree.gamelib.core.Core.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public Map<String, String> mo48jsonObjectToResponseData(JSONObject jSONObject) {
                String d = Core.this.d.d();
                String e = Core.this.d.e();
                if (d != null && e != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("x_uid", d);
                    hashMap.put("x_app_id", e);
                    return hashMap;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equals(net.gree.gamelib.core.a.b.b.c)) {
                        hashMap2.put(next, jSONObject.getString(next));
                    }
                }
                if (hashMap2.containsKey("x_uid") && hashMap2.containsKey("x_app_id")) {
                    String str = (String) hashMap2.get("x_uid");
                    String str2 = (String) hashMap2.get("x_app_id");
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        Core.this.d.b(str, str2);
                    }
                }
                return hashMap2;
            }
        };
    }

    public void clear3rdPartyUserAccount(int i, String str, String str2, CallbackListener<String> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", i);
            jSONObject.put("hashed_account_id", net.gree.gamelib.core.a.c.c.b(str));
            jSONObject.put(net.gree.gamelib.core.a.b.a.x, str2);
            signedRequest.setEntity(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.m(getConfig().getServerBaseUrl()), net.gree.gamelib.core.a.b.a.i(callbackListener));
    }

    public String decrypt(String str) {
        return net.gree.gamelib.core.a.a.a.b(this.e.b().getBytes(), str);
    }

    public String encrypt(String str) {
        return net.gree.gamelib.core.a.a.a.a(this.e.b().getBytes(), str);
    }

    public String getAppId() {
        return this.e.a();
    }

    public Config getConfig() {
        return this.c;
    }

    public SignedRequest getSignedRequest() {
        SignedRequest a2 = a((String) null).a();
        a2.setExecutor(EXECUTOR);
        Map<String, String> extraHeader = this.c.getExtraHeader();
        if (extraHeader != null) {
            for (Map.Entry<String, String> entry : extraHeader.entrySet()) {
                a2.addCustomValues(entry.getKey(), entry.getValue());
            }
        }
        return a2;
    }

    public String getUuid() {
        return this.d.c();
    }

    public boolean isAuthorized() {
        return this.f;
    }

    public boolean isDeviceChanged() {
        String c;
        if (this.d.c() == null || (c = this.e.c()) == null) {
            return false;
        }
        return !c.equals(this.d.f());
    }

    public boolean isDeviceCompromised() {
        return this.e.g();
    }

    public void queryXuid(CallbackListener<Map<String, String>> callbackListener) {
        String d = this.d.d();
        String e = this.d.e();
        if (d == null || e == null) {
            getSignedRequest().request("GET", net.gree.gamelib.core.a.b.a.c(getConfig().getServerBaseUrl()), c(callbackListener));
        } else if (callbackListener == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("x_uid", d);
            hashMap.put("x_app_id", e);
            callbackListener.onSuccess(hashMap);
        }
    }

    public void register3rdPartyUserAccount(int i, String str, String str2, CallbackListener<Void> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", i);
            jSONObject.put("hashed_account_id", net.gree.gamelib.core.a.c.c.b(str));
            jSONObject.put(net.gree.gamelib.core.a.b.a.x, str2);
            signedRequest.setEntity(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.k(getConfig().getServerBaseUrl()), net.gree.gamelib.core.a.b.a.g(callbackListener));
    }

    public void registerPassword(String str, CallbackListener<Void> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(net.gree.gamelib.core.a.b.a.q, net.gree.gamelib.core.a.a.a.b(str));
            signedRequest.setEntity(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.d(getConfig().getServerBaseUrl()), net.gree.gamelib.core.a.b.a.b(callbackListener));
    }

    public void registerUserAccount(String str, String str2, CallbackListener<Void> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(net.gree.gamelib.core.a.b.a.r, str);
            jSONObject.put(net.gree.gamelib.core.a.b.a.q, net.gree.gamelib.core.a.a.a.b(str2));
            signedRequest.setEntity(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.e(getConfig().getServerBaseUrl()), net.gree.gamelib.core.a.b.a.d(callbackListener));
    }

    public void registerXuid(Map<String, String> map, CallbackListener<Void> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x_uid", map.get("x_uid"));
            jSONObject.put("x_app_id", map.get("x_app_id"));
            signedRequest.setEntity(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.c(getConfig().getServerBaseUrl()), b(callbackListener));
    }

    public void request3rdPartyUserAccount(CallbackListener<ThirdPartyAccountList> callbackListener) {
        getSignedRequest().request("GET", net.gree.gamelib.core.a.b.a.j(getConfig().getServerBaseUrl()), net.gree.gamelib.core.a.b.a.f(callbackListener));
    }

    public void requestMigration(VerifyResult verifyResult, CallbackListener<Void> callbackListener) {
        if (!this.h.a()) {
            if (callbackListener == null) {
                return;
            }
            callbackListener.onError(17219, "The process is already in progress");
            return;
        }
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        String r = this.d.g() ? this.e.r() : this.d.a();
        if (verifyResult != null) {
            try {
                jSONObject.put("migration_token", verifyResult.getMigrationToken());
                jSONObject.put("src_uuid", verifyResult.getSourceUUID());
                jSONObject.put(net.gree.gamelib.core.a.b.a.o, this.e.c());
                jSONObject.put(net.gree.gamelib.core.a.b.a.p, "-----BEGIN PUBLIC KEY-----\n" + net.gree.gamelib.core.a.c.c.e(r) + "\n-----END PUBLIC KEY-----\n");
                if (!this.d.g()) {
                    jSONObject.put(net.gree.gamelib.core.a.b.a.n, getUuid());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        signedRequest.setEntity(jSONObject.toString());
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.h(getConfig().getServerBaseUrl()), a(verifyResult.getSourceUUID(), callbackListener));
    }

    public void requestMigrationCode(int i, CallbackListener<String> callbackListener) {
        getSignedRequest().request("GET", net.gree.gamelib.core.a.b.a.a(getConfig().getServerBaseUrl(), i), net.gree.gamelib.core.a.b.a.a(callbackListener));
    }

    protected void requrestVerifyDevice(net.gree.gamelib.core.a.a aVar, String str, String str2, CallbackListener<DeviceVerifyResult> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(net.gree.gamelib.core.a.b.a.o, aVar.c());
            jSONObject.put("compromised", aVar.g());
            jSONObject.put("emulator", aVar.j());
            jSONObject.put("debug", aVar.k());
            jSONObject.put("installer", aVar.l());
            jSONObject.put("bundle_id", aVar.m());
            jSONObject.put("app_version", aVar.f());
            jSONObject.put("os_version", aVar.n());
            if (str != null) {
                jSONObject.put("sf_jws", str);
            }
            if (str2 != null) {
                jSONObject.put("sf_error", str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.setEntity(jSONObject.toString());
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.p(getConfig().getServerBaseUrl()), new ResponseAdapter<DeviceVerifyResult>(a, callbackListener) { // from class: net.gree.gamelib.core.Core.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public DeviceVerifyResult mo48jsonObjectToResponseData(JSONObject jSONObject2) {
                DeviceVerifyResult deviceVerifyResult = new DeviceVerifyResult(jSONObject);
                deviceVerifyResult.setVerifyResultCode(jSONObject2.optInt(DeviceVerifyResult.KEY_VERIFY_RESULT_CODE));
                DeviceVerifyResult.SafetyNetResult safetyNetResult = deviceVerifyResult.getSafetyNetResult();
                if (safetyNetResult != null) {
                    safetyNetResult.setVerifyResultCode(jSONObject2.optInt(DeviceVerifyResult.KEY_SAFETYNET_VERIFY_RESULT_CODE));
                }
                return deviceVerifyResult;
            }
        });
    }

    public void resetAuthorization() {
        this.d.h();
        this.f = false;
        this.e.t();
    }

    public void unregister3rdPartyUserAccount(int i, CallbackListener<Void> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", i);
            signedRequest.setEntity(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.l(getConfig().getServerBaseUrl()), net.gree.gamelib.core.a.b.a.h(callbackListener));
    }

    public void updateUserToken(final CallbackListener<Void> callbackListener) {
        final String c = this.d.c();
        if (c == null) {
            return;
        }
        if (this.i.a()) {
            EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.core.Core.5
                @Override // java.lang.Runnable
                public void run() {
                    String b2;
                    SignedRequest signedRequest = Core.this.getSignedRequest();
                    JSONObject jSONObject = new JSONObject();
                    if (Core.this.d.g()) {
                        b2 = Core.this.e.s();
                    } else {
                        b2 = Core.this.d.b();
                        Core.this.e.t();
                    }
                    String r = Core.this.e.r();
                    String c2 = net.gree.gamelib.core.a.c.c.c(c, b2);
                    try {
                        jSONObject.put(net.gree.gamelib.core.a.b.a.s, c);
                        jSONObject.put(net.gree.gamelib.core.a.b.a.t, c2);
                        jSONObject.put(net.gree.gamelib.core.a.b.a.o, Core.this.e.c());
                        jSONObject.put(net.gree.gamelib.core.a.b.a.p, "-----BEGIN PUBLIC KEY-----\n" + net.gree.gamelib.core.a.c.c.e(r) + "\n-----END PUBLIC KEY-----\n");
                        signedRequest.setEntity(jSONObject.toString());
                        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.i(Core.this.getConfig().getServerBaseUrl()), new ResponseAdapter<Void>(Core.a, callbackListener) { // from class: net.gree.gamelib.core.Core.5.1
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // net.gree.gamelib.core.http.ResponseAdapter
                            /* renamed from: a */
                            public Void mo48jsonObjectToResponseData(JSONObject jSONObject2) {
                                Core.this.i.b();
                                String r2 = Core.this.e.r();
                                String s = Core.this.e.s();
                                Core.this.d.h();
                                Core.this.d.a(r2, s, c);
                                Core.this.f = true;
                                Core.this.d.a(Core.this.e.c());
                                return null;
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        Core.this.i.b();
                    }
                }
            });
        } else if (callbackListener == null) {
        } else {
            callbackListener.onError(17219, "The process is already in progress");
        }
    }

    public void verify3rdPartyUserAccount(int i, String str, String str2, CallbackListener<VerifyResult> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", i);
            jSONObject.put("hashed_account_id", net.gree.gamelib.core.a.c.c.b(str));
            jSONObject.put(net.gree.gamelib.core.a.b.a.x, str2);
            signedRequest.setEntity(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.n(getConfig().getServerBaseUrl()), net.gree.gamelib.core.a.b.a.j(callbackListener));
    }

    public void verifyDevice(Context context, String str, final CallbackListener<DeviceVerifyResult> callbackListener) {
        if (TextUtils.isEmpty(str)) {
            requrestVerifyDevice(this.e, null, null, callbackListener);
            return;
        }
        f fVar = new f(context, this);
        if (!fVar.a()) {
            requrestVerifyDevice(this.e, null, "Google Play Service Unavailable", callbackListener);
        } else {
            fVar.a(str, new CallbackListener<String>() { // from class: net.gree.gamelib.core.Core.6
                @Override // net.gree.gamelib.core.CallbackListener
                /* renamed from: a */
                public void onSuccess(String str2) {
                    Core core = Core.this;
                    core.requrestVerifyDevice(core.e, str2, null, callbackListener);
                }

                @Override // net.gree.gamelib.core.CallbackListener
                public void onError(int i, String str2) {
                    Core core = Core.this;
                    core.requrestVerifyDevice(core.e, null, str2, callbackListener);
                }
            });
        }
    }

    public void verifyMigrationCode(String str, String str2, CallbackListener<VerifyResult> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(net.gree.gamelib.core.a.b.a.j, str);
            if (str2 != null && str2.length() > 0) {
                jSONObject.put(net.gree.gamelib.core.a.b.a.q, net.gree.gamelib.core.a.a.a.b(str2));
            }
            signedRequest.setEntity(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.f(getConfig().getServerBaseUrl()), net.gree.gamelib.core.a.b.a.c(callbackListener));
    }

    public void verifyUserAccount(String str, String str2, CallbackListener<VerifyResult> callbackListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(net.gree.gamelib.core.a.b.a.r, str);
            if (str2 != null && str2.length() > 0) {
                jSONObject.put(net.gree.gamelib.core.a.b.a.q, net.gree.gamelib.core.a.a.a.b(str2));
            }
            signedRequest.setEntity(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        signedRequest.request("POST", net.gree.gamelib.core.a.b.a.g(getConfig().getServerBaseUrl()), net.gree.gamelib.core.a.b.a.e(callbackListener));
    }
}
