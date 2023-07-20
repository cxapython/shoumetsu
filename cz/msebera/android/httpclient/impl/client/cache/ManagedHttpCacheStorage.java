package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.HttpCacheUpdateCallback;
import cz.msebera.android.httpclient.util.Args;
import java.io.Closeable;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@ThreadSafe
/* loaded from: classes.dex */
public class ManagedHttpCacheStorage implements HttpCacheStorage, Closeable {
    private final CacheMap entries;
    private final ReferenceQueue<HttpCacheEntry> morque = new ReferenceQueue<>();
    private final Set<ResourceReference> resources = new HashSet();
    private final AtomicBoolean active = new AtomicBoolean(true);

    public ManagedHttpCacheStorage(CacheConfig cacheConfig) {
        this.entries = new CacheMap(cacheConfig.getMaxCacheEntries());
    }

    private void ensureValidState() {
        if (this.active.get()) {
            return;
        }
        throw new IllegalStateException("Cache has been shut down");
    }

    private void keepResourceReference(HttpCacheEntry httpCacheEntry) {
        if (httpCacheEntry.getResource() != null) {
            this.resources.add(new ResourceReference(httpCacheEntry, this.morque));
        }
    }

    public void cleanResources() {
        if (this.active.get()) {
            while (true) {
                ResourceReference resourceReference = (ResourceReference) this.morque.poll();
                if (resourceReference == null) {
                    return;
                }
                synchronized (this) {
                    this.resources.remove(resourceReference);
                }
                resourceReference.getResource().dispose();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.active.compareAndSet(true, false)) {
            synchronized (this) {
                while (true) {
                    ResourceReference resourceReference = (ResourceReference) this.morque.poll();
                    if (resourceReference != null) {
                        this.resources.remove(resourceReference);
                        resourceReference.getResource().dispose();
                    }
                }
            }
        }
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public HttpCacheEntry getEntry(String str) {
        HttpCacheEntry httpCacheEntry;
        Args.notNull(str, "URL");
        ensureValidState();
        synchronized (this) {
            httpCacheEntry = this.entries.get(str);
        }
        return httpCacheEntry;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public void putEntry(String str, HttpCacheEntry httpCacheEntry) {
        Args.notNull(str, "URL");
        Args.notNull(httpCacheEntry, "Cache entry");
        ensureValidState();
        synchronized (this) {
            this.entries.put(str, httpCacheEntry);
            keepResourceReference(httpCacheEntry);
        }
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public void removeEntry(String str) {
        Args.notNull(str, "URL");
        ensureValidState();
        synchronized (this) {
            this.entries.remove(str);
        }
    }

    public void shutdown() {
        if (this.active.compareAndSet(true, false)) {
            synchronized (this) {
                this.entries.clear();
                for (ResourceReference resourceReference : this.resources) {
                    resourceReference.getResource().dispose();
                }
                this.resources.clear();
                while (this.morque.poll() != null) {
                }
            }
        }
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public void updateEntry(String str, HttpCacheUpdateCallback httpCacheUpdateCallback) {
        Args.notNull(str, "URL");
        Args.notNull(httpCacheUpdateCallback, "Callback");
        ensureValidState();
        synchronized (this) {
            HttpCacheEntry httpCacheEntry = this.entries.get(str);
            HttpCacheEntry update = httpCacheUpdateCallback.update(httpCacheEntry);
            this.entries.put(str, update);
            if (httpCacheEntry != update) {
                keepResourceReference(update);
            }
        }
    }
}
