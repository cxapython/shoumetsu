package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;

@Deprecated
/* loaded from: classes.dex */
public abstract class AbstractPooledConnAdapter extends AbstractClientConnAdapter {
    protected volatile AbstractPoolEntry poolEntry;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractPooledConnAdapter(ClientConnectionManager clientConnectionManager, AbstractPoolEntry abstractPoolEntry) {
        super(clientConnectionManager, abstractPoolEntry.connection);
        this.poolEntry = abstractPoolEntry;
    }

    @Deprecated
    protected final void assertAttached() {
        if (this.poolEntry != null) {
            return;
        }
        throw new ConnectionShutdownException();
    }

    protected void assertValid(AbstractPoolEntry abstractPoolEntry) {
        if (isReleased() || abstractPoolEntry == null) {
            throw new ConnectionShutdownException();
        }
    }

    @Override // cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractPoolEntry poolEntry = getPoolEntry();
        if (poolEntry != null) {
            poolEntry.shutdownEntry();
        }
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        if (wrappedConnection != null) {
            wrappedConnection.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.msebera.android.httpclient.impl.conn.AbstractClientConnAdapter
    public synchronized void detach() {
        this.poolEntry = null;
        super.detach();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public String getId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public AbstractPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection, cz.msebera.android.httpclient.conn.HttpRoutedConnection
    public HttpRoute getRoute() {
        AbstractPoolEntry poolEntry = getPoolEntry();
        assertValid(poolEntry);
        if (poolEntry.tracker == null) {
            return null;
        }
        return poolEntry.tracker.toRoute();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public Object getState() {
        AbstractPoolEntry poolEntry = getPoolEntry();
        assertValid(poolEntry);
        return poolEntry.getState();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void layerProtocol(HttpContext httpContext, HttpParams httpParams) {
        AbstractPoolEntry poolEntry = getPoolEntry();
        assertValid(poolEntry);
        poolEntry.layerProtocol(httpContext, httpParams);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void open(HttpRoute httpRoute, HttpContext httpContext, HttpParams httpParams) {
        AbstractPoolEntry poolEntry = getPoolEntry();
        assertValid(poolEntry);
        poolEntry.open(httpRoute, httpContext, httpParams);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void setState(Object obj) {
        AbstractPoolEntry poolEntry = getPoolEntry();
        assertValid(poolEntry);
        poolEntry.setState(obj);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void shutdown() {
        AbstractPoolEntry poolEntry = getPoolEntry();
        if (poolEntry != null) {
            poolEntry.shutdownEntry();
        }
        OperatedClientConnection wrappedConnection = getWrappedConnection();
        if (wrappedConnection != null) {
            wrappedConnection.shutdown();
        }
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void tunnelProxy(HttpHost httpHost, boolean z, HttpParams httpParams) {
        AbstractPoolEntry poolEntry = getPoolEntry();
        assertValid(poolEntry);
        poolEntry.tunnelProxy(httpHost, z, httpParams);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void tunnelTarget(boolean z, HttpParams httpParams) {
        AbstractPoolEntry poolEntry = getPoolEntry();
        assertValid(poolEntry);
        poolEntry.tunnelTarget(z, httpParams);
    }
}
