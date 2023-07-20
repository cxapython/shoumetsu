package org.cocos2dx.lib;

import android.util.Log;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHeaders;

/* loaded from: classes.dex */
class d extends com.c.a.a.c {
    int a;
    String b;
    String c;
    String d;
    private Cocos2dxDownloader e;

    public d(Cocos2dxDownloader cocos2dxDownloader, int i, String str, String str2, String str3) {
        this.e = cocos2dxDownloader;
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // com.c.a.a.c
    public void a(int i, Header[] headerArr, byte[] bArr) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= headerArr.length) {
                break;
            }
            Header header = headerArr[i2];
            if (header.getName().equals(HttpHeaders.ACCEPT_RANGES)) {
                z = Boolean.valueOf(header.getValue().equals("bytes"));
                break;
            }
            i2++;
        }
        Cocos2dxDownloader.setResumingSupport(this.b, z);
        Cocos2dxDownloader.createTask(this.e, this.a, this.c, this.d);
    }

    @Override // com.c.a.a.c
    public void a(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        a("onFailure(code:" + i + " headers:" + headerArr + " throwable:" + th + " id:" + this.a);
        String str = "";
        if (th != null) {
            str = th.toString();
        }
        this.e.onFinish(this.a, i, str, null);
    }

    void a(String str) {
        Log.d("Cocos2dxDownloader", str);
    }

    @Override // com.c.a.a.c
    public void e() {
        this.e.runNextTaskIfExists();
    }
}
