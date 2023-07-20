package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
/* loaded from: classes.dex */
public class BooleanResult implements Result {
    private final Status a;
    private final boolean b;

    @ShowFirstParty
    @KeepForSdk
    public BooleanResult(Status status, boolean z) {
        this.a = (Status) Preconditions.checkNotNull(status, "Status must not be null");
        this.b = z;
    }

    @KeepForSdk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.a.equals(booleanResult.a) && this.b == booleanResult.b;
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public Status getStatus() {
        return this.a;
    }

    @KeepForSdk
    public boolean getValue() {
        return this.b;
    }

    @KeepForSdk
    public final int hashCode() {
        return ((this.a.hashCode() + 527) * 31) + (this.b ? 1 : 0);
    }
}
