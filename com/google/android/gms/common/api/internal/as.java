package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class as implements au {
    private final /* synthetic */ zacp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(zacp zacpVar) {
        this.a = zacpVar;
    }

    @Override // com.google.android.gms.common.api.internal.au
    public final void a(BasePendingResult<?> basePendingResult) {
        this.a.a.remove(basePendingResult);
    }
}
