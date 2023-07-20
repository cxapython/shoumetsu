package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.nearby.zzgw;
import com.google.android.gms.internal.nearby.zzgy;
import com.google.android.gms.internal.nearby.zzhb;
import com.google.android.gms.internal.nearby.zzhd;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* loaded from: classes.dex */
public final class zzah extends GmsClient<zzs> {
    private final zzhd<ListenerHolder.ListenerKey, IBinder> d;
    private final ClientAppContext e;
    private final int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(14)
    public zzah(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, MessagesOptions messagesOptions) {
        super(context, looper, 62, clientSettings, connectionCallbacks, onConnectionFailedListener);
        int i;
        this.d = new zzhd<>();
        String realClientPackageName = clientSettings.getRealClientPackageName();
        int a = a(context);
        if (messagesOptions != null) {
            this.e = new ClientAppContext(realClientPackageName, null, false, null, a);
            i = messagesOptions.zzfh;
        } else {
            this.e = new ClientAppContext(realClientPackageName, null, false, null, a);
            i = -1;
        }
        this.f = i;
        if (a != 1 || !PlatformVersion.isAtLeastIceCreamSandwich()) {
            return;
        }
        Activity activity = (Activity) context;
        if (Log.isLoggable("NearbyMessagesClient", 2)) {
            Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
        }
        activity.getApplication().registerActivityLifecycleCallbacks(new b(activity, this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        return queryLocalInterface instanceof zzs ? (zzs) queryLocalInterface : new zzt(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        String str;
        switch (i) {
            case 1:
                str = "ACTIVITY_STOPPED";
                break;
            case 2:
                str = "CLIENT_DISCONNECTED";
                break;
            default:
                if (!Log.isLoggable("NearbyMessagesClient", 5)) {
                    return;
                }
                Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", Integer.valueOf(i)));
                return;
        }
        if (!isConnected()) {
            if (!Log.isLoggable("NearbyMessagesClient", 3)) {
                return;
            }
            Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str));
            return;
        }
        zzj zzjVar = new zzj(i);
        if (Log.isLoggable("NearbyMessagesClient", 3)) {
            Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", str));
        }
        ((zzs) getService()).zza(zzjVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, PendingIntent pendingIntent) {
        ((zzs) getService()).zza(new zzcg(null, new zzgy(listenerHolder), pendingIntent));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void a(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, PendingIntent pendingIntent, zzab zzabVar, SubscribeOptions subscribeOptions) {
        a(listenerHolder, pendingIntent, zzabVar, subscribeOptions, this.e.zzhf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, PendingIntent pendingIntent, zzab zzabVar, SubscribeOptions subscribeOptions, int i) {
        ((zzs) getService()).zza(new SubscribeRequest(null, subscribeOptions.getStrategy(), new zzgy(listenerHolder), subscribeOptions.getFilter(), pendingIntent, null, zzabVar, subscribeOptions.zzgb, subscribeOptions.zzgc, this.e.zzhf));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<MessageListener> listenerHolder2) {
        zzgy zzgyVar = new zzgy(listenerHolder);
        if (!this.d.containsKey(listenerHolder2.getListenerKey())) {
            zzgyVar.zza(new Status(0));
            return;
        }
        ((zzs) getService()).zza(new zzcg(this.d.get(listenerHolder2.getListenerKey()), zzgyVar, null));
        this.d.remove(listenerHolder2.getListenerKey());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void a(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<MessageListener> listenerHolder2, zzab zzabVar, SubscribeOptions subscribeOptions, byte[] bArr) {
        a(listenerHolder, listenerHolder2, zzabVar, subscribeOptions, null, this.e.zzhf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<MessageListener> listenerHolder2, zzab zzabVar, SubscribeOptions subscribeOptions, byte[] bArr, int i) {
        if (!this.d.containsKey(listenerHolder2.getListenerKey())) {
            this.d.zza(listenerHolder2.getListenerKey(), new zzgw(listenerHolder2));
        }
        ((zzs) getService()).zza(new SubscribeRequest(this.d.get(listenerHolder2.getListenerKey()), subscribeOptions.getStrategy(), new zzgy(listenerHolder), subscribeOptions.getFilter(), null, null, zzabVar, subscribeOptions.zzgb, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, zzaf zzafVar) {
        ((zzs) getService()).zza(new zzce(zzafVar, new zzgy(listenerHolder)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void a(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, zzaf zzafVar, zzv zzvVar, PublishOptions publishOptions) {
        a(listenerHolder, zzafVar, zzvVar, publishOptions, this.e.zzhf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, zzaf zzafVar, zzv zzvVar, PublishOptions publishOptions, int i) {
        ((zzs) getService()).zza(new zzbz(zzafVar, publishOptions.getStrategy(), new zzgy(listenerHolder), zzvVar, i));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String b() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<StatusCallback> listenerHolder2) {
        if (!this.d.containsKey(listenerHolder2.getListenerKey())) {
            this.d.zza(listenerHolder2.getListenerKey(), new zzhb(listenerHolder2));
        }
        zzcb zzcbVar = new zzcb(new zzgy(listenerHolder), this.d.get(listenerHolder2.getListenerKey()));
        zzcbVar.zzix = true;
        ((zzs) getService()).zza(zzcbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<StatusCallback> listenerHolder2) {
        zzgy zzgyVar = new zzgy(listenerHolder);
        if (!this.d.containsKey(listenerHolder2.getListenerKey())) {
            zzgyVar.zza(new Status(0));
            return;
        }
        zzcb zzcbVar = new zzcb(zzgyVar, this.d.get(listenerHolder2.getListenerKey()));
        zzcbVar.zzix = false;
        ((zzs) getService()).zza(zzcbVar);
        this.d.remove(listenerHolder2.getListenerKey());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle d() {
        Bundle d = super.d();
        d.putInt("NearbyPermissions", this.f);
        d.putParcelable("ClientAppContext", this.e);
        return d;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        try {
            a(2);
        } catch (RemoteException e) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e));
            }
        }
        this.d.clear();
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }
}
