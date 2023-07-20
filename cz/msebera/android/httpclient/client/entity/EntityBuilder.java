package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.FileEntity;
import cz.msebera.android.httpclient.entity.InputStreamEntity;
import cz.msebera.android.httpclient.entity.SerializableEntity;
import cz.msebera.android.httpclient.entity.StringEntity;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@NotThreadSafe
/* loaded from: classes.dex */
public class EntityBuilder {
    private byte[] binary;
    private boolean chunked;
    private String contentEncoding;
    private ContentType contentType;
    private File file;
    private boolean gzipCompress;
    private List<NameValuePair> parameters;
    private Serializable serializable;
    private InputStream stream;
    private String text;

    EntityBuilder() {
    }

    private void clearContent() {
        this.text = null;
        this.binary = null;
        this.stream = null;
        this.parameters = null;
        this.serializable = null;
        this.file = null;
    }

    public static EntityBuilder create() {
        return new EntityBuilder();
    }

    private ContentType getContentOrDefault(ContentType contentType) {
        ContentType contentType2 = this.contentType;
        return contentType2 != null ? contentType2 : contentType;
    }

    public HttpEntity build() {
        AbstractHttpEntity fileEntity;
        ContentType contentType;
        String str = this.text;
        if (str != null) {
            fileEntity = new StringEntity(str, getContentOrDefault(ContentType.DEFAULT_TEXT));
        } else {
            byte[] bArr = this.binary;
            if (bArr != null) {
                fileEntity = new ByteArrayEntity(bArr, getContentOrDefault(ContentType.DEFAULT_BINARY));
            } else {
                InputStream inputStream = this.stream;
                if (inputStream != null) {
                    fileEntity = new InputStreamEntity(inputStream, -1L, getContentOrDefault(ContentType.DEFAULT_BINARY));
                } else {
                    List<NameValuePair> list = this.parameters;
                    if (list != null) {
                        ContentType contentType2 = this.contentType;
                        fileEntity = new UrlEncodedFormEntity(list, contentType2 != null ? contentType2.getCharset() : null);
                    } else {
                        Serializable serializable = this.serializable;
                        if (serializable != null) {
                            fileEntity = new SerializableEntity(serializable);
                            fileEntity.setContentType(ContentType.DEFAULT_BINARY.toString());
                        } else {
                            File file = this.file;
                            fileEntity = file != null ? new FileEntity(file, getContentOrDefault(ContentType.DEFAULT_BINARY)) : new BasicHttpEntity();
                        }
                    }
                }
            }
        }
        if (fileEntity.getContentType() != null && (contentType = this.contentType) != null) {
            fileEntity.setContentType(contentType.toString());
        }
        fileEntity.setContentEncoding(this.contentEncoding);
        fileEntity.setChunked(this.chunked);
        return this.gzipCompress ? new GzipCompressingEntity(fileEntity) : fileEntity;
    }

    public EntityBuilder chunked() {
        this.chunked = true;
        return this;
    }

    public byte[] getBinary() {
        return this.binary;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public File getFile() {
        return this.file;
    }

    public List<NameValuePair> getParameters() {
        return this.parameters;
    }

    public Serializable getSerializable() {
        return this.serializable;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public String getText() {
        return this.text;
    }

    public EntityBuilder gzipCompress() {
        this.gzipCompress = true;
        return this;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isGzipCompress() {
        return this.gzipCompress;
    }

    public EntityBuilder setBinary(byte[] bArr) {
        clearContent();
        this.binary = bArr;
        return this;
    }

    public EntityBuilder setContentEncoding(String str) {
        this.contentEncoding = str;
        return this;
    }

    public EntityBuilder setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public EntityBuilder setFile(File file) {
        clearContent();
        this.file = file;
        return this;
    }

    public EntityBuilder setParameters(List<NameValuePair> list) {
        clearContent();
        this.parameters = list;
        return this;
    }

    public EntityBuilder setParameters(NameValuePair... nameValuePairArr) {
        return setParameters(Arrays.asList(nameValuePairArr));
    }

    public EntityBuilder setSerializable(Serializable serializable) {
        clearContent();
        this.serializable = serializable;
        return this;
    }

    public EntityBuilder setStream(InputStream inputStream) {
        clearContent();
        this.stream = inputStream;
        return this;
    }

    public EntityBuilder setText(String str) {
        clearContent();
        this.text = str;
        return this;
    }
}
