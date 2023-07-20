package org.apache.http.entity.mime.content;

import com.google.android.gms.nearby.connection.Connections;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes.dex */
public class InputStreamBody extends AbstractContentBody {
    private final String filename;
    private final InputStream in;

    public InputStreamBody(InputStream inputStream, String str) {
        this(inputStream, "application/octet-stream", str);
    }

    public InputStreamBody(InputStream inputStream, String str, String str2) {
        super(str);
        if (inputStream != null) {
            this.in = inputStream;
            this.filename = str2;
            return;
        }
        throw new IllegalArgumentException("Input stream may not be null");
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getCharset() {
        return null;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public long getContentLength() {
        return -1L;
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return this.in;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override // org.apache.james.mime4j.message.SingleBody
    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[Connections.MAX_RELIABLE_MESSAGE_LEN];
                while (true) {
                    int read = this.in.read(bArr);
                    if (read == -1) {
                        outputStream.flush();
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                }
            } finally {
                this.in.close();
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
