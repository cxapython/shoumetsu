package com.c.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.nearby.connection.Connections;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpResponseException;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;

/* loaded from: classes.dex */
public abstract class c implements n {
    private String a;
    private Handler b;
    private boolean c;
    private boolean d;
    private URI e;
    private Header[] f;
    private Looper g;
    private WeakReference<Object> h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Handler {
        private final c a;

        a(c cVar, Looper looper) {
            super(looper);
            this.a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a(message);
        }
    }

    public c() {
        this((Looper) null);
    }

    public c(Looper looper) {
        this.a = "UTF-8";
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = new WeakReference<>(null);
        this.g = looper == null ? Looper.myLooper() : looper;
        a(false);
        b(false);
    }

    public c(boolean z) {
        this.a = "UTF-8";
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = new WeakReference<>(null);
        b(z);
        if (!c()) {
            this.g = Looper.myLooper();
            a(false);
        }
    }

    protected Message a(int i, Object obj) {
        return Message.obtain(this.b, i, obj);
    }

    public URI a() {
        return this.e;
    }

    public void a(int i) {
        com.c.a.a.a.a.b("AsyncHttpRH", String.format("Request retry no. %d", Integer.valueOf(i)));
    }

    public abstract void a(int i, Header[] headerArr, byte[] bArr);

    public abstract void a(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public void a(long j, long j2) {
        h hVar = com.c.a.a.a.a;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(j2);
        objArr[2] = Double.valueOf(j2 > 0 ? ((j * 1.0d) / j2) * 100.0d : -1.0d);
        hVar.a("AsyncHttpRH", String.format("Progress %d from %d (%2.0f%%)", objArr));
    }

    protected void a(Message message) {
        h hVar;
        String str;
        String str2;
        try {
            switch (message.what) {
                case 0:
                    Object[] objArr = (Object[]) message.obj;
                    if (objArr != null && objArr.length >= 3) {
                        a(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                        return;
                    }
                    hVar = com.c.a.a.a.a;
                    str = "AsyncHttpRH";
                    str2 = "SUCCESS_MESSAGE didn't got enough params";
                    break;
                case 1:
                    Object[] objArr2 = (Object[]) message.obj;
                    if (objArr2 != null && objArr2.length >= 4) {
                        a(((Integer) objArr2[0]).intValue(), (Header[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
                        return;
                    }
                    hVar = com.c.a.a.a.a;
                    str = "AsyncHttpRH";
                    str2 = "FAILURE_MESSAGE didn't got enough params";
                    break;
                    break;
                case 2:
                    d();
                    return;
                case 3:
                    e();
                    return;
                case 4:
                    Object[] objArr3 = (Object[]) message.obj;
                    if (objArr3 != null && objArr3.length >= 2) {
                        a(((Long) objArr3[0]).longValue(), ((Long) objArr3[1]).longValue());
                        return;
                    }
                    hVar = com.c.a.a.a.a;
                    str = "AsyncHttpRH";
                    str2 = "PROGRESS_MESSAGE didn't got enough params";
                    break;
                    break;
                case 5:
                    Object[] objArr4 = (Object[]) message.obj;
                    if (objArr4 != null && objArr4.length == 1) {
                        a(((Integer) objArr4[0]).intValue());
                        return;
                    }
                    hVar = com.c.a.a.a.a;
                    str = "AsyncHttpRH";
                    str2 = "RETRY_MESSAGE didn't get enough params";
                    break;
                    break;
                case 6:
                    f();
                    return;
                default:
                    return;
            }
            hVar.d(str, str2);
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // com.c.a.a.n
    public void a(n nVar, HttpResponse httpResponse) {
    }

    @Override // com.c.a.a.n
    public void a(HttpResponse httpResponse) {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            byte[] a2 = a(httpResponse.getEntity());
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (statusLine.getStatusCode() >= 300) {
                b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), a2, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
            } else {
                b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), a2);
            }
        }
    }

    public void a(Throwable th) {
        com.c.a.a.a.a.b("AsyncHttpRH", "User-space exception detected!", th);
        throw new RuntimeException(th);
    }

    @Override // com.c.a.a.n
    public void a(URI uri) {
        this.e = uri;
    }

    public void a(boolean z) {
        a aVar;
        if (!z && this.g == null) {
            z = true;
            com.c.a.a.a.a.c("AsyncHttpRH", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
        }
        if (z || this.b != null) {
            if (z && this.b != null) {
                aVar = null;
            }
            this.c = z;
        }
        aVar = new a(this, this.g);
        this.b = aVar;
        this.c = z;
    }

    @Override // com.c.a.a.n
    public void a(Header[] headerArr) {
        this.f = headerArr;
    }

    byte[] a(HttpEntity httpEntity) {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength > 2147483647L) {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        long j = 0;
        int i = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
        try {
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i <= 0 ? Connections.MAX_RELIABLE_MESSAGE_LEN : (int) contentLength);
            byte[] bArr = new byte[Connections.MAX_RELIABLE_MESSAGE_LEN];
            while (true) {
                int read = content.read(bArr);
                if (read == -1 || Thread.currentThread().isInterrupted()) {
                    break;
                }
                j += read;
                byteArrayBuffer.append(bArr, 0, read);
                b(j, i <= 0 ? 1L : contentLength);
            }
            com.c.a.a.a.a(content);
            com.c.a.a.a.a(httpEntity);
            return byteArrayBuffer.toByteArray();
        } catch (OutOfMemoryError unused) {
            System.gc();
            throw new IOException("File too large to fit into available memory");
        }
    }

    @Override // com.c.a.a.n
    public final void b(int i) {
        b(a(5, new Object[]{Integer.valueOf(i)}));
    }

    public final void b(int i, Header[] headerArr, byte[] bArr) {
        b(a(0, new Object[]{Integer.valueOf(i), headerArr, bArr}));
    }

    @Override // com.c.a.a.n
    public final void b(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        b(a(1, new Object[]{Integer.valueOf(i), headerArr, bArr, th}));
    }

    public final void b(long j, long j2) {
        b(a(4, new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
    }

    protected void b(Message message) {
        if (b() || this.b == null) {
            a(message);
        } else if (Thread.currentThread().isInterrupted()) {
        } else {
            p.a(this.b != null, "handler should not be null!");
            this.b.sendMessage(message);
        }
    }

    @Override // com.c.a.a.n
    public void b(n nVar, HttpResponse httpResponse) {
    }

    public void b(boolean z) {
        if (z) {
            this.g = null;
            this.b = null;
        }
        this.d = z;
    }

    @Override // com.c.a.a.n
    public boolean b() {
        return this.c;
    }

    @Override // com.c.a.a.n
    public boolean c() {
        return this.d;
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
        com.c.a.a.a.a.b("AsyncHttpRH", "Request got cancelled");
    }

    @Override // com.c.a.a.n
    public final void g() {
        b(a(2, (Object) null));
    }

    @Override // com.c.a.a.n
    public final void h() {
        b(a(3, (Object) null));
    }

    @Override // com.c.a.a.n
    public final void i() {
        b(a(6, (Object) null));
    }
}
