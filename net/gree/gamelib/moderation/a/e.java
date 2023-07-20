package net.gree.gamelib.moderation.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.http.SignedRequest;
import net.gree.gamelib.moderation.KeywordFilter;
import net.gree.gamelib.moderation.KeywordFilterListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {
    protected static final int a = 180000;
    protected static final int b = 86400;
    protected static final String c = "v1.0";
    private static final String h = "e";
    protected KeywordFilter d;
    protected net.gree.gamelib.moderation.a.a.b e;
    protected AtomicBoolean f = new AtomicBoolean();
    protected ScheduledExecutorService g = Executors.newScheduledThreadPool(1);

    public e(KeywordFilter keywordFilter) {
        this.d = keywordFilter;
        this.e = new net.gree.gamelib.moderation.a.a.b(this.d.getContext());
    }

    protected int a() {
        return a;
    }

    protected JSONArray a(JSONArray jSONArray, long j) {
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (j <= net.gree.gamelib.moderation.a.a.a.a(jSONObject)) {
                jSONArray2.put(jSONObject);
            } else {
                jSONArray3.put(jSONObject);
            }
        }
        if (jSONArray3.length() > 0) {
            b(jSONArray3);
        }
        return jSONArray2;
    }

    public void a(final net.gree.gamelib.moderation.a.a.a aVar) {
        if (aVar != null) {
            Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.moderation.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.b(aVar);
                }
            });
            b();
        }
    }

    protected void a(final JSONArray jSONArray) {
        KeywordFilter keywordFilter = this.d;
        if (keywordFilter != null) {
            SignedRequest signedRequest = keywordFilter.getSignedRequest();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONArray = a(jSONArray, net.gree.gamelib.moderation.a.a.a.b() - 86400);
                jSONObject.put("results", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            signedRequest.setEntity(jSONObject.toString());
            signedRequest.request("POST", new net.gree.gamelib.moderation.a.b.c(this.d.getParams()).b(c), new net.gree.gamelib.moderation.a.b.b<net.gree.gamelib.moderation.a.b.a>(h, new KeywordFilterListener<net.gree.gamelib.moderation.a.b.a>() { // from class: net.gree.gamelib.moderation.a.e.3
                @Override // net.gree.gamelib.core.CallbackListener
                /* renamed from: a */
                public void onSuccess(net.gree.gamelib.moderation.a.b.a aVar) {
                    e.this.c();
                    Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.moderation.a.e.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.e.b(jSONArray);
                            if (e.this.e.a().length() > 0) {
                                e.this.b();
                            }
                        }
                    });
                }

                @Override // net.gree.gamelib.core.CallbackListener
                public void onError(int i, String str) {
                    e.this.b();
                }
            }) { // from class: net.gree.gamelib.moderation.a.e.4
                @Override // net.gree.gamelib.moderation.a.b.b
                protected net.gree.gamelib.moderation.a.b.a b(String str) {
                    return null;
                }
            });
        }
    }

    protected void b() {
        if (!this.f.getAndSet(true)) {
            this.g.schedule(new Runnable() { // from class: net.gree.gamelib.moderation.a.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.c();
                    e.this.f();
                }
            }, a(), TimeUnit.MILLISECONDS);
        }
    }

    protected void b(net.gree.gamelib.moderation.a.a.a aVar) {
        this.e.a(aVar);
    }

    void b(JSONArray jSONArray) {
        this.e.b(jSONArray);
    }

    protected void c() {
        this.f.set(false);
    }

    AtomicBoolean d() {
        return this.f;
    }

    net.gree.gamelib.moderation.a.a.b e() {
        return this.e;
    }

    public void f() {
        net.gree.gamelib.moderation.a.a.b bVar = this.e;
        if (bVar != null) {
            JSONArray a2 = bVar.a();
            if (a2.length() > 0) {
                a(a2);
            } else {
                c();
            }
        }
    }
}
