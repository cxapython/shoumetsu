package org.apache.james.mime4j.util;

import cz.msebera.android.httpclient.message.TokenParser;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.james.mime4j.field.ContentTypeField;

/* loaded from: classes.dex */
public final class MimeUtil {
    public static final String ENC_7BIT = "7bit";
    public static final String ENC_8BIT = "8bit";
    public static final String ENC_BASE64 = "base64";
    public static final String ENC_BINARY = "binary";
    public static final String ENC_QUOTED_PRINTABLE = "quoted-printable";
    public static final String MIME_HEADER_CONTENT_DESCRIPTION = "content-description";
    public static final String MIME_HEADER_CONTENT_DISPOSITION = "content-disposition";
    public static final String MIME_HEADER_CONTENT_ID = "content-id";
    public static final String MIME_HEADER_LANGAUGE = "content-language";
    public static final String MIME_HEADER_LOCATION = "content-location";
    public static final String MIME_HEADER_MD5 = "content-md5";
    public static final String MIME_HEADER_MIME_VERSION = "mime-version";
    public static final String PARAM_CREATION_DATE = "creation-date";
    public static final String PARAM_FILENAME = "filename";
    public static final String PARAM_MODIFICATION_DATE = "modification-date";
    public static final String PARAM_READ_DATE = "read-date";
    public static final String PARAM_SIZE = "size";
    private static final Log log = LogFactory.getLog(MimeUtil.class);
    private static final Random random = new Random();
    private static int counter = 0;
    private static final ThreadLocal<DateFormat> RFC822_DATE_FORMAT = new ThreadLocal<DateFormat>() { // from class: org.apache.james.mime4j.util.MimeUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            return new Rfc822DateFormat();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Rfc822DateFormat extends SimpleDateFormat {
        private static final long serialVersionUID = 1;

        public Rfc822DateFormat() {
            super("EEE, d MMM yyyy HH:mm:ss ", Locale.US);
        }

        @Override // java.text.SimpleDateFormat, java.text.DateFormat
        public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            StringBuffer format = super.format(date, stringBuffer, fieldPosition);
            int i = ((this.calendar.get(15) + this.calendar.get(16)) / 1000) / 60;
            if (i < 0) {
                format.append('-');
                i = -i;
            } else {
                format.append('+');
            }
            format.append(String.format("%02d%02d", Integer.valueOf(i / 60), Integer.valueOf(i % 60)));
            return format;
        }
    }

    private MimeUtil() {
    }

    public static String createUniqueBoundary() {
        return "-=Part." + Integer.toHexString(nextCounterValue()) + '.' + Long.toHexString(random.nextLong()) + '.' + Long.toHexString(System.currentTimeMillis()) + '.' + Long.toHexString(random.nextLong()) + "=-";
    }

    public static String createUniqueMessageId(String str) {
        StringBuilder sb = new StringBuilder("<Mime4j.");
        sb.append(Integer.toHexString(nextCounterValue()));
        sb.append('.');
        sb.append(Long.toHexString(random.nextLong()));
        sb.append('.');
        sb.append(Long.toHexString(System.currentTimeMillis()));
        if (str != null) {
            sb.append('@');
            sb.append(str);
        }
        sb.append('>');
        return sb.toString();
    }

    public static String fold(String str, int i) {
        int length = str.length();
        if (i + length <= 76) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = -i;
        int indexOfWsp = indexOfWsp(str, 0);
        while (indexOfWsp != length) {
            int indexOfWsp2 = indexOfWsp(str, indexOfWsp + 1);
            if (indexOfWsp2 - i2 > 76) {
                sb.append(str.substring(Math.max(0, i2), indexOfWsp));
                sb.append(CharsetUtil.CRLF);
                i2 = indexOfWsp;
            }
            indexOfWsp = indexOfWsp2;
        }
        sb.append(str.substring(Math.max(0, i2)));
        return sb.toString();
    }

    public static String formatDate(Date date, TimeZone timeZone) {
        DateFormat dateFormat = RFC822_DATE_FORMAT.get();
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(date);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d5, code lost:
        if (r3 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00dc, code lost:
        if (r11 != ';') goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> getHeaderParams(String str) {
        String substring;
        boolean z;
        char c;
        boolean z2;
        String unfold = unfold(str.trim());
        HashMap hashMap = new HashMap();
        if (unfold.indexOf(";") == -1) {
            substring = null;
        } else {
            String substring2 = unfold.substring(0, unfold.indexOf(";"));
            substring = unfold.substring(substring2.length() + 1);
            unfold = substring2;
        }
        hashMap.put("", unfold);
        if (substring != null) {
            char[] charArray = substring.toCharArray();
            StringBuilder sb = new StringBuilder(64);
            StringBuilder sb2 = new StringBuilder(64);
            int length = charArray.length;
            char c2 = 0;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                char c3 = charArray[i];
                if (c2 != 'c') {
                    switch (c2) {
                        case 0:
                            if (c3 == '=') {
                                log.error("Expected header param name, got '='");
                                c2 = 'c';
                                break;
                            } else {
                                sb.setLength(0);
                                sb2.setLength(0);
                                c2 = 1;
                            }
                        case 1:
                            if (c3 == '=') {
                                if (sb.length() != 0) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 'c';
                                break;
                            } else {
                                sb.append(c3);
                                break;
                            }
                        case 2:
                            if (c3 == '\t' || c3 == ' ') {
                                z2 = false;
                            } else if (c3 != '\"') {
                                z2 = true;
                                c2 = 3;
                            } else {
                                z2 = false;
                                c2 = 4;
                            }
                            if (!z2) {
                                break;
                            }
                        case 3:
                            if (c3 != '\t' && c3 != ' ' && c3 != ';') {
                                sb2.append(c3);
                                c = c2;
                                z = false;
                                break;
                            } else {
                                hashMap.put(sb.toString().trim().toLowerCase(), sb2.toString().trim());
                                z = true;
                                c = 5;
                                break;
                            }
                        case 4:
                            if (c3 != '\"') {
                                if (c3 != '\\') {
                                    if (z3) {
                                        sb2.append(TokenParser.ESCAPE);
                                    }
                                    sb2.append(c3);
                                    z3 = false;
                                    break;
                                } else {
                                    if (z3) {
                                        sb2.append(TokenParser.ESCAPE);
                                    }
                                    z3 = !z3;
                                    break;
                                }
                            } else {
                                if (!z3) {
                                    hashMap.put(sb.toString().trim().toLowerCase(), sb2.toString());
                                    c2 = 5;
                                    break;
                                }
                                sb2.append(c3);
                                z3 = false;
                            }
                        case 5:
                            c = c2;
                            if (c3 != '\t' && c3 != ' ') {
                            }
                            c2 = c;
                            break;
                    }
                } else {
                    if (c3 != ';') {
                    }
                    c2 = 0;
                }
            }
            if (c2 == 3) {
                hashMap.put(sb.toString().trim().toLowerCase(), sb2.toString().trim());
            }
        }
        return hashMap;
    }

    private static int indexOfWsp(String str, int i) {
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == ' ' || charAt == '\t') {
                return i;
            }
            i++;
        }
        return length;
    }

    public static boolean isBase64Encoding(String str) {
        return ENC_BASE64.equalsIgnoreCase(str);
    }

    public static boolean isMessage(String str) {
        return str != null && str.equalsIgnoreCase(ContentTypeField.TYPE_MESSAGE_RFC822);
    }

    public static boolean isMultipart(String str) {
        return str != null && str.toLowerCase().startsWith(ContentTypeField.TYPE_MULTIPART_PREFIX);
    }

    public static boolean isQuotedPrintableEncoded(String str) {
        return ENC_QUOTED_PRINTABLE.equalsIgnoreCase(str);
    }

    public static boolean isSameMimeType(String str, String str2) {
        return (str == null || str2 == null || !str.equalsIgnoreCase(str2)) ? false : true;
    }

    private static synchronized int nextCounterValue() {
        int i;
        synchronized (MimeUtil.class) {
            i = counter;
            counter = i + 1;
        }
        return i;
    }

    public static String unfold(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\r' || charAt == '\n') {
                return unfold0(str, i);
            }
        }
        return str;
    }

    private static String unfold0(String str, int i) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        if (i > 0) {
            sb.append(str.substring(0, i));
        }
        while (true) {
            i++;
            if (i < length) {
                char charAt = str.charAt(i);
                if (charAt != '\r' && charAt != '\n') {
                    sb.append(charAt);
                }
            } else {
                return sb.toString();
            }
        }
    }
}
