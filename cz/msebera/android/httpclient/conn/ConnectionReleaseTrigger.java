package cz.msebera.android.httpclient.conn;

/* loaded from: classes.dex */
public interface ConnectionReleaseTrigger {
    void abortConnection();

    void releaseConnection();
}
