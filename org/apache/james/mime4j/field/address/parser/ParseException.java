package org.apache.james.mime4j.field.address.parser;

/* loaded from: classes.dex */
public class ParseException extends org.apache.james.mime4j.field.ParseException {
    private static final long serialVersionUID = 1;
    public Token currentToken;
    protected String eol;
    public int[][] expectedTokenSequences;
    protected boolean specialConstructor;
    public String[] tokenImage;

    public ParseException() {
        super("Cannot parse field");
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = false;
    }

    public ParseException(String str) {
        super(str);
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = false;
    }

    public ParseException(Throwable th) {
        super(th);
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = false;
    }

    public ParseException(Token token, int[][] iArr, String[] strArr) {
        super("");
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = true;
        this.currentToken = token;
        this.expectedTokenSequences = iArr;
        this.tokenImage = strArr;
    }

    protected String add_escapes(String str) {
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
        StringBuilder sb;
        String str;
        int[][] iArr;
        if (!this.specialConstructor) {
            return super.getMessage();
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int i2 = 0;
        while (true) {
            int[][] iArr2 = this.expectedTokenSequences;
            if (i >= iArr2.length) {
                break;
            }
            if (i2 < iArr2[i].length) {
                i2 = iArr2[i].length;
            }
            int i3 = 0;
            while (true) {
                iArr = this.expectedTokenSequences;
                if (i3 >= iArr[i].length) {
                    break;
                }
                stringBuffer.append(this.tokenImage[iArr[i][i3]]);
                stringBuffer.append(" ");
                i3++;
            }
            if (iArr[i][iArr[i].length - 1] != 0) {
                stringBuffer.append("...");
            }
            stringBuffer.append(this.eol);
            stringBuffer.append("    ");
            i++;
        }
        Token token = this.currentToken.next;
        String str2 = "Encountered \"";
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            if (i4 != 0) {
                str2 = str2 + " ";
            }
            if (token.kind == 0) {
                str2 = str2 + this.tokenImage[0];
                break;
            }
            str2 = str2 + add_escapes(token.image);
            token = token.next;
            i4++;
        }
        String str3 = (str2 + "\" at line " + this.currentToken.next.beginLine + ", column " + this.currentToken.next.beginColumn) + "." + this.eol;
        if (this.expectedTokenSequences.length == 1) {
            sb = new StringBuilder();
            sb.append(str3);
            str = "Was expecting:";
        } else {
            sb = new StringBuilder();
            sb.append(str3);
            str = "Was expecting one of:";
        }
        sb.append(str);
        sb.append(this.eol);
        sb.append("    ");
        return sb.toString() + stringBuffer.toString();
    }
}
