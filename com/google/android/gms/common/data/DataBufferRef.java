package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferRef {
    @KeepForSdk
    protected final DataHolder a;
    @KeepForSdk
    protected int b;
    private int c;

    @KeepForSdk
    public DataBufferRef(DataHolder dataHolder, int i) {
        this.a = (DataHolder) Preconditions.checkNotNull(dataHolder);
        a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public int a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public long a(String str) {
        return this.a.getLong(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        Preconditions.checkState(i >= 0 && i < this.a.getCount());
        this.b = i;
        this.c = this.a.getWindowIndex(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public void a(String str, CharArrayBuffer charArrayBuffer) {
        this.a.zaa(str, this.b, this.c, charArrayBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public int b(String str) {
        return this.a.getInteger(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public boolean c(String str) {
        return this.a.getBoolean(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public String d(String str) {
        return this.a.getString(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public float e(String str) {
        return this.a.zaa(str, this.b, this.c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.equal(Integer.valueOf(dataBufferRef.b), Integer.valueOf(this.b)) && Objects.equal(Integer.valueOf(dataBufferRef.c), Integer.valueOf(this.c)) && dataBufferRef.a == this.a) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public byte[] f(String str) {
        return this.a.getByteArray(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public Uri g(String str) {
        String string = this.a.getString(str, this.b, this.c);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public boolean h(String str) {
        return this.a.hasNull(str, this.b, this.c);
    }

    @KeepForSdk
    public boolean hasColumn(String str) {
        return this.a.hasColumn(str);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.b), Integer.valueOf(this.c), this.a);
    }

    @KeepForSdk
    public boolean isDataValid() {
        return !this.a.isClosed();
    }
}
