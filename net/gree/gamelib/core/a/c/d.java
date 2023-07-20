package net.gree.gamelib.core.a.c;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.gree.gamelib.core.http.HttpRequest;
import net.gree.gamelib.core.http.HttpResponse;

/* loaded from: classes.dex */
public abstract class d {
    protected String a = null;
    protected Pattern b = null;

    private Map<String, String> b(String str) {
        TreeMap treeMap = new TreeMap();
        if (this.b == null) {
            this.b = Pattern.compile("([-_a-z]*)=\"([^\"]*)\"");
        }
        Matcher matcher = this.b.matcher(str);
        while (matcher.find()) {
            treeMap.put(matcher.group(1), matcher.group(2));
        }
        return treeMap;
    }

    public abstract String a(String str);

    public abstract void a(HttpRequest httpRequest);

    public boolean a(HttpRequest httpRequest, HttpResponse httpResponse) {
        String header;
        TreeMap treeMap = new TreeMap();
        if (net.gree.gamelib.core.a.b.a.q(httpRequest.getMethod()) && (header = httpResponse.getHeader(c.b)) != null) {
            String[] split = header.split(" ");
            if (!"OAuth".equalsIgnoreCase(split[0]) || split.length != 2) {
                return false;
            }
            Map<String, String> b = b(split[1]);
            String str = null;
            for (String str2 : b.keySet()) {
                String d = c.d(b.get(str2));
                if (c.l.equals(str2)) {
                    str = d;
                } else {
                    treeMap.put(str2, d);
                }
            }
            String a = c.a(httpRequest, this.a, treeMap);
            if (str != null) {
                return str.equals(a);
            }
            return false;
        }
        return false;
    }
}
