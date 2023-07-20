package net.gree.gamelib.core.a;

import java.util.Map;

/* loaded from: classes.dex */
public class i {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e = false;
    private boolean f;
    private String g;
    private String h;
    private Map<String, String> i;

    public i(String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = false;
        this.g = null;
        this.h = null;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f = z;
        this.g = str5;
        this.h = str6;
    }

    public String a() {
        return this.a;
    }

    public i a(Map<String, String> map) {
        this.i = map;
        return this;
    }

    public i a(boolean z) {
        this.e = z;
        return this;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public boolean e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public boolean h() {
        return this.e;
    }

    public Map<String, String> i() {
        return this.i;
    }
}
