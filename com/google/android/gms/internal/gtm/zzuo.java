package com.google.android.gms.internal.gtm;

import com.google.android.gms.games.Notifications;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes.dex */
public final class zzuo {
    private final ByteBuffer a;
    private zzqj b;
    private int c;

    private zzuo(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        this.a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzuo(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(i3 + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    private final zzqj a() {
        if (this.b != null) {
            if (this.c != this.a.position()) {
                this.b.write(this.a.array(), this.c, this.a.position() - this.c);
            }
            return this.b;
        }
        this.b = zzqj.zza(this.a);
        this.c = this.a.position();
        return this.b;
    }

    private final void a(int i) {
        byte b = (byte) i;
        if (this.a.hasRemaining()) {
            this.a.put(b);
            return;
        }
        throw new zzup(this.a.position(), this.a.limit());
    }

    private final void a(long j) {
        while (((-128) & j) != 0) {
            a((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128);
            j >>>= 7;
        }
        a((int) j);
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        char charAt;
        int i3;
        if (!byteBuffer.isReadOnly()) {
            int i4 = 0;
            if (!byteBuffer.hasArray()) {
                int length = charSequence.length();
                while (i4 < length) {
                    char charAt2 = charSequence.charAt(i4);
                    char c = charAt2;
                    if (charAt2 >= 128) {
                        if (charAt2 < 2048) {
                            i3 = (charAt2 >>> 6) | 960;
                        } else if (charAt2 >= 55296 && 57343 >= charAt2) {
                            int i5 = i4 + 1;
                            if (i5 != charSequence.length()) {
                                char charAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                    i4++;
                                } else {
                                    i4 = i5;
                                }
                            }
                            StringBuilder sb = new StringBuilder(39);
                            sb.append("Unpaired surrogate at index ");
                            sb.append(i4 - 1);
                            throw new IllegalArgumentException(sb.toString());
                        } else {
                            byteBuffer.put((byte) ((charAt2 >>> '\f') | 480));
                            i3 = ((charAt2 >>> 6) & 63) | 128;
                        }
                        byteBuffer.put((byte) i3);
                        c = (charAt2 & '?') | 128;
                    }
                    byteBuffer.put((byte) c);
                    i4++;
                }
                return;
            }
            try {
                byte[] array = byteBuffer.array();
                int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                int remaining = byteBuffer.remaining();
                int length2 = charSequence.length();
                int i6 = remaining + arrayOffset;
                while (i4 < length2) {
                    int i7 = i4 + arrayOffset;
                    if (i7 >= i6 || (charAt = charSequence.charAt(i4)) >= 128) {
                        break;
                    }
                    array[i7] = (byte) charAt;
                    i4++;
                }
                if (i4 == length2) {
                    i = arrayOffset + length2;
                } else {
                    i = arrayOffset + i4;
                    while (i4 < length2) {
                        char charAt4 = charSequence.charAt(i4);
                        if (charAt4 >= 128 || i >= i6) {
                            if (charAt4 < 2048 && i <= i6 - 2) {
                                int i8 = i + 1;
                                array[i] = (byte) ((charAt4 >>> 6) | 960);
                                i = i8 + 1;
                                array[i8] = (byte) ((charAt4 & '?') | 128);
                            } else if ((charAt4 >= 55296 && 57343 >= charAt4) || i > i6 - 3) {
                                if (i > i6 - 4) {
                                    StringBuilder sb2 = new StringBuilder(37);
                                    sb2.append("Failed writing ");
                                    sb2.append(charAt4);
                                    sb2.append(" at index ");
                                    sb2.append(i);
                                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                                }
                                int i9 = i4 + 1;
                                if (i9 != charSequence.length()) {
                                    char charAt5 = charSequence.charAt(i9);
                                    if (Character.isSurrogatePair(charAt4, charAt5)) {
                                        int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                        int i10 = i + 1;
                                        array[i] = (byte) ((codePoint2 >>> 18) | 240);
                                        int i11 = i10 + 1;
                                        array[i10] = (byte) (((codePoint2 >>> 12) & 63) | 128);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint2 >>> 6) & 63) | 128);
                                        i = i12 + 1;
                                        array[i12] = (byte) ((codePoint2 & 63) | 128);
                                        i4 = i9;
                                    } else {
                                        i4 = i9;
                                    }
                                }
                                StringBuilder sb3 = new StringBuilder(39);
                                sb3.append("Unpaired surrogate at index ");
                                sb3.append(i4 - 1);
                                throw new IllegalArgumentException(sb3.toString());
                            } else {
                                int i13 = i + 1;
                                array[i] = (byte) ((charAt4 >>> '\f') | 480);
                                int i14 = i13 + 1;
                                array[i13] = (byte) (((charAt4 >>> 6) & 63) | 128);
                                i2 = i14 + 1;
                                array[i14] = (byte) ((charAt4 & '?') | 128);
                            }
                            i4++;
                        } else {
                            i2 = i + 1;
                            array[i] = (byte) charAt4;
                        }
                        i = i2;
                        i4++;
                    }
                }
                byteBuffer.position(i - byteBuffer.arrayOffset());
                return;
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        }
        throw new ReadOnlyBufferException();
    }

    public static int zzb(int i, zzuw zzuwVar) {
        int zzbb = zzbb(i);
        int zzpe = zzuwVar.zzpe();
        return zzbb + zzbj(zzpe) + zzpe;
    }

    public static int zzb(int i, String str) {
        return zzbb(i) + zzda(str);
    }

    public static int zzbb(int i) {
        return zzbj(i << 3);
    }

    public static int zzbc(int i) {
        if (i >= 0) {
            return zzbj(i);
        }
        return 10;
    }

    public static int zzbj(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzd(int i, long j) {
        return zzbb(i) + (((-128) & j) == 0 ? 1 : ((-16384) & j) == 0 ? 2 : ((-2097152) & j) == 0 ? 3 : ((-268435456) & j) == 0 ? 4 : ((-34359738368L) & j) == 0 ? 5 : ((-4398046511104L) & j) == 0 ? 6 : ((-562949953421312L) & j) == 0 ? 7 : ((-72057594037927936L) & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10);
    }

    public static int zzda(String str) {
        int a = a(str);
        return zzbj(a) + a;
    }

    public static int zzi(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static zzuo zzk(byte[] bArr, int i, int i2) {
        return new zzuo(bArr, 0, i2);
    }

    public static zzuo zzl(byte[] bArr) {
        return zzk(bArr, 0, bArr.length);
    }

    public final void zza(int i, zzuw zzuwVar) {
        zzd(i, 2);
        zzb(zzuwVar);
    }

    public final void zza(int i, String str) {
        zzd(i, 2);
        try {
            int zzbj = zzbj(str.length());
            if (zzbj != zzbj(str.length() * 3)) {
                zzcb(a(str));
                a(str, this.a);
                return;
            }
            int position = this.a.position();
            if (this.a.remaining() < zzbj) {
                throw new zzup(position + zzbj, this.a.limit());
            }
            this.a.position(position + zzbj);
            a(str, this.a);
            int position2 = this.a.position();
            this.a.position(position);
            zzcb((position2 - position) - zzbj);
            this.a.position(position2);
        } catch (BufferOverflowException e) {
            zzup zzupVar = new zzup(this.a.position(), this.a.limit());
            zzupVar.initCause(e);
            throw zzupVar;
        }
    }

    public final void zzb(int i, boolean z) {
        zzd(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        if (this.a.hasRemaining()) {
            this.a.put(b);
            return;
        }
        throw new zzup(this.a.position(), this.a.limit());
    }

    public final void zzb(zzuw zzuwVar) {
        zzcb(zzuwVar.zzse());
        zzuwVar.zza(this);
    }

    public final void zzcb(int i) {
        while ((i & (-128)) != 0) {
            a((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
            i >>>= 7;
        }
        a(i);
    }

    public final void zzcc(int i) {
        if (this.a.remaining() >= 4) {
            this.a.putInt(i);
            return;
        }
        throw new zzup(this.a.position(), this.a.limit());
    }

    public final void zzd(int i, int i2) {
        zzcb((i << 3) | i2);
    }

    public final void zze(int i, int i2) {
        zzd(i, 0);
        if (i2 >= 0) {
            zzcb(i2);
        } else {
            a(i2);
        }
    }

    public final void zze(int i, zzsk zzskVar) {
        zzqj a = a();
        a.zza(i, zzskVar);
        a.flush();
        this.c = this.a.position();
    }

    public final void zzi(int i, long j) {
        zzd(i, 0);
        a(j);
    }

    public final void zzm(byte[] bArr) {
        int length = bArr.length;
        if (this.a.remaining() >= length) {
            this.a.put(bArr, 0, length);
            return;
        }
        throw new zzup(this.a.position(), this.a.limit());
    }

    public final void zzrx() {
        if (this.a.remaining() == 0) {
            return;
        }
        throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.a.remaining())));
    }
}
