package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class a {
    protected static <T extends c> T a(String str, a aVar) {
        try {
            return (T) Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class).invoke(null, aVar);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (!(e4.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((RuntimeException) e4.getCause());
        }
    }

    private static Class a(Class<? extends c> cls) {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }

    protected static <T extends c> void a(T t, a aVar) {
        try {
            c(t).getDeclaredMethod("write", t.getClass(), a.class).invoke(null, t, aVar);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (!(e4.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((RuntimeException) e4.getCause());
        }
    }

    private void b(c cVar) {
        try {
            a(a((Class<? extends c>) cVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    private static <T extends c> Class c(T t) {
        return a((Class<? extends c>) t.getClass());
    }

    protected abstract void a(int i);

    public void a(int i, int i2) {
        c(i2);
        a(i);
    }

    protected abstract void a(Parcelable parcelable);

    public void a(Parcelable parcelable, int i) {
        c(i);
        a(parcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        if (cVar == null) {
            a((String) null);
            return;
        }
        b(cVar);
        a c = c();
        a(cVar, c);
        c.b();
    }

    public void a(c cVar, int i) {
        c(i);
        a(cVar);
    }

    protected abstract void a(String str);

    public void a(String str, int i) {
        c(i);
        a(str);
    }

    public void a(boolean z, boolean z2) {
    }

    protected abstract void a(byte[] bArr);

    public void a(byte[] bArr, int i) {
        c(i);
        a(bArr);
    }

    public boolean a() {
        return false;
    }

    public int b(int i, int i2) {
        return !b(i2) ? i : d();
    }

    public <T extends Parcelable> T b(T t, int i) {
        return !b(i) ? t : (T) g();
    }

    public <T extends c> T b(T t, int i) {
        return !b(i) ? t : (T) h();
    }

    public String b(String str, int i) {
        return !b(i) ? str : e();
    }

    protected abstract void b();

    protected abstract boolean b(int i);

    public byte[] b(byte[] bArr, int i) {
        return !b(i) ? bArr : f();
    }

    protected abstract a c();

    protected abstract void c(int i);

    protected abstract int d();

    protected abstract String e();

    protected abstract byte[] f();

    protected abstract <T extends Parcelable> T g();

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends c> T h() {
        String e = e();
        if (e == null) {
            return null;
        }
        return (T) a(e, c());
    }
}
