package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements Continuation<Void, Task<List<Task<?>>>> {
    private final /* synthetic */ Collection a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Collection collection) {
        this.a = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<List<Task<?>>> then(Task<Void> task) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        return Tasks.forResult(arrayList);
    }
}
