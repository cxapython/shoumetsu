package net.gree.gamelib.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import net.gree.gamelib.core.CallbackListener;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.http.ResponseAdapter;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {
    private static final String a = "f";
    private static final String b = "nonce";
    private static final Executor c = Executors.newCachedThreadPool();
    private SafetyNetClient d;
    private Core e;
    private boolean f;

    public f(Context context, Core core) {
        this(core, SafetyNet.getClient(context), GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0);
    }

    public f(Core core, SafetyNetClient safetyNetClient, boolean z) {
        this.e = core;
        this.d = safetyNetClient;
        this.f = false;
        this.f = z;
    }

    public void a(final String str, final CallbackListener<String> callbackListener) {
        a(new CallbackListener<String>() { // from class: net.gree.gamelib.core.a.f.2
            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str2) {
                CallbackListener callbackListener2 = callbackListener;
                if (callbackListener2 != null) {
                    callbackListener2.onError(i, str2);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onSuccess(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    f.this.d.attest(str2.getBytes(), str).addOnSuccessListener(f.c, new OnSuccessListener<SafetyNetApi.AttestationResponse>() { // from class: net.gree.gamelib.core.a.f.2.2
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public void onSuccess(SafetyNetApi.AttestationResponse attestationResponse) {
                            if (callbackListener != null) {
                                callbackListener.onSuccess(attestationResponse.getJwsResult());
                            }
                        }
                    }).addOnFailureListener(f.c, new OnFailureListener() { // from class: net.gree.gamelib.core.a.f.2.1
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public void onFailure(Exception exc) {
                            if (callbackListener != null) {
                                callbackListener.onError(17220, exc.getMessage());
                            }
                        }
                    });
                    return;
                }
                CallbackListener callbackListener2 = callbackListener;
                if (callbackListener2 == null) {
                    return;
                }
                callbackListener2.onSuccess(null);
            }
        });
    }

    protected void a(CallbackListener<String> callbackListener) {
        this.e.getSignedRequest().request("POST", net.gree.gamelib.core.a.b.a.o(this.e.getConfig().getServerBaseUrl()), new ResponseAdapter<String>(a, callbackListener) { // from class: net.gree.gamelib.core.a.f.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // net.gree.gamelib.core.http.ResponseAdapter
            /* renamed from: a */
            public String mo48jsonObjectToResponseData(JSONObject jSONObject) {
                return jSONObject.optString(f.b);
            }
        });
    }

    public boolean a() {
        return this.f;
    }
}
