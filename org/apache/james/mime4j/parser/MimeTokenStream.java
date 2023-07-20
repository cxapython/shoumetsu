package org.apache.james.mime4j.parser;

import com.google.android.gms.nearby.connection.Connections;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import org.apache.james.mime4j.codec.Base64InputStream;
import org.apache.james.mime4j.codec.QuotedPrintableInputStream;
import org.apache.james.mime4j.descriptor.BodyDescriptor;
import org.apache.james.mime4j.io.BufferedLineReaderInputStream;
import org.apache.james.mime4j.io.LineNumberInputStream;
import org.apache.james.mime4j.util.CharsetUtil;
import org.apache.james.mime4j.util.MimeUtil;

/* loaded from: classes.dex */
public class MimeTokenStream implements EntityStates, RecursionMode {
    private final MimeEntityConfig config;
    private EntityStateMachine currentStateMachine;
    private final LinkedList<EntityStateMachine> entities;
    private BufferedLineReaderInputStream inbuffer;
    private int recursionMode;
    private int state;

    public MimeTokenStream() {
        this(new MimeEntityConfig());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MimeTokenStream(MimeEntityConfig mimeEntityConfig) {
        this.entities = new LinkedList<>();
        this.state = -1;
        this.recursionMode = 0;
        this.config = mimeEntityConfig;
    }

    public static final MimeTokenStream createMaximalDescriptorStream() {
        MimeEntityConfig mimeEntityConfig = new MimeEntityConfig();
        mimeEntityConfig.setMaximalBodyDescriptor(true);
        return new MimeTokenStream(mimeEntityConfig);
    }

    public static final MimeTokenStream createStrictValidationStream() {
        MimeEntityConfig mimeEntityConfig = new MimeEntityConfig();
        mimeEntityConfig.setStrictParsing(true);
        return new MimeTokenStream(mimeEntityConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [org.apache.james.mime4j.io.LineNumberSource] */
    /* JADX WARN: Type inference failed for: r1v2 */
    private void doParse(InputStream inputStream, String str) {
        ?? r1;
        EntityStateMachine entityStateMachine;
        this.entities.clear();
        if (this.config.isCountLineNumbers()) {
            inputStream = new LineNumberInputStream(inputStream);
            r1 = inputStream;
        } else {
            r1 = 0;
        }
        this.inbuffer = new BufferedLineReaderInputStream(inputStream, Connections.MAX_RELIABLE_MESSAGE_LEN, this.config.getMaxLineLen());
        switch (this.recursionMode) {
            case 0:
            case 1:
            case 3:
                MimeEntity mimeEntity = new MimeEntity(r1, this.inbuffer, null, 0, 1, this.config);
                mimeEntity.setRecursionMode(this.recursionMode);
                entityStateMachine = mimeEntity;
                if (str != null) {
                    mimeEntity.skipHeader(str);
                    entityStateMachine = mimeEntity;
                    break;
                }
                break;
            case 2:
                entityStateMachine = new RawEntity(this.inbuffer);
                break;
            default:
                this.entities.add(this.currentStateMachine);
                this.state = this.currentStateMachine.getState();
        }
        this.currentStateMachine = entityStateMachine;
        this.entities.add(this.currentStateMachine);
        this.state = this.currentStateMachine.getState();
    }

    public static final String stateToString(int i) {
        return AbstractEntity.stateToString(i);
    }

    public BodyDescriptor getBodyDescriptor() {
        return this.currentStateMachine.getBodyDescriptor();
    }

    public InputStream getDecodedInputStream() {
        String transferEncoding = getBodyDescriptor().getTransferEncoding();
        InputStream contentStream = this.currentStateMachine.getContentStream();
        return MimeUtil.isBase64Encoding(transferEncoding) ? new Base64InputStream(contentStream) : MimeUtil.isQuotedPrintableEncoded(transferEncoding) ? new QuotedPrintableInputStream(contentStream) : contentStream;
    }

    public Field getField() {
        return this.currentStateMachine.getField();
    }

    public InputStream getInputStream() {
        return this.currentStateMachine.getContentStream();
    }

    public Reader getReader() {
        String charset = getBodyDescriptor().getCharset();
        return new InputStreamReader(getDecodedInputStream(), (charset == null || "".equals(charset)) ? CharsetUtil.US_ASCII : Charset.forName(charset));
    }

    public int getRecursionMode() {
        return this.recursionMode;
    }

    public int getState() {
        return this.state;
    }

    public boolean isRaw() {
        return this.recursionMode == 2;
    }

    public int next() {
        if (this.state == -1 || this.currentStateMachine == null) {
            throw new IllegalStateException("No more tokens are available.");
        }
        while (true) {
            EntityStateMachine entityStateMachine = this.currentStateMachine;
            if (entityStateMachine == null) {
                this.state = -1;
                return this.state;
            }
            EntityStateMachine advance = entityStateMachine.advance();
            if (advance != null) {
                this.entities.add(advance);
                this.currentStateMachine = advance;
            }
            this.state = this.currentStateMachine.getState();
            int i = this.state;
            if (i != -1) {
                return i;
            }
            this.entities.removeLast();
            if (this.entities.isEmpty()) {
                this.currentStateMachine = null;
            } else {
                this.currentStateMachine = this.entities.getLast();
                this.currentStateMachine.setRecursionMode(this.recursionMode);
            }
        }
    }

    public void parse(InputStream inputStream) {
        doParse(inputStream, null);
    }

    public void parseHeadless(InputStream inputStream, String str) {
        if (str != null) {
            doParse(inputStream, str);
            return;
        }
        throw new IllegalArgumentException("Content type may not be null");
    }

    public void setRecursionMode(int i) {
        this.recursionMode = i;
        EntityStateMachine entityStateMachine = this.currentStateMachine;
        if (entityStateMachine != null) {
            entityStateMachine.setRecursionMode(i);
        }
    }

    public void stop() {
        this.inbuffer.truncate();
    }
}
