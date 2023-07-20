package com.microsoft.appcenter;

import android.app.Application;
import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public interface d extends Application.ActivityLifecycleCallbacks {
    void a(Context context, com.microsoft.appcenter.a.b bVar, String str, String str2, boolean z);

    void a(c cVar);

    void a(String str, String str2);

    void a(boolean z);

    boolean b();

    boolean c();

    Map<String, com.microsoft.appcenter.c.a.a.f> d();

    String l();
}
