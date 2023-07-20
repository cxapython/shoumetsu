package androidx.core.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.core.a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class a {
    private static int a(int i, float f) {
        return (i & 16777215) | (Math.round(Color.alpha(i) * f) << 24);
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return a(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int i;
        int attributeCount;
        int i2;
        int i3 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[iArr.length];
        int i4 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i3 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray a = a(resources, theme, attributeSet, a.d.ColorStateListItem);
                int color = a.getColor(a.d.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (a.hasValue(a.d.ColorStateListItem_android_alpha)) {
                    i = a.d.ColorStateListItem_android_alpha;
                } else {
                    if (a.hasValue(a.d.ColorStateListItem_alpha)) {
                        i = a.d.ColorStateListItem_alpha;
                    }
                    a.recycle();
                    attributeCount = attributeSet.getAttributeCount();
                    int[] iArr3 = new int[attributeCount];
                    int i5 = 0;
                    for (i2 = 0; i2 < attributeCount; i2++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                        if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != a.C0019a.alpha) {
                            int i6 = i5 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr3[i5] = attributeNameResource;
                            i5 = i6;
                        }
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr3, i5);
                    int a2 = a(color, f);
                    if (i4 != 0) {
                        int length = trimStateSet.length;
                    }
                    iArr2 = e.a(iArr2, i4, a2);
                    iArr = (int[][]) e.a(iArr, i4, trimStateSet);
                    i4++;
                }
                f = a.getFloat(i, 1.0f);
                a.recycle();
                attributeCount = attributeSet.getAttributeCount();
                int[] iArr32 = new int[attributeCount];
                int i52 = 0;
                while (i2 < attributeCount) {
                }
                int[] trimStateSet2 = StateSet.trimStateSet(iArr32, i52);
                int a22 = a(color, f);
                if (i4 != 0) {
                }
                iArr2 = e.a(iArr2, i4, a22);
                iArr = (int[][]) e.a(iArr, i4, trimStateSet2);
                i4++;
            }
            i3 = 1;
        }
        int[] iArr4 = new int[i4];
        int[][] iArr5 = new int[i4];
        System.arraycopy(iArr2, 0, iArr4, 0, i4);
        System.arraycopy(iArr, 0, iArr5, 0, i4);
        return new ColorStateList(iArr5, iArr4);
    }
}
