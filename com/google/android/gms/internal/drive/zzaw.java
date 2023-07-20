package com.google.android.gms.internal.drive;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzaw extends GmsClient<zzeo> {
    protected final boolean d;
    private final String e;
    private final Bundle f;
    private volatile DriveId g;
    private volatile DriveId h;
    private volatile boolean i;
    @VisibleForTesting
    @GuardedBy("changeEventCallbackMap")
    private final Map<DriveId, Map<ChangeListener, zzee>> j;
    @VisibleForTesting
    @GuardedBy("changesAvailableEventCallbackMap")
    private final Map<zzd, zzee> k;
    @VisibleForTesting
    @GuardedBy("uploadProgressEventCallbackMap")
    private final Map<DriveId, Map<com.google.android.gms.drive.events.zzl, zzee>> l;
    @VisibleForTesting
    @GuardedBy("pinnedDownloadProgressEventCallbackMap")
    private final Map<DriveId, Map<com.google.android.gms.drive.events.zzl, zzee>> m;

    public zzaw(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.i = false;
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = new HashMap();
        this.e = clientSettings.getRealClientPackageName();
        this.f = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.d = false;
                return;
            case 1:
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (serviceInfo.exported) {
                    this.d = true;
                    return;
                }
                String str = serviceInfo.name;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 60);
                sb.append("Drive event service ");
                sb.append(str);
                sb.append(" must be exported in AndroidManifest.xml");
                throw new IllegalStateException(sb.toString());
            default:
                String action = intent.getAction();
                StringBuilder sb2 = new StringBuilder(String.valueOf(action).length() + 72);
                sb2.append("AndroidManifest.xml can only define one service that handles the ");
                sb2.append(action);
                sb2.append(" action");
                throw new IllegalStateException(sb2.toString());
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
        return queryLocalInterface instanceof zzeo ? (zzeo) queryLocalInterface : new zzep(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingResult<Status> a(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(1, driveId));
        Preconditions.checkNotNull(changeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkState(isConnected(), "Client must be connected");
        synchronized (this.j) {
            Map<ChangeListener, zzee> map = this.j.get(driveId);
            if (map == null) {
                map = new HashMap<>();
                this.j.put(driveId, map);
            }
            zzee zzeeVar = map.get(changeListener);
            if (zzeeVar == null) {
                zzeeVar = new zzee(getLooper(), getContext(), 1, changeListener);
                map.put(changeListener, zzeeVar);
            } else if (zzeeVar.zzg(1)) {
                return new m(googleApiClient, Status.RESULT_SUCCESS);
            }
            zzeeVar.zzf(1);
            return googleApiClient.execute(new n(this, googleApiClient, new zzj(1, driveId), zzeeVar));
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.g = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.h = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            this.i = true;
        }
        super.a(i, iBinder, bundle, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingResult<Status> b(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(1, driveId));
        Preconditions.checkState(isConnected(), "Client must be connected");
        Preconditions.checkNotNull(changeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.j) {
            Map<ChangeListener, zzee> map = this.j.get(driveId);
            if (map == null) {
                return new m(googleApiClient, Status.RESULT_SUCCESS);
            }
            zzee remove = map.remove(changeListener);
            if (remove == null) {
                return new m(googleApiClient, Status.RESULT_SUCCESS);
            }
            if (map.isEmpty()) {
                this.j.remove(driveId);
            }
            return googleApiClient.execute(new o(this, googleApiClient, new zzgm(driveId, 1), remove));
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String b() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle d() {
        String packageName = getContext().getPackageName();
        Preconditions.checkNotNull(packageName);
        Preconditions.checkState(!h().getAllRequestedScopes().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.e)) {
            bundle.putString("proxy_package_name", this.e);
        }
        bundle.putAll(this.f);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzeo) getService()).zza(new zzad());
            } catch (RemoteException unused) {
            }
        }
        super.disconnect();
        synchronized (this.j) {
            this.j.clear();
        }
        synchronized (this.k) {
            this.k.clear();
        }
        synchronized (this.l) {
            this.l.clear();
        }
        synchronized (this.m) {
            this.m.clear();
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresAccount() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return !getContext().getPackageName().equals(this.e) || !UidVerifier.isGooglePlayServicesUid(getContext(), Process.myUid());
    }

    public final DriveId zzad() {
        return this.g;
    }

    public final DriveId zzae() {
        return this.h;
    }

    public final boolean zzaf() {
        return this.i;
    }

    public final boolean zzag() {
        return this.d;
    }
}
