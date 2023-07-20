package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class zzff {
    private final ExecutorService a = Executors.newSingleThreadExecutor();
    private volatile InputStream b = null;
    private volatile boolean c = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(OutputStream outputStream, boolean z, long j) {
        try {
            outputStream.write(z ? 1 : 0);
        } catch (IOException e) {
            Log.w("NearbyConnections", String.format("Unable to deliver status for Payload %d", Long.valueOf(j)), e);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.c = true;
        this.a.shutdownNow();
        IOUtils.closeQuietly(this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2, long j) {
        this.a.execute(new bz(this, inputStream, outputStream, j, outputStream2));
    }
}
