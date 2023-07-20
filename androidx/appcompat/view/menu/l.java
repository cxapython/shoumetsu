package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;

/* loaded from: classes.dex */
public class l {
    private final Context a;
    private final g b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private m.a i;
    private k j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public l(Context context, g gVar, View view, boolean z, int i) {
        this(context, gVar, view, z, i, 0);
    }

    public l(Context context, g gVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.l.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                l.this.e();
            }
        };
        this.a = context;
        this.b = gVar;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        k b = b();
        b.c(z2);
        if (z) {
            if ((androidx.core.g.c.a(this.g, androidx.core.g.o.b(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            b.b(i);
            b.c(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        b.a();
    }

    private k g() {
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        k eVar = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width) ? new e(this.a, this.f, this.d, this.e, this.c) : new r(this.a, this.b, this.f, this.d, this.e, this.c);
        eVar.a(this.b);
        eVar.a(this.l);
        eVar.a(this.f);
        eVar.a(this.i);
        eVar.b(this.h);
        eVar.a(this.g);
        return eVar;
    }

    public void a() {
        if (c()) {
            return;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(View view) {
        this.f = view;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(m.a aVar) {
        this.i = aVar;
        k kVar = this.j;
        if (kVar != null) {
            kVar.a(aVar);
        }
    }

    public void a(boolean z) {
        this.h = z;
        k kVar = this.j;
        if (kVar != null) {
            kVar.b(z);
        }
    }

    public boolean a(int i, int i2) {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    public k b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public void d() {
        if (f()) {
            this.j.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean f() {
        k kVar = this.j;
        return kVar != null && kVar.d();
    }
}
