package net.gree.gamelib.payment.shop.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.shop.Order;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class QueryUnfinishedOrderListener implements PaymentListener<Order> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(String str, String str2, String str3, String str4);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryUnfinishedOrderListener.2
            @Override // java.lang.Runnable
            public void run() {
                QueryUnfinishedOrderListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final Order order) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryUnfinishedOrderListener.1
            @Override // java.lang.Runnable
            public void run() {
                QueryUnfinishedOrderListener.this.nativeOnSuccess(order.getPurchaseId(), order.getProductId(), order.getReceipt(), order.getSignature());
            }
        });
    }
}
