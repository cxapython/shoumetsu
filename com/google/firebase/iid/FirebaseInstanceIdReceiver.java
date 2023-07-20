package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.drive.DriveFile;
import cz.msebera.android.httpclient.HttpStatus;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class FirebaseInstanceIdReceiver extends androidx.g.a.a {
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static al a;

    @ShowFirstParty
    @SuppressLint({"InlinedApi"})
    public static int a(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        boolean z = true;
        boolean z2 = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & DriveFile.MODE_READ_ONLY) == 0) {
            z = false;
        }
        if (!z2 || z) {
            int a2 = z.a().a(context, intent);
            if (!PlatformVersion.isAtLeastO() || a2 != 402) {
                return a2;
            }
            b(broadcastReceiver, context, intent);
            return HttpStatus.SC_FORBIDDEN;
        }
        return b(broadcastReceiver, context, intent);
    }

    private static synchronized al a(Context context, String str) {
        al alVar;
        synchronized (FirebaseInstanceIdReceiver.class) {
            if (a == null) {
                a = new al(context, str);
            }
            alVar = a;
        }
        return alVar;
    }

    private final void a(Context context, Intent intent) {
        int a2;
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            String stringExtra = intent.getStringExtra("CMD");
            if (stringExtra != null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(intent.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                    sb.append("Received command: ");
                    sb.append(stringExtra);
                    sb.append(" - ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                    FirebaseInstanceId.a().f();
                } else if ("SYNC".equals(stringExtra)) {
                    FirebaseInstanceId.a().h();
                }
            }
            a2 = -1;
        } else {
            String stringExtra2 = intent.getStringExtra("gcm.rawData64");
            if (stringExtra2 != null) {
                intent.putExtra("rawData", Base64.decode(stringExtra2, 0));
                intent.removeExtra("gcm.rawData64");
            }
            a2 = a(this, context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(a2);
        }
    }

    private static int b(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        if (broadcastReceiver.isOrderedBroadcast()) {
            broadcastReceiver.setResultCode(-1);
        }
        a(context, "com.google.firebase.MESSAGING_EVENT").a(intent, broadcastReceiver.goAsync());
        return -1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
        if (intent2 != null) {
            a(context, intent2);
        } else {
            a(context, intent);
        }
    }
}
