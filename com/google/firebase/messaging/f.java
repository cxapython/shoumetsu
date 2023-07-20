package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.f;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
final class f {
    private final Executor a;
    private final Context b;
    private final e c;
    private final Bundle d;

    public f(Context context, Bundle bundle, Executor executor) {
        this.a = executor;
        this.b = context;
        this.d = bundle;
        this.c = new e(context, context.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        boolean z;
        if ("1".equals(e.a(this.d, "gcm.n.noui"))) {
            return true;
        }
        if (!((KeyguardManager) this.b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                SystemClock.sleep(10L);
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.b.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        if (next.importance == 100) {
                            z = true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        g a = g.a(e.a(this.d, "gcm.n.image"));
        if (a != null) {
            a.a(this.a);
        }
        d a2 = this.c.a(this.d);
        f.d dVar = a2.a;
        if (a != null) {
            try {
                Bitmap bitmap = (Bitmap) Tasks.await(a.a(), 5L, TimeUnit.SECONDS);
                dVar.a(bitmap);
                dVar.a(new f.b().a(bitmap).b((Bitmap) null));
            } catch (InterruptedException unused) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                a.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException unused2) {
            } catch (TimeoutException unused3) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                a.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.b.getSystemService("notification")).notify(a2.b, 0, a2.a.b());
        return true;
    }
}
