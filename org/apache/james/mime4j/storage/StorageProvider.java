package org.apache.james.mime4j.storage;

import java.io.InputStream;

/* loaded from: classes.dex */
public interface StorageProvider {
    StorageOutputStream createStorageOutputStream();

    Storage store(InputStream inputStream);
}
