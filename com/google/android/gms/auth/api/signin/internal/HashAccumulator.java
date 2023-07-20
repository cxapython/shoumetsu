package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public class HashAccumulator {
    @VisibleForTesting
    private static int a = 31;
    private int b = 1;

    @KeepForSdk
    public HashAccumulator addObject(Object obj) {
        this.b = (a * this.b) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.b;
    }

    public final HashAccumulator zaa(boolean z) {
        this.b = (a * this.b) + (z ? 1 : 0);
        return this;
    }
}
