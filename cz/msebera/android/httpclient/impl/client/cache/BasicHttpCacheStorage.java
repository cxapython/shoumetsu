package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.HttpCacheUpdateCallback;

@ThreadSafe
/* loaded from: classes.dex */
public class BasicHttpCacheStorage implements HttpCacheStorage {
    private final CacheMap entries;

    public BasicHttpCacheStorage(CacheConfig cacheConfig) {
        this.entries = new CacheMap(cacheConfig.getMaxCacheEntries());
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public synchronized HttpCacheEntry getEntry(String str) {
        return this.entries.get(str);
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public synchronized void putEntry(String str, HttpCacheEntry httpCacheEntry) {
        this.entries.put(str, httpCacheEntry);
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public synchronized void removeEntry(String str) {
        this.entries.remove(str);
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public synchronized void updateEntry(String str, HttpCacheUpdateCallback httpCacheUpdateCallback) {
        this.entries.put(str, httpCacheUpdateCallback.update(this.entries.get(str)));
    }
}
