package androidx.core.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.a;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {
        final int[] a;
        final float[] b;

        a(int i, int i2) {
            this.a = new int[]{i, i2};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.a = new int[]{i, i2, i3};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.a[i] = list.get(i).intValue();
                this.b[i] = list2.get(i).floatValue();
            }
        }
    }

    private static Shader.TileMode a(int i) {
        switch (i) {
            case 1:
                return Shader.TileMode.REPEAT;
            case 2:
                return Shader.TileMode.MIRROR;
            default:
                return Shader.TileMode.CLAMP;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray a2 = g.a(resources, theme, attributeSet, a.d.GradientColor);
        float a3 = g.a(a2, xmlPullParser, "startX", a.d.GradientColor_android_startX, 0.0f);
        float a4 = g.a(a2, xmlPullParser, "startY", a.d.GradientColor_android_startY, 0.0f);
        float a5 = g.a(a2, xmlPullParser, "endX", a.d.GradientColor_android_endX, 0.0f);
        float a6 = g.a(a2, xmlPullParser, "endY", a.d.GradientColor_android_endY, 0.0f);
        float a7 = g.a(a2, xmlPullParser, "centerX", a.d.GradientColor_android_centerX, 0.0f);
        float a8 = g.a(a2, xmlPullParser, "centerY", a.d.GradientColor_android_centerY, 0.0f);
        int a9 = g.a(a2, xmlPullParser, net.gree.gamelib.payment.internal.a.e.J, a.d.GradientColor_android_type, 0);
        int b = g.b(a2, xmlPullParser, "startColor", a.d.GradientColor_android_startColor, 0);
        boolean a10 = g.a(xmlPullParser, "centerColor");
        int b2 = g.b(a2, xmlPullParser, "centerColor", a.d.GradientColor_android_centerColor, 0);
        int b3 = g.b(a2, xmlPullParser, "endColor", a.d.GradientColor_android_endColor, 0);
        int a11 = g.a(a2, xmlPullParser, "tileMode", a.d.GradientColor_android_tileMode, 0);
        float a12 = g.a(a2, xmlPullParser, "gradientRadius", a.d.GradientColor_android_gradientRadius, 0.0f);
        a2.recycle();
        a a13 = a(b(resources, xmlPullParser, attributeSet, theme), b, b3, a10, b2);
        switch (a9) {
            case 1:
                if (a12 <= 0.0f) {
                    throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                }
                return new RadialGradient(a7, a8, a12, a13.a, a13.b, a(a11));
            case 2:
                return new SweepGradient(a7, a8, a13.a, a13.b);
            default:
                return new LinearGradient(a3, a4, a5, a6, a13.a, a13.b, a(a11));
        }
    }

    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        return aVar != null ? aVar : z ? new a(i, i3, i2) : new a(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray a2 = g.a(resources, theme, attributeSet, a.d.GradientColorItem);
                boolean hasValue = a2.hasValue(a.d.GradientColorItem_android_color);
                boolean hasValue2 = a2.hasValue(a.d.GradientColorItem_android_offset);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = a2.getColor(a.d.GradientColorItem_android_color, 0);
                float f = a2.getFloat(a.d.GradientColorItem_android_offset, 0.0f);
                a2.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }
}
