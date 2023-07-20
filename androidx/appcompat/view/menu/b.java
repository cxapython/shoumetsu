package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements m {
    protected Context a;
    protected Context b;
    protected g c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected n f;
    private m.a g;
    private int h;
    private int i;

    public b(Context context, int i, int i2) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    public View a(h hVar, View view, ViewGroup viewGroup) {
        n.a a = view instanceof n.a ? (n.a) view : a(viewGroup);
        a(hVar, a);
        return (View) a;
    }

    public m.a a() {
        return this.g;
    }

    public n.a a(ViewGroup viewGroup) {
        return (n.a) this.d.inflate(this.i, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Context context, g gVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = gVar;
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i);
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z) {
        m.a aVar = this.g;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    public abstract void a(h hVar, n.a aVar);

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
        this.g = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.c;
        int i = 0;
        if (gVar != null) {
            gVar.j();
            ArrayList<h> i2 = this.c.i();
            int size = i2.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                h hVar = i2.get(i4);
                if (a(i3, hVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    h itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View a = a(hVar, childAt, viewGroup);
                    if (hVar != itemData) {
                        a.setPressed(false);
                        a.jumpDrawablesToCurrentState();
                    }
                    if (a != childAt) {
                        a(a, i3);
                    }
                    i3++;
                }
            }
            i = i3;
        }
        while (i < viewGroup.getChildCount()) {
            if (!a(viewGroup, i)) {
                i++;
            }
        }
    }

    public boolean a(int i, h hVar) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(g gVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(s sVar) {
        m.a aVar = this.g;
        if (aVar != null) {
            return aVar.a(sVar);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b(g gVar, h hVar) {
        return false;
    }
}
