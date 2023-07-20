package net.gree.gamelib.core.a.b;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import net.gree.gamelib.core.CallbackListener;
import net.gree.gamelib.core.http.ResponseAdapter;
import net.gree.gamelib.core.http.ResponseListener;
import net.gree.gamelib.core.migration.ThirdPartyAccountList;
import net.gree.gamelib.core.migration.VerifyResult;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private static final String A = "/v1.0/auth/initialize";
    private static final String B = "/v1.0/auth/authorize";
    private static final String C = "/v1.0/auth/x_uid";
    private static final String D = "/v1.0/migration/code";
    private static final String E = "/v1.0/migration/password/register";
    private static final String F = "/v1.0/migration/code/verify";
    private static final String G = "/v1.0/migration";
    private static final String H = "/v1.0/migration/extra/user/register";
    private static final String I = "/v1.0/migration/extra/user/verify";
    private static final String J = "/v1.0/migration/user/token";
    private static final String K = "/v1.0/migration/3rd/user";
    private static final String L = "/v1.0/migration/3rd/user/register";
    private static final String M = "/v1.0/migration/3rd/user/unregister";
    private static final String N = "/v1.0/migration/3rd/user/clear";
    private static final String O = "/v1.0/migration/3rd/user/verify";
    private static final String P = "/v1.0/deviceverification/nonce";
    private static final String Q = "/v1.0/deviceverification/verify";
    private static final String R = "authVersion";
    private static final String S = "appVersion";
    private static final String T = "uaType";
    private static final String U = "android-app";
    private static final String V = "carrier";
    private static final String W = "compromised";
    private static final String X = "countryCode";
    private static final String Y = "currencyCode";
    public static final String a = "GET";
    public static final String b = "POST";
    public static final String c = "PUT";
    public static final String d = "DELETE";
    public static final String e = "X-GREE-GAMELIB";
    public static final int f = 60000;
    public static final int g = 60000;
    public static final String h = "x_uid";
    public static final String i = "x_app_id";
    public static final String j = "migration_code";
    public static final String k = "migration_token";
    public static final String l = "src_uuid";
    public static final String m = "src_x_uid";
    public static final String n = "dst_uuid";
    public static final String o = "device_id";
    public static final String p = "token";
    public static final String q = "migration_password";
    public static final String r = "extra_account";
    public static final String s = "uuid";
    public static final String t = "fingerprint";
    public static final String u = "accounts";
    public static final String v = "platform";
    public static final String w = "hashed_account_id";
    public static final String x = "access_token";
    public static final String y = "cleared_uuid";
    private static final String z = "a";

    private a() {
    }

    public static String a(String str) {
        return str + A;
    }

    public static String a(String str, int i2) {
        return str + D + "?renew=" + i2;
    }

    public static String a(String str, Map<String, String> map, String str2, String str3, boolean z2, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(R);
        sb.append('=');
        sb.append(str);
        sb.append('&');
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                sb.append('&');
            }
        }
        sb.append(S);
        sb.append('=');
        sb.append(str2);
        sb.append('&');
        sb.append(T);
        sb.append('=');
        sb.append(U);
        sb.append('&');
        sb.append(V);
        sb.append('=');
        sb.append(str3);
        sb.append('&');
        sb.append(W);
        sb.append('=');
        sb.append(z2);
        sb.append('&');
        sb.append(X);
        sb.append('=');
        sb.append(str4);
        sb.append('&');
        sb.append(Y);
        sb.append('=');
        sb.append(str5);
        try {
            return URLEncoder.encode(sb.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static ResponseListener a(CallbackListener<String> callbackListener) {
        return new ResponseAdapter<String>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public String mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return jSONObject.getString(a.j);
            }
        };
    }

    public static String b(String str) {
        return str + B;
    }

    public static ResponseListener b(CallbackListener<Void> callbackListener) {
        return new ResponseAdapter<Void>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public Void mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return null;
            }
        };
    }

    public static String c(String str) {
        return str + C;
    }

    public static ResponseListener c(CallbackListener<VerifyResult> callbackListener) {
        return new ResponseAdapter<VerifyResult>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public VerifyResult mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return new VerifyResult(jSONObject);
            }
        };
    }

    public static String d(String str) {
        return str + E;
    }

    public static ResponseListener d(CallbackListener<Void> callbackListener) {
        return new ResponseAdapter<Void>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public Void mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return null;
            }
        };
    }

    public static String e(String str) {
        return str + H;
    }

    public static ResponseListener e(CallbackListener<VerifyResult> callbackListener) {
        return new ResponseAdapter<VerifyResult>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public VerifyResult mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return new VerifyResult(jSONObject);
            }
        };
    }

    public static String f(String str) {
        return str + F;
    }

    public static ResponseListener f(CallbackListener<ThirdPartyAccountList> callbackListener) {
        return new ResponseAdapter<ThirdPartyAccountList>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public ThirdPartyAccountList mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return new ThirdPartyAccountList(jSONObject);
            }
        };
    }

    public static String g(String str) {
        return str + I;
    }

    public static ResponseListener g(CallbackListener<Void> callbackListener) {
        return new ResponseAdapter<Void>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public Void mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return null;
            }
        };
    }

    public static String h(String str) {
        return str + G;
    }

    public static ResponseListener h(CallbackListener<Void> callbackListener) {
        return new ResponseAdapter<Void>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public Void mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return null;
            }
        };
    }

    public static String i(String str) {
        return str + J;
    }

    public static ResponseListener i(CallbackListener<String> callbackListener) {
        return new ResponseAdapter<String>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public String mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return jSONObject.getString(a.y);
            }
        };
    }

    public static String j(String str) {
        return str + K;
    }

    public static ResponseListener j(CallbackListener<VerifyResult> callbackListener) {
        return new ResponseAdapter<VerifyResult>(z, callbackListener) { // from class: net.gree.gamelib.core.a.b.a.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public VerifyResult mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return new VerifyResult(jSONObject);
            }
        };
    }

    public static String k(String str) {
        return str + L;
    }

    public static String l(String str) {
        return str + M;
    }

    public static String m(String str) {
        return str + N;
    }

    public static String n(String str) {
        return str + O;
    }

    public static String o(String str) {
        return str + P;
    }

    public static String p(String str) {
        return str + Q;
    }

    public static boolean q(String str) {
        return "GET".equalsIgnoreCase(str) || "POST".equalsIgnoreCase(str) || "PUT".equalsIgnoreCase(str) || "DELETE".equalsIgnoreCase(str);
    }
}
