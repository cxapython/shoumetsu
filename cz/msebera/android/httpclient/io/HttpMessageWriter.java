package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.HttpMessage;

/* loaded from: classes.dex */
public interface HttpMessageWriter<T extends HttpMessage> {
    void write(T t);
}
