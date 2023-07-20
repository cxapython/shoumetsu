package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements OnCompleteListener<Boolean> {
    private final /* synthetic */ TaskCompletionSource a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(zzak zzakVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Boolean> task) {
        if (task.isSuccessful()) {
            this.a.setResult(null);
        } else {
            this.a.setException(task.getException());
        }
    }
}
