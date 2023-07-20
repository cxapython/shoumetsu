package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedInputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthInputStream;
import cz.msebera.android.httpclient.impl.io.IdentityInputStream;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.InputStream;

@Immutable
@Deprecated
/* loaded from: classes.dex */
public class EntityDeserializer {
    private final ContentLengthStrategy lenStrategy;

    public EntityDeserializer(ContentLengthStrategy contentLengthStrategy) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(contentLengthStrategy, "Content length strategy");
    }

    public HttpEntity deserialize(SessionInputBuffer sessionInputBuffer, HttpMessage httpMessage) {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(httpMessage, "HTTP message");
        return doDeserialize(sessionInputBuffer, httpMessage);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected BasicHttpEntity doDeserialize(SessionInputBuffer sessionInputBuffer, HttpMessage httpMessage) {
        InputStream identityInputStream;
        Header firstHeader;
        Header firstHeader2;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        long determineLength = this.lenStrategy.determineLength(httpMessage);
        if (determineLength == -2) {
            basicHttpEntity.setChunked(true);
            basicHttpEntity.setContentLength(-1L);
            identityInputStream = new ChunkedInputStream(sessionInputBuffer);
        } else if (determineLength != -1) {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(determineLength);
            basicHttpEntity.setContent(new ContentLengthInputStream(sessionInputBuffer, determineLength));
            firstHeader = httpMessage.getFirstHeader("Content-Type");
            if (firstHeader != null) {
                basicHttpEntity.setContentType(firstHeader);
            }
            firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
            if (firstHeader2 != null) {
                basicHttpEntity.setContentEncoding(firstHeader2);
            }
            return basicHttpEntity;
        } else {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(-1L);
            identityInputStream = new IdentityInputStream(sessionInputBuffer);
        }
        basicHttpEntity.setContent(identityInputStream);
        firstHeader = httpMessage.getFirstHeader("Content-Type");
        if (firstHeader != null) {
        }
        firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
        if (firstHeader2 != null) {
        }
        return basicHttpEntity;
    }
}
