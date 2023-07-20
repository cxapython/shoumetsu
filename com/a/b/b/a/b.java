package com.a.b.b.a;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.request.GameRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class b {
    private HashMap<String, a> c = new HashMap<>();
    public HashMap<File, ZipFile> a = new HashMap<>();
    ByteBuffer b = ByteBuffer.allocate(4);

    /* loaded from: classes.dex */
    public static final class a {
        public final File a;
        public final String b;
        public final String c;
        public long d;
        public int e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j = -1;

        public a(String str, File file, String str2) {
            this.b = str2;
            this.c = str;
            this.a = file;
        }

        public long a() {
            return this.j;
        }

        public void a(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer) {
            long j = this.d;
            try {
                randomAccessFile.seek(j);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) == 67324752) {
                    this.j = j + 30 + (byteBuffer.getShort(26) & 65535) + (byteBuffer.getShort(28) & 65535);
                } else {
                    Log.w("zipro", "didn't find signature at start of lfh");
                    throw new IOException();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public AssetFileDescriptor b() {
            if (this.e == 0) {
                try {
                    return new AssetFileDescriptor(ParcelFileDescriptor.open(this.a, DriveFile.MODE_READ_ONLY), a(), this.i);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
    }

    public b(String str) {
        b(str);
    }

    private static int a(int i) {
        return ((i & 255) << 24) + ((65280 & i) << 8) + ((16711680 & i) >>> 8) + ((i >>> 24) & 255);
    }

    private static int a(RandomAccessFile randomAccessFile) {
        return a(randomAccessFile.readInt());
    }

    public AssetFileDescriptor a(String str) {
        a aVar = this.c.get(str);
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        File file = new File(str);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = randomAccessFile.length();
        if (length >= 22) {
            long j = 65557;
            if (65557 > length) {
                j = length;
            }
            randomAccessFile.seek(0L);
            int a2 = a(randomAccessFile);
            if (a2 == 101010256) {
                Log.i("zipro", "Found Zip archive, but it looks empty");
                throw new IOException();
            } else if (a2 != 67324752) {
                Log.v("zipro", "Not a Zip archive");
                throw new IOException();
            } else {
                randomAccessFile.seek(length - j);
                ByteBuffer allocate = ByteBuffer.allocate((int) j);
                byte[] array = allocate.array();
                randomAccessFile.readFully(array);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                int length2 = array.length - 22;
                while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != 101010256)) {
                    length2--;
                }
                if (length2 < 0) {
                    Log.d("zipro", "Zip: EOCD not found, " + str + " is not zip");
                }
                short s = allocate.getShort(length2 + 8);
                long j2 = allocate.getInt(length2 + 12) & 4294967295L;
                long j3 = allocate.getInt(length2 + 16) & 4294967295L;
                if (j3 + j2 > length) {
                    Log.w("zipro", "bad offsets (dir " + j3 + ", size " + j2 + ", eocd " + length2 + ")");
                    throw new IOException();
                } else if (s == 0) {
                    Log.w("zipro", "empty archive?");
                    throw new IOException();
                } else {
                    MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, j3, j2);
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    short s2 = 65535;
                    byte[] bArr = new byte[GameRequest.TYPE_ALL];
                    ByteBuffer allocate2 = ByteBuffer.allocate(30);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < s) {
                        if (map.getInt(i3) != 33639248) {
                            Log.w("zipro", "Missed a central dir sig (at " + i3 + ")");
                            throw new IOException();
                        }
                        int i4 = map.getShort(i3 + 28) & s2;
                        int i5 = map.getShort(i3 + 30) & s2;
                        int i6 = map.getShort(i3 + 32) & s2;
                        map.position(i3 + 46);
                        map.get(bArr, i, i4);
                        map.position(i);
                        String str2 = new String(bArr, i, i4);
                        a aVar = new a(str, file, str2);
                        aVar.e = map.getShort(i3 + 10) & s2;
                        aVar.f = map.getInt(i3 + 12) & 4294967295L;
                        aVar.g = map.getLong(i3 + 16) & 4294967295L;
                        aVar.h = map.getLong(i3 + 20) & 4294967295L;
                        aVar.i = map.getLong(i3 + 24) & 4294967295L;
                        aVar.d = map.getInt(i3 + 42) & 4294967295L;
                        allocate2.clear();
                        aVar.a(randomAccessFile, allocate2);
                        this.c.put(str2, aVar);
                        i3 += i4 + 46 + i5 + i6;
                        i2++;
                        bArr = bArr;
                        s2 = 65535;
                        i = 0;
                    }
                    return;
                }
            }
        }
        throw new IOException();
    }
}
