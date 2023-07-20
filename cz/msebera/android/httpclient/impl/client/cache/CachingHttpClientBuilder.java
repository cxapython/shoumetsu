package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import java.io.Closeable;
import java.io.File;

/* loaded from: classes.dex */
public class CachingHttpClientBuilder extends HttpClientBuilder {
    private CacheConfig cacheConfig;
    private File cacheDir;
    private boolean deleteCache = true;
    private HttpCacheInvalidator httpCacheInvalidator;
    private ResourceFactory resourceFactory;
    private SchedulingStrategy schedulingStrategy;
    private HttpCacheStorage storage;

    protected CachingHttpClientBuilder() {
    }

    public static CachingHttpClientBuilder create() {
        return new CachingHttpClientBuilder();
    }

    private AsynchronousValidator createAsynchronousRevalidator(CacheConfig cacheConfig) {
        if (cacheConfig.getAsynchronousWorkersMax() > 0) {
            AsynchronousValidator asynchronousValidator = new AsynchronousValidator(createSchedulingStrategy(cacheConfig));
            addCloseable(asynchronousValidator);
            return asynchronousValidator;
        }
        return null;
    }

    private SchedulingStrategy createSchedulingStrategy(CacheConfig cacheConfig) {
        SchedulingStrategy schedulingStrategy = this.schedulingStrategy;
        return schedulingStrategy != null ? schedulingStrategy : new ImmediateSchedulingStrategy(cacheConfig);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    @Override // cz.msebera.android.httpclient.impl.client.HttpClientBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ClientExecChain decorateMainExec(ClientExecChain clientExecChain) {
        ResourceFactory resourceFactory;
        HttpCacheStorage httpCacheStorage;
        HttpCacheInvalidator httpCacheInvalidator;
        CacheConfig cacheConfig = this.cacheConfig;
        if (cacheConfig == null) {
            cacheConfig = CacheConfig.DEFAULT;
        }
        ResourceFactory resourceFactory2 = this.resourceFactory;
        if (resourceFactory2 == null) {
            File file = this.cacheDir;
            if (file != null) {
                resourceFactory = new FileResourceFactory(file);
                httpCacheStorage = this.storage;
                BasicHttpCacheStorage basicHttpCacheStorage = httpCacheStorage;
                if (httpCacheStorage == null) {
                    if (this.cacheDir == null) {
                        basicHttpCacheStorage = new BasicHttpCacheStorage(cacheConfig);
                    } else {
                        final ManagedHttpCacheStorage managedHttpCacheStorage = new ManagedHttpCacheStorage(cacheConfig);
                        if (this.deleteCache) {
                            addCloseable(new Closeable() { // from class: cz.msebera.android.httpclient.impl.client.cache.CachingHttpClientBuilder.1
                                @Override // java.io.Closeable, java.lang.AutoCloseable
                                public void close() {
                                    managedHttpCacheStorage.shutdown();
                                }
                            });
                            basicHttpCacheStorage = managedHttpCacheStorage;
                        } else {
                            addCloseable(managedHttpCacheStorage);
                            basicHttpCacheStorage = managedHttpCacheStorage;
                        }
                    }
                }
                HttpCacheStorage httpCacheStorage2 = basicHttpCacheStorage;
                AsynchronousValidator createAsynchronousRevalidator = createAsynchronousRevalidator(cacheConfig);
                CacheKeyGenerator cacheKeyGenerator = new CacheKeyGenerator();
                httpCacheInvalidator = this.httpCacheInvalidator;
                if (httpCacheInvalidator == null) {
                    httpCacheInvalidator = new CacheInvalidator(cacheKeyGenerator, httpCacheStorage2);
                }
                return new CachingExec(clientExecChain, new BasicHttpCache(resourceFactory, httpCacheStorage2, cacheConfig, cacheKeyGenerator, httpCacheInvalidator), cacheConfig, createAsynchronousRevalidator);
            }
            resourceFactory2 = new HeapResourceFactory();
        }
        resourceFactory = resourceFactory2;
        httpCacheStorage = this.storage;
        BasicHttpCacheStorage basicHttpCacheStorage2 = httpCacheStorage;
        if (httpCacheStorage == null) {
        }
        HttpCacheStorage httpCacheStorage22 = basicHttpCacheStorage2;
        AsynchronousValidator createAsynchronousRevalidator2 = createAsynchronousRevalidator(cacheConfig);
        CacheKeyGenerator cacheKeyGenerator2 = new CacheKeyGenerator();
        httpCacheInvalidator = this.httpCacheInvalidator;
        if (httpCacheInvalidator == null) {
        }
        return new CachingExec(clientExecChain, new BasicHttpCache(resourceFactory, httpCacheStorage22, cacheConfig, cacheKeyGenerator2, httpCacheInvalidator), cacheConfig, createAsynchronousRevalidator2);
    }

    public final CachingHttpClientBuilder setCacheConfig(CacheConfig cacheConfig) {
        this.cacheConfig = cacheConfig;
        return this;
    }

    public final CachingHttpClientBuilder setCacheDir(File file) {
        this.cacheDir = file;
        return this;
    }

    public CachingHttpClientBuilder setDeleteCache(boolean z) {
        this.deleteCache = z;
        return this;
    }

    public final CachingHttpClientBuilder setHttpCacheInvalidator(HttpCacheInvalidator httpCacheInvalidator) {
        this.httpCacheInvalidator = httpCacheInvalidator;
        return this;
    }

    public final CachingHttpClientBuilder setHttpCacheStorage(HttpCacheStorage httpCacheStorage) {
        this.storage = httpCacheStorage;
        return this;
    }

    public final CachingHttpClientBuilder setResourceFactory(ResourceFactory resourceFactory) {
        this.resourceFactory = resourceFactory;
        return this;
    }

    public final CachingHttpClientBuilder setSchedulingStrategy(SchedulingStrategy schedulingStrategy) {
        this.schedulingStrategy = schedulingStrategy;
        return this;
    }
}
