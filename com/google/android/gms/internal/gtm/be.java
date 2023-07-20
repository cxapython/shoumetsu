package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class be extends bi {
    private final int b;
    private final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(byte[] bArr, int i, int i2) {
        super(bArr);
        b(i, i + i2, bArr.length);
        this.b = i;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bi, com.google.android.gms.internal.gtm.zzps
    public final byte a(int i) {
        return this.a[this.b + i];
    }

    @Override // com.google.android.gms.internal.gtm.bi
    protected final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.gtm.bi, com.google.android.gms.internal.gtm.zzps
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.gtm.bi, com.google.android.gms.internal.gtm.zzps
    public final byte zzak(int i) {
        int size = size();
        if (((size - (i + 1)) | i) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(size);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        return this.a[this.b + i];
    }
}
