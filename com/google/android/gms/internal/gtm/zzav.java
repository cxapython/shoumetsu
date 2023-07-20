package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzav implements ServiceConnection {
    final /* synthetic */ zzat a;
    private volatile zzce b;
    private volatile boolean c;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzav(zzat zzatVar) {
        this.a = zzatVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzav zzavVar;
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.a.zzu("Service connected with null binder");
                notifyAll();
                return;
            }
            zzce zzceVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                        zzceVar = queryLocalInterface instanceof zzce ? (zzce) queryLocalInterface : new zzcf(iBinder);
                    }
                    this.a.zzq("Bound to IAnalyticsService interface");
                } else {
                    this.a.zze("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.a.zzu("Service connect failed to get IAnalyticsService");
            }
            if (zzceVar == null) {
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    Context e = this.a.e();
                    zzavVar = this.a.a;
                    connectionTracker.unbindService(e, zzavVar);
                } catch (IllegalArgumentException unused2) {
                }
            } else if (!this.c) {
                this.a.zzt("onServiceConnected received after the timeout limit");
                this.a.h().zza(new j(this, zzceVar));
            } else {
                this.b = zzceVar;
            }
            notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceDisconnected");
        this.a.h().zza(new k(this, componentName));
    }

    public final zzce zzdq() {
        zzav zzavVar;
        com.google.android.gms.analytics.zzk.zzav();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context e = this.a.e();
        intent.putExtra("app_package_name", e.getPackageName());
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            this.b = null;
            this.c = true;
            zzavVar = this.a.a;
            boolean bindService = connectionTracker.bindService(e, intent, zzavVar, 129);
            this.a.zza("Bind to service requested", Boolean.valueOf(bindService));
            if (!bindService) {
                this.c = false;
                return null;
            }
            try {
                wait(zzby.zzaak.get().longValue());
            } catch (InterruptedException unused) {
                this.a.zzt("Wait for service connect was interrupted");
            }
            this.c = false;
            zzce zzceVar = this.b;
            this.b = null;
            if (zzceVar == null) {
                this.a.zzu("Successfully bound to service but never got onServiceConnected callback");
            }
            return zzceVar;
        }
    }
}
