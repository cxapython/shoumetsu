package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class ai extends aa {
    private final WeakReference<Context> a;

    public ai(Context context, Resources resources) {
        super(resources);
        this.a = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.aa, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.a.get();
        if (drawable != null && context != null) {
            g.a();
            g.a(context, i, drawable);
        }
        return drawable;
    }
}
