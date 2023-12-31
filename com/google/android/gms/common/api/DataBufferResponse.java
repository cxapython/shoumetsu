package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
    @KeepForSdk
    public DataBufferResponse() {
    }

    /* JADX WARN: Incorrect types in method signature: (TR;)V */
    /* JADX WARN: Multi-variable type inference failed */
    @KeepForSdk
    public DataBufferResponse(AbstractDataBuffer abstractDataBuffer) {
        super(abstractDataBuffer);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public void close() {
        ((AbstractDataBuffer) a()).close();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: get */
    public T mo27get(int i) {
        return (T) ((AbstractDataBuffer) a()).mo27get(i);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        return ((AbstractDataBuffer) a()).getCount();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Bundle getMetadata() {
        return ((AbstractDataBuffer) a()).getMetadata();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public boolean isClosed() {
        return ((AbstractDataBuffer) a()).isClosed();
    }

    @Override // com.google.android.gms.common.data.DataBuffer, java.lang.Iterable
    public Iterator<T> iterator() {
        return ((AbstractDataBuffer) a()).iterator();
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        ((AbstractDataBuffer) a()).release();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Iterator<T> singleRefIterator() {
        return ((AbstractDataBuffer) a()).singleRefIterator();
    }
}
