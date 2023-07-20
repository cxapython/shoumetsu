package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements OnCompleteListener<TResult> {
    private final /* synthetic */ TaskCompletionSource a;
    private final /* synthetic */ zaab b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zaab zaabVar, TaskCompletionSource taskCompletionSource) {
        this.b = zaabVar;
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<TResult> task) {
        Map map;
        map = this.b.b;
        map.remove(this.a);
    }
}
