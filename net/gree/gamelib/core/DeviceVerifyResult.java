package net.gree.gamelib.core;

import android.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeviceVerifyResult {
    public static final String KEY_SAFETYNET_VERIFY_RESULT_CODE = "sf_verify_result_code";
    public static final String KEY_VERIFY_RESULT_CODE = "verify_result_code";
    private static final String a = "compromised";
    private static final String b = "emulator";
    private static final String c = "debug";
    private static final String d = "installer";
    private static final String e = "bundle_id";
    private static final String f = "app_version";
    private static final String g = "os_version";
    private static final String h = "sf_jws";
    private static final String i = "apkPackageName";
    private static final String j = "apkCertificateDigestSha256";
    private static final String k = "apkDigestSha256";
    private static final String l = "ctsProfileMatch";
    private static final String m = "basicIntegrity";
    private int n = -1;
    private boolean o;
    private boolean p;
    private boolean q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private SafetyNetResult w;

    /* loaded from: classes.dex */
    public class SafetyNetResult {
        private int b = -1;
        private String c;
        private String d;
        private String e;
        private boolean f;
        private boolean g;

        public SafetyNetResult() {
        }

        public String getApkCertificateDigest() {
            return this.d;
        }

        public String getApkDigest() {
            return this.e;
        }

        public String getApkPackageName() {
            return this.c;
        }

        public int getVerifyResultCode() {
            return this.b;
        }

        public boolean isBasicIntegrity() {
            return this.g;
        }

        public boolean isCtsProfileMatch() {
            return this.f;
        }

        public void setVerifyResultCode(int i) {
            this.b = i;
        }
    }

    public DeviceVerifyResult(JSONObject jSONObject) {
        this.w = null;
        this.o = jSONObject.optBoolean(a);
        this.p = jSONObject.optBoolean(b);
        this.q = jSONObject.optBoolean(c);
        this.r = jSONObject.optString(d);
        this.s = jSONObject.optString(e);
        this.t = jSONObject.optString(f);
        this.u = jSONObject.optString(g);
        this.v = jSONObject.optString(h);
        JSONObject a2 = a(this.v);
        if (a2 != null) {
            this.w = new SafetyNetResult();
            this.w.c = a2.optString(i);
            this.w.d = a2.optJSONArray(j).optString(0);
            this.w.e = a2.optString(k);
            this.w.f = a2.optBoolean(l);
            this.w.g = a2.optBoolean(m);
        }
    }

    private JSONObject a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length != 3) {
            return null;
        }
        try {
            return new JSONObject(new String(Base64.decode(split[1], 8)));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getAppVersion() {
        return this.t;
    }

    public String getInstaller() {
        return this.r;
    }

    public String getOsVersion() {
        return this.u;
    }

    public String getPackageName() {
        return this.s;
    }

    public SafetyNetResult getSafetyNetResult() {
        return this.w;
    }

    public int getVerifyResultCode() {
        return this.n;
    }

    public boolean isCompromised() {
        return this.o;
    }

    public boolean isDebug() {
        return this.q;
    }

    public boolean isEmulator() {
        return this.p;
    }

    public void setVerifyResultCode(int i2) {
        this.n = i2;
    }
}
