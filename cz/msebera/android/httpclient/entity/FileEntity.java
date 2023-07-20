package cz.msebera.android.httpclient.entity;

import com.google.android.gms.nearby.connection.Connections;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.util.Args;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
/* loaded from: classes.dex */
public class FileEntity extends AbstractHttpEntity implements Cloneable {
    protected final File file;

    public FileEntity(File file) {
        this.file = (File) Args.notNull(file, "File");
    }

    public FileEntity(File file, ContentType contentType) {
        this.file = (File) Args.notNull(file, "File");
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    @Deprecated
    public FileEntity(File file, String str) {
        this.file = (File) Args.notNull(file, "File");
        setContentType(str);
    }

    public Object clone() {
        return super.clone();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() {
        return new FileInputStream(this.file);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.file.length();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) {
        Args.notNull(outputStream, "Output stream");
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
    }
}
