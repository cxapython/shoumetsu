package org.cocos2dx.lib;

import android.util.Log;
import cz.msebera.android.httpclient.Header;
import java.io.File;

/* loaded from: classes.dex */
class c extends com.c.a.a.e {
    int e;
    File f;
    private long g;
    private long h;
    private Cocos2dxDownloader i;

    public c(Cocos2dxDownloader cocos2dxDownloader, int i, File file, File file2) {
        super(file, true);
        this.f = file2;
        this.i = cocos2dxDownloader;
        this.e = i;
        this.g = k().length();
        this.h = 0L;
    }

    @Override // com.c.a.a.e
    public void a(int i, Header[] headerArr, File file) {
        String str;
        StringBuilder sb;
        String str2;
        a("onSuccess(i:" + i + " headers:" + headerArr + " file:" + file);
        if (this.f.exists()) {
            if (this.f.isDirectory()) {
                sb = new StringBuilder();
                str2 = "Dest file is directory:";
            } else if (!this.f.delete()) {
                sb = new StringBuilder();
                str2 = "Can't remove old file:";
            }
            sb.append(str2);
            sb.append(this.f.getAbsolutePath());
            str = sb.toString();
            this.i.onFinish(this.e, 0, str, null);
        }
        k().renameTo(this.f);
        str = null;
        this.i.onFinish(this.e, 0, str, null);
    }

    @Override // com.c.a.a.e
    public void a(int i, Header[] headerArr, Throwable th, File file) {
        a("onFailure(i:" + i + " headers:" + headerArr + " throwable:" + th + " file:" + file);
        String str = "";
        if (th != null) {
            str = th.toString();
        }
        this.i.onFinish(this.e, i, str, null);
    }

    @Override // com.c.a.a.c
    public void a(long j, long j2) {
        long j3 = j - this.h;
        long j4 = this.g;
        this.i.onProgress(this.e, j3, j + j4, j2 + j4);
        this.h = j;
    }

    void a(String str) {
        Log.d("Cocos2dxDownloader", str);
    }

    @Override // com.c.a.a.c
    public void d() {
        this.i.onStart(this.e);
    }

    @Override // com.c.a.a.c
    public void e() {
        this.i.runNextTaskIfExists();
    }
}
