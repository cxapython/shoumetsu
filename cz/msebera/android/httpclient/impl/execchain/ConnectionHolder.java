package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.concurrent.Cancellable;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@ThreadSafe
/* loaded from: classes.dex */
class ConnectionHolder implements Cancellable, ConnectionReleaseTrigger, Closeable {
    public HttpClientAndroidLog log;
    private final HttpClientConnection managedConn;
    private final HttpClientConnectionManager manager;
    private volatile boolean released;
    private volatile boolean reusable;
    private volatile Object state;
    private volatile TimeUnit tunit;
    private volatile long validDuration;

    public ConnectionHolder(HttpClientAndroidLog httpClientAndroidLog, HttpClientConnectionManager httpClientConnectionManager, HttpClientConnection httpClientConnection) {
        this.log = httpClientAndroidLog;
        this.manager = httpClientConnectionManager;
        this.managedConn = httpClientConnection;
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        synchronized (this.managedConn) {
            if (this.released) {
                return;
            }
            this.released = true;
            try {
                this.managedConn.shutdown();
                this.log.debug("Connection discarded");
                this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
            } catch (IOException e) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug(e.getMessage(), e);
                }
                this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // cz.msebera.android.httpclient.concurrent.Cancellable
    public boolean cancel() {
        boolean z = this.released;
        this.log.debug("Cancelling request execution");
        abortConnection();
        return !z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        abortConnection();
    }

    public boolean isReleased() {
        return this.released;
    }

    public boolean isReusable() {
        return this.reusable;
    }

    public void markNonReusable() {
        this.reusable = false;
    }

    public void markReusable() {
        this.reusable = true;
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        HttpClientConnectionManager httpClientConnectionManager;
        HttpClientConnection httpClientConnection;
        Object obj;
        long j;
        TimeUnit timeUnit;
        synchronized (this.managedConn) {
            if (this.released) {
                return;
            }
            this.released = true;
            if (!this.reusable) {
                try {
                    this.managedConn.close();
                    this.log.debug("Connection discarded");
                    this.manager.releaseConnection(this.managedConn, null, 0L, TimeUnit.MILLISECONDS);
                } catch (IOException e) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug(e.getMessage(), e);
                    }
                    httpClientConnectionManager = this.manager;
                    httpClientConnection = this.managedConn;
                    obj = null;
                    j = 0;
                    timeUnit = TimeUnit.MILLISECONDS;
                }
            }
            httpClientConnectionManager = this.manager;
            httpClientConnection = this.managedConn;
            obj = this.state;
            j = this.validDuration;
            timeUnit = this.tunit;
            httpClientConnectionManager.releaseConnection(httpClientConnection, obj, j, timeUnit);
        }
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public void setValidFor(long j, TimeUnit timeUnit) {
        synchronized (this.managedConn) {
            this.validDuration = j;
            this.tunit = timeUnit;
        }
    }
}
