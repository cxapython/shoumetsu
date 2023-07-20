package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.InvalidCredentialsException;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.auth.NTCredentials;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

@NotThreadSafe
/* loaded from: classes.dex */
public class NTLMScheme extends AuthSchemeBase {
    private String challenge;
    private final NTLMEngine engine;
    private State state;

    /* loaded from: classes.dex */
    enum State {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        MSG_TYPE1_GENERATED,
        MSG_TYPE2_RECEVIED,
        MSG_TYPE3_GENERATED,
        FAILED
    }

    public NTLMScheme() {
        this(new NTLMEngineImpl());
    }

    public NTLMScheme(NTLMEngine nTLMEngine) {
        Args.notNull(nTLMEngine, "NTLM engine");
        this.engine = nTLMEngine;
        this.state = State.UNINITIATED;
        this.challenge = null;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) {
        String generateType3Msg;
        State state;
        try {
            NTCredentials nTCredentials = (NTCredentials) credentials;
            if (this.state == State.FAILED) {
                throw new AuthenticationException("NTLM authentication failed");
            }
            if (this.state == State.CHALLENGE_RECEIVED) {
                generateType3Msg = this.engine.generateType1Msg(nTCredentials.getDomain(), nTCredentials.getWorkstation());
                state = State.MSG_TYPE1_GENERATED;
            } else if (this.state != State.MSG_TYPE2_RECEVIED) {
                throw new AuthenticationException("Unexpected state: " + this.state);
            } else {
                generateType3Msg = this.engine.generateType3Msg(nTCredentials.getUserName(), nTCredentials.getPassword(), nTCredentials.getDomain(), nTCredentials.getWorkstation(), this.challenge);
                state = State.MSG_TYPE3_GENERATED;
            }
            this.state = state;
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
            charArrayBuffer.append(isProxy() ? "Proxy-Authorization" : "Authorization");
            charArrayBuffer.append(": NTLM ");
            charArrayBuffer.append(generateType3Msg);
            return new BufferedHeader(charArrayBuffer);
        } catch (ClassCastException unused) {
            throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + credentials.getClass().getName());
        }
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getParameter(String str) {
        return null;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getRealm() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getSchemeName() {
        return "ntlm";
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isComplete() {
        return this.state == State.MSG_TYPE3_GENERATED || this.state == State.FAILED;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isConnectionBased() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    protected void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) {
        State state;
        this.challenge = charArrayBuffer.substringTrimmed(i, i2);
        if (this.challenge.isEmpty()) {
            state = this.state == State.UNINITIATED ? State.CHALLENGE_RECEIVED : State.FAILED;
        } else if (this.state.compareTo(State.MSG_TYPE1_GENERATED) < 0) {
            this.state = State.FAILED;
            throw new MalformedChallengeException("Out of sequence NTLM response message");
        } else if (this.state != State.MSG_TYPE1_GENERATED) {
            return;
        } else {
            state = State.MSG_TYPE2_RECEVIED;
        }
        this.state = state;
    }
}
