package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.List;
import java.util.NoSuchElementException;

@NotThreadSafe
/* loaded from: classes.dex */
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List<Header> allHeaders;
    protected String headerName;
    protected int currentIndex = findNext(-1);
    protected int lastIndex = -1;

    public BasicListHeaderIterator(List<Header> list, String str) {
        this.allHeaders = (List) Args.notNull(list, "Header list");
        this.headerName = str;
    }

    protected boolean filterHeader(int i) {
        if (this.headerName == null) {
            return true;
        }
        return this.headerName.equalsIgnoreCase(this.allHeaders.get(i).getName());
    }

    protected int findNext(int i) {
        if (i < -1) {
            return -1;
        }
        int size = this.allHeaders.size() - 1;
        boolean z = false;
        while (!z && i < size) {
            i++;
            z = filterHeader(i);
        }
        if (!z) {
            return -1;
        }
        return i;
    }

    @Override // cz.msebera.android.httpclient.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        return this.currentIndex >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        return nextHeader();
    }

    @Override // cz.msebera.android.httpclient.HeaderIterator
    public Header nextHeader() {
        int i = this.currentIndex;
        if (i >= 0) {
            this.lastIndex = i;
            this.currentIndex = findNext(i);
            return this.allHeaders.get(i);
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public void remove() {
        Asserts.check(this.lastIndex >= 0, "No header to remove");
        this.allHeaders.remove(this.lastIndex);
        this.lastIndex = -1;
        this.currentIndex--;
    }
}
