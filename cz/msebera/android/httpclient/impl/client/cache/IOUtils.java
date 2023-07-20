package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.annotation.Immutable;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

@Immutable
/* loaded from: classes.dex */
class IOUtils {
    IOUtils() {
    }

    static void closeSilently(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void consume(HttpEntity httpEntity) {
        InputStream content;
        if (httpEntity == null || !httpEntity.isStreaming() || (content = httpEntity.getContent()) == null) {
            return;
        }
        content.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyAndClose(InputStream inputStream, OutputStream outputStream) {
        try {
            copy(inputStream, outputStream);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            closeSilently(inputStream);
            closeSilently(outputStream);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyFile(File file, File file2) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            FileChannel channel2 = randomAccessFile2.getChannel();
            try {
                channel.transferTo(0L, randomAccessFile.length(), channel2);
                channel.close();
                channel2.close();
                randomAccessFile.close();
                randomAccessFile2.close();
            } catch (IOException e) {
                closeSilently(channel);
                closeSilently(channel2);
                throw e;
            }
        } catch (IOException e2) {
            closeSilently(randomAccessFile);
            closeSilently(randomAccessFile2);
            throw e2;
        }
    }
}
