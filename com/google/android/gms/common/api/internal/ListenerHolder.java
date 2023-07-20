package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

@KeepForSdk
/* loaded from: classes.dex */
public final class ListenerHolder<L> {
    private final a a;
    private volatile L b;
    private final ListenerKey<L> c;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class ListenerKey<L> {
        private final L a;
        private final String b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @KeepForSdk
        public ListenerKey(L l, String str) {
            this.a = l;
            this.b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.a == listenerKey.a && this.b.equals(listenerKey.b);
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * 31) + this.b.hashCode();
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(L l);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    /* loaded from: classes.dex */
    private final class a extends zap {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            ListenerHolder.this.a((Notifier) message.obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @KeepForSdk
    public ListenerHolder(Looper looper, L l, String str) {
        this.a = new a(looper);
        this.b = (L) Preconditions.checkNotNull(l, "Listener must not be null");
        this.c = new ListenerKey<>(l, Preconditions.checkNotEmpty(str));
    }

    @KeepForSdk
    final void a(Notifier<? super L> notifier) {
        Object obj = (L) this.b;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }

    @KeepForSdk
    public final void clear() {
        this.b = null;
    }

    @KeepForSdk
    public final ListenerKey<L> getListenerKey() {
        return this.c;
    }

    @KeepForSdk
    public final boolean hasListener() {
        return this.b != null;
    }

    @KeepForSdk
    public final void notifyListener(Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.a.sendMessage(this.a.obtainMessage(1, notifier));
    }
}
