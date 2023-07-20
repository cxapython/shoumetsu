package org.apache.james.mime4j.message;

import java.io.InputStream;
import org.apache.james.mime4j.codec.Base64InputStream;
import org.apache.james.mime4j.codec.QuotedPrintableInputStream;
import org.apache.james.mime4j.descriptor.BodyDescriptor;
import org.apache.james.mime4j.field.AbstractField;
import org.apache.james.mime4j.parser.AbstractContentHandler;
import org.apache.james.mime4j.parser.Field;
import org.apache.james.mime4j.util.MimeUtil;

/* loaded from: classes.dex */
public abstract class SimpleContentHandler extends AbstractContentHandler {
    private Header currHeader;

    @Override // org.apache.james.mime4j.parser.AbstractContentHandler, org.apache.james.mime4j.parser.ContentHandler
    public final void body(BodyDescriptor bodyDescriptor, InputStream inputStream) {
        InputStream quotedPrintableInputStream;
        if (MimeUtil.isBase64Encoding(bodyDescriptor.getTransferEncoding())) {
            quotedPrintableInputStream = new Base64InputStream(inputStream);
        } else if (!MimeUtil.isQuotedPrintableEncoded(bodyDescriptor.getTransferEncoding())) {
            bodyDecoded(bodyDescriptor, inputStream);
            return;
        } else {
            quotedPrintableInputStream = new QuotedPrintableInputStream(inputStream);
        }
        bodyDecoded(bodyDescriptor, quotedPrintableInputStream);
    }

    public abstract void bodyDecoded(BodyDescriptor bodyDescriptor, InputStream inputStream);

    @Override // org.apache.james.mime4j.parser.AbstractContentHandler, org.apache.james.mime4j.parser.ContentHandler
    public final void endHeader() {
        Header header = this.currHeader;
        this.currHeader = null;
        headers(header);
    }

    @Override // org.apache.james.mime4j.parser.AbstractContentHandler, org.apache.james.mime4j.parser.ContentHandler
    public final void field(Field field) {
        this.currHeader.addField(AbstractField.parse(field.getRaw()));
    }

    public abstract void headers(Header header);

    @Override // org.apache.james.mime4j.parser.AbstractContentHandler, org.apache.james.mime4j.parser.ContentHandler
    public final void startHeader() {
        this.currHeader = new Header();
    }
}
