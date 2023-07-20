package net.gree.gamelib.core.a.c;

import java.util.TreeMap;
import net.gree.gamelib.core.http.HttpRequest;

/* loaded from: classes.dex */
public class a extends d {
    private String c;
    private String d;
    private String e;

    public a(String str, String str2, String str3, String str4) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = str;
        this.d = str3;
        this.e = str4;
        this.a = str2;
    }

    @Override // net.gree.gamelib.core.a.c.d
    public String a(String str) {
        return c.c(str, this.d);
    }

    @Override // net.gree.gamelib.core.a.c.d
    public void a(HttpRequest httpRequest) {
        TreeMap treeMap = new TreeMap();
        String entity = httpRequest.getEntity();
        String a = c.a();
        treeMap.put(c.h, c.a(entity));
        treeMap.put(c.i, this.c);
        treeMap.put(c.j, c.b());
        treeMap.put(c.k, a);
        treeMap.put(c.m, c.f);
        treeMap.put(c.n, "1.0");
        treeMap.put(c.p, c.a(this.a, a, this.d));
        treeMap.put(c.o, this.e);
        treeMap.put(c.l, c.b(httpRequest, this.d, treeMap));
        httpRequest.setHeader("Authorization", c.a(treeMap));
    }
}
