package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class n extends Spinner implements androidx.core.g.n {
    private static final int[] d = {16843505};
    b a;
    int b;
    final Rect c;
    private final f e;
    private final Context f;
    private v g;
    private SpinnerAdapter h;
    private final boolean i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() == theme) {
                        return;
                    }
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                } else if (!(spinnerAdapter instanceof af)) {
                } else {
                    af afVar = (af) spinnerAdapter;
                    if (afVar.a() != null) {
                        return;
                    }
                    afVar.a(theme);
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends x {
        ListAdapter a;
        private CharSequence h;
        private final Rect i;

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.i = new Rect();
            b(n.this);
            a(true);
            a(0);
            a(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.n.b.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    n.this.setSelection(i2);
                    if (n.this.getOnItemClickListener() != null) {
                        n.this.performItemClick(view, i2, b.this.a.getItemId(i2));
                    }
                    b.this.c();
                }
            });
        }

        @Override // androidx.appcompat.widget.x, androidx.appcompat.view.menu.q
        public void a() {
            ViewTreeObserver viewTreeObserver;
            boolean d = d();
            f();
            h(2);
            super.a();
            e().setChoiceMode(1);
            i(n.this.getSelectedItemPosition());
            if (!d && (viewTreeObserver = n.this.getViewTreeObserver()) != null) {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.n.b.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        b bVar = b.this;
                        if (!bVar.a(n.this)) {
                            b.this.c();
                            return;
                        }
                        b.this.f();
                        b.super.a();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                a(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.n.b.3
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver2 = n.this.getViewTreeObserver();
                        if (viewTreeObserver2 != null) {
                            viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        }

        @Override // androidx.appcompat.widget.x
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.a = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        boolean a(View view) {
            return androidx.core.g.o.k(view) && view.getGlobalVisibleRect(this.i);
        }

        public CharSequence b() {
            return this.h;
        }

        void f() {
            int i;
            Drawable h = h();
            int i2 = 0;
            if (h != null) {
                h.getPadding(n.this.c);
                i2 = ap.a(n.this) ? n.this.c.right : -n.this.c.left;
            } else {
                Rect rect = n.this.c;
                n.this.c.right = 0;
                rect.left = 0;
            }
            int paddingLeft = n.this.getPaddingLeft();
            int paddingRight = n.this.getPaddingRight();
            int width = n.this.getWidth();
            if (n.this.b == -2) {
                int a = n.this.a((SpinnerAdapter) this.a, h());
                int i3 = (n.this.getContext().getResources().getDisplayMetrics().widthPixels - n.this.c.left) - n.this.c.right;
                if (a > i3) {
                    a = i3;
                }
                i = Math.max(a, (width - paddingLeft) - paddingRight);
            } else {
                i = n.this.b == -1 ? (width - paddingLeft) - paddingRight : n.this.b;
            }
            g(i);
            c(ap.a(n.this) ? i2 + ((width - paddingRight) - l()) : i2 + paddingLeft);
        }
    }

    public n(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public n(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r12 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        r12.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
        if (r12 == null) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public n(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i);
        androidx.appcompat.view.c cVar;
        CharSequence[] e;
        SpinnerAdapter spinnerAdapter;
        TypedArray typedArray;
        this.c = new Rect();
        aj a2 = aj.a(context, attributeSet, a.j.Spinner, i, 0);
        this.e = new f(this);
        if (theme != null) {
            cVar = new androidx.appcompat.view.c(context, theme);
        } else {
            int g = a2.g(a.j.Spinner_popupTheme, 0);
            if (g == 0) {
                this.f = Build.VERSION.SDK_INT < 23 ? context : null;
                if (this.f != null) {
                    if (i2 == -1) {
                        try {
                            typedArray = context.obtainStyledAttributes(attributeSet, d, i, 0);
                        } catch (Exception e2) {
                            e = e2;
                            typedArray = null;
                        } catch (Throwable th) {
                            th = th;
                            typedArray = null;
                            if (typedArray != null) {
                            }
                            throw th;
                        }
                        try {
                            try {
                                i2 = typedArray.hasValue(0) ? typedArray.getInt(0, 0) : i2;
                            } catch (Throwable th2) {
                                th = th2;
                                if (typedArray != null) {
                                    typedArray.recycle();
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        }
                    }
                    if (i2 == 1) {
                        final b bVar = new b(this.f, attributeSet, i);
                        aj a3 = aj.a(this.f, attributeSet, a.j.Spinner, i, 0);
                        this.b = a3.f(a.j.Spinner_android_dropDownWidth, -2);
                        bVar.a(a3.a(a.j.Spinner_android_popupBackground));
                        bVar.a(a2.c(a.j.Spinner_android_prompt));
                        a3.a();
                        this.a = bVar;
                        this.g = new v(this) { // from class: androidx.appcompat.widget.n.1
                            @Override // androidx.appcompat.widget.v
                            public androidx.appcompat.view.menu.q a() {
                                return bVar;
                            }

                            @Override // androidx.appcompat.widget.v
                            public boolean b() {
                                if (!n.this.a.d()) {
                                    n.this.a.a();
                                    return true;
                                }
                                return true;
                            }
                        };
                    }
                }
                e = a2.e(a.j.Spinner_android_entries);
                if (e != null) {
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, e);
                    arrayAdapter.setDropDownViewResource(a.g.support_simple_spinner_dropdown_item);
                    setAdapter((SpinnerAdapter) arrayAdapter);
                }
                a2.a();
                this.i = true;
                spinnerAdapter = this.h;
                if (spinnerAdapter != null) {
                    setAdapter(spinnerAdapter);
                    this.h = null;
                }
                this.e.a(attributeSet, i);
            }
            cVar = new androidx.appcompat.view.c(context, g);
        }
        this.f = cVar;
        if (this.f != null) {
        }
        e = a2.e(a.j.Spinner_android_entries);
        if (e != null) {
        }
        a2.a();
        this.i = true;
        spinnerAdapter = this.h;
        if (spinnerAdapter != null) {
        }
        this.e.a(attributeSet, i);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.c);
        return i2 + this.c.left + this.c.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.e;
        if (fVar != null) {
            fVar.c();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.j();
        }
        if (Build.VERSION.SDK_INT < 16) {
            return 0;
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.k();
        }
        if (Build.VERSION.SDK_INT < 16) {
            return 0;
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.a != null) {
            return this.b;
        }
        if (Build.VERSION.SDK_INT < 16) {
            return 0;
        }
        return super.getDropDownWidth();
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.h();
        }
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.a != null) {
            return this.f;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        return super.getPopupContext();
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        b bVar = this.a;
        return bVar != null ? bVar.b() : super.getPrompt();
    }

    @Override // androidx.core.g.n
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.e;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // androidx.core.g.n
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.e;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.a;
        if (bVar == null || !bVar.d()) {
            return;
        }
        this.a.c();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        v vVar = this.g;
        if (vVar == null || !vVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        b bVar = this.a;
        if (bVar != null) {
            if (bVar.d()) {
                return true;
            }
            this.a.a();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.i) {
            this.h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.a == null) {
            return;
        }
        Context context = this.f;
        if (context == null) {
            context = getContext();
        }
        this.a.a(new a(spinnerAdapter, context.getTheme()));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.c(i);
        } else if (Build.VERSION.SDK_INT < 16) {
        } else {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.d(i);
        } else if (Build.VERSION.SDK_INT < 16) {
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.a != null) {
            this.b = i;
        } else if (Build.VERSION.SDK_INT < 16) {
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(drawable);
        } else if (Build.VERSION.SDK_INT < 16) {
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.g.n
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(colorStateList);
        }
    }

    @Override // androidx.core.g.n
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(mode);
        }
    }
}
