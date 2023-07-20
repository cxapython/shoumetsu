package com.google.android.gms.internal.gtm;

import java.util.Arrays;

/* loaded from: classes.dex */
final class eo {
    final int a;
    final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eo)) {
            return false;
        }
        eo eoVar = (eo) obj;
        return this.a == eoVar.a && Arrays.equals(this.b, eoVar.b);
    }

    public final int hashCode() {
        return ((this.a + 527) * 31) + Arrays.hashCode(this.b);
    }
}
