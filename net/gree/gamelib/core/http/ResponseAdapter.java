package net.gree.gamelib.core.http;

import net.gree.gamelib.core.CallbackListener;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.core.a.b.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class ResponseAdapter<T> implements ResponseListener {
    protected CallbackListener<T> mListener;
    protected String mTag;

    public ResponseAdapter(String str, CallbackListener<T> callbackListener) {
        this.mTag = str;
        this.mListener = callbackListener;
    }

    /* renamed from: jsonObjectToResponseData */
    protected abstract T mo48jsonObjectToResponseData(JSONObject jSONObject);

    /* renamed from: jsonStringToResponseData */
    protected T mo49jsonStringToResponseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (b.d.equals(jSONObject.getString(b.c))) {
            return mo48jsonObjectToResponseData(jSONObject);
        }
        throw new JSONException("result is not OK");
    }

    @Override // net.gree.gamelib.core.http.ResponseListener
    public void onResponse(HttpResponse httpResponse, String str) {
        String message;
        String str2 = this.mTag;
        GLog.i(str2, "Response body:" + str);
        if (httpResponse == null) {
            CallbackListener<T> callbackListener = this.mListener;
            if (callbackListener == null) {
                return;
            }
            callbackListener.onError(1000, "Network error");
            return;
        }
        if (str == null) {
            str = "";
        }
        try {
            if (httpResponse.getStatusCode() == 200) {
                T mo49jsonStringToResponseData = mo49jsonStringToResponseData(str);
                if (this.mListener == null) {
                    return;
                }
                this.mListener.onSuccess(mo49jsonStringToResponseData);
                return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 17220;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i = jSONObject.getInt(b.f);
            message = jSONObject.getString(b.g);
        } catch (JSONException e2) {
            e2.printStackTrace();
            message = e2.getMessage();
        }
        CallbackListener<T> callbackListener2 = this.mListener;
        if (callbackListener2 == null) {
            return;
        }
        callbackListener2.onError(i, message);
    }
}
