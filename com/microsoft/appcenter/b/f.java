package com.microsoft.appcenter.b;

/* loaded from: classes.dex */
public abstract class f implements d {
    final d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.a = dVar;
    }

    @Override // com.microsoft.appcenter.b.d
    public void a() {
        this.a.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }
}
