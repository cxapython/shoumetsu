package net.gree.gamelib.payment.depositbook;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.b.a;
import net.gree.gamelib.payment.internal.b.b;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RefundBalance extends a {
    protected static final String KEY_CHARGE = "balance_charge_gem";
    protected static final String KEY_FREE = "balance_free_gem";
    protected static final String KEY_PAYBACK_CODE = "payback_code";
    protected static final String KEY_TOTAL = "balance_total_gem";
    private static final String a = "RefundBalance";
    protected long mCharge;
    protected JSONObject mEntry;
    protected long mFree;
    protected String mPaybackCode;
    protected long mTotal;

    /* loaded from: classes.dex */
    protected static class ResponseAdapter extends b<RefundBalance> {
        public ResponseAdapter(PaymentListener<RefundBalance> paymentListener) {
            super(RefundBalance.a, paymentListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.gree.gamelib.payment.internal.b.b
        /* renamed from: toPaymentResponse */
        public RefundBalance mo54toPaymentResponse(String str) {
            return new RefundBalance(str);
        }
    }

    protected RefundBalance(String str) {
        super(str);
        this.mEntry = getEntry();
        this.mCharge = this.mEntry.getLong(KEY_CHARGE);
        this.mFree = this.mEntry.getLong(KEY_FREE);
        this.mTotal = this.mEntry.getLong(KEY_TOTAL);
        this.mPaybackCode = this.mEntry.getString(KEY_PAYBACK_CODE);
    }

    public long getCharge() {
        return this.mCharge;
    }

    public long getFree() {
        return this.mFree;
    }

    public String getPaybackCode() {
        return this.mPaybackCode;
    }

    public long getTotalAmount() {
        return this.mTotal;
    }
}
