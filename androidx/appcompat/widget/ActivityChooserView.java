package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {
    final a a;
    final FrameLayout b;
    final FrameLayout c;
    androidx.core.g.b d;
    final DataSetObserver e;
    PopupWindow.OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final View j;
    private final ImageView k;
    private final int l;
    private final ViewTreeObserver.OnGlobalLayoutListener m;
    private x n;
    private boolean o;
    private int p;

    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {
        private static final int[] a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            aj a2 = aj.a(context, attributeSet, a);
            setBackgroundDrawable(a2.a(0));
            a2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView a;
        private d b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        public int a() {
            int i = this.c;
            this.c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.c = i;
            return i2;
        }

        public void a(int i) {
            if (this.c != i) {
                this.c = i;
                notifyDataSetChanged();
            }
        }

        public void a(d dVar) {
            d d = this.a.a.d();
            if (d != null && this.a.isShown()) {
                d.unregisterObserver(this.a.e);
            }
            this.b = dVar;
            if (dVar != null && this.a.isShown()) {
                dVar.registerObserver(this.a.e);
            }
            notifyDataSetChanged();
        }

        public void a(boolean z) {
            if (this.f != z) {
                this.f = z;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z, boolean z2) {
            if (this.d == z && this.e == z2) {
                return;
            }
            this.d = z;
            this.e = z2;
            notifyDataSetChanged();
        }

        public ResolveInfo b() {
            return this.b.b();
        }

        public int c() {
            return this.b.a();
        }

        public d d() {
            return this.b;
        }

        public boolean e() {
            return this.d;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int a = this.b.a();
            if (!this.d && this.b.b() != null) {
                a--;
            }
            int min = Math.min(a, this.c);
            return this.f ? min + 1 : min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.d && this.b.b() != null) {
                        i++;
                    }
                    return this.b.a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (!this.f || i != getCount() - 1) ? 0 : 1;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != a.f.list_item) {
                        view = LayoutInflater.from(this.a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(a.f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(a.f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (!this.d || i != 0 || !this.e) {
                        view.setActivated(false);
                    } else {
                        view.setActivated(true);
                    }
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View inflate = LayoutInflater.from(this.a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    inflate.setId(1);
                    ((TextView) inflate.findViewById(a.f.title)).setText(this.a.getContext().getString(a.h.abc_activity_chooser_view_see_all));
                    return inflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        final /* synthetic */ ActivityChooserView a;

        private void a() {
            if (this.a.f != null) {
                this.a.f.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != this.a.c) {
                if (view != this.a.b) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView activityChooserView = this.a;
                activityChooserView.g = false;
                activityChooserView.a(activityChooserView.h);
                return;
            }
            this.a.b();
            Intent b = this.a.a.d().b(this.a.a.d().a(this.a.a.b()));
            if (b == null) {
                return;
            }
            b.addFlags(524288);
            this.a.getContext().startActivity(b);
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            if (this.a.d != null) {
                this.a.d.a(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.a.b();
                    if (this.a.g) {
                        if (i <= 0) {
                            return;
                        }
                        this.a.a.d().c(i);
                        return;
                    }
                    if (!this.a.a.e()) {
                        i++;
                    }
                    Intent b = this.a.a.d().b(i);
                    if (b == null) {
                        return;
                    }
                    b.addFlags(524288);
                    this.a.getContext().startActivity(b);
                    return;
                case 1:
                    this.a.a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == this.a.c) {
                if (this.a.a.getCount() > 0) {
                    ActivityChooserView activityChooserView = this.a;
                    activityChooserView.g = true;
                    activityChooserView.a(activityChooserView.h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(int i) {
        a aVar;
        x listPopupWindow;
        if (this.a.d() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.m);
            boolean z = this.c.getVisibility() == 0;
            int c = this.a.c();
            if (i != Integer.MAX_VALUE) {
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                if (c > i + i2) {
                    this.a.a(true);
                    aVar = this.a;
                    i--;
                    aVar.a(i);
                    listPopupWindow = getListPopupWindow();
                    if (!listPopupWindow.d()) {
                        return;
                    }
                    if (this.g || !z) {
                        this.a.a(true, z);
                    } else {
                        this.a.a(false, false);
                    }
                    listPopupWindow.g(Math.min(this.a.a(), this.l));
                    listPopupWindow.a();
                    androidx.core.g.b bVar = this.d;
                    if (bVar != null) {
                        bVar.a(true);
                    }
                    listPopupWindow.e().setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
                    listPopupWindow.e().setSelector(new ColorDrawable(0));
                    return;
                }
            }
            this.a.a(false);
            aVar = this.a;
            aVar.a(i);
            listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.d()) {
            }
        } else {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
    }

    public boolean a() {
        if (c() || !this.o) {
            return false;
        }
        this.g = false;
        a(this.h);
        return true;
    }

    public boolean b() {
        if (c()) {
            getListPopupWindow().c();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (!viewTreeObserver.isAlive()) {
                return true;
            }
            viewTreeObserver.removeGlobalOnLayoutListener(this.m);
            return true;
        }
        return true;
    }

    public boolean c() {
        return getListPopupWindow().d();
    }

    public d getDataModel() {
        return this.a.d();
    }

    x getListPopupWindow() {
        if (this.n == null) {
            this.n = new x(getContext());
            this.n.a(this.a);
            this.n.b(this);
            this.n.a(true);
            this.n.a((AdapterView.OnItemClickListener) this.i);
            this.n.a((PopupWindow.OnDismissListener) this.i);
        }
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d d = this.a.d();
        if (d != null) {
            d.registerObserver(this.e);
        }
        this.o = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d d = this.a.d();
        if (d != null) {
            d.unregisterObserver(this.e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        }
        if (c()) {
            b();
        }
        this.o = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.j.layout(0, 0, i3 - i, i4 - i2);
        if (!c()) {
            b();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.j;
        if (this.c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(d dVar) {
        this.a.a(dVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.k.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.k.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.h = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    public void setProvider(androidx.core.g.b bVar) {
        this.d = bVar;
    }
}
