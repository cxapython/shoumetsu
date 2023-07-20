package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t {
    private final Executor a;
    @GuardedBy("this")
    private final Map<Pair<String, String>, Task<a>> b = new androidx.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Executor executor) {
        this.a = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(Pair pair, Task task) {
        synchronized (this) {
            this.b.remove(pair);
        }
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized Task<a> a(String str, String str2, u uVar) {
        Pair pair = new Pair(str, str2);
        Task<a> task = this.b.get(pair);
        if (task != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return task;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        Task continueWithTask = uVar.a().continueWithTask(this.a, new Continuation(this, pair) { // from class: com.google.firebase.iid.v
            private final t a;
            private final Pair b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = pair;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.a.a(this.b, task2);
            }
        });
        this.b.put(pair, continueWithTask);
        return continueWithTask;
    }
}
