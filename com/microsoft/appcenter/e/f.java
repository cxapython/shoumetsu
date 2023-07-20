package com.microsoft.appcenter.e;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import java.io.Closeable;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class f implements Closeable {
    @SuppressLint({"StaticFieldLeak"})
    private static f a;
    private final Context b;
    private final ConnectivityManager c;
    private ConnectivityManager.NetworkCallback e;
    private a f;
    private final Set<b> d = new CopyOnWriteArraySet();
    private final AtomicBoolean g = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f.this.e();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    public f(Context context) {
        this.b = context.getApplicationContext();
        this.c = (ConnectivityManager) context.getSystemService("connectivity");
        a();
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f(context);
            }
            fVar = a;
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Network network) {
        com.microsoft.appcenter.e.a.b("AppCenter", "Network " + network + " is available.");
        if (this.g.compareAndSet(false, true)) {
            a(true);
        }
    }

    private void a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("Network has been ");
        sb.append(z ? "connected." : "disconnected.");
        com.microsoft.appcenter.e.a.b("AppCenter", sb.toString());
        for (b bVar : this.d) {
            bVar.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Network network) {
        com.microsoft.appcenter.e.a.b("AppCenter", "Network " + network + " is lost.");
        Network[] allNetworks = this.c.getAllNetworks();
        if (!(allNetworks == null || allNetworks.length == 0 || Arrays.equals(allNetworks, new Network[]{network})) || !this.g.compareAndSet(true, false)) {
            return;
        }
        a(false);
    }

    private IntentFilter c() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    private boolean d() {
        if (Build.VERSION.SDK_INT >= 21) {
            Network[] allNetworks = this.c.getAllNetworks();
            if (allNetworks == null) {
                return false;
            }
            for (Network network : allNetworks) {
                NetworkInfo networkInfo = this.c.getNetworkInfo(network);
                if (networkInfo != null && networkInfo.isConnected()) {
                    return true;
                }
            }
        } else {
            NetworkInfo[] allNetworkInfo = this.c.getAllNetworkInfo();
            if (allNetworkInfo == null) {
                return false;
            }
            for (NetworkInfo networkInfo2 : allNetworkInfo) {
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        boolean d = d();
        if (this.g.compareAndSet(!d, d)) {
            a(d);
        }
    }

    public void a() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12);
                this.e = new ConnectivityManager.NetworkCallback() { // from class: com.microsoft.appcenter.e.f.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        f.this.a(network);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        f.this.b(network);
                    }
                };
                this.c.registerNetworkCallback(builder.build(), this.e);
            } else {
                this.f = new a();
                this.b.registerReceiver(this.f, c());
                e();
            }
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Cannot access network state information.", e);
            this.g.set(true);
        }
    }

    public void a(b bVar) {
        this.d.add(bVar);
    }

    public void b(b bVar) {
        this.d.remove(bVar);
    }

    public boolean b() {
        return this.g.get() || d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.set(false);
        if (Build.VERSION.SDK_INT >= 21) {
            this.c.unregisterNetworkCallback(this.e);
        } else {
            this.b.unregisterReceiver(this.f);
        }
    }
}
