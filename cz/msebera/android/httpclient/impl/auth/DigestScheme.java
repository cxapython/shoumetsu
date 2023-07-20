package cz.msebera.android.httpclient.impl.auth;

import com.adjust.sdk.Constants;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.james.mime4j.field.ContentTypeField;

@NotThreadSafe
/* loaded from: classes.dex */
public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private static final long serialVersionUID = 3883908186234566916L;
    private String a1;
    private String a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public DigestScheme() {
        this(Consts.ASCII);
    }

    @Deprecated
    public DigestScheme(ChallengeState challengeState) {
        super(challengeState);
    }

    public DigestScheme(Charset charset) {
        super(charset);
        this.complete = false;
    }

    public static String createCnonce() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return encode(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Header createDigestHeader(Credentials credentials, HttpRequest httpRequest) {
        char c;
        MessageDigest messageDigest;
        String str;
        StringBuilder sb;
        ArrayList arrayList;
        int i;
        String parameter = getParameter("uri");
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("opaque");
        String parameter5 = getParameter("methodname");
        String parameter6 = getParameter("algorithm");
        if (parameter6 == null) {
            parameter6 = Constants.MD5;
        }
        HashSet hashSet = new HashSet(8);
        String parameter7 = getParameter("qop");
        if (parameter7 != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(parameter7, ",");
            while (stringTokenizer.hasMoreTokens()) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.ROOT));
            }
            c = (!(httpRequest instanceof HttpEntityEnclosingRequest) || !hashSet.contains("auth-int")) ? hashSet.contains("auth") ? (char) 2 : (char) 65535 : (char) 1;
        } else {
            c = 0;
        }
        if (c == 65535) {
            throw new AuthenticationException("None of the qop methods is supported: " + parameter7);
        }
        String parameter8 = getParameter(ContentTypeField.PARAM_CHARSET);
        if (parameter8 == null) {
            parameter8 = "ISO-8859-1";
        }
        String str2 = parameter6.equalsIgnoreCase("MD5-sess") ? Constants.MD5 : parameter6;
        try {
            MessageDigest createMessageDigest = createMessageDigest(str2);
            String name = credentials.getUserPrincipal().getName();
            String password = credentials.getPassword();
            if (parameter3.equals(this.lastNonce)) {
                this.nounceCount++;
            } else {
                this.nounceCount = 1L;
                this.cnonce = null;
                this.lastNonce = parameter3;
            }
            StringBuilder sb2 = new StringBuilder(256);
            Formatter formatter = new Formatter(sb2, Locale.US);
            char c2 = c;
            formatter.format("%08x", Long.valueOf(this.nounceCount));
            formatter.close();
            String sb3 = sb2.toString();
            if (this.cnonce == null) {
                this.cnonce = createCnonce();
            }
            this.a1 = null;
            this.a2 = null;
            if (parameter6.equalsIgnoreCase("MD5-sess")) {
                sb2.setLength(0);
                sb2.append(name);
                sb2.append(':');
                sb2.append(parameter2);
                sb2.append(':');
                sb2.append(password);
                String encode = encode(createMessageDigest.digest(EncodingUtils.getBytes(sb2.toString(), parameter8)));
                sb2.setLength(0);
                sb2.append(encode);
                sb2.append(':');
                sb2.append(parameter3);
                sb2.append(':');
                sb2.append(this.cnonce);
                this.a1 = sb2.toString();
                messageDigest = createMessageDigest;
            } else {
                messageDigest = createMessageDigest;
                sb2.setLength(0);
                sb2.append(name);
                sb2.append(':');
                sb2.append(parameter2);
                sb2.append(':');
                sb2.append(password);
                this.a1 = sb2.toString();
            }
            String encode2 = encode(messageDigest.digest(EncodingUtils.getBytes(this.a1, parameter8)));
            if (c2 == 2) {
                sb = new StringBuilder();
                str = parameter5;
            } else {
                str = parameter5;
                if (c2 == 1) {
                    HttpEntity entity = httpRequest instanceof HttpEntityEnclosingRequest ? ((HttpEntityEnclosingRequest) httpRequest).getEntity() : null;
                    if (entity != null && !entity.isRepeatable()) {
                        if (!hashSet.contains("auth")) {
                            throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                        }
                        this.a2 = str + ':' + parameter;
                        c2 = 2;
                        String encode3 = encode(messageDigest.digest(EncodingUtils.getBytes(this.a2, parameter8)));
                        if (c2 == 0) {
                        }
                        sb2.append(':');
                        sb2.append(encode3);
                        String encode4 = encode(messageDigest.digest(EncodingUtils.getAsciiBytes(sb2.toString())));
                        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
                        charArrayBuffer.append(isProxy() ? "Proxy-Authorization" : "Authorization");
                        charArrayBuffer.append(": Digest ");
                        arrayList = new ArrayList(20);
                        arrayList.add(new BasicNameValuePair("username", name));
                        arrayList.add(new BasicNameValuePair("realm", parameter2));
                        arrayList.add(new BasicNameValuePair("nonce", parameter3));
                        arrayList.add(new BasicNameValuePair("uri", parameter));
                        arrayList.add(new BasicNameValuePair("response", encode4));
                        if (c2 != 0) {
                        }
                        arrayList.add(new BasicNameValuePair("algorithm", parameter6));
                        if (parameter4 != null) {
                        }
                        while (i < arrayList.size()) {
                        }
                        return new BufferedHeader(charArrayBuffer);
                    }
                    HttpEntityDigester httpEntityDigester = new HttpEntityDigester(messageDigest);
                    if (entity != null) {
                        try {
                            entity.writeTo(httpEntityDigester);
                        } catch (IOException e) {
                            throw new AuthenticationException("I/O error reading entity content", e);
                        }
                    }
                    httpEntityDigester.close();
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(':');
                    sb.append(parameter);
                    sb.append(':');
                    sb.append(encode(httpEntityDigester.getDigest()));
                    this.a2 = sb.toString();
                    String encode32 = encode(messageDigest.digest(EncodingUtils.getBytes(this.a2, parameter8)));
                    if (c2 == 0) {
                        sb2.setLength(0);
                        sb2.append(encode2);
                        sb2.append(':');
                        sb2.append(parameter3);
                    } else {
                        sb2.setLength(0);
                        sb2.append(encode2);
                        sb2.append(':');
                        sb2.append(parameter3);
                        sb2.append(':');
                        sb2.append(sb3);
                        sb2.append(':');
                        sb2.append(this.cnonce);
                        sb2.append(':');
                        sb2.append(c2 == 1 ? "auth-int" : "auth");
                    }
                    sb2.append(':');
                    sb2.append(encode32);
                    String encode42 = encode(messageDigest.digest(EncodingUtils.getAsciiBytes(sb2.toString())));
                    CharArrayBuffer charArrayBuffer2 = new CharArrayBuffer(128);
                    charArrayBuffer2.append(isProxy() ? "Proxy-Authorization" : "Authorization");
                    charArrayBuffer2.append(": Digest ");
                    arrayList = new ArrayList(20);
                    arrayList.add(new BasicNameValuePair("username", name));
                    arrayList.add(new BasicNameValuePair("realm", parameter2));
                    arrayList.add(new BasicNameValuePair("nonce", parameter3));
                    arrayList.add(new BasicNameValuePair("uri", parameter));
                    arrayList.add(new BasicNameValuePair("response", encode42));
                    if (c2 != 0) {
                        arrayList.add(new BasicNameValuePair("qop", c2 == 1 ? "auth-int" : "auth"));
                        arrayList.add(new BasicNameValuePair("nc", sb3));
                        arrayList.add(new BasicNameValuePair("cnonce", this.cnonce));
                    }
                    arrayList.add(new BasicNameValuePair("algorithm", parameter6));
                    if (parameter4 != null) {
                        arrayList.add(new BasicNameValuePair("opaque", parameter4));
                    }
                    for (i = 0; i < arrayList.size(); i++) {
                        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) arrayList.get(i);
                        if (i > 0) {
                            charArrayBuffer2.append(", ");
                        }
                        String name2 = basicNameValuePair.getName();
                        BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(charArrayBuffer2, basicNameValuePair, !("nc".equals(name2) || "qop".equals(name2) || "algorithm".equals(name2)));
                    }
                    return new BufferedHeader(charArrayBuffer2);
                }
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append(':');
            sb.append(parameter);
            this.a2 = sb.toString();
            String encode322 = encode(messageDigest.digest(EncodingUtils.getBytes(this.a2, parameter8)));
            if (c2 == 0) {
            }
            sb2.append(':');
            sb2.append(encode322);
            String encode422 = encode(messageDigest.digest(EncodingUtils.getAsciiBytes(sb2.toString())));
            CharArrayBuffer charArrayBuffer22 = new CharArrayBuffer(128);
            charArrayBuffer22.append(isProxy() ? "Proxy-Authorization" : "Authorization");
            charArrayBuffer22.append(": Digest ");
            arrayList = new ArrayList(20);
            arrayList.add(new BasicNameValuePair("username", name));
            arrayList.add(new BasicNameValuePair("realm", parameter2));
            arrayList.add(new BasicNameValuePair("nonce", parameter3));
            arrayList.add(new BasicNameValuePair("uri", parameter));
            arrayList.add(new BasicNameValuePair("response", encode422));
            if (c2 != 0) {
            }
            arrayList.add(new BasicNameValuePair("algorithm", parameter6));
            if (parameter4 != null) {
            }
            while (i < arrayList.size()) {
            }
            return new BufferedHeader(charArrayBuffer22);
        } catch (UnsupportedDigestAlgorithmException unused) {
            throw new AuthenticationException("Unsuppported digest algorithm: " + str2);
        }
    }

    private static MessageDigest createMessageDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + str);
        }
    }

    static String encode(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            char[] cArr2 = HEXADECIMAL;
            cArr[i2] = cArr2[(bArr[i] & 240) >> 4];
            cArr[i2 + 1] = cArr2[bArr[i] & 15];
        }
        return new String(cArr);
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) {
        return authenticate(credentials, httpRequest, new BasicHttpContext());
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httpRequest, "HTTP request");
        if (getParameter("realm") != null) {
            if (getParameter("nonce") == null) {
                throw new AuthenticationException("missing nonce in challenge");
            }
            getParameters().put("methodname", httpRequest.getRequestLine().getMethod());
            getParameters().put("uri", httpRequest.getRequestLine().getUri());
            if (getParameter(ContentTypeField.PARAM_CHARSET) == null) {
                getParameters().put(ContentTypeField.PARAM_CHARSET, getCredentialsCharset(httpRequest));
            }
            return createDigestHeader(credentials, httpRequest);
        }
        throw new AuthenticationException("missing realm in challenge");
    }

    String getA1() {
        return this.a1;
    }

    String getA2() {
        return this.a2;
    }

    String getCnonce() {
        return this.cnonce;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getSchemeName() {
        return "digest";
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    public void overrideParamter(String str, String str2) {
        getParameters().put(str, str2);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.AuthScheme
    public void processChallenge(Header header) {
        super.processChallenge(header);
        this.complete = true;
        if (!getParameters().isEmpty()) {
            return;
        }
        throw new MalformedChallengeException("Authentication challenge is empty");
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    public String toString() {
        return "DIGEST [complete=" + this.complete + ", nonce=" + this.lastNonce + ", nc=" + this.nounceCount + "]";
    }
}
