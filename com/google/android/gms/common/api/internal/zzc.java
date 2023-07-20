package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zzc extends androidx.e.a.d implements LifecycleFragment {
    private static WeakHashMap<androidx.e.a.e, WeakReference<zzc>> a = new WeakHashMap<>();
    private Map<String, LifecycleCallback> b = new androidx.b.a();
    private int c = 0;
    private Bundle d;

    public static zzc zza(androidx.e.a.e eVar) {
        zzc zzcVar;
        WeakReference<zzc> weakReference = a.get(eVar);
        if (weakReference == null || (zzcVar = weakReference.get()) == null) {
            try {
                zzc zzcVar2 = (zzc) eVar.d().a("SupportLifecycleFragmentImpl");
                if (zzcVar2 == null || zzcVar2.isRemoving()) {
                    zzcVar2 = new zzc();
                    eVar.d().a().a(zzcVar2, "SupportLifecycleFragmentImpl").d();
                }
                a.put(eVar, new WeakReference<>(zzcVar2));
                return zzcVar2;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return zzcVar;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        if (!this.b.containsKey(str)) {
            this.b.put(str, lifecycleCallback);
            if (this.c <= 0) {
                return;
            }
            new zze(Looper.getMainLooper()).post(new bh(this, lifecycleCallback, str));
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // androidx.e.a.d
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.b.values()) {
            lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return cls.cast(this.b.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final /* synthetic */ Activity getLifecycleActivity() {
        return getActivity();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        return this.c > 0;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        return this.c >= 2;
    }

    @Override // androidx.e.a.d
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.b.values()) {
            lifecycleCallback.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.e.a.d
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = 1;
        this.d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.b.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.e.a.d
    public final void onDestroy() {
        super.onDestroy();
        this.c = 5;
        for (LifecycleCallback lifecycleCallback : this.b.values()) {
            lifecycleCallback.onDestroy();
        }
    }

    @Override // androidx.e.a.d
    public final void onResume() {
        super.onResume();
        this.c = 3;
        for (LifecycleCallback lifecycleCallback : this.b.values()) {
            lifecycleCallback.onResume();
        }
    }

    @Override // androidx.e.a.d
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.b.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // androidx.e.a.d
    public final void onStart() {
        super.onStart();
        this.c = 2;
        for (LifecycleCallback lifecycleCallback : this.b.values()) {
            lifecycleCallback.onStart();
        }
    }

    @Override // androidx.e.a.d
    public final void onStop() {
        super.onStop();
        this.c = 4;
        for (LifecycleCallback lifecycleCallback : this.b.values()) {
            lifecycleCallback.onStop();
        }
    }
}
