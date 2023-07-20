package com.google.android.gms.internal.gtm;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class zzps implements Serializable, Iterable<Byte> {
    private static final bf a;
    private static final Comparator<zzps> c;
    public static final zzps zzavx = new bi(zzre.zzbbh);
    private int b = 0;

    static {
        a = ay.a() ? new bj(null) : new bd(null);
        c = new bb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzps a(byte[] bArr) {
        return new bi(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte b) {
        return b & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Beginning index: ");
                sb.append(i);
                sb.append(" < 0");
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (i2 < i) {
                StringBuilder sb2 = new StringBuilder(66);
                sb2.append("Beginning index larger than ending index: ");
                sb2.append(i);
                sb2.append(", ");
                sb2.append(i2);
                throw new IndexOutOfBoundsException(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("End index: ");
                sb3.append(i2);
                sb3.append(" >= ");
                sb3.append(i3);
                throw new IndexOutOfBoundsException(sb3.toString());
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bg b(int i) {
        return new bg(i, null);
    }

    public static zzps zzb(byte[] bArr, int i, int i2) {
        b(i, i + i2, bArr.length);
        return new bi(a.a(bArr, i, i2));
    }

    public static zzps zzcy(String str) {
        return new bi(str.getBytes(zzre.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a() {
        return this.b;
    }

    protected abstract int a(int i, int i2, int i3);

    protected abstract String a(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(zzpr zzprVar);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int size = size();
            i = a(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.b = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new ba(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract byte zzak(int i);

    public abstract zzps zzc(int i, int i2);

    public final String zznc() {
        return size() == 0 ? "" : a(zzre.a);
    }

    public abstract boolean zznd();
}
