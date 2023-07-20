package net.gree.gamelib.payment.depositbook.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.depositbook.Transaction;
import net.gree.gamelib.payment.depositbook.TransactionHistory;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class QueryHistoryListener implements PaymentListener<TransactionHistory> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(Transaction[] transactionArr, boolean z, int i, int i2);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.depositbook.cocos2dx.QueryHistoryListener.2
            @Override // java.lang.Runnable
            public void run() {
                QueryHistoryListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final TransactionHistory transactionHistory) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.depositbook.cocos2dx.QueryHistoryListener.1
            @Override // java.lang.Runnable
            public void run() {
                QueryHistoryListener.this.nativeOnSuccess(transactionHistory.getTransactions(), transactionHistory.hasNext(), transactionHistory.getOffset(), transactionHistory.getLimit());
            }
        });
    }
}
