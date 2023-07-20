package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.g;

/* loaded from: classes.dex */
public class s extends g implements SubMenu {
    private g d;
    private h e;

    public s(Context context, g gVar, h hVar) {
        super(context);
        this.d = gVar;
        this.e = hVar;
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(g.a aVar) {
        this.d.a(aVar);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean a() {
        return this.d.a();
    }

    @Override // androidx.appcompat.view.menu.g
    boolean a(g gVar, MenuItem menuItem) {
        return super.a(gVar, menuItem) || this.d.a(gVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean b() {
        return this.d.b();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean c() {
        return this.d.c();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean c(h hVar) {
        return this.d.c(hVar);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean d(h hVar) {
        return this.d.d(hVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.e;
    }

    @Override // androidx.appcompat.view.menu.g
    public g n() {
        return this.d.n();
    }

    public Menu q() {
        return this.d;
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.d.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.d(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.c(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.a(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }
}
