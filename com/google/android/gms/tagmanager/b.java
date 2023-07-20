package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements c {
    private Long a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzy c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzy zzyVar, boolean z) {
        this.c = zzyVar;
        this.b = z;
    }

    @Override // com.google.android.gms.tagmanager.c
    public final boolean a(Container container) {
        Clock clock;
        zzai zzaiVar;
        if (!this.b) {
            return !container.isDefault();
        }
        long lastRefreshTime = container.getLastRefreshTime();
        if (this.a == null) {
            zzaiVar = this.c.j;
            this.a = Long.valueOf(zzaiVar.zzhl());
        }
        clock = this.c.b;
        return lastRefreshTime + this.a.longValue() >= clock.currentTimeMillis();
    }
}
