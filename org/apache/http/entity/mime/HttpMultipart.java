package org.apache.http.entity.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.james.mime4j.field.ContentTypeField;
import org.apache.james.mime4j.message.Body;
import org.apache.james.mime4j.message.BodyPart;
import org.apache.james.mime4j.message.MessageWriter;
import org.apache.james.mime4j.message.Multipart;
import org.apache.james.mime4j.parser.Field;
import org.apache.james.mime4j.util.ByteArrayBuffer;
import org.apache.james.mime4j.util.ByteSequence;
import org.apache.james.mime4j.util.CharsetUtil;

@NotThreadSafe
/* loaded from: classes.dex */
public class HttpMultipart extends Multipart {
    private static final ByteArrayBuffer CR_LF = encode(MIME.DEFAULT_CHARSET, CharsetUtil.CRLF);
    private static final ByteArrayBuffer TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
    private HttpMultipartMode mode;

    public HttpMultipart(String str) {
        super(str);
        this.mode = HttpMultipartMode.STRICT;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void doWriteTo(HttpMultipartMode httpMultipartMode, OutputStream outputStream, boolean z) {
        ByteArrayBuffer encode;
        List<BodyPart> bodyParts = getBodyParts();
        Charset charset = getCharset();
        ByteArrayBuffer encode2 = encode(charset, getBoundary());
        int i = 0;
        switch (httpMultipartMode) {
            case STRICT:
                String preamble = getPreamble();
                if (preamble != null && preamble.length() != 0) {
                    writeBytes(encode(charset, preamble), outputStream);
                    writeBytes(CR_LF, outputStream);
                }
                while (i < bodyParts.size()) {
                    writeBytes(TWO_DASHES, outputStream);
                    writeBytes(encode2, outputStream);
                    writeBytes(CR_LF, outputStream);
                    BodyPart bodyPart = bodyParts.get(i);
                    for (Field field : bodyPart.getHeader().getFields()) {
                        writeBytes(field.getRaw(), outputStream);
                        writeBytes(CR_LF, outputStream);
                    }
                    writeBytes(CR_LF, outputStream);
                    if (z) {
                        MessageWriter.DEFAULT.writeBody(bodyPart.getBody(), outputStream);
                    }
                    writeBytes(CR_LF, outputStream);
                    i++;
                }
                writeBytes(TWO_DASHES, outputStream);
                writeBytes(encode2, outputStream);
                writeBytes(TWO_DASHES, outputStream);
                writeBytes(CR_LF, outputStream);
                String epilogue = getEpilogue();
                if (epilogue != null && epilogue.length() != 0) {
                    encode = encode(charset, epilogue);
                    break;
                } else {
                    return;
                }
            case BROWSER_COMPATIBLE:
                while (i < bodyParts.size()) {
                    writeBytes(TWO_DASHES, outputStream);
                    writeBytes(encode2, outputStream);
                    writeBytes(CR_LF, outputStream);
                    BodyPart bodyPart2 = bodyParts.get(i);
                    Field field2 = bodyPart2.getHeader().getField("Content-Disposition");
                    writeBytes(encode(charset, field2.getName() + ": " + field2.getBody()), outputStream);
                    writeBytes(CR_LF, outputStream);
                    writeBytes(CR_LF, outputStream);
                    if (z) {
                        MessageWriter.DEFAULT.writeBody(bodyPart2.getBody(), outputStream);
                    }
                    writeBytes(CR_LF, outputStream);
                    i++;
                }
                writeBytes(TWO_DASHES, outputStream);
                writeBytes(encode2, outputStream);
                encode = TWO_DASHES;
                break;
            default:
                return;
        }
        writeBytes(encode, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    private static ByteArrayBuffer encode(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private static void writeBytes(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    private static void writeBytes(ByteSequence byteSequence, OutputStream outputStream) {
        if (byteSequence instanceof ByteArrayBuffer) {
            writeBytes((ByteArrayBuffer) byteSequence, outputStream);
        } else {
            outputStream.write(byteSequence.toByteArray());
        }
    }

    protected String getBoundary() {
        return ((ContentTypeField) getParent().getHeader().getField("Content-Type")).getBoundary();
    }

    protected Charset getCharset() {
        ContentTypeField contentTypeField = (ContentTypeField) getParent().getHeader().getField("Content-Type");
        switch (this.mode) {
            case STRICT:
                return MIME.DEFAULT_CHARSET;
            case BROWSER_COMPATIBLE:
                return CharsetUtil.getCharset(contentTypeField.getCharset() != null ? contentTypeField.getCharset() : "ISO-8859-1");
            default:
                return null;
        }
    }

    public HttpMultipartMode getMode() {
        return this.mode;
    }

    public long getTotalLength() {
        ByteArrayOutputStream byteArrayOutputStream;
        List<BodyPart> bodyParts = getBodyParts();
        long j = 0;
        for (int i = 0; i < bodyParts.size(); i++) {
            Body body = bodyParts.get(i).getBody();
            if (body instanceof ContentBody) {
                long contentLength = ((ContentBody) body).getContentLength();
                if (contentLength >= 0) {
                    j += contentLength;
                }
            }
            return -1L;
        }
        try {
            doWriteTo(this.mode, new ByteArrayOutputStream(), false);
            return j + byteArrayOutputStream.toByteArray().length;
        } catch (IOException unused) {
            return -1L;
        }
    }

    public void setMode(HttpMultipartMode httpMultipartMode) {
        this.mode = httpMultipartMode;
    }

    public void writeTo(OutputStream outputStream) {
        doWriteTo(this.mode, outputStream, true);
    }
}
