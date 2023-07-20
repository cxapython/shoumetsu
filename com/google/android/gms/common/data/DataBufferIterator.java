package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferIterator<T> implements Iterator<T> {
    protected final DataBuffer<T> a;
    protected int b = -1;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        this.a = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.getCount() - 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.a;
            int i = this.b + 1;
            this.b = i;
            return dataBuffer.mo27get(i);
        }
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i2);
        throw new NoSuchElementException(sb.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
