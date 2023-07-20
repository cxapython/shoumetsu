package com.microsoft.appcenter.b;

import android.text.TextUtils;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class i extends IOException {
    private final int a;
    private final String b;
    private final Map<String, String> c;

    public i(int i, String str, Map<String, String> map) {
        super(a(i, str));
        this.b = str;
        this.a = i;
        this.c = map;
    }

    private static String a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return String.valueOf(i);
        }
        return i + " - " + str;
    }

    public int a() {
        return this.a;
    }

    public Map<String, String> b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && this.b.equals(iVar.b) && this.c.equals(iVar.c);
    }

    public int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
