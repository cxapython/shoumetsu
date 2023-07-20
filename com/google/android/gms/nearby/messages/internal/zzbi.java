package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzgw;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* loaded from: classes.dex */
public final class zzbi implements Messages {
    public static final zzbi zzij = new zzbi();
    public static final Api.ClientKey<zzah> CLIENT_KEY = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<zzah, MessagesOptions> CLIENT_BUILDER = new z();

    private zzbi() {
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> getPermissionStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new ah(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        zzgw.zza(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message) {
        return publish(googleApiClient, message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message, PublishOptions publishOptions) {
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        aj ajVar = null;
        ListenerHolder registerListener = publishOptions.getCallback() == null ? null : googleApiClient.registerListener(publishOptions.getCallback());
        if (registerListener != null) {
            ajVar = new aj(registerListener);
        }
        return googleApiClient.execute(new ab(this, googleApiClient, message, ajVar, publishOptions));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> registerStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return googleApiClient.execute(new ai(this, googleApiClient, googleApiClient.registerListener(statusCallback)));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return subscribe(googleApiClient, pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        am amVar = null;
        ListenerHolder registerListener = subscribeOptions.getCallback() == null ? null : googleApiClient.registerListener(subscribeOptions.getCallback());
        if (registerListener != null) {
            amVar = new am(registerListener);
        }
        return googleApiClient.execute(new ae(this, googleApiClient, pendingIntent, amVar, subscribeOptions));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return subscribe(googleApiClient, messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zzae() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder registerListener = googleApiClient.registerListener(messageListener);
        am amVar = null;
        ListenerHolder registerListener2 = subscribeOptions.getCallback() == null ? null : googleApiClient.registerListener(subscribeOptions.getCallback());
        if (registerListener2 != null) {
            amVar = new am(registerListener2);
        }
        return googleApiClient.execute(new ad(this, googleApiClient, registerListener, amVar, subscribeOptions));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unpublish(GoogleApiClient googleApiClient, Message message) {
        Preconditions.checkNotNull(message);
        return googleApiClient.execute(new ac(this, googleApiClient, message));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unregisterStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return googleApiClient.execute(new aa(this, googleApiClient, googleApiClient.registerListener(statusCallback)));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent);
        return googleApiClient.execute(new ag(this, googleApiClient, pendingIntent));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        Preconditions.checkNotNull(messageListener);
        return googleApiClient.execute(new af(this, googleApiClient, googleApiClient.registerListener(messageListener)));
    }
}
