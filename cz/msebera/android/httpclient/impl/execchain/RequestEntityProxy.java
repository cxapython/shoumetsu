package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
/* loaded from: classes.dex */
class RequestEntityProxy implements HttpEntity {
    private boolean consumed = false;
    private final HttpEntity original;

    RequestEntityProxy(HttpEntity httpEntity) {
        this.original = httpEntity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void enhance(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity == null || entity.isRepeatable() || isEnhanced(entity)) {
            return;
        }
        httpEntityEnclosingRequest.setEntity(new RequestEntityProxy(entity));
    }

    static boolean isEnhanced(HttpEntity httpEntity) {
        return httpEntity instanceof RequestEntityProxy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isRepeatable(HttpRequest httpRequest) {
        HttpEntity entity;
        if (!(httpRequest instanceof HttpEntityEnclosingRequest) || (entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity()) == null) {
            return true;
        }
        if (isEnhanced(entity) && !((RequestEntityProxy) entity).isConsumed()) {
            return true;
        }
        return entity.isRepeatable();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    @Deprecated
    public void consumeContent() {
        this.consumed = true;
        this.original.consumeContent();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() {
        return this.original.getContent();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return this.original.getContentEncoding();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.original.getContentLength();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentType() {
        return this.original.getContentType();
    }

    public HttpEntity getOriginal() {
        return this.original;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return this.original.isChunked();
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return this.original.isRepeatable();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return this.original.isStreaming();
    }

    public String toString() {
        return "RequestEntityProxy{" + this.original + '}';
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) {
        this.consumed = true;
        this.original.writeTo(outputStream);
    }
}
