package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.a;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class g {
    private static g b;
    private WeakHashMap<Context, androidx.b.h<ColorStateList>> j;
    private androidx.b.a<String, d> k;
    private androidx.b.h<String> l;
    private final WeakHashMap<Context, androidx.b.d<WeakReference<Drawable.ConstantState>>> m = new WeakHashMap<>(0);
    private TypedValue n;
    private boolean o;
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private static final c c = new c(6);
    private static final int[] d = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};
    private static final int[] i = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.g.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.appcompat.b.a.a.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.g.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.i.a.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends androidx.b.e<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e implements d {
        e() {
        }

        @Override // androidx.appcompat.widget.g.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.i.a.a.i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private ColorStateList a(Context context) {
        return f(context, ae.a(context, a.C0010a.colorButtonNormal));
    }

    static PorterDuff.Mode a(int i2) {
        if (i2 == a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (g.class) {
            a2 = c.a(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                c.a(i2, mode, a2);
            }
        }
        return a2;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        LayerDrawable layerDrawable;
        Drawable findDrawableByLayerId;
        int i3;
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (s.b(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable f2 = androidx.core.graphics.drawable.a.f(drawable);
            androidx.core.graphics.drawable.a.a(f2, b2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 == null) {
                return f2;
            }
            androidx.core.graphics.drawable.a.a(f2, a2);
            return f2;
        }
        if (i2 == a.e.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ae.a(context, a.C0010a.colorControlNormal), a);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i3 = a.C0010a.colorControlNormal;
        } else if (i2 != a.e.abc_ratingbar_material && i2 != a.e.abc_ratingbar_indicator_material && i2 != a.e.abc_ratingbar_small_material) {
            if (!a(context, i2, drawable) && z) {
                return null;
            }
            return drawable;
        } else {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ae.c(context, a.C0010a.colorControlNormal), a);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i3 = a.C0010a.colorControlActivated;
        }
        a(findDrawableByLayerId, ae.a(context, i3), a);
        a(layerDrawable.findDrawableByLayerId(16908301), ae.a(context, a.C0010a.colorControlActivated), a);
        return drawable;
    }

    private synchronized Drawable a(Context context, long j) {
        androidx.b.d<WeakReference<Drawable.ConstantState>> dVar = this.m.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> a2 = dVar.a(j);
        if (a2 != null) {
            Drawable.ConstantState constantState = a2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.b(j);
        }
        return null;
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (b == null) {
                b = new g();
                a(b);
            }
            gVar = b;
        }
        return gVar;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap<>();
        }
        androidx.b.h<ColorStateList> hVar = this.j.get(context);
        if (hVar == null) {
            hVar = new androidx.b.h<>();
            this.j.put(context, hVar);
        }
        hVar.c(i2, colorStateList);
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (s.b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable, ah ahVar, int[] iArr) {
        if (s.b(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (ahVar.d || ahVar.c) {
            drawable.setColorFilter(a(ahVar.d ? ahVar.a : null, ahVar.c ? ahVar.b : a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT > 23) {
            return;
        }
        drawable.invalidateSelf();
    }

    private static void a(g gVar) {
        if (Build.VERSION.SDK_INT < 24) {
            gVar.a("vector", new e());
            gVar.a("animated-vector", new b());
            gVar.a("animated-selector", new a());
        }
    }

    private void a(String str, d dVar) {
        if (this.k == null) {
            this.k = new androidx.b.a<>();
        }
        this.k.put(str, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, int i2, Drawable drawable) {
        boolean z;
        int i3;
        PorterDuff.Mode mode = a;
        int i4 = 16842801;
        if (a(d, i2)) {
            i4 = a.C0010a.colorControlNormal;
        } else if (a(f, i2)) {
            i4 = a.C0010a.colorControlActivated;
        } else if (!a(g, i2)) {
            if (i2 == a.e.abc_list_divider_mtrl_alpha) {
                i4 = 16842800;
                i3 = Math.round(40.8f);
                z = true;
            } else if (i2 != a.e.abc_dialog_material_background) {
                z = false;
                i3 = -1;
                i4 = 0;
            }
            if (z) {
                return false;
            }
            if (s.b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(a(ae.a(context, i4), mode));
            if (i3 != -1) {
                drawable.setAlpha(i3);
            }
            return true;
        } else {
            mode = PorterDuff.Mode.MULTIPLY;
        }
        z = true;
        i3 = -1;
        if (z) {
        }
    }

    private synchronized boolean a(Context context, long j, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            androidx.b.d<WeakReference<Drawable.ConstantState>> dVar = this.m.get(context);
            if (dVar == null) {
                dVar = new androidx.b.d<>();
                this.m.put(context, dVar);
            }
            dVar.b(j, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof androidx.i.a.a.i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList b(Context context) {
        return f(context, 0);
    }

    private ColorStateList c(Context context) {
        return f(context, ae.a(context, a.C0010a.colorAccent));
    }

    private Drawable c(Context context, int i2) {
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        if (i2 == a.e.abc_cab_background_top_material) {
            a3 = new LayerDrawable(new Drawable[]{a(context, a.e.abc_cab_background_internal_bg), a(context, a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a3);
        }
        return a3;
    }

    private ColorStateList d(Context context) {
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        ColorStateList b2 = ae.b(context, a.C0010a.colorSwitchThumbNormal);
        if (b2 == null || !b2.isStateful()) {
            iArr[0] = ae.a;
            iArr2[0] = ae.c(context, a.C0010a.colorSwitchThumbNormal);
            iArr[1] = ae.e;
            iArr2[1] = ae.a(context, a.C0010a.colorControlActivated);
            iArr[2] = ae.h;
            iArr2[2] = ae.a(context, a.C0010a.colorSwitchThumbNormal);
        } else {
            iArr[0] = ae.a;
            iArr2[0] = b2.getColorForState(iArr[0], 0);
            iArr[1] = ae.e;
            iArr2[1] = ae.a(context, a.C0010a.colorControlActivated);
            iArr[2] = ae.h;
            iArr2[2] = b2.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private Drawable d(Context context, int i2) {
        int next;
        androidx.b.a<String, d> aVar = this.k;
        if (aVar == null || aVar.isEmpty()) {
            return null;
        }
        androidx.b.h<String> hVar = this.l;
        if (hVar != null) {
            String a2 = hVar.a(i2);
            if ("appcompat_skip_skip".equals(a2) || (a2 != null && this.k.get(a2) == null)) {
                return null;
            }
        } else {
            this.l = new androidx.b.h<>();
        }
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long a3 = a(typedValue);
        Drawable a4 = a(context, a3);
        if (a4 != null) {
            return a4;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.l.c(i2, name);
                d dVar = this.k.get(name);
                if (dVar != null) {
                    a4 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a4 != null) {
                    a4.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a3, a4);
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (a4 == null) {
            this.l.c(i2, "appcompat_skip_skip");
        }
        return a4;
    }

    private ColorStateList e(Context context, int i2) {
        androidx.b.h<ColorStateList> hVar;
        WeakHashMap<Context, androidx.b.h<ColorStateList>> weakHashMap = this.j;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.a(i2);
    }

    private void e(Context context) {
        if (this.o) {
            return;
        }
        this.o = true;
        Drawable a2 = a(context, a.e.abc_vector_test);
        if (a2 != null && a(a2)) {
            return;
        }
        this.o = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    private ColorStateList f(Context context, int i2) {
        int a2 = ae.a(context, a.C0010a.colorControlHighlight);
        return new ColorStateList(new int[][]{ae.a, ae.d, ae.b, ae.h}, new int[]{ae.c(context, a.C0010a.colorButtonNormal), androidx.core.graphics.a.a(a2, i2), androidx.core.graphics.a.a(a2, i2), i2});
    }

    public synchronized Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable d2;
        e(context);
        d2 = d(context, i2);
        if (d2 == null) {
            d2 = c(context, i2);
        }
        if (d2 == null) {
            d2 = androidx.core.a.a.a(context, i2);
        }
        if (d2 != null) {
            d2 = a(context, i2, z, d2);
        }
        if (d2 != null) {
            s.a(d2);
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, ao aoVar, int i2) {
        Drawable d2 = d(context, i2);
        if (d2 == null) {
            d2 = aoVar.a(i2);
        }
        if (d2 != null) {
            return a(context, i2, false, d2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:43:0x0078, B:9:0x0013, B:11:0x0017, B:12:0x001a, B:14:0x001e, B:15:0x0023, B:17:0x0027, B:18:0x002c, B:20:0x0030, B:21:0x0035, B:23:0x0039, B:24:0x003e, B:26:0x0042, B:29:0x0047, B:31:0x004f, B:32:0x0056, B:34:0x005e, B:35:0x0061, B:37:0x0069, B:38:0x006c, B:40:0x0070, B:41:0x0073), top: B:49:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized ColorStateList b(Context context, int i2) {
        ColorStateList e2;
        int i3;
        e2 = e(context, i2);
        if (e2 == null) {
            if (i2 == a.e.abc_edit_text_material) {
                i3 = a.c.abc_tint_edittext;
            } else if (i2 == a.e.abc_switch_track_mtrl_alpha) {
                i3 = a.c.abc_tint_switch_track;
            } else {
                if (i2 == a.e.abc_switch_thumb_material) {
                    e2 = d(context);
                } else if (i2 == a.e.abc_btn_default_mtrl_shape) {
                    e2 = a(context);
                } else if (i2 == a.e.abc_btn_borderless_material) {
                    e2 = b(context);
                } else if (i2 == a.e.abc_btn_colored_material) {
                    e2 = c(context);
                } else {
                    if (i2 != a.e.abc_spinner_mtrl_am_alpha && i2 != a.e.abc_spinner_textfield_background_material) {
                        if (a(e, i2)) {
                            e2 = ae.b(context, a.C0010a.colorControlNormal);
                        } else if (a(h, i2)) {
                            i3 = a.c.abc_tint_default;
                        } else if (a(i, i2)) {
                            i3 = a.c.abc_tint_btn_checkable;
                        } else if (i2 == a.e.abc_seekbar_thumb_material) {
                            i3 = a.c.abc_tint_seek_thumb;
                        }
                    }
                    i3 = a.c.abc_tint_spinner;
                }
                if (e2 != null) {
                    a(context, i2, e2);
                }
            }
            e2 = androidx.appcompat.a.a.a.a(context, i3);
            if (e2 != null) {
            }
        }
        return e2;
    }
}
