package cz.msebera.android.httpclient.config;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
/* loaded from: classes.dex */
public final class Registry<I> implements Lookup<I> {
    private final Map<String, I> map;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Registry(Map<String, I> map) {
        this.map = new ConcurrentHashMap(map);
    }

    @Override // cz.msebera.android.httpclient.config.Lookup
    /* renamed from: lookup */
    public I mo34lookup(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str.toLowerCase(Locale.ROOT));
    }

    public String toString() {
        return this.map.toString();
    }
}
