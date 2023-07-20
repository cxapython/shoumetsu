package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzgw;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zzak extends MessagesClient {
    private static final Api.ClientKey<zzah> b = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzah, MessagesOptions> c = new l();
    private static final Api<MessagesOptions> d = new Api<>("Nearby.MESSAGES_API", c, b);
    private final int e;

    public zzak(Activity activity, MessagesOptions messagesOptions) {
        super(activity, d, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.e = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new t(activity, this, null));
    }

    public zzak(Context context, MessagesOptions messagesOptions) {
        super(context, d, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.e = zzah.a(context);
    }

    public final <T> ListenerHolder<BaseImplementation.ResultHolder<Status>> a(TaskCompletionSource<T> taskCompletionSource) {
        return registerListener(new o(this, taskCompletionSource), Status.class.getName());
    }

    private final <T> Task<Void> a(ListenerHolder<T> listenerHolder, u uVar, u uVar2) {
        return doRegisterEventListener(new q(this, listenerHolder, uVar), new r(this, listenerHolder.getListenerKey(), uVar2));
    }

    private final Task<Void> a(u uVar) {
        return doWrite(new s(this, uVar));
    }

    private final <T> Task<Void> a(T t) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        doUnregisterEventListener(ListenerHolders.createListenerKey(t, t.getClass().getName())).addOnCompleteListener(new p(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final void a(int i) {
        a(new u(1) { // from class: com.google.android.gms.nearby.messages.internal.k
            private final int a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = r1;
            }

            @Override // com.google.android.gms.nearby.messages.internal.u
            public final void a(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.a(this.a);
            }
        });
    }

    private final <T> ListenerHolder<T> b(T t) {
        if (t == null) {
            return null;
        }
        return (ListenerHolder<T>) registerListener(t, t.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.GoogleApi
    public final ClientSettings.Builder a() {
        ClientSettings.Builder a = super.a();
        if (getApiOptions() != null) {
            getApiOptions();
        }
        return a;
    }

    public final /* synthetic */ void a(PendingIntent pendingIntent, x xVar, SubscribeOptions subscribeOptions, zzah zzahVar, ListenerHolder listenerHolder) {
        zzahVar.a(listenerHolder, pendingIntent, xVar, subscribeOptions, this.e);
    }

    public final /* synthetic */ void a(ListenerHolder listenerHolder, x xVar, SubscribeOptions subscribeOptions, zzah zzahVar, ListenerHolder listenerHolder2) {
        zzahVar.a(listenerHolder2, listenerHolder, xVar, subscribeOptions, null, this.e);
    }

    public final /* synthetic */ void a(Message message, v vVar, PublishOptions publishOptions, zzah zzahVar, ListenerHolder listenerHolder) {
        zzahVar.a(listenerHolder, zzaf.zza(message), vVar, publishOptions, this.e);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        zzgw.zza(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message) {
        return publish(message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message, PublishOptions publishOptions) {
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        ListenerHolder b2 = b(message);
        return a(b2, new u(this, message, new m(this, b(publishOptions.getCallback()), b2), publishOptions) { // from class: com.google.android.gms.nearby.messages.internal.c
            private final zzak a;
            private final Message b;
            private final v c;
            private final PublishOptions d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = message;
                this.c = r3;
                this.d = publishOptions;
            }

            @Override // com.google.android.gms.nearby.messages.internal.u
            public final void a(zzah zzahVar, ListenerHolder listenerHolder) {
                this.a.a(this.b, this.c, this.d, zzahVar, listenerHolder);
            }
        }, new u(message) { // from class: com.google.android.gms.nearby.messages.internal.d
            private final Message a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = message;
            }

            @Override // com.google.android.gms.nearby.messages.internal.u
            public final void a(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.a(listenerHolder, zzaf.zza(this.a));
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> registerStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        ListenerHolder b2 = b(statusCallback);
        return a(b2, new u(b2) { // from class: com.google.android.gms.nearby.messages.internal.i
            private final ListenerHolder a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = b2;
            }

            @Override // com.google.android.gms.nearby.messages.internal.u
            public final void a(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.b(listenerHolder, this.a);
            }
        }, new u(b2) { // from class: com.google.android.gms.nearby.messages.internal.j
            private final ListenerHolder a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = b2;
            }

            @Override // com.google.android.gms.nearby.messages.internal.u
            public final void a(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.c(listenerHolder, this.a);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent) {
        return subscribe(pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        ListenerHolder b2 = b(subscribeOptions.getCallback());
        return a(new u(this, pendingIntent, b2 == null ? null : new x(b2), subscribeOptions) { // from class: com.google.android.gms.nearby.messages.internal.g
            private final zzak a;
            private final PendingIntent b;
            private final x c;
            private final SubscribeOptions d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = pendingIntent;
                this.c = r3;
                this.d = subscribeOptions;
            }

            @Override // com.google.android.gms.nearby.messages.internal.u
            public final void a(zzah zzahVar, ListenerHolder listenerHolder) {
                this.a.a(this.b, this.c, this.d, zzahVar, listenerHolder);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener) {
        return subscribe(messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zzae() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder b2 = b(messageListener);
        return a(b2, new u(this, b2, new n(this, b(subscribeOptions.getCallback()), b2), subscribeOptions) { // from class: com.google.android.gms.nearby.messages.internal.e
            private final zzak a;
            private final ListenerHolder b;
            private final x c;
            private final SubscribeOptions d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = b2;
                this.c = r3;
                this.d = subscribeOptions;
            }

            @Override // com.google.android.gms.nearby.messages.internal.u
            public final void a(zzah zzahVar, ListenerHolder listenerHolder) {
                this.a.a(this.b, this.c, this.d, zzahVar, listenerHolder);
            }
        }, new u(b2) { // from class: com.google.android.gms.nearby.messages.internal.f
            private final ListenerHolder a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = b2;
            }

            @Override // com.google.android.gms.nearby.messages.internal.u
            public final void a(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.a(listenerHolder, this.a);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unpublish(Message message) {
        Preconditions.checkNotNull(message);
        return a((zzak) message);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unregisterStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return a((zzak) statusCallback);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent);
        return a(new u(pendingIntent) { // from class: com.google.android.gms.nearby.messages.internal.h
            private final PendingIntent a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = pendingIntent;
            }

            @Override // com.google.android.gms.nearby.messages.internal.u
            public final void a(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.a(listenerHolder, this.a);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(MessageListener messageListener) {
        Preconditions.checkNotNull(messageListener);
        return a((zzak) messageListener);
    }
}
