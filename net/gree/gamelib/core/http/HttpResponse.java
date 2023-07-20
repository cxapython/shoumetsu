package net.gree.gamelib.core.http;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpResponse {
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_OK = 200;
    private int a;
    private Map<String, String> b;
    private String c;

    public HttpResponse(int i, Map<String, String> map, String str) {
        this.a = 0;
        this.b = null;
        this.c = null;
        this.a = i;
        this.b = new HashMap();
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (str2 != null) {
                    this.b.put(str2, map.get(str2));
                }
            }
        }
        this.c = str;
    }

    public String getEntity() {
        return this.c;
    }

    public String getHeader(String str) {
        return this.b.get(str);
    }

    public Map<String, String> getHeaders() {
        return this.b;
    }

    public int getStatusCode() {
        return this.a;
    }
}
