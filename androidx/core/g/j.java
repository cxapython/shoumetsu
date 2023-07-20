package androidx.core.g;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class j {
    private ViewParent a;
    private ViewParent b;
    private final View c;
    private boolean d;
    private int[] e;

    public j(View view) {
        this.c = view;
    }

    private void a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.a = viewParent;
                return;
            case 1:
                this.b = viewParent;
                return;
            default:
                return;
        }
    }

    private ViewParent c(int i) {
        switch (i) {
            case 0:
                return this.a;
            case 1:
                return this.b;
            default:
                return null;
        }
    }

    public void a(boolean z) {
        if (this.d) {
            o.j(this.c);
        }
        this.d = z;
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(float f, float f2) {
        ViewParent c;
        if (!a() || (c = c(0)) == null) {
            return false;
        }
        return r.a(c, this.c, f, f2);
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent c;
        if (!a() || (c = c(0)) == null) {
            return false;
        }
        return r.a(c, this.c, f, f2, z);
    }

    public boolean a(int i) {
        return c(i) != null;
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (!a()) {
            return false;
        }
        View view = this.c;
        for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
            if (r.a(parent, view, this.c, i, i2)) {
                a(i2, parent);
                r.b(parent, view, this.c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent c;
        int i6;
        int i7;
        if (!a() || (c = c(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        r.a(c, this.c, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent c;
        int i4;
        int i5;
        if (!a() || (c = c(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        r.a(c, this.c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public void b(int i) {
        ViewParent c = c(i);
        if (c != null) {
            r.a(c, this.c, i);
            a(i, (ViewParent) null);
        }
    }
}
