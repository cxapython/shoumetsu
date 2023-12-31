package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.util.Args;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable
/* loaded from: classes.dex */
public class CacheEntity implements HttpEntity, Serializable {
    private static final long serialVersionUID = -3467082284120936233L;
    private final HttpCacheEntry cacheEntry;

    public CacheEntity(HttpCacheEntry httpCacheEntry) {
        this.cacheEntry = httpCacheEntry;
    }

    public Object clone() {
        return super.clone();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() {
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() {
        return this.cacheEntry.getResource().getInputStream();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return this.cacheEntry.getFirstHeader("Content-Encoding");
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.cacheEntry.getResource().length();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentType() {
        return this.cacheEntry.getFirstHeader("Content-Type");
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) {
        Args.notNull(outputStream, "Output stream");
        InputStream inputStream = this.cacheEntry.getResource().getInputStream();
        try {
            IOUtils.copy(inputStream, outputStream);
        } finally {
            inputStream.close();
        }
    }
}
