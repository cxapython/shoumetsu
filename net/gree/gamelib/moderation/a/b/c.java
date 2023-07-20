package net.gree.gamelib.moderation.a.b;

import java.util.Map;
import net.gree.gamelib.core.http.RequestUrl;

/* loaded from: classes.dex */
public class c extends RequestUrl {
    public static final String a = "moderationVersion";
    private static final String b = "gl-payment";
    private static final String c = "bn-payment";
    private static final String d = "gree-apps.net";
    private static final String e = "wrightflyer.net";
    private static final String f = "BNE";
    private static final String g = "GLS";
    private static final String h = "/moderate/keywordlist";
    private static final String i = "/moderate/filtering/commit";
    private static final String j = "/moderate/restriction";

    public c(Map<String, String> map) {
        super(map);
    }

    public static boolean a(String str) {
        return f.equalsIgnoreCase(str) || g.equalsIgnoreCase(str);
    }

    public String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(this.mBaseUrl);
        sb.append('/');
        sb.append(str);
        sb.append(h);
        if (str2 != null) {
            sb.append("?timestamp=");
            sb.append(str2);
        }
        return sb.toString();
    }

    public String b(String str) {
        return this.mBaseUrl + '/' + str + i;
    }

    public String c(String str) {
        return this.mBaseUrl + '/' + str + j;
    }

    @Override // net.gree.gamelib.core.http.RequestUrl
    protected String getDomain(String str) {
        return a(str) ? c : b;
    }

    @Override // net.gree.gamelib.core.http.RequestUrl
    protected String getProductionUrlSuffix(String str) {
        return a(str) ? e : d;
    }
}
