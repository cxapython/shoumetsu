package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ao extends Resources {
    private static boolean a = false;
    private final WeakReference<Context> b;

    public ao(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.b = new WeakReference<>(context);
    }

    public static boolean a() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    public static boolean b() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable a(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.b.get();
        return context != null ? g.a().a(context, this, i) : super.getDrawable(i);
    }
}
