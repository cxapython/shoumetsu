package com.google.android.gms.internal.drive;

import java.util.Arrays;

/* loaded from: classes.dex */
final class cs {
    final int a;
    final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cs)) {
            return false;
        }
        cs csVar = (cs) obj;
        return this.a == csVar.a && Arrays.equals(this.b, csVar.b);
    }

    public final int hashCode() {
        return ((this.a + 527) * 31) + Arrays.hashCode(this.b);
    }
}
