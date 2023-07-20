package net.gree.gamelib.payment.depositbook.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.depositbook.Balance;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class QueryBalanceListener implements PaymentListener<Balance> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(long j, long j2, long j3);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.depositbook.cocos2dx.QueryBalanceListener.2
            @Override // java.lang.Runnable
            public void run() {
                QueryBalanceListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final Balance balance) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.depositbook.cocos2dx.QueryBalanceListener.1
            @Override // java.lang.Runnable
            public void run() {
                QueryBalanceListener.this.nativeOnSuccess(balance.getCharge(), balance.getFree(), balance.getTotalAmount());
            }
        });
    }
}
