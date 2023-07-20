package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzb;
import com.google.android.gms.internal.firebase_messaging.zzf;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public abstract class af extends Service {
    final ExecutorService a;
    private Binder b;
    private final Object c;
    private int d;
    private int e;

    public af() {
        zzb zza = zza.zza();
        String valueOf = String.valueOf(getClass().getSimpleName());
        this.a = zza.zza(new NamedThreadFactory(valueOf.length() != 0 ? "Firebase-".concat(valueOf) : new String("Firebase-")), zzf.zze);
        this.c = new Object();
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Intent intent) {
        if (intent != null) {
            androidx.g.a.a.completeWakefulIntent(intent);
        }
        synchronized (this.c) {
            this.e--;
            if (this.e == 0) {
                stopSelfResult(this.d);
            }
        }
    }

    protected Intent a(Intent intent) {
        return intent;
    }

    public boolean b(Intent intent) {
        return false;
    }

    public abstract void c(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.b == null) {
            this.b = new aj(this);
        }
        return this.b;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.c) {
            this.d = i2;
            this.e++;
        }
        Intent a = a(intent);
        if (a == null) {
            d(intent);
            return 2;
        } else if (b(a)) {
            d(intent);
            return 2;
        } else {
            this.a.execute(new ad(this, a, intent));
            return 3;
        }
    }
}
