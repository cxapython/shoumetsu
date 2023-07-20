package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

/* loaded from: classes.dex */
public class Storage {
    private static final Lock a = new ReentrantLock();
    @GuardedBy("sLk")
    private static Storage b;
    private final Lock c = new ReentrantLock();
    @GuardedBy("mLk")
    private final SharedPreferences d;

    @VisibleForTesting
    private Storage(Context context) {
        this.d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @VisibleForTesting
    @Nullable
    private final GoogleSignInAccount a(String str) {
        String c;
        if (!TextUtils.isEmpty(str) && (c = c(b("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.zaa(c);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final void a(String str, String str2) {
        this.c.lock();
        try {
            this.d.edit().putString(str, str2).apply();
        } finally {
            this.c.unlock();
        }
    }

    @VisibleForTesting
    @Nullable
    private final GoogleSignInOptions b(String str) {
        String c;
        if (!TextUtils.isEmpty(str) && (c = c(b("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.zab(c);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    @Nullable
    private final String c(String str) {
        this.c.lock();
        try {
            return this.d.getString(str, null);
        } finally {
            this.c.unlock();
        }
    }

    private final void d(String str) {
        this.c.lock();
        try {
            this.d.edit().remove(str).apply();
        } finally {
            this.c.unlock();
        }
    }

    @KeepForSdk
    public static Storage getInstance(Context context) {
        Preconditions.checkNotNull(context);
        a.lock();
        try {
            if (b == null) {
                b = new Storage(context.getApplicationContext());
            }
            return b;
        } finally {
            a.unlock();
        }
    }

    @KeepForSdk
    public void clear() {
        this.c.lock();
        try {
            this.d.edit().clear().apply();
        } finally {
            this.c.unlock();
        }
    }

    @KeepForSdk
    @Nullable
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        return a(c("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    @Nullable
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        return b(c("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    @Nullable
    public String getSavedRefreshToken() {
        return c("refreshToken");
    }

    @KeepForSdk
    public void saveDefaultGoogleSignInAccount(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        a("defaultGoogleSignInAccount", googleSignInAccount.zab());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String zab = googleSignInAccount.zab();
        a(b("googleSignInAccount", zab), googleSignInAccount.zac());
        a(b("googleSignInOptions", zab), googleSignInOptions.zae());
    }

    public final void zaf() {
        String c = c("defaultGoogleSignInAccount");
        d("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(c)) {
            d(b("googleSignInAccount", c));
            d(b("googleSignInOptions", c));
        }
    }
}
