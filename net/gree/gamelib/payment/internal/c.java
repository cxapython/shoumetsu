package net.gree.gamelib.payment.internal;

import net.gree.gamelib.core.GLog;
import net.gree.gamelib.payment.PaymentError;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.depositbook.Balance;
import net.gree.gamelib.payment.depositbook.DepositBook;
import net.gree.gamelib.payment.depositbook.TransactionHistory;

/* loaded from: classes.dex */
public class c extends DepositBook {
    private static final String a = "c";
    private static final c b = new c();

    private c() {
    }

    private void a(PaymentListener<?> paymentListener) {
        if (paymentListener != null) {
            paymentListener.onError(17220, PaymentError.ERROR_MESSAGE_PAYMENT_NOT_INITIALIZED);
        }
    }

    public static DepositBook b() {
        return b;
    }

    private void c() {
        GLog.e(a, PaymentError.ERROR_MESSAGE_PAYMENT_NOT_INITIALIZED);
    }

    @Override // net.gree.gamelib.payment.depositbook.DepositBook
    public void queryBalance(int i, PaymentListener<Balance> paymentListener) {
        c();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.depositbook.DepositBook
    public void queryBalance(PaymentListener<Balance> paymentListener) {
        c();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.depositbook.DepositBook
    public void queryHistory(int i, int i2, PaymentListener<TransactionHistory> paymentListener) {
        c();
        a(paymentListener);
    }
}
