package androidx.core.f;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public class c {
    public static int a(Object... objArr) {
        return Build.VERSION.SDK_INT >= 19 ? Objects.hash(objArr) : Arrays.hashCode(objArr);
    }
}
