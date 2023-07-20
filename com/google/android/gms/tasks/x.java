package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class x implements Continuation<Void, List<TResult>> {
    private final /* synthetic */ Collection a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Collection collection) {
        this.a = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task<Void> task) {
        if (this.a.size() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Task task2 : this.a) {
            arrayList.add(task2.getResult());
        }
        return arrayList;
    }
}
