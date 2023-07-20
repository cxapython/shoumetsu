package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

/* loaded from: classes.dex */
final class cb implements ct {
    private static final cb a = new cb();

    private cb() {
    }

    public static cb a() {
        return a;
    }

    @Override // com.google.android.gms.internal.gtm.ct
    public final boolean a(Class<?> cls) {
        return zzrc.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.gtm.ct
    public final cs b(Class<?> cls) {
        if (!zzrc.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (cs) zzrc.a((Class<zzrc>) cls.asSubclass(zzrc.class)).a(zzrc.zze.zzbat, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
