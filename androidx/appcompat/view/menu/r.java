package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends k implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, m {
    private static final int e = a.g.abc_popup_menu_item_layout;
    final z a;
    View c;
    ViewTreeObserver d;
    private final Context f;
    private final g g;
    private final f h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private PopupWindow.OnDismissListener n;
    private View o;
    private m.a p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean u;
    final ViewTreeObserver.OnGlobalLayoutListener b = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.r.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!r.this.d() || r.this.a.g()) {
                return;
            }
            View view = r.this.c;
            if (view == null || !view.isShown()) {
                r.this.c();
            } else {
                r.this.a.a();
            }
        }
    };
    private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.r.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (r.this.d != null) {
                if (!r.this.d.isAlive()) {
                    r.this.d = view.getViewTreeObserver();
                }
                r.this.d.removeGlobalOnLayoutListener(r.this.b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int t = 0;

    public r(Context context, g gVar, View view, int i, int i2, boolean z) {
        this.f = context;
        this.g = gVar;
        this.i = z;
        this.h = new f(gVar, LayoutInflater.from(context), this.i, e);
        this.k = i;
        this.l = i2;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.o = view;
        this.a = new z(this.f, null, this.k, this.l);
        gVar.a(this, context);
    }

    private boolean h() {
        View view;
        if (d()) {
            return true;
        }
        if (this.q || (view = this.o) == null) {
            return false;
        }
        this.c = view;
        this.a.a((PopupWindow.OnDismissListener) this);
        this.a.a((AdapterView.OnItemClickListener) this);
        this.a.a(true);
        View view2 = this.c;
        boolean z = this.d == null;
        this.d = view2.getViewTreeObserver();
        if (z) {
            this.d.addOnGlobalLayoutListener(this.b);
        }
        view2.addOnAttachStateChangeListener(this.m);
        this.a.b(view2);
        this.a.e(this.t);
        if (!this.r) {
            this.s = a(this.h, null, this.f, this.j);
            this.r = true;
        }
        this.a.g(this.s);
        this.a.h(2);
        this.a.a(g());
        this.a.a();
        ListView e2 = this.a.e();
        e2.setOnKeyListener(this);
        if (this.u && this.g.m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) e2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.g.m());
            }
            frameLayout.setEnabled(false);
            e2.addHeaderView(frameLayout, null, false);
        }
        this.a.a((ListAdapter) this.h);
        this.a.a();
        return true;
    }

    @Override // androidx.appcompat.view.menu.q
    public void a() {
        if (h()) {
            return;
        }
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(int i) {
        this.t = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(View view) {
        this.o = view;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(g gVar) {
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z) {
        if (gVar != this.g) {
            return;
        }
        c();
        m.a aVar = this.p;
        if (aVar == null) {
            return;
        }
        aVar.a(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        this.r = false;
        f fVar = this.h;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(s sVar) {
        if (sVar.hasVisibleItems()) {
            l lVar = new l(this.f, sVar, this.c, this.i, this.k, this.l);
            lVar.a(this.p);
            lVar.a(k.b(sVar));
            lVar.a(this.n);
            this.n = null;
            this.g.a(false);
            int j = this.a.j();
            int k = this.a.k();
            if ((Gravity.getAbsoluteGravity(this.t, androidx.core.g.o.b(this.o)) & 7) == 5) {
                j += this.o.getWidth();
            }
            if (lVar.a(j, k)) {
                m.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(sVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(int i) {
        this.a.c(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(boolean z) {
        this.h.a(z);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.q
    public void c() {
        if (d()) {
            this.a.c();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(int i) {
        this.a.d(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(boolean z) {
        this.u = z;
    }

    @Override // androidx.appcompat.view.menu.q
    public boolean d() {
        return !this.q && this.a.d();
    }

    @Override // androidx.appcompat.view.menu.q
    public ListView e() {
        return this.a.e();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.q = true;
        this.g.close();
        ViewTreeObserver viewTreeObserver = this.d;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.d = this.c.getViewTreeObserver();
            }
            this.d.removeGlobalOnLayoutListener(this.b);
            this.d = null;
        }
        this.c.removeOnAttachStateChangeListener(this.m);
        PopupWindow.OnDismissListener onDismissListener = this.n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            c();
            return true;
        }
        return false;
    }
}
