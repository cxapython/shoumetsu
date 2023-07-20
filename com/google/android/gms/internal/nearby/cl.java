package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cl implements OnFailureListener {
    private final /* synthetic */ RegisterListenerMethod a;
    private final /* synthetic */ zzk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(zzk zzkVar, RegisterListenerMethod registerListenerMethod) {
        this.b = zzkVar;
        this.a = registerListenerMethod;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Set set;
        synchronized (this.b) {
            set = this.b.c;
            set.remove(this.a.getListenerKey());
        }
    }
}
