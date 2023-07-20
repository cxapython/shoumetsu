package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.concurrent.FutureCallback;
import cz.msebera.android.httpclient.pool.PoolEntry;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@ThreadSafe
/* loaded from: classes.dex */
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private volatile int maxTotal;
    private volatile int validateAfterInactivity;
    private final Lock lock = new ReentrantLock();
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool = new HashMap();
    private final Set<E> leased = new HashSet();
    private final LinkedList<E> available = new LinkedList<>();
    private final LinkedList<PoolEntryFuture<E>> pending = new LinkedList<>();
    private final Map<T, Integer> maxPerRoute = new HashMap();

    public AbstractConnPool(ConnFactory<T, C> connFactory, int i, int i2) {
        this.connFactory = (ConnFactory) Args.notNull(connFactory, "Connection factory");
        this.defaultMaxPerRoute = Args.positive(i, "Max per route value");
        this.maxTotal = Args.positive(i2, "Max total value");
    }

    private int getMax(T t) {
        Integer num = this.maxPerRoute.get(t);
        return num != null ? num.intValue() : this.defaultMaxPerRoute;
    }

    private RouteSpecificPool<T, C, E> getPool(final T t) {
        RouteSpecificPool<T, C, E> routeSpecificPool = this.routeToPool.get(t);
        if (routeSpecificPool == null) {
            RouteSpecificPool<T, C, E> routeSpecificPool2 = (RouteSpecificPool<T, C, E>) new RouteSpecificPool<T, C, E>(t) { // from class: cz.msebera.android.httpclient.pool.AbstractConnPool.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // cz.msebera.android.httpclient.pool.RouteSpecificPool
                protected E createEntry(C c) {
                    return (E) AbstractConnPool.this.createEntry(t, c);
                }
            };
            this.routeToPool.put(t, routeSpecificPool2);
            return routeSpecificPool2;
        }
        return routeSpecificPool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066 A[Catch: all -> 0x0136, LOOP:1: B:14:0x0030->B:29:0x0066, LOOP_END, TryCatch #1 {all -> 0x0136, blocks: (B:7:0x001c, B:9:0x0022, B:13:0x002b, B:14:0x0030, B:31:0x0071, B:34:0x0084, B:38:0x0097, B:41:0x009e, B:42:0x00ac, B:44:0x00b2, B:46:0x00c1, B:48:0x00ca, B:50:0x00d2, B:51:0x00e8, B:55:0x0109, B:58:0x0115, B:17:0x0037, B:19:0x0041, B:27:0x0060, B:29:0x0066, B:20:0x0045, B:22:0x0049, B:24:0x0059, B:64:0x012e, B:65:0x0135, B:54:0x00fd), top: B:69:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006f A[EDGE_INSN: B:77:0x006f->B:30:0x006f ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public E getPoolEntryBlocking(T t, Object obj, long j, TimeUnit timeUnit, PoolEntryFuture<E> poolEntryFuture) {
        E e;
        E e2 = null;
        Date date = j > 0 ? new Date(System.currentTimeMillis() + timeUnit.toMillis(j)) : null;
        this.lock.lock();
        try {
            RouteSpecificPool pool = getPool(t);
            while (e2 == null) {
                Asserts.check(!this.isShutDown, "Connection pool shut down");
                while (true) {
                    e = (E) pool.getFree(obj);
                    if (e == null) {
                        break;
                    }
                    if (!e.isExpired(System.currentTimeMillis())) {
                        if (this.validateAfterInactivity > 0 && e.getUpdated() + this.validateAfterInactivity <= System.currentTimeMillis() && !validate(e)) {
                        }
                        if (e.isClosed()) {
                            break;
                        }
                        this.available.remove(e);
                        pool.free(e, false);
                    }
                    e.close();
                    if (e.isClosed()) {
                    }
                }
                if (e != null) {
                    this.available.remove(e);
                    this.leased.add(e);
                    onReuse(e);
                    return e;
                }
                int max = getMax(t);
                int max2 = Math.max(0, (pool.getAllocatedCount() + 1) - max);
                if (max2 > 0) {
                    for (int i = 0; i < max2; i++) {
                        PoolEntry lastUsed = pool.getLastUsed();
                        if (lastUsed == null) {
                            break;
                        }
                        lastUsed.close();
                        this.available.remove(lastUsed);
                        pool.remove(lastUsed);
                    }
                }
                if (pool.getAllocatedCount() < max) {
                    int max3 = Math.max(this.maxTotal - this.leased.size(), 0);
                    if (max3 > 0) {
                        if (this.available.size() > max3 - 1 && !this.available.isEmpty()) {
                            E removeLast = this.available.removeLast();
                            removeLast.close();
                            getPool(removeLast.getRoute()).remove(removeLast);
                        }
                        E e3 = (E) pool.add(this.connFactory.create(t));
                        this.leased.add(e3);
                        return e3;
                    }
                }
                pool.queue(poolEntryFuture);
                this.pending.add(poolEntryFuture);
                boolean await = poolEntryFuture.await(date);
                pool.unqueue(poolEntryFuture);
                this.pending.remove(poolEntryFuture);
                if (!await && date != null && date.getTime() <= System.currentTimeMillis()) {
                    break;
                }
                e2 = e;
            }
            throw new TimeoutException("Timeout waiting for connection");
        } finally {
            this.lock.unlock();
        }
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, RouteSpecificPool<T, C, E>>> it = this.routeToPool.entrySet().iterator();
        while (it.hasNext()) {
            RouteSpecificPool<T, C, E> value = it.next().getValue();
            if (value.getPendingCount() + value.getAllocatedCount() == 0) {
                it.remove();
            }
        }
    }

    public void closeExpired() {
        final long currentTimeMillis = System.currentTimeMillis();
        enumAvailable(new PoolEntryCallback<T, C>() { // from class: cz.msebera.android.httpclient.pool.AbstractConnPool.4
            @Override // cz.msebera.android.httpclient.pool.PoolEntryCallback
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.isExpired(currentTimeMillis)) {
                    poolEntry.close();
                }
            }
        });
    }

    public void closeIdle(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        if (millis < 0) {
            millis = 0;
        }
        final long currentTimeMillis = System.currentTimeMillis() - millis;
        enumAvailable(new PoolEntryCallback<T, C>() { // from class: cz.msebera.android.httpclient.pool.AbstractConnPool.3
            @Override // cz.msebera.android.httpclient.pool.PoolEntryCallback
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.getUpdated() <= currentTimeMillis) {
                    poolEntry.close();
                }
            }
        });
    }

    protected abstract E createEntry(T t, C c);

    protected void enumAvailable(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                poolEntryCallback.process(next);
                if (next.isClosed()) {
                    getPool(next.getRoute()).remove(next);
                    it.remove();
                }
            }
            purgePoolMap();
        } finally {
            this.lock.unlock();
        }
    }

    protected void enumLeased(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            for (E e : this.leased) {
                poolEntryCallback.process(e);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxPerRoute(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            return getMax(t);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    public Set<T> getRoutes() {
        this.lock.lock();
        try {
            return new HashSet(this.routeToPool.keySet());
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getStats(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            RouteSpecificPool<T, C, E> pool = getPool(t);
            return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(t));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    public int getValidateAfterInactivity() {
        return this.validateAfterInactivity;
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    public Future<E> lease(T t, Object obj) {
        return lease(t, obj, null);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPool
    public Future<E> lease(final T t, final Object obj, FutureCallback<E> futureCallback) {
        Args.notNull(t, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return new PoolEntryFuture<E>(this.lock, futureCallback) { // from class: cz.msebera.android.httpclient.pool.AbstractConnPool.2
            @Override // cz.msebera.android.httpclient.pool.PoolEntryFuture
            /* renamed from: getPoolEntry */
            public E mo43getPoolEntry(long j, TimeUnit timeUnit) {
                E e = (E) AbstractConnPool.this.getPoolEntryBlocking(t, obj, j, timeUnit, this);
                AbstractConnPool.this.onLease(e);
                return e;
            }
        };
    }

    protected void onLease(E e) {
    }

    protected void onRelease(E e) {
    }

    protected void onReuse(E e) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void release(E e, boolean z) {
        this.lock.lock();
        try {
            if (this.leased.remove(e)) {
                RouteSpecificPool pool = getPool(e.getRoute());
                pool.free(e, z);
                if (!z || this.isShutDown) {
                    e.close();
                } else {
                    this.available.addFirst(e);
                    onRelease(e);
                }
                PoolEntryFuture<E> nextPending = pool.nextPending();
                if (nextPending != null) {
                    this.pending.remove(nextPending);
                } else {
                    nextPending = this.pending.poll();
                }
                if (nextPending != null) {
                    nextPending.wakeup();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cz.msebera.android.httpclient.pool.ConnPool
    public /* bridge */ /* synthetic */ void release(Object obj, boolean z) {
        release((AbstractConnPool<T, C, E>) ((PoolEntry) obj), z);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Max per route value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxPerRoute(T t, int i) {
        Args.notNull(t, "Route");
        Args.positive(i, "Max per route value");
        this.lock.lock();
        try {
            this.maxPerRoute.put(t, Integer.valueOf(i));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxTotal(int i) {
        Args.positive(i, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = i;
        } finally {
            this.lock.unlock();
        }
    }

    public void setValidateAfterInactivity(int i) {
        this.validateAfterInactivity = i;
    }

    public void shutdown() {
        if (this.isShutDown) {
            return;
        }
        this.isShutDown = true;
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            for (E e : this.leased) {
                e.close();
            }
            for (RouteSpecificPool<T, C, E> routeSpecificPool : this.routeToPool.values()) {
                routeSpecificPool.shutdown();
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        return "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";
    }

    protected boolean validate(E e) {
        return true;
    }
}
