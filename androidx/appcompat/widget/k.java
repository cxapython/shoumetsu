package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class k {
    private final ImageView a;
    private ah b;
    private ah c;
    private ah d;

    public k(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new ah();
        }
        ah ahVar = this.d;
        ahVar.a();
        ColorStateList a = androidx.core.widget.d.a(this.a);
        if (a != null) {
            ahVar.d = true;
            ahVar.a = a;
        }
        PorterDuff.Mode b = androidx.core.widget.d.b(this.a);
        if (b != null) {
            ahVar.c = true;
            ahVar.b = b;
        }
        if (ahVar.d || ahVar.c) {
            g.a(drawable, ahVar, this.a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b = androidx.appcompat.a.a.a.b(this.a.getContext(), i);
            if (b != null) {
                s.a(b);
            }
            this.a.setImageDrawable(b);
        } else {
            this.a.setImageDrawable(null);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new ah();
        }
        ah ahVar = this.c;
        ahVar.a = colorStateList;
        ahVar.d = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new ah();
        }
        ah ahVar = this.c;
        ahVar.b = mode;
        ahVar.c = true;
        d();
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        aj a = aj.a(this.a.getContext(), attributeSet, a.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (g = a.g(a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.a.a.a.b(this.a.getContext(), g)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                s.a(drawable);
            }
            if (a.f(a.j.AppCompatImageView_tint)) {
                androidx.core.widget.d.a(this.a, a.d(a.j.AppCompatImageView_tint));
            }
            if (a.f(a.j.AppCompatImageView_tintMode)) {
                androidx.core.widget.d.a(this.a, s.a(a.a(a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        ah ahVar = this.c;
        if (ahVar != null) {
            return ahVar.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        ah ahVar = this.c;
        if (ahVar != null) {
            return ahVar.b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            s.a(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            ah ahVar = this.c;
            if (ahVar == null && (ahVar = this.b) == null) {
                return;
            }
            g.a(drawable, ahVar, this.a.getDrawableState());
        }
    }
}
