package net.gree.gamelib.payment.depositbook;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.b.a;
import net.gree.gamelib.payment.internal.b.b;
import net.gree.gamelib.payment.internal.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TransactionHistory extends a implements f {
    protected static final String KEY_TRANSACTIONS = "transactions";
    private static final String d = "TransactionHistory";
    protected boolean mHasNext;
    protected int mLimit;
    protected int mOffset;
    protected Transaction[] mTransactions;

    /* loaded from: classes.dex */
    protected static class ResponseAdapter extends b<TransactionHistory> {
        public ResponseAdapter(PaymentListener<TransactionHistory> paymentListener) {
            super(TransactionHistory.d, paymentListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.gree.gamelib.payment.internal.b.b
        /* renamed from: toPaymentResponse */
        public TransactionHistory mo54toPaymentResponse(String str) {
            return new TransactionHistory(str);
        }
    }

    protected TransactionHistory(String str) {
        super(str);
        JSONObject entry = getEntry();
        this.mOffset = entry.getInt(f.a);
        this.mLimit = entry.getInt(f.b);
        this.mHasNext = entry.getBoolean(f.c);
        JSONArray jSONArray = entry.getJSONArray(KEY_TRANSACTIONS);
        int length = jSONArray.length();
        this.mTransactions = new Transaction[length];
        for (int i = 0; i < length; i++) {
            this.mTransactions[i] = new Transaction(jSONArray.getJSONObject(i));
        }
    }

    @Override // net.gree.gamelib.payment.internal.f
    public int getLimit() {
        return this.mLimit;
    }

    @Override // net.gree.gamelib.payment.internal.f
    public int getOffset() {
        return this.mOffset;
    }

    public Transaction[] getTransactions() {
        return this.mTransactions;
    }

    @Override // net.gree.gamelib.payment.internal.f
    public boolean hasNext() {
        return this.mHasNext;
    }
}
