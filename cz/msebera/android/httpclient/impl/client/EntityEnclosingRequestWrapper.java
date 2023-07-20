package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
@Deprecated
/* loaded from: classes.dex */
public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
    private boolean consumed;
    private HttpEntity entity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class EntityWrapper extends HttpEntityWrapper {
        EntityWrapper(HttpEntity httpEntity) {
            super(httpEntity);
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public void consumeContent() {
            EntityEnclosingRequestWrapper.this.consumed = true;
            super.consumeContent();
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public InputStream getContent() {
            EntityEnclosingRequestWrapper.this.consumed = true;
            return super.getContent();
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public void writeTo(OutputStream outputStream) {
            EntityEnclosingRequestWrapper.this.consumed = true;
            super.writeTo(outputStream);
        }
    }

    public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        super(httpEntityEnclosingRequest);
        setEntity(httpEntityEnclosingRequest.getEntity());
    }

    @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        Header firstHeader = getFirstHeader("Expect");
        return firstHeader != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(firstHeader.getValue());
    }

    @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // cz.msebera.android.httpclient.impl.client.RequestWrapper
    public boolean isRepeatable() {
        HttpEntity httpEntity = this.entity;
        return httpEntity == null || httpEntity.isRepeatable() || !this.consumed;
    }

    @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity != null ? new EntityWrapper(httpEntity) : null;
        this.consumed = false;
    }
}
