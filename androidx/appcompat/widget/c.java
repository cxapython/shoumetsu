package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.g.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
class c extends androidx.appcompat.view.menu.b implements b.a {
    private b A;
    d g;
    e h;
    a i;
    RunnableC0016c j;
    final f k;
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y;
    private View z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.s sVar, View view) {
            super(context, sVar, view, false, a.C0010a.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.h) sVar.getItem()).j()) {
                a(c.this.g == null ? (View) c.this.f : c.this.g);
            }
            a(c.this.k);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            c cVar = c.this;
            cVar.i = null;
            cVar.l = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.q a() {
            if (c.this.i != null) {
                return c.this.i.b();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0016c implements Runnable {
        private e b;

        public RunnableC0016c(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.c != null) {
                c.this.c.f();
            }
            View view = (View) c.this.f;
            if (view != null && view.getWindowToken() != null && this.b.c()) {
                c.this.h = this.b;
            }
            c.this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends l implements ActionMenuView.a {
        private final float[] b;

        public d(Context context) {
            super(context, null, a.C0010a.actionOverflowButtonStyle);
            this.b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            al.a(this, getContentDescription());
            setOnTouchListener(new v(this) { // from class: androidx.appcompat.widget.c.d.1
                @Override // androidx.appcompat.widget.v
                public androidx.appcompat.view.menu.q a() {
                    if (c.this.h == null) {
                        return null;
                    }
                    return c.this.h.b();
                }

                @Override // androidx.appcompat.widget.v
                public boolean b() {
                    c.this.d();
                    return true;
                }

                @Override // androidx.appcompat.widget.v
                public boolean c() {
                    if (c.this.j != null) {
                        return false;
                    }
                    c.this.e();
                    return true;
                }
            });
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.d();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, a.C0010a.actionOverflowMenuStyle);
            a(8388613);
            a(c.this.k);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (c.this.c != null) {
                c.this.c.close();
            }
            c.this.h = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.s) {
                gVar.n().a(false);
            }
            m.a a = c.this.a();
            if (a != null) {
                a.a(gVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            if (gVar == null) {
                return false;
            }
            c.this.l = ((androidx.appcompat.view.menu.s) gVar).getItem().getItemId();
            m.a a = c.this.a();
            if (a == null) {
                return false;
            }
            return a.a(gVar);
        }
    }

    public c(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
        this.y = new SparseBooleanArray();
        this.k = new f();
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.b
    public View a(androidx.appcompat.view.menu.h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.n()) {
            actionView = super.a(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(Context context, androidx.appcompat.view.menu.g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(context);
        if (!this.p) {
            this.o = a2.b();
        }
        if (!this.v) {
            this.q = a2.c();
        }
        if (!this.t) {
            this.s = a2.a();
        }
        int i = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new d(this.a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = i;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.z = null;
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = androidx.appcompat.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void a(Drawable drawable) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.n = true;
        this.m = drawable;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        f();
        super.a(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.b
    public void a(androidx.appcompat.view.menu.h hVar, n.a aVar) {
        aVar.a(hVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(boolean z) {
        super.a(z);
        ((View) this.f).requestLayout();
        boolean z2 = false;
        if (this.c != null) {
            ArrayList<androidx.appcompat.view.menu.h> k = this.c.k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                androidx.core.g.b a2 = k.get(i).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        ArrayList<androidx.appcompat.view.menu.h> l = this.c != null ? this.c.l() : null;
        if (this.o && l != null) {
            int size2 = l.size();
            if (size2 == 1) {
                z2 = !l.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.g == null) {
                this.g = new d(this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.b());
            }
        } else {
            d dVar = this.g;
            if (dVar != null && dVar.getParent() == this.f) {
                ((ViewGroup) this.f).removeView(this.g);
            }
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(int i, androidx.appcompat.view.menu.h hVar) {
        return hVar.j();
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.g) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean a(androidx.appcompat.view.menu.s sVar) {
        boolean z = false;
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.s sVar2 = sVar;
        while (sVar2.q() != this.c) {
            sVar2 = (androidx.appcompat.view.menu.s) sVar2.q();
        }
        View a2 = a(sVar2.getItem());
        if (a2 == null) {
            return false;
        }
        this.l = sVar.getItem().getItemId();
        int size = sVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = sVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.i = new a(this.b, sVar, a2);
        this.i.a(z);
        this.i.a();
        super.a(sVar);
        return true;
    }

    public void b(boolean z) {
        this.o = z;
        this.p = true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean b() {
        ArrayList<androidx.appcompat.view.menu.h> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        c cVar = this;
        int i5 = 0;
        if (cVar.c != null) {
            arrayList = cVar.c.i();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = cVar.s;
        int i7 = cVar.r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f;
        int i8 = i6;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            androidx.appcompat.view.menu.h hVar = arrayList.get(i11);
            if (hVar.l()) {
                i9++;
            } else if (hVar.k()) {
                i10++;
            } else {
                z2 = true;
            }
            if (cVar.w && hVar.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (cVar.o && (z2 || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = cVar.y;
        sparseBooleanArray.clear();
        if (cVar.u) {
            int i13 = cVar.x;
            i3 = i7 / i13;
            i2 = i13 + ((i7 % i13) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i14 = i7;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i) {
            androidx.appcompat.view.menu.h hVar2 = arrayList.get(i15);
            if (hVar2.l()) {
                View a2 = cVar.a(hVar2, cVar.z, viewGroup);
                if (cVar.z == null) {
                    cVar.z = a2;
                }
                if (cVar.u) {
                    i3 -= ActionMenuView.a(a2, i2, i3, makeMeasureSpec, i5);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = hVar2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                hVar2.d(z);
                i4 = i;
                i16 = measuredWidth;
            } else if (hVar2.k()) {
                int groupId2 = hVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i14 > 0 && (!cVar.u || i3 > 0);
                if (z4) {
                    boolean z5 = z4;
                    View a3 = cVar.a(hVar2, cVar.z, viewGroup);
                    i4 = i;
                    if (cVar.z == null) {
                        cVar.z = a3;
                    }
                    if (cVar.u) {
                        int a4 = ActionMenuView.a(a3, i2, i3, makeMeasureSpec, 0);
                        i3 -= a4;
                        if (a4 == 0) {
                            z5 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z4 = z5 & (!cVar.u ? i14 + i16 > 0 : i14 >= 0);
                } else {
                    i4 = i;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i17 = 0; i17 < i15; i17++) {
                        androidx.appcompat.view.menu.h hVar3 = arrayList.get(i17);
                        if (hVar3.getGroupId() == groupId2) {
                            if (hVar3.j()) {
                                i12++;
                            }
                            hVar3.d(false);
                        }
                    }
                }
                if (z4) {
                    i12--;
                }
                hVar2.d(z4);
            } else {
                i4 = i;
                hVar2.d(false);
                i15++;
                i = i4;
                cVar = this;
                i5 = 0;
            }
            i15++;
            i = i4;
            cVar = this;
            i5 = 0;
        }
        return true;
    }

    public Drawable c() {
        d dVar = this.g;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (!this.n) {
            return null;
        }
        return this.m;
    }

    public void c(boolean z) {
        this.w = z;
    }

    @Override // androidx.core.g.b.a
    public void d(boolean z) {
        if (z) {
            super.a((androidx.appcompat.view.menu.s) null);
        } else if (this.c == null) {
        } else {
            this.c.a(false);
        }
    }

    public boolean d() {
        if (!this.o || h() || this.c == null || this.f == null || this.j != null || this.c.l().isEmpty()) {
            return false;
        }
        this.j = new RunnableC0016c(new e(this.b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        super.a((androidx.appcompat.view.menu.s) null);
        return true;
    }

    public boolean e() {
        if (this.j != null && this.f != null) {
            ((View) this.f).removeCallbacks(this.j);
            this.j = null;
            return true;
        }
        e eVar = this.h;
        if (eVar == null) {
            return false;
        }
        eVar.d();
        return true;
    }

    public boolean f() {
        return e() | g();
    }

    public boolean g() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.d();
            return true;
        }
        return false;
    }

    public boolean h() {
        e eVar = this.h;
        return eVar != null && eVar.f();
    }
}
