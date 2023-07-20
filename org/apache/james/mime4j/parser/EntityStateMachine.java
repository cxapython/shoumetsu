package org.apache.james.mime4j.parser;

import java.io.InputStream;
import org.apache.james.mime4j.descriptor.BodyDescriptor;

/* loaded from: classes.dex */
public interface EntityStateMachine {
    EntityStateMachine advance();

    BodyDescriptor getBodyDescriptor();

    InputStream getContentStream();

    Field getField();

    int getState();

    void setRecursionMode(int i);
}
