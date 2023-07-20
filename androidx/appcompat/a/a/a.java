package androidx.appcompat.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.g;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<C0011a>> b = new WeakHashMap<>(0);
    private static final Object c = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0011a {
        final ColorStateList a;
        final Configuration b;

        C0011a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d = d(context, i);
        if (d != null) {
            return d;
        }
        ColorStateList c2 = c(context, i);
        if (c2 == null) {
            return androidx.core.a.a.b(context, i);
        }
        a(context, i, c2);
        return c2;
    }

    private static TypedValue a() {
        TypedValue typedValue = a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (c) {
            SparseArray<C0011a> sparseArray = b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0011a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    public static Drawable b(Context context, int i) {
        return g.a().a(context, i);
    }

    private static ColorStateList c(Context context, int i) {
        if (e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.a.a.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static ColorStateList d(Context context, int i) {
        C0011a c0011a;
        synchronized (c) {
            SparseArray<C0011a> sparseArray = b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0011a = sparseArray.get(i)) != null) {
                if (c0011a.b.equals(context.getResources().getConfiguration())) {
                    return c0011a.a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static boolean e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i, a2, true);
        return a2.type >= 28 && a2.type <= 31;
    }
}
