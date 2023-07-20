package net.gree.gamelib.payment.depositbook;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class Transaction {
    protected static final String KEY_CHARGE = "balance_change_charge";
    protected static final String KEY_CHARGE_EXPIRATION = "expire_charge";
    protected static final String KEY_DATE = "date";
    protected static final String KEY_FORMATTED_PRICE = "formatted_price";
    protected static final String KEY_FREE = "balance_change_free";
    protected static final String KEY_FREE_EXPIRATION = "expire_free";
    protected static final String KEY_PRICE = "price";
    protected static final String KEY_REASON = "reason";
    protected static final String KEY_TYPE = "transaction_type";
    public static final int TYPE_CONSUME_GEM = 1;
    public static final int TYPE_ISSUING_FREE_GEM = 3;
    public static final int TYPE_PURCHASE_CHARGE_GEM = 2;
    protected long mCharge;
    protected String mChargeExpirationDate;
    protected String mCurrency;
    protected String mDate;
    protected String mFormattedPrice;
    protected long mFree;
    protected String mFreeExpirationDate;
    protected JSONObject mJson;
    protected double mPrice;
    protected String mReason;
    protected int mType;

    /* JADX INFO: Access modifiers changed from: protected */
    public Transaction(JSONObject jSONObject) {
        this.mJson = jSONObject;
        this.mType = this.mJson.getInt(KEY_TYPE);
        this.mDate = this.mJson.getString(KEY_DATE);
        this.mReason = this.mJson.getString(KEY_REASON);
        this.mCharge = this.mJson.getLong(KEY_CHARGE);
        this.mFree = this.mJson.getLong(KEY_FREE);
        this.mPrice = this.mJson.optDouble("price");
        this.mFormattedPrice = this.mJson.optString("formatted_price");
        this.mChargeExpirationDate = this.mJson.optString(KEY_CHARGE_EXPIRATION);
        this.mFreeExpirationDate = this.mJson.optString(KEY_FREE_EXPIRATION);
    }

    public long getCharge() {
        return this.mCharge;
    }

    public String getChargeExpirationDate() {
        return this.mChargeExpirationDate;
    }

    public String getDate() {
        return this.mDate;
    }

    public String getFormattedPrice() {
        return this.mFormattedPrice;
    }

    public long getFree() {
        return this.mFree;
    }

    public String getFreeExpirationDate() {
        return this.mFreeExpirationDate;
    }

    public double getPrice() {
        return this.mPrice;
    }

    public String getReason() {
        return this.mReason;
    }

    public int getType() {
        return this.mType;
    }

    public String toString() {
        return this.mJson.toString();
    }
}
