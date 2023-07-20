package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SM;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import java.util.Date;

@Immutable
/* loaded from: classes.dex */
public class BasicExpiresHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    private final String[] datepatterns;

    public BasicExpiresHandler(String[] strArr) {
        Args.notNull(strArr, "Array of date patterns");
        this.datepatterns = strArr;
    }

    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.EXPIRES_ATTR;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) {
        Args.notNull(setCookie, SM.COOKIE);
        if (str != null) {
            Date parseDate = cz.msebera.android.httpclient.client.utils.DateUtils.parseDate(str, this.datepatterns);
            if (parseDate != null) {
                setCookie.setExpiryDate(parseDate);
                return;
            }
            throw new MalformedCookieException("Invalid 'expires' attribute: " + str);
        }
        throw new MalformedCookieException("Missing value for 'expires' attribute");
    }
}
