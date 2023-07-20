package net.gree.gamelib.core.http;

import android.text.TextUtils;
import cz.msebera.android.httpclient.HttpHost;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class RequestUrl {
    protected static final String PARAM_POLICY = "policy";
    protected static final String PARAM_SERVER_URL = "serverUrl";
    protected static final String PARAM_SERVER_URL_SUFFIX = "serverUrlSuffix";
    protected String mBaseUrl;
    protected String mDomain;

    public RequestUrl(Map<String, String> map) {
        String str = null;
        String str2 = map != null ? map.get("policy") : null;
        String str3 = map != null ? map.get("serverUrlSuffix") : null;
        str = map != null ? map.get("serverUrl") : str;
        this.mDomain = getDomain(str2);
        if (!TextUtils.isEmpty(str)) {
            this.mBaseUrl = str;
        } else {
            this.mBaseUrl = getBaseUrl(this.mDomain, str3, getProductionUrlSuffix(str2));
        }
    }

    public static String getBaseUrl(String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "";
        }
        StringBuilder sb = new StringBuilder(HttpHost.DEFAULT_SCHEME_NAME);
        if (TextUtils.isEmpty(str2)) {
            str2 = str3;
        } else if (!str3.equals(str2)) {
            str2 = '-' + str2;
        }
        if (str3.equals(str2)) {
            str2 = '.' + str2;
            sb.append('s');
        }
        sb.append("://");
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public String getDomain() {
        return this.mDomain;
    }

    protected abstract String getDomain(String str);

    protected abstract String getProductionUrlSuffix(String str);
}
