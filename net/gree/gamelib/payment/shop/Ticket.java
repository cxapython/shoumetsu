package net.gree.gamelib.payment.shop;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class Ticket {
    public static final String KEY_ALLOW_NEXT_PURCHASE = "allow_next_purchase";
    public static final String KEY_AMENITY_LABEL = "amenity_label";
    public static final String KEY_TICKET_END_DATETIME = "ticket_end_datetime";
    public static final String KEY_TICKET_START_DATETIME = "ticket_start_datetime";
    public static final String KEY_VALID_DAYS = "valid_days";
    protected int mAllowNextPurchase;
    protected String mAmenityLabel;
    protected JSONObject mJson;
    protected String mTicketEndDatetime;
    protected String mTicketStartDatetime;
    protected int mValidDays;

    public Ticket(JSONObject jSONObject) {
        this.mJson = jSONObject;
        this.mAmenityLabel = this.mJson.getString("amenity_label");
        this.mTicketStartDatetime = this.mJson.optString(KEY_TICKET_START_DATETIME);
        this.mTicketEndDatetime = this.mJson.optString(KEY_TICKET_END_DATETIME);
        this.mValidDays = this.mJson.optInt(KEY_VALID_DAYS);
        this.mAllowNextPurchase = this.mJson.optInt(KEY_ALLOW_NEXT_PURCHASE);
    }

    public int getAllowNextPurchase() {
        return this.mAllowNextPurchase;
    }

    public String getAmenityLabel() {
        return this.mAmenityLabel;
    }

    public String getTicketEndDatetime() {
        return this.mTicketEndDatetime;
    }

    public String getTicketStartDatetime() {
        return this.mTicketStartDatetime;
    }

    public int getValidDays() {
        return this.mValidDays;
    }

    public String toString() {
        return this.mJson.toString();
    }
}
