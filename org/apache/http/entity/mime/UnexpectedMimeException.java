package org.apache.http.entity.mime;

import org.apache.james.mime4j.MimeException;

@Deprecated
/* loaded from: classes.dex */
public class UnexpectedMimeException extends RuntimeException {
    private static final long serialVersionUID = 1316818299528463579L;

    public UnexpectedMimeException(MimeException mimeException) {
        super(mimeException.getMessage(), mimeException);
    }
}
