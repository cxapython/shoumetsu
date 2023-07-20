package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzir;

/* loaded from: classes.dex */
public abstract class zzir<M extends zzir<M>> extends zzix {
    protected zzit a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.drive.zzix
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
    public final boolean a(zzio zzioVar, int i) {
        int position = zzioVar.getPosition();
        if (!zzioVar.zzk(i)) {
            return false;
        }
        int i2 = i >>> 3;
        cs csVar = new cs(i, zzioVar.zza(position, zzioVar.getPosition() - position));
        cr crVar = null;
        zzit zzitVar = this.a;
        if (zzitVar == null) {
            this.a = new zzit();
        } else {
            crVar = zzitVar.a(i2);
        }
        if (crVar == null) {
            crVar = new cr();
            this.a.a(i2, crVar);
        }
        crVar.a(csVar);
        return true;
    }

    @Override // com.google.android.gms.internal.drive.zzix
    public /* synthetic */ Object clone() {
        zzir zzirVar = (zzir) super.clone();
        zziv.zza(this, zzirVar);
        return zzirVar;
    }

    @Override // com.google.android.gms.internal.drive.zzix
    public void zza(zzip zzipVar) {
        if (this.a == null) {
            return;
        }
        for (int i = 0; i < this.a.a(); i++) {
            this.a.b(i).a(zzipVar);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzix
    public final /* synthetic */ zzix zzbi() {
        return (zzir) clone();
    }
}
