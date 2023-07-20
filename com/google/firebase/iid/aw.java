package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aw implements Continuation<Bundle, String> {
    private final /* synthetic */ av a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.a = avVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ String then(Task<Bundle> task) {
        String a;
        av avVar = this.a;
        a = av.a(task.getResult(IOException.class));
        return a;
    }
}
