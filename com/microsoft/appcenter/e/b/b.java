package com.microsoft.appcenter.e.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class b {
    @SuppressLint({"StaticFieldLeak"})
    private static b a;
    private Context c;
    private List<c> d;
    private final Set<a> b = Collections.newSetFromMap(new ConcurrentHashMap());
    private boolean e = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str);

        void b(String str);

        void c(String str);
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            b a2 = a();
            a2.c = context.getApplicationContext();
            a2.d();
        }
    }

    private synchronized Boolean b(String str, String str2, Date date) {
        List<c> d = d();
        if (d == null) {
            d = new ArrayList<>();
        }
        boolean z = true;
        c cVar = d.size() > 0 ? d.get(d.size() - 1) : null;
        if (cVar == null || !TextUtils.equals(cVar.a(), str)) {
            if (cVar != null && TextUtils.equals(cVar.b(), str2)) {
                z = false;
            }
            Date date2 = new Date();
            if (cVar != null && cVar.d() != null && date2.after(cVar.d())) {
                if (z && str != null) {
                    d.add(new c(null, null, cVar.d(), date2));
                }
                date2 = cVar.d();
            }
            d.add(new c(str, str2, date2, date));
            if (d.size() > 5) {
                d.subList(0, d.size() - 5).clear();
                com.microsoft.appcenter.e.a.b("AppCenter", "Size of the token history is exceeded. The oldest token has been removed.");
            }
            a(d);
            return Boolean.valueOf(z);
        }
        return null;
    }

    private String b(List<c> list) {
        JSONStringer jSONStringer = new JSONStringer();
        jSONStringer.array();
        for (c cVar : list) {
            jSONStringer.object();
            cVar.a(jSONStringer);
            jSONStringer.endObject();
        }
        jSONStringer.endArray();
        return jSONStringer.toString();
    }

    private List<c> b(String str) {
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            c cVar = new c();
            cVar.a(jSONObject);
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private synchronized c e() {
        List<c> d = d();
        if (d == null || d.size() <= 0) {
            return null;
        }
        return d.get(d.size() - 1);
    }

    public void a(a aVar) {
        this.b.add(aVar);
    }

    public void a(d dVar) {
        c e = e();
        if (e == null || dVar.b() == null || !dVar.b().equals(e.a()) || !dVar.a()) {
            return;
        }
        for (a aVar : this.b) {
            aVar.c(e.b());
        }
    }

    public synchronized void a(String str) {
        List<c> d = d();
        if (d != null && d.size() != 0) {
            if (d.size() == 1) {
                com.microsoft.appcenter.e.a.b("AppCenter", "Couldn't remove token from history: token history contains only current one.");
                return;
            } else if (!TextUtils.equals(d.get(0).a(), str)) {
                com.microsoft.appcenter.e.a.b("AppCenter", "Couldn't remove token from history: the token isn't oldest or is already removed.");
                return;
            } else {
                d.remove(0);
                a(d);
                com.microsoft.appcenter.e.a.b("AppCenter", "The token has been removed from token history.");
                return;
            }
        }
        com.microsoft.appcenter.e.a.d("AppCenter", "Couldn't remove token from history: token history is empty.");
    }

    public void a(String str, String str2, Date date) {
        if (str == null) {
            str2 = null;
            date = null;
        }
        Boolean b = b(str, str2, date);
        if (b == null) {
            return;
        }
        for (a aVar : this.b) {
            aVar.a(str);
            if (b.booleanValue()) {
                aVar.b(str2 == null ? null : str2.substring(0, Math.min(36, str2.length())));
            }
        }
    }

    void a(List<c> list) {
        this.d = list;
        if (list == null) {
            com.microsoft.appcenter.e.d.d.c("AppCenter.auth_token_history");
            return;
        }
        try {
            com.microsoft.appcenter.e.d.d.b("AppCenter.auth_token_history", com.microsoft.appcenter.e.c.e.a(this.c).a(b(list)));
        } catch (JSONException e) {
            com.microsoft.appcenter.e.a.a("AppCenter", "Failed to serialize auth token history.", e);
        }
    }

    public synchronized void b() {
        if (!this.e) {
            return;
        }
        this.e = false;
        a(null, null, null);
    }

    public void b(a aVar) {
        this.b.remove(aVar);
    }

    public synchronized List<d> c() {
        List<c> d = d();
        if (d != null && d.size() != 0) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            if (d.get(0).a() != null) {
                arrayList.add(new d(null, null, d.get(0).c()));
            }
            while (i < d.size()) {
                c cVar = d.get(i);
                String a2 = cVar.a();
                Date c = cVar.c();
                if (a2 == null && i == 0) {
                    c = null;
                }
                Date d2 = cVar.d();
                i++;
                Date c2 = d.size() > i ? d.get(i).c() : null;
                if (c2 != null) {
                    if (d2 != null && c2.before(d2)) {
                        d2 = c2;
                        arrayList.add(new d(a2, c, d2));
                    }
                }
                if (d2 == null) {
                    if (c2 == null) {
                    }
                    d2 = c2;
                }
                arrayList.add(new d(a2, c, d2));
            }
            return arrayList;
        }
        return Collections.singletonList(new d());
    }

    List<c> d() {
        List<c> list = this.d;
        if (list != null) {
            return list;
        }
        String a2 = com.microsoft.appcenter.e.d.d.a("AppCenter.auth_token_history", (String) null);
        String a3 = (a2 == null || a2.isEmpty()) ? null : com.microsoft.appcenter.e.c.e.a(this.c).a(a2, false).a();
        if (a3 == null || a3.isEmpty()) {
            return null;
        }
        try {
            this.d = b(a3);
        } catch (JSONException e) {
            com.microsoft.appcenter.e.a.a("AppCenter", "Failed to deserialize auth token history.", e);
        }
        return this.d;
    }
}
