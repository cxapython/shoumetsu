package com.google.android.gms.common;

import java.util.Arrays;

/* loaded from: classes.dex */
final class e extends d {
    private final byte[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.a = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.d
    public final byte[] a() {
        return this.a;
    }
}
