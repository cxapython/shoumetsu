package com.google.android.gms.internal.drive;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class zziv {
    protected static final Charset a = Charset.forName("UTF-8");
    private static final Charset b = Charset.forName("ISO-8859-1");
    private static final Object c = new Object();

    public static void zza(zzir zzirVar, zzir zzirVar2) {
        if (zzirVar.a != null) {
            zzirVar2.a = (zzit) zzirVar.a.clone();
        }
    }
}
