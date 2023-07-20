package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class f {
    @GuardedBy("MessengerIpcClient.class")
    private static f a;
    private final Context b;
    private final ScheduledExecutorService c;
    @GuardedBy("this")
    private h d = new h(this);
    @GuardedBy("this")
    private int e = 1;

    private f(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.c = scheduledExecutorService;
        this.b = context.getApplicationContext();
    }

    private final synchronized int a() {
        int i;
        i = this.e;
        this.e = i + 1;
        return i;
    }

    private final synchronized <T> Task<T> a(m<T> mVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(mVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.d.a(mVar)) {
            this.d = new h(this);
            this.d.a(mVar);
        }
        return mVar.b.getTask();
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f(context, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zze));
            }
            fVar = a;
        }
        return fVar;
    }

    public final Task<Void> a(int i, Bundle bundle) {
        return a(new n(a(), 2, bundle));
    }

    public final Task<Bundle> b(int i, Bundle bundle) {
        return a(new o(a(), 1, bundle));
    }
}
