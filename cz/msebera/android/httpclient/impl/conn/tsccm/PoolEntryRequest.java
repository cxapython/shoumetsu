package cz.msebera.android.httpclient.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes.dex */
public interface PoolEntryRequest {
    void abortRequest();

    BasicPoolEntry getPoolEntry(long j, TimeUnit timeUnit);
}
