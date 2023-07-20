package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements ServiceConnection {
    private final Set<ServiceConnection> a = new HashSet();
    private int b = 2;
    private boolean c;
    private IBinder d;
    private final GmsClientSupervisor.zza e;
    private ComponentName f;
    private final /* synthetic */ k g;

    public l(k kVar, GmsClientSupervisor.zza zzaVar) {
        this.g = kVar;
        this.e = zzaVar;
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        Context context;
        ConnectionTracker unused;
        Context unused2;
        unused = this.g.d;
        unused2 = this.g.b;
        GmsClientSupervisor.zza zzaVar = this.e;
        context = this.g.b;
        zzaVar.zzb(context);
        this.a.add(serviceConnection);
    }

    public final void a(String str) {
        ConnectionTracker connectionTracker;
        Context context;
        Context context2;
        ConnectionTracker connectionTracker2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        this.b = 3;
        connectionTracker = this.g.d;
        context = this.g.b;
        GmsClientSupervisor.zza zzaVar = this.e;
        context2 = this.g.b;
        this.c = connectionTracker.zza(context, str, zzaVar.zzb(context2), this, this.e.zzq());
        if (this.c) {
            handler = this.g.c;
            Message obtainMessage = handler.obtainMessage(1, this.e);
            handler2 = this.g.c;
            j = this.g.f;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.b = 2;
        try {
            connectionTracker2 = this.g.d;
            context3 = this.g.b;
            connectionTracker2.unbindService(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean a() {
        return this.c;
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.a.contains(serviceConnection);
    }

    public final int b() {
        return this.b;
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        ConnectionTracker unused;
        Context unused2;
        unused = this.g.d;
        unused2 = this.g.b;
        this.a.remove(serviceConnection);
    }

    public final void b(String str) {
        Handler handler;
        ConnectionTracker connectionTracker;
        Context context;
        handler = this.g.c;
        handler.removeMessages(1, this.e);
        connectionTracker = this.g.d;
        context = this.g.b;
        connectionTracker.unbindService(context, this);
        this.c = false;
        this.b = 2;
    }

    public final boolean c() {
        return this.a.isEmpty();
    }

    public final IBinder d() {
        return this.d;
    }

    public final ComponentName e() {
        return this.f;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.g.a;
        synchronized (hashMap) {
            handler = this.g.c;
            handler.removeMessages(1, this.e);
            this.d = iBinder;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.a) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.g.a;
        synchronized (hashMap) {
            handler = this.g.c;
            handler.removeMessages(1, this.e);
            this.d = null;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.a) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.b = 2;
        }
    }
}
