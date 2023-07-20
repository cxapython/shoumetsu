package net.gree.gamelib.payment.shop.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.shop.PurchaseAlertSetting;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class GetPurchaseAlertSettingListener implements PaymentListener<PurchaseAlertSetting> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(boolean z, double d);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.GetPurchaseAlertSettingListener.2
            @Override // java.lang.Runnable
            public void run() {
                GetPurchaseAlertSettingListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final PurchaseAlertSetting purchaseAlertSetting) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.GetPurchaseAlertSettingListener.1
            @Override // java.lang.Runnable
            public void run() {
                GetPurchaseAlertSettingListener.this.nativeOnSuccess(purchaseAlertSetting.isPurchaseAlert(), purchaseAlertSetting.getThresholdAmount());
            }
        });
    }
}
