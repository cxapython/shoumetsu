package org.apache.james.mime4j.descriptor;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.james.mime4j.field.ContentTypeField;
import org.apache.james.mime4j.parser.Field;
import org.apache.james.mime4j.util.MimeUtil;

/* loaded from: classes.dex */
public class DefaultBodyDescriptor implements MutableBodyDescriptor {
    private static final String DEFAULT_MEDIA_TYPE = "text";
    private static final String DEFAULT_MIME_TYPE = "text/plain";
    private static final String DEFAULT_SUB_TYPE = "plain";
    private static final String EMAIL_MESSAGE_MIME_TYPE = "message/rfc822";
    private static final String MEDIA_TYPE_MESSAGE = "message";
    private static final String MEDIA_TYPE_TEXT = "text";
    private static final String SUB_TYPE_EMAIL = "rfc822";
    private static final String US_ASCII = "us-ascii";
    private static Log log = LogFactory.getLog(DefaultBodyDescriptor.class);
    private String boundary;
    private String charset;
    private long contentLength;
    private boolean contentTransferEncSet;
    private boolean contentTypeSet;
    private String mediaType;
    private String mimeType;
    private Map<String, String> parameters;
    private String subType;
    private String transferEncoding;

    public DefaultBodyDescriptor() {
        this(null);
    }

    public DefaultBodyDescriptor(BodyDescriptor bodyDescriptor) {
        String str;
        this.mediaType = "text";
        this.subType = DEFAULT_SUB_TYPE;
        this.mimeType = "text/plain";
        this.boundary = null;
        this.charset = US_ASCII;
        this.transferEncoding = MimeUtil.ENC_7BIT;
        this.parameters = new HashMap();
        this.contentLength = -1L;
        if (bodyDescriptor == null || !MimeUtil.isSameMimeType(ContentTypeField.TYPE_MULTIPART_DIGEST, bodyDescriptor.getMimeType())) {
            this.mimeType = "text/plain";
            this.subType = DEFAULT_SUB_TYPE;
            str = "text";
        } else {
            this.mimeType = "message/rfc822";
            this.subType = SUB_TYPE_EMAIL;
            str = "message";
        }
        this.mediaType = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseContentType(String str) {
        String str2;
        String str3;
        String str4;
        this.contentTypeSet = true;
        Map<String, String> headerParams = MimeUtil.getHeaderParams(str);
        String str5 = headerParams.get("");
        if (str5 != null) {
            str5 = str5.toLowerCase().trim();
            int indexOf = str5.indexOf(47);
            boolean z = false;
            if (indexOf != -1) {
                str3 = str5.substring(0, indexOf).trim();
                str2 = str5.substring(indexOf + 1).trim();
                if (str3.length() > 0 && str2.length() > 0) {
                    str5 = str3 + "/" + str2;
                    z = true;
                }
            } else {
                str2 = null;
                str3 = null;
            }
            if (!z) {
                str5 = null;
                str2 = null;
            }
            String str6 = headerParams.get(ContentTypeField.PARAM_BOUNDARY);
            if (str5 != null && ((str5.startsWith(ContentTypeField.TYPE_MULTIPART_PREFIX) && str6 != null) || !str5.startsWith(ContentTypeField.TYPE_MULTIPART_PREFIX))) {
                this.mimeType = str5;
                this.subType = str2;
                this.mediaType = str3;
            }
            if (MimeUtil.isMultipart(this.mimeType)) {
                this.boundary = str6;
            }
            str4 = headerParams.get(ContentTypeField.PARAM_CHARSET);
            this.charset = null;
            if (str4 != null) {
                String trim = str4.trim();
                if (trim.length() > 0) {
                    this.charset = trim.toLowerCase();
                }
            }
            if (this.charset == null && "text".equals(this.mediaType)) {
                this.charset = US_ASCII;
            }
            this.parameters.putAll(headerParams);
            this.parameters.remove("");
            this.parameters.remove(ContentTypeField.PARAM_BOUNDARY);
            this.parameters.remove(ContentTypeField.PARAM_CHARSET);
        }
        str2 = null;
        str3 = str2;
        String str62 = headerParams.get(ContentTypeField.PARAM_BOUNDARY);
        if (str5 != null) {
            this.mimeType = str5;
            this.subType = str2;
            this.mediaType = str3;
        }
        if (MimeUtil.isMultipart(this.mimeType)) {
        }
        str4 = headerParams.get(ContentTypeField.PARAM_CHARSET);
        this.charset = null;
        if (str4 != null) {
        }
        if (this.charset == null) {
            this.charset = US_ASCII;
        }
        this.parameters.putAll(headerParams);
        this.parameters.remove("");
        this.parameters.remove(ContentTypeField.PARAM_BOUNDARY);
        this.parameters.remove(ContentTypeField.PARAM_CHARSET);
    }

    @Override // org.apache.james.mime4j.descriptor.MutableBodyDescriptor
    public void addField(Field field) {
        String name = field.getName();
        String body = field.getBody();
        String lowerCase = name.trim().toLowerCase();
        if (lowerCase.equals("content-transfer-encoding") && !this.contentTransferEncSet) {
            this.contentTransferEncSet = true;
            String lowerCase2 = body.trim().toLowerCase();
            if (lowerCase2.length() <= 0) {
                return;
            }
            this.transferEncoding = lowerCase2;
        } else if (!lowerCase.equals("content-length") || this.contentLength != -1) {
            if (!lowerCase.equals("content-type") || this.contentTypeSet) {
                return;
            }
            parseContentType(body);
        } else {
            try {
                this.contentLength = Long.parseLong(body.trim());
            } catch (NumberFormatException unused) {
                Log log2 = log;
                log2.error("Invalid content-length: " + body);
            }
        }
    }

    @Override // org.apache.james.mime4j.descriptor.BodyDescriptor
    public String getBoundary() {
        return this.boundary;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getCharset() {
        return this.charset;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public Map<String, String> getContentTypeParameters() {
        return this.parameters;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getSubType() {
        return this.subType;
    }

    @Override // org.apache.james.mime4j.descriptor.ContentDescriptor
    public String getTransferEncoding() {
        return this.transferEncoding;
    }

    public String toString() {
        return this.mimeType;
    }
}
