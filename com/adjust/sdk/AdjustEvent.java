package com.adjust.sdk;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AdjustEvent {
    private static ILogger logger = AdjustFactory.getLogger();
    String callbackId;
    Map<String, String> callbackParameters;
    String currency;
    String eventToken;
    String orderId;
    Map<String, String> partnerParameters;
    Double revenue;

    public AdjustEvent(String str) {
        if (!checkEventToken(str, logger)) {
            return;
        }
        this.eventToken = str;
    }

    private static boolean checkEventToken(String str, ILogger iLogger) {
        String str2;
        if (str == null) {
            str2 = "Missing Event Token";
        } else if (str.length() > 0) {
            return true;
        } else {
            str2 = "Event Token can't be empty";
        }
        iLogger.error(str2, new Object[0]);
        return false;
    }

    private boolean checkRevenue(Double d, String str) {
        if (d != null) {
            if (d.doubleValue() < 0.0d) {
                logger.error("Invalid amount %.5f", d);
                return false;
            } else if (str == null) {
                logger.error("Currency must be set with revenue", new Object[0]);
                return false;
            } else if (str.equals("")) {
                logger.error("Currency is empty", new Object[0]);
                return false;
            }
        } else if (str != null) {
            logger.error("Revenue must be set with currency", new Object[0]);
            return false;
        }
        return true;
    }

    public void addCallbackParameter(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Callback") && Util.isValidParameter(str2, "value", "Callback")) {
            if (this.callbackParameters == null) {
                this.callbackParameters = new LinkedHashMap();
            }
            if (this.callbackParameters.put(str, str2) == null) {
                return;
            }
            logger.warn("Key %s was overwritten", str);
        }
    }

    public void addPartnerParameter(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Partner") && Util.isValidParameter(str2, "value", "Partner")) {
            if (this.partnerParameters == null) {
                this.partnerParameters = new LinkedHashMap();
            }
            if (this.partnerParameters.put(str, str2) == null) {
                return;
            }
            logger.warn("Key %s was overwritten", str);
        }
    }

    public boolean isValid() {
        return this.eventToken != null;
    }

    public void setCallbackId(String str) {
        this.callbackId = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setRevenue(double d, String str) {
        if (!checkRevenue(Double.valueOf(d), str)) {
            return;
        }
        this.revenue = Double.valueOf(d);
        this.currency = str;
    }
}
