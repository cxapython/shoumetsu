package net.gree.gamelib.payment.login;

import android.text.TextUtils;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.payment.Payment;
import net.gree.gamelib.payment.PaymentError;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.Xuid;
import net.gree.gamelib.payment.migration.MigrationCodeVerifyResult;
import net.gree.gamelib.payment.migration.MigrationVerifyResult;
import org.json.JSONException;

/* loaded from: classes.dex */
public class LoginHelper {
    private static final String a = "LoginHelper";
    private static int b = 3;
    private static boolean c = false;
    private static int[] d = {4, 14, 15, 17, 18, 20, 3000, 8012, PaymentError.ERROR_CODE_LOGIN_LOCAL_AUTH_NOT_FOUND_ERROR};
    private static int[] e = {7002, 7003, 7004, PaymentError.ERROR_CODE_VERIFY_3RD_PARTY_ACCOUNT_NOT_REGISTERED_USER_ACCOUNT, 3000};

    public static void authorize(final LoginListener<Xuid> loginListener) {
        Payment payment = Payment.getInstance();
        if (!c(loginListener)) {
            return;
        }
        PaymentListener<Void> paymentListener = new PaymentListener<Void>() { // from class: net.gree.gamelib.payment.login.LoginHelper.2
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r1) {
                LoginHelper.b(LoginListener.this);
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str) {
                LoginHelper.c();
                String str2 = LoginHelper.a;
                GLog.i(str2, "Login authorize error code:" + i);
                LoginListener loginListener2 = LoginListener.this;
                if (loginListener2 != null) {
                    loginListener2.onError(i, str);
                }
            }
        };
        if (payment.isDeviceChanged()) {
            GLog.i(a, "Login updateUserToken");
            payment.updateUserToken(paymentListener);
        } else if (!TextUtils.isEmpty(payment.getUuid())) {
            GLog.i(a, "Login authorize");
            payment.authorize(paymentListener);
        } else {
            c();
            GLog.i(a, "Login user auth info not found");
            if (loginListener == null) {
                return;
            }
            loginListener.onError(PaymentError.ERROR_CODE_LOGIN_LOCAL_AUTH_NOT_FOUND_ERROR, PaymentError.ERROR_MESSAGE_LOGIN_LOCAL_AUTH_NOT_FOUND_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final LoginListener<Xuid> loginListener) {
        Payment.getInstance().queryXuid(b, new PaymentListener<Xuid>() { // from class: net.gree.gamelib.payment.login.LoginHelper.1
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Xuid xuid) {
                LoginHelper.c();
                LoginListener loginListener2 = LoginListener.this;
                if (loginListener2 != null) {
                    loginListener2.onSuccess(xuid);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str) {
                LoginHelper.c();
                LoginListener loginListener2 = LoginListener.this;
                if (loginListener2 != null) {
                    loginListener2.onError(i, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        c = false;
    }

    private static boolean c(LoginListener<?> loginListener) {
        if (!c) {
            c = true;
            return true;
        } else if (loginListener == null) {
            return false;
        } else {
            loginListener.onError(17219, "The process is already in progress");
            return false;
        }
    }

    public static boolean isAuthError(int i) {
        for (int i2 : d) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLoginError(int i) {
        for (int i2 : e) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static void login(int i, String str, String str2, final LoginListener<Xuid> loginListener) {
        verifyLogin3rdPartyUserAccount(i, str, str2, new LoginListener<LoginVerifyResult>() { // from class: net.gree.gamelib.payment.login.LoginHelper.8
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(LoginVerifyResult loginVerifyResult) {
                LoginHelper.login(loginVerifyResult, LoginListener.this);
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str3) {
                LoginListener loginListener2 = LoginListener.this;
                if (loginListener2 != null) {
                    loginListener2.onError(i2, str3);
                }
            }
        });
    }

    public static void login(String str, String str2, final LoginListener<Xuid> loginListener) {
        verifyLoginUserAccount(str, str2, new LoginListener<LoginVerifyResult>() { // from class: net.gree.gamelib.payment.login.LoginHelper.7
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(LoginVerifyResult loginVerifyResult) {
                LoginHelper.login(loginVerifyResult, LoginListener.this);
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str3) {
                LoginListener loginListener2 = LoginListener.this;
                if (loginListener2 != null) {
                    loginListener2.onError(i, str3);
                }
            }
        });
    }

    public static void login(LoginVerifyResult loginVerifyResult, final LoginListener<Xuid> loginListener) {
        if (!c(loginListener)) {
            return;
        }
        Payment.getInstance().requestMigration(loginVerifyResult, new PaymentListener<Void>() { // from class: net.gree.gamelib.payment.login.LoginHelper.6
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r1) {
                LoginHelper.b(LoginListener.this);
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str) {
                LoginHelper.c();
                String str2 = LoginHelper.a;
                GLog.i(str2, "Login login with verify result error code:" + i);
                LoginListener loginListener2 = LoginListener.this;
                if (loginListener2 != null) {
                    loginListener2.onError(i, str);
                }
            }
        });
    }

    public static void logout() {
        Payment.getInstance().resetAuthorization();
    }

    public static void registerLogin3rdPartyUserAccount(int i, String str, String str2, LoginListener<Void> loginListener) {
        Payment.getInstance().register3rdPartyUserAccount(i, str, str2, loginListener);
    }

    public static void registerLoginPassword(String str, LoginListener<Void> loginListener) {
        Payment.getInstance().registerMigrationPassword(str, loginListener);
    }

    public static void requestLoginId(LoginListener<String> loginListener) {
        Payment.getInstance().requestMigrationCode(0, loginListener);
    }

    public static void setQueryXuidRetryCount(int i) {
        b = i;
    }

    public static void signup(String str, final LoginListener<Xuid> loginListener) {
        Payment payment = Payment.getInstance();
        if (!c(loginListener)) {
            return;
        }
        payment.resetAuthorization();
        payment.authorize(str, new PaymentListener<Void>() { // from class: net.gree.gamelib.payment.login.LoginHelper.3
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r1) {
                LoginHelper.b(LoginListener.this);
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str2) {
                LoginHelper.c();
                String str3 = LoginHelper.a;
                GLog.i(str3, "Login signup error code:" + i);
                LoginListener loginListener2 = LoginListener.this;
                if (loginListener2 != null) {
                    loginListener2.onError(i, str2);
                }
            }
        });
    }

    public static void verifyLogin3rdPartyUserAccount(int i, String str, String str2, final LoginListener<LoginVerifyResult> loginListener) {
        Payment payment = Payment.getInstance();
        if (!c(loginListener)) {
            return;
        }
        payment.resetAuthorization();
        payment.verify3rdPartyUserAccount(i, str, str2, new PaymentListener<MigrationVerifyResult>() { // from class: net.gree.gamelib.payment.login.LoginHelper.5
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(MigrationVerifyResult migrationVerifyResult) {
                LoginHelper.c();
                if (LoginListener.this != null) {
                    try {
                        LoginListener.this.onSuccess(new LoginVerifyResult(migrationVerifyResult.toString()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str3) {
                LoginHelper.c();
                String str4 = LoginHelper.a;
                GLog.i(str4, "Login verify3rdPartyUserAccount error code:" + i2);
                LoginListener loginListener2 = LoginListener.this;
                if (loginListener2 != null) {
                    loginListener2.onError(i2, str3);
                }
            }
        });
    }

    public static void verifyLoginUserAccount(String str, String str2, final LoginListener<LoginVerifyResult> loginListener) {
        Payment payment = Payment.getInstance();
        if (!c(loginListener)) {
            return;
        }
        payment.resetAuthorization();
        payment.verifyMigrationCode(str, str2, new PaymentListener<MigrationCodeVerifyResult>() { // from class: net.gree.gamelib.payment.login.LoginHelper.4
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(MigrationCodeVerifyResult migrationCodeVerifyResult) {
                LoginHelper.c();
                if (LoginListener.this != null) {
                    try {
                        LoginListener.this.onSuccess(new LoginVerifyResult(migrationCodeVerifyResult.toString()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str3) {
                LoginHelper.c();
                String str4 = LoginHelper.a;
                GLog.i(str4, "Login verifyLoginPassword error code:" + i);
                LoginListener loginListener2 = LoginListener.this;
                if (loginListener2 != null) {
                    loginListener2.onError(i, str3);
                }
            }
        });
    }
}
