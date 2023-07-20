package com.google.android.gms.internal.nearby;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* loaded from: classes.dex */
public final class zzbd extends ConnectionsClient {
    private static final Api.ClientKey<zzx> b = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzx, Api.ApiOptions.NoOptions> c = new al();
    private static final Api<Api.ApiOptions.NoOptions> d = new Api<>("Nearby.CONNECTIONS_API", c, b);
    private final zzk e;

    public zzbd(Activity activity) {
        super(activity, d, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.e = zzk.zza();
    }

    public zzbd(Context context) {
        super(context, d, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.e = zzk.zza();
    }

    private final Task<Void> a(av avVar) {
        return doWrite(new au(this, avVar));
    }

    private final Task<Void> a(ay ayVar) {
        return doWrite(new am(this, ayVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        ListenerHolder<String> zza = this.e.zza((GoogleApi) this, str, "connection");
        this.e.zza(this, new as(this, zza), new at(this, zza.getListenerKey()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        zzk zzkVar = this.e;
        zzkVar.zza(this, zzkVar.zzb(this, str, "connection"));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> acceptConnection(final String str, PayloadCallback payloadCallback) {
        final ListenerHolder<L> registerListener = registerListener(payloadCallback, PayloadCallback.class.getName());
        return a(new av(str, registerListener) { // from class: com.google.android.gms.internal.nearby.ae
            private final String a;
            private final ListenerHolder b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = str;
                this.b = registerListener;
            }

            @Override // com.google.android.gms.internal.nearby.av
            public final void a(zzx zzxVar, BaseImplementation.ResultHolder resultHolder) {
                zzxVar.zza(resultHolder, this.a, this.b);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> cancelPayload(final long j) {
        return a(new av(j) { // from class: com.google.android.gms.internal.nearby.ai
            private final long a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = j;
            }

            @Override // com.google.android.gms.internal.nearby.av
            public final void a(zzx zzxVar, BaseImplementation.ResultHolder resultHolder) {
                zzxVar.zza(resultHolder, this.a);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void disconnectFromEndpoint(final String str) {
        a(new ay(str) { // from class: com.google.android.gms.internal.nearby.aj
            private final String a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = str;
            }

            @Override // com.google.android.gms.internal.nearby.ay
            public final void a(zzx zzxVar) {
                zzxVar.disconnectFromEndpoint(this.a);
            }
        });
        b(str);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> rejectConnection(final String str) {
        return a(new av(str) { // from class: com.google.android.gms.internal.nearby.af
            private final String a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = str;
            }

            @Override // com.google.android.gms.internal.nearby.av
            public final void a(zzx zzxVar, BaseImplementation.ResultHolder resultHolder) {
                zzxVar.zza(resultHolder, this.a);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(final String str, final String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        final ListenerHolder<L> registerListener = registerListener(new aw(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        a(str2);
        return a(new av(str, str2, registerListener) { // from class: com.google.android.gms.internal.nearby.ad
            private final String a;
            private final String b;
            private final ListenerHolder c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = str;
                this.b = str2;
                this.c = registerListener;
            }

            @Override // com.google.android.gms.internal.nearby.av
            public final void a(zzx zzxVar, BaseImplementation.ResultHolder resultHolder) {
                zzxVar.zza(resultHolder, this.a, this.b, this.c);
            }
        }).addOnFailureListener(new ar(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final String str, final Payload payload) {
        return a(new av(str, payload) { // from class: com.google.android.gms.internal.nearby.ag
            private final String a;
            private final Payload b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = str;
                this.b = payload;
            }

            @Override // com.google.android.gms.internal.nearby.av
            public final void a(zzx zzxVar, BaseImplementation.ResultHolder resultHolder) {
                zzxVar.zza((BaseImplementation.ResultHolder<Status>) resultHolder, new String[]{this.a}, this.b, false);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(final List<String> list, final Payload payload) {
        return a(new av(list, payload) { // from class: com.google.android.gms.internal.nearby.ah
            private final List a;
            private final Payload b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = list;
                this.b = payload;
            }

            @Override // com.google.android.gms.internal.nearby.av
            public final void a(zzx zzxVar, BaseImplementation.ResultHolder resultHolder) {
                zzxVar.zza((BaseImplementation.ResultHolder<Status>) resultHolder, (String[]) this.a.toArray(new String[0]), this.b, false);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        ListenerHolder<L> registerListener = registerListener(new aw(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        ListenerHolder zza = this.e.zza((GoogleApi) this, (zzbd) new Object(), "advertising");
        return this.e.zza(this, new an(this, zza, str, str2, registerListener, advertisingOptions), new ao(this, zza.getListenerKey()));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions) {
        ListenerHolder zza = this.e.zza((GoogleApi) this, (zzbd) endpointDiscoveryCallback, "discovery");
        return this.e.zza(this, new ap(this, zza, str, zza, discoveryOptions), new aq(this, zza.getListenerKey()));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAdvertising() {
        this.e.zza(this, "advertising");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAllEndpoints() {
        stopAdvertising();
        stopDiscovery();
        a(ak.a);
        this.e.zza(this, "connection");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopDiscovery() {
        this.e.zza(this, "discovery");
    }
}
