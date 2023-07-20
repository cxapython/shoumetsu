package com.google.android.gms.internal.nearby;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zzgr {
    private static final ParcelUuid a = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int b;
    private final List<ParcelUuid> c;
    private final SparseArray<byte[]> d;
    private final Map<ParcelUuid, byte[]> e;
    private final int f;
    private final String g;
    private final byte[] h;

    private zzgr(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.c = list;
        this.d = sparseArray;
        this.e = map;
        this.g = str;
        this.b = i;
        this.f = i2;
        this.h = bArr;
    }

    private static int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(a(a(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static ParcelUuid a(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                StringBuilder sb = new StringBuilder(38);
                sb.append("uuidBytes length invalid - ");
                sb.append(length);
                throw new IllegalArgumentException(sb.toString());
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
                } else {
                    j = ((bArr[3] & 255) << 24) + (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
                }
                return new ParcelUuid(new UUID(a.getUuid().getMostSignificantBits() + (j << 32), a.getUuid().getLeastSignificantBits()));
            }
        }
        throw new IllegalArgumentException("uuidBytes cannot be null");
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzgr zzd(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        HashMap hashMap = new HashMap();
        String str = null;
        int i2 = -1;
        byte b = -2147483648;
        while (i < bArr.length) {
            try {
                int i3 = i + 1;
                int i4 = bArr[i] & 255;
                if (i4 == 0) {
                    return new zzgr(!arrayList.isEmpty() ? null : arrayList, sparseArray, hashMap, i2, b, str, bArr);
                }
                int i5 = i4 - 1;
                int i6 = i3 + 1;
                int i7 = bArr[i3] & 255;
                if (i7 == 22) {
                    hashMap.put(a(a(bArr, i6, 2)), a(bArr, i6 + 2, i5 - 2));
                } else if (i7 != 255) {
                    switch (i7) {
                        case 1:
                            i2 = bArr[i6] & 255;
                            continue;
                        case 2:
                        case 3:
                            a(bArr, i6, i5, 2, arrayList);
                            continue;
                        case 4:
                        case 5:
                            a(bArr, i6, i5, 4, arrayList);
                            continue;
                        case 6:
                        case 7:
                            a(bArr, i6, i5, 16, arrayList);
                            continue;
                        case 8:
                        case 9:
                            str = new String(a(bArr, i6, i5));
                            continue;
                        case 10:
                            b = bArr[i6];
                            continue;
                        default:
                            continue;
                    }
                } else {
                    sparseArray.put(((bArr[i6 + 1] & 255) << 8) + (255 & bArr[i6]), a(bArr, i6 + 2, i5 - 2));
                }
                i = i5 + i6;
            } catch (Exception e) {
                String valueOf = String.valueOf(Arrays.toString(bArr));
                Log.w("BleRecord", valueOf.length() != 0 ? "Unable to parse scan record: ".concat(valueOf) : new String("Unable to parse scan record: "), e);
                return null;
            }
        }
        return new zzgr(!arrayList.isEmpty() ? null : arrayList, sparseArray, hashMap, i2, b, str, bArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgr) {
            return Arrays.equals(this.h, ((zzgr) obj).h);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.h);
    }

    public final String toString() {
        String sb;
        String sb2;
        int i = this.b;
        String valueOf = String.valueOf(this.c);
        SparseArray<byte[]> sparseArray = this.d;
        StringBuilder sb3 = new StringBuilder();
        int i2 = 0;
        if (sparseArray.size() <= 0) {
            sb = "{}";
        } else {
            sb3.append('{');
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                if (i3 > 0) {
                    sb3.append(", ");
                }
                int keyAt = sparseArray.keyAt(i3);
                byte[] valueAt = sparseArray.valueAt(i3);
                sb3.append(keyAt);
                sb3.append('=');
                sb3.append(valueAt == null ? null : Hex.bytesToStringUppercase(valueAt));
            }
            sb3.append('}');
            sb = sb3.toString();
        }
        Map<ParcelUuid, byte[]> map = this.e;
        StringBuilder sb4 = new StringBuilder();
        if (map.keySet().size() <= 0) {
            sb2 = "{}";
        } else {
            sb4.append('{');
            for (Map.Entry<ParcelUuid, byte[]> entry : map.entrySet()) {
                if (i2 > 0) {
                    sb4.append(", ");
                }
                sb4.append(entry.getKey());
                sb4.append('=');
                byte[] value = entry.getValue();
                sb4.append(value == null ? null : Hex.bytesToStringUppercase(value));
                i2++;
            }
            sb4.append('}');
            sb2 = sb4.toString();
        }
        int i4 = this.f;
        String str = this.g;
        StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf).length() + 139 + String.valueOf(sb).length() + String.valueOf(sb2).length() + String.valueOf(str).length());
        sb5.append("BleRecord [mAdvertiseFlags=");
        sb5.append(i);
        sb5.append(", mServiceUuids=");
        sb5.append(valueOf);
        sb5.append(", mManufacturerSpecificData=");
        sb5.append(sb);
        sb5.append(", mServiceData=");
        sb5.append(sb2);
        sb5.append(", mTxPowerLevel=");
        sb5.append(i4);
        sb5.append(", mDeviceName=");
        sb5.append(str);
        sb5.append("]");
        return sb5.toString();
    }
}
