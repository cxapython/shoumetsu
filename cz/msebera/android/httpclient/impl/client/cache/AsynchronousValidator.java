package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
class AsynchronousValidator implements Closeable {
    private final CacheKeyGenerator cacheKeyGenerator;
    private final FailureCache failureCache;
    public HttpClientAndroidLog log;
    private final Set<String> queued;
    private final SchedulingStrategy schedulingStrategy;

    public AsynchronousValidator(CacheConfig cacheConfig) {
        this(new ImmediateSchedulingStrategy(cacheConfig));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsynchronousValidator(SchedulingStrategy schedulingStrategy) {
        this.log = new HttpClientAndroidLog(getClass());
        this.schedulingStrategy = schedulingStrategy;
        this.queued = new HashSet();
        this.cacheKeyGenerator = new CacheKeyGenerator();
        this.failureCache = new DefaultFailureCache();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.schedulingStrategy.close();
    }

    Set<String> getScheduledIdentifiers() {
        return Collections.unmodifiableSet(this.queued);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jobFailed(String str) {
        this.failureCache.increaseErrorCount(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jobSuccessful(String str) {
        this.failureCache.resetErrorCount(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void markComplete(String str) {
        this.queued.remove(str);
    }

    public synchronized void revalidateCacheEntry(CachingExec cachingExec, HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, HttpCacheEntry httpCacheEntry) {
        String variantURI = this.cacheKeyGenerator.getVariantURI(httpClientContext.getTargetHost(), httpRequestWrapper, httpCacheEntry);
        if (!this.queued.contains(variantURI)) {
            try {
                this.schedulingStrategy.schedule(new AsynchronousValidationRequest(this, cachingExec, httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, httpCacheEntry, variantURI, this.failureCache.getErrorCount(variantURI)));
                this.queued.add(variantURI);
            } catch (RejectedExecutionException e) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Revalidation for [" + variantURI + "] not scheduled: " + e);
            }
        }
    }
}
