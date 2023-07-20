package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.w;
import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes.dex */
public class ActionMenuView extends w implements g.b, androidx.appcompat.view.menu.n {
    g.a a;
    e b;
    private androidx.appcompat.view.menu.g c;
    private Context d;
    private int e;
    private boolean f;
    private androidx.appcompat.widget.c g;
    private m.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* loaded from: classes.dex */
    public interface a {
        boolean c();

        boolean d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements m.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends w.a {
        @ViewDebug.ExportedProperty
        public boolean a;
        @ViewDebug.ExportedProperty
        public int b;
        @ViewDebug.ExportedProperty
        public int c;
        @ViewDebug.ExportedProperty
        public boolean d;
        @ViewDebug.ExportedProperty
        public boolean e;
        boolean f;

        public c(int i, int i2) {
            super(i, i2);
            this.a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.a = cVar.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
            if (ActionMenuView.this.a != null) {
                ActionMenuView.this.a.a(gVar);
            }
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return ActionMenuView.this.b != null && ActionMenuView.this.b.a(menuItem);
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (f * 4.0f);
        this.d = context;
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.b();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, BleSignal.UNKNOWN_TX_POWER), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (cVar.a || !z2) {
            z = false;
        }
        cVar.d = z;
        cVar.b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x023e A[LOOP:5: B:139:0x023e->B:144:0x025d, LOOP_START, PHI: r13 
      PHI: (r13v4 int) = (r13v3 int), (r13v5 int) binds: [B:138:0x023c, B:144:0x025d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0265  */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        int i7;
        int i8;
        int i9;
        ?? r13;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i10 = size - paddingLeft;
        int i11 = this.k;
        int i12 = i10 / i11;
        int i13 = i10 % i11;
        if (i12 == 0) {
            setMeasuredDimension(i10, 0);
            return;
        }
        int i14 = i11 + (i13 / i12);
        int childCount = getChildCount();
        int i15 = i12;
        int i16 = 0;
        int i17 = 0;
        boolean z3 = false;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        long j = 0;
        while (i16 < childCount) {
            View childAt = getChildAt(i16);
            int i21 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z4 = childAt instanceof ActionMenuItemView;
                int i22 = i18 + 1;
                if (z4) {
                    int i23 = this.l;
                    i9 = i22;
                    r13 = 0;
                    childAt.setPadding(i23, 0, i23, 0);
                } else {
                    i9 = i22;
                    r13 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f = r13;
                int i24 = r13 == true ? 1 : 0;
                int i25 = r13 == true ? 1 : 0;
                cVar.c = i24;
                cVar.b = r13;
                cVar.d = r13;
                cVar.leftMargin = r13;
                cVar.rightMargin = r13;
                cVar.e = z4 && ((ActionMenuItemView) childAt).b();
                int a2 = a(childAt, i14, cVar.a ? 1 : i15, childMeasureSpec, paddingTop);
                int max = Math.max(i19, a2);
                if (cVar.d) {
                    i20++;
                }
                if (cVar.a) {
                    z3 = true;
                }
                i15 -= a2;
                i17 = Math.max(i17, childAt.getMeasuredHeight());
                if (a2 == 1) {
                    j |= 1 << i16;
                    i17 = i17;
                }
                i19 = max;
                i18 = i9;
            }
            i16++;
            size2 = i21;
        }
        int i26 = size2;
        boolean z5 = z3 && i18 == 2;
        boolean z6 = false;
        while (i20 > 0 && i15 > 0) {
            int i27 = Integer.MAX_VALUE;
            int i28 = 0;
            int i29 = 0;
            long j2 = 0;
            while (i28 < childCount) {
                boolean z7 = z6;
                c cVar2 = (c) getChildAt(i28).getLayoutParams();
                int i30 = i17;
                if (cVar2.d) {
                    if (cVar2.b < i27) {
                        i27 = cVar2.b;
                        j2 = 1 << i28;
                        i29 = 1;
                    } else if (cVar2.b == i27) {
                        j2 |= 1 << i28;
                        i29++;
                    }
                }
                i28++;
                i17 = i30;
                z6 = z7;
            }
            z = z6;
            i5 = i17;
            j |= j2;
            if (i29 > i15) {
                i3 = mode;
                i4 = i10;
                break;
            }
            int i31 = i27 + 1;
            int i32 = 0;
            while (i32 < childCount) {
                View childAt2 = getChildAt(i32);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i33 = i10;
                int i34 = mode;
                long j3 = 1 << i32;
                if ((j2 & j3) == 0) {
                    if (cVar3.b == i31) {
                        j |= j3;
                    }
                    i8 = i31;
                } else {
                    if (!z5 || !cVar3.e || i15 != 1) {
                        i8 = i31;
                    } else {
                        int i35 = this.l;
                        i8 = i31;
                        childAt2.setPadding(i35 + i14, 0, i35, 0);
                    }
                    cVar3.b++;
                    cVar3.f = true;
                    i15--;
                }
                i32++;
                mode = i34;
                i31 = i8;
                i10 = i33;
            }
            i17 = i5;
            z6 = true;
        }
        i3 = mode;
        i4 = i10;
        z = z6;
        i5 = i17;
        if (!z3) {
            i6 = 1;
            if (i18 == 1) {
                z2 = true;
                if (i15 > 0 || j == 0 || (i15 >= i18 - i6 && !z2 && i19 <= i6)) {
                    i7 = 0;
                } else {
                    float bitCount = Long.bitCount(j);
                    if (!z2) {
                        if ((j & 1) != 0) {
                            i7 = 0;
                            if (!((c) getChildAt(0).getLayoutParams()).e) {
                                bitCount -= 0.5f;
                            }
                        } else {
                            i7 = 0;
                        }
                        int i36 = childCount - 1;
                        if ((j & (1 << i36)) != 0 && !((c) getChildAt(i36).getLayoutParams()).e) {
                            bitCount -= 0.5f;
                        }
                    } else {
                        i7 = 0;
                    }
                    int i37 = bitCount > 0.0f ? (int) ((i15 * i14) / bitCount) : 0;
                    for (int i38 = 0; i38 < childCount; i38++) {
                        if ((j & (1 << i38)) != 0) {
                            View childAt3 = getChildAt(i38);
                            c cVar4 = (c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                cVar4.c = i37;
                                cVar4.f = true;
                                if (i38 == 0 && !cVar4.e) {
                                    cVar4.leftMargin = (-i37) / 2;
                                }
                            } else if (cVar4.a) {
                                cVar4.c = i37;
                                cVar4.f = true;
                                cVar4.rightMargin = (-i37) / 2;
                            } else {
                                if (i38 != 0) {
                                    cVar4.leftMargin = i37 / 2;
                                }
                                if (i38 != childCount - 1) {
                                    cVar4.rightMargin = i37 / 2;
                                }
                            }
                            z = true;
                        }
                    }
                }
                if (z) {
                    while (i7 < childCount) {
                        View childAt4 = getChildAt(i7);
                        c cVar5 = (c) childAt4.getLayoutParams();
                        if (cVar5.f) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.b * i14) + cVar5.c, 1073741824), childMeasureSpec);
                        }
                        i7++;
                    }
                }
                setMeasuredDimension(i4, i3 == 1073741824 ? i5 : i26);
            }
        } else {
            i6 = 1;
        }
        z2 = false;
        if (i15 > 0) {
        }
        i7 = 0;
        if (z) {
        }
        setMeasuredDimension(i4, i3 == 1073741824 ? i5 : i26);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.w, android.view.ViewGroup
    /* renamed from: a */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.w, android.view.ViewGroup
    /* renamed from: a */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.w, android.view.ViewGroup
    /* renamed from: a */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
            if (cVar.h <= 0) {
                cVar.h = 16;
            }
            return cVar;
        }
        return generateDefaultLayoutParams();
    }

    public void a(androidx.appcompat.view.menu.g gVar) {
        this.c = gVar;
    }

    public void a(m.a aVar, g.a aVar2) {
        this.h = aVar;
        this.a = aVar2;
    }

    protected boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).d();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).c();
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(androidx.appcompat.view.menu.h hVar) {
        return this.c.a(hVar, 0);
    }

    public c b() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.a = true;
        return generateDefaultLayoutParams;
    }

    public androidx.appcompat.view.menu.g c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.w, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public boolean d() {
        androidx.appcompat.widget.c cVar = this.g;
        return cVar != null && cVar.d();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        androidx.appcompat.widget.c cVar = this.g;
        return cVar != null && cVar.h();
    }

    public void f() {
        androidx.appcompat.widget.c cVar = this.g;
        if (cVar != null) {
            cVar.f();
        }
    }

    public Menu getMenu() {
        if (this.c == null) {
            Context context = getContext();
            this.c = new androidx.appcompat.view.menu.g(context);
            this.c.a(new d());
            this.g = new androidx.appcompat.widget.c(context);
            this.g.b(true);
            androidx.appcompat.widget.c cVar = this.g;
            m.a aVar = this.h;
            if (aVar == null) {
                aVar = new b();
            }
            cVar.a(aVar);
            this.c.a(this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.c();
    }

    public int getPopupTheme() {
        return this.e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.c cVar = this.g;
        if (cVar != null) {
            cVar.a(false);
            if (!this.g.h()) {
                return;
            }
            this.g.e();
            this.g.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.w, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int i7;
        if (!this.i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i3 - i;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = ap.a(this);
        int i10 = paddingRight;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (a(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i7 = getPaddingLeft() + cVar.leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i14 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i14, width, measuredHeight + i14);
                    i10 -= measuredWidth;
                    i11 = 1;
                } else {
                    i10 -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    a(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i9 / 2) - (measuredWidth2 / 2);
            int i16 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        if (i17 > 0) {
            i6 = i10 / i17;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int max = Math.max(i5, i6);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.a) {
                    int i18 = width2 - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
                i5++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.a) {
                int i20 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + cVar3.rightMargin + max;
            }
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.w, android.view.View
    public void onMeasure(int i, int i2) {
        androidx.appcompat.view.menu.g gVar;
        boolean z = this.i;
        this.i = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.i) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.i && (gVar = this.c) != null && size != this.j) {
            this.j = size;
            gVar.b(true);
        }
        int childCount = getChildCount();
        if (this.i && childCount > 0) {
            c(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            cVar.rightMargin = 0;
            cVar.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.c(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.b = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    public void setPopupTheme(int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.g = cVar;
        this.g.a(this);
    }
}
