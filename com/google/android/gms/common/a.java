package com.google.android.gms.common;

import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;

/* loaded from: classes.dex */
final class a implements Continuation<Map<zai<?>, String>, Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GoogleApiAvailability googleApiAvailability) {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Void then(Task<Map<zai<?>, String>> task) {
        task.getResult();
        return null;
    }
}
