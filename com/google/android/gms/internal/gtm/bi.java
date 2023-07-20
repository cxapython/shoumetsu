package com.google.android.gms.internal.gtm;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends bh {
    protected final byte[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(byte[] bArr) {
        if (bArr != null) {
            this.a = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzps
    public byte a(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    protected final int a(int i, int i2, int i3) {
        return zzre.a(i, this.a, b(), i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    protected final String a(Charset charset) {
        return new String(this.a, b(), size(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzps
    public final void a(zzpr zzprVar) {
        zzprVar.zza(this.a, b(), size());
    }

    @Override // com.google.android.gms.internal.gtm.bh
    final boolean a(zzps zzpsVar, int i, int i2) {
        if (i2 > zzpsVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 <= zzpsVar.size()) {
            if (!(zzpsVar instanceof bi)) {
                return zzpsVar.zzc(0, i2).equals(zzc(0, i2));
            }
            bi biVar = (bi) zzpsVar;
            return dz.a(this.a, b(), biVar.a, biVar.b(), i2) == -1;
        } else {
            int size2 = zzpsVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    protected int b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzps) || size() != ((zzps) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof bi)) {
            return obj.equals(this);
        }
        bi biVar = (bi) obj;
        int a = a();
        int a2 = biVar.a();
        if (a != 0 && a2 != 0 && a != a2) {
            return false;
        }
        return a(biVar, 0, size());
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public int size() {
        return this.a.length;
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public byte zzak(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final zzps zzc(int i, int i2) {
        int b = b(0, i2, size());
        return b == 0 ? zzps.zzavx : new be(this.a, b(), b);
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final boolean zznd() {
        int b = b();
        return eb.a(this.a, b, size() + b);
    }
}
