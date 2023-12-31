package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ThreadSafe
/* loaded from: classes.dex */
public class DefaultFailureCache implements FailureCache {
    static final int DEFAULT_MAX_SIZE = 1000;
    static final int MAX_UPDATE_TRIES = 10;
    private final int maxSize;
    private final ConcurrentMap<String, FailureCacheValue> storage;

    public DefaultFailureCache() {
        this(1000);
    }

    public DefaultFailureCache(int i) {
        this.maxSize = i;
        this.storage = new ConcurrentHashMap();
    }

    private FailureCacheValue findValueWithOldestTimestamp() {
        long j = Long.MAX_VALUE;
        FailureCacheValue failureCacheValue = null;
        for (Map.Entry<String, FailureCacheValue> entry : this.storage.entrySet()) {
            long creationTimeInNanos = entry.getValue().getCreationTimeInNanos();
            if (creationTimeInNanos < j) {
                failureCacheValue = entry.getValue();
                j = creationTimeInNanos;
            }
        }
        return failureCacheValue;
    }

    private void removeOldestEntryIfMapSizeExceeded() {
        FailureCacheValue findValueWithOldestTimestamp;
        if (this.storage.size() <= this.maxSize || (findValueWithOldestTimestamp = findValueWithOldestTimestamp()) == null) {
            return;
        }
        this.storage.remove(findValueWithOldestTimestamp.getKey(), findValueWithOldestTimestamp);
    }

    private void updateValue(String str) {
        for (int i = 0; i < 10; i++) {
            FailureCacheValue failureCacheValue = this.storage.get(str);
            if (failureCacheValue == null) {
                if (this.storage.putIfAbsent(str, new FailureCacheValue(str, 1)) == null) {
                    return;
                }
            } else {
                int errorCount = failureCacheValue.getErrorCount();
                if (errorCount == Integer.MAX_VALUE) {
                    return;
                }
                if (this.storage.replace(str, failureCacheValue, new FailureCacheValue(str, errorCount + 1))) {
                    return;
                }
            }
        }
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.FailureCache
    public int getErrorCount(String str) {
        if (str != null) {
            FailureCacheValue failureCacheValue = this.storage.get(str);
            if (failureCacheValue == null) {
                return 0;
            }
            return failureCacheValue.getErrorCount();
        }
        throw new IllegalArgumentException("identifier may not be null");
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.FailureCache
    public void increaseErrorCount(String str) {
        if (str != null) {
            updateValue(str);
            removeOldestEntryIfMapSizeExceeded();
            return;
        }
        throw new IllegalArgumentException("identifier may not be null");
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.FailureCache
    public void resetErrorCount(String str) {
        if (str != null) {
            this.storage.remove(str);
            return;
        }
        throw new IllegalArgumentException("identifier may not be null");
    }
}
