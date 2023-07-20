package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@NotThreadSafe
/* loaded from: classes.dex */
public class URIBuilder {
    private Charset charset;
    private String encodedAuthority;
    private String encodedFragment;
    private String encodedPath;
    private String encodedQuery;
    private String encodedSchemeSpecificPart;
    private String encodedUserInfo;
    private String fragment;
    private String host;
    private String path;
    private int port;
    private String query;
    private List<NameValuePair> queryParams;
    private String scheme;
    private String userInfo;

    public URIBuilder() {
        this.port = -1;
    }

    public URIBuilder(String str) {
        digestURI(new URI(str));
    }

    public URIBuilder(URI uri) {
        digestURI(uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String buildString() {
        String str;
        String encodePath;
        String encodeUric;
        StringBuilder sb = new StringBuilder();
        String str2 = this.scheme;
        if (str2 != null) {
            sb.append(str2);
            sb.append(':');
        }
        String str3 = this.encodedSchemeSpecificPart;
        if (str3 == null) {
            if (this.encodedAuthority != null) {
                sb.append("//");
                sb.append(this.encodedAuthority);
            } else if (this.host != null) {
                sb.append("//");
                String str4 = this.encodedUserInfo;
                if (str4 == null) {
                    String str5 = this.userInfo;
                    if (str5 != null) {
                        str4 = encodeUserInfo(str5);
                    }
                    if (!InetAddressUtils.isIPv6Address(this.host)) {
                        sb.append("[");
                        sb.append(this.host);
                        str = "]";
                    } else {
                        str = this.host;
                    }
                    sb.append(str);
                    if (this.port >= 0) {
                        sb.append(":");
                        sb.append(this.port);
                    }
                }
                sb.append(str4);
                sb.append("@");
                if (!InetAddressUtils.isIPv6Address(this.host)) {
                }
                sb.append(str);
                if (this.port >= 0) {
                }
            }
            String str6 = this.encodedPath;
            if (str6 != null) {
                encodePath = normalizePath(str6);
            } else {
                String str7 = this.path;
                if (str7 != null) {
                    encodePath = encodePath(normalizePath(str7));
                }
                if (this.encodedQuery == null) {
                    sb.append("?");
                    str3 = this.encodedQuery;
                } else if (this.queryParams == null) {
                    if (this.query != null) {
                        sb.append("?");
                        str3 = encodeUric(this.query);
                    }
                    if (this.encodedFragment != null) {
                        if (this.fragment != null) {
                            sb.append("#");
                            encodeUric = encodeUric(this.fragment);
                        }
                        return sb.toString();
                    }
                    sb.append("#");
                    encodeUric = this.encodedFragment;
                    sb.append(encodeUric);
                    return sb.toString();
                } else {
                    sb.append("?");
                    str3 = encodeUrlForm(this.queryParams);
                }
            }
            sb.append(encodePath);
            if (this.encodedQuery == null) {
            }
        }
        sb.append(str3);
        if (this.encodedFragment != null) {
        }
        sb.append(encodeUric);
        return sb.toString();
    }

    private void digestURI(URI uri) {
        this.scheme = uri.getScheme();
        this.encodedSchemeSpecificPart = uri.getRawSchemeSpecificPart();
        this.encodedAuthority = uri.getRawAuthority();
        this.host = uri.getHost();
        this.port = uri.getPort();
        this.encodedUserInfo = uri.getRawUserInfo();
        this.userInfo = uri.getUserInfo();
        this.encodedPath = uri.getRawPath();
        this.path = uri.getPath();
        this.encodedQuery = uri.getRawQuery();
        String rawQuery = uri.getRawQuery();
        Charset charset = this.charset;
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        this.queryParams = parseQuery(rawQuery, charset);
        this.encodedFragment = uri.getRawFragment();
        this.fragment = uri.getFragment();
    }

    private String encodePath(String str) {
        Charset charset = this.charset;
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return URLEncodedUtils.encPath(str, charset);
    }

    private String encodeUric(String str) {
        Charset charset = this.charset;
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return URLEncodedUtils.encUric(str, charset);
    }

    private String encodeUrlForm(List<NameValuePair> list) {
        Charset charset = this.charset;
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return URLEncodedUtils.format(list, charset);
    }

    private String encodeUserInfo(String str) {
        Charset charset = this.charset;
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return URLEncodedUtils.encUserInfo(str, charset);
    }

    private static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }

    private List<NameValuePair> parseQuery(String str, Charset charset) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return URLEncodedUtils.parse(str, charset);
    }

    public URIBuilder addParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder addParameters(List<NameValuePair> list) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.addAll(list);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URI build() {
        return new URI(buildString());
    }

    public URIBuilder clearParameters() {
        this.queryParams = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getFragment() {
        return this.fragment;
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public List<NameValuePair> getQueryParams() {
        List<NameValuePair> list = this.queryParams;
        return list != null ? new ArrayList(list) : new ArrayList();
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public boolean isAbsolute() {
        return this.scheme != null;
    }

    public boolean isOpaque() {
        return this.path == null;
    }

    public URIBuilder removeQuery() {
        this.queryParams = null;
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public URIBuilder setCustomQuery(String str) {
        this.query = str;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.queryParams = null;
        return this;
    }

    public URIBuilder setFragment(String str) {
        this.fragment = str;
        this.encodedFragment = null;
        return this;
    }

    public URIBuilder setHost(String str) {
        this.host = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        if (!this.queryParams.isEmpty()) {
            Iterator<NameValuePair> it = this.queryParams.iterator();
            while (it.hasNext()) {
                if (it.next().getName().equals(str)) {
                    it.remove();
                }
            }
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameters(List<NameValuePair> list) {
        List<NameValuePair> list2 = this.queryParams;
        if (list2 == null) {
            this.queryParams = new ArrayList();
        } else {
            list2.clear();
        }
        this.queryParams.addAll(list);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameters(NameValuePair... nameValuePairArr) {
        List<NameValuePair> list = this.queryParams;
        if (list == null) {
            this.queryParams = new ArrayList();
        } else {
            list.clear();
        }
        for (NameValuePair nameValuePair : nameValuePairArr) {
            this.queryParams.add(nameValuePair);
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setPath(String str) {
        this.path = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        return this;
    }

    public URIBuilder setPort(int i) {
        if (i < 0) {
            i = -1;
        }
        this.port = i;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    @Deprecated
    public URIBuilder setQuery(String str) {
        Charset charset = this.charset;
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        this.queryParams = parseQuery(str, charset);
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setScheme(String str) {
        this.scheme = str;
        return this;
    }

    public URIBuilder setUserInfo(String str) {
        this.userInfo = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        this.encodedUserInfo = null;
        return this;
    }

    public URIBuilder setUserInfo(String str, String str2) {
        return setUserInfo(str + ':' + str2);
    }

    public String toString() {
        return buildString();
    }
}
