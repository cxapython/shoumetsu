package androidx.e.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* loaded from: classes.dex */
public abstract class f {
    public abstract View a(int i);

    public d a(Context context, String str, Bundle bundle) {
        return d.instantiate(context, str, bundle);
    }

    public abstract boolean a();
}
