package androidx.core.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class b {
    private final Shader a;
    private final ColorStateList b;
    private int c;

    private b(Shader shader, ColorStateList colorStateList, int i) {
        this.a = shader;
        this.b = colorStateList;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(int i) {
        return new b(null, null, i);
    }

    static b a(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static b a(Resources resources, int i, Resources.Theme theme) {
        try {
            return b(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    static b a(Shader shader) {
        return new b(shader, null, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.equals("gradient") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b b(Resources resources, int i, Resources.Theme theme) {
        int next;
        char c;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            c = 1;
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c = 0;
                }
                c = 65535;
            }
            switch (c) {
                case 0:
                    return a(a.a(resources, xml, asAttributeSet, theme));
                case 1:
                    return a(d.a(resources, xml, asAttributeSet, theme));
                default:
                    throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
        }
        throw new XmlPullParserException("No start tag found");
    }

    public Shader a() {
        return this.a;
    }

    public boolean a(int[] iArr) {
        if (d()) {
            ColorStateList colorStateList = this.b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.c) {
                this.c = colorForState;
                return true;
            }
        }
        return false;
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public boolean c() {
        return this.a != null;
    }

    public boolean d() {
        ColorStateList colorStateList;
        return this.a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }

    public boolean e() {
        return c() || this.c != 0;
    }
}
