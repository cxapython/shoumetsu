package org.apache.james.mime4j.message;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.james.mime4j.codec.CodecUtil;
import org.apache.james.mime4j.storage.MultiReferenceStorage;

/* loaded from: classes.dex */
class StorageBinaryBody extends BinaryBody {
    private MultiReferenceStorage storage;

    public StorageBinaryBody(MultiReferenceStorage multiReferenceStorage) {
        this.storage = multiReferenceStorage;
    }

    @Override // org.apache.james.mime4j.message.SingleBody
    /* renamed from: copy  reason: collision with other method in class */
    public StorageBinaryBody mo66copy() {
        this.storage.addReference();
        return new StorageBinaryBody(this.storage);
    }

    @Override // org.apache.james.mime4j.message.SingleBody, org.apache.james.mime4j.message.Disposable
    public void dispose() {
        MultiReferenceStorage multiReferenceStorage = this.storage;
        if (multiReferenceStorage != null) {
            multiReferenceStorage.delete();
            this.storage = null;
        }
    }

    @Override // org.apache.james.mime4j.message.BinaryBody
    public InputStream getInputStream() {
        return this.storage.getInputStream();
    }

    @Override // org.apache.james.mime4j.message.SingleBody
    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            InputStream inputStream = this.storage.getInputStream();
            CodecUtil.copy(inputStream, outputStream);
            inputStream.close();
            return;
        }
        throw new IllegalArgumentException();
    }
}
