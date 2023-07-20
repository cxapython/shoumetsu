package net.gree.gamelib.core.a;

import java.util.Date;

/* loaded from: classes.dex */
public class h {
    public static final int a = 17219;
    public static final String b = "The process is already in progress";
    private static long c = 30000;
    private boolean d;
    private long e;
    private long f;

    public h() {
        this.d = false;
        this.e = 0L;
        this.f = c;
    }

    public h(long j) {
        this.d = false;
        this.e = 0L;
        this.f = c;
        this.f = j;
    }

    public boolean a() {
        long time = new Date().getTime();
        if (!this.d || time >= this.e + this.f) {
            this.d = true;
            this.e = time;
            return true;
        }
        return false;
    }

    public void b() {
        this.d = false;
        this.e = 0L;
    }
}
