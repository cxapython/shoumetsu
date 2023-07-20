package androidx.e.a;

import android.util.Log;
import androidx.e.a.d;
import androidx.e.a.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends n implements j.h {
    final j a;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    String k;
    boolean l;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    ArrayList<Runnable> u;
    ArrayList<C0030a> b = new ArrayList<>();
    boolean j = true;
    int m = -1;
    boolean t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0030a {
        int a;
        d b;
        int c;
        int d;
        int e;
        int f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0030a() {
        }

        C0030a(int i, d dVar) {
            this.a = i;
            this.b = dVar;
        }
    }

    public a(j jVar) {
        this.a = jVar;
    }

    private void a(int i, d dVar, String str, int i2) {
        Class<?> cls = dVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        dVar.mFragmentManager = this.a;
        if (str != null) {
            if (dVar.mTag != null && !str.equals(dVar.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + dVar + ": was " + dVar.mTag + " now " + str);
            }
            dVar.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + dVar + " with tag " + str + " to container view with no id");
            } else if (dVar.mFragmentId != 0 && dVar.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + dVar + ": was " + dVar.mFragmentId + " now " + i);
            } else {
                dVar.mFragmentId = i;
                dVar.mContainerId = i;
            }
        }
        a(new C0030a(i2, dVar));
    }

    private static boolean b(C0030a c0030a) {
        d dVar = c0030a.b;
        return dVar != null && dVar.mAdded && dVar.mView != null && !dVar.mDetached && !dVar.mHidden && dVar.isPostponed();
    }

    int a(boolean z) {
        if (!this.l) {
            if (j.a) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new androidx.core.f.b("FragmentManager"));
                a("  ", (FileDescriptor) null, printWriter, (String[]) null);
                printWriter.close();
            }
            this.l = true;
            this.m = this.i ? this.a.a(this) : -1;
            this.a.a(this, z);
            return this.m;
        }
        throw new IllegalStateException("commit already called");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(ArrayList<d> arrayList, d dVar) {
        d dVar2 = dVar;
        int i = 0;
        while (i < this.b.size()) {
            C0030a c0030a = this.b.get(i);
            switch (c0030a.a) {
                case 1:
                case 7:
                    arrayList.add(c0030a.b);
                    break;
                case 2:
                    d dVar3 = c0030a.b;
                    int i2 = dVar3.mContainerId;
                    d dVar4 = dVar2;
                    int i3 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        d dVar5 = arrayList.get(size);
                        if (dVar5.mContainerId == i2) {
                            if (dVar5 == dVar3) {
                                z = true;
                            } else {
                                if (dVar5 == dVar4) {
                                    this.b.add(i3, new C0030a(9, dVar5));
                                    i3++;
                                    dVar4 = null;
                                }
                                C0030a c0030a2 = new C0030a(3, dVar5);
                                c0030a2.c = c0030a.c;
                                c0030a2.e = c0030a.e;
                                c0030a2.d = c0030a.d;
                                c0030a2.f = c0030a.f;
                                this.b.add(i3, c0030a2);
                                arrayList.remove(dVar5);
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        this.b.remove(i3);
                        i3--;
                    } else {
                        c0030a.a = 1;
                        arrayList.add(dVar3);
                    }
                    i = i3;
                    dVar2 = dVar4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(c0030a.b);
                    if (c0030a.b == dVar2) {
                        this.b.add(i, new C0030a(9, c0030a.b));
                        i++;
                        dVar2 = null;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    this.b.add(i, new C0030a(9, dVar2));
                    i++;
                    dVar2 = c0030a.b;
                    break;
            }
            i++;
        }
        return dVar2;
    }

    public n a() {
        if (!this.i) {
            this.j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override // androidx.e.a.n
    public n a(d dVar) {
        a(new C0030a(3, dVar));
        return this;
    }

    @Override // androidx.e.a.n
    public n a(d dVar, String str) {
        a(0, dVar, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (!this.i) {
            return;
        }
        if (j.a) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
        }
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0030a c0030a = this.b.get(i2);
            if (c0030a.b != null) {
                c0030a.b.mBackStackNesting += i;
                if (j.a) {
                    Log.v("FragmentManager", "Bump nesting of " + c0030a.b + " to " + c0030a.b.mBackStackNesting);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0030a c0030a) {
        this.b.add(c0030a);
        c0030a.c = this.c;
        c0030a.d = this.d;
        c0030a.e = this.e;
        c0030a.f = this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        for (int i = 0; i < this.b.size(); i++) {
            C0030a c0030a = this.b.get(i);
            if (b(c0030a)) {
                c0030a.b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.c != 0 || this.d != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (this.p != 0 || this.q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                C0030a c0030a = this.b.get(i);
                switch (c0030a.a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + c0030a.a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(c0030a.b);
                if (z) {
                    if (c0030a.c != 0 || c0030a.d != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0030a.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0030a.d));
                    }
                    if (c0030a.e != 0 || c0030a.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0030a.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0030a.f));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            C0030a c0030a = this.b.get(i4);
            int i5 = c0030a.b != null ? c0030a.b.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        C0030a c0030a2 = aVar.b.get(i7);
                        if ((c0030a2.b != null ? c0030a2.b.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    @Override // androidx.e.a.j.h
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (j.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.i) {
            this.a.b(this);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d b(ArrayList<d> arrayList, d dVar) {
        for (int i = 0; i < this.b.size(); i++) {
            C0030a c0030a = this.b.get(i);
            int i2 = c0030a.a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            dVar = null;
                            break;
                        case 9:
                            dVar = c0030a.b;
                            break;
                    }
                }
                arrayList.add(c0030a.b);
            }
            arrayList.remove(c0030a.b);
        }
        return dVar;
    }

    public void b() {
        ArrayList<Runnable> arrayList = this.u;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.u.get(i).run();
            }
            this.u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            C0030a c0030a = this.b.get(size);
            d dVar = c0030a.b;
            if (dVar != null) {
                dVar.setNextTransition(j.d(this.g), this.h);
            }
            int i = c0030a.a;
            if (i != 1) {
                switch (i) {
                    case 3:
                        dVar.setNextAnim(c0030a.e);
                        this.a.a(dVar, false);
                        break;
                    case 4:
                        dVar.setNextAnim(c0030a.e);
                        this.a.j(dVar);
                        break;
                    case 5:
                        dVar.setNextAnim(c0030a.f);
                        this.a.i(dVar);
                        break;
                    case 6:
                        dVar.setNextAnim(c0030a.e);
                        this.a.l(dVar);
                        break;
                    case 7:
                        dVar.setNextAnim(c0030a.f);
                        this.a.k(dVar);
                        break;
                    case 8:
                        this.a.o(null);
                        break;
                    case 9:
                        this.a.o(dVar);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0030a.a);
                }
            } else {
                dVar.setNextAnim(c0030a.f);
                this.a.h(dVar);
            }
            if (!this.t && c0030a.a != 3 && dVar != null) {
                this.a.e(dVar);
            }
        }
        if (this.t || !z) {
            return;
        }
        j jVar = this.a;
        jVar.a(jVar.l, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0030a c0030a = this.b.get(i2);
            int i3 = c0030a.b != null ? c0030a.b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.e.a.n
    public int c() {
        return a(false);
    }

    @Override // androidx.e.a.n
    public int d() {
        return a(true);
    }

    @Override // androidx.e.a.n
    public void e() {
        a();
        this.a.b((j.h) this, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            C0030a c0030a = this.b.get(i);
            d dVar = c0030a.b;
            if (dVar != null) {
                dVar.setNextTransition(this.g, this.h);
            }
            int i2 = c0030a.a;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        dVar.setNextAnim(c0030a.d);
                        this.a.h(dVar);
                        break;
                    case 4:
                        dVar.setNextAnim(c0030a.d);
                        this.a.i(dVar);
                        break;
                    case 5:
                        dVar.setNextAnim(c0030a.c);
                        this.a.j(dVar);
                        break;
                    case 6:
                        dVar.setNextAnim(c0030a.d);
                        this.a.k(dVar);
                        break;
                    case 7:
                        dVar.setNextAnim(c0030a.c);
                        this.a.l(dVar);
                        break;
                    case 8:
                        this.a.o(dVar);
                        break;
                    case 9:
                        this.a.o(null);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0030a.a);
                }
            } else {
                dVar.setNextAnim(c0030a.c);
                this.a.a(dVar, false);
            }
            if (!this.t && c0030a.a != 1 && dVar != null) {
                this.a.e(dVar);
            }
        }
        if (!this.t) {
            j jVar = this.a;
            jVar.a(jVar.l, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        for (int i = 0; i < this.b.size(); i++) {
            if (b(this.b.get(i))) {
                return true;
            }
        }
        return false;
    }

    public String h() {
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            sb.append(" #");
            sb.append(this.m);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }
}
