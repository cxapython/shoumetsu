package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.ExecutionOptions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bz implements Runnable {
    private final /* synthetic */ InputStream a;
    private final /* synthetic */ OutputStream b;
    private final /* synthetic */ long c;
    private final /* synthetic */ OutputStream d;
    private final /* synthetic */ zzff e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(zzff zzffVar, InputStream inputStream, OutputStream outputStream, long j, OutputStream outputStream2) {
        this.e = zzffVar;
        this.a = inputStream;
        this.b = outputStream;
        this.c = j;
        this.d = outputStream2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th;
        boolean z;
        this.e.b = this.a;
        boolean z2 = true;
        try {
            IOUtils.copyStream(this.a, this.b, false, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH);
            IOUtils.closeQuietly(this.a);
            zzff zzffVar = this.e;
            zzff.a(this.d, false, this.c);
        } catch (IOException e) {
            try {
                z = this.e.c;
                if (!z) {
                    Log.w("NearbyConnections", String.format("Exception copying stream for Payload %d", Long.valueOf(this.c)), e);
                } else {
                    Log.d("NearbyConnections", String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", Long.valueOf(this.c)));
                }
                IOUtils.closeQuietly(this.a);
                zzff zzffVar2 = this.e;
                zzff.a(this.d, true, this.c);
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(this.a);
                zzff zzffVar3 = this.e;
                zzff.a(this.d, z2, this.c);
                IOUtils.closeQuietly(this.b);
                this.e.b = null;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            IOUtils.closeQuietly(this.a);
            zzff zzffVar32 = this.e;
            zzff.a(this.d, z2, this.c);
            IOUtils.closeQuietly(this.b);
            this.e.b = null;
            throw th;
        }
        IOUtils.closeQuietly(this.b);
        this.e.b = null;
    }
}
