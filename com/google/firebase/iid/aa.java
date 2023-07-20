package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements Runnable {
    private final long a;
    private final PowerManager.WakeLock b = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId c;
    private final ac d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public aa(FirebaseInstanceId firebaseInstanceId, q qVar, ac acVar, long j) {
        this.c = firebaseInstanceId;
        this.d = acVar;
        this.a = j;
        this.b.setReferenceCounted(false);
    }

    @VisibleForTesting
    private final boolean c() {
        ab c = this.c.c();
        if (this.c.i() || this.c.a(c)) {
            try {
                String d = this.c.d();
                if (d == null) {
                    Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                    return false;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "Token successfully retrieved");
                }
                if (c == null || (c != null && !d.equals(c.a))) {
                    Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                    intent.putExtra(net.gree.gamelib.core.a.b.a.p, d);
                    Context a = a();
                    Intent intent2 = new Intent(a, FirebaseInstanceIdReceiver.class);
                    intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                    intent2.putExtra("wrapped_intent", intent);
                    a.sendBroadcast(intent2);
                }
                return true;
            } catch (IOException | SecurityException e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Token retrieval failed: ".concat(valueOf) : new String("Token retrieval failed: "));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a() {
        return this.c.b().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public final void run() {
        try {
            if (z.a().a(a())) {
                this.b.acquire();
            }
            this.c.a(true);
            if (!this.c.g()) {
                this.c.a(false);
            } else if (z.a().b(a()) && !b()) {
                new ae(this).a();
                if (!z.a().a(a())) {
                    return;
                }
                this.b.release();
            } else {
                if (!c() || !this.d.a(this.c)) {
                    this.c.a(this.a);
                } else {
                    this.c.a(false);
                }
                if (!z.a().a(a())) {
                    return;
                }
                this.b.release();
            }
        } finally {
            if (z.a().a(a())) {
                this.b.release();
            }
        }
    }
}
