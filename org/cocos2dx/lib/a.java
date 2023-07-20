package org.cocos2dx.lib;

import android.util.Log;
import cz.msebera.android.httpclient.Header;

/* loaded from: classes.dex */
class a extends com.c.a.a.d {
    int a;
    private Cocos2dxDownloader b;
    private long c;

    public a(Cocos2dxDownloader cocos2dxDownloader, int i) {
        super(new String[]{".*"});
        this.b = cocos2dxDownloader;
        this.a = i;
        this.c = 0L;
    }

    @Override // com.c.a.a.c
    public void a(int i, Header[] headerArr, byte[] bArr) {
        a("onSuccess(i:" + i + " headers:" + headerArr);
        this.b.onFinish(this.a, 0, null, bArr);
    }

    @Override // com.c.a.a.c
    public void a(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        a("onFailure(i:" + i + " headers:" + headerArr + " throwable:" + th);
        String str = "";
        if (th != null) {
            str = th.toString();
        }
        this.b.onFinish(this.a, i, str, null);
    }

    @Override // com.c.a.a.c
    public void a(long j, long j2) {
        this.b.onProgress(this.a, j - this.c, j, j2);
        this.c = j;
    }

    void a(String str) {
        Log.d("Cocos2dxDownloader", str);
    }

    @Override // com.c.a.a.c
    public void d() {
        this.b.onStart(this.a);
    }

    @Override // com.c.a.a.c
    public void e() {
        this.b.runNextTaskIfExists();
    }
}
