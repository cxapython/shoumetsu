package com.google.android.gms.drive;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.drive.zzaf;
import com.google.android.gms.internal.drive.zzaw;
import com.google.android.gms.internal.drive.zzbb;
import com.google.android.gms.internal.drive.zzbr;
import com.google.android.gms.internal.drive.zzcb;
import com.google.android.gms.internal.drive.zzch;
import com.google.android.gms.internal.drive.zzeb;
import java.util.Set;

/* loaded from: classes.dex */
public final class Drive {
    public static final Api.ClientKey<zzaw> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzaw, Api.ApiOptions.NoOptions> a = new b();
    private static final Api.AbstractClientBuilder<zzaw, zzb> b = new c();
    private static final Api.AbstractClientBuilder<zzaw, zza> c = new d();
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    private static final Scope d = new Scope(Scopes.DRIVE_FULL);
    private static final Scope e = new Scope(Scopes.DRIVE_APPS);
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Drive.API", a, CLIENT_KEY);
    private static final Api<zzb> f = new Api<>("Drive.INTERNAL_API", b, CLIENT_KEY);
    public static final Api<zza> zzu = new Api<>("Drive.API_CONNECTIONLESS", c, CLIENT_KEY);
    @Deprecated
    public static final DriveApi DriveApi = new zzaf();
    @Deprecated
    private static final zzj g = new zzbr();
    private static final zzl h = new zzeb();
    @Deprecated
    public static final DrivePreferencesApi DrivePreferencesApi = new zzcb();

    /* loaded from: classes.dex */
    public static class zza implements Api.ApiOptions.HasGoogleSignInAccountOptions {
        private final Bundle a = new Bundle();
        private final GoogleSignInAccount b;

        public zza(GoogleSignInAccount googleSignInAccount) {
            this.b = googleSignInAccount;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                zza zzaVar = (zza) obj;
                if (!Objects.equal(this.b, zzaVar.getGoogleSignInAccount())) {
                    return false;
                }
                String string = this.a.getString("method_trace_filename");
                String string2 = zzaVar.a.getString("method_trace_filename");
                if (((string == null && string2 == null) || (string != null && string2 != null && string.equals(string2))) && this.a.getBoolean("bypass_initial_sync") == zzaVar.a.getBoolean("bypass_initial_sync") && this.a.getInt("proxy_type") == zzaVar.a.getInt("proxy_type")) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.b;
        }

        public final int hashCode() {
            return Objects.hashCode(this.b, this.a.getString("method_trace_filename", ""), Integer.valueOf(this.a.getInt("proxy_type")), Boolean.valueOf(this.a.getBoolean("bypass_initial_sync")));
        }

        public final Bundle zzg() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public static class zzb implements Api.ApiOptions.Optional {
    }

    private Drive() {
    }

    private static void a(GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        Set<Scope> requestedScopes = googleSignInAccount.getRequestedScopes();
        Preconditions.checkArgument(requestedScopes.contains(SCOPE_FILE) || requestedScopes.contains(SCOPE_APPFOLDER) || requestedScopes.contains(d) || requestedScopes.contains(e), "You must request a Drive scope in order to interact with the Drive API.");
    }

    public static DriveClient getDriveClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        a(googleSignInAccount);
        return new zzbb(activity, new zza(googleSignInAccount));
    }

    public static DriveClient getDriveClient(Context context, GoogleSignInAccount googleSignInAccount) {
        a(googleSignInAccount);
        return new zzbb(context, new zza(googleSignInAccount));
    }

    public static DriveResourceClient getDriveResourceClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        a(googleSignInAccount);
        return new zzch(activity, new zza(googleSignInAccount));
    }

    public static DriveResourceClient getDriveResourceClient(Context context, GoogleSignInAccount googleSignInAccount) {
        a(googleSignInAccount);
        return new zzch(context, new zza(googleSignInAccount));
    }
}
