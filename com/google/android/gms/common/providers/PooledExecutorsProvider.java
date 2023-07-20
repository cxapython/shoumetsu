package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
/* loaded from: classes.dex */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory a;

    /* loaded from: classes.dex */
    public interface PooledExecutorFactory {
        @KeepForSdk
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    @KeepForSdk
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (a == null) {
                a = new a();
            }
            pooledExecutorFactory = a;
        }
        return pooledExecutorFactory;
    }
}
