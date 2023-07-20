package net.gree.gamelib.moderation.a;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a {
    public static final int a = 8;

    protected a() {
    }

    public static long a(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.put(bArr, 0, bArr.length);
        allocate.flip();
        return allocate.getLong();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putLong(0, j);
        return allocate.array();
    }
}
