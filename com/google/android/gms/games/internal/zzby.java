package com.google.android.gms.games.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.util.PlatformVersion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zzby implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    private zze a;
    private zzca b;
    private WeakReference<View> c;
    private boolean d = false;

    private zzby(zze zzeVar, int i) {
        this.a = zzeVar;
        this.b = new zzca(i);
    }

    @TargetApi(17)
    private final void a(View view) {
        Display display;
        int i = -1;
        if (PlatformVersion.isAtLeastJellyBeanMR1() && (display = view.getDisplay()) != null) {
            i = display.getDisplayId();
        }
        IBinder windowToken = view.getWindowToken();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        zzca zzcaVar = this.b;
        zzcaVar.zzjy = i;
        zzcaVar.zzju = windowToken;
        zzcaVar.left = iArr[0];
        zzcaVar.top = iArr[1];
        zzcaVar.right = iArr[0] + width;
        zzcaVar.bottom = iArr[1] + height;
        if (this.d) {
            zzcr();
        }
    }

    public static zzby zza(zze zzeVar, int i) {
        return new zzby(zzeVar, i);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view;
        WeakReference<View> weakReference = this.c;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        a(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        a(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.a.i();
        view.removeOnAttachStateChangeListener(this);
    }

    public final void setGravity(int i) {
        this.b.gravity = i;
    }

    @TargetApi(16)
    public final void zzb(View view) {
        this.a.i();
        WeakReference<View> weakReference = this.c;
        if (weakReference != null) {
            View view2 = weakReference.get();
            Context context = this.a.getContext();
            if (view2 == null && (context instanceof Activity)) {
                view2 = ((Activity) context).getWindow().getDecorView();
            }
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this);
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                if (PlatformVersion.isAtLeastJellyBean()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
        this.c = null;
        Context context2 = this.a.getContext();
        if (view == null && (context2 instanceof Activity)) {
            Activity activity = (Activity) context2;
            view = activity.findViewById(16908290);
            if (view == null) {
                view = activity.getWindow().getDecorView();
            }
            zzbd.w("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if (view == null) {
            zzbd.e("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
            return;
        }
        a(view);
        this.c = new WeakReference<>(view);
        view.addOnAttachStateChangeListener(this);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public final Bundle zzco() {
        return this.b.zzcs();
    }

    public final IBinder zzcp() {
        return this.b.zzju;
    }

    public final zzca zzcq() {
        return this.b;
    }

    public final void zzcr() {
        boolean z;
        if (this.b.zzju != null) {
            this.a.a(this.b.zzju, this.b.zzcs());
            z = false;
        } else {
            z = true;
        }
        this.d = z;
    }
}
