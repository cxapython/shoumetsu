package net.gree.gamelib.payment.depositbook;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.b.a;
import net.gree.gamelib.payment.internal.b.b;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Balance extends a {
    protected static final String KEY_CHARGE = "balance_charge_gem";
    protected static final String KEY_FREE = "balance_free_gem";
    protected static final String KEY_TOTAL = "balance_total_gem";
    private static final String a = "Balance";
    protected long mCharge;
    protected JSONObject mEntry;
    protected long mFree;
    protected long mTotal;

    /* loaded from: classes.dex */
    protected static class ResponseAdapter extends b<Balance> {
        public ResponseAdapter(PaymentListener<Balance> paymentListener) {
            super(Balance.a, paymentListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.gree.gamelib.payment.internal.b.b
        /* renamed from: toPaymentResponse */
        public Balance mo54toPaymentResponse(String str) {
            return new Balance(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Balance(String str) {
        super(str);
        this.mEntry = getEntry();
        this.mCharge = this.mEntry.getLong(KEY_CHARGE);
        this.mFree = this.mEntry.getLong(KEY_FREE);
        this.mTotal = this.mEntry.getLong(KEY_TOTAL);
    }

    public long getCharge() {
        return this.mCharge;
    }

    public long getFree() {
        return this.mFree;
    }

    public long getTotalAmount() {
        return this.mTotal;
    }
}
