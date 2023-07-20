package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.firebase_messaging.zze;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements ServiceConnection {
    @GuardedBy("this")
    int a;
    final Messenger b;
    k c;
    @GuardedBy("this")
    final Queue<m<?>> d;
    @GuardedBy("this")
    final SparseArray<m<?>> e;
    final /* synthetic */ f f;

    private h(f fVar) {
        this.f = fVar;
        this.a = 0;
        this.b = new Messenger(new zze(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.firebase.iid.g
            private final h a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.a(message);
            }
        }));
        this.d = new ArrayDeque();
        this.e = new SparseArray<>();
    }

    private final void c() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f.c;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.firebase.iid.i
            private final h a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final m<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final h hVar = this.a;
                while (true) {
                    synchronized (hVar) {
                        if (hVar.a != 2) {
                            return;
                        }
                        if (hVar.d.isEmpty()) {
                            hVar.a();
                            return;
                        }
                        poll = hVar.d.poll();
                        hVar.e.put(poll.a, poll);
                        scheduledExecutorService2 = hVar.f.c;
                        scheduledExecutorService2.schedule(new Runnable(hVar, poll) { // from class: com.google.firebase.iid.l
                            private final h a;
                            private final m b;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.a = hVar;
                                this.b = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.a(this.b.a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    context = hVar.f.b;
                    Messenger messenger = hVar.b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.c;
                    obtain.arg1 = poll.a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.a());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.d);
                    obtain.setData(bundle);
                    try {
                        hVar.c.a(obtain);
                    } catch (RemoteException e) {
                        hVar.a(2, e.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a() {
        Context context;
        if (this.a == 2 && this.d.isEmpty() && this.e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.a = 3;
            ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
            context = this.f.b;
            connectionTracker.unbindService(context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(int i) {
        m<?> mVar = this.e.get(i);
        if (mVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.e.remove(i);
            mVar.a(new p(3, "Timed out waiting for response"));
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(int i, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        switch (this.a) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.a = 4;
                ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                context = this.f.b;
                connectionTracker.unbindService(context, this);
                p pVar = new p(i, str);
                for (m<?> mVar : this.d) {
                    mVar.a(pVar);
                }
                this.d.clear();
                for (int i2 = 0; i2 < this.e.size(); i2++) {
                    this.e.valueAt(i2).a(pVar);
                }
                this.e.clear();
                return;
            case 3:
                this.a = 4;
                return;
            case 4:
                return;
            default:
                int i3 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            m<?> mVar = this.e.get(i);
            if (mVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.e.remove(i);
            a();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                mVar.a(new p(4, "Not supported by GmsCore"));
            } else {
                mVar.a(data);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean a(m mVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        switch (this.a) {
            case 0:
                this.d.add(mVar);
                Preconditions.checkState(this.a == 0);
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                }
                this.a = 1;
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                context = this.f.b;
                if (!connectionTracker.bindService(context, intent, this, 1)) {
                    a(0, "Unable to bind to service");
                } else {
                    scheduledExecutorService = this.f.c;
                    scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.firebase.iid.j
                        private final h a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.b();
                        }
                    }, 30L, TimeUnit.SECONDS);
                }
                return true;
            case 1:
                this.d.add(mVar);
                return true;
            case 2:
                this.d.add(mVar);
                c();
                return true;
            case 3:
            case 4:
                return false;
            default:
                int i = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b() {
        if (this.a == 1) {
            a(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            a(0, "Null service connection");
            return;
        }
        try {
            this.c = new k(iBinder);
            this.a = 2;
            c();
        } catch (RemoteException e) {
            a(0, e.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        a(2, "Service disconnected");
    }
}
