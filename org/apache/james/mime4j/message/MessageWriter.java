package org.apache.james.mime4j.message;

import java.io.OutputStream;
import java.util.Iterator;
import org.apache.james.mime4j.codec.CodecUtil;
import org.apache.james.mime4j.field.ContentTypeField;
import org.apache.james.mime4j.parser.Field;
import org.apache.james.mime4j.util.ByteArrayBuffer;
import org.apache.james.mime4j.util.ByteSequence;
import org.apache.james.mime4j.util.ContentUtil;
import org.apache.james.mime4j.util.MimeUtil;

/* loaded from: classes.dex */
public class MessageWriter {
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHES = {45, 45};
    public static final MessageWriter DEFAULT = new MessageWriter();

    protected MessageWriter() {
    }

    private ByteSequence getBoundary(ContentTypeField contentTypeField) {
        String boundary = contentTypeField.getBoundary();
        if (boundary != null) {
            return ContentUtil.encode(boundary);
        }
        throw new IllegalArgumentException("Multipart boundary not specified");
    }

    private ContentTypeField getContentType(Multipart multipart) {
        Entity parent = multipart.getParent();
        if (parent != null) {
            Header header = parent.getHeader();
            if (header == null) {
                throw new IllegalArgumentException("Missing header in parent entity");
            }
            ContentTypeField contentTypeField = (ContentTypeField) header.getField("Content-Type");
            if (contentTypeField == null) {
                throw new IllegalArgumentException("Content-Type field not specified");
            }
            return contentTypeField;
        }
        throw new IllegalArgumentException("Missing parent entity in multipart");
    }

    private void writeBytes(ByteSequence byteSequence, OutputStream outputStream) {
        if (!(byteSequence instanceof ByteArrayBuffer)) {
            outputStream.write(byteSequence.toByteArray());
            return;
        }
        ByteArrayBuffer byteArrayBuffer = (ByteArrayBuffer) byteSequence;
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    protected OutputStream encodeStream(OutputStream outputStream, String str, boolean z) {
        return MimeUtil.isBase64Encoding(str) ? CodecUtil.wrapBase64(outputStream) : MimeUtil.isQuotedPrintableEncoded(str) ? CodecUtil.wrapQuotedPrintable(outputStream, z) : outputStream;
    }

    public void writeBody(Body body, OutputStream outputStream) {
        if (body instanceof Message) {
            writeEntity((Message) body, outputStream);
        } else if (body instanceof Multipart) {
            writeMultipart((Multipart) body, outputStream);
        } else if (!(body instanceof SingleBody)) {
            throw new IllegalArgumentException("Unsupported body class");
        } else {
            ((SingleBody) body).writeTo(outputStream);
        }
    }

    public void writeEntity(Entity entity, OutputStream outputStream) {
        Header header = entity.getHeader();
        if (header != null) {
            writeHeader(header, outputStream);
            Body body = entity.getBody();
            if (body == null) {
                throw new IllegalArgumentException("Missing body");
            }
            OutputStream encodeStream = encodeStream(outputStream, entity.getContentTransferEncoding(), body instanceof BinaryBody);
            writeBody(body, encodeStream);
            if (encodeStream == outputStream) {
                return;
            }
            encodeStream.close();
            return;
        }
        throw new IllegalArgumentException("Missing header");
    }

    public void writeHeader(Header header, OutputStream outputStream) {
        Iterator<Field> it = header.iterator();
        while (it.hasNext()) {
            writeBytes(it.next().getRaw(), outputStream);
            outputStream.write(CRLF);
        }
        outputStream.write(CRLF);
    }

    public void writeMultipart(Multipart multipart, OutputStream outputStream) {
        ByteSequence boundary = getBoundary(getContentType(multipart));
        writeBytes(multipart.getPreambleRaw(), outputStream);
        outputStream.write(CRLF);
        for (BodyPart bodyPart : multipart.getBodyParts()) {
            outputStream.write(DASHES);
            writeBytes(boundary, outputStream);
            outputStream.write(CRLF);
            writeEntity(bodyPart, outputStream);
            outputStream.write(CRLF);
        }
        outputStream.write(DASHES);
        writeBytes(boundary, outputStream);
        outputStream.write(DASHES);
        outputStream.write(CRLF);
        writeBytes(multipart.getEpilogueRaw(), outputStream);
    }
}
