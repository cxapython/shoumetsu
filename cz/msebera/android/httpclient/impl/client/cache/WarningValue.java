package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
class WarningValue {
    private static final String ASCTIME_DATE = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}";
    private static final String DATE1 = "\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}";
    private static final String DATE2 = "\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}";
    private static final String DATE3 = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d";
    private static final String DOMAINLABEL = "\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?";
    private static final String HOST = "((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+)";
    private static final String HOSTNAME = "(\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?";
    private static final String HTTP_DATE = "((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4})";
    private static final String IPV4ADDRESS = "\\d+\\.\\d+\\.\\d+\\.\\d+";
    private static final String MONTH = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec";
    private static final String PORT = "\\d*";
    private static final String RFC1123_DATE = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT";
    private static final String RFC850_DATE = "(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT";
    private static final String TIME = "\\d{2}:\\d{2}:\\d{2}";
    private static final String TOPLABEL = "\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?";
    private static final String WEEKDAY = "Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday";
    private static final String WKDAY = "Mon|Tue|Wed|Thu|Fri|Sat|Sun";
    private int init_offs;
    private int offs;
    private final String src;
    private String warnAgent;
    private int warnCode;
    private Date warnDate;
    private String warnText;
    private static final String HOSTPORT = "(((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+))(\\:\\d*)?";
    private static final Pattern HOSTPORT_PATTERN = Pattern.compile(HOSTPORT);
    private static final String WARN_DATE = "\"(((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}))\"";
    private static final Pattern WARN_DATE_PATTERN = Pattern.compile(WARN_DATE);

    WarningValue(String str) {
        this(str, 0);
    }

    WarningValue(String str, int i) {
        this.init_offs = i;
        this.offs = i;
        this.src = str;
        consumeWarnValue();
    }

    public static WarningValue[] getWarningValues(Header header) {
        ArrayList arrayList = new ArrayList();
        String value = header.getValue();
        int i = 0;
        while (i < value.length()) {
            try {
                WarningValue warningValue = new WarningValue(value, i);
                arrayList.add(warningValue);
                i = warningValue.offs;
            } catch (IllegalArgumentException unused) {
                int indexOf = value.indexOf(44, i);
                if (indexOf == -1) {
                    break;
                }
                i = indexOf + 1;
            }
        }
        return (WarningValue[]) arrayList.toArray(new WarningValue[0]);
    }

    private boolean isChar(char c) {
        return c >= 0 && c <= 127;
    }

    private boolean isControl(char c) {
        return c == 127 || (c >= 0 && c <= 31);
    }

    private boolean isSeparator(char c) {
        return c == '(' || c == ')' || c == '<' || c == '>' || c == '@' || c == ',' || c == ';' || c == ':' || c == '\\' || c == '\"' || c == '/' || c == '[' || c == ']' || c == '?' || c == '=' || c == '{' || c == '}' || c == ' ' || c == '\t';
    }

    private boolean isTokenChar(char c) {
        return isChar(c) && !isControl(c) && !isSeparator(c);
    }

    private void parseError() {
        String substring = this.src.substring(this.init_offs);
        throw new IllegalArgumentException("Bad warn code \"" + substring + "\"");
    }

    protected void consumeCharacter(char c) {
        if (this.offs + 1 > this.src.length() || c != this.src.charAt(this.offs)) {
            parseError();
        }
        this.offs++;
    }

    protected void consumeHostPort() {
        Matcher matcher = HOSTPORT_PATTERN.matcher(this.src.substring(this.offs));
        if (!matcher.find()) {
            parseError();
        }
        if (matcher.start() != 0) {
            parseError();
        }
        this.offs += matcher.end();
    }

    protected void consumeLinearWhitespace() {
        while (this.offs < this.src.length()) {
            char charAt = this.src.charAt(this.offs);
            if (charAt != '\t') {
                if (charAt != '\r') {
                    if (charAt != ' ') {
                        return;
                    }
                } else if (this.offs + 2 >= this.src.length() || this.src.charAt(this.offs + 1) != '\n') {
                    return;
                } else {
                    if (this.src.charAt(this.offs + 2) != ' ' && this.src.charAt(this.offs + 2) != '\t') {
                        return;
                    }
                    this.offs += 2;
                }
            }
            this.offs++;
        }
    }

    protected void consumeQuotedString() {
        int i;
        if (this.src.charAt(this.offs) != '\"') {
            parseError();
        }
        this.offs++;
        boolean z = false;
        while (this.offs < this.src.length() && !z) {
            char charAt = this.src.charAt(this.offs);
            if (this.offs + 1 < this.src.length() && charAt == '\\' && isChar(this.src.charAt(this.offs + 1))) {
                i = this.offs + 2;
            } else if (charAt == '\"') {
                this.offs++;
                z = true;
            } else if (charAt == '\"' || isControl(charAt)) {
                parseError();
            } else {
                i = this.offs + 1;
            }
            this.offs = i;
        }
        if (!z) {
            parseError();
        }
    }

    protected void consumeToken() {
        if (!isTokenChar(this.src.charAt(this.offs))) {
            parseError();
        }
        while (this.offs < this.src.length() && isTokenChar(this.src.charAt(this.offs))) {
            this.offs++;
        }
    }

    protected void consumeWarnAgent() {
        int i = this.offs;
        try {
            consumeHostPort();
            this.warnAgent = this.src.substring(i, this.offs);
            consumeCharacter(TokenParser.SP);
        } catch (IllegalArgumentException unused) {
            this.offs = i;
            consumeToken();
            this.warnAgent = this.src.substring(i, this.offs);
            consumeCharacter(TokenParser.SP);
        }
    }

    protected void consumeWarnCode() {
        if (this.offs + 4 > this.src.length() || !Character.isDigit(this.src.charAt(this.offs)) || !Character.isDigit(this.src.charAt(this.offs + 1)) || !Character.isDigit(this.src.charAt(this.offs + 2)) || this.src.charAt(this.offs + 3) != ' ') {
            parseError();
        }
        String str = this.src;
        int i = this.offs;
        this.warnCode = Integer.parseInt(str.substring(i, i + 3));
        this.offs += 4;
    }

    protected void consumeWarnDate() {
        int i = this.offs;
        Matcher matcher = WARN_DATE_PATTERN.matcher(this.src.substring(i));
        if (!matcher.lookingAt()) {
            parseError();
        }
        this.offs += matcher.end();
        this.warnDate = DateUtils.parseDate(this.src.substring(i + 1, this.offs - 1));
    }

    protected void consumeWarnText() {
        int i = this.offs;
        consumeQuotedString();
        this.warnText = this.src.substring(i, this.offs);
    }

    protected void consumeWarnValue() {
        consumeLinearWhitespace();
        consumeWarnCode();
        consumeWarnAgent();
        consumeWarnText();
        if (this.offs + 1 < this.src.length() && this.src.charAt(this.offs) == ' ' && this.src.charAt(this.offs + 1) == '\"') {
            consumeCharacter(TokenParser.SP);
            consumeWarnDate();
        }
        consumeLinearWhitespace();
        if (this.offs != this.src.length()) {
            consumeCharacter(',');
        }
    }

    public String getWarnAgent() {
        return this.warnAgent;
    }

    public int getWarnCode() {
        return this.warnCode;
    }

    public Date getWarnDate() {
        return this.warnDate;
    }

    public String getWarnText() {
        return this.warnText;
    }

    public String toString() {
        return this.warnDate != null ? String.format("%d %s %s \"%s\"", Integer.valueOf(this.warnCode), this.warnAgent, this.warnText, DateUtils.formatDate(this.warnDate)) : String.format("%d %s %s", Integer.valueOf(this.warnCode), this.warnAgent, this.warnText);
    }
}
