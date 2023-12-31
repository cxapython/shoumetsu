package cz.msebera.android.httpclient.util;

import java.util.Collection;

/* loaded from: classes.dex */
public class Args {
    public static void check(boolean z, String str) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public static void check(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format(str, obj));
    }

    public static void check(boolean z, String str, Object... objArr) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static <T extends CharSequence> T containsNoBlanks(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!TextUtils.containsBlanks(t)) {
            return t;
        } else {
            throw new IllegalArgumentException(str + " may not contain blanks");
        }
    }

    public static <T extends CharSequence> T notBlank(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!TextUtils.isBlank(t)) {
            return t;
        } else {
            throw new IllegalArgumentException(str + " may not be blank");
        }
    }

    public static <T extends CharSequence> T notEmpty(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!TextUtils.isEmpty(t)) {
            return t;
        } else {
            throw new IllegalArgumentException(str + " may not be empty");
        }
    }

    public static <E, T extends Collection<E>> T notEmpty(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!t.isEmpty()) {
            return t;
        } else {
            throw new IllegalArgumentException(str + " may not be empty");
        }
    }

    public static int notNegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static long notNegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static <T> T notNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static int positive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    public static long positive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }
}
