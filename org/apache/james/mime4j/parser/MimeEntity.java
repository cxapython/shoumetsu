package org.apache.james.mime4j.parser;

import com.google.android.gms.nearby.connection.Connections;
import java.io.InputStream;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.codec.Base64InputStream;
import org.apache.james.mime4j.codec.QuotedPrintableInputStream;
import org.apache.james.mime4j.descriptor.BodyDescriptor;
import org.apache.james.mime4j.io.BufferedLineReaderInputStream;
import org.apache.james.mime4j.io.LimitedInputStream;
import org.apache.james.mime4j.io.LineNumberSource;
import org.apache.james.mime4j.io.LineReaderInputStream;
import org.apache.james.mime4j.io.LineReaderInputStreamAdaptor;
import org.apache.james.mime4j.io.MimeBoundaryInputStream;
import org.apache.james.mime4j.util.ContentUtil;
import org.apache.james.mime4j.util.MimeUtil;

/* loaded from: classes.dex */
public class MimeEntity extends AbstractEntity {
    private static final int T_IN_BODYPART = -2;
    private static final int T_IN_MESSAGE = -3;
    private LineReaderInputStreamAdaptor dataStream;
    private final BufferedLineReaderInputStream inbuffer;
    private final LineNumberSource lineSource;
    private MimeBoundaryInputStream mimeStream;
    private int recursionMode;
    private boolean skipHeader;
    private byte[] tmpbuf;

    public MimeEntity(LineNumberSource lineNumberSource, BufferedLineReaderInputStream bufferedLineReaderInputStream, BodyDescriptor bodyDescriptor, int i, int i2) {
        this(lineNumberSource, bufferedLineReaderInputStream, bodyDescriptor, i, i2, new MimeEntityConfig());
    }

    public MimeEntity(LineNumberSource lineNumberSource, BufferedLineReaderInputStream bufferedLineReaderInputStream, BodyDescriptor bodyDescriptor, int i, int i2, MimeEntityConfig mimeEntityConfig) {
        super(bodyDescriptor, i, i2, mimeEntityConfig);
        this.lineSource = lineNumberSource;
        this.inbuffer = bufferedLineReaderInputStream;
        this.dataStream = new LineReaderInputStreamAdaptor(bufferedLineReaderInputStream, mimeEntityConfig.getMaxLineLen());
        this.skipHeader = false;
    }

    private void advanceToBoundary() {
        if (!this.dataStream.eof()) {
            if (this.tmpbuf == null) {
                this.tmpbuf = new byte[2048];
            }
            do {
            } while (getLimitedContentStream().read(this.tmpbuf) != -1);
        }
    }

    private void clearMimeStream() {
        this.mimeStream = null;
        this.dataStream = new LineReaderInputStreamAdaptor(this.inbuffer, this.config.getMaxLineLen());
    }

    private void createMimeStream() {
        String boundary = this.body.getBoundary();
        int length = boundary.length() * 2;
        if (length < 4096) {
            length = Connections.MAX_RELIABLE_MESSAGE_LEN;
        }
        try {
            if (this.mimeStream != null) {
                this.mimeStream = new MimeBoundaryInputStream(new BufferedLineReaderInputStream(this.mimeStream, length, this.config.getMaxLineLen()), boundary);
            } else {
                this.inbuffer.ensureCapacity(length);
                this.mimeStream = new MimeBoundaryInputStream(this.inbuffer, boundary);
            }
            this.dataStream = new LineReaderInputStreamAdaptor(this.mimeStream, this.config.getMaxLineLen());
        } catch (IllegalArgumentException e) {
            throw new MimeException(e.getMessage(), e);
        }
    }

    private InputStream getLimitedContentStream() {
        long maxContentLen = this.config.getMaxContentLen();
        return maxContentLen >= 0 ? new LimitedInputStream(this.dataStream, maxContentLen) : this.dataStream;
    }

    private EntityStateMachine nextMessage() {
        InputStream inputStream;
        String transferEncoding = this.body.getTransferEncoding();
        if (MimeUtil.isBase64Encoding(transferEncoding)) {
            this.log.debug("base64 encoded message/rfc822 detected");
            inputStream = new Base64InputStream(this.dataStream);
        } else if (MimeUtil.isQuotedPrintableEncoded(transferEncoding)) {
            this.log.debug("quoted-printable encoded message/rfc822 detected");
            inputStream = new QuotedPrintableInputStream(this.dataStream);
        } else {
            inputStream = this.dataStream;
        }
        if (this.recursionMode == 2) {
            return new RawEntity(inputStream);
        }
        MimeEntity mimeEntity = new MimeEntity(this.lineSource, new BufferedLineReaderInputStream(inputStream, Connections.MAX_RELIABLE_MESSAGE_LEN, this.config.getMaxLineLen()), this.body, 0, 1, this.config);
        mimeEntity.setRecursionMode(this.recursionMode);
        return mimeEntity;
    }

    private EntityStateMachine nextMimeEntity() {
        if (this.recursionMode == 2) {
            return new RawEntity(this.mimeStream);
        }
        MimeEntity mimeEntity = new MimeEntity(this.lineSource, new BufferedLineReaderInputStream(this.mimeStream, Connections.MAX_RELIABLE_MESSAGE_LEN, this.config.getMaxLineLen()), this.body, 10, 11, this.config);
        mimeEntity.setRecursionMode(this.recursionMode);
        return mimeEntity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
        if (r5.skipHeader != false) goto L36;
     */
    @Override // org.apache.james.mime4j.parser.EntityStateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EntityStateMachine advance() {
        int i;
        int i2 = 5;
        switch (this.state) {
            case T_IN_MESSAGE /* -3 */:
            case 7:
            case 12:
                i = this.endState;
                this.state = i;
                return null;
            case -2:
                advanceToBoundary();
                if (this.mimeStream.eof() && !this.mimeStream.isLastPart()) {
                    monitor(Event.MIME_BODY_PREMATURE_END);
                } else if (!this.mimeStream.isLastPart()) {
                    clearMimeStream();
                    createMimeStream();
                    this.state = -2;
                    return nextMimeEntity();
                }
                clearMimeStream();
                i = 9;
                this.state = i;
                return null;
            case -1:
            case 1:
            case 2:
            case 11:
            default:
                if (this.state == this.endState) {
                    i = -1;
                    this.state = i;
                    return null;
                }
                throw new IllegalStateException("Invalid state: " + stateToString(this.state));
            case 0:
                break;
            case 3:
            case 4:
                if (parseField()) {
                    i2 = 4;
                }
                this.state = i2;
                return null;
            case 5:
                String mimeType = this.body.getMimeType();
                i2 = 12;
                if (this.recursionMode != 3) {
                    if (MimeUtil.isMultipart(mimeType)) {
                        this.state = 6;
                        clearMimeStream();
                        return null;
                    } else if (this.recursionMode != 1 && MimeUtil.isMessage(mimeType)) {
                        this.state = T_IN_MESSAGE;
                        return nextMessage();
                    }
                }
                this.state = i2;
                return null;
            case 6:
                if (this.dataStream.isUsed()) {
                    advanceToBoundary();
                    this.state = 7;
                    return null;
                }
                createMimeStream();
                i = 8;
                this.state = i;
                return null;
            case 8:
                advanceToBoundary();
                if (this.mimeStream.isLastPart()) {
                    clearMimeStream();
                    this.state = 7;
                    return null;
                }
                clearMimeStream();
                createMimeStream();
                this.state = -2;
                return nextMimeEntity();
            case 9:
                this.state = 7;
                return null;
            case 10:
                this.state = 3;
                return null;
        }
    }

    @Override // org.apache.james.mime4j.parser.EntityStateMachine
    public InputStream getContentStream() {
        int i = this.state;
        if (i != 6 && i != 12) {
            switch (i) {
                case 8:
                case 9:
                    break;
                default:
                    throw new IllegalStateException("Invalid state: " + stateToString(this.state));
            }
        }
        return getLimitedContentStream();
    }

    @Override // org.apache.james.mime4j.parser.AbstractEntity
    protected LineReaderInputStream getDataStream() {
        return this.dataStream;
    }

    @Override // org.apache.james.mime4j.parser.AbstractEntity
    protected int getLineNumber() {
        LineNumberSource lineNumberSource = this.lineSource;
        if (lineNumberSource == null) {
            return -1;
        }
        return lineNumberSource.getLineNumber();
    }

    public int getRecursionMode() {
        return this.recursionMode;
    }

    @Override // org.apache.james.mime4j.parser.EntityStateMachine
    public void setRecursionMode(int i) {
        this.recursionMode = i;
    }

    public void skipHeader(String str) {
        if (this.state != 0) {
            throw new IllegalStateException("Invalid state: " + stateToString(this.state));
        }
        this.skipHeader = true;
        this.body.addField(new RawField(ContentUtil.encode("Content-Type: " + str), 12));
    }
}
