package net.gree.gamelib.payment.internal;

import net.gree.gamelib.core.GLog;
import net.gree.gamelib.core.http.SignedRequest;
import net.gree.gamelib.payment.AgeVerification;
import net.gree.gamelib.payment.Payment;
import net.gree.gamelib.payment.PaymentError;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.Xuid;
import net.gree.gamelib.payment.migration.MigrationCodeVerifyResult;
import net.gree.gamelib.payment.migration.MigrationVerifyResult;

/* loaded from: classes.dex */
public class d extends Payment {
    private static final String a = "d";
    private static final d b = new d();
    private static final String c = "";

    private d() {
    }

    private void a(PaymentListener<?> paymentListener) {
        if (paymentListener != null) {
            paymentListener.onError(17220, PaymentError.ERROR_MESSAGE_PAYMENT_NOT_INITIALIZED);
        }
    }

    public static Payment d() {
        return b;
    }

    private void e() {
        GLog.e(a, PaymentError.ERROR_MESSAGE_PAYMENT_NOT_INITIALIZED);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void authorize(String str, PaymentListener<Void> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public String getAppId() {
        e();
        return "";
    }

    @Override // net.gree.gamelib.payment.Payment
    public SignedRequest getSignedRequest() {
        e();
        return new SignedRequest();
    }

    @Override // net.gree.gamelib.payment.Payment
    public String getStoreType() {
        e();
        return "";
    }

    @Override // net.gree.gamelib.payment.Payment
    public String getUuid() {
        e();
        return "";
    }

    @Override // net.gree.gamelib.payment.Payment
    public boolean isAuthorized() {
        e();
        return false;
    }

    @Override // net.gree.gamelib.payment.Payment
    public void queryXuid(int i, PaymentListener<Xuid> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void queryXuid(PaymentListener<Xuid> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void registerAge(boolean z, String str, PaymentListener<Void> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void registerMigrationPassword(String str, PaymentListener<Void> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void registerMigrationUserAccount(String str, String str2, PaymentListener<Void> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void registerXuid(String str, String str2, PaymentListener<Void> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void requestMigration(MigrationVerifyResult migrationVerifyResult, PaymentListener<Void> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void requestMigrationCode(int i, PaymentListener<String> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void resetAuthorization() {
        e();
    }

    @Override // net.gree.gamelib.payment.Payment
    public String sign(String str) {
        e();
        return "";
    }

    @Override // net.gree.gamelib.payment.Payment
    public void verifyAge(PaymentListener<AgeVerification> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void verifyMigrationCode(String str, String str2, PaymentListener<MigrationCodeVerifyResult> paymentListener) {
        e();
        a(paymentListener);
    }

    @Override // net.gree.gamelib.payment.Payment
    public void verifyMigrationUserAccount(String str, String str2, PaymentListener<MigrationVerifyResult> paymentListener) {
        e();
        a(paymentListener);
    }
}
