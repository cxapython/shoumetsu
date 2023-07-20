package com.microsoft.appcenter.b;

import android.os.Handler;
import android.os.Looper;
import com.microsoft.appcenter.b.d;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class h extends f {
    static final long[] b = {TimeUnit.SECONDS.toMillis(10), TimeUnit.MINUTES.toMillis(5), TimeUnit.MINUTES.toMillis(20)};
    private final Handler c;
    private final Random d;

    /* loaded from: classes.dex */
    private class a extends e {
        private int d;

        a(d dVar, String str, String str2, Map<String, String> map, d.a aVar, l lVar) {
            super(dVar, str, str2, map, aVar, lVar);
        }

        @Override // com.microsoft.appcenter.b.e, com.microsoft.appcenter.b.l
        public void a(Exception exc) {
            long j;
            String str;
            if (this.d >= h.b.length || !j.a(exc)) {
                this.a.a(exc);
                return;
            }
            long parseLong = (!(exc instanceof i) || (str = ((i) exc).b().get("x-ms-retry-after-ms")) == null) ? 0L : Long.parseLong(str);
            if (parseLong == 0) {
                long[] jArr = h.b;
                int i = this.d;
                this.d = i + 1;
                parseLong = h.this.d.nextInt((int) j) + (jArr[i] / 2);
            }
            String str2 = "Try #" + this.d + " failed and will be retried in " + parseLong + " ms";
            if (exc instanceof UnknownHostException) {
                str2 = str2 + " (UnknownHostException)";
            }
            com.microsoft.appcenter.e.a.a("AppCenter", str2, exc);
            h.this.c.postDelayed(this, parseLong);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this(dVar, new Handler(Looper.getMainLooper()));
    }

    h(d dVar, Handler handler) {
        super(dVar);
        this.d = new Random();
        this.c = handler;
    }

    @Override // com.microsoft.appcenter.b.d
    public k a(String str, String str2, Map<String, String> map, d.a aVar, l lVar) {
        a aVar2 = new a(this.a, str, str2, map, aVar, lVar);
        aVar2.run();
        return aVar2;
    }
}
