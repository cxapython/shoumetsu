package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
class am implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static am j;
    private static am k;
    private final View a;
    private final CharSequence b;
    private final int c;
    private final Runnable d = new Runnable() { // from class: androidx.appcompat.widget.am.1
        @Override // java.lang.Runnable
        public void run() {
            am.this.a(false);
        }
    };
    private final Runnable e = new Runnable() { // from class: androidx.appcompat.widget.am.2
        @Override // java.lang.Runnable
        public void run() {
            am.this.a();
        }
    };
    private int f;
    private int g;
    private an h;
    private boolean i;

    private am(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.c = androidx.core.g.p.a(ViewConfiguration.get(this.a.getContext()));
        d();
        this.a.setOnLongClickListener(this);
        this.a.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        am amVar = j;
        if (amVar != null && amVar.a == view) {
            a((am) null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new am(view, charSequence);
            return;
        }
        am amVar2 = k;
        if (amVar2 != null && amVar2.a == view) {
            amVar2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private static void a(am amVar) {
        am amVar2 = j;
        if (amVar2 != null) {
            amVar2.c();
        }
        j = amVar;
        am amVar3 = j;
        if (amVar3 != null) {
            amVar3.b();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f) > this.c || Math.abs(y - this.g) > this.c) {
            this.f = x;
            this.g = y;
            return true;
        }
        return false;
    }

    private void b() {
        this.a.postDelayed(this.d, ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.a.removeCallbacks(this.d);
    }

    private void d() {
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
    }

    void a() {
        if (k == this) {
            k = null;
            an anVar = this.h;
            if (anVar != null) {
                anVar.a();
                this.h = null;
                d();
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a((am) null);
        }
        this.a.removeCallbacks(this.e);
    }

    void a(boolean z) {
        long longPressTimeout;
        if (!androidx.core.g.o.k(this.a)) {
            return;
        }
        a((am) null);
        am amVar = k;
        if (amVar != null) {
            amVar.a();
        }
        k = this;
        this.i = z;
        this.h = new an(this.a.getContext());
        this.h.a(this.a, this.f, this.g, this.i, this.b);
        this.a.addOnAttachStateChangeListener(this);
        if (this.i) {
            longPressTimeout = 2500;
        } else {
            longPressTimeout = ((androidx.core.g.o.e(this.a) & 1) == 1 ? 3000L : 15000L) - ViewConfiguration.getLongPressTimeout();
        }
        this.a.removeCallbacks(this.e);
        this.a.postDelayed(this.e, longPressTimeout);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h == null || !this.i) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    d();
                    a();
                }
            } else if (this.a.isEnabled() && this.h == null && a(motionEvent)) {
                a(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
