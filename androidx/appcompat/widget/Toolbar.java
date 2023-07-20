package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    private final ActionMenuView.e H;
    private ak I;
    private androidx.appcompat.widget.c J;
    private a K;
    private m.a L;
    private g.a M;
    private boolean N;
    private final Runnable O;
    ImageButton a;
    View b;
    int c;
    c d;
    private ActionMenuView e;
    private TextView f;
    private TextView g;
    private ImageButton h;
    private ImageView i;
    private Drawable j;
    private CharSequence k;
    private Context l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private ab u;
    private int v;
    private int w;
    private int x;
    private CharSequence y;
    private CharSequence z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.appcompat.view.menu.m {
        androidx.appcompat.view.menu.g a;
        androidx.appcompat.view.menu.h b;

        a() {
        }

        @Override // androidx.appcompat.view.menu.m
        public void a(Context context, androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.h hVar;
            androidx.appcompat.view.menu.g gVar2 = this.a;
            if (gVar2 != null && (hVar = this.b) != null) {
                gVar2.d(hVar);
            }
            this.a = gVar;
        }

        @Override // androidx.appcompat.view.menu.m
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void a(m.a aVar) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void a(boolean z) {
            if (this.b != null) {
                androidx.appcompat.view.menu.g gVar = this.a;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.a.getItem(i) == this.b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                b(this.a, this.b);
            }
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean a(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.h hVar) {
            Toolbar.this.d();
            ViewParent parent = Toolbar.this.a.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.a);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.a);
            }
            Toolbar.this.b = hVar.getActionView();
            this.b = hVar;
            ViewParent parent2 = Toolbar.this.b.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.b);
                }
                b generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.a = 8388611 | (Toolbar.this.c & 112);
                generateDefaultLayoutParams.b = 2;
                Toolbar.this.b.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar4 = Toolbar.this;
                toolbar4.addView(toolbar4.b);
            }
            Toolbar.this.f();
            Toolbar.this.requestLayout();
            hVar.e(true);
            if (Toolbar.this.b instanceof androidx.appcompat.view.b) {
                ((androidx.appcompat.view.b) Toolbar.this.b).a();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean a(androidx.appcompat.view.menu.s sVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean b() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean b(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.h hVar) {
            if (Toolbar.this.b instanceof androidx.appcompat.view.b) {
                ((androidx.appcompat.view.b) Toolbar.this.b).b();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.b);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.a);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.b = null;
            toolbar3.g();
            this.b = null;
            Toolbar.this.requestLayout();
            hVar.e(false);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a.C0012a {
        int b;

        public b(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public b(a.C0012a c0012a) {
            super(c0012a);
            this.b = 0;
        }

        public b(b bVar) {
            super((a.C0012a) bVar);
            this.b = 0;
            this.b = bVar.b;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public static class d extends androidx.d.a.a {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>() { // from class: androidx.appcompat.widget.Toolbar.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };
        int a;
        boolean b;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.d.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0010a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.H = new ActionMenuView.e() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.e
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.d != null) {
                    return Toolbar.this.d.a(menuItem);
                }
                return false;
            }
        };
        this.O = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.b();
            }
        };
        aj a2 = aj.a(getContext(), attributeSet, a.j.Toolbar, i, 0);
        this.n = a2.g(a.j.Toolbar_titleTextAppearance, 0);
        this.o = a2.g(a.j.Toolbar_subtitleTextAppearance, 0);
        this.x = a2.c(a.j.Toolbar_android_gravity, this.x);
        this.c = a2.c(a.j.Toolbar_buttonGravity, 48);
        int d2 = a2.d(a.j.Toolbar_titleMargin, 0);
        d2 = a2.f(a.j.Toolbar_titleMargins) ? a2.d(a.j.Toolbar_titleMargins, d2) : d2;
        this.t = d2;
        this.s = d2;
        this.r = d2;
        this.q = d2;
        int d3 = a2.d(a.j.Toolbar_titleMarginStart, -1);
        if (d3 >= 0) {
            this.q = d3;
        }
        int d4 = a2.d(a.j.Toolbar_titleMarginEnd, -1);
        if (d4 >= 0) {
            this.r = d4;
        }
        int d5 = a2.d(a.j.Toolbar_titleMarginTop, -1);
        if (d5 >= 0) {
            this.s = d5;
        }
        int d6 = a2.d(a.j.Toolbar_titleMarginBottom, -1);
        if (d6 >= 0) {
            this.t = d6;
        }
        this.p = a2.e(a.j.Toolbar_maxButtonHeight, -1);
        int d7 = a2.d(a.j.Toolbar_contentInsetStart, BleSignal.UNKNOWN_TX_POWER);
        int d8 = a2.d(a.j.Toolbar_contentInsetEnd, BleSignal.UNKNOWN_TX_POWER);
        int e = a2.e(a.j.Toolbar_contentInsetLeft, 0);
        int e2 = a2.e(a.j.Toolbar_contentInsetRight, 0);
        n();
        this.u.b(e, e2);
        if (d7 != Integer.MIN_VALUE || d8 != Integer.MIN_VALUE) {
            this.u.a(d7, d8);
        }
        this.v = a2.d(a.j.Toolbar_contentInsetStartWithNavigation, BleSignal.UNKNOWN_TX_POWER);
        this.w = a2.d(a.j.Toolbar_contentInsetEndWithActions, BleSignal.UNKNOWN_TX_POWER);
        this.j = a2.a(a.j.Toolbar_collapseIcon);
        this.k = a2.b(a.j.Toolbar_collapseContentDescription);
        CharSequence b2 = a2.b(a.j.Toolbar_title);
        if (!TextUtils.isEmpty(b2)) {
            setTitle(b2);
        }
        CharSequence b3 = a2.b(a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(b3)) {
            setSubtitle(b3);
        }
        this.l = getContext();
        setPopupTheme(a2.g(a.j.Toolbar_popupTheme, 0));
        Drawable a3 = a2.a(a.j.Toolbar_navigationIcon);
        if (a3 != null) {
            setNavigationIcon(a3);
        }
        CharSequence b4 = a2.b(a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(b4)) {
            setNavigationContentDescription(b4);
        }
        Drawable a4 = a2.a(a.j.Toolbar_logo);
        if (a4 != null) {
            setLogo(a4);
        }
        CharSequence b5 = a2.b(a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(b5)) {
            setLogoDescription(b5);
        }
        if (a2.f(a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.b(a.j.Toolbar_titleTextColor, -1));
        }
        if (a2.f(a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.b(a.j.Toolbar_subtitleTextColor, -1));
        }
        a2.a();
    }

    private int a(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.x & 112;
    }

    private int a(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int a2 = a(bVar.a);
        if (a2 != 48) {
            if (a2 == 80) {
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
            if (i3 < bVar.topMargin) {
                i3 = bVar.topMargin;
            } else {
                int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                if (i4 < bVar.bottomMargin) {
                    i3 = Math.max(0, i3 - (bVar.bottomMargin - i4));
                }
            }
            return paddingTop + i3;
        }
        return getPaddingTop() - i2;
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int a2 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return max + measuredWidth + bVar.rightMargin;
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            View view = list.get(i5);
            b bVar = (b) view.getLayoutParams();
            int i7 = bVar.leftMargin - i4;
            int i8 = bVar.rightMargin - i3;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            int max3 = Math.max(0, -i7);
            int max4 = Math.max(0, -i8);
            i6 += max + view.getMeasuredWidth() + max2;
            i5++;
            i3 = max4;
            i4 = max3;
        }
        return i6;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        b generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (b) layoutParams;
        generateDefaultLayoutParams.b = 1;
        if (!z || this.b == null) {
            addView(view, generateDefaultLayoutParams);
            return;
        }
        view.setLayoutParams(generateDefaultLayoutParams);
        this.F.add(view);
    }

    private void a(List<View> list, int i) {
        boolean z = androidx.core.g.o.b(this) == 1;
        int childCount = getChildCount();
        int a2 = androidx.core.g.c.a(i, androidx.core.g.o.b(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.b == 0 && a(childAt) && b(bVar.a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.b == 0 && a(childAt2) && b(bVar2.a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i) {
        int b2 = androidx.core.g.o.b(this);
        int a2 = androidx.core.g.c.a(i, b2) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : b2 == 1 ? 5 : 3;
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.g.f.a(marginLayoutParams) + androidx.core.g.f.b(marginLayoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a2 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (measuredWidth + bVar.leftMargin);
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.d(getContext());
    }

    private void h() {
        if (this.i == null) {
            this.i = new l(getContext());
        }
    }

    private void i() {
        j();
        if (this.e.c() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.e.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.e.setExpandedActionViewsExclusive(true);
            gVar.a(this.K, this.l);
        }
    }

    private void j() {
        if (this.e == null) {
            this.e = new ActionMenuView(getContext());
            this.e.setPopupTheme(this.m);
            this.e.setOnMenuItemClickListener(this.H);
            this.e.a(this.L, this.M);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388613 | (this.c & 112);
            this.e.setLayoutParams(generateDefaultLayoutParams);
            a((View) this.e, false);
        }
    }

    private void k() {
        if (this.h == null) {
            this.h = new j(getContext(), null, a.C0010a.toolbarNavigationButtonStyle);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.c & 112);
            this.h.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private void l() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean m() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void n() {
        if (this.u == null) {
            this.u = new ab();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b ? new b((b) layoutParams) : layoutParams instanceof a.C0012a ? new b((a.C0012a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void a(int i, int i2) {
        n();
        this.u.a(i, i2);
    }

    public void a(Context context, int i) {
        this.n = i;
        TextView textView = this.f;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public boolean a() {
        ActionMenuView actionMenuView = this.e;
        return actionMenuView != null && actionMenuView.e();
    }

    public void b(Context context, int i) {
        this.o = i;
        TextView textView = this.g;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public boolean b() {
        ActionMenuView actionMenuView = this.e;
        return actionMenuView != null && actionMenuView.d();
    }

    public void c() {
        a aVar = this.K;
        androidx.appcompat.view.menu.h hVar = aVar == null ? null : aVar.b;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    void d() {
        if (this.a == null) {
            this.a = new j(getContext(), null, a.C0010a.toolbarNavigationButtonStyle);
            this.a.setImageDrawable(this.j);
            this.a.setContentDescription(this.k);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.c & 112);
            generateDefaultLayoutParams.b = 2;
            this.a.setLayoutParams(generateDefaultLayoutParams);
            this.a.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: e */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    void f() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((b) childAt.getLayoutParams()).b != 2 && childAt != this.e) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    void g() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    public int getContentInsetEnd() {
        ab abVar = this.u;
        if (abVar != null) {
            return abVar.d();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.w;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        ab abVar = this.u;
        if (abVar != null) {
            return abVar.a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        ab abVar = this.u;
        if (abVar != null) {
            return abVar.b();
        }
        return 0;
    }

    public int getContentInsetStart() {
        ab abVar = this.u;
        if (abVar != null) {
            return abVar.c();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.v;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.g c2;
        ActionMenuView actionMenuView = this.e;
        return actionMenuView != null && (c2 = actionMenuView.c()) != null && c2.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return androidx.core.g.o.b(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return androidx.core.g.o.b(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.i;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.i;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        i();
        return this.e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        i();
        return this.e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.l;
    }

    public int getPopupTheme() {
        return this.m;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public r getWrapper() {
        if (this.I == null) {
            this.I = new ak(this, true);
        }
        return this.I;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02a5 A[LOOP:0: B:104:0x02a3->B:105:0x02a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c7 A[LOOP:1: B:107:0x02c5->B:108:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0301 A[LOOP:2: B:116:0x02ff->B:117:0x0301, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean a2;
        boolean a3;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        int i13;
        int paddingTop;
        int i14;
        int i15;
        int i16;
        char c2;
        int i17;
        int i18;
        int i19;
        int size;
        int i20;
        int i21;
        int size2;
        int i22;
        int i23;
        int size3;
        boolean z3 = androidx.core.g.o.b(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i24 = width - paddingRight;
        int[] iArr = this.G;
        iArr[1] = 0;
        iArr[0] = 0;
        int c3 = androidx.core.g.o.c(this);
        int min = c3 >= 0 ? Math.min(c3, i4 - i2) : 0;
        if (!a(this.h)) {
            i5 = paddingLeft;
        } else if (z3) {
            i6 = b(this.h, i24, iArr, min);
            i5 = paddingLeft;
            if (a(this.a)) {
                if (z3) {
                    i6 = b(this.a, i6, iArr, min);
                } else {
                    i5 = a(this.a, i5, iArr, min);
                }
            }
            if (a(this.e)) {
                if (z3) {
                    i5 = a(this.e, i5, iArr, min);
                } else {
                    i6 = b(this.e, i6, iArr, min);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i5);
            iArr[1] = Math.max(0, currentContentInsetRight - (i24 - i6));
            int max = Math.max(i5, currentContentInsetLeft);
            int min2 = Math.min(i6, i24 - currentContentInsetRight);
            if (a(this.b)) {
                if (z3) {
                    min2 = b(this.b, min2, iArr, min);
                } else {
                    max = a(this.b, max, iArr, min);
                }
            }
            if (a(this.i)) {
                if (z3) {
                    min2 = b(this.i, min2, iArr, min);
                } else {
                    max = a(this.i, max, iArr, min);
                }
            }
            a2 = a(this.f);
            a3 = a(this.g);
            if (!a2) {
                b bVar = (b) this.f.getLayoutParams();
                i7 = paddingRight;
                i8 = bVar.topMargin + this.f.getMeasuredHeight() + bVar.bottomMargin + 0;
            } else {
                i7 = paddingRight;
                i8 = 0;
            }
            if (!a3) {
                b bVar2 = (b) this.g.getLayoutParams();
                i9 = width;
                i8 += bVar2.topMargin + this.g.getMeasuredHeight() + bVar2.bottomMargin;
            } else {
                i9 = width;
            }
            if (!a2 || a3) {
                TextView textView = !a2 ? this.f : this.g;
                TextView textView2 = !a3 ? this.g : this.f;
                b bVar3 = (b) textView.getLayoutParams();
                b bVar4 = (b) textView2.getLayoutParams();
                if ((a2 || this.f.getMeasuredWidth() <= 0) && (!a3 || this.g.getMeasuredWidth() <= 0)) {
                    i10 = paddingLeft;
                    z2 = false;
                } else {
                    i10 = paddingLeft;
                    z2 = true;
                }
                i11 = this.x & 112;
                i12 = min;
                if (i11 != 48) {
                    i13 = max;
                    paddingTop = getPaddingTop() + bVar3.topMargin + this.s;
                } else if (i11 != 80) {
                    int i25 = (((height - paddingTop2) - paddingBottom) - i8) / 2;
                    i13 = max;
                    if (i25 < bVar3.topMargin + this.s) {
                        i25 = bVar3.topMargin + this.s;
                    } else {
                        int i26 = (((height - paddingBottom) - i8) - i25) - paddingTop2;
                        if (i26 < bVar3.bottomMargin + this.t) {
                            i25 = Math.max(0, i25 - ((bVar4.bottomMargin + this.t) - i26));
                        }
                    }
                    paddingTop = paddingTop2 + i25;
                } else {
                    i13 = max;
                    paddingTop = (((height - paddingBottom) - bVar4.bottomMargin) - this.t) - i8;
                }
                if (z3) {
                    i14 = 0;
                    int i27 = (z2 ? this.q : 0) - iArr[0];
                    max = i13 + Math.max(0, i27);
                    iArr[0] = Math.max(0, -i27);
                    if (a2) {
                        int measuredWidth = this.f.getMeasuredWidth() + max;
                        int measuredHeight = this.f.getMeasuredHeight() + paddingTop;
                        this.f.layout(max, paddingTop, measuredWidth, measuredHeight);
                        i15 = measuredWidth + this.r;
                        paddingTop = measuredHeight + ((b) this.f.getLayoutParams()).bottomMargin;
                    } else {
                        i15 = max;
                    }
                    if (a3) {
                        b bVar5 = (b) this.g.getLayoutParams();
                        int i28 = paddingTop + bVar5.topMargin;
                        int measuredWidth2 = this.g.getMeasuredWidth() + max;
                        this.g.layout(max, i28, measuredWidth2, this.g.getMeasuredHeight() + i28);
                        i16 = measuredWidth2 + this.r;
                        int i29 = bVar5.bottomMargin;
                    } else {
                        i16 = max;
                    }
                    if (z2) {
                        max = Math.max(i15, i16);
                    }
                    a(this.E, 3);
                    size = this.E.size();
                    i20 = max;
                    for (i21 = 0; i21 < size; i21++) {
                        i20 = a(this.E.get(i21), i20, iArr, i12);
                    }
                    int i30 = i12;
                    a(this.E, 5);
                    size2 = this.E.size();
                    for (i22 = 0; i22 < size2; i22++) {
                        min2 = b(this.E.get(i22), min2, iArr, i30);
                    }
                    a(this.E, 1);
                    int a4 = a(this.E, iArr);
                    i23 = (i10 + (((i9 - i10) - i7) / 2)) - (a4 / 2);
                    int i31 = a4 + i23;
                    if (i23 >= i20) {
                        i20 = i31 > min2 ? i23 - (i31 - min2) : i23;
                    }
                    size3 = this.E.size();
                    while (i14 < size3) {
                        i20 = a(this.E.get(i14), i20, iArr, i30);
                        i14++;
                    }
                    this.E.clear();
                    return;
                }
                if (z2) {
                    i17 = this.q;
                    c2 = 1;
                } else {
                    c2 = 1;
                    i17 = 0;
                }
                int i32 = i17 - iArr[c2];
                min2 -= Math.max(0, i32);
                iArr[c2] = Math.max(0, -i32);
                if (a2) {
                    int measuredWidth3 = min2 - this.f.getMeasuredWidth();
                    int measuredHeight2 = this.f.getMeasuredHeight() + paddingTop;
                    this.f.layout(measuredWidth3, paddingTop, min2, measuredHeight2);
                    i18 = measuredWidth3 - this.r;
                    paddingTop = measuredHeight2 + ((b) this.f.getLayoutParams()).bottomMargin;
                } else {
                    i18 = min2;
                }
                if (a3) {
                    b bVar6 = (b) this.g.getLayoutParams();
                    int i33 = paddingTop + bVar6.topMargin;
                    this.g.layout(min2 - this.g.getMeasuredWidth(), i33, min2, this.g.getMeasuredHeight() + i33);
                    i19 = min2 - this.r;
                    int i34 = bVar6.bottomMargin;
                } else {
                    i19 = min2;
                }
                if (z2) {
                    min2 = Math.min(i18, i19);
                }
                max = i13;
            } else {
                i10 = paddingLeft;
                i12 = min;
            }
            i14 = 0;
            a(this.E, 3);
            size = this.E.size();
            i20 = max;
            while (i21 < size) {
            }
            int i302 = i12;
            a(this.E, 5);
            size2 = this.E.size();
            while (i22 < size2) {
            }
            a(this.E, 1);
            int a42 = a(this.E, iArr);
            i23 = (i10 + (((i9 - i10) - i7) / 2)) - (a42 / 2);
            int i312 = a42 + i23;
            if (i23 >= i20) {
            }
            size3 = this.E.size();
            while (i14 < size3) {
            }
            this.E.clear();
            return;
        } else {
            i5 = a(this.h, paddingLeft, iArr, min);
        }
        i6 = i24;
        if (a(this.a)) {
        }
        if (a(this.e)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i5);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i24 - i6));
        int max2 = Math.max(i5, currentContentInsetLeft2);
        int min22 = Math.min(i6, i24 - currentContentInsetRight2);
        if (a(this.b)) {
        }
        if (a(this.i)) {
        }
        a2 = a(this.f);
        a3 = a(this.g);
        if (!a2) {
        }
        if (!a3) {
        }
        if (!a2) {
        }
        if (!a2) {
        }
        if (!a3) {
        }
        b bVar32 = (b) textView.getLayoutParams();
        b bVar42 = (b) textView2.getLayoutParams();
        if (a2) {
        }
        i10 = paddingLeft;
        z2 = false;
        i11 = this.x & 112;
        i12 = min;
        if (i11 != 48) {
        }
        if (z3) {
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.G;
        if (ap.a(this)) {
            c2 = 1;
            c3 = 0;
        } else {
            c2 = 0;
            c3 = 1;
        }
        if (a(this.h)) {
            a(this.h, i, 0, i2, 0, this.p);
            i3 = this.h.getMeasuredWidth() + b(this.h);
            i4 = Math.max(0, this.h.getMeasuredHeight() + c(this.h));
            i5 = View.combineMeasuredStates(0, this.h.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (a(this.a)) {
            a(this.a, i, 0, i2, 0, this.p);
            i3 = this.a.getMeasuredWidth() + b(this.a);
            i4 = Math.max(i4, this.a.getMeasuredHeight() + c(this.a));
            i5 = View.combineMeasuredStates(i5, this.a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i3);
        iArr[c2] = Math.max(0, currentContentInsetStart - i3);
        if (a(this.e)) {
            a(this.e, i, max, i2, 0, this.p);
            i6 = this.e.getMeasuredWidth() + b(this.e);
            i4 = Math.max(i4, this.e.getMeasuredHeight() + c(this.e));
            i5 = View.combineMeasuredStates(i5, this.e.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c3] = Math.max(0, currentContentInsetEnd - i6);
        if (a(this.b)) {
            max2 += a(this.b, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.b.getMeasuredHeight() + c(this.b));
            i5 = View.combineMeasuredStates(i5, this.b.getMeasuredState());
        }
        if (a(this.i)) {
            max2 += a(this.i, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.i.getMeasuredHeight() + c(this.i));
            i5 = View.combineMeasuredStates(i5, this.i.getMeasuredState());
        }
        int childCount = getChildCount();
        int i10 = i4;
        int i11 = max2;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((b) childAt.getLayoutParams()).b == 0 && a(childAt)) {
                i11 += a(childAt, i, i11, i2, 0, iArr);
                i10 = Math.max(i10, childAt.getMeasuredHeight() + c(childAt));
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        int i13 = this.s + this.t;
        int i14 = this.q + this.r;
        if (a(this.f)) {
            a(this.f, i, i11 + i14, i2, i13, iArr);
            int measuredWidth = this.f.getMeasuredWidth() + b(this.f);
            i9 = this.f.getMeasuredHeight() + c(this.f);
            i7 = View.combineMeasuredStates(i5, this.f.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i7 = i5;
            i8 = 0;
            i9 = 0;
        }
        if (a(this.g)) {
            i8 = Math.max(i8, a(this.g, i, i11 + i14, i2, i9 + i13, iArr));
            i9 += this.g.getMeasuredHeight() + c(this.g);
            i7 = View.combineMeasuredStates(i7, this.g.getMeasuredState());
        }
        int max3 = Math.max(i10, i9);
        int paddingLeft = i11 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i7);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (m()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        ActionMenuView actionMenuView = this.e;
        androidx.appcompat.view.menu.g c2 = actionMenuView != null ? actionMenuView.c() : null;
        if (dVar.a != 0 && this.K != null && c2 != null && (findItem = c2.findItem(dVar.a)) != null) {
            findItem.expandActionView();
        }
        if (!dVar.b) {
            return;
        }
        l();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        n();
        ab abVar = this.u;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        abVar.a(z);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        a aVar = this.K;
        if (aVar != null && aVar.b != null) {
            dVar.a = this.K.b.getItemId();
        }
        dVar.b = a();
        return dVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = BleSignal.UNKNOWN_TX_POWER;
        }
        if (i != this.w) {
            this.w = i;
            if (getNavigationIcon() == null) {
                return;
            }
            requestLayout();
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = BleSignal.UNKNOWN_TX_POWER;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() == null) {
                return;
            }
            requestLayout();
        }
    }

    public void setLogo(int i) {
        setLogo(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            h();
            if (!d(this.i)) {
                a((View) this.i, true);
            }
        } else {
            ImageView imageView = this.i;
            if (imageView != null && d(imageView)) {
                removeView(this.i);
                this.F.remove(this.i);
            }
        }
        ImageView imageView2 = this.i;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            h();
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            k();
        }
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            k();
            if (!d(this.h)) {
                a((View) this.h, true);
            }
        } else {
            ImageButton imageButton = this.h;
            if (imageButton != null && d(imageButton)) {
                removeView(this.h);
                this.F.remove(this.h);
            }
        }
        ImageButton imageButton2 = this.h;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        k();
        this.h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.d = cVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        i();
        this.e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.m != i) {
            this.m = i;
            if (i == 0) {
                this.l = getContext();
            } else {
                this.l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.g == null) {
                Context context = getContext();
                this.g = new p(context);
                this.g.setSingleLine();
                this.g.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.o;
                if (i != 0) {
                    this.g.setTextAppearance(context, i);
                }
                int i2 = this.B;
                if (i2 != 0) {
                    this.g.setTextColor(i2);
                }
            }
            if (!d(this.g)) {
                a((View) this.g, true);
            }
        } else {
            TextView textView = this.g;
            if (textView != null && d(textView)) {
                removeView(this.g);
                this.F.remove(this.g);
            }
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.B = i;
        TextView textView = this.g;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f == null) {
                Context context = getContext();
                this.f = new p(context);
                this.f.setSingleLine();
                this.f.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.n;
                if (i != 0) {
                    this.f.setTextAppearance(context, i);
                }
                int i2 = this.A;
                if (i2 != 0) {
                    this.f.setTextColor(i2);
                }
            }
            if (!d(this.f)) {
                a((View) this.f, true);
            }
        } else {
            TextView textView = this.f;
            if (textView != null && d(textView)) {
                removeView(this.f);
                this.F.remove(this.f);
            }
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.A = i;
        TextView textView = this.f;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }
}
