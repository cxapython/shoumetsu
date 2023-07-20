package org.apache.http.entity.mime.content;

import com.google.android.gms.nearby.connection.Connections;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.james.mime4j.field.ContentTypeField;

@NotThreadSafe
/* loaded from: classes.dex */
public class StringBody extends AbstractContentBody {
    private final Charset charset;
    private final byte[] content;

    public StringBody(String str) {
        this(str, "text/plain", null);
    }

    public StringBody(String str, String str2, Charset charset) {
        super(str2);
        if (str != null) {
            charset = charset == null ? Charset.defaultCharset() : charset;
            this.content = str.getBytes(charset.name());
            this.charset = charset;
            return;
        }
        throw new IllegalArgumentException("Text may not be null");
    }

    public StringBody(String str, Charset charset) {
        this(str, "text/plain", charset);
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getCharset() {
        return this.charset.name();
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public long getContentLength() {
        return this.content.length;
    }

    @Override // org.apache.http.entity.mime.content.AbstractContentBody, org.apache.james.mime4j.descriptor.ContentDescriptor
    public Map<String, String> getContentTypeParameters() {
        HashMap hashMap = new HashMap();
        hashMap.put(ContentTypeField.PARAM_CHARSET, this.charset.name());
        return hashMap;
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return null;
    }

    public Reader getReader() {
        return new InputStreamReader(new ByteArrayInputStream(this.content), this.charset);
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getTransferEncoding() {
        return "8bit";
    }

    @Override // org.apache.james.mime4j.message.SingleBody
    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
            byte[] bArr = new byte[Connections.MAX_RELIABLE_MESSAGE_LEN];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    @Deprecated
    public void writeTo(OutputStream outputStream, int i) {
        writeTo(outputStream);
    }
}
