package net.gree.gamelib.payment.depositbook.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.depositbook.RefundBalance;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class QueryRefundBalanceListener implements PaymentListener<RefundBalance> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(long j, long j2, long j3, String str);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.depositbook.cocos2dx.QueryRefundBalanceListener.2
            @Override // java.lang.Runnable
            public void run() {
                QueryRefundBalanceListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final RefundBalance refundBalance) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.depositbook.cocos2dx.QueryRefundBalanceListener.1
            @Override // java.lang.Runnable
            public void run() {
                QueryRefundBalanceListener.this.nativeOnSuccess(refundBalance.getCharge(), refundBalance.getFree(), refundBalance.getTotalAmount(), refundBalance.getPaybackCode());
            }
        });
    }
}
