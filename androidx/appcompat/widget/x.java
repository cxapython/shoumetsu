package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import com.google.android.gms.nearby.messages.BleSignal;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import java.lang.reflect.Method;
import org.cocos2dx.lib.GameControllerDelegate;

/* loaded from: classes.dex */
public class x implements androidx.appcompat.view.menu.q {
    private static Method a;
    private static Method b;
    private static Method h;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    t c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.m();
        }
    }

    /* loaded from: classes.dex */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (x.this.d()) {
                x.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            x.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || x.this.n() || x.this.g.getContentView() == null) {
                return;
            }
            x.this.f.removeCallbacks(x.this.e);
            x.this.e.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && x.this.g != null && x.this.g.isShowing() && x >= 0 && x < x.this.g.getWidth() && y >= 0 && y < x.this.g.getHeight()) {
                x.this.f.postDelayed(x.this.e, 250L);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                x.this.f.removeCallbacks(x.this.e);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x.this.c == null || !androidx.core.g.o.k(x.this.c) || x.this.c.getCount() <= x.this.c.getChildCount() || x.this.c.getChildCount() > x.this.d) {
                return;
            }
            x.this.g.setInputMethodMode(2);
            x.this.a();
        }
    }

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public x(Context context) {
        this(context, null, a.C0010a.listPopupWindowStyle);
    }

    public x(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public x(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = -2;
        this.l = -2;
        this.o = GameControllerDelegate.THUMBSTICK_RIGHT_X;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = Integer.MAX_VALUE;
        this.x = 0;
        this.e = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ListPopupWindow, i, i2);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        this.g = new m(context, attributeSet, i, i2);
        this.g.setInputMethodMode(1);
    }

    private int a(View view, int i, boolean z) {
        Method method = b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.g.getMaxAvailableHeight(view, i);
    }

    private void b() {
        View view = this.w;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) parent).removeView(this.w);
        }
    }

    private void c(boolean z) {
        Method method = a;
        if (method != null) {
            try {
                method.invoke(this.g, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int f() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        boolean z = true;
        if (this.c == null) {
            Context context = this.i;
            this.G = new Runnable() { // from class: androidx.appcompat.widget.x.1
                @Override // java.lang.Runnable
                public void run() {
                    View i4 = x.this.i();
                    if (i4 == null || i4.getWindowToken() == null) {
                        return;
                    }
                    x.this.a();
                }
            };
            this.c = a(context, !this.J);
            Drawable drawable = this.A;
            if (drawable != null) {
                this.c.setSelector(drawable);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.x.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j) {
                    t tVar;
                    if (i4 == -1 || (tVar = x.this.c) == null) {
                        return;
                    }
                    tVar.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.c.setOnScrollListener(this.E);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.C;
            if (onItemSelectedListener != null) {
                this.c.setOnItemSelectedListener(onItemSelectedListener);
            }
            t tVar = this.c;
            View view = this.w;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    case 0:
                        linearLayout.addView(view);
                        linearLayout.addView(tVar, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(tVar, layoutParams);
                        linearLayout.addView(view);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                        break;
                }
                int i4 = this.l;
                if (i4 >= 0) {
                    i3 = BleSignal.UNKNOWN_TX_POWER;
                } else {
                    i4 = 0;
                    i3 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i4, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                tVar = linearLayout;
            } else {
                i = 0;
            }
            this.g.setContentView(tVar);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.g.getContentView();
            View view2 = this.w;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            i2 = this.H.top + this.H.bottom;
            if (!this.p) {
                this.n = -this.H.top;
            }
        } else {
            this.H.setEmpty();
            i2 = 0;
        }
        if (this.g.getInputMethodMode() != 2) {
            z = false;
        }
        int a2 = a(i(), this.n, z);
        if (this.u || this.k == -1) {
            return a2 + i2;
        }
        int i5 = this.l;
        switch (i5) {
            case ContentLengthStrategy.CHUNKED /* -2 */:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), BleSignal.UNKNOWN_TX_POWER);
                break;
            case -1:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), 1073741824);
                break;
            default:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                break;
        }
        int a3 = this.c.a(makeMeasureSpec, 0, -1, a2 - i, -1);
        if (a3 > 0) {
            i += i2 + this.c.getPaddingTop() + this.c.getPaddingBottom();
        }
        return a3 + i;
    }

    t a(Context context, boolean z) {
        return new t(context, z);
    }

    @Override // androidx.appcompat.view.menu.q
    public void a() {
        int f = f();
        boolean n = n();
        androidx.core.widget.g.a(this.g, this.o);
        boolean z = true;
        if (this.g.isShowing()) {
            if (!androidx.core.g.o.k(i())) {
                return;
            }
            int i = this.l;
            if (i == -1) {
                i = -1;
            } else if (i == -2) {
                i = i().getWidth();
            }
            int i2 = this.k;
            if (i2 == -1) {
                if (!n) {
                    f = -1;
                }
                if (n) {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(0);
                } else {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(-1);
                }
            } else if (i2 != -2) {
                f = i2;
            }
            PopupWindow popupWindow = this.g;
            if (this.v || this.u) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.g.update(i(), this.m, this.n, i < 0 ? -1 : i, f < 0 ? -1 : f);
            return;
        }
        int i3 = this.l;
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = i().getWidth();
        }
        int i4 = this.k;
        if (i4 == -1) {
            f = -1;
        } else if (i4 != -2) {
            f = i4;
        }
        this.g.setWidth(i3);
        this.g.setHeight(f);
        c(true);
        this.g.setOutsideTouchable(!this.v && !this.u);
        this.g.setTouchInterceptor(this.D);
        if (this.s) {
            androidx.core.widget.g.a(this.g, this.r);
        }
        Method method = h;
        if (method != null) {
            try {
                method.invoke(this.g, this.I);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        androidx.core.widget.g.a(this.g, i(), this.m, this.n, this.t);
        this.c.setSelection(-1);
        if (!this.J || this.c.isInTouchMode()) {
            m();
        }
        if (this.J) {
            return;
        }
        this.f.post(this.F);
    }

    public void a(int i) {
        this.x = i;
    }

    public void a(Rect rect) {
        this.I = rect;
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.y;
        if (dataSetObserver == null) {
            this.y = new b();
        } else {
            ListAdapter listAdapter2 = this.j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        t tVar = this.c;
        if (tVar != null) {
            tVar.setAdapter(this.j);
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z) {
        this.J = z;
        this.g.setFocusable(z);
    }

    public void b(int i) {
        this.g.setAnimationStyle(i);
    }

    public void b(View view) {
        this.z = view;
    }

    public void b(boolean z) {
        this.s = true;
        this.r = z;
    }

    @Override // androidx.appcompat.view.menu.q
    public void c() {
        this.g.dismiss();
        b();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    public void c(int i) {
        this.m = i;
    }

    public void d(int i) {
        this.n = i;
        this.p = true;
    }

    @Override // androidx.appcompat.view.menu.q
    public boolean d() {
        return this.g.isShowing();
    }

    @Override // androidx.appcompat.view.menu.q
    public ListView e() {
        return this.c;
    }

    public void e(int i) {
        this.t = i;
    }

    public void f(int i) {
        this.l = i;
    }

    public void g(int i) {
        Drawable background = this.g.getBackground();
        if (background == null) {
            f(i);
            return;
        }
        background.getPadding(this.H);
        this.l = this.H.left + this.H.right + i;
    }

    public boolean g() {
        return this.J;
    }

    public Drawable h() {
        return this.g.getBackground();
    }

    public void h(int i) {
        this.g.setInputMethodMode(i);
    }

    public View i() {
        return this.z;
    }

    public void i(int i) {
        t tVar = this.c;
        if (!d() || tVar == null) {
            return;
        }
        tVar.setListSelectionHidden(false);
        tVar.setSelection(i);
        if (tVar.getChoiceMode() == 0) {
            return;
        }
        tVar.setItemChecked(i, true);
    }

    public int j() {
        return this.m;
    }

    public int k() {
        if (!this.p) {
            return 0;
        }
        return this.n;
    }

    public int l() {
        return this.l;
    }

    public void m() {
        t tVar = this.c;
        if (tVar != null) {
            tVar.setListSelectionHidden(true);
            tVar.requestLayout();
        }
    }

    public boolean n() {
        return this.g.getInputMethodMode() == 2;
    }
}
