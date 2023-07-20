package net.gree.gamelib.payment.shop.cocos2dx;

import net.gree.gamelib.payment.shop.Order;
import net.gree.gamelib.payment.shop.OrderListener;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class QueryOrderListener implements OrderListener {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccessNeedsCaution(String str, String str2);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryOrderListener.3
            @Override // java.lang.Runnable
            public void run() {
                QueryOrderListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.payment.shop.OrderListener
    public void onNeedCautionBeforePurchase(final Order order) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryOrderListener.2
            @Override // java.lang.Runnable
            public void run() {
                QueryOrderListener.this.nativeOnSuccessNeedsCaution(order.getPurchaseId(), order.getProductId());
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final Order order) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryOrderListener.1
            @Override // java.lang.Runnable
            public void run() {
                QueryOrderListener.this.nativeOnSuccess(order.getPurchaseId(), order.getProductId());
            }
        });
    }
}
