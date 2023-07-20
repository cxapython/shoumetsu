package cz.msebera.android.httpclient.conn;

import java.io.InputStream;

/* loaded from: classes.dex */
public interface EofSensorWatcher {
    boolean eofDetected(InputStream inputStream);

    boolean streamAbort(InputStream inputStream);

    boolean streamClosed(InputStream inputStream);
}
