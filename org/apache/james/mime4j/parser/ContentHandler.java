package org.apache.james.mime4j.parser;

import java.io.InputStream;
import org.apache.james.mime4j.descriptor.BodyDescriptor;

/* loaded from: classes.dex */
public interface ContentHandler {
    void body(BodyDescriptor bodyDescriptor, InputStream inputStream);

    void endBodyPart();

    void endHeader();

    void endMessage();

    void endMultipart();

    void epilogue(InputStream inputStream);

    void field(Field field);

    void preamble(InputStream inputStream);

    void raw(InputStream inputStream);

    void startBodyPart();

    void startHeader();

    void startMessage();

    void startMultipart(BodyDescriptor bodyDescriptor);
}
