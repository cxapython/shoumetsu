package net.gree.gamelib.payment.cocos2dx;

import net.gree.gamelib.payment.AgeVerification;
import net.gree.gamelib.payment.PaymentListener;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class VerifyAgeListener implements PaymentListener<AgeVerification> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(int i, String str, double d);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.cocos2dx.VerifyAgeListener.2
            @Override // java.lang.Runnable
            public void run() {
                VerifyAgeListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final AgeVerification ageVerification) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.cocos2dx.VerifyAgeListener.1
            @Override // java.lang.Runnable
            public void run() {
                VerifyAgeListener.this.nativeOnSuccess(ageVerification.getAgeGroup(), ageVerification.getBirthday(), ageVerification.getLimit());
            }
        });
    }
}
