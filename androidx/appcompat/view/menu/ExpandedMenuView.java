package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.aj;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, g.b, n {
    private static final int[] a = {16842964, 16843049};
    private g b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        aj a2 = aj.a(context, attributeSet, a, i, 0);
        if (a2.f(0)) {
            setBackgroundDrawable(a2.a(0));
        }
        if (a2.f(1)) {
            setDivider(a2.a(1));
        }
        a2.a();
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(h hVar) {
        return this.b.a(hVar, 0);
    }

    public int getWindowAnimations() {
        return this.c;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((h) getAdapter().getItem(i));
    }
}
