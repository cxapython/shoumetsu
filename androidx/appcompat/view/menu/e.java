package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.y;
import androidx.appcompat.widget.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends k implements View.OnKeyListener, PopupWindow.OnDismissListener, m {
    private static final int g = a.g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    final Handler a;
    View d;
    ViewTreeObserver e;
    boolean f;
    private final Context h;
    private final int i;
    private final int j;
    private final int k;
    private final boolean l;
    private View r;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean y;
    private m.a z;
    private final List<g> m = new ArrayList();
    final List<a> b = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener c = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.e.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!e.this.d() || e.this.b.size() <= 0 || e.this.b.get(0).a.g()) {
                return;
            }
            View view = e.this.d;
            if (view == null || !view.isShown()) {
                e.this.c();
                return;
            }
            for (a aVar : e.this.b) {
                aVar.a.a();
            }
        }
    };
    private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.e.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (e.this.e != null) {
                if (!e.this.e.isAlive()) {
                    e.this.e = view.getViewTreeObserver();
                }
                e.this.e.removeGlobalOnLayoutListener(e.this.c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final y o = new y() { // from class: androidx.appcompat.view.menu.e.3
        @Override // androidx.appcompat.widget.y
        public void a(g gVar, MenuItem menuItem) {
            e.this.a.removeCallbacksAndMessages(gVar);
        }

        @Override // androidx.appcompat.widget.y
        public void b(final g gVar, final MenuItem menuItem) {
            final a aVar = null;
            e.this.a.removeCallbacksAndMessages(null);
            int size = e.this.b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == e.this.b.get(i).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            if (i2 < e.this.b.size()) {
                aVar = e.this.b.get(i2);
            }
            e.this.a.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.e.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        e.this.f = true;
                        aVar.b.a(false);
                        e.this.f = false;
                    }
                    if (!menuItem.isEnabled() || !menuItem.hasSubMenu()) {
                        return;
                    }
                    gVar.a(menuItem, 4);
                }
            }, gVar, SystemClock.uptimeMillis() + 200);
        }
    };
    private int p = 0;
    private int q = 0;
    private boolean x = false;
    private int s = i();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public final z a;
        public final g b;
        public final int c;

        public a(z zVar, g gVar, int i) {
            this.a = zVar;
            this.b = gVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.e();
        }
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.h = context;
        this.r = view;
        this.j = i;
        this.k = i2;
        this.l = z;
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    private MenuItem a(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, g gVar) {
        f fVar;
        int i;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.b, gVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (a2 == fVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1 || (firstVisiblePosition = (i2 + i) - a3.getFirstVisiblePosition()) < 0 || firstVisiblePosition >= a3.getChildCount()) {
            return null;
        }
        return a3.getChildAt(firstVisiblePosition);
    }

    private void c(g gVar) {
        a aVar;
        View view;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.h);
        f fVar = new f(gVar, from, this.l, g);
        if (!d() && this.x) {
            fVar.a(true);
        } else if (d()) {
            fVar.a(k.b(gVar));
        }
        int a2 = a(fVar, null, this.h, this.i);
        z h = h();
        h.a((ListAdapter) fVar);
        h.g(a2);
        h.e(this.q);
        if (this.b.size() > 0) {
            List<a> list = this.b;
            aVar = list.get(list.size() - 1);
            view = a(aVar, gVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            h.c(false);
            h.a((Object) null);
            int d = d(a2);
            boolean z = d == 1;
            this.s = d;
            if (Build.VERSION.SDK_INT >= 26) {
                h.b(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.q & 7) == 5) {
                    iArr[0] = iArr[0] + this.r.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.q & 5) == 5) {
                if (!z) {
                    a2 = view.getWidth();
                    i3 = i - a2;
                }
                i3 = i + a2;
            } else {
                if (z) {
                    a2 = view.getWidth();
                    i3 = i + a2;
                }
                i3 = i - a2;
            }
            h.c(i3);
            h.b(true);
            h.d(i2);
        } else {
            if (this.t) {
                h.c(this.v);
            }
            if (this.u) {
                h.d(this.w);
            }
            h.a(g());
        }
        this.b.add(new a(h, gVar, this.s));
        h.a();
        ListView e = h.e();
        e.setOnKeyListener(this);
        if (aVar != null || !this.y || gVar.m() == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) from.inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) e, false);
        frameLayout.setEnabled(false);
        ((TextView) frameLayout.findViewById(16908310)).setText(gVar.m());
        e.addHeaderView(frameLayout, null, false);
        h.a();
    }

    private int d(int i) {
        List<a> list = this.b;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.d.getWindowVisibleDisplayFrame(rect);
        return this.s == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private int d(g gVar) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (gVar == this.b.get(i).b) {
                return i;
            }
        }
        return -1;
    }

    private z h() {
        z zVar = new z(this.h, null, this.j, this.k);
        zVar.a(this.o);
        zVar.a((AdapterView.OnItemClickListener) this);
        zVar.a((PopupWindow.OnDismissListener) this);
        zVar.b(this.r);
        zVar.e(this.q);
        zVar.a(true);
        zVar.h(2);
        return zVar;
    }

    private int i() {
        return androidx.core.g.o.b(this.r) == 1 ? 0 : 1;
    }

    @Override // androidx.appcompat.view.menu.q
    public void a() {
        if (d()) {
            return;
        }
        for (g gVar : this.m) {
            c(gVar);
        }
        this.m.clear();
        this.d = this.r;
        if (this.d == null) {
            return;
        }
        boolean z = this.e == null;
        this.e = this.d.getViewTreeObserver();
        if (z) {
            this.e.addOnGlobalLayoutListener(this.c);
        }
        this.d.addOnAttachStateChangeListener(this.n);
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(int i) {
        if (this.p != i) {
            this.p = i;
            this.q = androidx.core.g.c.a(i, androidx.core.g.o.b(this.r));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(View view) {
        if (this.r != view) {
            this.r = view;
            this.q = androidx.core.g.c.a(this.p, androidx.core.g.o.b(this.r));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(g gVar) {
        gVar.a(this, this.h);
        if (d()) {
            c(gVar);
        } else {
            this.m.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z) {
        int d = d(gVar);
        if (d < 0) {
            return;
        }
        int i = d + 1;
        if (i < this.b.size()) {
            this.b.get(i).b.a(false);
        }
        a remove = this.b.remove(d);
        remove.b.a(this);
        if (this.f) {
            remove.a.b((Object) null);
            remove.a.b(0);
        }
        remove.a.c();
        int size = this.b.size();
        this.s = size > 0 ? this.b.get(size - 1).c : i();
        if (size != 0) {
            if (!z) {
                return;
            }
            this.b.get(0).b.a(false);
            return;
        }
        c();
        m.a aVar = this.z;
        if (aVar != null) {
            aVar.a(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.e;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.e.removeGlobalOnLayoutListener(this.c);
            }
            this.e = null;
        }
        this.d.removeOnAttachStateChangeListener(this.n);
        this.A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
        this.z = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        for (a aVar : this.b) {
            a(aVar.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(s sVar) {
        for (a aVar : this.b) {
            if (sVar == aVar.b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (sVar.hasVisibleItems()) {
            a((g) sVar);
            m.a aVar2 = this.z;
            if (aVar2 != null) {
                aVar2.a(sVar);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(int i) {
        this.t = true;
        this.v = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(boolean z) {
        this.x = z;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.q
    public void c() {
        int size = this.b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.b.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.a.d()) {
                    aVar.a.c();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(int i) {
        this.u = true;
        this.w = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(boolean z) {
        this.y = z;
    }

    @Override // androidx.appcompat.view.menu.q
    public boolean d() {
        return this.b.size() > 0 && this.b.get(0).a.d();
    }

    @Override // androidx.appcompat.view.menu.q
    public ListView e() {
        if (this.b.isEmpty()) {
            return null;
        }
        List<a> list = this.b;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.k
    protected boolean f() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.b.get(i);
            if (!aVar.a.d()) {
                break;
            }
            i++;
        }
        if (aVar != null) {
            aVar.b.a(false);
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
