package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzox {
    private final List<zzot> a;
    private final List<zzot> b;
    private final List<zzot> c;
    private final List<zzot> d;
    private final List<zzot> e;
    private final List<zzot> f;
    private final List<String> g;
    private final List<String> h;
    private final List<String> i;
    private final List<String> j;

    private zzox(List<zzot> list, List<zzot> list2, List<zzot> list3, List<zzot> list4, List<zzot> list5, List<zzot> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
        this.a = Collections.unmodifiableList(list);
        this.b = Collections.unmodifiableList(list2);
        this.c = Collections.unmodifiableList(list3);
        this.d = Collections.unmodifiableList(list4);
        this.e = Collections.unmodifiableList(list5);
        this.f = Collections.unmodifiableList(list6);
        this.g = Collections.unmodifiableList(list7);
        this.h = Collections.unmodifiableList(list8);
        this.i = Collections.unmodifiableList(list9);
        this.j = Collections.unmodifiableList(list10);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String valueOf2 = String.valueOf(this.b);
        String valueOf3 = String.valueOf(this.c);
        String valueOf4 = String.valueOf(this.d);
        String valueOf5 = String.valueOf(this.e);
        String valueOf6 = String.valueOf(this.f);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 102 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length());
        sb.append("Positive predicates: ");
        sb.append(valueOf);
        sb.append("  Negative predicates: ");
        sb.append(valueOf2);
        sb.append("  Add tags: ");
        sb.append(valueOf3);
        sb.append("  Remove tags: ");
        sb.append(valueOf4);
        sb.append("  Add macros: ");
        sb.append(valueOf5);
        sb.append("  Remove macros: ");
        sb.append(valueOf6);
        return sb.toString();
    }

    public final List<zzot> zzlw() {
        return this.a;
    }

    public final List<zzot> zzlx() {
        return this.b;
    }

    public final List<zzot> zzly() {
        return this.c;
    }

    public final List<zzot> zzlz() {
        return this.d;
    }

    public final List<zzot> zzmq() {
        return this.e;
    }

    public final List<zzot> zzmr() {
        return this.f;
    }
}
