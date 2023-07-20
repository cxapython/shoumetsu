package org.apache.james.mime4j.parser;

import java.io.InputStream;
import org.apache.james.mime4j.descriptor.BodyDescriptor;

/* loaded from: classes.dex */
public abstract class AbstractContentHandler implements ContentHandler {
    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void body(BodyDescriptor bodyDescriptor, InputStream inputStream) {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void endBodyPart() {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void endHeader() {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void endMessage() {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void endMultipart() {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void epilogue(InputStream inputStream) {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void field(Field field) {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void preamble(InputStream inputStream) {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void raw(InputStream inputStream) {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void startBodyPart() {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void startHeader() {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void startMessage() {
    }

    @Override // org.apache.james.mime4j.parser.ContentHandler
    public void startMultipart(BodyDescriptor bodyDescriptor) {
    }
}
