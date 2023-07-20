package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cl implements df {
    private static final ct b = new cm();
    private final ct a;

    public cl() {
        this(new cn(cb.a(), a()));
    }

    private cl(ct ctVar) {
        this.a = (ct) zzre.a(ctVar, "messageInfoFactory");
    }

    private static ct a() {
        try {
            return (ct) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }

    private static boolean a(cs csVar) {
        return csVar.a() == zzrc.zze.zzbaz;
    }

    @Override // com.google.android.gms.internal.gtm.df
    public final <T> de<T> a(Class<T> cls) {
        dg.a((Class<?>) cls);
        cs b2 = this.a.b(cls);
        return b2.b() ? zzrc.class.isAssignableFrom(cls) ? cw.a(dg.c(), bu.a(), b2.c()) : cw.a(dg.a(), bu.b(), b2.c()) : zzrc.class.isAssignableFrom(cls) ? a(b2) ? cv.a(cls, b2, cz.b(), cg.b(), dg.c(), bu.a(), cr.b()) : cv.a(cls, b2, cz.b(), cg.b(), dg.c(), null, cr.b()) : a(b2) ? cv.a(cls, b2, cz.a(), cg.a(), dg.a(), bu.b(), cr.a()) : cv.a(cls, b2, cz.a(), cg.a(), dg.b(), null, cr.a());
    }
}
