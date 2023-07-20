package androidx.e.a;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.e.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final q b;
    private static final q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        public d a;
        public boolean b;
        public androidx.e.a.a c;
        public d d;
        public boolean e;
        public androidx.e.a.a f;

        a() {
        }
    }

    static {
        b = Build.VERSION.SDK_INT >= 21 ? new p() : null;
        c = a();
    }

    static View a(androidx.b.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        androidx.e.a.a aVar3 = aVar2.c;
        if (obj == null || aVar == null || aVar3.r == null || aVar3.r.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar3.r : aVar3.s).get(0));
    }

    private static androidx.b.a<String, String> a(int i, ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        androidx.b.a<String, String> aVar = new androidx.b.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.e.a.a aVar2 = arrayList.get(i4);
            if (aVar2.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (aVar2.r != null) {
                    int size = aVar2.r.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.r;
                        arrayList4 = aVar2.s;
                    } else {
                        ArrayList<String> arrayList5 = aVar2.r;
                        arrayList3 = aVar2.s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    static androidx.b.a<String, View> a(q qVar, androidx.b.a<String, String> aVar, Object obj, a aVar2) {
        androidx.core.app.j enterTransitionCallback;
        ArrayList<String> arrayList;
        String a2;
        d dVar = aVar2.a;
        View view = dVar.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        androidx.b.a<String, View> aVar3 = new androidx.b.a<>();
        qVar.a((Map<String, View>) aVar3, view);
        androidx.e.a.a aVar4 = aVar2.c;
        if (aVar2.b) {
            enterTransitionCallback = dVar.getExitTransitionCallback();
            arrayList = aVar4.r;
        } else {
            enterTransitionCallback = dVar.getEnterTransitionCallback();
            arrayList = aVar4.s;
        }
        if (arrayList != null) {
            aVar3.a((Collection<?>) arrayList);
            aVar3.a((Collection<?>) aVar.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = aVar3.get(str);
                if (view2 == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(androidx.core.g.o.d(view2)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, androidx.core.g.o.d(view2));
                }
            }
        } else {
            a(aVar, aVar3);
        }
        return aVar3;
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar == null) {
            a aVar2 = new a();
            sparseArray.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private static q a() {
        try {
            return (q) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static q a(d dVar, d dVar2) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null) {
            Object exitTransition = dVar.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = dVar.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = dVar.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (dVar2 != null) {
            Object enterTransition = dVar2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = dVar2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = dVar2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        q qVar = b;
        if (qVar != null && a(qVar, arrayList)) {
            return b;
        }
        q qVar2 = c;
        if (qVar2 != null && a(qVar2, arrayList)) {
            return c;
        }
        if (b != null || c != null) {
            throw new IllegalArgumentException("Invalid Transition types");
        }
        return null;
    }

    private static Object a(final q qVar, ViewGroup viewGroup, View view, androidx.b.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final View view2;
        final Rect rect;
        final d dVar = aVar2.a;
        final d dVar2 = aVar2.d;
        if (dVar != null) {
            dVar.getView().setVisibility(0);
        }
        if (dVar == null || dVar2 == null) {
            return null;
        }
        final boolean z = aVar2.b;
        Object a2 = aVar.isEmpty() ? null : a(qVar, dVar, dVar2, z);
        androidx.b.a<String, View> b2 = b(qVar, aVar, a2, aVar2);
        final androidx.b.a<String, View> a3 = a(qVar, aVar, a2, aVar2);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, aVar.keySet());
            a(arrayList2, a3, aVar.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(dVar, dVar2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            qVar.a(obj3, view, arrayList);
            a(qVar, obj3, obj2, b2, aVar2.e, aVar2.f);
            Rect rect2 = new Rect();
            View a4 = a(a3, aVar2, obj, z);
            if (a4 != null) {
                qVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = a4;
        } else {
            view2 = null;
            rect = null;
        }
        r.a(viewGroup, new Runnable() { // from class: androidx.e.a.o.3
            @Override // java.lang.Runnable
            public void run() {
                o.a(d.this, dVar2, z, (androidx.b.a<String, View>) a3, false);
                View view3 = view2;
                if (view3 != null) {
                    qVar.a(view3, rect);
                }
            }
        });
        return obj3;
    }

    private static Object a(q qVar, d dVar, d dVar2, boolean z) {
        if (dVar == null || dVar2 == null) {
            return null;
        }
        return qVar.c(qVar.b(z ? dVar2.getSharedElementReturnTransition() : dVar.getSharedElementEnterTransition()));
    }

    private static Object a(q qVar, d dVar, boolean z) {
        if (dVar == null) {
            return null;
        }
        return qVar.b(z ? dVar.getReenterTransition() : dVar.getEnterTransition());
    }

    private static Object a(q qVar, Object obj, Object obj2, Object obj3, d dVar, boolean z) {
        return (obj == null || obj2 == null || dVar == null) ? true : z ? dVar.getAllowReturnTransitionOverlap() : dVar.getAllowEnterTransitionOverlap() ? qVar.a(obj2, obj, obj3) : qVar.b(obj2, obj, obj3);
    }

    private static String a(androidx.b.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    static ArrayList<View> a(q qVar, Object obj, d dVar, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View view2 = dVar.getView();
            if (view2 != null) {
                qVar.a(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            qVar.a(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    private static void a(androidx.b.a<String, String> aVar, androidx.b.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    public static void a(androidx.e.a.a aVar, SparseArray<a> sparseArray, boolean z) {
        int size = aVar.b.size();
        for (int i = 0; i < size; i++) {
            a(aVar, aVar.b.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
        if (r10.mAdded != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006c, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0088, code lost:
        if (r10.mHidden == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x008a, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(androidx.e.a.a aVar, a.C0030a c0030a, SparseArray<a> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        a aVar2;
        j jVar;
        boolean z7;
        d dVar = c0030a.b;
        if (dVar == null || (i = dVar.mContainerId) == 0) {
            return;
        }
        int i2 = z ? a[c0030a.a] : c0030a.a;
        boolean z8 = false;
        if (i2 != 1) {
            switch (i2) {
                case 3:
                case 6:
                    if (z2) {
                        z7 = false;
                        break;
                    } else {
                        z7 = false;
                        break;
                    }
                    z5 = z7;
                    z4 = false;
                    z6 = true;
                    break;
                case 4:
                    if (z2) {
                        z7 = false;
                        break;
                    } else {
                        z7 = false;
                        break;
                    }
                    z5 = z7;
                    z4 = false;
                    z6 = true;
                    break;
                case 5:
                    if (z2) {
                        if (dVar.mHiddenChanged) {
                            if (!dVar.mHidden) {
                                break;
                            }
                        }
                        z3 = false;
                        z8 = z3;
                        z4 = true;
                        z6 = false;
                        z5 = false;
                        break;
                    } else {
                        z3 = dVar.mHidden;
                        z8 = z3;
                        z4 = true;
                        z6 = false;
                        z5 = false;
                    }
                case 7:
                    break;
                default:
                    z4 = false;
                    z6 = false;
                    z5 = false;
                    break;
            }
            a aVar3 = sparseArray.get(i);
            if (z8) {
                aVar3 = a(aVar3, sparseArray, i);
                aVar3.a = dVar;
                aVar3.b = z;
                aVar3.c = aVar;
            }
            aVar2 = aVar3;
            if (!z2 && z4) {
                if (aVar2 != null && aVar2.d == dVar) {
                    aVar2.d = null;
                }
                jVar = aVar.a;
                if (dVar.mState < 1 && jVar.l >= 1 && !aVar.t) {
                    jVar.f(dVar);
                    jVar.a(dVar, 1, 0, 0, false);
                }
            }
            if (z5 && (aVar2 == null || aVar2.d == null)) {
                aVar2 = a(aVar2, sparseArray, i);
                aVar2.d = dVar;
                aVar2.e = z;
                aVar2.f = aVar;
            }
            if (!z2 || !z6 || aVar2 == null || aVar2.a != dVar) {
                return;
            }
            aVar2.a = null;
            return;
        }
        if (z2) {
            z3 = dVar.mIsNewlyAdded;
            z8 = z3;
            z4 = true;
            z6 = false;
            z5 = false;
            a aVar32 = sparseArray.get(i);
            if (z8) {
            }
            aVar2 = aVar32;
            if (!z2) {
                if (aVar2 != null) {
                    aVar2.d = null;
                }
                jVar = aVar.a;
                if (dVar.mState < 1) {
                    jVar.f(dVar);
                    jVar.a(dVar, 1, 0, 0, false);
                }
            }
            if (z5) {
                aVar2 = a(aVar2, sparseArray, i);
                aVar2.d = dVar;
                aVar2.e = z;
                aVar2.f = aVar;
            }
            if (!z2) {
                return;
            }
            return;
        }
        if (!dVar.mAdded) {
        }
        z3 = false;
        z8 = z3;
        z4 = true;
        z6 = false;
        z5 = false;
        a aVar322 = sparseArray.get(i);
        if (z8) {
        }
        aVar2 = aVar322;
        if (!z2) {
        }
        if (z5) {
        }
        if (!z2) {
        }
    }

    static void a(d dVar, d dVar2, boolean z, androidx.b.a<String, View> aVar, boolean z2) {
        androidx.core.app.j enterTransitionCallback = z ? dVar2.getEnterTransitionCallback() : dVar.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
            }
            if (z2) {
                enterTransitionCallback.a(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.b(arrayList2, arrayList, null);
            }
        }
    }

    private static void a(j jVar, int i, a aVar, View view, androidx.b.a<String, String> aVar2) {
        d dVar;
        d dVar2;
        q a2;
        Object obj;
        ViewGroup viewGroup = jVar.n.a() ? (ViewGroup) jVar.n.a(i) : null;
        if (viewGroup == null || (a2 = a((dVar2 = aVar.d), (dVar = aVar.a))) == null) {
            return;
        }
        boolean z = aVar.b;
        boolean z2 = aVar.e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, dVar, z);
        Object b2 = b(a2, dVar2, z2);
        Object a4 = a(a2, viewGroup, view, aVar2, aVar, arrayList2, arrayList, a3, b2);
        if (a3 == null && a4 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a5 = a(a2, obj, dVar2, arrayList2, view);
        ArrayList<View> a6 = a(a2, a3, dVar, arrayList, view);
        a(a6, 4);
        Object a7 = a(a2, a3, obj, a4, dVar, z);
        if (a7 == null) {
            return;
        }
        a(a2, obj, dVar2, a5);
        ArrayList<String> a8 = a2.a(arrayList);
        a2.a(a7, a3, a6, obj, a5, a4, arrayList);
        a2.a(viewGroup, a7);
        a2.a(viewGroup, arrayList2, arrayList, a8, aVar2);
        a(a6, 0);
        a2.a(a4, arrayList2, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar, ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (jVar.l < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.e.a.a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b(aVar, sparseArray, z);
            } else {
                a(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() == 0) {
            return;
        }
        View view = new View(jVar.m.i());
        int size = sparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            int keyAt = sparseArray.keyAt(i4);
            androidx.b.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
            a aVar2 = (a) sparseArray.valueAt(i4);
            if (z) {
                a(jVar, keyAt, aVar2, view, a2);
            } else {
                b(jVar, keyAt, aVar2, view, a2);
            }
        }
    }

    private static void a(final q qVar, ViewGroup viewGroup, final d dVar, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        r.a(viewGroup, new Runnable() { // from class: androidx.e.a.o.2
            @Override // java.lang.Runnable
            public void run() {
                Object obj3 = obj;
                if (obj3 != null) {
                    qVar.c(obj3, view);
                    arrayList2.addAll(o.a(qVar, obj, dVar, arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        qVar.b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static void a(q qVar, Object obj, d dVar, final ArrayList<View> arrayList) {
        if (dVar == null || obj == null || !dVar.mAdded || !dVar.mHidden || !dVar.mHiddenChanged) {
            return;
        }
        dVar.setHideReplaced(true);
        qVar.b(obj, dVar.getView(), arrayList);
        r.a(dVar.mContainer, new Runnable() { // from class: androidx.e.a.o.1
            @Override // java.lang.Runnable
            public void run() {
                o.a(arrayList, 4);
            }
        });
    }

    private static void a(q qVar, Object obj, Object obj2, androidx.b.a<String, View> aVar, boolean z, androidx.e.a.a aVar2) {
        if (aVar2.r == null || aVar2.r.isEmpty()) {
            return;
        }
        View view = aVar.get((z ? aVar2.s : aVar2.r).get(0));
        qVar.a(obj, view);
        if (obj2 == null) {
            return;
        }
        qVar.a(obj2, view);
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    private static void a(ArrayList<View> arrayList, androidx.b.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (collection.contains(androidx.core.g.o.d(c2))) {
                arrayList.add(c2);
            }
        }
    }

    private static boolean a(q qVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!qVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static androidx.b.a<String, View> b(q qVar, androidx.b.a<String, String> aVar, Object obj, a aVar2) {
        androidx.core.app.j exitTransitionCallback;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        d dVar = aVar2.d;
        androidx.b.a<String, View> aVar3 = new androidx.b.a<>();
        qVar.a((Map<String, View>) aVar3, dVar.getView());
        androidx.e.a.a aVar4 = aVar2.f;
        if (aVar2.e) {
            exitTransitionCallback = dVar.getEnterTransitionCallback();
            arrayList = aVar4.s;
        } else {
            exitTransitionCallback = dVar.getExitTransitionCallback();
            arrayList = aVar4.r;
        }
        aVar3.a((Collection<?>) arrayList);
        if (exitTransitionCallback != null) {
            exitTransitionCallback.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(androidx.core.g.o.d(view))) {
                    aVar.put(androidx.core.g.o.d(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a((Collection<?>) aVar3.keySet());
        }
        return aVar3;
    }

    private static Object b(final q qVar, ViewGroup viewGroup, final View view, final androidx.b.a<String, String> aVar, final a aVar2, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object a2;
        androidx.b.a<String, String> aVar3;
        Object obj3;
        Rect rect;
        final d dVar = aVar2.a;
        final d dVar2 = aVar2.d;
        if (dVar == null || dVar2 == null) {
            return null;
        }
        final boolean z = aVar2.b;
        if (aVar.isEmpty()) {
            aVar3 = aVar;
            a2 = null;
        } else {
            a2 = a(qVar, dVar, dVar2, z);
            aVar3 = aVar;
        }
        androidx.b.a<String, View> b2 = b(qVar, aVar3, a2, aVar2);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b2.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(dVar, dVar2, z, b2, true);
        if (obj3 != null) {
            rect = new Rect();
            qVar.a(obj3, view, arrayList);
            a(qVar, obj3, obj2, b2, aVar2.e, aVar2.f);
            if (obj != null) {
                qVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        r.a(viewGroup, new Runnable() { // from class: androidx.e.a.o.4
            @Override // java.lang.Runnable
            public void run() {
                androidx.b.a<String, View> a3 = o.a(q.this, aVar, obj4, aVar2);
                if (a3 != null) {
                    arrayList2.addAll(a3.values());
                    arrayList2.add(view);
                }
                o.a(dVar, dVar2, z, a3, false);
                Object obj5 = obj4;
                if (obj5 != null) {
                    q.this.a(obj5, arrayList, arrayList2);
                    View a4 = o.a(a3, aVar2, obj, z);
                    if (a4 == null) {
                        return;
                    }
                    q.this.a(a4, rect2);
                }
            }
        });
        return obj3;
    }

    private static Object b(q qVar, d dVar, boolean z) {
        if (dVar == null) {
            return null;
        }
        return qVar.b(z ? dVar.getReturnTransition() : dVar.getExitTransition());
    }

    public static void b(androidx.e.a.a aVar, SparseArray<a> sparseArray, boolean z) {
        if (!aVar.a.n.a()) {
            return;
        }
        for (int size = aVar.b.size() - 1; size >= 0; size--) {
            a(aVar, aVar.b.get(size), sparseArray, true, z);
        }
    }

    private static void b(j jVar, int i, a aVar, View view, androidx.b.a<String, String> aVar2) {
        d dVar;
        d dVar2;
        q a2;
        Object obj;
        ViewGroup viewGroup = jVar.n.a() ? (ViewGroup) jVar.n.a(i) : null;
        if (viewGroup == null || (a2 = a((dVar2 = aVar.d), (dVar = aVar.a))) == null) {
            return;
        }
        boolean z = aVar.b;
        boolean z2 = aVar.e;
        Object a3 = a(a2, dVar, z);
        Object b2 = b(a2, dVar2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object b3 = b(a2, viewGroup, view, aVar2, aVar, arrayList, arrayList2, a3, b2);
        if (a3 == null && b3 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a4 = a(a2, obj, dVar2, arrayList, view);
        Object obj2 = (a4 == null || a4.isEmpty()) ? null : obj;
        a2.b(a3, view);
        Object a5 = a(a2, a3, obj2, b3, dVar, aVar.b);
        if (a5 == null) {
            return;
        }
        ArrayList<View> arrayList3 = new ArrayList<>();
        a2.a(a5, a3, arrayList3, obj2, a4, b3, arrayList2);
        a(a2, viewGroup, dVar, view, arrayList2, a3, arrayList3, obj2, a4);
        a2.a((View) viewGroup, arrayList2, (Map<String, String>) aVar2);
        a2.a(viewGroup, a5);
        a2.a(viewGroup, arrayList2, (Map<String, String>) aVar2);
    }
}
