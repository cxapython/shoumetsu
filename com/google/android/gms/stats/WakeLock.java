package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ShowFirstParty
@ThreadSafe
@KeepForSdk
/* loaded from: classes.dex */
public class WakeLock {
    private static ScheduledExecutorService n;
    private static volatile zza o = new a();
    private final Object a;
    private final PowerManager.WakeLock b;
    private WorkSource c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final Context h;
    private boolean i;
    private final Map<String, Integer[]> j;
    private final Set<Future<?>> k;
    private int l;
    private AtomicInteger m;

    /* loaded from: classes.dex */
    public interface zza {
    }

    @KeepForSdk
    public WakeLock(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    private WakeLock(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private WakeLock(Context context, int i, String str, String str2, String str3, String str4) {
        this.a = this;
        this.i = true;
        this.j = new HashMap();
        this.k = Collections.synchronizedSet(new HashSet());
        this.m = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        this.d = i;
        this.f = null;
        this.g = null;
        this.h = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf("*gcore*:");
            String valueOf2 = String.valueOf(str);
            this.e = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.e = str;
        }
        this.b = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            this.c = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(str3) ? context.getPackageName() : str3);
            WorkSource workSource = this.c;
            if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.h)) {
                WorkSource workSource2 = this.c;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.c = workSource;
                }
                try {
                    this.b.setWorkSource(this.c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                    Log.wtf("WakeLock", e.toString());
                }
            }
        }
        if (n == null) {
            n = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        }
    }

    private final String a(String str) {
        return (!this.i || TextUtils.isEmpty(str)) ? this.f : str;
    }

    private final List<String> a() {
        return WorkSourceUtil.getNames(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        if (this.b.isHeld()) {
            try {
                this.b.release();
            } catch (RuntimeException e) {
                if (!e.getClass().equals(RuntimeException.class)) {
                    throw e;
                }
                Log.e("WakeLock", String.valueOf(this.e).concat(" was already released!"), e);
            }
            this.b.isHeld();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r2 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (r13.l == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r13.h, com.google.android.gms.common.stats.StatsUtils.getEventKey(r13.b, r6), 7, r13.e, r6, null, r13.d, a(), r14);
        r13.l++;
     */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void acquire(long j) {
        this.m.incrementAndGet();
        String a = a((String) null);
        synchronized (this.a) {
            boolean z = false;
            if ((!this.j.isEmpty() || this.l > 0) && !this.b.isHeld()) {
                this.j.clear();
                this.l = 0;
            }
            if (this.i) {
                Integer[] numArr = this.j.get(a);
                if (numArr == null) {
                    this.j.put(a, new Integer[]{1});
                    z = true;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                }
            }
            if (!this.i) {
            }
        }
        this.b.acquire();
        if (j > 0) {
            n.schedule(new b(this), j, TimeUnit.MILLISECONDS);
        }
    }

    @KeepForSdk
    public boolean isHeld() {
        return this.b.isHeld();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r1 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (r12.l == 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r12.h, com.google.android.gms.common.stats.StatsUtils.getEventKey(r12.b, r6), 8, r12.e, r6, null, r12.d, a());
        r12.l--;
     */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release() {
        boolean z;
        if (this.m.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.e).concat(" release without a matched acquire!"));
        }
        String a = a((String) null);
        synchronized (this.a) {
            if (this.i) {
                Integer[] numArr = this.j.get(a);
                if (numArr != null) {
                    if (numArr[0].intValue() == 1) {
                        this.j.remove(a);
                        z = true;
                    } else {
                        numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                    }
                }
                z = false;
            }
            if (!this.i) {
            }
        }
        a(0);
    }

    @KeepForSdk
    public void setReferenceCounted(boolean z) {
        this.b.setReferenceCounted(z);
        this.i = z;
    }
}
