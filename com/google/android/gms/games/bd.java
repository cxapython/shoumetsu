package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.internal.zzbn;

/* loaded from: classes.dex */
final class bd implements zzbn {
    @Override // com.google.android.gms.games.internal.zzbn
    public final boolean zza(Status status) {
        return status.isSuccess() || status.getStatusCode() == 4004;
    }
}
