package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.gtm.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements bc<zzk> {
    private final /* synthetic */ zzy a;

    private e(zzy zzyVar) {
        this.a = zzyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(zzy zzyVar, eq eqVar) {
        this(zzyVar);
    }

    @Override // com.google.android.gms.tagmanager.bc
    public final void a() {
    }

    @Override // com.google.android.gms.tagmanager.bc
    public final void a(int i) {
        zzai zzaiVar;
        eo eoVar;
        zzy zzyVar;
        ContainerHolder mo8createFailedResult;
        zzai zzaiVar2;
        if (i == zzcz.zzahw) {
            zzaiVar2 = this.a.j;
            zzaiVar2.zzhn();
        }
        synchronized (this.a) {
            if (!this.a.isReady()) {
                eoVar = this.a.m;
                if (eoVar != null) {
                    zzyVar = this.a;
                    mo8createFailedResult = this.a.m;
                } else {
                    zzyVar = this.a;
                    mo8createFailedResult = this.a.mo8createFailedResult(Status.RESULT_TIMEOUT);
                }
                zzyVar.setResult(mo8createFailedResult);
            }
        }
        zzaiVar = this.a.j;
        this.a.a(zzaiVar.zzhm());
    }

    @Override // com.google.android.gms.tagmanager.bc
    public final /* synthetic */ void a(zzk zzkVar) {
        zzai zzaiVar;
        Clock clock;
        long j;
        boolean b;
        zzk zzkVar2;
        zzk zzkVar3;
        zzai zzaiVar2;
        zzk zzkVar4 = zzkVar;
        zzaiVar = this.a.j;
        zzaiVar.zzho();
        synchronized (this.a) {
            if (zzkVar4.zzqk == null) {
                zzkVar2 = this.a.o;
                if (zzkVar2.zzqk == null) {
                    zzdi.zzav("Current resource is null; network resource is also null");
                    zzaiVar2 = this.a.j;
                    this.a.a(zzaiVar2.zzhm());
                    return;
                }
                zzkVar3 = this.a.o;
                zzkVar4.zzqk = zzkVar3.zzqk;
            }
            zzy zzyVar = this.a;
            clock = this.a.b;
            zzyVar.a(zzkVar4, clock.currentTimeMillis(), false);
            j = this.a.p;
            StringBuilder sb = new StringBuilder(58);
            sb.append("setting refresh time to current time: ");
            sb.append(j);
            zzdi.zzab(sb.toString());
            b = this.a.b();
            if (!b) {
                this.a.a(zzkVar4);
            }
        }
    }
}
