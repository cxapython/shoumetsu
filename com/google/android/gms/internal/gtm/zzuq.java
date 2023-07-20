package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuq;

/* loaded from: classes.dex */
public abstract class zzuq<M extends zzuq<M>> extends zzuw {
    protected zzus a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuw
    public int a() {
        if (this.a != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.a.a(); i2++) {
                i += this.a.b(i2).a();
            }
            return i;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(zzun zzunVar, int i) {
        int position = zzunVar.getPosition();
        if (!zzunVar.zzao(i)) {
            return false;
        }
        int i2 = i >>> 3;
        eo eoVar = new eo(i, zzunVar.zzt(position, zzunVar.getPosition() - position));
        en enVar = null;
        zzus zzusVar = this.a;
        if (zzusVar == null) {
            this.a = new zzus();
        } else {
            enVar = zzusVar.a(i2);
        }
        if (enVar == null) {
            enVar = new en();
            this.a.a(i2, enVar);
        }
        enVar.a(eoVar);
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public /* synthetic */ Object clone() {
        zzuq zzuqVar = (zzuq) super.clone();
        zzuu.zza(this, zzuqVar);
        return zzuqVar;
    }

    public final <T> T zza(zzur<M, T> zzurVar) {
        en a;
        zzus zzusVar = this.a;
        if (zzusVar == null || (a = zzusVar.a(zzurVar.tag >>> 3)) == null) {
            return null;
        }
        return (T) a.a((zzur<?, Object>) zzurVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public void zza(zzuo zzuoVar) {
        if (this.a == null) {
            return;
        }
        for (int i = 0; i < this.a.a(); i++) {
            this.a.b(i).a(zzuoVar);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zzry() {
        return (zzuq) clone();
    }
}
