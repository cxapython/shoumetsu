package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzg {
    private final zzj a;
    private final Clock b;
    private boolean c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private final Map<Class<? extends zzi>, zzi> j;
    private final List<zzo> k;

    private zzg(zzg zzgVar) {
        this.a = zzgVar.a;
        this.b = zzgVar.b;
        this.d = zzgVar.d;
        this.e = zzgVar.e;
        this.f = zzgVar.f;
        this.g = zzgVar.g;
        this.h = zzgVar.h;
        this.k = new ArrayList(zzgVar.k);
        this.j = new HashMap(zzgVar.j.size());
        for (Map.Entry<Class<? extends zzi>, zzi> entry : zzgVar.j.entrySet()) {
            zzi a = a(entry.getKey());
            entry.getValue().zzb(a);
            this.j.put(entry.getKey(), a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzg(zzj zzjVar, Clock clock) {
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotNull(clock);
        this.a = zzjVar;
        this.b = clock;
        this.g = 1800000L;
        this.h = 3024000000L;
        this.j = new HashMap();
        this.k = new ArrayList();
    }

    @TargetApi(19)
    private static <T extends zzi> T a(Class<T> cls) {
        try {
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            if (e instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e);
            }
            if (e instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e);
            }
            if (Build.VERSION.SDK_INT >= 19 && (e instanceof ReflectiveOperationException)) {
                throw new IllegalArgumentException("Linkage exception", e);
            }
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a() {
        this.f = this.b.elapsedRealtime();
        long j = this.e;
        if (j == 0) {
            j = this.b.currentTimeMillis();
        }
        this.d = j;
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzj b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean c() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void d() {
        this.i = true;
    }

    @VisibleForTesting
    public final <T extends zzi> T zza(Class<T> cls) {
        return (T) this.j.get(cls);
    }

    @VisibleForTesting
    public final void zza(long j) {
        this.e = j;
    }

    @VisibleForTesting
    public final void zza(zzi zziVar) {
        Preconditions.checkNotNull(zziVar);
        Class<?> cls = zziVar.getClass();
        if (cls.getSuperclass() == zzi.class) {
            zziVar.zzb(zzb(cls));
            return;
        }
        throw new IllegalArgumentException();
    }

    @VisibleForTesting
    public final zzg zzai() {
        return new zzg(this);
    }

    @VisibleForTesting
    public final Collection<zzi> zzaj() {
        return this.j.values();
    }

    public final List<zzo> zzak() {
        return this.k;
    }

    @VisibleForTesting
    public final long zzal() {
        return this.d;
    }

    @VisibleForTesting
    public final void zzam() {
        this.a.b().a(this);
    }

    @VisibleForTesting
    public final boolean zzan() {
        return this.c;
    }

    @VisibleForTesting
    public final <T extends zzi> T zzb(Class<T> cls) {
        T t = (T) this.j.get(cls);
        if (t == null) {
            T t2 = (T) a(cls);
            this.j.put(cls, t2);
            return t2;
        }
        return t;
    }
}
