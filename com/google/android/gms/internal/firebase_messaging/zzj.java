package com.google.android.gms.internal.firebase_messaging;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class zzj {
    private static final OutputStream a = new c();

    public static InputStream zza(InputStream inputStream, long j) {
        return new d(inputStream, 1048576L);
    }
}
