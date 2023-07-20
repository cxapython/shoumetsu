package androidx.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] c = new int[0];
    private static final Object[] d = new Object[0];
    private static Object[] e;
    private static int f;
    private static Object[] g;
    private static int h;
    Object[] a;
    int b;
    private int[] i;
    private f<E, E> j;

    public b() {
        this(0);
    }

    public b(int i) {
        if (i == 0) {
            this.i = c;
            this.a = d;
        } else {
            d(i);
        }
        this.b = 0;
    }

    private int a() {
        int i = this.b;
        if (i == 0) {
            return -1;
        }
        int a = c.a(this.i, i, 0);
        if (a < 0 || this.a[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.i[i2] == 0) {
            if (this.a[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = a - 1; i3 >= 0 && this.i[i3] == 0; i3--) {
            if (this.a[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private int a(Object obj, int i) {
        int i2 = this.b;
        if (i2 == 0) {
            return -1;
        }
        int a = c.a(this.i, i2, i);
        if (a < 0 || obj.equals(this.a[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.i[i3] == i) {
            if (obj.equals(this.a[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a - 1; i4 >= 0 && this.i[i4] == i; i4--) {
            if (obj.equals(this.a[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (h < 10) {
                    objArr[0] = g;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    g = objArr;
                    h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    e = objArr;
                    f++;
                }
            }
        }
    }

    private f<E, E> b() {
        if (this.j == null) {
            this.j = new f<E, E>() { // from class: androidx.b.b.1
                @Override // androidx.b.f
                protected int a() {
                    return b.this.b;
                }

                @Override // androidx.b.f
                protected int a(Object obj) {
                    return b.this.a(obj);
                }

                @Override // androidx.b.f
                protected Object a(int i, int i2) {
                    return b.this.a[i];
                }

                @Override // androidx.b.f
                protected E a(int i, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.b.f
                protected void a(int i) {
                    b.this.c(i);
                }

                @Override // androidx.b.f
                protected void a(E e2, E e3) {
                    b.this.add(e2);
                }

                @Override // androidx.b.f
                protected int b(Object obj) {
                    return b.this.a(obj);
                }

                @Override // androidx.b.f
                protected Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.b.f
                protected void c() {
                    b.this.clear();
                }
            };
        }
        return this.j;
    }

    private void d(int i) {
        if (i == 8) {
            synchronized (b.class) {
                if (g != null) {
                    Object[] objArr = g;
                    this.a = objArr;
                    g = (Object[]) objArr[0];
                    this.i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    h--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (b.class) {
                if (e != null) {
                    Object[] objArr2 = e;
                    this.a = objArr2;
                    e = (Object[]) objArr2[0];
                    this.i = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f--;
                    return;
                }
            }
        }
        this.i = new int[i];
        this.a = new Object[i];
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public void a(int i) {
        int[] iArr = this.i;
        if (iArr.length < i) {
            Object[] objArr = this.a;
            d(i);
            int i2 = this.b;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.i, 0, i2);
                System.arraycopy(objArr, 0, this.a, 0, this.b);
            }
            a(iArr, objArr, this.b);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i;
        int a;
        if (e2 == null) {
            a = a();
            i = 0;
        } else {
            int hashCode = e2.hashCode();
            i = hashCode;
            a = a(e2, hashCode);
        }
        if (a >= 0) {
            return false;
        }
        int i2 = ~a;
        int i3 = this.b;
        if (i3 >= this.i.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            int[] iArr = this.i;
            Object[] objArr = this.a;
            d(i4);
            int[] iArr2 = this.i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.a, 0, objArr.length);
            }
            a(iArr, objArr, this.b);
        }
        int i5 = this.b;
        if (i2 < i5) {
            int[] iArr3 = this.i;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.a;
            System.arraycopy(objArr2, i2, objArr2, i6, this.b - i2);
        }
        this.i[i2] = i;
        this.a[i2] = e2;
        this.b++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        a(this.b + collection.size());
        boolean z = false;
        for (E e2 : collection) {
            z |= add(e2);
        }
        return z;
    }

    public E b(int i) {
        return (E) this.a[i];
    }

    public E c(int i) {
        Object[] objArr = this.a;
        E e2 = (E) objArr[i];
        int i2 = this.b;
        if (i2 <= 1) {
            a(this.i, objArr, i2);
            this.i = c;
            this.a = d;
            this.b = 0;
        } else {
            int[] iArr = this.i;
            int i3 = 8;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                this.b--;
                int i4 = this.b;
                if (i < i4) {
                    int[] iArr2 = this.i;
                    int i5 = i + 1;
                    System.arraycopy(iArr2, i5, iArr2, i, i4 - i);
                    Object[] objArr2 = this.a;
                    System.arraycopy(objArr2, i5, objArr2, i, this.b - i);
                }
                this.a[this.b] = null;
            } else {
                if (i2 > 8) {
                    i3 = i2 + (i2 >> 1);
                }
                int[] iArr3 = this.i;
                Object[] objArr3 = this.a;
                d(i3);
                this.b--;
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.i, 0, i);
                    System.arraycopy(objArr3, 0, this.a, 0, i);
                }
                int i6 = this.b;
                if (i < i6) {
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, this.i, i, i6 - i);
                    System.arraycopy(objArr3, i7, this.a, i, this.b - i);
                }
            }
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.b;
        if (i != 0) {
            a(this.i, this.a, i);
            this.i = c;
            this.a = d;
            this.b = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return a(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.b; i++) {
                try {
                    if (!set.contains(b(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.i;
        int i = this.b;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.b <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return b().e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int a = a(obj);
        if (a >= 0) {
            c(a);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.b - 1; i >= 0; i--) {
            if (!collection.contains(this.a[i])) {
                c(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.b;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.b;
        Object[] objArr = new Object[i];
        System.arraycopy(this.a, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.b) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.b));
        }
        System.arraycopy(this.a, 0, tArr, 0, this.b);
        int length = tArr.length;
        int i = this.b;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.b * 14);
        sb.append('{');
        for (int i = 0; i < this.b; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E b = b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
