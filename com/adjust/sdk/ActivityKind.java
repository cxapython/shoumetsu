package com.adjust.sdk;

import com.google.android.gms.tagmanager.DataLayer;

/* loaded from: classes.dex */
public enum ActivityKind {
    UNKNOWN,
    SESSION,
    EVENT,
    CLICK,
    ATTRIBUTION,
    REVENUE,
    REATTRIBUTION,
    INFO,
    GDPR,
    AD_REVENUE,
    DISABLE_THIRD_PARTY_SHARING,
    SUBSCRIPTION,
    THIRD_PARTY_SHARING,
    MEASUREMENT_CONSENT;

    public static ActivityKind fromString(String str) {
        return "session".equals(str) ? SESSION : DataLayer.EVENT_KEY.equals(str) ? EVENT : "click".equals(str) ? CLICK : "attribution".equals(str) ? ATTRIBUTION : "info".equals(str) ? INFO : "gdpr".equals(str) ? GDPR : "disable_third_party_sharing".equals(str) ? DISABLE_THIRD_PARTY_SHARING : "ad_revenue".equals(str) ? AD_REVENUE : "subscription".equals(str) ? SUBSCRIPTION : "third_party_sharing".equals(str) ? THIRD_PARTY_SHARING : "measurement_consent".equals(str) ? MEASUREMENT_CONSENT : UNKNOWN;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (this) {
            case SESSION:
                return "session";
            case EVENT:
                return DataLayer.EVENT_KEY;
            case CLICK:
                return "click";
            case ATTRIBUTION:
                return "attribution";
            case INFO:
                return "info";
            case GDPR:
                return "gdpr";
            case DISABLE_THIRD_PARTY_SHARING:
                return "disable_third_party_sharing";
            case AD_REVENUE:
                return "ad_revenue";
            case SUBSCRIPTION:
                return "subscription";
            case THIRD_PARTY_SHARING:
                return "third_party_sharing";
            case MEASUREMENT_CONSENT:
                return "measurement_consent";
            default:
                return "unknown";
        }
    }
}
