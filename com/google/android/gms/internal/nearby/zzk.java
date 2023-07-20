package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzk {
    private static zzk a;
    private final Map<String, Set<ListenerHolder.ListenerKey<?>>> b = new HashMap();
    private final Set<ListenerHolder.ListenerKey<?>> c = new HashSet();
    private final Map<String, ListenerHolder<String>> d = new HashMap();

    private zzk() {
    }

    private final void a(String str, ListenerHolder.ListenerKey<?> listenerKey) {
        Set<ListenerHolder.ListenerKey<?>> set = this.b.get(str);
        if (set == null) {
            set = new HashSet<>();
            this.b.put(str, set);
        }
        set.add(listenerKey);
    }

    public static synchronized zzk zza() {
        zzk zzkVar;
        synchronized (zzk.class) {
            if (a == null) {
                a = new zzk();
            }
            zzkVar = a;
        }
        return zzkVar;
    }

    public final synchronized <T> ListenerHolder<T> zza(GoogleApi googleApi, T t, String str) {
        ListenerHolder<T> registerListener;
        registerListener = googleApi.registerListener(t, str);
        a(str, registerListener.getListenerKey());
        return registerListener;
    }

    public final synchronized ListenerHolder<String> zza(GoogleApi googleApi, String str, String str2) {
        if (this.d.containsKey(str) && this.d.get(str).hasListener()) {
            return this.d.get(str);
        }
        ListenerHolder<String> registerListener = googleApi.registerListener(str, str2);
        a(str2, registerListener.getListenerKey());
        this.d.put(str, registerListener);
        return registerListener;
    }

    public final synchronized Task<Boolean> zza(GoogleApi googleApi, ListenerHolder.ListenerKey<?> listenerKey) {
        this.c.remove(listenerKey);
        return googleApi.doUnregisterEventListener(listenerKey);
    }

    public final synchronized Task<Void> zza(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod) {
        this.c.add(registerListenerMethod.getListenerKey());
        return googleApi.doRegisterEventListener(registerListenerMethod, unregisterListenerMethod).addOnFailureListener(new cl(this, registerListenerMethod));
    }

    public final synchronized void zza(GoogleApi googleApi, String str) {
        Set<ListenerHolder.ListenerKey<?>> set = this.b.get(str);
        if (set == null) {
            return;
        }
        for (ListenerHolder.ListenerKey<?> listenerKey : set) {
            if (this.c.contains(listenerKey)) {
                zza(googleApi, listenerKey);
            }
        }
        this.b.remove(str);
    }

    public final synchronized <T> ListenerHolder.ListenerKey<T> zzb(GoogleApi googleApi, T t, String str) {
        if (t instanceof String) {
            return (ListenerHolder.ListenerKey<T>) zza(googleApi, (String) t, str).getListenerKey();
        }
        return ListenerHolders.createListenerKey(t, str);
    }
}
