package org.apache.http.entity.mime;

import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.message.BasicHeader;
import org.apache.james.mime4j.field.Fields;
import org.apache.james.mime4j.message.BodyPart;
import org.apache.james.mime4j.message.Message;

@ThreadSafe
/* loaded from: classes.dex */
public class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final Header contentType;
    private volatile boolean dirty;
    private long length;
    private final Message message;
    private final HttpMultipart multipart;

    public MultipartEntity() {
        this(HttpMultipartMode.STRICT, null, null);
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode) {
        this(httpMultipartMode, null, null);
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode, String str, Charset charset) {
        this.multipart = new HttpMultipart("form-data");
        this.contentType = new BasicHeader("Content-Type", generateContentType(str, charset));
        this.dirty = true;
        this.message = new Message();
        this.message.setHeader(new org.apache.james.mime4j.message.Header());
        this.multipart.setParent(this.message);
        this.multipart.setMode(httpMultipartMode == null ? HttpMultipartMode.STRICT : httpMultipartMode);
        this.message.getHeader().addField(Fields.contentType(this.contentType.getValue()));
    }

    public void addPart(String str, ContentBody contentBody) {
        this.multipart.addBodyPart(new FormBodyPart(str, contentBody));
        this.dirty = true;
    }

    public void consumeContent() {
        if (!isStreaming()) {
            return;
        }
        throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }

    protected String generateContentType(String str, Charset charset) {
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        if (str != null) {
            sb.append(str);
        } else {
            Random random = new Random();
            int nextInt = random.nextInt(11) + 30;
            for (int i = 0; i < nextInt; i++) {
                char[] cArr = MULTIPART_CHARS;
                sb.append(cArr[random.nextInt(cArr.length)]);
            }
        }
        if (charset != null) {
            sb.append(HTTP.CHARSET_PARAM);
            sb.append(charset.name());
        }
        return sb.toString();
    }

    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        if (this.dirty) {
            this.length = this.multipart.getTotalLength();
            this.dirty = false;
        }
        return this.length;
    }

    public Header getContentType() {
        return this.contentType;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isRepeatable() {
        Iterator<BodyPart> it = this.multipart.getBodyParts().iterator();
        while (it.hasNext()) {
            if (((ContentBody) ((FormBodyPart) it.next()).getBody()).getContentLength() < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public void writeTo(OutputStream outputStream) {
        this.multipart.writeTo(outputStream);
    }
}
