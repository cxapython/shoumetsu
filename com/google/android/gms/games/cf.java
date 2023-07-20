package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.internal.zzbn;

/* loaded from: classes.dex */
final class cf implements zzbn {
    @Override // com.google.android.gms.games.internal.zzbn
    public final boolean zza(Status status) {
        return status.isSuccess() || status.getStatusCode() == 3003;
    }
}
