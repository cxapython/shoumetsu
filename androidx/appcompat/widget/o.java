package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.core.a.a.f;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class o {
    private final TextView a;
    private ah b;
    private ah c;
    private ah d;
    private ah e;
    private ah f;
    private ah g;
    private final q h;
    private int i = 0;
    private Typeface j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TextView textView) {
        this.a = textView;
        this.h = new q(this.a);
    }

    private static ah a(Context context, g gVar, int i) {
        ColorStateList b = gVar.b(context, i);
        if (b != null) {
            ah ahVar = new ah();
            ahVar.d = true;
            ahVar.a = b;
            return ahVar;
        }
        return null;
    }

    private void a(Context context, aj ajVar) {
        String c;
        Typeface typeface;
        this.i = ajVar.a(a.j.TextAppearance_android_textStyle, this.i);
        boolean z = true;
        if (ajVar.f(a.j.TextAppearance_android_fontFamily) || ajVar.f(a.j.TextAppearance_fontFamily)) {
            this.j = null;
            int i = ajVar.f(a.j.TextAppearance_fontFamily) ? a.j.TextAppearance_fontFamily : a.j.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.a);
                try {
                    this.j = ajVar.a(i, this.i, new f.a() { // from class: androidx.appcompat.widget.o.1
                        @Override // androidx.core.a.a.f.a
                        public void a(int i2) {
                        }

                        @Override // androidx.core.a.a.f.a
                        public void a(Typeface typeface2) {
                            o.this.a(weakReference, typeface2);
                        }
                    });
                    if (this.j != null) {
                        z = false;
                    }
                    this.k = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.j != null || (c = ajVar.c(i)) == null) {
                return;
            }
            this.j = Typeface.create(c, this.i);
        } else if (!ajVar.f(a.j.TextAppearance_android_typeface)) {
        } else {
            this.k = false;
            switch (ajVar.a(a.j.TextAppearance_android_typeface, 1)) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    return;
            }
            this.j = typeface;
        }
    }

    private void a(Drawable drawable, ah ahVar) {
        if (drawable == null || ahVar == null) {
            return;
        }
        g.a(drawable, ahVar, this.a.getDrawableState());
    }

    private void b(int i, float f) {
        this.h.a(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        if (androidx.core.widget.b.d || c()) {
            return;
        }
        b(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        this.h.a(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i) {
        ColorStateList d;
        aj a = aj.a(context, i, a.j.TextAppearance);
        if (a.f(a.j.TextAppearance_textAllCaps)) {
            a(a.a(a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a.f(a.j.TextAppearance_android_textColor) && (d = a.d(a.j.TextAppearance_android_textColor)) != null) {
            this.a.setTextColor(d);
        }
        if (a.f(a.j.TextAppearance_android_textSize) && a.e(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        a(context, a);
        a.a();
        Typeface typeface = this.j;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        Context context = this.a.getContext();
        g a = g.a();
        aj a2 = aj.a(context, attributeSet, a.j.AppCompatTextHelper, i, 0);
        int g = a2.g(a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.f(a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.f(a.j.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.f(a.j.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.f(a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a2.f(a.j.AppCompatTextHelper_android_drawableStart)) {
                this.f = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a2.f(a.j.AppCompatTextHelper_android_drawableEnd)) {
                this.g = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a2.a();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        ColorStateList colorStateList3 = null;
        if (g != -1) {
            aj a3 = aj.a(context, g, a.j.TextAppearance);
            if (z3 || !a3.f(a.j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a3.a(a.j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, a3);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList d = a3.f(a.j.TextAppearance_android_textColor) ? a3.d(a.j.TextAppearance_android_textColor) : null;
                colorStateList2 = a3.f(a.j.TextAppearance_android_textColorHint) ? a3.d(a.j.TextAppearance_android_textColorHint) : null;
                if (a3.f(a.j.TextAppearance_android_textColorLink)) {
                    colorStateList3 = a3.d(a.j.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList4 = d;
                colorStateList = colorStateList3;
                colorStateList3 = colorStateList4;
            } else {
                colorStateList = null;
                colorStateList2 = null;
            }
            a3.a();
        } else {
            colorStateList = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
        }
        aj a4 = aj.a(context, attributeSet, a.j.TextAppearance, i, 0);
        if (z3 || !a4.f(a.j.TextAppearance_textAllCaps)) {
            z4 = z;
        } else {
            z2 = a4.a(a.j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a4.f(a.j.TextAppearance_android_textColor)) {
                colorStateList3 = a4.d(a.j.TextAppearance_android_textColor);
            }
            if (a4.f(a.j.TextAppearance_android_textColorHint)) {
                colorStateList2 = a4.d(a.j.TextAppearance_android_textColorHint);
            }
            if (a4.f(a.j.TextAppearance_android_textColorLink)) {
                colorStateList = a4.d(a.j.TextAppearance_android_textColorLink);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && a4.f(a.j.TextAppearance_android_textSize) && a4.e(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        a(context, a4);
        a4.a();
        if (colorStateList3 != null) {
            this.a.setTextColor(colorStateList3);
        }
        if (colorStateList2 != null) {
            this.a.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.a.setLinkTextColor(colorStateList);
        }
        if (!z3 && z4) {
            a(z2);
        }
        Typeface typeface = this.j;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.i);
        }
        this.h.a(attributeSet, i);
        if (androidx.core.widget.b.d && this.h.a() != 0) {
            int[] e = this.h.e();
            if (e.length > 0) {
                if (this.a.getAutoSizeStepGranularity() != -1.0f) {
                    this.a.setAutoSizeTextTypeUniformWithConfiguration(this.h.c(), this.h.d(), this.h.b(), 0);
                } else {
                    this.a.setAutoSizeTextTypeUniformWithPresetSizes(e, 0);
                }
            }
        }
        aj a5 = aj.a(context, attributeSet, a.j.AppCompatTextView);
        int e2 = a5.e(a.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int e3 = a5.e(a.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int e4 = a5.e(a.j.AppCompatTextView_lineHeight, -1);
        a5.a();
        if (e2 != -1) {
            androidx.core.widget.h.a(this.a, e2);
        }
        if (e3 != -1) {
            androidx.core.widget.h.b(this.a, e3);
        }
        if (e4 != -1) {
            androidx.core.widget.h.c(this.a, e4);
        }
    }

    void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.k) {
            this.j = typeface;
            TextView textView = weakReference.get();
            if (textView == null) {
                return;
            }
            textView.setTypeface(typeface, this.i);
        }
    }

    void a(boolean z) {
        this.a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i, int i2, int i3, int i4) {
        if (!androidx.core.widget.b.d) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr, int i) {
        this.h.a(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.h.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.h.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.h.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.h.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.h.e();
    }
}
