package com.microsoft.appcenter.c.a.b;

import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class k {
    private static final Pattern a = Pattern.compile("^[a-zA-Z0-9]((\\.(?!(\\.|$)))|[_a-zA-Z0-9]){3,99}$");

    public static String a(String str) {
        return str.split("-")[0];
    }

    public static void a(c cVar, String str) {
        if (str != null) {
            if (a.matcher(str).matches()) {
                cVar.b(str);
                return;
            }
            throw new IllegalArgumentException("Name must match '" + a + "' but was '" + str + "'.");
        }
        throw new IllegalArgumentException("Name cannot be null.");
    }

    public static void a(com.microsoft.appcenter.c.a.d dVar, c cVar, String str) {
        com.microsoft.appcenter.c.a.c r = dVar.r();
        cVar.a("3.0");
        cVar.b(dVar.n());
        cVar.c("o:" + a(str));
        cVar.g(str);
        if (cVar.h() == null) {
            cVar.a(new f());
        }
        cVar.h().a(new l());
        cVar.h().b().b(r.c());
        cVar.h().b().a(r.d());
        cVar.h().a(new n());
        cVar.h().c().a(com.microsoft.appcenter.e.b.f.c(dVar.q()));
        cVar.h().c().b(r.i().replace("_", "-"));
        cVar.h().a(new j());
        cVar.h().e().a(r.e());
        j e = cVar.h().e();
        e.b(r.f() + "-" + r.g() + "-" + r.h());
        cVar.h().a(new a());
        cVar.h().f().c(r.l());
        a f = cVar.h().f();
        f.a("a:" + r.p());
        cVar.h().a(new i());
        cVar.h().g().a(r.m());
        cVar.h().a(new m());
        m h = cVar.h().h();
        h.a(r.a() + "-" + r.b());
        cVar.h().a(new g());
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        objArr[0] = r.j().intValue() >= 0 ? "+" : "-";
        objArr[1] = Integer.valueOf(Math.abs(r.j().intValue() / 60));
        objArr[2] = Integer.valueOf(Math.abs(r.j().intValue() % 60));
        cVar.h().i().a(String.format(locale, "%s%02d:%02d", objArr));
        cVar.h().a(new e());
    }
}
