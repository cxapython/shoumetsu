package androidx.core.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.a.a.c;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class f {

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void a(int i);

        public final void a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: androidx.core.a.a.f.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(i);
                }
            });
        }

        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: androidx.core.a.a.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(typeface);
                }
            });
        }
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, aVar, null, true);
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (a2 == null && aVar == null) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface a(Context context, Resources resources, TypedValue typedValue, int i, int i2, a aVar, Handler handler, boolean z) {
        String str;
        StringBuilder sb;
        String str2;
        if (typedValue.string == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (!charSequence.startsWith("res/")) {
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        }
        Typeface a2 = androidx.core.graphics.c.a(resources, i, i2);
        if (a2 != null) {
            if (aVar != null) {
                aVar.a(a2, handler);
            }
            return a2;
        }
        try {
            if (!charSequence.toLowerCase().endsWith(".xml")) {
                Typeface a3 = androidx.core.graphics.c.a(context, resources, i, charSequence, i2);
                if (aVar != null) {
                    if (a3 != null) {
                        aVar.a(a3, handler);
                    } else {
                        aVar.a(-3, handler);
                    }
                }
                return a3;
            }
            c.a a4 = c.a(resources.getXml(i), resources);
            if (a4 != null) {
                return androidx.core.graphics.c.a(context, a4, resources, i, i2, aVar, handler, z);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        } catch (IOException e) {
            e = e;
            str = "ResourcesCompat";
            sb = new StringBuilder();
            str2 = "Failed to read xml resource ";
            sb.append(str2);
            sb.append(charSequence);
            Log.e(str, sb.toString(), e);
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e2) {
            e = e2;
            str = "ResourcesCompat";
            sb = new StringBuilder();
            str2 = "Failed to parse xml resource ";
            sb.append(str2);
            sb.append(charSequence);
            Log.e(str, sb.toString(), e);
            if (aVar != null) {
            }
            return null;
        }
    }

    public static Drawable a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }
}
