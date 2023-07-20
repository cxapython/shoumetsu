package net.gree.gamelib.core.a.c;

import java.util.TreeMap;
import net.gree.gamelib.core.http.HttpRequest;

/* loaded from: classes.dex */
public class b extends d {
    private String c;

    public b(String str, String str2) {
        this.c = null;
        this.c = str;
        this.a = str2;
    }

    @Override // net.gree.gamelib.core.a.c.d
    public String a(String str) {
        return null;
    }

    @Override // net.gree.gamelib.core.a.c.d
    public void a(HttpRequest httpRequest) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(c.h, c.a(httpRequest.getEntity()));
        treeMap.put(c.i, this.c);
        treeMap.put(c.j, c.b());
        treeMap.put(c.k, c.a());
        treeMap.put(c.m, c.d);
        treeMap.put(c.n, "1.0");
        treeMap.put(c.l, c.a(httpRequest, this.a, treeMap));
        httpRequest.setHeader("Authorization", c.a(treeMap));
    }
}
