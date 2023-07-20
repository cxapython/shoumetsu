package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Build;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
public final class o {
    public static MenuItem a(Context context, androidx.core.b.a.b bVar) {
        return Build.VERSION.SDK_INT >= 16 ? new j(context, bVar) : new i(context, bVar);
    }

    public static SubMenu a(Context context, androidx.core.b.a.c cVar) {
        return new t(context, cVar);
    }
}
