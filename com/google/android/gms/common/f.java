package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class f extends d {
    private static final WeakReference<byte[]> b = new WeakReference<>(null);
    private WeakReference<byte[]> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(byte[] bArr) {
        super(bArr);
        this.a = b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.d
    public final byte[] a() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.a.get();
            if (bArr == null) {
                bArr = b();
                this.a = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] b();
}
