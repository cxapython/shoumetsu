package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.a;

/* loaded from: classes.dex */
class f {
    private final View a;
    private ah d;
    private ah e;
    private ah f;
    private int c = -1;
    private final g b = g.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(View view) {
        this.a = view;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new ah();
        }
        ah ahVar = this.f;
        ahVar.a();
        ColorStateList h = androidx.core.g.o.h(this.a);
        if (h != null) {
            ahVar.d = true;
            ahVar.a = h;
        }
        PorterDuff.Mode i = androidx.core.g.o.i(this.a);
        if (i != null) {
            ahVar.c = true;
            ahVar.b = i;
        }
        if (ahVar.d || ahVar.c) {
            g.a(drawable, ahVar, this.a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a() {
        ah ahVar = this.e;
        if (ahVar != null) {
            return ahVar.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
        g gVar = this.b;
        b(gVar != null ? gVar.b(this.a.getContext(), i) : null);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new ah();
        }
        ah ahVar = this.e;
        ahVar.a = colorStateList;
        ahVar.d = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new ah();
        }
        ah ahVar = this.e;
        ahVar.b = mode;
        ahVar.c = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.c = -1;
        b((ColorStateList) null);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        aj a = aj.a(this.a.getContext(), attributeSet, a.j.ViewBackgroundHelper, i, 0);
        try {
            if (a.f(a.j.ViewBackgroundHelper_android_background)) {
                this.c = a.g(a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.b.b(this.a.getContext(), this.c);
                if (b != null) {
                    b(b);
                }
            }
            if (a.f(a.j.ViewBackgroundHelper_backgroundTint)) {
                androidx.core.g.o.a(this.a, a.d(a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.f(a.j.ViewBackgroundHelper_backgroundTintMode)) {
                androidx.core.g.o.a(this.a, s.a(a.a(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        ah ahVar = this.e;
        if (ahVar != null) {
            return ahVar.b;
        }
        return null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new ah();
            }
            ah ahVar = this.d;
            ahVar.a = colorStateList;
            ahVar.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (d() && b(background)) {
                return;
            }
            ah ahVar = this.e;
            if (ahVar == null && (ahVar = this.d) == null) {
                return;
            }
            g.a(background, ahVar, this.a.getDrawableState());
        }
    }
}
