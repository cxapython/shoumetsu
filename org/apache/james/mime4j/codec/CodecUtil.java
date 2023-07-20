package org.apache.james.mime4j.codec;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class CodecUtil {
    static final int DEFAULT_ENCODING_BUFFER_SIZE = 1024;

    public static void copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[DEFAULT_ENCODING_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void encodeBase64(InputStream inputStream, OutputStream outputStream) {
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream);
        copy(inputStream, base64OutputStream);
        base64OutputStream.close();
    }

    public static void encodeQuotedPrintable(InputStream inputStream, OutputStream outputStream) {
        new QuotedPrintableEncoder(DEFAULT_ENCODING_BUFFER_SIZE, false).encode(inputStream, outputStream);
    }

    public static void encodeQuotedPrintableBinary(InputStream inputStream, OutputStream outputStream) {
        new QuotedPrintableEncoder(DEFAULT_ENCODING_BUFFER_SIZE, true).encode(inputStream, outputStream);
    }

    public static OutputStream wrapBase64(OutputStream outputStream) {
        return new Base64OutputStream(outputStream);
    }

    public static OutputStream wrapQuotedPrintable(OutputStream outputStream, boolean z) {
        return new QuotedPrintableOutputStream(outputStream, z);
    }
}
