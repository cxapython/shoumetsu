package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends BaseAdapter {
    g a;
    private int b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.a = gVar;
        this.f = i;
        b();
    }

    public g a() {
        return this.a;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public h getItem(int i) {
        ArrayList<h> l = this.d ? this.a.l() : this.a.i();
        int i2 = this.b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return l.get(i);
    }

    public void a(boolean z) {
        this.c = z;
    }

    void b() {
        h p = this.a.p();
        if (p != null) {
            ArrayList<h> l = this.a.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (l.get(i) == p) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<h> l = this.d ? this.a.l() : this.a.i();
        return this.b < 0 ? l.size() : l.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.a.a() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
