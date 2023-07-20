package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@NotThreadSafe
@Deprecated
/* loaded from: classes.dex */
public abstract class AbstractClientConnAdapter implements ManagedClientConnection, HttpContext {
    private final ClientConnectionManager connManager;
    private volatile OperatedClientConnection wrappedConnection;
    private volatile boolean markedReusable = false;
    private volatile boolean released = false;
    private volatile long duration = Long.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractClientConnAdapter(ClientConnectionManager clientConnectionManager, OperatedClientConnection operatedClientConnection) {
        this.connManager = clientConnectionManager;
        this.wrappedConnection = operatedClientConnection;
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public synchronized void abortConnection() {
        if (this.released) {
            return;
        }
        this.released = true;
        unmarkReusable();
        try {
            shutdown();
        } catch (IOException unused) {
        }
        this.connManager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
    }

    @Deprecated
    protected final void assertNotAborted() {
        if (!isReleased()) {
            return;
        }
        throw new InterruptedIOException("Connection has been shut down");
    }

    protected final void assertValid(OperatedClientConnection operatedClientConnection) {
        if (isReleased() || operatedClientConnection == null) {
            throw new ConnectionShutdownException();
        }
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public void bind(Socket socket) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void detach() {
        this.wrappedConnection = null;
        this.duration = Long.MAX_VALUE;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void flush() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        wrappedConnection.flush();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String str) {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        if (wrappedConnection instanceof HttpContext) {
            return ((HttpContext) wrappedConnection).getAttribute(str);
        }
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getLocalAddress() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        return wrappedConnection.getLocalAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getLocalPort() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        return wrappedConnection.getLocalPort();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClientConnectionManager getManager() {
        return this.connManager;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        return wrappedConnection.getMetrics();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getRemoteAddress() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        return wrappedConnection.getRemoteAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getRemotePort() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        return wrappedConnection.getRemotePort();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection, cz.msebera.android.httpclient.conn.HttpRoutedConnection, cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        if (!isOpen()) {
            return null;
        }
        Socket socket = wrappedConnection.getSocket();
        if (!(socket instanceof SSLSocket)) {
            return null;
        }
        return ((SSLSocket) socket).getSession();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public Socket getSocket() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        if (!isOpen()) {
            return null;
        }
        return wrappedConnection.getSocket();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public int getSocketTimeout() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        return wrappedConnection.getSocketTimeout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OperatedClientConnection getWrappedConnection() {
        return this.wrappedConnection;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public boolean isMarkedReusable() {
        return this.markedReusable;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isOpen() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        if (wrappedConnection == null) {
            return false;
        }
        return wrappedConnection.isOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isReleased() {
        return this.released;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public boolean isResponseAvailable(int i) {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        return wrappedConnection.isResponseAvailable(i);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection, cz.msebera.android.httpclient.conn.HttpRoutedConnection
    public boolean isSecure() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        return wrappedConnection.isSecure();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isStale() {
        OperatedClientConnection wrappedConnection;
        if (!isReleased() && (wrappedConnection = getWrappedConnection()) != null) {
            return wrappedConnection.isStale();
        }
        return true;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void markReusable() {
        this.markedReusable = true;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void receiveResponseEntity(HttpResponse httpResponse) {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        unmarkReusable();
        wrappedConnection.receiveResponseEntity(httpResponse);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public HttpResponse receiveResponseHeader() {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        unmarkReusable();
        return wrappedConnection.receiveResponseHeader();
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public synchronized void releaseConnection() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.connManager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String str) {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        if (wrappedConnection instanceof HttpContext) {
            return ((HttpContext) wrappedConnection).removeAttribute(str);
        }
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        unmarkReusable();
        wrappedConnection.sendRequestEntity(httpEntityEnclosingRequest);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest) {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        unmarkReusable();
        wrappedConnection.sendRequestHeader(httpRequest);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        if (wrappedConnection instanceof HttpContext) {
            ((HttpContext) wrappedConnection).setAttribute(str, obj);
        }
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void setIdleDuration(long j, TimeUnit timeUnit) {
        this.duration = j > 0 ? timeUnit.toMillis(j) : -1L;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int i) {
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        assertValid(wrappedConnection);
        wrappedConnection.setSocketTimeout(i);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void unmarkReusable() {
        this.markedReusable = false;
    }
}
