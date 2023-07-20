package net.gree.gamelib.payment.shop;

import net.gree.gamelib.payment.Payment;

/* loaded from: classes.dex */
class a {
    a() {
    }

    public static Shop a() {
        return new Shop(Payment.getInstance());
    }
}
