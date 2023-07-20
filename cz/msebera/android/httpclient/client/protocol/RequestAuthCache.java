package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

@Immutable
/* loaded from: classes.dex */
public class RequestAuthCache implements HttpRequestInterceptor {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    private void doPreemptiveAuth(HttpHost httpHost, AuthScheme authScheme, AuthState authState, CredentialsProvider credentialsProvider) {
        String schemeName = authScheme.getSchemeName();
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Re-using cached '" + schemeName + "' auth scheme for " + httpHost);
        }
        Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost, AuthScope.ANY_REALM, schemeName));
        if (credentials == null) {
            this.log.debug("No credentials for preemptive authentication");
            return;
        }
        authState.setState("BASIC".equalsIgnoreCase(authScheme.getSchemeName()) ? AuthProtocolState.CHALLENGED : AuthProtocolState.SUCCESS);
        authState.update(authScheme, credentials);
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        AuthScheme authScheme;
        AuthScheme authScheme2;
        HttpClientAndroidLog httpClientAndroidLog;
        String str;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        AuthCache authCache = adapt.getAuthCache();
        if (authCache == null) {
            httpClientAndroidLog = this.log;
            str = "Auth cache not set in the context";
        } else {
            CredentialsProvider credentialsProvider = adapt.getCredentialsProvider();
            if (credentialsProvider == null) {
                httpClientAndroidLog = this.log;
                str = "Credentials provider not set in the context";
            } else {
                RouteInfo httpRoute = adapt.getHttpRoute();
                if (httpRoute == null) {
                    httpClientAndroidLog = this.log;
                    str = "Route info not set in the context";
                } else {
                    HttpHost targetHost = adapt.getTargetHost();
                    if (targetHost != null) {
                        if (targetHost.getPort() < 0) {
                            targetHost = new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName());
                        }
                        AuthState targetAuthState = adapt.getTargetAuthState();
                        if (targetAuthState != null && targetAuthState.getState() == AuthProtocolState.UNCHALLENGED && (authScheme2 = authCache.get(targetHost)) != null) {
                            doPreemptiveAuth(targetHost, authScheme2, targetAuthState, credentialsProvider);
                        }
                        HttpHost proxyHost = httpRoute.getProxyHost();
                        AuthState proxyAuthState = adapt.getProxyAuthState();
                        if (proxyHost == null || proxyAuthState == null || proxyAuthState.getState() != AuthProtocolState.UNCHALLENGED || (authScheme = authCache.get(proxyHost)) == null) {
                            return;
                        }
                        doPreemptiveAuth(proxyHost, authScheme, proxyAuthState, credentialsProvider);
                        return;
                    }
                    httpClientAndroidLog = this.log;
                    str = "Target host not set in the context";
                }
            }
        }
        httpClientAndroidLog.debug(str);
    }
}
