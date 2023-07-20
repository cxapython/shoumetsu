package org.apache.james.mime4j.field.mimeversion.parser;

/* loaded from: classes.dex */
public class TokenMgrError extends Error {
    static final int INVALID_LEXICAL_STATE = 2;
    static final int LEXICAL_ERROR = 0;
    static final int LOOP_DETECTED = 3;
    static final int STATIC_LEXER_ERROR = 1;
    int errorCode;

    public TokenMgrError() {
    }

    public TokenMgrError(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public TokenMgrError(boolean z, int i, int i2, int i3, String str, char c, int i4) {
        this(LexicalError(z, i, i2, i3, str, c), i4);
    }

    protected static String LexicalError(boolean z, int i, int i2, int i3, String str, char c) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("Lexical error at line ");
        sb.append(i2);
        sb.append(", column ");
        sb.append(i3);
        sb.append(".  Encountered: ");
        if (z) {
            str2 = "<EOF> ";
        } else {
            str2 = "\"" + addEscapes(String.valueOf(c)) + "\" (" + ((int) c) + "), ";
        }
        sb.append(str2);
        sb.append("after : \"");
        sb.append(addEscapes(str));
        sb.append("\"");
        return sb.toString();
    }

    protected static final String addEscapes(String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != 0) {
                if (charAt == '\"') {
                    str2 = "\\\"";
                } else if (charAt == '\'') {
                    str2 = "\\'";
                } else if (charAt != '\\') {
                    switch (charAt) {
                        case '\b':
                            str2 = "\\b";
                            break;
                        case '\t':
                            str2 = "\\t";
                            break;
                        case '\n':
                            str2 = "\\n";
                            break;
                        default:
                            switch (charAt) {
                                case '\f':
                                    str2 = "\\f";
                                    break;
                                case '\r':
                                    str2 = "\\r";
                                    break;
                                default:
                                    char charAt2 = str.charAt(i);
                                    if (charAt2 < ' ' || charAt2 > '~') {
                                        String str3 = "0000" + Integer.toString(charAt2, 16);
                                        str2 = "\\u" + str3.substring(str3.length() - 4, str3.length());
                                        break;
                                    } else {
                                        stringBuffer.append(charAt2);
                                        break;
                                    }
                            }
                    }
                } else {
                    str2 = "\\\\";
                }
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }
}
