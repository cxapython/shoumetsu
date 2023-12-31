package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.util.Args;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class DecompressingEntity extends HttpEntityWrapper {
    private static final int BUFFER_SIZE = 2048;
    private InputStream content;
    private final InputStreamFactory inputStreamFactory;

    public DecompressingEntity(HttpEntity httpEntity, InputStreamFactory inputStreamFactory) {
        super(httpEntity);
        this.inputStreamFactory = inputStreamFactory;
    }

    private InputStream getDecompressingStream() {
        return new LazyDecompressingInputStream(this.wrappedEntity.getContent(), this.inputStreamFactory);
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() {
        if (this.wrappedEntity.isStreaming()) {
            if (this.content == null) {
                this.content = getDecompressingStream();
            }
            return this.content;
        }
        return getDecompressingStream();
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return -1L;
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) {
        Args.notNull(outputStream, "Output stream");
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[BUFFER_SIZE];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } finally {
            content.close();
        }
    }
}
