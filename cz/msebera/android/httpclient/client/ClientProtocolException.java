package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.io.IOException;

@Immutable
/* loaded from: classes.dex */
public class ClientProtocolException extends IOException {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String str) {
        super(str);
    }

    public ClientProtocolException(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    public ClientProtocolException(Throwable th) {
        initCause(th);
    }
}
