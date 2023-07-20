package com.microsoft.appcenter.c;

import android.content.Context;
import com.microsoft.appcenter.b.d;
import com.microsoft.appcenter.b.j;
import com.microsoft.appcenter.b.k;
import com.microsoft.appcenter.b.l;
import com.microsoft.appcenter.c.a.a.g;
import com.microsoft.appcenter.c.a.e;
import com.microsoft.appcenter.e.h;
import com.microsoft.appcenter.f;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c implements b {
    private final g a;
    private final d b;
    private String c = "https://mobile.events.data.microsoft.com/OneCollector/1.0";

    /* loaded from: classes.dex */
    private static class a implements d.a {
        private final g a;
        private final e b;

        a(g gVar, e eVar) {
            this.a = gVar;
            this.b = eVar;
        }

        @Override // com.microsoft.appcenter.b.d.a
        public String a() {
            StringBuilder sb = new StringBuilder();
            for (com.microsoft.appcenter.c.a.d dVar : this.b.a()) {
                sb.append(this.a.a(dVar));
                sb.append('\n');
            }
            return sb.toString();
        }

        @Override // com.microsoft.appcenter.b.d.a
        public void a(URL url, Map<String, String> map) {
            if (com.microsoft.appcenter.e.a.a() <= 2) {
                com.microsoft.appcenter.e.a.a("AppCenter", "Calling " + url + "...");
                HashMap hashMap = new HashMap(map);
                String str = (String) hashMap.get("apikey");
                if (str != null) {
                    hashMap.put("apikey", j.b(str));
                }
                String str2 = (String) hashMap.get("Tickets");
                if (str2 != null) {
                    hashMap.put("Tickets", j.c(str2));
                }
                com.microsoft.appcenter.e.a.a("AppCenter", "Headers: " + hashMap);
            }
        }
    }

    public c(Context context, g gVar) {
        this.a = gVar;
        this.b = j.a(context);
    }

    @Override // com.microsoft.appcenter.c.b
    public k a(String str, String str2, UUID uuid, e eVar, l lVar) {
        HashMap hashMap = new HashMap();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        for (com.microsoft.appcenter.c.a.d dVar : eVar.a()) {
            linkedHashSet.addAll(dVar.t());
        }
        StringBuilder sb = new StringBuilder();
        for (String str3 : linkedHashSet) {
            sb.append(str3);
            sb.append(",");
        }
        if (!linkedHashSet.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        hashMap.put("apikey", sb.toString());
        JSONObject jSONObject = new JSONObject();
        Iterator<com.microsoft.appcenter.c.a.d> it = eVar.a().iterator();
        while (it.hasNext()) {
            List<String> a2 = ((com.microsoft.appcenter.c.a.b.c) it.next()).h().b().a();
            if (a2 != null) {
                for (String str4 : a2) {
                    String a3 = h.a(str4);
                    if (a3 != null) {
                        try {
                            jSONObject.put(str4, a3);
                        } catch (JSONException e) {
                            com.microsoft.appcenter.e.a.b("AppCenter", "Cannot serialize tickets, sending log anonymously", e);
                        }
                    }
                }
            }
        }
        if (jSONObject.length() > 0) {
            hashMap.put("Tickets", jSONObject.toString());
            if (f.b) {
                hashMap.put("Strict", Boolean.TRUE.toString());
            }
        }
        hashMap.put("Content-Type", "application/x-json-stream; charset=utf-8");
        hashMap.put("Client-Version", String.format("ACS-Android-Java-no-%s-no", "2.4.0"));
        hashMap.put("Upload-Time", String.valueOf(System.currentTimeMillis()));
        return this.b.a(this.c, "POST", hashMap, new a(this.a, eVar), lVar);
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
