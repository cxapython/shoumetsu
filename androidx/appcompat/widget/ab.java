package androidx.appcompat.widget;

import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes.dex */
class ab {
    private int a = 0;
    private int b = 0;
    private int c = BleSignal.UNKNOWN_TX_POWER;
    private int d = BleSignal.UNKNOWN_TX_POWER;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    public int a() {
        return this.a;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.a = i2;
            }
            if (i == Integer.MIN_VALUE) {
                return;
            }
            this.b = i;
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.a = i;
        }
        if (i2 == Integer.MIN_VALUE) {
            return;
        }
        this.b = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
        if (r2 != Integer.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0028, code lost:
        if (r2 != Integer.MIN_VALUE) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        int i;
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (!this.h) {
            this.a = this.e;
        } else if (z) {
            int i2 = this.d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.e;
            }
            this.a = i2;
            i = this.c;
        } else {
            int i3 = this.c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.e;
            }
            this.a = i3;
            i = this.d;
        }
        i = this.f;
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public void b(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.b = i2;
        }
    }

    public int c() {
        return this.g ? this.b : this.a;
    }

    public int d() {
        return this.g ? this.a : this.b;
    }
}
