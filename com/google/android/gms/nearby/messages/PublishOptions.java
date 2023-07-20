package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class PublishOptions {
    public static final PublishOptions DEFAULT = new Builder().build();
    private final Strategy a;
    private final PublishCallback b;

    /* loaded from: classes.dex */
    public static class Builder {
        private Strategy a = Strategy.DEFAULT;
        private PublishCallback b;

        public PublishOptions build() {
            return new PublishOptions(this.a, this.b);
        }

        public Builder setCallback(PublishCallback publishCallback) {
            this.b = (PublishCallback) Preconditions.checkNotNull(publishCallback);
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.a = (Strategy) Preconditions.checkNotNull(strategy);
            return this;
        }
    }

    private PublishOptions(Strategy strategy, PublishCallback publishCallback) {
        this.a = strategy;
        this.b = publishCallback;
    }

    public final PublishCallback getCallback() {
        return this.b;
    }

    public final Strategy getStrategy() {
        return this.a;
    }
}
