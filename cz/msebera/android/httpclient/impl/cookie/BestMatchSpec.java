package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.ThreadSafe;

@ThreadSafe
@Deprecated
/* loaded from: classes.dex */
public class BestMatchSpec extends DefaultCookieSpec {
    public BestMatchSpec() {
        this(null, false);
    }

    public BestMatchSpec(String[] strArr, boolean z) {
        super(strArr, z);
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.DefaultCookieSpec
    public String toString() {
        return "best-match";
    }
}
