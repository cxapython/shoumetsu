package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.params.AuthPNames;
import cz.msebera.android.httpclient.message.BasicHeaderValueParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.CharsetUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@NotThreadSafe
/* loaded from: classes.dex */
public abstract class RFC2617Scheme extends AuthSchemeBase implements Serializable {
    private static final long serialVersionUID = -2845454858205884623L;
    private transient Charset credentialsCharset;
    private final Map<String, String> params;

    public RFC2617Scheme() {
        this(Consts.ASCII);
    }

    @Deprecated
    public RFC2617Scheme(ChallengeState challengeState) {
        super(challengeState);
        this.params = new HashMap();
        this.credentialsCharset = Consts.ASCII;
    }

    public RFC2617Scheme(Charset charset) {
        this.params = new HashMap();
        this.credentialsCharset = charset == null ? Consts.ASCII : charset;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.credentialsCharset = CharsetUtils.get(objectInputStream.readUTF());
        if (this.credentialsCharset == null) {
            this.credentialsCharset = Consts.ASCII;
        }
    }

    private void readObjectNoData() {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeUTF(this.credentialsCharset.name());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCredentialsCharset(HttpRequest httpRequest) {
        String str = (String) httpRequest.getParams().getParameter(AuthPNames.CREDENTIAL_CHARSET);
        return str == null ? getCredentialsCharset().name() : str;
    }

    public Charset getCredentialsCharset() {
        Charset charset = this.credentialsCharset;
        return charset != null ? charset : Consts.ASCII;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getParameter(String str) {
        if (str == null) {
            return null;
        }
        return this.params.get(str.toLowerCase(Locale.ROOT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String> getParameters() {
        return this.params;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getRealm() {
        return getParameter("realm");
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    protected void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) {
        HeaderElement[] parseElements = BasicHeaderValueParser.INSTANCE.parseElements(charArrayBuffer, new ParserCursor(i, charArrayBuffer.length()));
        this.params.clear();
        for (HeaderElement headerElement : parseElements) {
            this.params.put(headerElement.getName().toLowerCase(Locale.ROOT), headerElement.getValue());
        }
    }
}
