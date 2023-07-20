package com.microsoft.appcenter.analytics;

import android.provider.Settings;
import com.microsoft.appcenter.c.a.b.e;
import com.microsoft.appcenter.c.a.b.n;

/* loaded from: classes.dex */
public class d extends com.microsoft.appcenter.a.a {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private final a f;
    private final c g = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f = aVar;
    }

    private String a() {
        return this.a;
    }

    private String b() {
        return this.b;
    }

    private boolean b(com.microsoft.appcenter.c.a.d dVar) {
        if (dVar instanceof com.microsoft.appcenter.c.a.b.c) {
            Object s = dVar.s();
            a aVar = this.f;
            if (s == aVar && aVar.b()) {
                return true;
            }
        }
        return false;
    }

    private String c() {
        return this.c;
    }

    private String d() {
        return this.d;
    }

    @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
    public void a(com.microsoft.appcenter.c.a.d dVar, String str) {
        if (b(dVar)) {
            com.microsoft.appcenter.c.a.b.c cVar = (com.microsoft.appcenter.c.a.b.c) dVar;
            com.microsoft.appcenter.c.a.b.a f = cVar.h().f();
            n c = cVar.h().c();
            e d = cVar.h().d();
            String str2 = this.a;
            if (str2 == null) {
                a aVar = this.f;
                while (true) {
                    aVar = aVar.b;
                    if (aVar != null) {
                        String a = aVar.c().a();
                        if (a != null) {
                            f.b(a);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                f.b(str2);
            }
            String str3 = this.b;
            if (str3 == null) {
                a aVar2 = this.f;
                while (true) {
                    aVar2 = aVar2.b;
                    if (aVar2 != null) {
                        String b = aVar2.c().b();
                        if (b != null) {
                            f.c(b);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                f.c(str3);
            }
            String str4 = this.c;
            if (str4 == null) {
                a aVar3 = this.f;
                while (true) {
                    aVar3 = aVar3.b;
                    if (aVar3 != null) {
                        String c2 = aVar3.c().c();
                        if (c2 != null) {
                            f.d(c2);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                f.d(str4);
            }
            String str5 = this.d;
            if (str5 == null) {
                a aVar4 = this.f;
                while (true) {
                    aVar4 = aVar4.b;
                    if (aVar4 != null) {
                        String d2 = aVar4.c().d();
                        if (d2 != null) {
                            c.a(d2);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                c.a(str5);
            }
            if (!this.e) {
                return;
            }
            String string = Settings.Secure.getString(this.f.c.getContentResolver(), "android_id");
            d.a("a:" + string);
        }
    }
}
