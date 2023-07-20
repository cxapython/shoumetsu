package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.lang.reflect.InvocationTargetException;

@Immutable
/* loaded from: classes.dex */
public class CloneUtils {
    private CloneUtils() {
    }

    public static Object clone(Object obj) {
        return cloneObject(obj);
    }

    public static <T> T cloneObject(T t) {
        if (t == null) {
            return null;
        }
        if (!(t instanceof Cloneable)) {
            throw new CloneNotSupportedException();
        }
        try {
            try {
                return (T) t.getClass().getMethod("clone", null).invoke(t, null);
            } catch (IllegalAccessException e) {
                throw new IllegalAccessError(e.getMessage());
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (!(cause instanceof CloneNotSupportedException)) {
                    throw new Error("Unexpected exception", cause);
                }
                throw ((CloneNotSupportedException) cause);
            }
        } catch (NoSuchMethodException e3) {
            throw new NoSuchMethodError(e3.getMessage());
        }
    }
}
