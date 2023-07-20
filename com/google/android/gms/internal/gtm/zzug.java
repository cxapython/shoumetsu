package com.google.android.gms.internal.gtm;

/* JADX WARN: Init of enum zzbfx can be incorrect */
/* JADX WARN: Init of enum zzbfy can be incorrect */
/* JADX WARN: Init of enum zzbfz can be incorrect */
/* JADX WARN: Init of enum zzbga can be incorrect */
/* loaded from: classes.dex */
public enum zzug {
    DOUBLE(zzul.DOUBLE, 1),
    FLOAT(zzul.FLOAT, 5),
    INT64(zzul.LONG, 0),
    UINT64(zzul.LONG, 0),
    INT32(zzul.INT, 0),
    FIXED64(zzul.LONG, 1),
    FIXED32(zzul.INT, 5),
    BOOL(zzul.BOOLEAN, 0),
    STRING(r2, 2) { // from class: com.google.android.gms.internal.gtm.ei
    },
    GROUP(r2, 3) { // from class: com.google.android.gms.internal.gtm.ej
    },
    MESSAGE(r2, 2) { // from class: com.google.android.gms.internal.gtm.ek
    },
    BYTES(r2, 2) { // from class: com.google.android.gms.internal.gtm.el
    },
    UINT32(zzul.INT, 0),
    ENUM(zzul.ENUM, 0),
    SFIXED32(zzul.INT, 5),
    SFIXED64(zzul.LONG, 1),
    SINT32(zzul.INT, 0),
    SINT64(zzul.LONG, 0);
    
    private final zzul a;
    private final int b;

    static {
        final zzul zzulVar = zzul.STRING;
        final zzul zzulVar2 = zzul.MESSAGE;
        final zzul zzulVar3 = zzul.MESSAGE;
        final zzul zzulVar4 = zzul.BYTE_STRING;
    }

    zzug(zzul zzulVar, int i) {
        this.a = zzulVar;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* synthetic */ zzug(zzul zzulVar, int i, eh ehVar) {
        this(zzulVar, i);
    }

    public final zzul zzrs() {
        return this.a;
    }

    public final int zzrt() {
        return this.b;
    }
}
