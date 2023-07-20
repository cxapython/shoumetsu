package androidx.h.a;

import androidx.lifecycle.g;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0033a<D> {
        void a(androidx.h.b.a<D> aVar);

        void a(androidx.h.b.a<D> aVar, D d);
    }

    public static <T extends g & s> a a(T t) {
        return new b(t, t.getViewModelStore());
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
