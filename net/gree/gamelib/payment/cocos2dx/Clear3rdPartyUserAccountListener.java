package net.gree.gamelib.payment.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class Clear3rdPartyUserAccountListener implements PaymentListener<String> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(String str);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.cocos2dx.Clear3rdPartyUserAccountListener.2
            @Override // java.lang.Runnable
            public void run() {
                Clear3rdPartyUserAccountListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.cocos2dx.Clear3rdPartyUserAccountListener.1
            @Override // java.lang.Runnable
            public void run() {
                Clear3rdPartyUserAccountListener.this.nativeOnSuccess(str);
            }
        });
    }
}
