package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.content.AbstractContentBody;
import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;

/* loaded from: classes.dex */
public class FormBodyPart {
    private final ContentBody body;
    private final Header header;
    private final String name;

    @Deprecated
    public FormBodyPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Body");
        this.name = str;
        this.body = contentBody;
        this.header = new Header();
        generateContentDisp(contentBody);
        generateContentType(contentBody);
        generateTransferEncoding(contentBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormBodyPart(String str, ContentBody contentBody, Header header) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Body");
        this.name = str;
        this.body = contentBody;
        this.header = header == null ? new Header() : header;
    }

    public void addField(String str, String str2) {
        Args.notNull(str, "Field name");
        this.header.addField(new MinimalField(str, str2));
    }

    @Deprecated
    protected void generateContentDisp(ContentBody contentBody) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(getName());
        sb.append("\"");
        if (contentBody.getFilename() != null) {
            sb.append("; filename=\"");
            sb.append(contentBody.getFilename());
            sb.append("\"");
        }
        addField("Content-Disposition", sb.toString());
    }

    @Deprecated
    protected void generateContentType(ContentBody contentBody) {
        String str;
        String sb;
        ContentType contentType = contentBody instanceof AbstractContentBody ? ((AbstractContentBody) contentBody).getContentType() : null;
        if (contentType != null) {
            str = "Content-Type";
            sb = contentType.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(contentBody.getMimeType());
            if (contentBody.getCharset() != null) {
                sb2.append(HTTP.CHARSET_PARAM);
                sb2.append(contentBody.getCharset());
            }
            str = "Content-Type";
            sb = sb2.toString();
        }
        addField(str, sb);
    }

    @Deprecated
    protected void generateTransferEncoding(ContentBody contentBody) {
        addField("Content-Transfer-Encoding", contentBody.getTransferEncoding());
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public String getName() {
        return this.name;
    }
}
