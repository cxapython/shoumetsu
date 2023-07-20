package androidx.h.a;

import android.os.Bundle;
import android.util.Log;
import androidx.b.h;
import androidx.h.a.a;
import androidx.h.b.a;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends androidx.h.a.a {
    static boolean a = false;
    private final g b;
    private final c c;

    /* loaded from: classes.dex */
    public static class a<D> extends l<D> implements a.InterfaceC0035a<D> {
        private final int e;
        private final Bundle f;
        private final androidx.h.b.a<D> g;
        private g h;
        private C0034b<D> i;
        private androidx.h.b.a<D> j;

        androidx.h.b.a<D> a(boolean z) {
            if (b.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.g.c();
            this.g.g();
            C0034b<D> c0034b = this.i;
            if (c0034b != null) {
                a((m) c0034b);
                if (z) {
                    c0034b.b();
                }
            }
            this.g.a((a.InterfaceC0035a) this);
            if ((c0034b == null || c0034b.a()) && !z) {
                return this.g;
            }
            this.g.i();
            return this.j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a(m<? super D> mVar) {
            super.a((m) mVar);
            this.h = null;
            this.i = null;
        }

        @Override // androidx.lifecycle.l, androidx.lifecycle.LiveData
        public void a(D d) {
            super.a((a<D>) d);
            androidx.h.b.a<D> aVar = this.j;
            if (aVar != null) {
                aVar.i();
                this.j = null;
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.g);
            androidx.h.b.a<D> aVar = this.g;
            aVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i);
                C0034b<D> c0034b = this.i;
                c0034b.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().a((androidx.h.b.a<D>) a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }

        @Override // androidx.lifecycle.LiveData
        protected void b() {
            if (b.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.g.a();
        }

        @Override // androidx.lifecycle.LiveData
        protected void c() {
            if (b.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.g.e();
        }

        androidx.h.b.a<D> e() {
            return this.g;
        }

        void f() {
            g gVar = this.h;
            C0034b<D> c0034b = this.i;
            if (gVar == null || c0034b == null) {
                return;
            }
            super.a((m) c0034b);
            a(gVar, c0034b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.e);
            sb.append(" : ");
            androidx.core.f.a.a(this.g, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034b<D> implements m<D> {
        private final androidx.h.b.a<D> a;
        private final a.InterfaceC0033a<D> b;
        private boolean c;

        @Override // androidx.lifecycle.m
        public void a(D d) {
            if (b.a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.a((androidx.h.b.a<D>) d));
            }
            this.b.a(this.a, d);
            this.c = true;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        boolean a() {
            return this.c;
        }

        void b() {
            if (this.c) {
                if (b.a) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.b.a(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }
    }

    /* loaded from: classes.dex */
    static class c extends p {
        private static final q.a a = new q.a() { // from class: androidx.h.a.b.c.1
            @Override // androidx.lifecycle.q.a
            public <T extends p> T a(Class<T> cls) {
                return new c();
            }
        };
        private h<a> b = new h<>();
        private boolean c = false;

        c() {
        }

        static c a(r rVar) {
            return (c) new q(rVar, a).a(c.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.p
        public void a() {
            super.a();
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.e(i).a(true);
            }
            this.b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.b.b(); i++) {
                    a e = this.b.e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.d(i));
                    printWriter.print(": ");
                    printWriter.println(e.toString());
                    e.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void b() {
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.e(i).f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, r rVar) {
        this.b = gVar;
        this.c = c.a(rVar);
    }

    @Override // androidx.h.a.a
    public void a() {
        this.c.b();
    }

    @Override // androidx.h.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.f.a.a(this.b, sb);
        sb.append("}}");
        return sb.toString();
    }
}
