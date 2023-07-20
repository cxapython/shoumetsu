package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.ap;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x {
    private static int a;
    private static PendingIntent b;
    private final Context d;
    private final q e;
    private Messenger g;
    private ap h;
    @GuardedBy("responseCallbacks")
    private final androidx.b.g<String, TaskCompletionSource<Bundle>> c = new androidx.b.g<>();
    private Messenger f = new Messenger(new w(this, Looper.getMainLooper()));

    public x(Context context, q qVar) {
        this.d = context;
        this.e = qVar;
    }

    private static synchronized String a() {
        String num;
        synchronized (x.class) {
            int i = a;
            a = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private static synchronized void a(Context context, Intent intent) {
        synchronized (x.class) {
            if (b == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                b = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Message message) {
        String str;
        String str2;
        if (message == null || !(message.obj instanceof Intent)) {
            str = "FirebaseInstanceId";
            str2 = "Dropping invalid message";
        } else {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new ap.a());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof ap) {
                    this.h = (ap) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.g = (Messenger) parcelableExtra;
                }
            }
            Intent intent2 = (Intent) message.obj;
            String action = intent2.getAction();
            if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                if (!Log.isLoggable("FirebaseInstanceId", 3)) {
                    return;
                }
                String valueOf = String.valueOf(action);
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                return;
            }
            String stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra != null) {
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (!matcher.matches()) {
                    if (!Log.isLoggable("FirebaseInstanceId", 3)) {
                        return;
                    }
                    String valueOf2 = String.valueOf(stringExtra);
                    Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Unexpected response string: ".concat(valueOf2) : new String("Unexpected response string: "));
                    return;
                }
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group2);
                a(group, extras);
                return;
            }
            String stringExtra2 = intent2.getStringExtra("error");
            if (stringExtra2 == null) {
                String valueOf3 = String.valueOf(intent2.getExtras());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 49);
                sb.append("Unexpected response, no error or registration id ");
                sb.append(valueOf3);
                Log.w("FirebaseInstanceId", sb.toString());
                return;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf4 = String.valueOf(stringExtra2);
                Log.d("FirebaseInstanceId", valueOf4.length() != 0 ? "Received InstanceID error ".concat(valueOf4) : new String("Received InstanceID error "));
            }
            if (!stringExtra2.startsWith("|")) {
                synchronized (this.c) {
                    for (int i = 0; i < this.c.size(); i++) {
                        a(this.c.b(i), intent2.getExtras());
                    }
                }
                return;
            }
            String[] split = stringExtra2.split("\\|");
            if (split.length > 2 && "ID".equals(split[1])) {
                String str3 = split[2];
                String str4 = split[3];
                if (str4.startsWith(":")) {
                    str4 = str4.substring(1);
                }
                a(str3, intent2.putExtra("error", str4).getExtras());
                return;
            }
            str = "FirebaseInstanceId";
            String valueOf5 = String.valueOf(stringExtra2);
            str2 = valueOf5.length() != 0 ? "Unexpected structured response ".concat(valueOf5) : new String("Unexpected structured response ");
        }
        Log.w(str, str2);
    }

    private final void a(String str, Bundle bundle) {
        synchronized (this.c) {
            TaskCompletionSource<Bundle> remove = this.c.remove(str);
            if (remove != null) {
                remove.setResult(bundle);
                return;
            }
            String valueOf = String.valueOf(str);
            Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
        }
    }

    private final Bundle b(Bundle bundle) {
        Bundle c = c(bundle);
        if (c == null || !c.containsKey("google.messenger")) {
            return c;
        }
        Bundle c2 = c(bundle);
        if (c2 != null && c2.containsKey("google.messenger")) {
            return null;
        }
        return c2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a0, code lost:
        if (r8.h != null) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.tasks.TaskCompletionSource, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.util.concurrent.TimeUnit] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d0 -> B:65:0x00db). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d6 -> B:65:0x00db). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bundle c(Bundle bundle) {
        TaskCompletionSource taskCompletionSource;
        TaskCompletionSource taskCompletionSource2;
        String a2 = a();
        ?? taskCompletionSource3 = new TaskCompletionSource();
        synchronized (this.c) {
            this.c.put(a2, taskCompletionSource3);
        }
        if (this.e.a() != 0) {
            Intent intent = new Intent();
            intent.setPackage("com.google.android.gms");
            intent.setAction(this.e.a() == 2 ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.putExtras(bundle);
            a(this.d, intent);
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 5);
            sb.append("|ID|");
            sb.append(a2);
            sb.append("|");
            intent.putExtra("kid", sb.toString());
            int i = 3;
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 8);
                sb2.append("Sending ");
                sb2.append(valueOf);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
            intent.putExtra("google.messenger", this.f);
            if (this.g == null) {
                taskCompletionSource2 = taskCompletionSource3;
            }
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.g != null) {
                    this.g.send(obtain);
                    taskCompletionSource = taskCompletionSource3;
                } else {
                    this.h.a(obtain);
                    taskCompletionSource = taskCompletionSource3;
                }
            } catch (RemoteException unused) {
                taskCompletionSource2 = taskCompletionSource3;
                if (Log.isLoggable("FirebaseInstanceId", i)) {
                    Log.d("FirebaseInstanceId", "Messenger failed, fallback to startService");
                    taskCompletionSource2 = taskCompletionSource3;
                }
                if (this.e.a() == 2) {
                    this.d.sendBroadcast(intent);
                    taskCompletionSource = taskCompletionSource2;
                } else {
                    this.d.startService(intent);
                    taskCompletionSource = taskCompletionSource2;
                }
                try {
                    Task task = taskCompletionSource.getTask();
                    taskCompletionSource3 = 30000;
                    i = TimeUnit.MILLISECONDS;
                    Bundle bundle2 = (Bundle) Tasks.await(task, 30000L, i);
                    synchronized (this.c) {
                    }
                } catch (InterruptedException | TimeoutException unused2) {
                    Log.w("FirebaseInstanceId", "No response");
                    throw new IOException("TIMEOUT");
                } catch (ExecutionException e) {
                    throw new IOException(e);
                }
            }
            try {
                Task task2 = taskCompletionSource.getTask();
                taskCompletionSource3 = 30000;
                i = TimeUnit.MILLISECONDS;
                Bundle bundle22 = (Bundle) Tasks.await(task2, 30000L, i);
                synchronized (this.c) {
                    this.c.remove(a2);
                }
                return bundle22;
            } catch (Throwable th) {
                synchronized (this.c) {
                    this.c.remove(a2);
                    throw th;
                }
            }
        }
        throw new IOException("MISSING_INSTANCEID_SERVICE");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle a(Bundle bundle) {
        if (this.e.d() >= 12000000) {
            try {
                return (Bundle) Tasks.await(f.a(this.d).b(1, bundle));
            } catch (InterruptedException | ExecutionException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                    sb.append("Error making request: ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if ((e.getCause() instanceof p) && ((p) e.getCause()).a() == 4) {
                    return b(bundle);
                }
                return null;
            }
        }
        return b(bundle);
    }
}
