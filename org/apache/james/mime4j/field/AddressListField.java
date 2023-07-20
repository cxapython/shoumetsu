package org.apache.james.mime4j.field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.james.mime4j.field.address.AddressList;
import org.apache.james.mime4j.util.ByteSequence;

/* loaded from: classes.dex */
public class AddressListField extends AbstractField {
    private AddressList addressList;
    private org.apache.james.mime4j.field.address.parser.ParseException parseException;
    private boolean parsed;
    private static Log log = LogFactory.getLog(AddressListField.class);
    static final FieldParser PARSER = new FieldParser() { // from class: org.apache.james.mime4j.field.AddressListField.1
        @Override // org.apache.james.mime4j.field.FieldParser
        public ParsedField parse(String str, String str2, ByteSequence byteSequence) {
            return new AddressListField(str, str2, byteSequence);
        }
    };

    AddressListField(String str, String str2, ByteSequence byteSequence) {
        super(str, str2, byteSequence);
        this.parsed = false;
    }

    private void parse() {
        String body = getBody();
        try {
            this.addressList = AddressList.parse(body);
        } catch (org.apache.james.mime4j.field.address.parser.ParseException e) {
            if (log.isDebugEnabled()) {
                Log log2 = log;
                log2.debug("Parsing value '" + body + "': " + e.getMessage());
            }
            this.parseException = e;
        }
        this.parsed = true;
    }

    public AddressList getAddressList() {
        if (!this.parsed) {
            parse();
        }
        return this.addressList;
    }

    @Override // org.apache.james.mime4j.field.AbstractField, org.apache.james.mime4j.field.ParsedField
    /* renamed from: getParseException  reason: collision with other method in class */
    public org.apache.james.mime4j.field.address.parser.ParseException mo60getParseException() {
        if (!this.parsed) {
            parse();
        }
        return this.parseException;
    }
}
