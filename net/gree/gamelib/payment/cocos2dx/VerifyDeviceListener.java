package net.gree.gamelib.payment.cocos2dx;

import net.gree.gamelib.core.DeviceVerifyResult;
import net.gree.gamelib.payment.PaymentListener;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class VerifyDeviceListener implements PaymentListener<DeviceVerifyResult> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(DeviceVerifyResult deviceVerifyResult);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.cocos2dx.VerifyDeviceListener.2
            @Override // java.lang.Runnable
            public void run() {
                VerifyDeviceListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final DeviceVerifyResult deviceVerifyResult) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.cocos2dx.VerifyDeviceListener.1
            @Override // java.lang.Runnable
            public void run() {
                VerifyDeviceListener.this.nativeOnSuccess(deviceVerifyResult);
            }
        });
    }
}
