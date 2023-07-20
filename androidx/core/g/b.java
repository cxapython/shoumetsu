package androidx.core.g;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {
    private final Context a;
    private a b;
    private InterfaceC0027b c;

    /* loaded from: classes.dex */
    public interface a {
        void d(boolean z);
    }

    /* renamed from: androidx.core.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0027b {
        void a(boolean z);
    }

    public b(Context context) {
        this.a = context;
    }

    public abstract View a();

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(SubMenu subMenu) {
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(InterfaceC0027b interfaceC0027b) {
        if (this.c != null && interfaceC0027b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = interfaceC0027b;
    }

    public void a(boolean z) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.d(z);
        }
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public void f() {
        this.c = null;
        this.b = null;
    }
}
