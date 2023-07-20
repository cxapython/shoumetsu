package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Set;

@KeepForSdk
/* loaded from: classes.dex */
public interface e {
    @KeepForSdk
    <T> T a(Class<T> cls);

    @KeepForSdk
    <T> Set<T> b(Class<T> cls);

    @KeepForSdk
    <T> com.google.firebase.c.a<T> c(Class<T> cls);

    @KeepForSdk
    <T> com.google.firebase.c.a<Set<T>> d(Class<T> cls);
}
