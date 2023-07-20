package net.gree.gamelib.payment.shop;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.b.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Order extends net.gree.gamelib.payment.internal.b.a {
    protected static final String KEY_ID = "purchase_id";
    protected static final String KEY_NEED_CAUTION = "need_caution_for_minors";
    protected static final String KEY_PRODUCT_ID = "product_id";
    protected static final String KEY_RECEIPT = "receipt";
    protected static final String KEY_SIGNATURE = "signature";
    private static final String a = "Order";
    protected JSONObject mEntry;
    protected boolean mNeedCaution;
    protected String mProductId;
    protected String mPurchaseId;
    protected String mReceipt;
    protected String mSignature;

    /* loaded from: classes.dex */
    protected static class ResponseAdapter extends b<Order> {
        public ResponseAdapter(final OrderListener orderListener) {
            super(Order.a, new PaymentListener<Order>() { // from class: net.gree.gamelib.payment.shop.Order.ResponseAdapter.1
                @Override // net.gree.gamelib.core.CallbackListener
                /* renamed from: a */
                public void onSuccess(Order order) {
                    if (OrderListener.this != null) {
                        if (order.mNeedCaution) {
                            OrderListener.this.onNeedCautionBeforePurchase(order);
                        } else {
                            OrderListener.this.onSuccess(order);
                        }
                    }
                }

                @Override // net.gree.gamelib.core.CallbackListener
                public void onError(int i, String str) {
                    OrderListener orderListener2 = OrderListener.this;
                    if (orderListener2 != null) {
                        orderListener2.onError(i, str);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // net.gree.gamelib.payment.internal.b.b
        /* renamed from: toPaymentResponse  reason: collision with other method in class */
        public Order mo54toPaymentResponse(String str) {
            return new Order(str);
        }
    }

    public Order(String str) {
        super(str);
        this.mEntry = getEntry();
        this.mPurchaseId = this.mEntry.getString(KEY_ID);
        this.mNeedCaution = this.mEntry.getBoolean(KEY_NEED_CAUTION);
        this.mProductId = this.mJson.optString("product_id");
        this.mReceipt = this.mJson.optString("receipt");
        this.mSignature = this.mJson.optString(KEY_SIGNATURE);
    }

    public Order(String str, String str2, boolean z) {
        this(toResponseJson(str, str2, z));
    }

    protected static String toResponseJson(String str, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(net.gree.gamelib.core.a.b.b.c, net.gree.gamelib.core.a.b.b.d);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(KEY_ID, str);
        jSONObject2.put(KEY_NEED_CAUTION, z);
        jSONObject.put("entry", jSONObject2);
        jSONObject.put("product_id", str2);
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        try {
            this.mJson.put("product_id", str);
        } catch (JSONException unused) {
        }
        this.mProductId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        try {
            this.mJson.put("receipt", str);
        } catch (JSONException unused) {
        }
        this.mReceipt = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        try {
            this.mJson.put(KEY_SIGNATURE, str);
        } catch (JSONException unused) {
        }
        this.mSignature = str;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getPurchaseId() {
        return this.mPurchaseId;
    }

    public String getReceipt() {
        return this.mReceipt;
    }

    public String getSignature() {
        return this.mSignature;
    }
}
