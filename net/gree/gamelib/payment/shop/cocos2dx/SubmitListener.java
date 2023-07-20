package net.gree.gamelib.payment.shop.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class SubmitListener implements PaymentListener<Void> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess();

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.SubmitListener.2
            @Override // java.lang.Runnable
            public void run() {
                SubmitListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(Void r1) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.SubmitListener.1
            @Override // java.lang.Runnable
            public void run() {
                SubmitListener.this.nativeOnSuccess();
            }
        });
    }
}
