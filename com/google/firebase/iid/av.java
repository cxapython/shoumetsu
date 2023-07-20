package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class av implements b {
    private final com.google.firebase.b a;
    private final q b;
    private final x c;
    private final Executor d;
    private final com.google.firebase.e.g e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(com.google.firebase.b bVar, q qVar, Executor executor, com.google.firebase.e.g gVar) {
        this(bVar, qVar, executor, new x(bVar.a(), qVar), gVar);
    }

    private av(com.google.firebase.b bVar, q qVar, Executor executor, x xVar, com.google.firebase.e.g gVar) {
        this.a = bVar;
        this.b = qVar;
        this.c = xVar;
        this.d = executor;
        this.e = gVar;
    }

    private final <T> Task<Void> a(Task<T> task) {
        return task.continueWith(ak.a(), new ax(this));
    }

    private final Task<Bundle> a(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.a.c().a());
        bundle.putString("gmsv", Integer.toString(this.b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.b.b());
        bundle.putString("app_ver_name", this.b.c());
        bundle.putString("cliv", "fiid-12451000");
        bundle.putString("Firebase-Client", this.e.a());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.d.execute(new Runnable(this, bundle, taskCompletionSource) { // from class: com.google.firebase.iid.au
            private final av a;
            private final Bundle b;
            private final TaskCompletionSource c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = bundle;
                this.c = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b, this.c);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            }
            if (string3 != null) {
                throw new IOException(string3);
            }
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
            sb.append("Unexpected response: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private final Task<String> b(Task<Bundle> task) {
        return task.continueWith(this.d, new aw(this));
    }

    @Override // com.google.firebase.iid.b
    public final Task<Void> a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle)));
    }

    @Override // com.google.firebase.iid.b
    public final Task<String> a(String str, String str2, String str3, String str4) {
        return b(a(str, str3, str4, new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Bundle bundle, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(this.c.a(bundle));
        } catch (IOException e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // com.google.firebase.iid.b
    public final boolean a() {
        return this.b.a() != 0;
    }

    @Override // com.google.firebase.iid.b
    public final Task<Void> b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        bundle.putString("delete", "1");
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle)));
    }

    @Override // com.google.firebase.iid.b
    public final boolean b() {
        return false;
    }
}
