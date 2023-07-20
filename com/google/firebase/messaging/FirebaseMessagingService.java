package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.af;
import com.google.firebase.iid.z;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class FirebaseMessagingService extends af {
    private static final Queue<String> b = new ArrayDeque(10);

    @Override // com.google.firebase.iid.af
    protected final Intent a(Intent intent) {
        return z.a().b();
    }

    public void a() {
    }

    public void a(RemoteMessage remoteMessage) {
    }

    public void a(String str) {
    }

    public void a(String str, Exception exc) {
    }

    public void b(String str) {
    }

    @Override // com.google.firebase.iid.af
    public final boolean b(Intent intent) {
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
            if (pendingIntent != null) {
                try {
                    pendingIntent.send();
                } catch (PendingIntent.CanceledException unused) {
                    Log.e("FirebaseMessaging", "Notification pending intent canceled");
                }
            }
            if (!b.e(intent)) {
                return true;
            }
            b.b(intent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f7, code lost:
        if (r0.equals("send_event") == false) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015b  */
    @Override // com.google.firebase.iid.af
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(Intent intent) {
        Task<Void> a;
        boolean z;
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(action) && !"com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(action)) {
                if (!b.e(intent)) {
                    return;
                }
                b.c(intent);
                return;
            } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                b(intent.getStringExtra(net.gree.gamelib.core.a.b.a.p));
                return;
            } else {
                String valueOf = String.valueOf(intent.getAction());
                Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Unknown intent action: ".concat(valueOf) : new String("Unknown intent action: "));
                return;
            }
        }
        String stringExtra = intent.getStringExtra("google.message_id");
        char c = 2;
        if (TextUtils.isEmpty(stringExtra)) {
            a = Tasks.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            a = com.google.firebase.iid.f.a(this).a(2, bundle);
        }
        try {
            if (!TextUtils.isEmpty(stringExtra)) {
                if (b.contains(stringExtra)) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        String valueOf2 = String.valueOf(stringExtra);
                        Log.d("FirebaseMessaging", valueOf2.length() != 0 ? "Received duplicate message: ".concat(valueOf2) : new String("Received duplicate message: "));
                    }
                    z = true;
                    if (!z) {
                        String stringExtra2 = intent.getStringExtra("message_type");
                        if (stringExtra2 == null) {
                            stringExtra2 = "gcm";
                        }
                        int hashCode = stringExtra2.hashCode();
                        if (hashCode == -2062414158) {
                            if (stringExtra2.equals("deleted_messages")) {
                                c = 1;
                                switch (c) {
                                }
                            }
                            c = 65535;
                            switch (c) {
                            }
                        } else if (hashCode == 102161) {
                            if (stringExtra2.equals("gcm")) {
                                c = 0;
                                switch (c) {
                                }
                            }
                            c = 65535;
                            switch (c) {
                            }
                        } else if (hashCode != 814694033) {
                            if (hashCode == 814800675) {
                            }
                            c = 65535;
                            switch (c) {
                                case 0:
                                    if (b.e(intent)) {
                                        b.a(intent);
                                    }
                                    Bundle extras = intent.getExtras();
                                    if (extras == null) {
                                        extras = new Bundle();
                                    }
                                    extras.remove("androidx.contentpager.content.wakelockid");
                                    if (e.b(extras)) {
                                        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                                        try {
                                            if (new f(this, extras, newSingleThreadExecutor).a()) {
                                                break;
                                            } else {
                                                newSingleThreadExecutor.shutdown();
                                                if (b.e(intent)) {
                                                    b.d(intent);
                                                }
                                            }
                                        } finally {
                                            newSingleThreadExecutor.shutdown();
                                        }
                                    }
                                    a(new RemoteMessage(extras));
                                    break;
                                case 1:
                                    a();
                                    break;
                                case 2:
                                    a(intent.getStringExtra("google.message_id"));
                                    break;
                                case 3:
                                    String stringExtra3 = intent.getStringExtra("google.message_id");
                                    if (stringExtra3 == null) {
                                        stringExtra3 = intent.getStringExtra("message_id");
                                    }
                                    a(stringExtra3, new c(intent.getStringExtra("error")));
                                    break;
                                default:
                                    String valueOf3 = String.valueOf(stringExtra2);
                                    Log.w("FirebaseMessaging", valueOf3.length() != 0 ? "Received message with unknown type: ".concat(valueOf3) : new String("Received message with unknown type: "));
                                    break;
                            }
                        } else {
                            if (stringExtra2.equals("send_error")) {
                                c = 3;
                                switch (c) {
                                }
                            }
                            c = 65535;
                            switch (c) {
                            }
                        }
                    }
                    Tasks.await(a, 1L, TimeUnit.SECONDS);
                    return;
                }
                if (b.size() >= 10) {
                    b.remove();
                }
                b.add(stringExtra);
            }
            Tasks.await(a, 1L, TimeUnit.SECONDS);
            return;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            String valueOf4 = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf4).length() + 20);
            sb.append("Message ack failed: ");
            sb.append(valueOf4);
            Log.w("FirebaseMessaging", sb.toString());
            return;
        }
        z = false;
        if (!z) {
        }
    }
}
