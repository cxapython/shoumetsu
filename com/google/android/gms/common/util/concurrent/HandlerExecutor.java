package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zze;
import java.util.concurrent.Executor;

@KeepForSdk
/* loaded from: classes.dex */
public class HandlerExecutor implements Executor {
    private final Handler a;

    @KeepForSdk
    public HandlerExecutor(Looper looper) {
        this.a = new zze(looper);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
