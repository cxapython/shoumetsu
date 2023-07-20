package net.gree.gamelib.core.http;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpRequest {
    private String a;
    private String b;
    private Map<String, String> c;
    private String d = null;

    public HttpRequest(String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = str;
        this.b = str2;
        this.c = new HashMap();
    }

    private void a(String str, String str2) {
        if (str != null) {
            if ("".equals(str)) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    throw new IllegalArgumentException("Unexpected char in header name: " + str);
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str2.charAt(i2);
                if (charAt2 <= 31 || charAt2 >= 127) {
                    throw new IllegalArgumentException("Unexpected char in value: " + str);
                }
            }
            return;
        }
        throw new NullPointerException("name == null");
    }

    public String getEntity() {
        return this.d;
    }

    public String getHeader(String str) {
        return this.c.get(str);
    }

    public Map<String, String> getHeaders() {
        return this.c;
    }

    public String getMethod() {
        return this.a;
    }

    public String getUrl() {
        return this.b;
    }

    public void setEntity(String str) {
        this.d = str;
    }

    public HttpRequest setHeader(String str, String str2) {
        a(str, str2);
        this.c.put(str, str2);
        return this;
    }
}
