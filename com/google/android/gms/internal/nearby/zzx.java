package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import java.io.IOException;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzx extends GmsClient<zzdu> {
    private final long d;
    private final Set<k> e;
    private final Set<v> f;
    private final Set<cp> g;
    private zzff h;

    public zzx(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.e = new androidx.b.b();
        this.f = new androidx.b.b();
        this.g = new androidx.b.b();
        this.d = hashCode();
    }

    public static /* synthetic */ Status a(int i) {
        return b(i);
    }

    public static Status b(int i) {
        return new Status(i, ConnectionsStatusCodes.getStatusCodeString(i));
    }

    private final void i() {
        for (k kVar : this.e) {
            kVar.a();
        }
        for (v vVar : this.f) {
            vVar.a();
        }
        for (cp cpVar : this.g) {
            cpVar.a();
        }
        this.e.clear();
        this.f.clear();
        this.g.clear();
        zzff zzffVar = this.h;
        if (zzffVar != null) {
            zzffVar.a();
            this.h = null;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        return queryLocalInterface instanceof zzdu ? (zzdu) queryLocalInterface : new zzdv(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String b() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.d);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzdu) getService()).zza(new zzv().zzd());
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        i();
        super.disconnect();
    }

    public final void disconnectFromEndpoint(String str) {
        ((zzdu) getService()).zza(new zzdb().zzd(str).zzf());
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        super.onConnectedLocked((zzdu) iInterface);
        this.h = new zzff();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i) {
        if (i == 1) {
            i();
        }
        super.onConnectionSuspended(i);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    public final void stopAdvertising() {
        ((zzdu) getService()).zza(new zzgh().zzx());
    }

    public final void stopAllEndpoints() {
        ((zzdu) getService()).zza(new zzgk().zzy());
    }

    public final void stopDiscovery() {
        ((zzdu) getService()).zza(new zzgn().zzz());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, long j) {
        ((zzdu) getService()).zza(new zzs().zzb(new aa(resultHolder)).zza(j).zzc());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str) {
        ((zzdu) getService()).zza(new zzfo().zzc(new aa(resultHolder)).zzf(str).zzs());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str, ListenerHolder<PayloadCallback> listenerHolder) {
        v vVar = new v(listenerHolder);
        this.f.add(vVar);
        ((zzdu) getService()).zza(new zzo().zza(new aa(resultHolder)).zza(str).zza(vVar).zzb());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str, ListenerHolder<EndpointDiscoveryCallback> listenerHolder, DiscoveryOptions discoveryOptions) {
        k kVar = new k(listenerHolder);
        this.e.add(kVar);
        ((zzdu) getService()).zza(new zzge().zzf(new aa(resultHolder)).zzk(str).zze(discoveryOptions).zza(kVar).zzw());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str, String str2, ListenerHolder<ConnectionLifecycleCallback> listenerHolder) {
        cp cpVar = new cp(listenerHolder);
        this.g.add(cpVar);
        ((zzdu) getService()).zza(new zzfs().zzd(new aa(resultHolder)).zzg(str).zzh(str2).zza(cpVar).zzt());
    }

    public final void zza(BaseImplementation.ResultHolder<Connections.StartAdvertisingResult> resultHolder, String str, String str2, ListenerHolder<ConnectionLifecycleCallback> listenerHolder, AdvertisingOptions advertisingOptions) {
        cp cpVar = new cp(listenerHolder);
        this.g.add(cpVar);
        ((zzdu) getService()).zza(new zzga().zza(new ac(resultHolder)).zzi(str).zzj(str2).zzg(advertisingOptions).zzb(cpVar).zzv());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String[] strArr, Payload payload, boolean z) {
        try {
            Pair<zzfh, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> a = zzfl.a(payload);
            ((zzdu) getService()).zza(new zzfw().zze(new aa(resultHolder)).zza(strArr).zzb((zzfh) a.first).zzu());
            if (a.second == null) {
                return;
            }
            Pair pair = (Pair) a.second;
            this.h.a(payload.asStream().asInputStream(), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.first), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.second), payload.getId());
        } catch (IOException unused) {
            resultHolder.setResult(b((int) ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR));
        }
    }
}
