package com.google.firebase.e;

import com.google.firebase.components.n;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class b implements g {
    private final String a;
    private final d b;

    b(Set<e> set, d dVar) {
        this.a = a(set);
        this.b = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ g a(com.google.firebase.components.e eVar) {
        return new b(eVar.b(e.class), d.b());
    }

    private static String a(Set<e> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<e> it = set.iterator();
        while (it.hasNext()) {
            e next = it.next();
            sb.append(next.a());
            sb.append('/');
            sb.append(next.b());
            if (it.hasNext()) {
                sb.append(TokenParser.SP);
            }
        }
        return sb.toString();
    }

    public static com.google.firebase.components.b<g> b() {
        return com.google.firebase.components.b.a(g.class).a(n.b(e.class)).a(c.a()).b();
    }

    @Override // com.google.firebase.e.g
    public String a() {
        if (this.b.a().isEmpty()) {
            return this.a;
        }
        return this.a + TokenParser.SP + a(this.b.a());
    }
}
