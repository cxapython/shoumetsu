package com.google.android.gms.internal.gtm;

import java.util.Arrays;

/* loaded from: classes.dex */
final class bd implements bf {
    private bd() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bd(ba baVar) {
        this();
    }

    @Override // com.google.android.gms.internal.gtm.bf
    public final byte[] a(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }
}
