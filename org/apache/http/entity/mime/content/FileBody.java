package org.apache.http.entity.mime.content;

import com.google.android.gms.nearby.connection.Connections;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes.dex */
public class FileBody extends AbstractContentBody {
    private final File file;

    public FileBody(File file) {
        this(file, "application/octet-stream");
    }

    public FileBody(File file, String str) {
        super(str);
        if (file != null) {
            this.file = file;
            return;
        }
        throw new IllegalArgumentException("File may not be null");
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getCharset() {
        return null;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public long getContentLength() {
        return this.file.length();
    }

    public File getFile() {
        return this.file;
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.file.getName();
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.file);
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override // org.apache.james.mime4j.message.SingleBody
    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            FileInputStream fileInputStream = new FileInputStream(this.file);
            try {
                byte[] bArr = new byte[Connections.MAX_RELIABLE_MESSAGE_LEN];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        outputStream.flush();
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                }
            } finally {
                fileInputStream.close();
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
