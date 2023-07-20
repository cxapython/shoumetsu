package androidx.core.g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* loaded from: classes.dex */
public final class g {
    public static MenuItem a(MenuItem menuItem, b bVar) {
        if (menuItem instanceof androidx.core.b.a.b) {
            return ((androidx.core.b.a.b) menuItem).a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).setNumericShortcut(c, i);
        } else if (Build.VERSION.SDK_INT < 26) {
        } else {
            menuItem.setNumericShortcut(c, i);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT < 26) {
        } else {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT < 26) {
        } else {
            menuItem.setIconTintMode(mode);
        }
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).a(charSequence);
        } else if (Build.VERSION.SDK_INT < 26) {
        } else {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).setAlphabeticShortcut(c, i);
        } else if (Build.VERSION.SDK_INT < 26) {
        } else {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).b(charSequence);
        } else if (Build.VERSION.SDK_INT < 26) {
        } else {
            menuItem.setTooltipText(charSequence);
        }
    }
}
