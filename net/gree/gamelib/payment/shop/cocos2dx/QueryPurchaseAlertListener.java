package net.gree.gamelib.payment.shop.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.shop.PurchaseAlert;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class QueryPurchaseAlertListener implements PaymentListener<PurchaseAlert> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(double d, double d2, double d3, boolean z, boolean z2);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryPurchaseAlertListener.2
            @Override // java.lang.Runnable
            public void run() {
                QueryPurchaseAlertListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final PurchaseAlert purchaseAlert) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryPurchaseAlertListener.1
            @Override // java.lang.Runnable
            public void run() {
                QueryPurchaseAlertListener.this.nativeOnSuccess(purchaseAlert.getTotalAmount(), purchaseAlert.getThresholdAmount(), purchaseAlert.getPrice(), purchaseAlert.isPurchaseAlert(), purchaseAlert.isDisplayAlert());
            }
        });
    }
}
