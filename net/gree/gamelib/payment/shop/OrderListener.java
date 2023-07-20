package net.gree.gamelib.payment.shop;

import net.gree.gamelib.payment.PaymentListener;

/* loaded from: classes.dex */
public interface OrderListener extends PaymentListener<Order> {
    void onNeedCautionBeforePurchase(Order order);
}
