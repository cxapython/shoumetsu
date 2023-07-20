package com.google.android.gms.internal.gtm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
class ab extends BroadcastReceiver {
    @VisibleForTesting
    private static final String a = "com.google.android.gms.internal.gtm.ab";
    private final zzap b;
    private boolean c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(zzap zzapVar) {
        Preconditions.checkNotNull(zzapVar);
        this.b = zzapVar;
    }

    private final void e() {
        this.b.zzco();
        this.b.zzcs();
    }

    @VisibleForTesting
    private final boolean f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (SecurityException unused) {
        }
        return false;
    }

    public final void a() {
        e();
        if (this.c) {
            return;
        }
        Context context = this.b.getContext();
        context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter);
        this.d = f();
        this.b.zzco().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.d));
        this.c = true;
    }

    public final void b() {
        if (!this.c) {
            return;
        }
        this.b.zzco().zzq("Unregistering connectivity change receiver");
        this.c = false;
        this.d = false;
        try {
            this.b.getContext().unregisterReceiver(this);
        } catch (IllegalArgumentException e) {
            this.b.zzco().zze("Failed to unregister the network broadcast receiver", e);
        }
    }

    @VisibleForTesting
    public final void c() {
        Context context = this.b.getContext();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(a, true);
        context.sendOrderedBroadcast(intent, null);
    }

    public final boolean d() {
        if (!this.c) {
            this.b.zzco().zzt("Connectivity unknown. Receiver not registered");
        }
        return this.d;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        e();
        String action = intent.getAction();
        this.b.zzco().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean f = f();
            if (this.d == f) {
                return;
            }
            this.d = f;
            zzae zzcs = this.b.zzcs();
            zzcs.zza("Network connectivity status changed", Boolean.valueOf(f));
            zzcs.h().zza(new b(zzcs, f));
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.b.zzco().zzd("NetworkBroadcastReceiver received unknown action", action);
        } else if (intent.hasExtra(a)) {
        } else {
            zzae zzcs2 = this.b.zzcs();
            zzcs2.zzq("Radio powered up");
            zzcs2.zzci();
        }
    }
}
