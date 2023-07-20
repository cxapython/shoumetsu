package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements PendingResult.StatusListener {
    private final /* synthetic */ BasePendingResult a;
    private final /* synthetic */ zaab b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zaab zaabVar, BasePendingResult basePendingResult) {
        this.b = zaabVar;
        this.a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Map map;
        map = this.b.a;
        map.remove(this.a);
    }
}
