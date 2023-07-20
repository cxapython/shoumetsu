package cz.msebera.android.httpclient.util;

/* loaded from: classes.dex */
public class Asserts {
    public static void check(boolean z, String str) {
        if (z) {
            return;
        }
        throw new IllegalStateException(str);
    }

    public static void check(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalStateException(String.format(str, obj));
    }

    public static void check(boolean z, String str, Object... objArr) {
        if (z) {
            return;
        }
        throw new IllegalStateException(String.format(str, objArr));
    }

    public static void notBlank(CharSequence charSequence, String str) {
        if (!TextUtils.isBlank(charSequence)) {
            return;
        }
        throw new IllegalStateException(str + " is blank");
    }

    public static void notEmpty(CharSequence charSequence, String str) {
        if (!TextUtils.isEmpty(charSequence)) {
            return;
        }
        throw new IllegalStateException(str + " is empty");
    }

    public static void notNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalStateException(str + " is null");
    }
}
