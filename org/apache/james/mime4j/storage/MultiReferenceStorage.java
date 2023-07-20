package org.apache.james.mime4j.storage;

import java.io.InputStream;

/* loaded from: classes.dex */
public class MultiReferenceStorage implements Storage {
    private int referenceCounter;
    private final Storage storage;

    public MultiReferenceStorage(Storage storage) {
        if (storage != null) {
            this.storage = storage;
            this.referenceCounter = 1;
            return;
        }
        throw new IllegalArgumentException();
    }

    private synchronized boolean decrementCounter() {
        boolean z;
        if (this.referenceCounter == 0) {
            throw new IllegalStateException("storage has been deleted");
        }
        z = true;
        int i = this.referenceCounter - 1;
        this.referenceCounter = i;
        if (i != 0) {
            z = false;
        }
        return z;
    }

    private synchronized void incrementCounter() {
        if (this.referenceCounter == 0) {
            throw new IllegalStateException("storage has been deleted");
        }
        this.referenceCounter++;
    }

    public void addReference() {
        incrementCounter();
    }

    @Override // org.apache.james.mime4j.storage.Storage
    public void delete() {
        if (decrementCounter()) {
            this.storage.delete();
        }
    }

    @Override // org.apache.james.mime4j.storage.Storage
    public InputStream getInputStream() {
        return this.storage.getInputStream();
    }
}
