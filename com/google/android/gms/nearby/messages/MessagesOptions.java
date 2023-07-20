package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public class MessagesOptions implements Api.ApiOptions.Optional {
    public final String zzff;
    public final boolean zzfg;
    public final int zzfh;
    public final String zzfi;
    public final String zzfj;

    /* loaded from: classes.dex */
    public static class Builder {
        private int a = -1;

        public MessagesOptions build() {
            return new MessagesOptions(this);
        }

        public Builder setPermissions(int i) {
            this.a = i;
            return this;
        }
    }

    private MessagesOptions(Builder builder) {
        this.zzff = null;
        this.zzfg = false;
        this.zzfh = builder.a;
        this.zzfi = null;
        this.zzfj = null;
    }
}
