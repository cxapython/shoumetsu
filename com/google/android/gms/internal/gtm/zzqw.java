package com.google.android.gms.internal.gtm;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public enum zzqw {
    DOUBLE(0, by.SCALAR, zzrm.DOUBLE),
    FLOAT(1, by.SCALAR, zzrm.FLOAT),
    INT64(2, by.SCALAR, zzrm.LONG),
    UINT64(3, by.SCALAR, zzrm.LONG),
    INT32(4, by.SCALAR, zzrm.INT),
    FIXED64(5, by.SCALAR, zzrm.LONG),
    FIXED32(6, by.SCALAR, zzrm.INT),
    BOOL(7, by.SCALAR, zzrm.BOOLEAN),
    STRING(8, by.SCALAR, zzrm.STRING),
    MESSAGE(9, by.SCALAR, zzrm.MESSAGE),
    BYTES(10, by.SCALAR, zzrm.BYTE_STRING),
    UINT32(11, by.SCALAR, zzrm.INT),
    ENUM(12, by.SCALAR, zzrm.ENUM),
    SFIXED32(13, by.SCALAR, zzrm.INT),
    SFIXED64(14, by.SCALAR, zzrm.LONG),
    SINT32(15, by.SCALAR, zzrm.INT),
    SINT64(16, by.SCALAR, zzrm.LONG),
    GROUP(17, by.SCALAR, zzrm.MESSAGE),
    DOUBLE_LIST(18, by.VECTOR, zzrm.DOUBLE),
    FLOAT_LIST(19, by.VECTOR, zzrm.FLOAT),
    INT64_LIST(20, by.VECTOR, zzrm.LONG),
    UINT64_LIST(21, by.VECTOR, zzrm.LONG),
    INT32_LIST(22, by.VECTOR, zzrm.INT),
    FIXED64_LIST(23, by.VECTOR, zzrm.LONG),
    FIXED32_LIST(24, by.VECTOR, zzrm.INT),
    BOOL_LIST(25, by.VECTOR, zzrm.BOOLEAN),
    STRING_LIST(26, by.VECTOR, zzrm.STRING),
    MESSAGE_LIST(27, by.VECTOR, zzrm.MESSAGE),
    BYTES_LIST(28, by.VECTOR, zzrm.BYTE_STRING),
    UINT32_LIST(29, by.VECTOR, zzrm.INT),
    ENUM_LIST(30, by.VECTOR, zzrm.ENUM),
    SFIXED32_LIST(31, by.VECTOR, zzrm.INT),
    SFIXED64_LIST(32, by.VECTOR, zzrm.LONG),
    SINT32_LIST(33, by.VECTOR, zzrm.INT),
    SINT64_LIST(34, by.VECTOR, zzrm.LONG),
    DOUBLE_LIST_PACKED(35, by.PACKED_VECTOR, zzrm.DOUBLE),
    FLOAT_LIST_PACKED(36, by.PACKED_VECTOR, zzrm.FLOAT),
    INT64_LIST_PACKED(37, by.PACKED_VECTOR, zzrm.LONG),
    UINT64_LIST_PACKED(38, by.PACKED_VECTOR, zzrm.LONG),
    INT32_LIST_PACKED(39, by.PACKED_VECTOR, zzrm.INT),
    FIXED64_LIST_PACKED(40, by.PACKED_VECTOR, zzrm.LONG),
    FIXED32_LIST_PACKED(41, by.PACKED_VECTOR, zzrm.INT),
    BOOL_LIST_PACKED(42, by.PACKED_VECTOR, zzrm.BOOLEAN),
    UINT32_LIST_PACKED(43, by.PACKED_VECTOR, zzrm.INT),
    ENUM_LIST_PACKED(44, by.PACKED_VECTOR, zzrm.ENUM),
    SFIXED32_LIST_PACKED(45, by.PACKED_VECTOR, zzrm.INT),
    SFIXED64_LIST_PACKED(46, by.PACKED_VECTOR, zzrm.LONG),
    SINT32_LIST_PACKED(47, by.PACKED_VECTOR, zzrm.INT),
    SINT64_LIST_PACKED(48, by.PACKED_VECTOR, zzrm.LONG),
    GROUP_LIST(49, by.VECTOR, zzrm.MESSAGE),
    MAP(50, by.MAP, zzrm.VOID);
    
    private static final zzqw[] ac;
    private static final Type[] ad = new Type[0];
    private final zzrm X;
    private final int Y;
    private final by Z;
    private final Class<?> aa;
    private final boolean ab;

    static {
        zzqw[] values = values();
        ac = new zzqw[values.length];
        for (zzqw zzqwVar : values) {
            ac[zzqwVar.Y] = zzqwVar;
        }
    }

    zzqw(int i, by byVar, zzrm zzrmVar) {
        Class<?> zzpx;
        this.Y = i;
        this.Z = byVar;
        this.X = zzrmVar;
        switch (byVar) {
            case MAP:
            case VECTOR:
                zzpx = zzrmVar.zzpx();
                break;
            default:
                zzpx = null;
                break;
        }
        this.aa = zzpx;
        boolean z = false;
        if (byVar == by.SCALAR) {
            switch (zzrmVar) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.ab = z;
    }

    public final int id() {
        return this.Y;
    }
}
