package net.gree.gamelib.payment.internal.a;

/* loaded from: classes.dex */
public class f {
    int a;
    String b;

    public f(int i, String str) {
        String a;
        this.a = i;
        if (str == null || str.trim().length() == 0) {
            a = e.a(i);
        } else {
            a = str + " (response: " + e.a(i) + ")";
        }
        this.b = a;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.a == 0;
    }

    public boolean d() {
        return this.a == -1005;
    }

    public boolean e() {
        int i = this.a;
        return i == 2 || i == 3;
    }

    public String toString() {
        return "{\"iab_result_code\":" + this.a + ",\"message\":\"" + this.b + "\"}";
    }
}
