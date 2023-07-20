package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.client.cache.InputLimit;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Immutable
/* loaded from: classes.dex */
public class FileResourceFactory implements ResourceFactory {
    private final File cacheDir;
    private final BasicIdGenerator idgen = new BasicIdGenerator();

    public FileResourceFactory(File file) {
        this.cacheDir = file;
    }

    private File generateUniqueCacheFile(String str) {
        StringBuilder sb = new StringBuilder();
        this.idgen.generate(sb);
        sb.append('.');
        int min = Math.min(str.length(), 100);
        for (int i = 0; i < min; i++) {
            char charAt = str.charAt(i);
            if (!Character.isLetterOrDigit(charAt) && charAt != '.') {
                charAt = '-';
            }
            sb.append(charAt);
        }
        return new File(this.cacheDir, sb.toString());
    }

    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    public Resource copy(String str, Resource resource) {
        File generateUniqueCacheFile = generateUniqueCacheFile(str);
        if (resource instanceof FileResource) {
            IOUtils.copyFile(((FileResource) resource).getFile(), generateUniqueCacheFile);
        } else {
            IOUtils.copyAndClose(resource.getInputStream(), new FileOutputStream(generateUniqueCacheFile));
        }
        return new FileResource(generateUniqueCacheFile);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        r10.reached();
     */
    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Resource generate(String str, InputStream inputStream, InputLimit inputLimit) {
        File generateUniqueCacheFile = generateUniqueCacheFile(str);
        FileOutputStream fileOutputStream = new FileOutputStream(generateUniqueCacheFile);
        try {
            byte[] bArr = new byte[2048];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                j += read;
                if (inputLimit != null && j > inputLimit.getValue()) {
                    break;
                }
            }
            fileOutputStream.close();
            return new FileResource(generateUniqueCacheFile);
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }
}
