package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;

/* loaded from: classes.dex */
final class bb {
    private final KeyPair a;
    private final long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public bb(KeyPair keyPair, long j) {
        this.a = keyPair;
        this.b = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b() {
        return Base64.encodeToString(this.a.getPublic().getEncoded(), 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        return Base64.encodeToString(this.a.getPrivate().getEncoded(), 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final KeyPair a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        return this.b == bbVar.b && this.a.getPublic().equals(bbVar.a.getPublic()) && this.a.getPrivate().equals(bbVar.a.getPrivate());
    }

    public final int hashCode() {
        return Objects.hashCode(this.a.getPublic(), this.a.getPrivate(), Long.valueOf(this.b));
    }
}
