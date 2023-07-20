package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

@Immutable
/* loaded from: classes.dex */
abstract class AuthenticationStrategyImpl implements AuthenticationStrategy {
    private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList("Negotiate", "Kerberos", "NTLM", "Digest", "Basic"));
    private final int challengeCode;
    private final String headerName;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthenticationStrategyImpl(int i, String str) {
        this.challengeCode = i;
        this.headerName = str;
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public void authFailed(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        Args.notNull(httpHost, "Host");
        Args.notNull(httpContext, "HTTP context");
        AuthCache authCache = HttpClientContext.adapt(httpContext).getAuthCache();
        if (authCache != null) {
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Clearing cached auth scheme for " + httpHost);
            }
            authCache.remove(httpHost);
        }
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public void authSucceeded(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        Args.notNull(httpHost, "Host");
        Args.notNull(authScheme, "Auth scheme");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        if (isCachable(authScheme)) {
            AuthCache authCache = adapt.getAuthCache();
            if (authCache == null) {
                authCache = new BasicAuthCache();
                adapt.setAuthCache(authCache);
            }
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Caching '" + authScheme.getSchemeName() + "' auth scheme for " + httpHost);
            }
            authCache.put(httpHost, authScheme);
        }
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public Map<String, Header> getChallenges(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        CharArrayBuffer charArrayBuffer;
        int i;
        Args.notNull(httpResponse, "HTTP response");
        Header[] headers = httpResponse.getHeaders(this.headerName);
        HashMap hashMap = new HashMap(headers.length);
        for (Header header : headers) {
            if (header instanceof FormattedHeader) {
                FormattedHeader formattedHeader = (FormattedHeader) header;
                charArrayBuffer = formattedHeader.getBuffer();
                i = formattedHeader.getValuePos();
            } else {
                String value = header.getValue();
                if (value == null) {
                    throw new MalformedChallengeException("Header value is null");
                }
                charArrayBuffer = new CharArrayBuffer(value.length());
                charArrayBuffer.append(value);
                i = 0;
            }
            while (i < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(i))) {
                i++;
            }
            int i2 = i;
            while (i2 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(i2))) {
                i2++;
            }
            hashMap.put(charArrayBuffer.substring(i, i2).toLowerCase(Locale.ROOT), header);
        }
        return hashMap;
    }

    abstract Collection<String> getPreferredAuthSchemes(RequestConfig requestConfig);

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        return httpResponse.getStatusLine().getStatusCode() == this.challengeCode;
    }

    protected boolean isCachable(AuthScheme authScheme) {
        if (authScheme == null || !authScheme.isComplete()) {
            return false;
        }
        String schemeName = authScheme.getSchemeName();
        return schemeName.equalsIgnoreCase("Basic") || schemeName.equalsIgnoreCase("Digest");
    }

    @Override // cz.msebera.android.httpclient.client.AuthenticationStrategy
    public Queue<AuthOption> select(Map<String, Header> map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        HttpClientAndroidLog httpClientAndroidLog;
        String str;
        Args.notNull(map, "Map of auth challenges");
        Args.notNull(httpHost, "Host");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        LinkedList linkedList = new LinkedList();
        Lookup<AuthSchemeProvider> authSchemeRegistry = adapt.getAuthSchemeRegistry();
        if (authSchemeRegistry == null) {
            httpClientAndroidLog = this.log;
            str = "Auth scheme registry not set in the context";
        } else {
            CredentialsProvider credentialsProvider = adapt.getCredentialsProvider();
            if (credentialsProvider != null) {
                Collection<String> preferredAuthSchemes = getPreferredAuthSchemes(adapt.getRequestConfig());
                if (preferredAuthSchemes == null) {
                    preferredAuthSchemes = DEFAULT_SCHEME_PRIORITY;
                }
                if (this.log.isDebugEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                    httpClientAndroidLog2.debug("Authentication schemes in the order of preference: " + preferredAuthSchemes);
                }
                for (String str2 : preferredAuthSchemes) {
                    Header header = map.get(str2.toLowerCase(Locale.ROOT));
                    if (header != null) {
                        AuthSchemeProvider mo34lookup = authSchemeRegistry.mo34lookup(str2);
                        if (mo34lookup != null) {
                            AuthScheme create = mo34lookup.create(httpContext);
                            create.processChallenge(header);
                            Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort(), create.getRealm(), create.getSchemeName()));
                            if (credentials != null) {
                                linkedList.add(new AuthOption(create, credentials));
                            }
                        } else if (this.log.isWarnEnabled()) {
                            HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                            httpClientAndroidLog3.warn("Authentication scheme " + str2 + " not supported");
                        }
                    } else if (this.log.isDebugEnabled()) {
                        HttpClientAndroidLog httpClientAndroidLog4 = this.log;
                        httpClientAndroidLog4.debug("Challenge for " + str2 + " authentication scheme not available");
                    }
                }
                return linkedList;
            }
            httpClientAndroidLog = this.log;
            str = "Credentials provider not set in the context";
        }
        httpClientAndroidLog.debug(str);
        return linkedList;
    }
}
