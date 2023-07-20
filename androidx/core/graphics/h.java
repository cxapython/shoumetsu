package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.a.a.c;
import androidx.core.d.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    private c.C0020c a(c.b bVar, int i) {
        return (c.C0020c) a(bVar.a(), i, new a<c.C0020c>() { // from class: androidx.core.graphics.h.2
            @Override // androidx.core.graphics.h.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public int b(c.C0020c c0020c) {
                return c0020c.b();
            }

            @Override // androidx.core.graphics.h.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(c.C0020c c0020c) {
                return c0020c.c();
            }
        });
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.b(t2) - i2) * 2) + (aVar.a(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File a2 = i.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (i.a(a2, resources, i)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0022b[] c0022bArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (c0022bArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(c0022bArr, i).a());
            try {
                Typeface a2 = a(context, inputStream);
                i.a(inputStream);
                return a2;
            } catch (IOException unused) {
                i.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                i.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0020c a2 = a(bVar, i);
        if (a2 == null) {
            return null;
        }
        return c.a(context, resources, a2.f(), a2.a(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = i.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (i.a(a2, inputStream)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b.C0022b a(b.C0022b[] c0022bArr, int i) {
        return (b.C0022b) a(c0022bArr, i, new a<b.C0022b>() { // from class: androidx.core.graphics.h.1
            @Override // androidx.core.graphics.h.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public int b(b.C0022b c0022b) {
                return c0022b.c();
            }

            @Override // androidx.core.graphics.h.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(b.C0022b c0022b) {
                return c0022b.d();
            }
        });
    }
}
