package org.apache.james.mime4j.storage;

import java.io.InputStream;
import org.apache.james.mime4j.codec.CodecUtil;

/* loaded from: classes.dex */
public abstract class AbstractStorageProvider implements StorageProvider {
    @Override // org.apache.james.mime4j.storage.StorageProvider
    public final Storage store(InputStream inputStream) {
        StorageOutputStream createStorageOutputStream = createStorageOutputStream();
        CodecUtil.copy(inputStream, createStorageOutputStream);
        return createStorageOutputStream.toStorage();
    }
}
