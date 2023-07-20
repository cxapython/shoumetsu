package com.microsoft.appcenter.b;

import java.io.Closeable;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public interface d extends Closeable {

    /* loaded from: classes.dex */
    public interface a {
        String a();

        void a(URL url, Map<String, String> map);
    }

    k a(String str, String str2, Map<String, String> map, a aVar, l lVar);

    void a();
}
