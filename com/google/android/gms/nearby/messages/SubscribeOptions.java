package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class SubscribeOptions {
    public static final SubscribeOptions DEFAULT = new Builder().build();
    private final Strategy a;
    private final MessageFilter b;
    private final SubscribeCallback c;
    public final boolean zzgb;
    public final int zzgc;

    /* loaded from: classes.dex */
    public static class Builder {
        private Strategy a = Strategy.DEFAULT;
        private MessageFilter b = MessageFilter.INCLUDE_ALL_MY_TYPES;
        private SubscribeCallback c;

        public SubscribeOptions build() {
            return new SubscribeOptions(this.a, this.b, this.c);
        }

        public Builder setCallback(SubscribeCallback subscribeCallback) {
            this.c = (SubscribeCallback) Preconditions.checkNotNull(subscribeCallback);
            return this;
        }

        public Builder setFilter(MessageFilter messageFilter) {
            this.b = messageFilter;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.a = strategy;
            return this;
        }
    }

    private SubscribeOptions(Strategy strategy, MessageFilter messageFilter, SubscribeCallback subscribeCallback, boolean z, int i) {
        this.a = strategy;
        this.b = messageFilter;
        this.c = subscribeCallback;
        this.zzgb = z;
        this.zzgc = i;
    }

    public final SubscribeCallback getCallback() {
        return this.c;
    }

    public final MessageFilter getFilter() {
        return this.b;
    }

    public final Strategy getStrategy() {
        return this.a;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String valueOf2 = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36 + String.valueOf(valueOf2).length());
        sb.append("SubscribeOptions{strategy=");
        sb.append(valueOf);
        sb.append(", filter=");
        sb.append(valueOf2);
        sb.append('}');
        return sb.toString();
    }
}
