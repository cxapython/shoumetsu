package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class ak implements r {
    Toolbar a;
    CharSequence b;
    Window.Callback c;
    boolean d;
    private int e;
    private View f;
    private Drawable g;
    private Drawable h;
    private Drawable i;
    private boolean j;
    private CharSequence k;
    private CharSequence l;
    private int m;
    private int n;
    private Drawable o;

    public ak(Toolbar toolbar, boolean z) {
        this(toolbar, z, a.h.abc_action_bar_up_description, a.e.abc_ic_ab_back_material);
    }

    public ak(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.m = 0;
        this.n = 0;
        this.a = toolbar;
        this.b = toolbar.getTitle();
        this.k = toolbar.getSubtitle();
        this.j = this.b != null;
        this.i = toolbar.getNavigationIcon();
        aj a = aj.a(toolbar.getContext(), null, a.j.ActionBar, a.C0010a.actionBarStyle, 0);
        this.o = a.a(a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence b = a.b(a.j.ActionBar_title);
            if (!TextUtils.isEmpty(b)) {
                b(b);
            }
            CharSequence b2 = a.b(a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(b2)) {
                c(b2);
            }
            Drawable a2 = a.a(a.j.ActionBar_logo);
            if (a2 != null) {
                b(a2);
            }
            Drawable a3 = a.a(a.j.ActionBar_icon);
            if (a3 != null) {
                a(a3);
            }
            if (this.i == null && (drawable = this.o) != null) {
                c(drawable);
            }
            d(a.a(a.j.ActionBar_displayOptions, 0));
            int g = a.g(a.j.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                a(LayoutInflater.from(this.a.getContext()).inflate(g, (ViewGroup) this.a, false));
                d(this.e | 16);
            }
            int f = a.f(a.j.ActionBar_height, 0);
            if (f > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = f;
                this.a.setLayoutParams(layoutParams);
            }
            int d = a.d(a.j.ActionBar_contentInsetStart, -1);
            int d2 = a.d(a.j.ActionBar_contentInsetEnd, -1);
            if (d >= 0 || d2 >= 0) {
                this.a.a(Math.max(d, 0), Math.max(d2, 0));
            }
            int g2 = a.g(a.j.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.a(toolbar2.getContext(), g2);
            }
            int g3 = a.g(a.j.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.b(toolbar3.getContext(), g3);
            }
            int g4 = a.g(a.j.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.a.setPopupTheme(g4);
            }
        } else {
            this.e = c();
        }
        a.a();
        c(i);
        this.l = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ak.1
            final androidx.appcompat.view.menu.a a;

            {
                this.a = new androidx.appcompat.view.menu.a(ak.this.a.getContext(), 0, 16908332, 0, 0, ak.this.b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ak.this.c == null || !ak.this.d) {
                    return;
                }
                ak.this.c.onMenuItemSelected(0, this.a);
            }
        });
    }

    private int c() {
        if (this.a.getNavigationIcon() != null) {
            this.o = this.a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    private void d() {
        Drawable drawable;
        int i = this.e;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.h) == null) {
            drawable = this.g;
        }
        this.a.setLogo(drawable);
    }

    private void e() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.e & 4) != 0) {
            toolbar = this.a;
            drawable = this.i;
            if (drawable == null) {
                drawable = this.o;
            }
        } else {
            toolbar = this.a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void e(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void f() {
        if ((this.e & 4) != 0) {
            if (TextUtils.isEmpty(this.l)) {
                this.a.setNavigationContentDescription(this.n);
            } else {
                this.a.setNavigationContentDescription(this.l);
            }
        }
    }

    @Override // androidx.appcompat.widget.r
    public CharSequence a() {
        return this.a.getTitle();
    }

    @Override // androidx.appcompat.widget.r
    public void a(int i) {
        a(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    @Override // androidx.appcompat.widget.r
    public void a(Drawable drawable) {
        this.g = drawable;
        d();
    }

    public void a(View view) {
        View view2 = this.f;
        if (view2 != null && (this.e & 16) != 0) {
            this.a.removeView(view2);
        }
        this.f = view;
        if (view == null || (this.e & 16) == 0) {
            return;
        }
        this.a.addView(this.f);
    }

    @Override // androidx.appcompat.widget.r
    public void a(Window.Callback callback) {
        this.c = callback;
    }

    @Override // androidx.appcompat.widget.r
    public void a(CharSequence charSequence) {
        if (!this.j) {
            e(charSequence);
        }
    }

    public Context b() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.widget.r
    public void b(int i) {
        b(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    public void b(Drawable drawable) {
        this.h = drawable;
        d();
    }

    public void b(CharSequence charSequence) {
        this.j = true;
        e(charSequence);
    }

    public void c(int i) {
        if (i == this.n) {
            return;
        }
        this.n = i;
        if (!TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            return;
        }
        e(this.n);
    }

    public void c(Drawable drawable) {
        this.i = drawable;
        e();
    }

    public void c(CharSequence charSequence) {
        this.k = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void d(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    f();
                }
                e();
            }
            if ((i2 & 3) != 0) {
                d();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.b);
                    toolbar = this.a;
                    charSequence = this.k;
                } else {
                    charSequence = null;
                    this.a.setTitle((CharSequence) null);
                    toolbar = this.a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || (view = this.f) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    public void d(CharSequence charSequence) {
        this.l = charSequence;
        f();
    }

    public void e(int i) {
        d(i == 0 ? null : b().getString(i));
    }
}
