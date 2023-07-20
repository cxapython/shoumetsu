package androidx.h.b;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class a<D> {
    int a;
    InterfaceC0035a<D> b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    /* renamed from: androidx.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0035a<D> {
    }

    public String a(D d) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.f.a.a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
        b();
    }

    public void a(InterfaceC0035a<D> interfaceC0035a) {
        InterfaceC0035a<D> interfaceC0035a2 = this.b;
        if (interfaceC0035a2 != null) {
            if (interfaceC0035a2 != interfaceC0035a) {
                throw new IllegalArgumentException("Attempting to unregister the wrong listener");
            }
            this.b = null;
            return;
        }
        throw new IllegalStateException("No listener register");
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.c || this.f || this.g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g);
        }
        if (this.d || this.e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d);
            printWriter.print(" mReset=");
            printWriter.println(this.e);
        }
    }

    protected void b() {
    }

    public boolean c() {
        return d();
    }

    protected boolean d() {
        return false;
    }

    public void e() {
        this.c = false;
        f();
    }

    protected void f() {
    }

    public void g() {
        this.d = true;
        h();
    }

    protected void h() {
    }

    public void i() {
        j();
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }

    protected void j() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.f.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}
