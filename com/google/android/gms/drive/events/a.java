package com.google.android.gms.drive.events;

import android.os.Looper;
import com.google.android.gms.drive.events.DriveEventService;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
final class a extends Thread {
    private final /* synthetic */ CountDownLatch a;
    private final /* synthetic */ DriveEventService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DriveEventService driveEventService, CountDownLatch countDownLatch) {
        this.b = driveEventService;
        this.a = countDownLatch;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            Looper.prepare();
            this.b.a = new DriveEventService.a(this.b, null);
            this.b.b = false;
            this.a.countDown();
            Looper.loop();
        } finally {
            countDownLatch = this.b.e;
            if (countDownLatch != null) {
                countDownLatch2 = this.b.e;
                countDownLatch2.countDown();
            }
        }
    }
}
