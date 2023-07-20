package net.gree.gamelib.payment.depositbook;

import net.gree.gamelib.payment.Payment;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.depositbook.Balance;
import net.gree.gamelib.payment.depositbook.RefundBalance;
import net.gree.gamelib.payment.depositbook.TransactionHistory;
import net.gree.gamelib.payment.internal.b.c;
import net.gree.gamelib.payment.internal.d;

/* loaded from: classes.dex */
public class DepositBook {
    private static final String a = "v1.0";
    private static final String b = "v1.0";
    private static final String c = "v1.0";
    private static DepositBook d;
    private Payment e;
    private c f;

    /* JADX INFO: Access modifiers changed from: protected */
    public DepositBook() {
    }

    protected DepositBook(Payment payment) {
        this.e = payment;
        Payment payment2 = this.e;
        if (payment2 != null) {
            this.f = new c(payment2.getParams());
        }
    }

    static void a() {
        d = null;
    }

    private void a(String str, PaymentListener<Balance> paymentListener) {
        this.e.getSignedRequest().request("GET", str, new Balance.ResponseAdapter(paymentListener));
    }

    public static synchronized DepositBook getInstance() {
        synchronized (DepositBook.class) {
            if (Payment.getInstance() instanceof d) {
                return net.gree.gamelib.payment.internal.c.b();
            }
            if (d == null) {
                d = new DepositBook(Payment.getInstance());
            }
            return d;
        }
    }

    public void queryBalance(int i, PaymentListener<Balance> paymentListener) {
        a(this.f.a("v1.0", i), paymentListener);
    }

    public void queryBalance(PaymentListener<Balance> paymentListener) {
        a(this.f.b("v1.0"), paymentListener);
    }

    public void queryHistory(int i, int i2, PaymentListener<TransactionHistory> paymentListener) {
        this.e.getSignedRequest().request("GET", this.f.b("v1.0", i, i2), new TransactionHistory.ResponseAdapter(paymentListener));
    }

    public void queryRefundBalance(PaymentListener<RefundBalance> paymentListener) {
        this.e.getSignedRequest().request("GET", this.f.m("v1.0"), new RefundBalance.ResponseAdapter(paymentListener));
    }
}
