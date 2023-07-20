package com.google.android.gms.tagmanager;

import java.util.Arrays;

/* loaded from: classes.dex */
final class v {
    final String a;
    final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(String str, byte[] bArr) {
        this.a = str;
        this.b = bArr;
    }

    public final String toString() {
        String str = this.a;
        int hashCode = Arrays.hashCode(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
        sb.append("KeyAndSerialized: key = ");
        sb.append(str);
        sb.append(" serialized hash = ");
        sb.append(hashCode);
        return sb.toString();
    }
}
