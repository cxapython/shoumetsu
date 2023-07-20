package com.adjust.sdk;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class SessionResponseData extends ResponseData {
    private String sdkPlatform;

    public SessionResponseData(ActivityPackage activityPackage) {
        this.sdkPlatform = Util.getSdkPrefixPlatform(activityPackage.getClientSdk());
    }

    public AdjustSessionFailure getFailureResponseData() {
        JSONObject jSONObject;
        if (this.success) {
            return null;
        }
        AdjustSessionFailure adjustSessionFailure = new AdjustSessionFailure();
        if ("unity".equals(this.sdkPlatform)) {
            adjustSessionFailure.message = this.message != null ? this.message : "";
            adjustSessionFailure.timestamp = this.timestamp != null ? this.timestamp : "";
            adjustSessionFailure.adid = this.adid != null ? this.adid : "";
            adjustSessionFailure.willRetry = this.willRetry;
            if (this.jsonResponse == null) {
                jSONObject = new JSONObject();
                adjustSessionFailure.jsonResponse = jSONObject;
                return adjustSessionFailure;
            }
        } else {
            adjustSessionFailure.message = this.message;
            adjustSessionFailure.timestamp = this.timestamp;
            adjustSessionFailure.adid = this.adid;
            adjustSessionFailure.willRetry = this.willRetry;
        }
        jSONObject = this.jsonResponse;
        adjustSessionFailure.jsonResponse = jSONObject;
        return adjustSessionFailure;
    }

    public AdjustSessionSuccess getSuccessResponseData() {
        JSONObject jSONObject;
        if (!this.success) {
            return null;
        }
        AdjustSessionSuccess adjustSessionSuccess = new AdjustSessionSuccess();
        if ("unity".equals(this.sdkPlatform)) {
            adjustSessionSuccess.message = this.message != null ? this.message : "";
            adjustSessionSuccess.timestamp = this.timestamp != null ? this.timestamp : "";
            adjustSessionSuccess.adid = this.adid != null ? this.adid : "";
            if (this.jsonResponse == null) {
                jSONObject = new JSONObject();
                adjustSessionSuccess.jsonResponse = jSONObject;
                return adjustSessionSuccess;
            }
        } else {
            adjustSessionSuccess.message = this.message;
            adjustSessionSuccess.timestamp = this.timestamp;
            adjustSessionSuccess.adid = this.adid;
        }
        jSONObject = this.jsonResponse;
        adjustSessionSuccess.jsonResponse = jSONObject;
        return adjustSessionSuccess;
    }
}
