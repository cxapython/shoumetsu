package androidx.core.g;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class s {
    private WeakReference<View> a;

    public void a() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }
}
