package cz.msebera.android.httpclient;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public interface HttpEntity {
    @Deprecated
    void consumeContent();

    InputStream getContent();

    Header getContentEncoding();

    long getContentLength();

    Header getContentType();

    boolean isChunked();

    boolean isRepeatable();

    boolean isStreaming();

    void writeTo(OutputStream outputStream);
}
