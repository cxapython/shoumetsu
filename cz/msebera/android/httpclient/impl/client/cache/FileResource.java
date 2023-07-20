package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.client.cache.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@ThreadSafe
/* loaded from: classes.dex */
public class FileResource implements Resource {
    private static final long serialVersionUID = 4132244415919043397L;
    private volatile boolean disposed = false;
    private final File file;

    public FileResource(File file) {
        this.file = file;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public synchronized void dispose() {
        if (this.disposed) {
            return;
        }
        this.disposed = true;
        this.file.delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized File getFile() {
        return this.file;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public synchronized InputStream getInputStream() {
        return new FileInputStream(this.file);
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public synchronized long length() {
        return this.file.length();
    }
}
