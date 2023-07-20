package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zak {
    private int d;
    private final androidx.b.a<zai<?>, String> b = new androidx.b.a<>();
    private final TaskCompletionSource<Map<zai<?>, String>> c = new TaskCompletionSource<>();
    private boolean e = false;
    private final androidx.b.a<zai<?>, ConnectionResult> a = new androidx.b.a<>();

    public zak(Iterable<? extends GoogleApi<?>> iterable) {
        for (GoogleApi<?> googleApi : iterable) {
            this.a.put(googleApi.zak(), null);
        }
        this.d = this.a.keySet().size();
    }

    public final Task<Map<zai<?>, String>> getTask() {
        return this.c.getTask();
    }

    public final void zaa(zai<?> zaiVar, ConnectionResult connectionResult, String str) {
        this.a.put(zaiVar, connectionResult);
        this.b.put(zaiVar, str);
        this.d--;
        if (!connectionResult.isSuccess()) {
            this.e = true;
        }
        if (this.d == 0) {
            if (!this.e) {
                this.c.setResult(this.b);
                return;
            }
            this.c.setException(new AvailabilityException(this.a));
        }
    }

    public final Set<zai<?>> zap() {
        return this.a.keySet();
    }
}
