package net.gree.gamelib.payment.shop;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.b.b;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PurchaseAlert extends net.gree.gamelib.payment.internal.b.a {
    public static final String KEY_DISPLAY_ALERT = "display_alert";
    public static final String KEY_IS_PURCHASE_ALERT = "purchase_alert";
    public static final String KEY_PRICE = "price";
    public static final String KEY_THRESHOLD_AMOUNT = "threshold_amount";
    public static final String KEY_TOTAL_AMOUNT = "total_amount";
    private static final String a = "PurchaseAlert";
    protected boolean mDisplayAlert;
    protected JSONObject mEntry;
    protected double mPrice;
    protected boolean mPurchaseAlert;
    protected double mThresholdAmount;
    protected double mTotalAmount;

    /* loaded from: classes.dex */
    protected static class ResponseAdapter extends b<PurchaseAlert> {
        public ResponseAdapter(PaymentListener<PurchaseAlert> paymentListener) {
            super(PurchaseAlert.a, paymentListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // net.gree.gamelib.payment.internal.b.b
        /* renamed from: toPaymentResponse  reason: collision with other method in class */
        public PurchaseAlert mo54toPaymentResponse(String str) {
            return new PurchaseAlert(str);
        }
    }

    public PurchaseAlert(String str) {
        super(str);
        this.mEntry = getEntry();
        this.mTotalAmount = this.mEntry.getDouble(KEY_TOTAL_AMOUNT);
        this.mThresholdAmount = this.mEntry.getDouble("threshold_amount");
        this.mPrice = this.mEntry.getDouble("price");
        this.mPurchaseAlert = this.mEntry.getBoolean("purchase_alert");
        this.mDisplayAlert = this.mEntry.getBoolean(KEY_DISPLAY_ALERT);
    }

    public double getPrice() {
        return this.mPrice;
    }

    public double getThresholdAmount() {
        return this.mThresholdAmount;
    }

    public double getTotalAmount() {
        return this.mTotalAmount;
    }

    public boolean isDisplayAlert() {
        return this.mDisplayAlert;
    }

    public boolean isPurchaseAlert() {
        return this.mPurchaseAlert;
    }

    @Override // net.gree.gamelib.payment.internal.b.a
    public String toString() {
        return this.mEntry.toString();
    }
}
