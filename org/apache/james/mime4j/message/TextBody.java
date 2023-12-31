package org.apache.james.mime4j.message;

import java.io.Reader;

/* loaded from: classes.dex */
public abstract class TextBody extends SingleBody {
    public abstract String getMimeCharset();

    public abstract Reader getReader();
}
