package net.gree.gamelib.payment.internal.shop;

/* loaded from: classes.dex */
public class PurchaseSettings {
    public static boolean sForceFailPurchaseCommit = false;
    public static boolean sIgnoreBillingSupported = false;
    public static boolean sPrioritizeGameLibProductList = false;
    public static boolean sSkipConsumePurchase = false;

    protected PurchaseSettings() {
    }

    public static void init() {
        sIgnoreBillingSupported = false;
        sForceFailPurchaseCommit = false;
        sSkipConsumePurchase = false;
        sPrioritizeGameLibProductList = false;
    }
}
