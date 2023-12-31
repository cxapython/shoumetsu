package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.s;
import androidx.core.g.g;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.nearby.connection.Connections;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class d extends MenuInflater {
    static final Class<?>[] a = {Context.class};
    static final Class<?>[] b = a;
    final Object[] c;
    final Object[] d;
    Context e;
    private Object f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] a = {MenuItem.class};
        private Object b;
        private Method c;

        public a(Object obj, String str) {
            this.b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.b, menuItem)).booleanValue();
                }
                this.c.invoke(this.b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;
        androidx.core.g.b a;
        private Menu c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.c = menu;
            a();
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = d.this.e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            int i = this.x;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.B != null) {
                if (d.this.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(d.this.a(), this.B));
            }
            boolean z2 = menuItem instanceof h;
            if (z2) {
                h hVar = (h) menuItem;
            }
            if (this.t >= 2) {
                if (z2) {
                    ((h) menuItem).a(true);
                } else if (menuItem instanceof i) {
                    ((i) menuItem).a(true);
                }
            }
            String str = this.z;
            if (str != null) {
                menuItem.setActionView((View) a(str, d.a, d.this.c));
                z = true;
            }
            int i2 = this.y;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            androidx.core.g.b bVar = this.a;
            if (bVar != null) {
                g.a(menuItem, bVar);
            }
            g.a(menuItem, this.C);
            g.b(menuItem, this.D);
            g.b(menuItem, this.p, this.q);
            g.a(menuItem, this.r, this.s);
            PorterDuff.Mode mode = this.F;
            if (mode != null) {
                g.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.E;
            if (colorStateList != null) {
                g.a(menuItem, colorStateList);
            }
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = d.this.e.obtainStyledAttributes(attributeSet, a.j.MenuGroup);
            this.d = obtainStyledAttributes.getResourceId(a.j.MenuGroup_android_id, 0);
            this.e = obtainStyledAttributes.getInt(a.j.MenuGroup_android_menuCategory, 0);
            this.f = obtainStyledAttributes.getInt(a.j.MenuGroup_android_orderInCategory, 0);
            this.g = obtainStyledAttributes.getInt(a.j.MenuGroup_android_checkableBehavior, 0);
            this.h = obtainStyledAttributes.getBoolean(a.j.MenuGroup_android_visible, true);
            this.i = obtainStyledAttributes.getBoolean(a.j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b() {
            this.j = true;
            a(this.c.add(this.d, this.k, this.l, this.m));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = d.this.e.obtainStyledAttributes(attributeSet, a.j.MenuItem);
            this.k = obtainStyledAttributes.getResourceId(a.j.MenuItem_android_id, 0);
            this.l = (obtainStyledAttributes.getInt(a.j.MenuItem_android_menuCategory, this.e) & (-65536)) | (obtainStyledAttributes.getInt(a.j.MenuItem_android_orderInCategory, this.f) & GameRequest.TYPE_ALL);
            this.m = obtainStyledAttributes.getText(a.j.MenuItem_android_title);
            this.n = obtainStyledAttributes.getText(a.j.MenuItem_android_titleCondensed);
            this.o = obtainStyledAttributes.getResourceId(a.j.MenuItem_android_icon, 0);
            this.p = a(obtainStyledAttributes.getString(a.j.MenuItem_android_alphabeticShortcut));
            this.q = obtainStyledAttributes.getInt(a.j.MenuItem_alphabeticModifiers, Connections.MAX_RELIABLE_MESSAGE_LEN);
            this.r = a(obtainStyledAttributes.getString(a.j.MenuItem_android_numericShortcut));
            this.s = obtainStyledAttributes.getInt(a.j.MenuItem_numericModifiers, Connections.MAX_RELIABLE_MESSAGE_LEN);
            this.t = obtainStyledAttributes.hasValue(a.j.MenuItem_android_checkable) ? obtainStyledAttributes.getBoolean(a.j.MenuItem_android_checkable, false) : this.g;
            this.u = obtainStyledAttributes.getBoolean(a.j.MenuItem_android_checked, false);
            this.v = obtainStyledAttributes.getBoolean(a.j.MenuItem_android_visible, this.h);
            this.w = obtainStyledAttributes.getBoolean(a.j.MenuItem_android_enabled, this.i);
            this.x = obtainStyledAttributes.getInt(a.j.MenuItem_showAsAction, -1);
            this.B = obtainStyledAttributes.getString(a.j.MenuItem_android_onClick);
            this.y = obtainStyledAttributes.getResourceId(a.j.MenuItem_actionLayout, 0);
            this.z = obtainStyledAttributes.getString(a.j.MenuItem_actionViewClass);
            this.A = obtainStyledAttributes.getString(a.j.MenuItem_actionProviderClass);
            boolean z = this.A != null;
            if (z && this.y == 0 && this.z == null) {
                this.a = (androidx.core.g.b) a(this.A, d.b, d.this.d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.a = null;
            }
            this.C = obtainStyledAttributes.getText(a.j.MenuItem_contentDescription);
            this.D = obtainStyledAttributes.getText(a.j.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(a.j.MenuItem_iconTintMode)) {
                this.F = s.a(obtainStyledAttributes.getInt(a.j.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (obtainStyledAttributes.hasValue(a.j.MenuItem_iconTint)) {
                this.E = obtainStyledAttributes.getColorStateList(a.j.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            obtainStyledAttributes.recycle();
            this.j = false;
        }

        public SubMenu c() {
            this.j = true;
            SubMenu addSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.j;
        }
    }

    public d(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
        this.d = this.c;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r4 = r11;
        r6 = null;
        r11 = false;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r11 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        switch(r4) {
            case 1: goto L55;
            case 2: goto L39;
            case 3: goto L10;
            default: goto L59;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        r4 = r9.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r5 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r4.equals(r6) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        r6 = null;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r4.equals("group") == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
        if (r4.equals("item") == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r0.d() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
        if (r0.a == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
        if (r0.a.c() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
        r0.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
        if (r4.equals("menu") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
        if (r5 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0094, code lost:
        r4 = r9.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009e, code lost:
        if (r4.equals("group") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
        r0.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:
        if (r4.equals("item") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ac, code lost:
        r0.b(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b6, code lost:
        if (r4.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b8, code lost:
        a(r9, r10, r0.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c0, code lost:
        r6 = r4;
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ca, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cb, code lost:
        r4 = r9.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d1, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            }
        }
    }

    Object a() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof androidx.core.b.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.e.getResources().getLayout(i);
                    a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
