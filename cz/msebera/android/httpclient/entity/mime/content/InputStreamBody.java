package cz.msebera.android.httpclient.entity.mime.content;

import com.google.android.gms.nearby.connection.Connections;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.util.Args;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class InputStreamBody extends AbstractContentBody {
    private final String filename;
    private final InputStream in;

    public InputStreamBody(InputStream inputStream, ContentType contentType) {
        this(inputStream, contentType, (String) null);
    }

    public InputStreamBody(InputStream inputStream, ContentType contentType, String str) {
        super(contentType);
        Args.notNull(inputStream, "Input stream");
        this.in = inputStream;
        this.filename = str;
    }

    public InputStreamBody(InputStream inputStream, String str) {
        this(inputStream, ContentType.DEFAULT_BINARY, str);
    }

    @Deprecated
    public InputStreamBody(InputStream inputStream, String str, String str2) {
        this(inputStream, ContentType.create(str), str2);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return -1L;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return this.in;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) {
        Args.notNull(outputStream, "Output stream");
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
    }
}
