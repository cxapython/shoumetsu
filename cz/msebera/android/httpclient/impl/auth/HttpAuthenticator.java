package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes.dex */
public class HttpAuthenticator {
    public HttpClientAndroidLog log;

    public HttpAuthenticator() {
        this(null);
    }

    public HttpAuthenticator(HttpClientAndroidLog httpClientAndroidLog) {
        this.log = httpClientAndroidLog == null ? new HttpClientAndroidLog(getClass()) : httpClientAndroidLog;
    }

    private Header doAuth(AuthScheme authScheme, Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) {
        return authScheme instanceof ContextAwareAuthScheme ? ((ContextAwareAuthScheme) authScheme).authenticate(credentials, httpRequest, httpContext) : authScheme.authenticate(credentials, httpRequest);
    }

    private void ensureAuthScheme(AuthScheme authScheme) {
        Asserts.notNull(authScheme, "Auth scheme");
    }

    public void generateAuthResponse(HttpRequest httpRequest, AuthState authState, HttpContext httpContext) {
        AuthScheme authScheme = authState.getAuthScheme();
        Credentials credentials = authState.getCredentials();
        int i = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[authState.getState().ordinal()];
        if (i != 1) {
            switch (i) {
                case 4:
                    return;
                case 3:
                    ensureAuthScheme(authScheme);
                    if (authScheme.isConnectionBased()) {
                        return;
                    }
                    break;
            }
        } else {
            Queue<AuthOption> authOptions = authState.getAuthOptions();
            if (authOptions != null) {
                while (!authOptions.isEmpty()) {
                    AuthOption remove = authOptions.remove();
                    AuthScheme authScheme2 = remove.getAuthScheme();
                    Credentials credentials2 = remove.getCredentials();
                    authState.update(authScheme2, credentials2);
                    if (this.log.isDebugEnabled()) {
                        HttpClientAndroidLog httpClientAndroidLog = this.log;
                        httpClientAndroidLog.debug("Generating response to an authentication challenge using " + authScheme2.getSchemeName() + " scheme");
                    }
                    try {
                        httpRequest.addHeader(doAuth(authScheme2, credentials2, httpRequest, httpContext));
                        return;
                    } catch (AuthenticationException e) {
                        if (this.log.isWarnEnabled()) {
                            HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                            httpClientAndroidLog2.warn(authScheme2 + " authentication error: " + e.getMessage());
                        }
                    }
                }
                return;
            }
            ensureAuthScheme(authScheme);
        }
        if (authScheme != null) {
            try {
                httpRequest.addHeader(doAuth(authScheme, credentials, httpRequest, httpContext));
            } catch (AuthenticationException e2) {
                if (!this.log.isErrorEnabled()) {
                    return;
                }
                HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                httpClientAndroidLog3.error(authScheme + " authentication error: " + e2.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0067 A[Catch: MalformedChallengeException -> 0x00da, TryCatch #0 {MalformedChallengeException -> 0x00da, blocks: (B:3:0x0001, B:5:0x0009, B:6:0x0023, B:8:0x002d, B:10:0x0035, B:11:0x0046, B:27:0x00a6, B:29:0x00ac, B:31:0x00b2, B:33:0x00ba, B:34:0x00d0, B:14:0x004b, B:16:0x0051, B:19:0x0067, B:21:0x0079, B:23:0x0089, B:25:0x00a0), top: B:43:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac A[Catch: MalformedChallengeException -> 0x00da, TryCatch #0 {MalformedChallengeException -> 0x00da, blocks: (B:3:0x0001, B:5:0x0009, B:6:0x0023, B:8:0x002d, B:10:0x0035, B:11:0x0046, B:27:0x00a6, B:29:0x00ac, B:31:0x00b2, B:33:0x00ba, B:34:0x00d0, B:14:0x004b, B:16:0x0051, B:19:0x0067, B:21:0x0079, B:23:0x0089, B:25:0x00a0), top: B:43:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleAuthChallenge(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthState authState, HttpContext httpContext) {
        Queue<AuthOption> select;
        try {
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug(httpHost.toHostString() + " requested authentication");
            }
            Map<String, Header> challenges = authenticationStrategy.getChallenges(httpHost, httpResponse, httpContext);
            if (challenges.isEmpty()) {
                this.log.debug("Response contains no authentication challenges");
                return false;
            }
            AuthScheme authScheme = authState.getAuthScheme();
            switch (authState.getState()) {
                case CHALLENGED:
                case HANDSHAKE:
                    if (authScheme == null) {
                        this.log.debug("Auth scheme is null");
                        authenticationStrategy.authFailed(httpHost, null, httpContext);
                        authState.reset();
                        authState.setState(AuthProtocolState.FAILURE);
                        return false;
                    }
                    if (authScheme != null) {
                        Header header = challenges.get(authScheme.getSchemeName().toLowerCase(Locale.ROOT));
                        if (header != null) {
                            this.log.debug("Authorization challenge processed");
                            authScheme.processChallenge(header);
                            if (!authScheme.isComplete()) {
                                authState.setState(AuthProtocolState.HANDSHAKE);
                                return true;
                            }
                            this.log.debug("Authentication failed");
                            authenticationStrategy.authFailed(httpHost, authState.getAuthScheme(), httpContext);
                            authState.reset();
                            authState.setState(AuthProtocolState.FAILURE);
                            return false;
                        }
                        authState.reset();
                    }
                    select = authenticationStrategy.select(challenges, httpHost, httpResponse, httpContext);
                    if (select != null || select.isEmpty()) {
                        return false;
                    }
                    if (this.log.isDebugEnabled()) {
                        HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                        httpClientAndroidLog2.debug("Selected authentication options: " + select);
                    }
                    authState.setState(AuthProtocolState.CHALLENGED);
                    authState.update(select);
                    return true;
                case SUCCESS:
                    authState.reset();
                    select = authenticationStrategy.select(challenges, httpHost, httpResponse, httpContext);
                    if (select != null) {
                        break;
                    }
                    return false;
                case FAILURE:
                    return false;
                case UNCHALLENGED:
                    if (authScheme != null) {
                    }
                    select = authenticationStrategy.select(challenges, httpHost, httpResponse, httpContext);
                    if (select != null) {
                    }
                    return false;
                default:
                    select = authenticationStrategy.select(challenges, httpHost, httpResponse, httpContext);
                    if (select != null) {
                    }
                    return false;
            }
        } catch (MalformedChallengeException e) {
            if (this.log.isWarnEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                httpClientAndroidLog3.warn("Malformed challenge: " + e.getMessage());
            }
            authState.reset();
            return false;
        }
    }

    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthState authState, HttpContext httpContext) {
        if (authenticationStrategy.isAuthenticationRequested(httpHost, httpResponse, httpContext)) {
            this.log.debug("Authentication required");
            if (authState.getState() != AuthProtocolState.SUCCESS) {
                return true;
            }
            authenticationStrategy.authFailed(httpHost, authState.getAuthScheme(), httpContext);
            return true;
        }
        switch (authState.getState()) {
            case CHALLENGED:
            case HANDSHAKE:
                this.log.debug("Authentication succeeded");
                authState.setState(AuthProtocolState.SUCCESS);
                authenticationStrategy.authSucceeded(httpHost, authState.getAuthScheme(), httpContext);
                return false;
            case SUCCESS:
                return false;
            default:
                authState.setState(AuthProtocolState.UNCHALLENGED);
                return false;
        }
    }
}
