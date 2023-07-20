package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.games.request.GameRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class g implements androidx.core.b.a.a {
    private static final int[] d = {1, 4, 5, 3, 2, 0};
    private boolean A;
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private a i;
    private ContextMenu.ContextMenuInfo q;
    private h y;
    private int p = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<h> w = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<m>> x = new CopyOnWriteArrayList<>();
    private boolean z = false;
    private ArrayList<h> j = new ArrayList<>();
    private ArrayList<h> k = new ArrayList<>();
    private boolean l = true;
    private ArrayList<h> m = new ArrayList<>();
    private ArrayList<h> n = new ArrayList<>();
    private boolean o = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(g gVar);

        boolean a(g gVar, MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(h hVar);
    }

    public g(Context context) {
        this.e = context;
        this.f = context.getResources();
        d(true);
    }

    private static int a(ArrayList<h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private h a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new h(this, i, i2, i3, i4, charSequence, i5);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d2 = d();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (i > 0) {
                this.a = d2.getText(i);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (i2 > 0) {
                this.b = androidx.core.a.a.a(e(), i2);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        b(false);
    }

    private void a(int i, boolean z) {
        if (i < 0 || i >= this.j.size()) {
            return;
        }
        this.j.remove(i);
        if (!z) {
            return;
        }
        b(true);
    }

    private boolean a(s sVar, m mVar) {
        boolean z = false;
        if (this.x.isEmpty()) {
            return false;
        }
        if (mVar != null) {
            z = mVar.a(sVar);
        }
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null) {
                this.x.remove(next);
            } else if (!z) {
                z = mVar2.a(sVar);
            }
        }
        return z;
    }

    private void c(boolean z) {
        if (this.x.isEmpty()) {
            return;
        }
        g();
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                mVar.a(z);
            }
        }
        h();
    }

    private void d(boolean z) {
        boolean z2 = true;
        if (!z || this.f.getConfiguration().keyboard == 1 || !androidx.core.g.p.a(ViewConfiguration.get(this.e), this.e)) {
            z2 = false;
        }
        this.h = z2;
    }

    private static int e(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = d;
            if (i2 < iArr.length) {
                return (i & GameRequest.TYPE_ALL) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public int a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.j.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int e = e(i3);
        h a2 = a(i, i2, i3, e, charSequence, this.p);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.q;
        if (contextMenuInfo != null) {
            a2.a(contextMenuInfo);
        }
        ArrayList<h> arrayList = this.j;
        arrayList.add(a(arrayList, e), a2);
        b(true);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    h a(int i, KeyEvent keyEvent) {
        ArrayList<h> arrayList = this.w;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean b2 = b();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = arrayList.get(i2);
            char alphabeticShortcut = b2 ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            if ((alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) || (b2 && alphabeticShortcut == '\b' && i == 67))) {
                return hVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        g();
        for (int i = 0; i < size; i++) {
            h hVar = this.j.get(i);
            if (hVar.getGroupId() == groupId && hVar.g() && hVar.isCheckable()) {
                hVar.b(hVar == menuItem);
            }
        }
        h();
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        this.l = true;
        b(true);
    }

    public void a(m mVar) {
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.x.remove(next);
            }
        }
    }

    public void a(m mVar, Context context) {
        this.x.add(new WeakReference<>(mVar));
        mVar.a(context, this);
        this.o = true;
    }

    void a(List<h> list, int i, KeyEvent keyEvent) {
        boolean b2 = b();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = this.j.get(i2);
                if (hVar.hasSubMenu()) {
                    ((g) hVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = b2 ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if (((modifiers & 69647) == ((b2 ? hVar.getAlphabeticModifiers() : hVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b2 && alphabeticShortcut == '\b' && i == 67)) && hVar.isEnabled())) {
                    list.add(hVar);
                }
            }
        }
    }

    public final void a(boolean z) {
        if (this.v) {
            return;
        }
        this.v = true;
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                mVar.a(this, z);
            }
        }
        this.v = false;
    }

    public boolean a() {
        return this.z;
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (m) null, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r1 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
        a(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        if ((r9 & 1) == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r1 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(MenuItem menuItem, m mVar, int i) {
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean b2 = hVar.b();
        androidx.core.g.b a2 = hVar.a();
        boolean z = a2 != null && a2.c();
        if (hVar.n()) {
            b2 |= hVar.expandActionView();
        } else if (hVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                a(false);
            }
            if (!hVar.hasSubMenu()) {
                hVar.a(new s(e(), this, hVar));
            }
            s sVar = (s) hVar.getSubMenu();
            if (z) {
                a2.a(sVar);
            }
            b2 |= a(sVar, mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(g gVar, MenuItem menuItem) {
        a aVar = this.i;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.f.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        s sVar = new s(this.e, this, hVar);
        hVar.a(sVar);
        return sVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int i) {
        return a(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.o = true;
        b(true);
    }

    public void b(boolean z) {
        if (!this.r) {
            if (z) {
                this.l = true;
                this.o = true;
            }
            c(z);
            return;
        }
        this.s = true;
        if (!z) {
            return;
        }
        this.t = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g c(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    public boolean c() {
        return this.h;
    }

    public boolean c(h hVar) {
        boolean z = false;
        if (this.x.isEmpty()) {
            return false;
        }
        g();
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                z = mVar.a(this, hVar);
                if (z) {
                    break;
                }
            }
        }
        h();
        if (z) {
            this.y = hVar;
        }
        return z;
    }

    @Override // android.view.Menu
    public void clear() {
        h hVar = this.y;
        if (hVar != null) {
            d(hVar);
        }
        this.j.clear();
        b(true);
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        b(false);
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    Resources d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g d(int i) {
        a(0, null, i, null, null);
        return this;
    }

    public boolean d(h hVar) {
        boolean z = false;
        if (!this.x.isEmpty() && this.y == hVar) {
            g();
            Iterator<WeakReference<m>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.x.remove(next);
                } else {
                    z = mVar.b(this, hVar);
                    if (z) {
                        break;
                    }
                }
            }
            h();
            if (z) {
                this.y = null;
            }
        }
        return z;
    }

    public Context e() {
        return this.e;
    }

    public void f() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.j.get(i2);
            if (hVar.getItemId() == i) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (findItem = hVar.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public void g() {
        if (!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.j.get(i);
    }

    public void h() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(this.t);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<h> i() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.j.get(i);
            if (hVar.isVisible()) {
                this.k.add(hVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void j() {
        ArrayList<h> i = i();
        if (!this.o) {
            return;
        }
        Iterator<WeakReference<m>> it = this.x.iterator();
        boolean z = false;
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                z |= mVar.b();
            }
        }
        if (z) {
            this.m.clear();
            this.n.clear();
            int size = i.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = i.get(i2);
                (hVar.j() ? this.m : this.n).add(hVar);
            }
        } else {
            this.m.clear();
            this.n.clear();
            this.n.addAll(i());
        }
        this.o = false;
    }

    public ArrayList<h> k() {
        j();
        return this.m;
    }

    public ArrayList<h> l() {
        j();
        return this.n;
    }

    public CharSequence m() {
        return this.a;
    }

    public g n() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.u;
    }

    public h p() {
        return this.y;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        h a2 = a(i, keyEvent);
        boolean a3 = a2 != null ? a(a2, i2) : false;
        if ((i2 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int b2 = b(i);
        if (b2 >= 0) {
            int size = this.j.size() - b2;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.j.get(b2).getGroupId() != i) {
                    break;
                }
                a(b2, false);
                i2 = i3;
            }
            b(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        a(a(i), true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.j.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.a(z2);
                hVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.z = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.j.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.j.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.j.get(i2);
            if (hVar.getGroupId() == i && hVar.c(z)) {
                z2 = true;
            }
        }
        if (z2) {
            b(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.g = z;
        b(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.j.size();
    }
}
