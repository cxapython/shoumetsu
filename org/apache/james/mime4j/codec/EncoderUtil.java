package org.apache.james.mime4j.codec;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.Locale;
import org.apache.james.mime4j.util.CharsetUtil;

/* loaded from: classes.dex */
public class EncoderUtil {
    private static final char BASE64_PAD = '=';
    private static final int ENCODED_WORD_MAX_LENGTH = 75;
    private static final String ENC_WORD_PREFIX = "=?";
    private static final String ENC_WORD_SUFFIX = "?=";
    private static final int MAX_USED_CHARACTERS = 50;
    private static final byte[] BASE64_TABLE = Base64OutputStream.BASE64_TABLE;
    private static final BitSet Q_REGULAR_CHARS = initChars("=_?");
    private static final BitSet Q_RESTRICTED_CHARS = initChars("=_?\"#$%&'(),.:;<>@[\\]^`{|}~");
    private static final BitSet TOKEN_CHARS = initChars("()<>@,;:\\\"/[]?=");
    private static final BitSet ATEXT_CHARS = initChars("()<>@.,;:\\\"[]");

    /* loaded from: classes.dex */
    public enum Encoding {
        B,
        Q
    }

    /* loaded from: classes.dex */
    public enum Usage {
        TEXT_TOKEN,
        WORD_ENTITY
    }

    private EncoderUtil() {
    }

    private static int bEncodedLength(byte[] bArr) {
        return ((bArr.length + 2) / 3) * 4;
    }

    private static Charset determineCharset(String str) {
        int length = str.length();
        boolean z = true;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt > 255) {
                return CharsetUtil.UTF_8;
            }
            if (charAt > 127) {
                z = false;
            }
        }
        return z ? CharsetUtil.US_ASCII : CharsetUtil.ISO_8859_1;
    }

    private static Encoding determineEncoding(byte[] bArr, Usage usage) {
        if (bArr.length == 0) {
            return Encoding.Q;
        }
        BitSet bitSet = usage == Usage.TEXT_TOKEN ? Q_REGULAR_CHARS : Q_RESTRICTED_CHARS;
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & 255;
            if (i2 != 32 && !bitSet.get(i2)) {
                i++;
            }
        }
        return (i * 100) / bArr.length > 30 ? Encoding.B : Encoding.Q;
    }

    private static byte[] encode(String str, Charset charset) {
        ByteBuffer encode = charset.encode(str);
        byte[] bArr = new byte[encode.limit()];
        encode.get(bArr);
        return bArr;
    }

    public static String encodeAddressDisplayName(String str) {
        return isAtomPhrase(str) ? str : hasToBeEncoded(str, 0) ? encodeEncodedWord(str, Usage.WORD_ENTITY) : quote(str);
    }

    public static String encodeAddressLocalPart(String str) {
        return isDotAtomText(str) ? str : quote(str);
    }

    private static String encodeB(String str, String str2, int i, Charset charset, byte[] bArr) {
        String encodeB;
        StringBuilder sb;
        if (str.length() + bEncodedLength(bArr) + 2 <= 75 - i) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append(encodeB(bArr));
            encodeB = ENC_WORD_SUFFIX;
        } else {
            String substring = str2.substring(0, str2.length() / 2);
            String encodeB2 = encodeB(str, substring, i, charset, encode(substring, charset));
            String substring2 = str2.substring(str2.length() / 2);
            encodeB = encodeB(str, substring2, 0, charset, encode(substring2, charset));
            sb = new StringBuilder();
            sb.append(encodeB2);
            sb.append(" ");
        }
        sb.append(encodeB);
        return sb.toString();
    }

    public static String encodeB(byte[] bArr) {
        int i;
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            i = length - 2;
            if (i2 >= i) {
                break;
            }
            int i3 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
            sb.append((char) BASE64_TABLE[(i3 >> 18) & 63]);
            sb.append((char) BASE64_TABLE[(i3 >> 12) & 63]);
            sb.append((char) BASE64_TABLE[(i3 >> 6) & 63]);
            sb.append((char) BASE64_TABLE[i3 & 63]);
            i2 += 3;
        }
        if (i2 != i) {
            if (i2 == length - 1) {
                int i4 = (bArr[i2] & 255) << 16;
                sb.append((char) BASE64_TABLE[(i4 >> 18) & 63]);
                sb.append((char) BASE64_TABLE[(i4 >> 12) & 63]);
                sb.append(BASE64_PAD);
            }
            return sb.toString();
        }
        int i5 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
        sb.append((char) BASE64_TABLE[(i5 >> 18) & 63]);
        sb.append((char) BASE64_TABLE[(i5 >> 12) & 63]);
        sb.append((char) BASE64_TABLE[(i5 >> 6) & 63]);
        sb.append(BASE64_PAD);
        return sb.toString();
    }

    public static String encodeEncodedWord(String str, Usage usage) {
        return encodeEncodedWord(str, usage, 0, null, null);
    }

    public static String encodeEncodedWord(String str, Usage usage, int i) {
        return encodeEncodedWord(str, usage, i, null, null);
    }

    public static String encodeEncodedWord(String str, Usage usage, int i, Charset charset, Encoding encoding) {
        if (str != null) {
            if (i < 0 || i > 50) {
                throw new IllegalArgumentException();
            }
            if (charset == null) {
                charset = determineCharset(str);
            }
            Charset charset2 = charset;
            String mimeCharset = CharsetUtil.toMimeCharset(charset2.name());
            if (mimeCharset == null) {
                throw new IllegalArgumentException("Unsupported charset");
            }
            byte[] encode = encode(str, charset2);
            if (encoding == null) {
                encoding = determineEncoding(encode, usage);
            }
            if (encoding == Encoding.B) {
                return encodeB(ENC_WORD_PREFIX + mimeCharset + "?B?", str, i, charset2, encode);
            }
            return encodeQ(ENC_WORD_PREFIX + mimeCharset + "?Q?", str, usage, i, charset2, encode);
        }
        throw new IllegalArgumentException();
    }

    public static String encodeHeaderParameter(String str, String str2) {
        StringBuilder sb;
        String lowerCase = str.toLowerCase(Locale.US);
        if (isToken(str2)) {
            sb = new StringBuilder();
            sb.append(lowerCase);
            sb.append("=");
            sb.append(str2);
        } else {
            sb = new StringBuilder();
            sb.append(lowerCase);
            sb.append("=");
            sb.append(quote(str2));
        }
        return sb.toString();
    }

    public static String encodeIfNecessary(String str, Usage usage, int i) {
        return hasToBeEncoded(str, i) ? encodeEncodedWord(str, usage, i) : str;
    }

    private static String encodeQ(String str, String str2, Usage usage, int i, Charset charset, byte[] bArr) {
        String encodeQ;
        StringBuilder sb;
        if (str.length() + qEncodedLength(bArr, usage) + 2 <= 75 - i) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append(encodeQ(bArr, usage));
            encodeQ = ENC_WORD_SUFFIX;
        } else {
            String substring = str2.substring(0, str2.length() / 2);
            String encodeQ2 = encodeQ(str, substring, usage, i, charset, encode(substring, charset));
            String substring2 = str2.substring(str2.length() / 2);
            encodeQ = encodeQ(str, substring2, usage, 0, charset, encode(substring2, charset));
            sb = new StringBuilder();
            sb.append(encodeQ2);
            sb.append(" ");
        }
        sb.append(encodeQ);
        return sb.toString();
    }

    public static String encodeQ(byte[] bArr, Usage usage) {
        char c;
        BitSet bitSet = usage == Usage.TEXT_TOKEN ? Q_REGULAR_CHARS : Q_RESTRICTED_CHARS;
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            int i = b & 255;
            if (i == 32) {
                c = '_';
            } else if (!bitSet.get(i)) {
                sb.append(BASE64_PAD);
                sb.append(hexDigit(i >>> 4));
                c = hexDigit(i & 15);
            } else {
                c = (char) i;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static boolean hasToBeEncoded(String str, int i) {
        if (str != null) {
            if (i < 0 || i > 50) {
                throw new IllegalArgumentException();
            }
            int i2 = i;
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '\t' || charAt == ' ') {
                    i2 = 0;
                } else {
                    i2++;
                    if (i2 > 77 || charAt < ' ' || charAt >= 127) {
                        return true;
                    }
                }
            }
            return false;
        }
        throw new IllegalArgumentException();
    }

    private static char hexDigit(int i) {
        return (char) (i < 10 ? i + 48 : (i - 10) + 65);
    }

    private static BitSet initChars(String str) {
        BitSet bitSet = new BitSet(128);
        for (char c = '!'; c < 127; c = (char) (c + 1)) {
            if (str.indexOf(c) == -1) {
                bitSet.set(c);
            }
        }
        return bitSet;
    }

    private static boolean isAtomPhrase(String str) {
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (ATEXT_CHARS.get(charAt)) {
                z = true;
            } else if (!CharsetUtil.isWhitespace(charAt)) {
                return false;
            }
        }
        return z;
    }

    private static boolean isDotAtomText(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        char c = '.';
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '.') {
                if (c == '.' || i == length - 1) {
                    return false;
                }
            } else if (!ATEXT_CHARS.get(charAt)) {
                return false;
            }
            i++;
            c = charAt;
        }
        return true;
    }

    public static boolean isToken(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!TOKEN_CHARS.get(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static int qEncodedLength(byte[] bArr, Usage usage) {
        BitSet bitSet = usage == Usage.TEXT_TOKEN ? Q_REGULAR_CHARS : Q_RESTRICTED_CHARS;
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & 255;
            i = (i2 != 32 && !bitSet.get(i2)) ? i + 3 : i + 1;
        }
        return i;
    }

    private static String quote(String str) {
        String replaceAll = str.replaceAll("[\\\\\"]", "\\\\$0");
        return "\"" + replaceAll + "\"";
    }
}
