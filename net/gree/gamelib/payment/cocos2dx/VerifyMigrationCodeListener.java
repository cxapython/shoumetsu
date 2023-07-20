package net.gree.gamelib.payment.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.depositbook.Balance;
import net.gree.gamelib.payment.migration.MigrationCodeVerifyResult;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class VerifyMigrationCodeListener implements PaymentListener<MigrationCodeVerifyResult> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(String str, String str2, String str3, long j, long j2, long j3);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.cocos2dx.VerifyMigrationCodeListener.2
            @Override // java.lang.Runnable
            public void run() {
                VerifyMigrationCodeListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final MigrationCodeVerifyResult migrationCodeVerifyResult) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.cocos2dx.VerifyMigrationCodeListener.1
            @Override // java.lang.Runnable
            public void run() {
                Balance balance = migrationCodeVerifyResult.getBalance();
                VerifyMigrationCodeListener.this.nativeOnSuccess(migrationCodeVerifyResult.getMigrationToken(), migrationCodeVerifyResult.getSourceUUID(), migrationCodeVerifyResult.getSourceXUID(), balance.getCharge(), balance.getFree(), balance.getTotalAmount());
            }
        });
    }
}
