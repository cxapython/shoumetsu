package com.microsoft.appcenter.c;

import android.content.Context;
import com.microsoft.appcenter.b.d;
import com.microsoft.appcenter.b.j;
import com.microsoft.appcenter.b.k;
import com.microsoft.appcenter.b.l;
import com.microsoft.appcenter.c.a.a.g;
import com.microsoft.appcenter.c.a.e;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes.dex */
public class a implements b {
    private final g a;
    private final d b;
    private String c = "https://in.appcenter.ms";

    /* renamed from: com.microsoft.appcenter.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0061a extends com.microsoft.appcenter.b.a {
        private final g a;
        private final e b;

        C0061a(g gVar, e eVar) {
            this.a = gVar;
            this.b = eVar;
        }

        @Override // com.microsoft.appcenter.b.d.a
        public String a() {
            return this.a.a(this.b);
        }
    }

    public a(Context context, g gVar) {
        this.a = gVar;
        this.b = j.a(context);
    }

    @Override // com.microsoft.appcenter.c.b
    public k a(String str, String str2, UUID uuid, e eVar, l lVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("Install-ID", uuid.toString());
        hashMap.put("App-Secret", str2);
        if (str != null) {
            hashMap.put("Authorization", String.format("Bearer %s", str));
        }
        C0061a c0061a = new C0061a(this.a, eVar);
        d dVar = this.b;
        return dVar.a(this.c + "/logs?api-version=1.0.0", "POST", hashMap, c0061a, lVar);
    }

    @Override // com.microsoft.appcenter.c.b
    public void a() {
        this.b.a();
    }

    @Override // com.microsoft.appcenter.c.b
    public void a(String str) {
        this.c = str;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }
}
