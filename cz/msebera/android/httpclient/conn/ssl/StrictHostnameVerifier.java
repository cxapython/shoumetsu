package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
@Deprecated
/* loaded from: classes.dex */
public class StrictHostnameVerifier extends AbstractVerifier {
    public static final StrictHostnameVerifier INSTANCE = new StrictHostnameVerifier();

    public final String toString() {
        return "STRICT";
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier
    public final void verify(String str, String[] strArr, String[] strArr2) {
        verify(str, strArr, strArr2, true);
    }
}
