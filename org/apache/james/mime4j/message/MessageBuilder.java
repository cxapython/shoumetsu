package org.apache.james.mime4j.message;

import java.io.InputStream;
import java.util.Stack;
import org.apache.james.mime4j.codec.Base64InputStream;
import org.apache.james.mime4j.codec.QuotedPrintableInputStream;
import org.apache.james.mime4j.descriptor.BodyDescriptor;
import org.apache.james.mime4j.field.AbstractField;
import org.apache.james.mime4j.parser.ContentHandler;
import org.apache.james.mime4j.parser.Field;
import org.apache.james.mime4j.storage.StorageProvider;
import org.apache.james.mime4j.util.ByteArrayBuffer;
import org.apache.james.mime4j.util.ByteSequence;
import org.apache.james.mime4j.util.MimeUtil;

/* loaded from: classes.dex */
public class MessageBuilder implements ContentHandler {
    private final BodyFactory bodyFactory;
    private final Entity entity;
    private Stack<Object> stack;

    public MessageBuilder(Entity entity) {
        this.stack = new Stack<>();
        this.entity = entity;
        this.bodyFactory = new BodyFactory();
    }

    public MessageBuilder(Entity entity, StorageProvider storageProvider) {
        this.stack = new Stack<>();
        this.entity = entity;
        this.bodyFactory = new BodyFactory(storageProvider);
    }

    private void expect(Class<?> cls) {
        if (cls.isInstance(this.stack.peek())) {
            return;
        }
        throw new IllegalStateException("Internal stack error: Expected '" + cls.getName() + "' found '" + this.stack.peek().getClass().getName() + "'");
    }

    private static ByteSequence loadStream(InputStream inputStream) {
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(64);
        while (true) {
            int read = inputStream.read();
            if (read != -1) {
                byteArrayBuffer.append(read);
            } else {
                return byteArrayBuffer;
            }
        }
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void body(BodyDescriptor bodyDescriptor, InputStream inputStream) {
        expect(Entity.class);
        String transferEncoding = bodyDescriptor.getTransferEncoding();
        InputStream base64InputStream = MimeUtil.ENC_BASE64.equals(transferEncoding) ? new Base64InputStream(inputStream) : MimeUtil.ENC_QUOTED_PRINTABLE.equals(transferEncoding) ? new QuotedPrintableInputStream(inputStream) : inputStream;
        ((Entity) this.stack.peek()).setBody(bodyDescriptor.getMimeType().startsWith("text/") ? this.bodyFactory.textBody(base64InputStream, bodyDescriptor.getCharset()) : this.bodyFactory.binaryBody(base64InputStream));
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void endBodyPart() {
        expect(BodyPart.class);
        this.stack.pop();
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void endHeader() {
        expect(Header.class);
        expect(Entity.class);
        ((Entity) this.stack.peek()).setHeader((Header) this.stack.pop());
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void endMessage() {
        expect(Message.class);
        this.stack.pop();
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void endMultipart() {
        this.stack.pop();
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void epilogue(InputStream inputStream) {
        expect(Multipart.class);
        ((Multipart) this.stack.peek()).setEpilogueRaw(loadStream(inputStream));
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void field(Field field) {
        expect(Header.class);
        ((Header) this.stack.peek()).addField(AbstractField.parse(field.getRaw()));
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void preamble(InputStream inputStream) {
        expect(Multipart.class);
        ((Multipart) this.stack.peek()).setPreambleRaw(loadStream(inputStream));
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void raw(InputStream inputStream) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void startBodyPart() {
        expect(Multipart.class);
        BodyPart bodyPart = new BodyPart();
        ((Multipart) this.stack.peek()).addBodyPart(bodyPart);
        this.stack.push(bodyPart);
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void startHeader() {
        this.stack.push(new Header());
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void startMessage() {
        if (this.stack.isEmpty()) {
            this.stack.push(this.entity);
            return;
        }
        expect(Entity.class);
        Message message = new Message();
        ((Entity) this.stack.peek()).setBody(message);
        this.stack.push(message);
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void startMultipart(BodyDescriptor bodyDescriptor) {
        expect(Entity.class);
        Multipart multipart = new Multipart(bodyDescriptor.getSubType());
        ((Entity) this.stack.peek()).setBody(multipart);
        this.stack.push(multipart);
    }
}
