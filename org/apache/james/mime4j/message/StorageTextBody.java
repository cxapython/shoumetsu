package org.apache.james.mime4j.message;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import org.apache.james.mime4j.codec.CodecUtil;
import org.apache.james.mime4j.storage.MultiReferenceStorage;
import org.apache.james.mime4j.util.CharsetUtil;

/* loaded from: classes.dex */
class StorageTextBody extends TextBody {
    private Charset charset;
    private MultiReferenceStorage storage;

    public StorageTextBody(MultiReferenceStorage multiReferenceStorage, Charset charset) {
        this.storage = multiReferenceStorage;
        this.charset = charset;
    }

    @Override // org.apache.james.mime4j.message.SingleBody
    /* renamed from: copy  reason: collision with other method in class */
    public StorageTextBody mo66copy() {
        this.storage.addReference();
        return new StorageTextBody(this.storage, this.charset);
    }

    @Override // org.apache.james.mime4j.message.SingleBody, org.apache.james.mime4j.message.Disposable
    public void dispose() {
        MultiReferenceStorage multiReferenceStorage = this.storage;
        if (multiReferenceStorage != null) {
            multiReferenceStorage.delete();
            this.storage = null;
        }
    }

    @Override // org.apache.james.mime4j.message.TextBody
    public String getMimeCharset() {
        return CharsetUtil.toMimeCharset(this.charset.name());
    }

    @Override // org.apache.james.mime4j.message.TextBody
    public Reader getReader() {
        return new InputStreamReader(this.storage.getInputStream(), this.charset);
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
