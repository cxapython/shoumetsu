package org.cocos2dx.lib;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
class e implements Runnable {
    private CountDownLatch a;
    private boolean[] b;
    private final int c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CountDownLatch countDownLatch, boolean[] zArr, int i, String str) {
        this.a = countDownLatch;
        this.b = zArr;
        this.c = i;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b[0] = Cocos2dxWebViewHelper._shouldStartLoading(this.c, this.d);
        this.a.countDown();
    }
}
