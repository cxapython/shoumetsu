package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.a.a.c;
import androidx.core.a.a.f;
import androidx.core.d.b;

/* loaded from: classes.dex */
public class c {
    private static final h a;
    private static final androidx.b.e<String, Typeface> b;

    static {
        a = Build.VERSION.SDK_INT >= 28 ? new g() : Build.VERSION.SDK_INT >= 26 ? new f() : (Build.VERSION.SDK_INT < 24 || !e.a()) ? Build.VERSION.SDK_INT >= 21 ? new d() : new h() : new e();
        b = new androidx.b.e<>(16);
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = a.a(context, resources, i, str, i2);
        if (a2 != null) {
            b.put(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.C0022b[] c0022bArr, int i) {
        return a.a(context, cancellationSignal, c0022bArr, i);
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.b() == 0) {
                z2 = true;
            }
            a2 = androidx.core.d.b.a(context, dVar.a(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            a2 = a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.a(a2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            b.put(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return b.get(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
