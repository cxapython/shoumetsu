package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class ClientSettings {
    public static final String KEY_CLIENT_SESSION_ID = "com.google.android.gms.common.internal.ClientSettings.sessionId";
    private final Account a;
    private final Set<Scope> b;
    private final Set<Scope> c;
    private final Map<Api<?>, OptionalApiSettings> d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final SignInOptions i;
    private final boolean j;
    private Integer k;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class Builder {
        private Account a;
        private androidx.b.b<Scope> b;
        private Map<Api<?>, OptionalApiSettings> c;
        private View e;
        private String f;
        private String g;
        private boolean i;
        private int d = 0;
        private SignInOptions h = SignInOptions.DEFAULT;

        public final Builder addAllRequiredScopes(Collection<Scope> collection) {
            if (this.b == null) {
                this.b = new androidx.b.b<>();
            }
            this.b.addAll(collection);
            return this;
        }

        public final Builder addRequiredScope(Scope scope) {
            if (this.b == null) {
                this.b = new androidx.b.b<>();
            }
            this.b.add(scope);
            return this;
        }

        @KeepForSdk
        public final ClientSettings build() {
            return new ClientSettings(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }

        public final Builder enableSignInClientDisconnectFix() {
            this.i = true;
            return this;
        }

        public final Builder setAccount(Account account) {
            this.a = account;
            return this;
        }

        public final Builder setGravityForPopups(int i) {
            this.d = i;
            return this;
        }

        public final Builder setOptionalApiSettingsMap(Map<Api<?>, OptionalApiSettings> map) {
            this.c = map;
            return this;
        }

        public final Builder setRealClientClassName(String str) {
            this.g = str;
            return this;
        }

        @KeepForSdk
        public final Builder setRealClientPackageName(String str) {
            this.f = str;
            return this;
        }

        public final Builder setSignInOptions(SignInOptions signInOptions) {
            this.h = signInOptions;
            return this;
        }

        public final Builder setViewForPopups(View view) {
            this.e = view;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class OptionalApiSettings {
        public final Set<Scope> mScopes;

        public OptionalApiSettings(Set<Scope> set) {
            Preconditions.checkNotNull(set);
            this.mScopes = Collections.unmodifiableSet(set);
        }
    }

    @KeepForSdk
    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i, View view, String str, String str2, SignInOptions signInOptions) {
        this(account, set, map, i, view, str, str2, signInOptions, false);
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i, View view, String str, String str2, SignInOptions signInOptions, boolean z) {
        this.a = account;
        this.b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.d = map == null ? Collections.EMPTY_MAP : map;
        this.f = view;
        this.e = i;
        this.g = str;
        this.h = str2;
        this.i = signInOptions;
        this.j = z;
        HashSet hashSet = new HashSet(this.b);
        for (OptionalApiSettings optionalApiSettings : this.d.values()) {
            hashSet.addAll(optionalApiSettings.mScopes);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    @KeepForSdk
    public static ClientSettings createDefault(Context context) {
        return new GoogleApiClient.Builder(context).buildClientSettings();
    }

    @KeepForSdk
    @Nullable
    public final Account getAccount() {
        return this.a;
    }

    @KeepForSdk
    @Nullable
    @Deprecated
    public final String getAccountName() {
        Account account = this.a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @KeepForSdk
    public final Account getAccountOrDefault() {
        Account account = this.a;
        return account != null ? account : new Account("<<default account>>", AccountType.GOOGLE);
    }

    @KeepForSdk
    public final Set<Scope> getAllRequestedScopes() {
        return this.c;
    }

    @KeepForSdk
    public final Set<Scope> getApplicableScopes(Api<?> api) {
        OptionalApiSettings optionalApiSettings = this.d.get(api);
        if (optionalApiSettings == null || optionalApiSettings.mScopes.isEmpty()) {
            return this.b;
        }
        HashSet hashSet = new HashSet(this.b);
        hashSet.addAll(optionalApiSettings.mScopes);
        return hashSet;
    }

    @Nullable
    public final Integer getClientSessionId() {
        return this.k;
    }

    @KeepForSdk
    public final int getGravityForPopups() {
        return this.e;
    }

    public final Map<Api<?>, OptionalApiSettings> getOptionalApiSettings() {
        return this.d;
    }

    @Nullable
    public final String getRealClientClassName() {
        return this.h;
    }

    @KeepForSdk
    @Nullable
    public final String getRealClientPackageName() {
        return this.g;
    }

    @KeepForSdk
    public final Set<Scope> getRequiredScopes() {
        return this.b;
    }

    @Nullable
    public final SignInOptions getSignInOptions() {
        return this.i;
    }

    @KeepForSdk
    @Nullable
    public final View getViewForPopups() {
        return this.f;
    }

    public final boolean isSignInClientDisconnectFixEnabled() {
        return this.j;
    }

    public final void setClientSessionId(Integer num) {
        this.k = num;
    }
}
