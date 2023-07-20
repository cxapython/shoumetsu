package net.gree.gamelib.core.a.a;

import com.google.android.gms.games.Notifications;
import com.google.android.gms.nearby.connection.Connections;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class b {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 2;
    public static final int e = 4;
    public static final int f = 8;
    public static final int g = 16;
    public static final int h = 32;
    private static final int j = 76;
    private static final String m = "US-ASCII";
    static final /* synthetic */ boolean i = !b.class.desiredAssertionStatus();
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte n = -5;
    private static final byte k = 61;
    private static final byte o = -1;
    private static final byte l = 10;
    private static final byte[] q = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, k, -9, -9, -9, o, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, l, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] s = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, k, -9, -9, -9, o, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, l, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] t = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] u = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, l, -9, -9, -9, o, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, k, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* loaded from: classes.dex */
    public static class a extends FilterInputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private int f;
        private boolean g;
        private int h;
        private byte[] i;

        public a(InputStream inputStream) {
            this(inputStream, 0);
        }

        public a(InputStream inputStream, int i) {
            super(inputStream);
            this.h = i;
            boolean z = true;
            this.g = (i & 8) > 0;
            this.a = (i & 1) <= 0 ? false : z;
            this.d = this.a ? 4 : 3;
            this.c = new byte[this.d];
            this.b = -1;
            this.f = 0;
            this.i = b.c(i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read;
            if (this.b < 0) {
                if (this.a) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    for (int i2 = 0; i2 < 3; i2++) {
                        int read2 = this.in.read();
                        if (read2 < 0) {
                            break;
                        }
                        bArr[i2] = (byte) read2;
                        i++;
                    }
                    if (i <= 0) {
                        return -1;
                    }
                    b.b(bArr, 0, i, this.c, 0, this.h);
                    this.b = 0;
                    this.e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = this.in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.i[read & Notifications.NOTIFICATION_TYPES_ALL] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 != 4) {
                        if (i3 != 0) {
                            throw new IOException("Improperly padded Base64 input.");
                        }
                        return -1;
                    }
                    this.e = b.b(bArr2, 0, this.c, 0, this.h);
                    this.b = 0;
                }
            }
            int i4 = this.b;
            if (i4 >= 0) {
                if (i4 >= this.e) {
                    return -1;
                }
                if (this.a && this.g && this.f >= 76) {
                    this.f = 0;
                    return 10;
                }
                this.f++;
                byte[] bArr3 = this.c;
                int i5 = this.b;
                this.b = i5 + 1;
                byte b = bArr3[i5];
                if (this.b >= this.d) {
                    this.b = -1;
                }
                return b & b.o;
            }
            throw new IOException("Error in Base64 code reading stream.");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    /* renamed from: net.gree.gamelib.core.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0067b extends FilterOutputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public C0067b(OutputStream outputStream) {
            this(outputStream, 1);
        }

        public C0067b(OutputStream outputStream, int i) {
            super(outputStream);
            boolean z = true;
            this.f = (i & 8) != 0;
            this.a = (i & 1) == 0 ? false : z;
            this.d = this.a ? 3 : 4;
            this.c = new byte[this.d];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = b.c(i);
        }

        public void a() {
            if (this.b > 0) {
                if (!this.a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                this.out.write(b.b(this.g, this.c, this.b, this.i));
                this.b = 0;
            }
        }

        public void b() {
            a();
            this.h = true;
        }

        public void c() {
            this.h = false;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
            super.close();
            this.c = null;
            this.out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) {
            if (this.h) {
                this.out.write(i);
                return;
            }
            if (this.a) {
                byte[] bArr = this.c;
                int i2 = this.b;
                this.b = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.b < this.d) {
                    return;
                }
                this.out.write(b.b(this.g, this.c, this.d, this.i));
                this.e += 4;
                if (this.f && this.e >= 76) {
                    this.out.write(10);
                    this.e = 0;
                }
            } else {
                byte[] bArr2 = this.j;
                int i3 = i & Notifications.NOTIFICATION_TYPES_ALL;
                if (bArr2[i3] <= -5) {
                    if (bArr2[i3] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr3 = this.c;
                int i4 = this.b;
                this.b = i4 + 1;
                bArr3[i4] = (byte) i;
                if (this.b < this.d) {
                    return;
                }
                this.out.write(this.g, 0, b.b(bArr3, 0, this.g, 0, this.i));
            }
            this.b = 0;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (this.h) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static Object a(String str, int i2, final ClassLoader classLoader) {
        ByteArrayInputStream byteArrayInputStream;
        byte[] a2 = a(str, i2);
        ObjectInputStream objectInputStream = 0;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(a2);
            } catch (IOException e2) {
                e = e2;
            } catch (ClassNotFoundException e3) {
                e = e3;
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream = null;
            }
            try {
                objectInputStream = classLoader == null ? new ObjectInputStream(byteArrayInputStream) : new ObjectInputStream(byteArrayInputStream) { // from class: net.gree.gamelib.core.a.a.b.1
                    @Override // java.io.ObjectInputStream
                    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
                        Class<?> cls = Class.forName(objectStreamClass.getName(), false, classLoader);
                        return cls == null ? super.resolveClass(objectStreamClass) : cls;
                    }
                };
                Object readObject = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception unused2) {
                }
                return readObject;
            } catch (IOException e4) {
                e = e4;
                throw e;
            } catch (ClassNotFoundException e5) {
                e = e5;
                throw e;
            } catch (Throwable th2) {
                th = th2;
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused3) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            objectInputStream = classLoader;
        }
    }

    public static String a(Serializable serializable) {
        return a(serializable, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static String a(Serializable serializable, int i2) {
        ?? r6;
        ?? r1;
        C0067b c0067b;
        ObjectOutputStream objectOutputStream;
        if (serializable != null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                r1 = new ByteArrayOutputStream();
                try {
                    c0067b = new C0067b(r1, i2 | 1);
                    try {
                        if ((i2 & 2) != 0) {
                            r6 = new GZIPOutputStream(c0067b);
                            try {
                                objectOutputStream2 = new ObjectOutputStream(r6);
                                r6 = r6;
                            } catch (IOException e2) {
                                e = e2;
                                objectOutputStream = objectOutputStream2;
                                objectOutputStream2 = r1;
                                r6 = r6;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    ObjectOutputStream objectOutputStream3 = objectOutputStream;
                                    r1 = objectOutputStream2;
                                    objectOutputStream2 = objectOutputStream3;
                                    try {
                                        objectOutputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        r6.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        c0067b.close();
                                    } catch (Exception unused3) {
                                    }
                                    try {
                                        r1.close();
                                    } catch (Exception unused4) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objectOutputStream2.close();
                                r6.close();
                                c0067b.close();
                                r1.close();
                                throw th;
                            }
                        } else {
                            objectOutputStream2 = new ObjectOutputStream(c0067b);
                            r6 = 0;
                        }
                        objectOutputStream2.writeObject(serializable);
                        try {
                            objectOutputStream2.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            r6.close();
                        } catch (Exception unused6) {
                        }
                        try {
                            c0067b.close();
                        } catch (Exception unused7) {
                        }
                        try {
                            r1.close();
                        } catch (Exception unused8) {
                        }
                        try {
                            return new String(r1.toByteArray(), "US-ASCII");
                        } catch (UnsupportedEncodingException unused9) {
                            return new String(r1.toByteArray());
                        }
                    } catch (IOException e3) {
                        e = e3;
                        ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                        objectOutputStream2 = r1;
                        objectOutputStream = objectOutputStream4;
                        r6 = objectOutputStream4;
                    } catch (Throwable th3) {
                        th = th3;
                        r6 = objectOutputStream2;
                    }
                } catch (IOException e4) {
                    e = e4;
                    r6 = 0;
                    c0067b = null;
                    objectOutputStream2 = r1;
                    objectOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    r6 = 0;
                    c0067b = null;
                }
            } catch (IOException e5) {
                e = e5;
                r6 = 0;
                objectOutputStream = null;
                c0067b = null;
            } catch (Throwable th5) {
                th = th5;
                r6 = 0;
                r1 = 0;
                c0067b = null;
            }
        } else {
            throw new NullPointerException("Cannot serialize a null object.");
        }
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!i) {
                throw new AssertionError(e2.getMessage());
            }
            str = null;
        }
        if (i || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2) {
        return a(bArr, 0, bArr.length, i2);
    }

    public static String a(byte[] bArr, int i2, int i3) {
        String str;
        try {
            str = a(bArr, i2, i3, 0);
        } catch (IOException e2) {
            if (!i) {
                throw new AssertionError(e2.getMessage());
            }
            str = null;
        }
        if (i || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2, int i3, int i4) {
        byte[] b2 = b(bArr, i2, i3, i4);
        try {
            return new String(b2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b2);
        }
    }

    public static void a(String str, String str2) {
        C0067b c0067b = null;
        try {
            try {
                C0067b c0067b2 = new C0067b(new FileOutputStream(str2), 0);
                try {
                    c0067b2.write(str.getBytes("US-ASCII"));
                    try {
                        c0067b2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    c0067b = c0067b2;
                    try {
                        c0067b.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static void a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & o));
            }
        }
    }

    public static void a(byte[] bArr, String str) {
        if (bArr != null) {
            C0067b c0067b = null;
            try {
                try {
                    C0067b c0067b2 = new C0067b(new FileOutputStream(str), 1);
                    try {
                        c0067b2.write(bArr);
                        try {
                            c0067b2.close();
                        } catch (Exception unused) {
                        }
                    } catch (IOException e2) {
                    } catch (Throwable th) {
                        th = th;
                        c0067b = c0067b2;
                        try {
                            c0067b.close();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    throw e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new NullPointerException("Data to encode was null.");
        }
    }

    public static byte[] a(String str) {
        return a(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0059 -> B:70:0x0059). Please submit an issue!!! */
    public static byte[] a(String str, int i2) {
        byte[] bytes;
        ?? length;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPInputStream gZIPInputStream;
        if (str != null) {
            try {
                bytes = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            byte[] c2 = c(bytes, 0, bytes.length, i2);
            boolean z = (i2 & 4) != 0;
            if (c2 != null && (length = c2.length) >= 4 && !z && 35615 == ((c2[0] & o) | ((c2[1] << 8) & 65280))) {
                byte[] bArr = new byte[2048];
                GZIPInputStream gZIPInputStream2 = null;
                gZIPInputStream2 = null;
                gZIPInputStream2 = null;
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            length = new ByteArrayInputStream(c2);
                        } catch (IOException e2) {
                            e = e2;
                            length = 0;
                            gZIPInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            length = 0;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        length = 0;
                        gZIPInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                        length = 0;
                    }
                    try {
                        gZIPInputStream = new GZIPInputStream(length);
                        while (true) {
                            try {
                                int read = gZIPInputStream.read(bArr);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (IOException e4) {
                                e = e4;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                length = length;
                                try {
                                    e.printStackTrace();
                                    byteArrayOutputStream2.close();
                                    gZIPInputStream.close();
                                    length.close();
                                    return c2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    gZIPInputStream2 = gZIPInputStream;
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        gZIPInputStream2.close();
                                    } catch (Exception unused3) {
                                    }
                                    try {
                                        length.close();
                                    } catch (Exception unused4) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                gZIPInputStream2 = gZIPInputStream;
                                byteArrayOutputStream.close();
                                gZIPInputStream2.close();
                                length.close();
                                throw th;
                            }
                        }
                        c2 = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        e = e5;
                        gZIPInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream.close();
                        gZIPInputStream2.close();
                        length.close();
                        throw th;
                    }
                } catch (Exception unused5) {
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception unused6) {
                }
                try {
                    length.close();
                } catch (Exception unused7) {
                }
            }
            return c2;
        }
        throw new NullPointerException("Input string was null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr != null) {
            if (bArr2 == null) {
                throw new NullPointerException("Destination array was null.");
            }
            if (i2 < 0 || (i5 = i2 + 3) >= bArr.length) {
                throw new IllegalArgumentException(String.format(Locale.US, "Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
            }
            if (i3 < 0 || (i6 = i3 + 2) >= bArr2.length) {
                throw new IllegalArgumentException(String.format(Locale.US, "Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
            }
            byte[] c2 = c(i4);
            int i7 = i2 + 2;
            if (bArr[i7] == 61) {
                bArr2[i3] = (byte) ((((c2[bArr[i2 + 1]] & o) << 12) | ((c2[bArr[i2]] & o) << 18)) >>> 16);
                return 1;
            } else if (bArr[i5] == 61) {
                int i8 = ((c2[bArr[i7]] & o) << 6) | ((c2[bArr[i2 + 1]] & o) << 12) | ((c2[bArr[i2]] & o) << 18);
                bArr2[i3] = (byte) (i8 >>> 16);
                bArr2[i3 + 1] = (byte) (i8 >>> 8);
                return 2;
            } else {
                int i9 = (c2[bArr[i5]] & o) | ((c2[bArr[i2 + 1]] & o) << 12) | ((c2[bArr[i2]] & o) << 18) | ((c2[bArr[i7]] & o) << 6);
                bArr2[i3] = (byte) (i9 >> 16);
                bArr2[i3 + 1] = (byte) (i9 >> 8);
                bArr2[i6] = (byte) i9;
                return 3;
            }
        }
        throw new NullPointerException("Source array was null.");
    }

    public static Object b(String str) {
        return a(str, 0, (ClassLoader) null);
    }

    public static void b(String str, String str2) {
        String d2 = d(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(d2.getBytes("US-ASCII"));
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static final byte[] b(int i2) {
        return (i2 & 16) == 16 ? r : (i2 & 32) == 32 ? t : p;
    }

    public static byte[] b(byte[] bArr) {
        try {
            return b(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (i) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr, int i2, int i3, int i4) {
        ByteArrayOutputStream byteArrayOutputStream;
        C0067b c0067b;
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Cannot have negative offset: " + i2);
            } else if (i3 < 0) {
                throw new IllegalArgumentException("Cannot have length offset: " + i3);
            } else if (i2 + i3 > bArr.length) {
                throw new IllegalArgumentException(String.format(Locale.US, "Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            } else {
                if ((i4 & 2) == 0) {
                    boolean z = (i4 & 8) != 0;
                    int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
                    if (z) {
                        i5 += i5 / 76;
                    }
                    byte[] bArr2 = new byte[i5];
                    int i6 = i3 - 2;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    while (i7 < i6) {
                        b(bArr, i7 + i2, 3, bArr2, i8, i4);
                        int i10 = i9 + 4;
                        if (!z || i10 < 76) {
                            i9 = i10;
                        } else {
                            bArr2[i8 + 4] = l;
                            i8++;
                            i9 = 0;
                        }
                        i7 += 3;
                        i8 += 4;
                    }
                    if (i7 < i3) {
                        b(bArr, i7 + i2, i3 - i7, bArr2, i8, i4);
                        i8 += 4;
                    }
                    int i11 = i8;
                    if (i11 > bArr2.length - 1) {
                        return bArr2;
                    }
                    byte[] bArr3 = new byte[i11];
                    System.arraycopy(bArr2, 0, bArr3, 0, i11);
                    return bArr3;
                }
                GZIPOutputStream gZIPOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        c0067b = new C0067b(byteArrayOutputStream, i4 | 1);
                    } catch (IOException e2) {
                        e = e2;
                        c0067b = null;
                        gZIPOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        c0067b = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    c0067b = null;
                    gZIPOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = 0;
                    c0067b = null;
                }
                try {
                    gZIPOutputStream = new GZIPOutputStream(c0067b);
                    try {
                        gZIPOutputStream.write(bArr, i2, i3);
                        gZIPOutputStream.close();
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            c0067b.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e4) {
                        e = e4;
                        gZIPOutputStream2 = byteArrayOutputStream;
                        try {
                            throw e;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = gZIPOutputStream2;
                            gZIPOutputStream2 = gZIPOutputStream;
                            try {
                                gZIPOutputStream2.close();
                            } catch (Exception unused4) {
                            }
                            try {
                                c0067b.close();
                            } catch (Exception unused5) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused6) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        gZIPOutputStream2 = gZIPOutputStream;
                        gZIPOutputStream2.close();
                        c0067b.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    gZIPOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    gZIPOutputStream2.close();
                    c0067b.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
        } else {
            throw new NullPointerException("Cannot serialize a null array.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] b2 = b(i5);
        int i6 = 0;
        int i7 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0);
        if (i3 > 2) {
            i6 = (bArr[i2 + 2] << 24) >>> 24;
        }
        int i8 = i7 | i6;
        switch (i3) {
            case 1:
                bArr2[i4] = b2[i8 >>> 18];
                bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
                bArr2[i4 + 2] = k;
                bArr2[i4 + 3] = k;
                return bArr2;
            case 2:
                bArr2[i4] = b2[i8 >>> 18];
                bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
                bArr2[i4 + 2] = b2[(i8 >>> 6) & 63];
                bArr2[i4 + 3] = k;
                return bArr2;
            case 3:
                bArr2[i4] = b2[i8 >>> 18];
                bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
                bArr2[i4 + 2] = b2[(i8 >>> 6) & 63];
                bArr2[i4 + 3] = b2[i8 & 63];
                return bArr2;
            default:
                return bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        b(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    public static void c(String str, String str2) {
        byte[] c2 = c(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(c2);
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i2) {
        return (i2 & 16) == 16 ? s : (i2 & 32) == 32 ? u : q;
    }

    public static byte[] c(String str) {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                if (file.length() > 2147483647L) {
                    throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
                }
                byte[] bArr = new byte[(int) file.length()];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 0);
                int i2 = 0;
                while (true) {
                    try {
                        int read = aVar2.read(bArr, i2, Connections.MAX_RELIABLE_MESSAGE_LEN);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        try {
                            aVar.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] c(byte[] bArr) {
        return c(bArr, 0, bArr.length, 0);
    }

    public static byte[] c(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        if (bArr != null) {
            if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
                throw new IllegalArgumentException(String.format(Locale.US, "Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            if (i3 == 0) {
                return new byte[0];
            }
            if (i3 < 4) {
                throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
            }
            byte[] c2 = c(i4);
            byte[] bArr2 = new byte[(i3 * 3) / 4];
            byte[] bArr3 = new byte[4];
            int i6 = 0;
            int i7 = 0;
            while (i2 < i5) {
                byte b2 = c2[bArr[i2] & o];
                if (b2 < -5) {
                    throw new IOException(String.format(Locale.US, "Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & o), Integer.valueOf(i2)));
                }
                if (b2 >= -1) {
                    int i8 = i6 + 1;
                    bArr3[i6] = bArr[i2];
                    if (i8 > 3) {
                        i7 += b(bArr3, 0, bArr2, i7, i4);
                        if (bArr[i2] == 61) {
                            break;
                        }
                        i6 = 0;
                    } else {
                        i6 = i8;
                    }
                }
                i2++;
            }
            byte[] bArr4 = new byte[i7];
            System.arraycopy(bArr2, 0, bArr4, 0, i7);
            return bArr4;
        }
        throw new NullPointerException("Cannot decode null source array.");
    }

    public static String d(String str) {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 1);
                int i2 = 0;
                while (true) {
                    try {
                        int read = aVar2.read(bArr, i2, Connections.MAX_RELIABLE_MESSAGE_LEN);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        try {
                            aVar.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                String str2 = new String(bArr, 0, i2, "US-ASCII");
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return str2;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
