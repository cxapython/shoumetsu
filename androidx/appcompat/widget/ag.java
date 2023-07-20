package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ag extends ContextWrapper {
    private static final Object a = new Object();
    private static ArrayList<WeakReference<ag>> b;
    private final Resources c;
    private final Resources.Theme d;

    private ag(Context context) {
        super(context);
        if (!ao.a()) {
            this.c = new ai(this, context.getResources());
            this.d = null;
            return;
        }
        this.c = new ao(this, context.getResources());
        this.d = this.c.newTheme();
        this.d.setTo(context.getTheme());
    }

    public static Context a(Context context) {
        if (b(context)) {
            synchronized (a) {
                if (b == null) {
                    b = new ArrayList<>();
                } else {
                    for (int size = b.size() - 1; size >= 0; size--) {
                        WeakReference<ag> weakReference = b.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            b.remove(size);
                        }
                    }
                    for (int size2 = b.size() - 1; size2 >= 0; size2--) {
                        WeakReference<ag> weakReference2 = b.get(size2);
                        ag agVar = weakReference2 != null ? weakReference2.get() : null;
                        if (agVar != null && agVar.getBaseContext() == context) {
                            return agVar;
                        }
                    }
                }
                ag agVar2 = new ag(context);
                b.add(new WeakReference<>(agVar2));
                return agVar2;
            }
        }
        return context;
    }

    private static boolean b(Context context) {
        if ((context instanceof ag) || (context.getResources() instanceof ai) || (context.getResources() instanceof ao)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || ao.a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.c.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
