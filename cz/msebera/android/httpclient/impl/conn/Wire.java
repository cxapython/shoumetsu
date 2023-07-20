package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.message.TokenParser;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Immutable
/* loaded from: classes.dex */
public class Wire {
    private final String id;
    public HttpClientAndroidLog log;

    public Wire(HttpClientAndroidLog httpClientAndroidLog) {
        this(httpClientAndroidLog, "");
    }

    public Wire(HttpClientAndroidLog httpClientAndroidLog, String str) {
        this.log = httpClientAndroidLog;
        this.id = str;
    }

    private void wire(String str, InputStream inputStream) {
        String str2;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            if (read == 13) {
                str2 = "[\\r]";
            } else if (read == 10) {
                sb.append("[\\n]\"");
                sb.insert(0, "\"");
                sb.insert(0, str);
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug(this.id + " " + sb.toString());
                sb.setLength(0);
            } else if (read < 32 || read > 127) {
                sb.append("[0x");
                sb.append(Integer.toHexString(read));
                str2 = "]";
            } else {
                sb.append((char) read);
            }
            sb.append(str2);
        }
        if (sb.length() > 0) {
            sb.append(TokenParser.DQUOTE);
            sb.insert(0, TokenParser.DQUOTE);
            sb.insert(0, str);
            HttpClientAndroidLog httpClientAndroidLog2 = this.log;
            httpClientAndroidLog2.debug(this.id + " " + sb.toString());
        }
    }

    public boolean enabled() {
        return this.log.isDebugEnabled();
    }

    public void input(int i) {
        input(new byte[]{(byte) i});
    }

    public void input(InputStream inputStream) {
        Args.notNull(inputStream, "Input");
        wire("<< ", inputStream);
    }

    public void input(String str) {
        Args.notNull(str, "Input");
        input(str.getBytes());
    }

    public void input(byte[] bArr) {
        Args.notNull(bArr, "Input");
        wire("<< ", new ByteArrayInputStream(bArr));
    }

    public void input(byte[] bArr, int i, int i2) {
        Args.notNull(bArr, "Input");
        wire("<< ", new ByteArrayInputStream(bArr, i, i2));
    }

    public void output(int i) {
        output(new byte[]{(byte) i});
    }

    public void output(InputStream inputStream) {
        Args.notNull(inputStream, "Output");
        wire(">> ", inputStream);
    }

    public void output(String str) {
        Args.notNull(str, "Output");
        output(str.getBytes());
    }

    public void output(byte[] bArr) {
        Args.notNull(bArr, "Output");
        wire(">> ", new ByteArrayInputStream(bArr));
    }

    public void output(byte[] bArr, int i, int i2) {
        Args.notNull(bArr, "Output");
        wire(">> ", new ByteArrayInputStream(bArr, i, i2));
    }
}
