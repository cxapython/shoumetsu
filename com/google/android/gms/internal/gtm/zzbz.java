package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzbz<V> {
    private final V a;
    private final GservicesValue<V> b;

    private zzbz(GservicesValue<V> gservicesValue, V v) {
        Preconditions.checkNotNull(gservicesValue);
        this.b = gservicesValue;
        this.a = v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbz<Float> a(String str, float f, float f2) {
        return new zzbz<>(GservicesValue.value(str, Float.valueOf(0.5f)), Float.valueOf(0.5f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbz<Integer> a(String str, int i, int i2) {
        return new zzbz<>(GservicesValue.value(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbz<Long> a(String str, long j, long j2) {
        return new zzbz<>(GservicesValue.value(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbz<String> a(String str, String str2, String str3) {
        return new zzbz<>(GservicesValue.value(str, str3), str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbz<Boolean> a(String str, boolean z, boolean z2) {
        return new zzbz<>(GservicesValue.value(str, z2), Boolean.valueOf(z));
    }

    public final V get() {
        return this.a;
    }
}
