package com.c.a.a;

import com.google.android.gms.nearby.connection.Connections;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class e extends c {
    protected final File a;
    protected final boolean b;
    protected final boolean c;
    protected File d;

    public e(File file, boolean z) {
        this(file, z, false);
    }

    public e(File file, boolean z, boolean z2) {
        this(file, z, z2, false);
    }

    public e(File file, boolean z, boolean z2, boolean z3) {
        super(z3);
        p.a(file != null, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        if (!file.isDirectory() && !file.getParentFile().isDirectory()) {
            p.a(file.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
        }
        if (file.isDirectory() && !file.mkdirs()) {
            a.a.b("FileAsyncHttpRH", "Cannot create directories for requested Directory location, might not be a problem");
        }
        this.a = file;
        this.b = z;
        this.c = z2;
    }

    public abstract void a(int i, Header[] headerArr, File file);

    public abstract void a(int i, Header[] headerArr, Throwable th, File file);

    @Override // com.c.a.a.c
    public final void a(int i, Header[] headerArr, byte[] bArr) {
        a(i, headerArr, k());
    }

    @Override // com.c.a.a.c
    public final void a(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        a(i, headerArr, th, k());
    }

    @Override // com.c.a.a.c
    protected byte[] a(HttpEntity httpEntity) {
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            long contentLength = httpEntity.getContentLength();
            FileOutputStream fileOutputStream = new FileOutputStream(k(), this.b);
            if (content == null) {
                return null;
            }
            try {
                byte[] bArr = new byte[Connections.MAX_RELIABLE_MESSAGE_LEN];
                int i = 0;
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    i += read;
                    fileOutputStream.write(bArr, 0, read);
                    b(i, contentLength);
                }
                return null;
            } finally {
                a.a(content);
                fileOutputStream.flush();
                a.a(fileOutputStream);
            }
        }
        return null;
    }

    protected File j() {
        p.a(this.a != null, "Target file is null, fatal!");
        return this.a;
    }

    public File k() {
        if (this.d == null) {
            this.d = j().isDirectory() ? l() : j();
        }
        return this.d;
    }

    protected File l() {
        StringBuilder sb;
        String substring;
        p.a(j().isDirectory(), "Target file is not a directory, cannot proceed");
        p.a(a() != null, "RequestURI is null, cannot proceed");
        String uri = a().toString();
        String substring2 = uri.substring(uri.lastIndexOf(47) + 1, uri.length());
        File file = new File(j(), substring2);
        if (!file.exists() || !this.c) {
            return file;
        }
        if (!substring2.contains(".")) {
            sb = new StringBuilder();
            sb.append(substring2);
            substring = " (%d)";
        } else {
            sb = new StringBuilder();
            sb.append(substring2.substring(0, substring2.lastIndexOf(46)));
            sb.append(" (%d)");
            substring = substring2.substring(substring2.lastIndexOf(46), substring2.length());
        }
        sb.append(substring);
        String sb2 = sb.toString();
        int i = 0;
        while (true) {
            File file2 = new File(j(), String.format(sb2, Integer.valueOf(i)));
            if (!file2.exists()) {
                return file2;
            }
            i++;
        }
    }
}
