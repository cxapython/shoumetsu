package net.gree.gamelib.payment.shop;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.b.b;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PurchaseAlertSetting extends net.gree.gamelib.payment.internal.b.a {
    public static final String KEY_IS_PURCHASE_ALERT = "purchase_alert";
    public static final String KEY_THRESHOLD_AMOUNT = "threshold_amount";
    private static final String a = "PurchaseAlertSetting";
    protected JSONObject mEntry;
    protected boolean mPurchaseAlert;
    protected double mThresholdAmount;

    /* loaded from: classes.dex */
    protected static class ResponseAdapter extends b<PurchaseAlertSetting> {
        public ResponseAdapter(PaymentListener<PurchaseAlertSetting> paymentListener) {
            super(PurchaseAlertSetting.a, paymentListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // net.gree.gamelib.payment.internal.b.b
        /* renamed from: toPaymentResponse  reason: collision with other method in class */
        public PurchaseAlertSetting mo54toPaymentResponse(String str) {
            return new PurchaseAlertSetting(str);
        }
    }

    public PurchaseAlertSetting(String str) {
        super(str);
        this.mEntry = getEntry();
        this.mThresholdAmount = this.mEntry.getDouble("threshold_amount");
        this.mPurchaseAlert = this.mEntry.getBoolean("purchase_alert");
    }

    public double getThresholdAmount() {
        return this.mThresholdAmount;
    }

    public boolean isPurchaseAlert() {
        return this.mPurchaseAlert;
    }

    @Override // net.gree.gamelib.payment.internal.b.a
    public String toString() {
        return this.mEntry.toString();
    }
}
