package net.gree.gamelib.payment;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import net.gree.gamelib.core.CallbackListener;
import net.gree.gamelib.core.Config;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.DeviceVerifyResult;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.core.http.SignedRequest;
import net.gree.gamelib.core.migration.ThirdPartyAccountList;
import net.gree.gamelib.core.migration.VerifyResult;
import net.gree.gamelib.payment.AgeVerification;
import net.gree.gamelib.payment.internal.a.b;
import net.gree.gamelib.payment.internal.b.c;
import net.gree.gamelib.payment.internal.d;
import net.gree.gamelib.payment.migration.MigrationCodeVerifyResult;
import net.gree.gamelib.payment.migration.MigrationVerifyResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Payment {
    private static final String a = "Payment";
    private static final String b = "1.7.1";
    private static final int c = 3;
    private static final String d = "v1.0";
    private static final String e = "v1.0";
    private static final boolean f = false;
    private static Payment g;
    private Core h;
    private Context i;
    private Map<String, String> j;
    private c k;
    private String l;
    private a m;

    /* loaded from: classes.dex */
    interface a {
        void a(int i, int i2, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Payment() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Payment(Context context, String str, String str2, Map<String, String> map) {
        this.i = context.getApplicationContext();
        this.j = map;
        this.k = new c(map);
        Config config = new Config(this.k.getDomain(), str, str2);
        config.setServerBaseUrl(this.k.getBaseUrl());
        HashMap hashMap = new HashMap();
        if (map != null) {
            config.setScramble(map.get("ksrle"));
            String str3 = map.get("isTestUser");
            if (str3 != null) {
                config.setTestUserEnabled(Boolean.valueOf(str3).booleanValue());
            }
            this.l = map.get(SettingConsts.STORE_TYPE);
            if (this.l == null) {
                this.l = "google";
            }
            hashMap.put(SettingConsts.STORE_TYPE, this.l);
            String str4 = map.get("policy");
            if (str4 != null) {
                hashMap.put("policy", str4);
            }
            String str5 = map.get(SettingConsts.PRODUCT_LIST_PRIORITY);
            if (str5 != null) {
                hashMap.put(SettingConsts.PRODUCT_LIST_PRIORITY, str5);
            }
            config.setExtraHeader(hashMap);
        }
        this.h = createCore(context, config);
        if (b.a.equalsIgnoreCase(this.l)) {
            net.gree.gamelib.payment.internal.b.a();
        }
    }

    static long a(long j, int i) {
        if (i >= 0) {
            long j2 = 1;
            for (int i2 = 0; i2 < i; i2++) {
                j2 *= j;
            }
            return j2;
        }
        throw new IllegalArgumentException("negative value received");
    }

    static void a() {
        g = null;
    }

    public static Payment getInstance() {
        Payment payment = g;
        return payment == null ? d.d() : payment;
    }

    public static String getVersion() {
        return b;
    }

    public static synchronized void initialize(Context context, String str, String str2, Map<String, String> map) {
        synchronized (Payment.class) {
            if (g == null) {
                g = net.gree.gamelib.payment.a.a(context, str, str2, map);
            }
        }
    }

    Xuid a(Map<String, String> map) {
        return new Xuid(map);
    }

    void a(final int i, final int i2, final PaymentListener<Xuid> paymentListener) {
        if (i <= 0) {
            i = 0;
        }
        this.h.queryXuid(new CallbackListener<Map<String, String>>() { // from class: net.gree.gamelib.payment.Payment.13
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Map<String, String> map) {
                if (paymentListener != null) {
                    Xuid xuid = null;
                    try {
                        xuid = Payment.this.a(map);
                        if (TextUtils.isEmpty(xuid.getUserId())) {
                            onError(3000, PaymentError.ERROR_MESSAGE_XUID_NOT_REGISTERED);
                            return;
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    paymentListener.onSuccess(xuid);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(final int i3, final String str) {
                final int i4 = i + 1;
                if (i2 >= i4) {
                    new Handler().postDelayed(new Runnable() { // from class: net.gree.gamelib.payment.Payment.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str2 = Payment.a;
                            GLog.i(str2, "queryXuid retries " + i4 + " times.");
                            if (Payment.this.m != null) {
                                Payment.this.m.a(i4, i3, str);
                            }
                            Payment.this.a(i4, i2, paymentListener);
                        }
                    }, Payment.this.getInterval(i4));
                    return;
                }
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 == null) {
                    return;
                }
                paymentListener2.onError(i3, str);
            }
        });
    }

    void a(a aVar) {
        this.m = aVar;
    }

    void a(JSONObject jSONObject, boolean z, String str) {
        jSONObject.put("minor", z);
        if (str != null) {
            jSONObject.put("birthday", str);
        }
    }

    public void authorize(final String str, final PaymentListener<Void> paymentListener) {
        final CallbackListener<Void> callbackListener = new CallbackListener<Void>() { // from class: net.gree.gamelib.payment.Payment.1
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i, str2);
                }
            }
        };
        if (b.a.equalsIgnoreCase(this.l)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.gree.gamelib.payment.Payment.12
                @Override // java.lang.Runnable
                public void run() {
                    net.gree.gamelib.payment.internal.b.b();
                    net.gree.gamelib.payment.internal.b.d().a(Payment.this.i, Payment.this.j, new PaymentListener<String>() { // from class: net.gree.gamelib.payment.Payment.12.1
                        @Override // net.gree.gamelib.core.CallbackListener
                        /* renamed from: a */
                        public void onSuccess(String str2) {
                            Payment.this.h.authorize(str, callbackListener);
                        }

                        @Override // net.gree.gamelib.core.CallbackListener
                        public void onError(int i, String str2) {
                            if (paymentListener != null) {
                                paymentListener.onError(i, str2);
                            }
                        }
                    });
                }
            });
        } else {
            this.h.authorize(str, callbackListener);
        }
    }

    public void authorize(PaymentListener<Void> paymentListener) {
        authorize(null, paymentListener);
    }

    c b() {
        if (this.k == null) {
            this.k = new c(this.j);
        }
        return this.k;
    }

    public void clear3rdPartyUserAccount(int i, String str, String str2, final PaymentListener<String> paymentListener) {
        this.h.clear3rdPartyUserAccount(i, str, str2, new CallbackListener<String>() { // from class: net.gree.gamelib.payment.Payment.8
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(String str3) {
                paymentListener.onSuccess(str3);
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str3) {
                paymentListener.onError(i2, str3);
            }
        });
    }

    protected Core createCore(Context context, Config config) {
        return new Core(context, config);
    }

    public String getAppId() {
        return this.h.getAppId();
    }

    public Context getContext() {
        return this.i;
    }

    public Core getCore() {
        return this.h;
    }

    public PaymentError getError(int i) {
        return new PaymentError(i);
    }

    protected long getInterval(int i) {
        if (i <= 0) {
            return 0L;
        }
        return a(3L, i) * 1000;
    }

    public Map<String, String> getParams() {
        return this.j;
    }

    public SignedRequest getSignedRequest() {
        SignedRequest signedRequest = this.h.getSignedRequest();
        signedRequest.addCustomValues(c.a, getVersion());
        return signedRequest;
    }

    public String getStoreType() {
        return this.l;
    }

    public String getUuid() {
        return this.h.getUuid();
    }

    public boolean isAuthorized() {
        return this.h.isAuthorized();
    }

    public boolean isDeviceChanged() {
        return this.h.isDeviceChanged();
    }

    public boolean isDeviceCompromised() {
        return this.h.isDeviceCompromised();
    }

    public void queryXuid(int i, PaymentListener<Xuid> paymentListener) {
        a(0, i, paymentListener);
    }

    public void queryXuid(PaymentListener<Xuid> paymentListener) {
        a(0, 0, paymentListener);
    }

    public void register3rdPartyUserAccount(int i, String str, String str2, final PaymentListener<Void> paymentListener) {
        this.h.register3rdPartyUserAccount(i, str, str2, new CallbackListener<Void>() { // from class: net.gree.gamelib.payment.Payment.6
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str3) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i2, str3);
                }
            }
        });
    }

    public void registerAge(boolean z, String str, final PaymentListener<Void> paymentListener) {
        SignedRequest signedRequest = getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, z, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        signedRequest.setEntity(jSONObject.toString());
        signedRequest.request("POST", b().d("v1.0"), new net.gree.gamelib.payment.internal.b.b<net.gree.gamelib.payment.internal.b.a>(a, new PaymentListener<net.gree.gamelib.payment.internal.b.a>() { // from class: net.gree.gamelib.payment.Payment.15
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(net.gree.gamelib.payment.internal.b.a aVar) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i, str2);
                }
            }
        }) { // from class: net.gree.gamelib.payment.Payment.16
            @Override // net.gree.gamelib.payment.internal.b.b
            /* renamed from: toPaymentResponse */
            protected net.gree.gamelib.payment.internal.b.a mo54toPaymentResponse(String str2) {
                return null;
            }
        });
    }

    public void registerMigrationPassword(String str, final PaymentListener<Void> paymentListener) {
        this.h.registerPassword(str, new CallbackListener<Void>() { // from class: net.gree.gamelib.payment.Payment.18
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str2) {
                paymentListener.onError(i, str2);
            }
        });
    }

    public void registerMigrationUserAccount(String str, String str2, final PaymentListener<Void> paymentListener) {
        this.h.registerUserAccount(str, str2, new CallbackListener<Void>() { // from class: net.gree.gamelib.payment.Payment.2
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str3) {
                paymentListener.onError(i, str3);
            }
        });
    }

    public void registerXuid(String str, String str2, final PaymentListener<Void> paymentListener) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("x_uid", str);
        treeMap.put("x_app_id", str2);
        this.h.registerXuid(treeMap, new CallbackListener<Void>() { // from class: net.gree.gamelib.payment.Payment.14
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str3) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i, str3);
                }
            }
        });
    }

    public void request3rdPartyUserAccount(final PaymentListener<ThirdPartyAccountList> paymentListener) {
        this.h.request3rdPartyUserAccount(new CallbackListener<ThirdPartyAccountList>() { // from class: net.gree.gamelib.payment.Payment.5
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(ThirdPartyAccountList thirdPartyAccountList) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(thirdPartyAccountList);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i, str);
                }
            }
        });
    }

    public void requestMigration(MigrationVerifyResult migrationVerifyResult, final PaymentListener<Void> paymentListener) {
        VerifyResult verifyResult;
        try {
            verifyResult = new VerifyResult(migrationVerifyResult.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
            verifyResult = null;
        }
        this.h.requestMigration(verifyResult, new CallbackListener<Void>() { // from class: net.gree.gamelib.payment.Payment.4
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i, str);
                }
            }
        });
    }

    public void requestMigrationCode(int i, final PaymentListener<String> paymentListener) {
        this.h.requestMigrationCode(i, new CallbackListener<String>() { // from class: net.gree.gamelib.payment.Payment.17
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(String str) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(str);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i2, str);
                }
            }
        });
    }

    public void resetAuthorization() {
        this.h.resetAuthorization();
    }

    public String sign(String str) {
        return this.h.getSignedRequest().sign(str);
    }

    public void unregister3rdPartyUserAccount(int i, final PaymentListener<Void> paymentListener) {
        this.h.unregister3rdPartyUserAccount(i, new CallbackListener<Void>() { // from class: net.gree.gamelib.payment.Payment.7
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r2) {
                paymentListener.onSuccess(null);
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str) {
                paymentListener.onError(i2, str);
            }
        });
    }

    public void updateUserToken(final PaymentListener<Void> paymentListener) {
        this.h.updateUserToken(new CallbackListener<Void>() { // from class: net.gree.gamelib.payment.Payment.10
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i, str);
                }
            }
        });
    }

    public void verify3rdPartyUserAccount(int i, String str, String str2, final PaymentListener<MigrationVerifyResult> paymentListener) {
        this.h.verify3rdPartyUserAccount(i, str, str2, new CallbackListener<VerifyResult>() { // from class: net.gree.gamelib.payment.Payment.9
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(VerifyResult verifyResult) {
                try {
                    MigrationVerifyResult migrationVerifyResult = new MigrationVerifyResult(verifyResult.getPayload().toString());
                    if (paymentListener == null) {
                        return;
                    }
                    paymentListener.onSuccess(migrationVerifyResult);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    PaymentListener paymentListener2 = paymentListener;
                    if (paymentListener2 == null) {
                        return;
                    }
                    paymentListener2.onError(17220, verifyResult.getPayload().toString());
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str3) {
                paymentListener.onError(i2, str3);
            }
        });
    }

    public void verifyAge(PaymentListener<AgeVerification> paymentListener) {
        getSignedRequest().request("GET", b().c("v1.0"), new AgeVerification.ResponseAdapter(paymentListener));
    }

    public void verifyDevice(String str, final PaymentListener<DeviceVerifyResult> paymentListener) {
        if (!"google".equalsIgnoreCase(this.l)) {
            str = null;
        }
        this.h.verifyDevice(this.i, str, new CallbackListener<DeviceVerifyResult>() { // from class: net.gree.gamelib.payment.Payment.11
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(DeviceVerifyResult deviceVerifyResult) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(deviceVerifyResult);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i, str2);
                }
            }
        });
    }

    public void verifyDevice(PaymentListener<DeviceVerifyResult> paymentListener) {
        verifyDevice(null, paymentListener);
    }

    public void verifyMigrationCode(String str, String str2, final PaymentListener<MigrationCodeVerifyResult> paymentListener) {
        this.h.verifyMigrationCode(str, str2, new CallbackListener<VerifyResult>() { // from class: net.gree.gamelib.payment.Payment.19
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(VerifyResult verifyResult) {
                try {
                    MigrationCodeVerifyResult migrationCodeVerifyResult = new MigrationCodeVerifyResult(verifyResult.getPayload().toString());
                    if (paymentListener == null) {
                        return;
                    }
                    paymentListener.onSuccess(migrationCodeVerifyResult);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    PaymentListener paymentListener2 = paymentListener;
                    if (paymentListener2 == null) {
                        return;
                    }
                    paymentListener2.onError(17220, verifyResult.getPayload().toString());
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str3) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i, str3);
                }
            }
        });
    }

    public void verifyMigrationUserAccount(String str, String str2, final PaymentListener<MigrationVerifyResult> paymentListener) {
        this.h.verifyUserAccount(str, str2, new CallbackListener<VerifyResult>() { // from class: net.gree.gamelib.payment.Payment.3
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(VerifyResult verifyResult) {
                try {
                    MigrationVerifyResult migrationVerifyResult = new MigrationVerifyResult(verifyResult.getPayload().toString());
                    if (paymentListener == null) {
                        return;
                    }
                    paymentListener.onSuccess(migrationVerifyResult);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    PaymentListener paymentListener2 = paymentListener;
                    if (paymentListener2 == null) {
                        return;
                    }
                    paymentListener2.onError(17220, verifyResult.getPayload().toString());
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str3) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i, str3);
                }
            }
        });
    }
}
