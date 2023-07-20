package net.gree.gamelib.payment.internal;

import android.app.Activity;
import android.content.Intent;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.payment.PaymentError;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.shop.Order;
import net.gree.gamelib.payment.shop.OrderListener;
import net.gree.gamelib.payment.shop.Product;
import net.gree.gamelib.payment.shop.ProductList;
import net.gree.gamelib.payment.shop.PurchaseAlert;
import net.gree.gamelib.payment.shop.PurchaseAlertSetting;
import net.gree.gamelib.payment.shop.Shop;
import net.gree.gamelib.payment.shop.TicketList;

/* loaded from: classes.dex */
public class e extends Shop {
    private static final String a = "e";
    private static final e b = new e();

    private e() {
    }

    public static Shop a() {
        return b;
    }

    private void a(PaymentListener<?> paymentListener) {
        if (paymentListener != null) {
            paymentListener.onError(17220, PaymentError.ERROR_MESSAGE_PAYMENT_NOT_INITIALIZED);
        }
    }

    private void e() {
        GLog.e(a, PaymentError.ERROR_MESSAGE_PAYMENT_NOT_INITIALIZED);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void confirmPurchaseTransaction(PaymentListener<Boolean> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void disposePurchase() {
        e();
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void getPurchaseAlertSetting(PaymentListener<PurchaseAlertSetting> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public boolean handleActivityResult(int i, int i2, Intent intent) {
        e();
        return false;
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void queryOrder(Product product, OrderListener orderListener) {
        e();
        a(orderListener);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void queryProductList(PaymentListener<ProductList> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void queryPurchaseAlert(Product product, PaymentListener<PurchaseAlert> paymentListener, String str) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void queryTicketStatus(PaymentListener<TicketList> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void queryUnfinishedOrder(PaymentListener<Order> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void restorePurchaseTransaction(PaymentListener<Boolean> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void submit(Activity activity, Order order, PaymentListener<Void> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.shop.Shop
    public void updatePurchaseAlertSetting(boolean z, double d, PaymentListener<Void> paymentListener, String str) {
        e();
        a(paymentListener);
    }
}
