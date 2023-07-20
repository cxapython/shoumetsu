package com.google.android.gms.signin;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* loaded from: classes.dex */
public final class zaa {
    private static final Api.ClientKey<SignInClientImpl> a = new Api.ClientKey<>();
    @ShowFirstParty
    private static final Api.ClientKey<SignInClientImpl> b = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zaph = new a();
    private static final Api.AbstractClientBuilder<SignInClientImpl, Object> c = new b();
    private static final Scope d = new Scope(Scopes.PROFILE);
    private static final Scope e = new Scope(Scopes.EMAIL);
    public static final Api<SignInOptions> API = new Api<>("SignIn.API", zaph, a);
    private static final Api<Object> f = new Api<>("SignIn.INTERNAL_API", c, b);
}
