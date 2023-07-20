package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;

/* loaded from: classes.dex */
final class db {
    private bs<zzl> a;
    private zzl b;

    public db(bs<zzl> bsVar, zzl zzlVar) {
        this.a = bsVar;
        this.b = zzlVar;
    }

    public final bs<zzl> a() {
        return this.a;
    }

    public final zzl b() {
        return this.b;
    }

    public final int c() {
        int zzse = this.a.a().zzse();
        zzl zzlVar = this.b;
        return zzse + (zzlVar == null ? 0 : zzlVar.zzse());
    }
}
