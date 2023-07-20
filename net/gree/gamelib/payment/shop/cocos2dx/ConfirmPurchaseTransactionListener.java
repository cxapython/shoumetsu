package net.gree.gamelib.payment.shop.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class ConfirmPurchaseTransactionListener implements PaymentListener<Boolean> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(boolean z);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.ConfirmPurchaseTransactionListener.2
            @Override // java.lang.Runnable
            public void run() {
                ConfirmPurchaseTransactionListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final Boolean bool) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.ConfirmPurchaseTransactionListener.1
            @Override // java.lang.Runnable
            public void run() {
                ConfirmPurchaseTransactionListener.this.nativeOnSuccess(bool.booleanValue());
            }
        });
    }
}
