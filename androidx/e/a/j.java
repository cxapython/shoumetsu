package androidx.e.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.e.a.d;
import androidx.e.a.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends androidx.e.a.i implements LayoutInflater.Factory2 {
    static final Interpolator F = new DecelerateInterpolator(2.5f);
    static final Interpolator G = new DecelerateInterpolator(1.5f);
    static final Interpolator H = new AccelerateInterpolator(2.5f);
    static final Interpolator I = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static Field q;
    ArrayList<C0032j> C;
    k D;
    ArrayList<h> b;
    boolean c;
    SparseArray<androidx.e.a.d> f;
    ArrayList<androidx.e.a.a> g;
    ArrayList<androidx.e.a.d> h;
    ArrayList<androidx.e.a.a> i;
    ArrayList<Integer> j;
    ArrayList<i.b> k;
    androidx.e.a.h m;
    androidx.e.a.f n;
    androidx.e.a.d o;
    androidx.e.a.d p;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    ArrayList<androidx.e.a.a> x;
    ArrayList<Boolean> y;
    ArrayList<androidx.e.a.d> z;
    int d = 0;
    final ArrayList<androidx.e.a.d> e = new ArrayList<>();
    private final CopyOnWriteArrayList<f> J = new CopyOnWriteArrayList<>();
    int l = 0;
    Bundle A = null;
    SparseArray<Parcelable> B = null;
    Runnable E = new Runnable() { // from class: androidx.e.a.j.1
        @Override // java.lang.Runnable
        public void run() {
            j.this.g();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends b {
        View a;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.a = view;
        }

        @Override // androidx.e.a.j.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (androidx.core.g.o.k(this.a) || Build.VERSION.SDK_INT >= 24) {
                this.a.post(new Runnable() { // from class: androidx.e.a.j.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a.setLayerType(0, null);
                    }
                });
            } else {
                this.a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* loaded from: classes.dex */
    private static class b implements Animation.AnimationListener {
        private final Animation.AnimationListener a;

        b(Animation.AnimationListener animationListener) {
            this.a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        public final Animation a;
        public final Animator b;

        c(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator != null) {
                return;
            }
            throw new IllegalStateException("Animator cannot be null");
        }

        c(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation != null) {
                return;
            }
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends AnimatorListenerAdapter {
        View a;

        d(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setLayerType(0, null);
            animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends AnimationSet implements Runnable {
        private final ViewGroup a;
        private final View b;
        private boolean c;
        private boolean d;
        private boolean e;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.e = true;
            this.a = viewGroup;
            this.b = view;
            addAnimation(animation);
            this.a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                r.a(this.a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                r.a(this.a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c || !this.e) {
                this.a.endViewTransition(this.b);
                this.d = true;
                return;
            }
            this.e = false;
            this.a.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class f {
        final i.a a;
        final boolean b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g {
        public static final int[] a = {16842755, 16842960, 16842961};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface h {
        boolean a(ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    private class i implements h {
        final String a;
        final int b;
        final int c;

        i(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.e.a.j.h
        public boolean a(ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2) {
            androidx.e.a.i peekChildFragmentManager;
            if (j.this.p == null || this.b >= 0 || this.a != null || (peekChildFragmentManager = j.this.p.peekChildFragmentManager()) == null || !peekChildFragmentManager.b()) {
                return j.this.a(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.e.a.j$j  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0032j implements d.c {
        final boolean a;
        final androidx.e.a.a b;
        private int c;

        C0032j(androidx.e.a.a aVar, boolean z) {
            this.a = z;
            this.b = aVar;
        }

        @Override // androidx.e.a.d.c
        public void a() {
            this.c--;
            if (this.c != 0) {
                return;
            }
            this.b.a.f();
        }

        @Override // androidx.e.a.d.c
        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            boolean z = this.c > 0;
            j jVar = this.b.a;
            int size = jVar.e.size();
            for (int i = 0; i < size; i++) {
                androidx.e.a.d dVar = jVar.e.get(i);
                dVar.setOnStartEnterTransitionListener(null);
                if (z && dVar.isPostponed()) {
                    dVar.startPostponedEnterTransition();
                }
            }
            this.b.a.a(this.b, this.a, !z, true);
        }

        public void e() {
            this.b.a.a(this.b, this.a, false, false);
        }
    }

    private void A() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private void B() {
        SparseArray<androidx.e.a.d> sparseArray = this.f;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.e.a.d valueAt = this.f.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.getAnimatingAway() != null) {
                    int stateAfterAnimating = valueAt.getStateAfterAnimating();
                    View animatingAway = valueAt.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    valueAt.setAnimatingAway(null);
                    a(valueAt, stateAfterAnimating, 0, 0, false);
                } else if (valueAt.getAnimator() != null) {
                    valueAt.getAnimator().end();
                }
            }
        }
    }

    private void C() {
        SparseArray<androidx.e.a.d> sparseArray = this.f;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    SparseArray<androidx.e.a.d> sparseArray2 = this.f;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    private int a(ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, androidx.b.b<androidx.e.a.d> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            androidx.e.a.a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.g() && !aVar.a(arrayList, i5 + 1, i3)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                C0032j c0032j = new C0032j(aVar, booleanValue);
                this.C.add(c0032j);
                aVar.a(c0032j);
                if (booleanValue) {
                    aVar.f();
                } else {
                    aVar.b(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                b(bVar);
            }
        }
        return i4;
    }

    private static Animation.AnimationListener a(Animation animation) {
        String str;
        String str2;
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            return (Animation.AnimationListener) q.get(animation);
        } catch (IllegalAccessException e2) {
            e = e2;
            str = "FragmentManager";
            str2 = "Cannot access Animation's mListener field";
            Log.e(str, str2, e);
            return null;
        } catch (NoSuchFieldException e3) {
            e = e3;
            str = "FragmentManager";
            str2 = "No field with the name mListener is found in Animation class";
            Log.e(str, str2, e);
            return null;
        }
    }

    static c a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220L);
        return new c(alphaAnimation);
    }

    static c a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(F);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new c(animationSet);
    }

    private void a(androidx.b.b<androidx.e.a.d> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.e.a.d b2 = bVar.b(i2);
            if (!b2.mAdded) {
                View view = b2.getView();
                b2.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    private void a(final androidx.e.a.d dVar, c cVar, int i2) {
        final View view = dVar.mView;
        final ViewGroup viewGroup = dVar.mContainer;
        viewGroup.startViewTransition(view);
        dVar.setStateAfterAnimating(i2);
        if (cVar.a != null) {
            e eVar = new e(cVar.a, viewGroup, view);
            dVar.setAnimatingAway(dVar.mView);
            eVar.setAnimationListener(new b(a(eVar)) { // from class: androidx.e.a.j.2
                @Override // androidx.e.a.j.b, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() { // from class: androidx.e.a.j.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (dVar.getAnimatingAway() != null) {
                                dVar.setAnimatingAway(null);
                                j.this.a(dVar, dVar.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            b(view, cVar);
            dVar.mView.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.b;
        dVar.setAnimator(cVar.b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.e.a.j.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator animator3 = dVar.getAnimator();
                dVar.setAnimator(null);
                if (animator3 == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                j jVar = j.this;
                androidx.e.a.d dVar2 = dVar;
                jVar.a(dVar2, dVar2.getStateAfterAnimating(), 0, 0, false);
            }
        });
        animator.setTarget(dVar.mView);
        b(dVar.mView, cVar);
        animator.start();
    }

    private static void a(k kVar) {
        if (kVar == null) {
            return;
        }
        List<androidx.e.a.d> a2 = kVar.a();
        if (a2 != null) {
            for (androidx.e.a.d dVar : a2) {
                dVar.mRetaining = true;
            }
        }
        List<k> b2 = kVar.b();
        if (b2 == null) {
            return;
        }
        for (k kVar2 : b2) {
            a(kVar2);
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new androidx.core.f.b("FragmentManager"));
        androidx.e.a.h hVar = this.m;
        try {
            if (hVar != null) {
                hVar.a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } else {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            }
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
        }
        throw runtimeException;
    }

    private void a(ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<C0032j> arrayList3 = this.C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            C0032j c0032j = this.C.get(i2);
            if (arrayList == null || c0032j.a || (indexOf2 = arrayList.indexOf(c0032j.b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (c0032j.c() || (arrayList != null && c0032j.b.a(arrayList, 0, arrayList.size()))) {
                    this.C.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || c0032j.a || (indexOf = arrayList.indexOf(c0032j.b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        c0032j.d();
                    }
                }
                i2++;
            }
            c0032j.e();
            i2++;
        }
    }

    private void a(ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5 = i2;
        boolean z = arrayList.get(i5).t;
        ArrayList<androidx.e.a.d> arrayList3 = this.z;
        if (arrayList3 == null) {
            this.z = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.z.addAll(this.e);
        androidx.e.a.d w = w();
        boolean z2 = false;
        for (int i6 = i5; i6 < i3; i6++) {
            androidx.e.a.a aVar = arrayList.get(i6);
            w = !arrayList2.get(i6).booleanValue() ? aVar.a(this.z, w) : aVar.b(this.z, w);
            z2 = z2 || aVar.i;
        }
        this.z.clear();
        if (!z) {
            o.a(this, arrayList, arrayList2, i2, i3, false);
        }
        b(arrayList, arrayList2, i2, i3);
        if (z) {
            androidx.b.b<androidx.e.a.d> bVar = new androidx.b.b<>();
            b(bVar);
            int a2 = a(arrayList, arrayList2, i2, i3, bVar);
            a(bVar);
            i4 = a2;
        } else {
            i4 = i3;
        }
        if (i4 != i5 && z) {
            o.a(this, arrayList, arrayList2, i2, i4, true);
            a(this.l, true);
        }
        while (i5 < i3) {
            androidx.e.a.a aVar2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && aVar2.m >= 0) {
                c(aVar2.m);
                aVar2.m = -1;
            }
            aVar2.b();
            i5++;
        }
        if (z2) {
            i();
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                if (a(childAnimations.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(View view, c cVar) {
        return view != null && cVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && androidx.core.g.o.g(view) && a(cVar);
    }

    static boolean a(c cVar) {
        if (cVar.a instanceof AlphaAnimation) {
            return true;
        }
        if (!(cVar.a instanceof AnimationSet)) {
            return a(cVar.b);
        }
        List<Animation> animations = ((AnimationSet) cVar.a).getAnimations();
        for (int i2 = 0; i2 < animations.size(); i2++) {
            if (animations.get(i2) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    private boolean a(String str, int i2, int i3) {
        androidx.e.a.i peekChildFragmentManager;
        g();
        c(true);
        androidx.e.a.d dVar = this.p;
        if (dVar == null || i2 >= 0 || str != null || (peekChildFragmentManager = dVar.peekChildFragmentManager()) == null || !peekChildFragmentManager.b()) {
            boolean a2 = a(this.x, this.y, str, i2, i3);
            if (a2) {
                this.c = true;
                try {
                    b(this.x, this.y);
                } finally {
                    z();
                }
            }
            h();
            C();
            return a2;
        }
        return true;
    }

    public static int b(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? 1 : 2;
        } else if (i2 == 4099) {
            return z ? 5 : 6;
        } else if (i2 != 8194) {
            return -1;
        } else {
            return z ? 3 : 4;
        }
    }

    private static void b(View view, c cVar) {
        if (view == null || cVar == null || !a(view, cVar)) {
            return;
        }
        if (cVar.b != null) {
            cVar.b.addListener(new d(view));
            return;
        }
        Animation.AnimationListener a2 = a(cVar.a);
        view.setLayerType(2, null);
        cVar.a.setAnimationListener(new a(view, a2));
    }

    private void b(androidx.b.b<androidx.e.a.d> bVar) {
        int i2 = this.l;
        if (i2 < 1) {
            return;
        }
        int min = Math.min(i2, 3);
        int size = this.e.size();
        for (int i3 = 0; i3 < size; i3++) {
            androidx.e.a.d dVar = this.e.get(i3);
            if (dVar.mState < min) {
                a(dVar, min, dVar.getNextAnim(), dVar.getNextTransition(), false);
                if (dVar.mView != null && !dVar.mHidden && dVar.mIsNewlyAdded) {
                    bVar.add(dVar);
                }
            }
        }
    }

    private void b(ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        a(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).t) {
                if (i3 != i2) {
                    a(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).t) {
                        i3++;
                    }
                }
                a(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 == size) {
            return;
        }
        a(arrayList, arrayList2, i3, size);
    }

    private static void b(ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            androidx.e.a.a aVar = arrayList.get(i2);
            boolean z = true;
            if (arrayList2.get(i2).booleanValue()) {
                aVar.a(-1);
                if (i2 != i3 - 1) {
                    z = false;
                }
                aVar.b(z);
            } else {
                aVar.a(1);
                aVar.f();
            }
            i2++;
        }
    }

    private void c(boolean z) {
        if (!this.c) {
            if (this.m == null) {
                throw new IllegalStateException("Fragment host has been destroyed");
            }
            if (Looper.myLooper() != this.m.j().getLooper()) {
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
            if (!z) {
                y();
            }
            if (this.x == null) {
                this.x = new ArrayList<>();
                this.y = new ArrayList<>();
            }
            this.c = true;
            try {
                a((ArrayList<androidx.e.a.a>) null, (ArrayList<Boolean>) null);
                return;
            } finally {
                this.c = false;
            }
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    private boolean c(ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.b != null && this.b.size() != 0) {
                int size = this.b.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    z |= this.b.get(i2).a(arrayList, arrayList2);
                }
                this.b.clear();
                this.m.j().removeCallbacks(this.E);
                return z;
            }
            return false;
        }
    }

    public static int d(int i2) {
        if (i2 != 4097) {
            if (i2 == 4099) {
                return 4099;
            }
            return i2 != 8194 ? 0 : 4097;
        }
        return 8194;
    }

    private void e(int i2) {
        try {
            this.c = true;
            a(i2, false);
            this.c = false;
            g();
        } catch (Throwable th) {
            this.c = false;
            throw th;
        }
    }

    private androidx.e.a.d p(androidx.e.a.d dVar) {
        ViewGroup viewGroup = dVar.mContainer;
        View view = dVar.mView;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.e.indexOf(dVar) - 1; indexOf >= 0; indexOf--) {
                androidx.e.a.d dVar2 = this.e.get(indexOf);
                if (dVar2.mContainer == viewGroup && dVar2.mView != null) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    private void y() {
        if (!d()) {
            if (this.v == null) {
                return;
            }
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void z() {
        this.c = false;
        this.y.clear();
        this.x.clear();
    }

    public int a(androidx.e.a.a aVar) {
        synchronized (this) {
            if (this.j != null && this.j.size() > 0) {
                int intValue = this.j.remove(this.j.size() - 1).intValue();
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                }
                this.i.set(intValue, aVar);
                return intValue;
            }
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (a) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.i.add(aVar);
            return size;
        }
    }

    public androidx.e.a.d a(Bundle bundle, String str) {
        int i2 = bundle.getInt(str, -1);
        if (i2 == -1) {
            return null;
        }
        androidx.e.a.d dVar = this.f.get(i2);
        if (dVar == null) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
        }
        return dVar;
    }

    @Override // androidx.e.a.i
    public androidx.e.a.d a(String str) {
        if (str != null) {
            for (int size = this.e.size() - 1; size >= 0; size--) {
                androidx.e.a.d dVar = this.e.get(size);
                if (dVar != null && str.equals(dVar.mTag)) {
                    return dVar;
                }
            }
        }
        SparseArray<androidx.e.a.d> sparseArray = this.f;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            androidx.e.a.d valueAt = this.f.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.mTag)) {
                return valueAt;
            }
        }
        return null;
    }

    c a(androidx.e.a.d dVar, int i2, boolean z, int i3) {
        int b2;
        int nextAnim = dVar.getNextAnim();
        Animation onCreateAnimation = dVar.onCreateAnimation(i2, z, nextAnim);
        if (onCreateAnimation != null) {
            return new c(onCreateAnimation);
        }
        Animator onCreateAnimator = dVar.onCreateAnimator(i2, z, nextAnim);
        if (onCreateAnimator != null) {
            return new c(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(this.m.i().getResources().getResourceTypeName(nextAnim));
            boolean z2 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.m.i(), nextAnim);
                    if (loadAnimation != null) {
                        return new c(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.m.i(), nextAnim);
                    if (loadAnimator != null) {
                        return new c(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(this.m.i(), nextAnim);
                    if (loadAnimation2 != null) {
                        return new c(loadAnimation2);
                    }
                }
            }
        }
        if (i2 == 0 || (b2 = b(i2, z)) < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return a(this.m.i(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.m.i(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.m.i(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.m.i(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.m.i(), 0.0f, 1.0f);
            case 6:
                return a(this.m.i(), 1.0f, 0.0f);
            default:
                if (i3 == 0 && this.m.e()) {
                    i3 = this.m.f();
                }
                if (i3 == 0) {
                }
                return null;
        }
    }

    @Override // androidx.e.a.i
    public n a() {
        return new androidx.e.a.a(this);
    }

    @Override // androidx.e.a.i
    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((h) new i(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public void a(int i2, androidx.e.a.a aVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (i2 < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + aVar);
                }
                this.i.set(i2, aVar);
            } else {
                while (size < i2) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + aVar);
                }
                this.i.add(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, boolean z) {
        androidx.e.a.h hVar;
        if (this.m != null || i2 == 0) {
            if (!z && i2 == this.l) {
                return;
            }
            this.l = i2;
            if (this.f == null) {
                return;
            }
            int size = this.e.size();
            for (int i3 = 0; i3 < size; i3++) {
                e(this.e.get(i3));
            }
            int size2 = this.f.size();
            for (int i4 = 0; i4 < size2; i4++) {
                androidx.e.a.d valueAt = this.f.valueAt(i4);
                if (valueAt != null && ((valueAt.mRemoving || valueAt.mDetached) && !valueAt.mIsNewlyAdded)) {
                    e(valueAt);
                }
            }
            e();
            if (!this.r || (hVar = this.m) == null || this.l != 4) {
                return;
            }
            hVar.d();
            this.r = false;
            return;
        }
        throw new IllegalStateException("No activity");
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            androidx.e.a.d dVar = this.e.get(i2);
            if (dVar != null) {
                dVar.performConfigurationChanged(configuration);
            }
        }
    }

    public void a(Bundle bundle, String str, androidx.e.a.d dVar) {
        if (dVar.mIndex < 0) {
            a(new IllegalStateException("Fragment " + dVar + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, dVar.mIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, k kVar) {
        List<k> list;
        List<androidx.lifecycle.r> list2;
        if (parcelable == null) {
            return;
        }
        l lVar = (l) parcelable;
        if (lVar.a == null) {
            return;
        }
        if (kVar != null) {
            List<androidx.e.a.d> a2 = kVar.a();
            list = kVar.b();
            list2 = kVar.c();
            int size = a2 != null ? a2.size() : 0;
            for (int i2 = 0; i2 < size; i2++) {
                androidx.e.a.d dVar = a2.get(i2);
                if (a) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + dVar);
                }
                int i3 = 0;
                while (i3 < lVar.a.length && lVar.a[i3].b != dVar.mIndex) {
                    i3++;
                }
                if (i3 == lVar.a.length) {
                    a(new IllegalStateException("Could not find active fragment with index " + dVar.mIndex));
                }
                m mVar = lVar.a[i3];
                mVar.l = dVar;
                dVar.mSavedViewState = null;
                dVar.mBackStackNesting = 0;
                dVar.mInLayout = false;
                dVar.mAdded = false;
                dVar.mTarget = null;
                if (mVar.k != null) {
                    mVar.k.setClassLoader(this.m.i().getClassLoader());
                    dVar.mSavedViewState = mVar.k.getSparseParcelableArray("android:view_state");
                    dVar.mSavedFragmentState = mVar.k;
                }
            }
        } else {
            list = null;
            list2 = null;
        }
        this.f = new SparseArray<>(lVar.a.length);
        int i4 = 0;
        while (i4 < lVar.a.length) {
            m mVar2 = lVar.a[i4];
            if (mVar2 != null) {
                androidx.e.a.d a3 = mVar2.a(this.m, this.n, this.o, (list == null || i4 >= list.size()) ? null : list.get(i4), (list2 == null || i4 >= list2.size()) ? null : list2.get(i4));
                if (a) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i4 + ": " + a3);
                }
                this.f.put(a3.mIndex, a3);
                mVar2.l = null;
            }
            i4++;
        }
        if (kVar != null) {
            List<androidx.e.a.d> a4 = kVar.a();
            int size2 = a4 != null ? a4.size() : 0;
            for (int i5 = 0; i5 < size2; i5++) {
                androidx.e.a.d dVar2 = a4.get(i5);
                if (dVar2.mTargetIndex >= 0) {
                    dVar2.mTarget = this.f.get(dVar2.mTargetIndex);
                    if (dVar2.mTarget == null) {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + dVar2 + " target no longer exists: " + dVar2.mTargetIndex);
                    }
                }
            }
        }
        this.e.clear();
        if (lVar.b != null) {
            for (int i6 = 0; i6 < lVar.b.length; i6++) {
                androidx.e.a.d dVar3 = this.f.get(lVar.b[i6]);
                if (dVar3 == null) {
                    a(new IllegalStateException("No instantiated fragment for index #" + lVar.b[i6]));
                }
                dVar3.mAdded = true;
                if (a) {
                    Log.v("FragmentManager", "restoreAllState: added #" + i6 + ": " + dVar3);
                }
                if (this.e.contains(dVar3)) {
                    throw new IllegalStateException("Already added!");
                }
                synchronized (this.e) {
                    this.e.add(dVar3);
                }
            }
        }
        if (lVar.c != null) {
            this.g = new ArrayList<>(lVar.c.length);
            for (int i7 = 0; i7 < lVar.c.length; i7++) {
                androidx.e.a.a a5 = lVar.c[i7].a(this);
                if (a) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + a5.m + "): " + a5);
                    PrintWriter printWriter = new PrintWriter(new androidx.core.f.b("FragmentManager"));
                    a5.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.g.add(a5);
                if (a5.m >= 0) {
                    a(a5.m, a5);
                }
            }
        } else {
            this.g = null;
        }
        if (lVar.d >= 0) {
            this.p = this.f.get(lVar.d);
        }
        this.d = lVar.e;
    }

    void a(androidx.e.a.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.b(z3);
        } else {
            aVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            o.a(this, (ArrayList<androidx.e.a.a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.l, true);
        }
        SparseArray<androidx.e.a.d> sparseArray = this.f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.e.a.d valueAt = this.f.valueAt(i2);
                if (valueAt != null && valueAt.mView != null && valueAt.mIsNewlyAdded && aVar.b(valueAt.mContainerId)) {
                    if (valueAt.mPostponedAlpha > 0.0f) {
                        valueAt.mView.setAlpha(valueAt.mPostponedAlpha);
                    }
                    if (z3) {
                        valueAt.mPostponedAlpha = 0.0f;
                    } else {
                        valueAt.mPostponedAlpha = -1.0f;
                        valueAt.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    public void a(androidx.e.a.d dVar) {
        if (dVar.mDeferStart) {
            if (this.c) {
                this.w = true;
                return;
            }
            dVar.mDeferStart = false;
            a(dVar, this.l, 0, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:150:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(androidx.e.a.d dVar, int i2, int i3, int i4, boolean z) {
        int i5;
        ViewGroup viewGroup;
        String str;
        int i6 = 1;
        boolean z2 = true;
        if (!dVar.mAdded || dVar.mDetached) {
            i5 = i2;
            if (i5 > 1) {
                i5 = 1;
            }
        } else {
            i5 = i2;
        }
        if (dVar.mRemoving && i5 > dVar.mState) {
            i5 = (dVar.mState != 0 || !dVar.isInBackStack()) ? dVar.mState : 1;
        }
        int i7 = (!dVar.mDeferStart || dVar.mState >= 3 || i5 <= 2) ? i5 : 2;
        if (dVar.mState <= i7) {
            if (dVar.mFromLayout && !dVar.mInLayout) {
                return;
            }
            if (dVar.getAnimatingAway() != null || dVar.getAnimator() != null) {
                dVar.setAnimatingAway(null);
                dVar.setAnimator(null);
                a(dVar, dVar.getStateAfterAnimating(), 0, 0, true);
            }
            switch (dVar.mState) {
                case 0:
                    if (i7 > 0) {
                        if (a) {
                            Log.v("FragmentManager", "moveto CREATED: " + dVar);
                        }
                        if (dVar.mSavedFragmentState != null) {
                            dVar.mSavedFragmentState.setClassLoader(this.m.i().getClassLoader());
                            dVar.mSavedViewState = dVar.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            dVar.mTarget = a(dVar.mSavedFragmentState, "android:target_state");
                            if (dVar.mTarget != null) {
                                dVar.mTargetRequestCode = dVar.mSavedFragmentState.getInt("android:target_req_state", 0);
                            }
                            if (dVar.mSavedUserVisibleHint != null) {
                                dVar.mUserVisibleHint = dVar.mSavedUserVisibleHint.booleanValue();
                                dVar.mSavedUserVisibleHint = null;
                            } else {
                                dVar.mUserVisibleHint = dVar.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                            }
                            if (!dVar.mUserVisibleHint) {
                                dVar.mDeferStart = true;
                                if (i7 > 2) {
                                    i7 = 2;
                                }
                            }
                        }
                        androidx.e.a.h hVar = this.m;
                        dVar.mHost = hVar;
                        androidx.e.a.d dVar2 = this.o;
                        dVar.mParentFragment = dVar2;
                        dVar.mFragmentManager = dVar2 != null ? dVar2.mChildFragmentManager : hVar.k();
                        if (dVar.mTarget != null) {
                            if (this.f.get(dVar.mTarget.mIndex) != dVar.mTarget) {
                                throw new IllegalStateException("Fragment " + dVar + " declared target fragment " + dVar.mTarget + " that does not belong to this FragmentManager!");
                            } else if (dVar.mTarget.mState < 1) {
                                a(dVar.mTarget, 1, 0, 0, true);
                            }
                        }
                        a(dVar, this.m.i(), false);
                        dVar.mCalled = false;
                        dVar.onAttach(this.m.i());
                        if (!dVar.mCalled) {
                            throw new s("Fragment " + dVar + " did not call through to super.onAttach()");
                        }
                        if (dVar.mParentFragment == null) {
                            this.m.b(dVar);
                        } else {
                            dVar.mParentFragment.onAttachFragment(dVar);
                        }
                        b(dVar, this.m.i(), false);
                        if (!dVar.mIsCreated) {
                            a(dVar, dVar.mSavedFragmentState, false);
                            dVar.performCreate(dVar.mSavedFragmentState);
                            b(dVar, dVar.mSavedFragmentState, false);
                        } else {
                            dVar.restoreChildFragmentState(dVar.mSavedFragmentState);
                            dVar.mState = 1;
                        }
                        dVar.mRetaining = false;
                    }
                case 1:
                    c(dVar);
                    if (i7 > 1) {
                        if (a) {
                            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + dVar);
                        }
                        if (!dVar.mFromLayout) {
                            if (dVar.mContainerId != 0) {
                                if (dVar.mContainerId == -1) {
                                    a(new IllegalArgumentException("Cannot create fragment " + dVar + " for a container view with no id"));
                                }
                                viewGroup = (ViewGroup) this.n.a(dVar.mContainerId);
                                if (viewGroup == null && !dVar.mRestored) {
                                    try {
                                        str = dVar.getResources().getResourceName(dVar.mContainerId);
                                    } catch (Resources.NotFoundException unused) {
                                        str = "unknown";
                                    }
                                    a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(dVar.mContainerId) + " (" + str + ") for fragment " + dVar));
                                }
                            } else {
                                viewGroup = null;
                            }
                            dVar.mContainer = viewGroup;
                            dVar.performCreateView(dVar.performGetLayoutInflater(dVar.mSavedFragmentState), viewGroup, dVar.mSavedFragmentState);
                            if (dVar.mView != null) {
                                dVar.mInnerView = dVar.mView;
                                dVar.mView.setSaveFromParentEnabled(false);
                                if (viewGroup != null) {
                                    viewGroup.addView(dVar.mView);
                                }
                                if (dVar.mHidden) {
                                    dVar.mView.setVisibility(8);
                                }
                                dVar.onViewCreated(dVar.mView, dVar.mSavedFragmentState);
                                a(dVar, dVar.mView, dVar.mSavedFragmentState, false);
                                if (dVar.mView.getVisibility() != 0 || dVar.mContainer == null) {
                                    z2 = false;
                                }
                                dVar.mIsNewlyAdded = z2;
                            } else {
                                dVar.mInnerView = null;
                            }
                        }
                        dVar.performActivityCreated(dVar.mSavedFragmentState);
                        c(dVar, dVar.mSavedFragmentState, false);
                        if (dVar.mView != null) {
                            dVar.restoreViewState(dVar.mSavedFragmentState);
                        }
                        dVar.mSavedFragmentState = null;
                    }
                    break;
                case 2:
                    if (i7 > 2) {
                        if (a) {
                            Log.v("FragmentManager", "moveto STARTED: " + dVar);
                        }
                        dVar.performStart();
                        b(dVar, false);
                    }
                case 3:
                    if (i7 > 3) {
                        if (a) {
                            Log.v("FragmentManager", "moveto RESUMED: " + dVar);
                        }
                        dVar.performResume();
                        c(dVar, false);
                        dVar.mSavedFragmentState = null;
                        dVar.mSavedViewState = null;
                        break;
                    }
                    break;
            }
        } else if (dVar.mState > i7) {
            switch (dVar.mState) {
                case 1:
                    if (i7 < 1) {
                        if (this.u) {
                            if (dVar.getAnimatingAway() != null) {
                                View animatingAway = dVar.getAnimatingAway();
                                dVar.setAnimatingAway(null);
                                animatingAway.clearAnimation();
                            } else if (dVar.getAnimator() != null) {
                                Animator animator = dVar.getAnimator();
                                dVar.setAnimator(null);
                                animator.cancel();
                            }
                        }
                        if (dVar.getAnimatingAway() != null || dVar.getAnimator() != null) {
                            dVar.setStateAfterAnimating(i7);
                            break;
                        } else {
                            if (a) {
                                Log.v("FragmentManager", "movefrom CREATED: " + dVar);
                            }
                            if (!dVar.mRetaining) {
                                dVar.performDestroy();
                                g(dVar, false);
                            } else {
                                dVar.mState = 0;
                            }
                            dVar.performDetach();
                            h(dVar, false);
                            if (!z) {
                                if (dVar.mRetaining) {
                                    dVar.mHost = null;
                                    dVar.mParentFragment = null;
                                    dVar.mFragmentManager = null;
                                    break;
                                } else {
                                    g(dVar);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    if (i7 < 2) {
                        if (a) {
                            Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + dVar);
                        }
                        if (dVar.mView != null && this.m.a(dVar) && dVar.mSavedViewState == null) {
                            m(dVar);
                        }
                        dVar.performDestroyView();
                        f(dVar, false);
                        if (dVar.mView != null && dVar.mContainer != null) {
                            dVar.mContainer.endViewTransition(dVar.mView);
                            dVar.mView.clearAnimation();
                            c a2 = (this.l <= 0 || this.u || dVar.mView.getVisibility() != 0 || dVar.mPostponedAlpha < 0.0f) ? null : a(dVar, i3, false, i4);
                            dVar.mPostponedAlpha = 0.0f;
                            if (a2 != null) {
                                a(dVar, a2, i7);
                            }
                            dVar.mContainer.removeView(dVar.mView);
                        }
                        dVar.mContainer = null;
                        dVar.mView = null;
                        dVar.mViewLifecycleOwner = null;
                        dVar.mViewLifecycleOwnerLiveData.a((androidx.lifecycle.l<androidx.lifecycle.g>) null);
                        dVar.mInnerView = null;
                        dVar.mInLayout = false;
                    }
                    if (i7 < 1) {
                    }
                    break;
                case 3:
                    if (i7 < 3) {
                        if (a) {
                            Log.v("FragmentManager", "movefrom STARTED: " + dVar);
                        }
                        dVar.performStop();
                        e(dVar, false);
                    }
                    if (i7 < 2) {
                    }
                    if (i7 < 1) {
                    }
                    break;
                case 4:
                    if (i7 < 4) {
                        if (a) {
                            Log.v("FragmentManager", "movefrom RESUMED: " + dVar);
                        }
                        dVar.performPause();
                        d(dVar, false);
                    }
                    if (i7 < 3) {
                    }
                    if (i7 < 2) {
                    }
                    if (i7 < 1) {
                    }
                    break;
            }
            if (dVar.mState != i6) {
                return;
            }
            Log.w("FragmentManager", "moveToState: Fragment state for " + dVar + " not updated inline; expected state " + i6 + " found " + dVar.mState);
            dVar.mState = i6;
            return;
        }
        i6 = i7;
        if (dVar.mState != i6) {
        }
    }

    void a(androidx.e.a.d dVar, Context context, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).a(dVar, context, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.a(this, dVar, context);
            }
        }
    }

    void a(androidx.e.a.d dVar, Bundle bundle, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).a(dVar, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.a(this, dVar, bundle);
            }
        }
    }

    void a(androidx.e.a.d dVar, View view, Bundle bundle, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).a(dVar, view, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.a(this, dVar, view, bundle);
            }
        }
    }

    public void a(androidx.e.a.d dVar, boolean z) {
        if (a) {
            Log.v("FragmentManager", "add: " + dVar);
        }
        f(dVar);
        if (!dVar.mDetached) {
            if (this.e.contains(dVar)) {
                throw new IllegalStateException("Fragment already added: " + dVar);
            }
            synchronized (this.e) {
                this.e.add(dVar);
            }
            dVar.mAdded = true;
            dVar.mRemoving = false;
            if (dVar.mView == null) {
                dVar.mHiddenChanged = false;
            }
            if (dVar.mHasMenu && dVar.mMenuVisible) {
                this.r = true;
            }
            if (!z) {
                return;
            }
            b(dVar);
        }
    }

    public void a(androidx.e.a.h hVar, androidx.e.a.f fVar, androidx.e.a.d dVar) {
        if (this.m == null) {
            this.m = hVar;
            this.n = fVar;
            this.o = dVar;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(h hVar, boolean z) {
        if (!z) {
            y();
        }
        synchronized (this) {
            if (!this.u && this.m != null) {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                this.b.add(hVar);
                f();
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }

    @Override // androidx.e.a.i
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        SparseArray<androidx.e.a.d> sparseArray = this.f;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < size5; i2++) {
                androidx.e.a.d valueAt = this.f.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.e.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size6; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.e.get(i3).toString());
            }
        }
        ArrayList<androidx.e.a.d> arrayList = this.h;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size4; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.h.get(i4).toString());
            }
        }
        ArrayList<androidx.e.a.a> arrayList2 = this.g;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size3; i5++) {
                androidx.e.a.a aVar = this.g.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.i != null && (size2 = this.i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i6 = 0; i6 < size2; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println((androidx.e.a.a) this.i.get(i6));
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        ArrayList<h> arrayList3 = this.b;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println((h) this.b.get(i7));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
    }

    public void a(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            androidx.e.a.d dVar = this.e.get(size);
            if (dVar != null) {
                dVar.performMultiWindowModeChanged(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i2) {
        return this.l >= i2;
    }

    public boolean a(Menu menu) {
        if (this.l < 1) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            androidx.e.a.d dVar = this.e.get(i2);
            if (dVar != null && dVar.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.l < 1) {
            return false;
        }
        ArrayList<androidx.e.a.d> arrayList = null;
        boolean z = false;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            androidx.e.a.d dVar = this.e.get(i2);
            if (dVar != null && dVar.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(dVar);
                z = true;
            }
        }
        if (this.h != null) {
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                androidx.e.a.d dVar2 = this.h.get(i3);
                if (arrayList == null || !arrayList.contains(dVar2)) {
                    dVar2.onDestroyOptionsMenu();
                }
            }
        }
        this.h = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            androidx.e.a.d dVar = this.e.get(i2);
            if (dVar != null && dVar.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<androidx.e.a.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int size;
        ArrayList<androidx.e.a.a> arrayList3 = this.g;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                size = this.g.size() - 1;
                while (size >= 0) {
                    androidx.e.a.a aVar = this.g.get(size);
                    if ((str != null && str.equals(aVar.h())) || (i2 >= 0 && i2 == aVar.m)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        androidx.e.a.a aVar2 = this.g.get(size);
                        if (str == null || !str.equals(aVar2.h())) {
                            if (i2 < 0 || i2 != aVar2.m) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.g.size() - 1) {
                return false;
            }
            for (int size3 = this.g.size() - 1; size3 > size; size3--) {
                arrayList.add(this.g.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public androidx.e.a.d b(int i2) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            androidx.e.a.d dVar = this.e.get(size);
            if (dVar != null && dVar.mFragmentId == i2) {
                return dVar;
            }
        }
        SparseArray<androidx.e.a.d> sparseArray = this.f;
        if (sparseArray != null) {
            for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
                androidx.e.a.d valueAt = this.f.valueAt(size2);
                if (valueAt != null && valueAt.mFragmentId == i2) {
                    return valueAt;
                }
            }
            return null;
        }
        return null;
    }

    public androidx.e.a.d b(String str) {
        androidx.e.a.d findFragmentByWho;
        SparseArray<androidx.e.a.d> sparseArray = this.f;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            androidx.e.a.d valueAt = this.f.valueAt(size);
            if (valueAt != null && (findFragmentByWho = valueAt.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public void b(Menu menu) {
        if (this.l < 1) {
            return;
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            androidx.e.a.d dVar = this.e.get(i2);
            if (dVar != null) {
                dVar.performOptionsMenuClosed(menu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(androidx.e.a.a aVar) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.add(aVar);
    }

    void b(androidx.e.a.d dVar) {
        a(dVar, this.l, 0, 0, false);
    }

    void b(androidx.e.a.d dVar, Context context, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).b(dVar, context, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.b(this, dVar, context);
            }
        }
    }

    void b(androidx.e.a.d dVar, Bundle bundle, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).b(dVar, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.b(this, dVar, bundle);
            }
        }
    }

    void b(androidx.e.a.d dVar, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).b(dVar, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.a(this, dVar);
            }
        }
    }

    public void b(h hVar, boolean z) {
        if (!z || (this.m != null && !this.u)) {
            c(z);
            if (hVar.a(this.x, this.y)) {
                this.c = true;
                try {
                    b(this.x, this.y);
                } finally {
                    z();
                }
            }
            h();
            C();
        }
    }

    public void b(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            androidx.e.a.d dVar = this.e.get(size);
            if (dVar != null) {
                dVar.performPictureInPictureModeChanged(z);
            }
        }
    }

    @Override // androidx.e.a.i
    public boolean b() {
        y();
        return a((String) null, -1, 0);
    }

    public boolean b(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            androidx.e.a.d dVar = this.e.get(i2);
            if (dVar != null && dVar.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.e.a.i
    public List<androidx.e.a.d> c() {
        List<androidx.e.a.d> list;
        if (this.e.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    public void c(int i2) {
        synchronized (this) {
            this.i.set(i2, null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (a) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.j.add(Integer.valueOf(i2));
        }
    }

    void c(androidx.e.a.d dVar) {
        if (!dVar.mFromLayout || dVar.mPerformedCreateView) {
            return;
        }
        dVar.performCreateView(dVar.performGetLayoutInflater(dVar.mSavedFragmentState), null, dVar.mSavedFragmentState);
        if (dVar.mView == null) {
            dVar.mInnerView = null;
            return;
        }
        dVar.mInnerView = dVar.mView;
        dVar.mView.setSaveFromParentEnabled(false);
        if (dVar.mHidden) {
            dVar.mView.setVisibility(8);
        }
        dVar.onViewCreated(dVar.mView, dVar.mSavedFragmentState);
        a(dVar, dVar.mView, dVar.mSavedFragmentState, false);
    }

    void c(androidx.e.a.d dVar, Bundle bundle, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).c(dVar, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.c(this, dVar, bundle);
            }
        }
    }

    void c(androidx.e.a.d dVar, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).c(dVar, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.b(this, dVar);
            }
        }
    }

    void d(final androidx.e.a.d dVar) {
        if (dVar.mView != null) {
            c a2 = a(dVar, dVar.getNextTransition(), !dVar.mHidden, dVar.getNextTransitionStyle());
            if (a2 == null || a2.b == null) {
                if (a2 != null) {
                    b(dVar.mView, a2);
                    dVar.mView.startAnimation(a2.a);
                    a2.a.start();
                }
                dVar.mView.setVisibility((!dVar.mHidden || dVar.isHideReplaced()) ? 0 : 8);
                if (dVar.isHideReplaced()) {
                    dVar.setHideReplaced(false);
                }
            } else {
                a2.b.setTarget(dVar.mView);
                if (!dVar.mHidden) {
                    dVar.mView.setVisibility(0);
                } else if (dVar.isHideReplaced()) {
                    dVar.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = dVar.mContainer;
                    final View view = dVar.mView;
                    viewGroup.startViewTransition(view);
                    a2.b.addListener(new AnimatorListenerAdapter() { // from class: androidx.e.a.j.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (dVar.mView != null) {
                                dVar.mView.setVisibility(8);
                            }
                        }
                    });
                }
                b(dVar.mView, a2);
                a2.b.start();
            }
        }
        if (dVar.mAdded && dVar.mHasMenu && dVar.mMenuVisible) {
            this.r = true;
        }
        dVar.mHiddenChanged = false;
        dVar.onHiddenChanged(dVar.mHidden);
    }

    void d(androidx.e.a.d dVar, Bundle bundle, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).d(dVar, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.d(this, dVar, bundle);
            }
        }
    }

    void d(androidx.e.a.d dVar, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).d(dVar, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.c(this, dVar);
            }
        }
    }

    @Override // androidx.e.a.i
    public boolean d() {
        return this.s || this.t;
    }

    void e() {
        if (this.f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            androidx.e.a.d valueAt = this.f.valueAt(i2);
            if (valueAt != null) {
                a(valueAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(androidx.e.a.d dVar) {
        if (dVar == null) {
            return;
        }
        int i2 = this.l;
        if (dVar.mRemoving) {
            i2 = dVar.isInBackStack() ? Math.min(i2, 1) : Math.min(i2, 0);
        }
        a(dVar, i2, dVar.getNextTransition(), dVar.getNextTransitionStyle(), false);
        if (dVar.mView != null) {
            androidx.e.a.d p = p(dVar);
            if (p != null) {
                View view = p.mView;
                ViewGroup viewGroup = dVar.mContainer;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(dVar.mView);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(dVar.mView, indexOfChild);
                }
            }
            if (dVar.mIsNewlyAdded && dVar.mContainer != null) {
                if (dVar.mPostponedAlpha > 0.0f) {
                    dVar.mView.setAlpha(dVar.mPostponedAlpha);
                }
                dVar.mPostponedAlpha = 0.0f;
                dVar.mIsNewlyAdded = false;
                c a2 = a(dVar, dVar.getNextTransition(), true, dVar.getNextTransitionStyle());
                if (a2 != null) {
                    b(dVar.mView, a2);
                    if (a2.a != null) {
                        dVar.mView.startAnimation(a2.a);
                    } else {
                        a2.b.setTarget(dVar.mView);
                        a2.b.start();
                    }
                }
            }
        }
        if (!dVar.mHiddenChanged) {
            return;
        }
        d(dVar);
    }

    void e(androidx.e.a.d dVar, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).e(dVar, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.d(this, dVar);
            }
        }
    }

    void f() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = this.C != null && !this.C.isEmpty();
            if (this.b != null && this.b.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.m.j().removeCallbacks(this.E);
                this.m.j().post(this.E);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(androidx.e.a.d dVar) {
        if (dVar.mIndex >= 0) {
            return;
        }
        int i2 = this.d;
        this.d = i2 + 1;
        dVar.setIndex(i2, this.o);
        if (this.f == null) {
            this.f = new SparseArray<>();
        }
        this.f.put(dVar.mIndex, dVar);
        if (!a) {
            return;
        }
        Log.v("FragmentManager", "Allocated fragment index " + dVar);
    }

    void f(androidx.e.a.d dVar, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).f(dVar, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.e(this, dVar);
            }
        }
    }

    void g(androidx.e.a.d dVar) {
        if (dVar.mIndex < 0) {
            return;
        }
        if (a) {
            Log.v("FragmentManager", "Freeing fragment index " + dVar);
        }
        this.f.put(dVar.mIndex, null);
        dVar.initState();
    }

    void g(androidx.e.a.d dVar, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).g(dVar, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.f(this, dVar);
            }
        }
    }

    public boolean g() {
        c(true);
        boolean z = false;
        while (c(this.x, this.y)) {
            this.c = true;
            try {
                b(this.x, this.y);
                z();
                z = true;
            } catch (Throwable th) {
                z();
                throw th;
            }
        }
        h();
        C();
        return z;
    }

    void h() {
        if (this.w) {
            this.w = false;
            e();
        }
    }

    public void h(androidx.e.a.d dVar) {
        if (a) {
            Log.v("FragmentManager", "remove: " + dVar + " nesting=" + dVar.mBackStackNesting);
        }
        boolean z = !dVar.isInBackStack();
        if (!dVar.mDetached || z) {
            synchronized (this.e) {
                this.e.remove(dVar);
            }
            if (dVar.mHasMenu && dVar.mMenuVisible) {
                this.r = true;
            }
            dVar.mAdded = false;
            dVar.mRemoving = true;
        }
    }

    void h(androidx.e.a.d dVar, boolean z) {
        androidx.e.a.d dVar2 = this.o;
        if (dVar2 != null) {
            androidx.e.a.i fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).h(dVar, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.b) {
                next.a.g(this, dVar);
            }
        }
    }

    void i() {
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                this.k.get(i2).a();
            }
        }
    }

    public void i(androidx.e.a.d dVar) {
        if (a) {
            Log.v("FragmentManager", "hide: " + dVar);
        }
        if (!dVar.mHidden) {
            dVar.mHidden = true;
            dVar.mHiddenChanged = true ^ dVar.mHiddenChanged;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k j() {
        a(this.D);
        return this.D;
    }

    public void j(androidx.e.a.d dVar) {
        if (a) {
            Log.v("FragmentManager", "show: " + dVar);
        }
        if (dVar.mHidden) {
            dVar.mHidden = false;
            dVar.mHiddenChanged = !dVar.mHiddenChanged;
        }
    }

    void k() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        k kVar;
        if (this.f != null) {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                androidx.e.a.d valueAt = this.f.valueAt(i2);
                if (valueAt != null) {
                    if (valueAt.mRetainInstance) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAt);
                        valueAt.mTargetIndex = valueAt.mTarget != null ? valueAt.mTarget.mIndex : -1;
                        if (a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    if (valueAt.mChildFragmentManager != null) {
                        valueAt.mChildFragmentManager.k();
                        kVar = valueAt.mChildFragmentManager.D;
                    } else {
                        kVar = valueAt.mChildNonConfig;
                    }
                    if (arrayList2 == null && kVar != null) {
                        arrayList2 = new ArrayList(this.f.size());
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(kVar);
                    }
                    if (arrayList3 == null && valueAt.mViewModelStore != null) {
                        arrayList3 = new ArrayList(this.f.size());
                        for (int i4 = 0; i4 < i2; i4++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(valueAt.mViewModelStore);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.D = null;
        } else {
            this.D = new k(arrayList, arrayList2, arrayList3);
        }
    }

    public void k(androidx.e.a.d dVar) {
        if (a) {
            Log.v("FragmentManager", "detach: " + dVar);
        }
        if (!dVar.mDetached) {
            dVar.mDetached = true;
            if (!dVar.mAdded) {
                return;
            }
            if (a) {
                Log.v("FragmentManager", "remove from detach: " + dVar);
            }
            synchronized (this.e) {
                this.e.remove(dVar);
            }
            if (dVar.mHasMenu && dVar.mMenuVisible) {
                this.r = true;
            }
            dVar.mAdded = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable l() {
        int[] iArr;
        int size;
        A();
        B();
        g();
        this.s = true;
        androidx.e.a.b[] bVarArr = null;
        this.D = null;
        SparseArray<androidx.e.a.d> sparseArray = this.f;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.f.size();
        m[] mVarArr = new m[size2];
        boolean z = false;
        for (int i2 = 0; i2 < size2; i2++) {
            androidx.e.a.d valueAt = this.f.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.mIndex < 0) {
                    a(new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.mIndex));
                }
                m mVar = new m(valueAt);
                mVarArr[i2] = mVar;
                if (valueAt.mState <= 0 || mVar.k != null) {
                    mVar.k = valueAt.mSavedFragmentState;
                } else {
                    mVar.k = n(valueAt);
                    if (valueAt.mTarget != null) {
                        if (valueAt.mTarget.mIndex < 0) {
                            a(new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.mTarget));
                        }
                        if (mVar.k == null) {
                            mVar.k = new Bundle();
                        }
                        a(mVar.k, "android:target_state", valueAt.mTarget);
                        if (valueAt.mTargetRequestCode != 0) {
                            mVar.k.putInt("android:target_req_state", valueAt.mTargetRequestCode);
                        }
                    }
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + valueAt + ": " + mVar.k);
                }
                z = true;
            }
        }
        if (!z) {
            if (a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.e.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i3 = 0; i3 < size3; i3++) {
                iArr[i3] = this.e.get(i3).mIndex;
                if (iArr[i3] < 0) {
                    a(new IllegalStateException("Failure saving state: active " + this.e.get(i3) + " has cleared index: " + iArr[i3]));
                }
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i3 + ": " + this.e.get(i3));
                }
            }
        } else {
            iArr = null;
        }
        ArrayList<androidx.e.a.a> arrayList = this.g;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new androidx.e.a.b[size];
            for (int i4 = 0; i4 < size; i4++) {
                bVarArr[i4] = new androidx.e.a.b(this.g.get(i4));
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.g.get(i4));
                }
            }
        }
        l lVar = new l();
        lVar.a = mVarArr;
        lVar.b = iArr;
        lVar.c = bVarArr;
        androidx.e.a.d dVar = this.p;
        if (dVar != null) {
            lVar.d = dVar.mIndex;
        }
        lVar.e = this.d;
        k();
        return lVar;
    }

    public void l(androidx.e.a.d dVar) {
        if (a) {
            Log.v("FragmentManager", "attach: " + dVar);
        }
        if (dVar.mDetached) {
            dVar.mDetached = false;
            if (dVar.mAdded) {
                return;
            }
            if (this.e.contains(dVar)) {
                throw new IllegalStateException("Fragment already added: " + dVar);
            }
            if (a) {
                Log.v("FragmentManager", "add from attach: " + dVar);
            }
            synchronized (this.e) {
                this.e.add(dVar);
            }
            dVar.mAdded = true;
            if (!dVar.mHasMenu || !dVar.mMenuVisible) {
                return;
            }
            this.r = true;
        }
    }

    public void m() {
        this.D = null;
        this.s = false;
        this.t = false;
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.e.a.d dVar = this.e.get(i2);
            if (dVar != null) {
                dVar.noteStateNotSaved();
            }
        }
    }

    void m(androidx.e.a.d dVar) {
        if (dVar.mInnerView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.B;
        if (sparseArray == null) {
            this.B = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        dVar.mInnerView.saveHierarchyState(this.B);
        if (this.B.size() <= 0) {
            return;
        }
        dVar.mSavedViewState = this.B;
        this.B = null;
    }

    Bundle n(androidx.e.a.d dVar) {
        Bundle bundle;
        if (this.A == null) {
            this.A = new Bundle();
        }
        dVar.performSaveInstanceState(this.A);
        d(dVar, this.A, false);
        if (!this.A.isEmpty()) {
            bundle = this.A;
            this.A = null;
        } else {
            bundle = null;
        }
        if (dVar.mView != null) {
            m(dVar);
        }
        if (dVar.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", dVar.mSavedViewState);
        }
        if (!dVar.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", dVar.mUserVisibleHint);
        }
        return bundle;
    }

    public void n() {
        this.s = false;
        this.t = false;
        e(1);
    }

    public void o() {
        this.s = false;
        this.t = false;
        e(2);
    }

    public void o(androidx.e.a.d dVar) {
        if (dVar == null || (this.f.get(dVar.mIndex) == dVar && (dVar.mHost == null || dVar.getFragmentManager() == this))) {
            this.p = dVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + dVar + " is not an active fragment of FragmentManager " + this);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        androidx.e.a.d dVar;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a);
        int i2 = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!androidx.e.a.d.isSupportFragmentClass(this.m.i(), str2)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        androidx.e.a.d b2 = resourceId != -1 ? b(resourceId) : null;
        if (b2 == null && string != null) {
            b2 = a(string);
        }
        if (b2 == null && i2 != -1) {
            b2 = b(i2);
        }
        if (a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + b2);
        }
        if (b2 == null) {
            androidx.e.a.d a2 = this.n.a(context, str2, null);
            a2.mFromLayout = true;
            a2.mFragmentId = resourceId != 0 ? resourceId : i2;
            a2.mContainerId = i2;
            a2.mTag = string;
            a2.mInLayout = true;
            a2.mFragmentManager = this;
            androidx.e.a.h hVar = this.m;
            a2.mHost = hVar;
            a2.onInflate(hVar.i(), attributeSet, a2.mSavedFragmentState);
            a(a2, true);
            dVar = a2;
        } else if (b2.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + str2);
        } else {
            b2.mInLayout = true;
            b2.mHost = this.m;
            if (!b2.mRetaining) {
                b2.onInflate(this.m.i(), attributeSet, b2.mSavedFragmentState);
            }
            dVar = b2;
        }
        if (this.l >= 1 || !dVar.mFromLayout) {
            b(dVar);
        } else {
            a(dVar, 1, 0, 0, false);
        }
        if (dVar.mView != null) {
            if (resourceId != 0) {
                dVar.mView.setId(resourceId);
            }
            if (dVar.mView.getTag() == null) {
                dVar.mView.setTag(string);
            }
            return dVar.mView;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void p() {
        this.s = false;
        this.t = false;
        e(3);
    }

    public void q() {
        this.s = false;
        this.t = false;
        e(4);
    }

    public void r() {
        e(3);
    }

    public void s() {
        this.t = true;
        e(2);
    }

    public void t() {
        e(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.o;
        if (obj == null) {
            obj = this.m;
        }
        androidx.core.f.a.a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void u() {
        this.u = true;
        g();
        e(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public void v() {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            androidx.e.a.d dVar = this.e.get(i2);
            if (dVar != null) {
                dVar.performLowMemory();
            }
        }
    }

    public androidx.e.a.d w() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 x() {
        return this;
    }
}
