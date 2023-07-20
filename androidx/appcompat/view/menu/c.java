package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
abstract class c<T> extends d<T> {
    final Context a;
    private Map<androidx.core.b.a.b, MenuItem> c;
    private Map<androidx.core.b.a.c, SubMenu> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, T t) {
        super(t);
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (menuItem instanceof androidx.core.b.a.b) {
            androidx.core.b.a.b bVar = (androidx.core.b.a.b) menuItem;
            if (this.c == null) {
                this.c = new androidx.b.a();
            }
            MenuItem menuItem2 = this.c.get(menuItem);
            if (menuItem2 != null) {
                return menuItem2;
            }
            MenuItem a = o.a(this.a, bVar);
            this.c.put(bVar, a);
            return a;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (subMenu instanceof androidx.core.b.a.c) {
            androidx.core.b.a.c cVar = (androidx.core.b.a.c) subMenu;
            if (this.d == null) {
                this.d = new androidx.b.a();
            }
            SubMenu subMenu2 = this.d.get(cVar);
            if (subMenu2 != null) {
                return subMenu2;
            }
            SubMenu a = o.a(this.a, cVar);
            this.d.put(cVar, a);
            return a;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        Map<androidx.core.b.a.b, MenuItem> map = this.c;
        if (map != null) {
            map.clear();
        }
        Map<androidx.core.b.a.c, SubMenu> map2 = this.d;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        Map<androidx.core.b.a.b, MenuItem> map = this.c;
        if (map == null) {
            return;
        }
        Iterator<androidx.core.b.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i) {
        Map<androidx.core.b.a.b, MenuItem> map = this.c;
        if (map == null) {
            return;
        }
        Iterator<androidx.core.b.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
