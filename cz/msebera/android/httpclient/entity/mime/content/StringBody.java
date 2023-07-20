package cz.msebera.android.httpclient.entity.mime.content;

import com.google.android.gms.nearby.connection.Connections;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class StringBody extends AbstractContentBody {
    private final byte[] content;

    @Deprecated
    public StringBody(String str) {
        this(str, "text/plain", Consts.ASCII);
    }

    public StringBody(String str, ContentType contentType) {
        super(contentType);
        Args.notNull(str, "Text");
        Charset charset = contentType.getCharset();
        this.content = str.getBytes(charset == null ? Consts.ASCII : charset);
    }

    @Deprecated
    public StringBody(String str, String str2, Charset charset) {
        this(str, ContentType.create(str2, charset));
    }

    @Deprecated
    public StringBody(String str, Charset charset) {
        this(str, "text/plain", charset);
    }

    @Deprecated
    public static StringBody create(String str) {
        return create(str, null, null);
    }

    @Deprecated
    public static StringBody create(String str, String str2, Charset charset) {
        try {
            return new StringBody(str, str2, charset);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Charset " + charset + " is not supported", e);
        }
    }

    @Deprecated
    public static StringBody create(String str, Charset charset) {
        return create(str, null, charset);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.content.length;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public String getFilename() {
        return null;
    }

    public Reader getReader() {
        Charset charset = getContentType().getCharset();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        if (charset == null) {
            charset = Consts.ASCII;
        }
        return new InputStreamReader(byteArrayInputStream, charset);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "8bit";
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) {
        Args.notNull(outputStream, "Output stream");
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
    }
}
