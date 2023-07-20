package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.conn.HttpRoutedConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

@Immutable
@Deprecated
/* loaded from: classes.dex */
public class RequestProxyAuthentication extends RequestAuthenticationBase {
    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        HttpClientAndroidLog httpClientAndroidLog;
        String str;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        if (httpRequest.containsHeader("Proxy-Authorization")) {
            return;
        }
        HttpRoutedConnection httpRoutedConnection = (HttpRoutedConnection) httpContext.getAttribute("http.connection");
        if (httpRoutedConnection == null) {
            httpClientAndroidLog = this.log;
            str = "HTTP connection not set in the context";
        } else if (httpRoutedConnection.getRoute().isTunnelled()) {
            return;
        } else {
            AuthState authState = (AuthState) httpContext.getAttribute("http.auth.proxy-scope");
            if (authState != null) {
                if (this.log.isDebugEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                    httpClientAndroidLog2.debug("Proxy auth state: " + authState.getState());
                }
                process(authState, httpRequest, httpContext);
                return;
            }
            httpClientAndroidLog = this.log;
            str = "Proxy auth state not set in the context";
        }
        httpClientAndroidLog.debug(str);
    }
}
