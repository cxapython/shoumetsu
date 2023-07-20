package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpCoreContext;
import java.net.URI;
import java.util.List;

@NotThreadSafe
/* loaded from: classes.dex */
public class HttpClientContext extends HttpCoreContext {
    public static final String AUTHSCHEME_REGISTRY = "http.authscheme-registry";
    public static final String AUTH_CACHE = "http.auth.auth-cache";
    public static final String COOKIESPEC_REGISTRY = "http.cookiespec-registry";
    public static final String COOKIE_ORIGIN = "http.cookie-origin";
    public static final String COOKIE_SPEC = "http.cookie-spec";
    public static final String COOKIE_STORE = "http.cookie-store";
    public static final String CREDS_PROVIDER = "http.auth.credentials-provider";
    public static final String HTTP_ROUTE = "http.route";
    public static final String PROXY_AUTH_STATE = "http.auth.proxy-scope";
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    public static final String REQUEST_CONFIG = "http.request-config";
    public static final String TARGET_AUTH_STATE = "http.auth.target-scope";
    public static final String USER_TOKEN = "http.user-token";

    public HttpClientContext() {
    }

    public HttpClientContext(HttpContext httpContext) {
        super(httpContext);
    }

    public static HttpClientContext adapt(HttpContext httpContext) {
        return httpContext instanceof HttpClientContext ? (HttpClientContext) httpContext : new HttpClientContext(httpContext);
    }

    public static HttpClientContext create() {
        return new HttpClientContext(new BasicHttpContext());
    }

    private <T> Lookup<T> getLookup(String str, Class<T> cls) {
        return (Lookup) getAttribute(str, Lookup.class);
    }

    public AuthCache getAuthCache() {
        return (AuthCache) getAttribute("http.auth.auth-cache", AuthCache.class);
    }

    public Lookup<AuthSchemeProvider> getAuthSchemeRegistry() {
        return getLookup("http.authscheme-registry", AuthSchemeProvider.class);
    }

    public CookieOrigin getCookieOrigin() {
        return (CookieOrigin) getAttribute("http.cookie-origin", CookieOrigin.class);
    }

    public CookieSpec getCookieSpec() {
        return (CookieSpec) getAttribute("http.cookie-spec", CookieSpec.class);
    }

    public Lookup<CookieSpecProvider> getCookieSpecRegistry() {
        return getLookup("http.cookiespec-registry", CookieSpecProvider.class);
    }

    public CookieStore getCookieStore() {
        return (CookieStore) getAttribute("http.cookie-store", CookieStore.class);
    }

    public CredentialsProvider getCredentialsProvider() {
        return (CredentialsProvider) getAttribute("http.auth.credentials-provider", CredentialsProvider.class);
    }

    public RouteInfo getHttpRoute() {
        return (RouteInfo) getAttribute("http.route", HttpRoute.class);
    }

    public AuthState getProxyAuthState() {
        return (AuthState) getAttribute("http.auth.proxy-scope", AuthState.class);
    }

    public List<URI> getRedirectLocations() {
        return (List) getAttribute("http.protocol.redirect-locations", List.class);
    }

    public RequestConfig getRequestConfig() {
        RequestConfig requestConfig = (RequestConfig) getAttribute("http.request-config", RequestConfig.class);
        return requestConfig != null ? requestConfig : RequestConfig.DEFAULT;
    }

    public AuthState getTargetAuthState() {
        return (AuthState) getAttribute("http.auth.target-scope", AuthState.class);
    }

    public Object getUserToken() {
        return getAttribute("http.user-token");
    }

    public <T> T getUserToken(Class<T> cls) {
        return (T) getAttribute("http.user-token", cls);
    }

    public void setAuthCache(AuthCache authCache) {
        setAttribute("http.auth.auth-cache", authCache);
    }

    public void setAuthSchemeRegistry(Lookup<AuthSchemeProvider> lookup) {
        setAttribute("http.authscheme-registry", lookup);
    }

    public void setCookieSpecRegistry(Lookup<CookieSpecProvider> lookup) {
        setAttribute("http.cookiespec-registry", lookup);
    }

    public void setCookieStore(CookieStore cookieStore) {
        setAttribute("http.cookie-store", cookieStore);
    }

    public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        setAttribute("http.auth.credentials-provider", credentialsProvider);
    }

    public void setRequestConfig(RequestConfig requestConfig) {
        setAttribute("http.request-config", requestConfig);
    }

    public void setUserToken(Object obj) {
        setAttribute("http.user-token", obj);
    }
}
