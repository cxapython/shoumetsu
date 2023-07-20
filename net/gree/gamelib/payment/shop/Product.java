package net.gree.gamelib.payment.shop;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class Product {
    public static final int CAMPAIGN_TYPE_APPLYING_CAMPAIGN = 1;
    public static final int CAMPAIGN_TYPE_CAMPAIGN_ONLY = 2;
    public static final int CAMPAIGN_TYPE_NOT_CAMPAIGN = 0;
    public static final String KEY_AMENITY_LABEL = "amenity_label";
    public static final String KEY_BONUS = "bonus_gem";
    public static final String KEY_CAMPAIGN_MODE = "campaign_mode";
    public static final String KEY_CAMPAIGN_TYPE = "campaign_type";
    public static final String KEY_CHARGE = "charge_gem";
    public static final String KEY_CONSUMABLE = "consumable";
    public static final String KEY_COUNTRY_CODE = "country_code";
    public static final String KEY_CURRENCY_CODE = "currency_code";
    public static final String KEY_DEFAULT_PRICE = "default_price";
    public static final String KEY_DEFAULT_PRODUCT_ID = "default_product_id";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_END_DATETIME = "end_datetime";
    public static final String KEY_FORMATTED_PRICE = "formatted_price";
    public static final String KEY_FREE = "free_gem";
    public static final String KEY_ID = "product_id";
    public static final String KEY_INCREASE_GEM = "increase_gem";
    public static final String KEY_LIMITED_COUNT = "limited_count";
    public static final String KEY_LIMITED_DATETIME = "limited_datetime";
    public static final String KEY_NAME = "name";
    public static final String KEY_PRICE = "price";
    public static final String KEY_PRIORITY = "priority";
    public static final String KEY_PRODUCT_TYPE = "product_type";
    public static final String KEY_START_DATETIME = "start_datetime";
    public static final String KEY_THUMBNAIL = "thumbnail_url";
    public static final String KEY_TICKET_ISSUING_GEM = "ticket_issuing_gem";
    public static final String KEY_TICKET_VALID_DAYS = "ticket_valid_days";
    public static final String KEY_TOTAL = "total_gem";
    public static final int PRODUCT_TYPE_GEM = 0;
    public static final int PRODUCT_TYPE_TICKET = 1;
    protected String mAmenityLabel;
    protected long mBonus;
    protected int mCampaignMode;
    protected int mCampaignType;
    protected long mCharge;
    protected int mConsumable;
    protected String mCountryCode;
    protected String mCurrencyCode;
    protected String mDefaultId;
    protected double mDefaultPrice;
    protected String mDescription;
    protected String mEndDatetime;
    protected String mFormattedPrice;
    protected long mFree;
    protected String mId;
    protected long mIncreaseGem;
    protected JSONObject mJson;
    protected int mLimitedCount;
    protected String mLimitedDatetime;
    protected String mName;
    protected double mPrice;
    protected String mPriceString;
    protected int mPriority;
    protected int mProductType;
    protected String mStartDatetime;
    protected String mThumbnailUrl;
    protected int mTicketIssuingGem;
    protected int mTicketValidDays;
    protected long mTotal;

    public Product(JSONObject jSONObject) {
        this.mJson = jSONObject;
        this.mId = this.mJson.getString(KEY_ID);
        this.mName = this.mJson.getString(KEY_NAME);
        this.mPrice = this.mJson.getDouble("price");
        this.mPriceString = this.mJson.getString("price");
        this.mDescription = this.mJson.getString("description");
        this.mThumbnailUrl = this.mJson.getString(KEY_THUMBNAIL);
        this.mCharge = this.mJson.getLong(KEY_CHARGE);
        this.mFree = this.mJson.getLong(KEY_FREE);
        this.mBonus = this.mJson.getLong(KEY_BONUS);
        this.mTotal = this.mJson.getLong(KEY_TOTAL);
        this.mCampaignType = this.mJson.getInt(KEY_CAMPAIGN_TYPE);
        this.mDefaultId = this.mJson.optString(KEY_DEFAULT_PRODUCT_ID);
        this.mDefaultPrice = this.mJson.optDouble(KEY_DEFAULT_PRICE, 0.0d);
        this.mIncreaseGem = this.mJson.getInt(KEY_INCREASE_GEM);
        this.mCampaignMode = this.mJson.getInt(KEY_CAMPAIGN_MODE);
        this.mPriority = this.mJson.getInt(KEY_PRIORITY);
        this.mConsumable = this.mJson.getInt(KEY_CONSUMABLE);
        this.mStartDatetime = this.mJson.optString(KEY_START_DATETIME);
        this.mEndDatetime = this.mJson.optString(KEY_END_DATETIME);
        this.mFormattedPrice = this.mJson.optString(KEY_FORMATTED_PRICE);
        this.mCurrencyCode = this.mJson.optString(KEY_CURRENCY_CODE);
        this.mCountryCode = this.mJson.optString(KEY_COUNTRY_CODE);
        this.mLimitedDatetime = this.mJson.optString(KEY_LIMITED_DATETIME);
        this.mLimitedCount = this.mJson.optInt(KEY_LIMITED_COUNT);
        this.mProductType = this.mJson.optInt(KEY_PRODUCT_TYPE);
        this.mTicketIssuingGem = this.mJson.optInt(KEY_TICKET_ISSUING_GEM);
        this.mTicketValidDays = this.mJson.optInt(KEY_TICKET_VALID_DAYS);
        this.mAmenityLabel = this.mJson.optString("amenity_label");
    }

    public String getAmenityLabel() {
        return this.mAmenityLabel;
    }

    public long getBonus() {
        return this.mBonus;
    }

    public int getCampaignMode() {
        return this.mCampaignMode;
    }

    public int getCampaignType() {
        return this.mCampaignType;
    }

    public long getCharge() {
        return this.mCharge;
    }

    public int getConsumable() {
        return this.mConsumable;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public String getCurrencyCode() {
        return this.mCurrencyCode;
    }

    public String getDefaultId() {
        return this.mDefaultId;
    }

    public double getDefaultPrice() {
        return this.mDefaultPrice;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getEndDatetime() {
        return this.mEndDatetime;
    }

    public String getFormattedPrice() {
        return this.mFormattedPrice;
    }

    public long getFree() {
        return this.mFree;
    }

    public String getId() {
        return this.mId;
    }

    public long getIncreaseGem() {
        return this.mIncreaseGem;
    }

    public JSONObject getJson() {
        return this.mJson;
    }

    public int getLimitedCount() {
        return this.mLimitedCount;
    }

    public String getLimitedDatetime() {
        return this.mLimitedDatetime;
    }

    public String getName() {
        return this.mName;
    }

    public double getPrice() {
        return this.mPrice;
    }

    public String getPriceString() {
        return this.mPriceString;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getProductType() {
        return this.mProductType;
    }

    public String getStartDatetime() {
        return this.mStartDatetime;
    }

    public String getThumbnailUrl() {
        return this.mThumbnailUrl;
    }

    public int getTicketIssuingGem() {
        return this.mTicketIssuingGem;
    }

    public int getTicketValidDays() {
        return this.mTicketValidDays;
    }

    public long getTotalAmount() {
        return this.mTotal;
    }

    public String toString() {
        return this.mJson.toString();
    }

    public void writeStoreProductData(JSONObject jSONObject) {
        if (jSONObject.has(KEY_NAME)) {
            this.mName = jSONObject.getString(KEY_NAME);
            this.mJson.put(KEY_NAME, this.mName);
        }
        if (jSONObject.has("price")) {
            this.mPrice = Double.parseDouble(jSONObject.getString("price"));
            this.mJson.put("price", this.mPrice);
            this.mPriceString = jSONObject.getString("price");
        }
        if (jSONObject.has(KEY_FORMATTED_PRICE)) {
            this.mFormattedPrice = jSONObject.getString(KEY_FORMATTED_PRICE);
            this.mJson.put(KEY_FORMATTED_PRICE, this.mFormattedPrice);
        }
        if (jSONObject.has(KEY_CURRENCY_CODE)) {
            this.mCurrencyCode = jSONObject.getString(KEY_CURRENCY_CODE);
            this.mJson.put(KEY_CURRENCY_CODE, this.mCurrencyCode);
        }
        if (jSONObject.has(KEY_COUNTRY_CODE)) {
            this.mCountryCode = jSONObject.getString(KEY_COUNTRY_CODE);
            this.mJson.put(KEY_COUNTRY_CODE, this.mCountryCode);
        }
        if (jSONObject.has("description")) {
            this.mDescription = jSONObject.getString("description");
            this.mJson.put("description", this.mDescription);
        }
    }
}
