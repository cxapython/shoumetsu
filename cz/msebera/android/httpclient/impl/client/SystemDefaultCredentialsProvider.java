package cz.msebera.android.httpclient.impl.client;

import com.adjust.sdk.Constants;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.NTCredentials;
import cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.util.Args;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
/* loaded from: classes.dex */
public class SystemDefaultCredentialsProvider implements CredentialsProvider {
    private static final Map<String, String> SCHEME_MAP = new ConcurrentHashMap();
    private final BasicCredentialsProvider internal = new BasicCredentialsProvider();

    static {
        SCHEME_MAP.put("Basic".toUpperCase(Locale.ROOT), "Basic");
        SCHEME_MAP.put("Digest".toUpperCase(Locale.ROOT), "Digest");
        SCHEME_MAP.put("NTLM".toUpperCase(Locale.ROOT), "NTLM");
        SCHEME_MAP.put("Negotiate".toUpperCase(Locale.ROOT), "SPNEGO");
        SCHEME_MAP.put("Kerberos".toUpperCase(Locale.ROOT), "Kerberos");
    }

    private static PasswordAuthentication getSystemCreds(AuthScope authScope, Authenticator.RequestorType requestorType) {
        String host = authScope.getHost();
        int port = authScope.getPort();
        HttpHost origin = authScope.getOrigin();
        return Authenticator.requestPasswordAuthentication(host, null, port, origin != null ? origin.getSchemeName() : port == 443 ? Constants.SCHEME : HttpHost.DEFAULT_SCHEME_NAME, null, translateScheme(authScope.getScheme()), null, requestorType);
    }

    private static String translateScheme(String str) {
        if (str == null) {
            return null;
        }
        String str2 = SCHEME_MAP.get(str);
        return str2 != null ? str2 : str;
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public void clear() {
        this.internal.clear();
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public Credentials getCredentials(AuthScope authScope) {
        Args.notNull(authScope, "Auth scope");
        Credentials credentials = this.internal.getCredentials(authScope);
        if (credentials != null) {
            return credentials;
        }
        if (authScope.getHost() != null) {
            PasswordAuthentication systemCreds = getSystemCreds(authScope, Authenticator.RequestorType.SERVER);
            if (systemCreds == null) {
                systemCreds = getSystemCreds(authScope, Authenticator.RequestorType.PROXY);
            }
            if (systemCreds != null) {
                String property = System.getProperty("http.auth.ntlm.domain");
                return property != null ? new NTCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()), null, property) : "NTLM".equalsIgnoreCase(authScope.getScheme()) ? new NTCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()), null, null) : new UsernamePasswordCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()));
            }
        }
        return null;
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public void setCredentials(AuthScope authScope, Credentials credentials) {
        this.internal.setCredentials(authScope, credentials);
    }
}
