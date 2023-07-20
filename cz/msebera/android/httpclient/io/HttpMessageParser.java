package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.HttpMessage;

/* loaded from: classes.dex */
public interface HttpMessageParser<T extends HttpMessage> {
    T parse();
}
