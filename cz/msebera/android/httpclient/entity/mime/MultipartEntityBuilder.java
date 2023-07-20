package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.content.ByteArrayBody;
import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.entity.mime.content.FileBody;
import cz.msebera.android.httpclient.entity.mime.content.InputStreamBody;
import cz.msebera.android.httpclient.entity.mime.content.StringBody;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.util.Args;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.james.mime4j.field.ContentTypeField;

/* loaded from: classes.dex */
public class MultipartEntityBuilder {
    private static final String DEFAULT_SUBTYPE = "form-data";
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private ContentType contentType;
    private HttpMultipartMode mode = HttpMultipartMode.STRICT;
    private String boundary = null;
    private Charset charset = null;
    private List<FormBodyPart> bodyParts = null;

    MultipartEntityBuilder() {
    }

    public static MultipartEntityBuilder create() {
        return new MultipartEntityBuilder();
    }

    private String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file) {
        return addBinaryBody(str, file, ContentType.DEFAULT_BINARY, file != null ? file.getName() : null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file, ContentType contentType, String str2) {
        return addPart(str, new FileBody(file, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream) {
        return addBinaryBody(str, inputStream, ContentType.DEFAULT_BINARY, (String) null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream, ContentType contentType, String str2) {
        return addPart(str, new InputStreamBody(inputStream, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr) {
        return addBinaryBody(str, bArr, ContentType.DEFAULT_BINARY, (String) null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr, ContentType contentType, String str2) {
        return addPart(str, new ByteArrayBody(bArr, contentType, str2));
    }

    public MultipartEntityBuilder addPart(FormBodyPart formBodyPart) {
        if (formBodyPart == null) {
            return this;
        }
        if (this.bodyParts == null) {
            this.bodyParts = new ArrayList();
        }
        this.bodyParts.add(formBodyPart);
        return this;
    }

    public MultipartEntityBuilder addPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Content body");
        return addPart(FormBodyPartBuilder.create(str, contentBody).build());
    }

    public MultipartEntityBuilder addTextBody(String str, String str2) {
        return addTextBody(str, str2, ContentType.DEFAULT_TEXT);
    }

    public MultipartEntityBuilder addTextBody(String str, String str2, ContentType contentType) {
        return addPart(str, new StringBody(str2, contentType));
    }

    public HttpEntity build() {
        return buildEntity();
    }

    MultipartFormEntity buildEntity() {
        AbstractMultipartForm httpBrowserCompatibleMultipart;
        ContentType contentType;
        ContentType contentType2;
        String str = this.boundary;
        if (str == null && (contentType2 = this.contentType) != null) {
            str = contentType2.getParameter(ContentTypeField.PARAM_BOUNDARY);
        }
        if (str == null) {
            str = generateBoundary();
        }
        Charset charset = this.charset;
        if (charset == null && (contentType = this.contentType) != null) {
            charset = contentType.getCharset();
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new BasicNameValuePair(ContentTypeField.PARAM_BOUNDARY, str));
        if (charset != null) {
            arrayList.add(new BasicNameValuePair(ContentTypeField.PARAM_CHARSET, charset.name()));
        }
        NameValuePair[] nameValuePairArr = (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]);
        ContentType contentType3 = this.contentType;
        ContentType withParameters = contentType3 != null ? contentType3.withParameters(nameValuePairArr) : ContentType.create("multipart/form-data", nameValuePairArr);
        List<FormBodyPart> list = this.bodyParts;
        List arrayList2 = list != null ? new ArrayList(list) : Collections.emptyList();
        HttpMultipartMode httpMultipartMode = this.mode;
        if (httpMultipartMode == null) {
            httpMultipartMode = HttpMultipartMode.STRICT;
        }
        switch (httpMultipartMode) {
            case BROWSER_COMPATIBLE:
                httpBrowserCompatibleMultipart = new HttpBrowserCompatibleMultipart(charset, str, arrayList2);
                break;
            case RFC6532:
                httpBrowserCompatibleMultipart = new HttpRFC6532Multipart(charset, str, arrayList2);
                break;
            default:
                httpBrowserCompatibleMultipart = new HttpStrictMultipart(charset, str, arrayList2);
                break;
        }
        return new MultipartFormEntity(httpBrowserCompatibleMultipart, withParameters, httpBrowserCompatibleMultipart.getTotalLength());
    }

    public MultipartEntityBuilder seContentType(ContentType contentType) {
        Args.notNull(contentType, "Content type");
        this.contentType = contentType;
        return this;
    }

    public MultipartEntityBuilder setBoundary(String str) {
        this.boundary = str;
        return this;
    }

    public MultipartEntityBuilder setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public MultipartEntityBuilder setLaxMode() {
        this.mode = HttpMultipartMode.BROWSER_COMPATIBLE;
        return this;
    }

    public MultipartEntityBuilder setMimeSubtype(String str) {
        Args.notBlank(str, "MIME subtype");
        this.contentType = ContentType.create(ContentTypeField.TYPE_MULTIPART_PREFIX + str);
        return this;
    }

    public MultipartEntityBuilder setMode(HttpMultipartMode httpMultipartMode) {
        this.mode = httpMultipartMode;
        return this;
    }

    public MultipartEntityBuilder setStrictMode() {
        this.mode = HttpMultipartMode.STRICT;
        return this;
    }
}
