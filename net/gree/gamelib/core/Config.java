package net.gree.gamelib.core;

import java.util.Map;

/* loaded from: classes.dex */
public class Config {
    private String a;
    private String b;
    private String c;
    private String d = null;
    private String e = null;
    private boolean f = false;
    private Map<String, String> g;

    public Config(String str, String str2, String str3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String getDomain() {
        return this.a;
    }

    public Map<String, String> getExtraHeader() {
        return this.g;
    }

    public String getId() {
        return this.b;
    }

    public String getScramble() {
        return this.d;
    }

    public String getSecret() {
        return this.c;
    }

    public String getServerBaseUrl() {
        return this.e;
    }

    public boolean getTestUserEnabled() {
        return this.f;
    }

    public Config setExtraHeader(Map<String, String> map) {
        this.g = map;
        return this;
    }

    public void setScramble(String str) {
        this.d = str;
    }

    public Config setServerBaseUrl(String str) {
        this.e = str;
        return this;
    }

    public Config setTestUserEnabled(boolean z) {
        this.f = z;
        return this;
    }
}
